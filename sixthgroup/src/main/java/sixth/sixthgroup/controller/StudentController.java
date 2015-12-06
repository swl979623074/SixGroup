package sixth.sixthgroup.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import sixth.sixthgroup.model.Student;
import sixth.sixthgroup.service.StudentService;

@Controller
@RequestMapping("/studentController")
public class StudentController {
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	/**
	 * 获取所有学生
	 * @return studentList
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectAll")
	public ModelAndView selectAll(HttpServletRequest request,HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			List<Student> list=this.studentService.getAll();
			if(list.size()>0){
				map.put("result", Boolean.TRUE);
				map.put("studentList", list);
			}else{
				map.put("result", Boolean.FALSE);
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		}finally{
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
	
	/**
	 * 根据学号获取一个学生
	 * @param studNum 学号
	 * @return student
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectStudByStudNum")
	public ModelAndView selectStudByStudNum(String studNum, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			Student student=new Student();
			student=this.studentService.getOneStudent(studNum);
			if(student!=null){
				map.put("result", Boolean.TRUE);
				map.put("student",student );
			}else{
				map.put("result", Boolean.FALSE);
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		}finally{
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
	
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/insertOneStudent")
	public ModelAndView insertOneStudent(int studGradeid,String studName,String studSex,
			String studAge,String studTel,String studQq,
			String studAddress,String studIdcard,String studNum,
			String studBron,String studBanknum,String studNation,
			String studDorimitory,HttpServletRequest request,HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String dstr=studBron; 
			java.util.Date date=sdf.parse(dstr);  
			
			Student student=new Student();
			student.setStudAddress(studAddress);
			student.setStudAge(studAge);
			student.setStudBanknum(studBanknum);
			student.setStudBron(date);
			student.setStudDorimitory(studDorimitory);
			student.setStudGradeid(studGradeid);
			student.setStudIdcard(studIdcard);
			student.setStudName(studName);
			student.setStudNation(studNation);
			student.setStudNum(studNum);
			student.setStudQq(studQq);
			student.setStudSex(studSex);
			student.setStudTel(studTel);
			
			int key=0;
			key=this.studentService.addOneStudent(student);
			if(key!=0){
				map.put("result", Boolean.TRUE);
				map.put("student", student);
			}else{
				map.put("result", Boolean.FALSE);
				map.put("message", "此学号已经存在");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		}finally{
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
}
