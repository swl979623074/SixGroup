package sixth.sixthgroup.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import sixth.sixthgroup.model.SpecialInfo;
import sixth.sixthgroup.service.SpecialInfoService;

@Controller
@RequestMapping("/specialInfoController")
public class SpecialInfoController {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	private SpecialInfoService specialInfoService;

	public SpecialInfoService getSpecialInfoService() {
		return specialInfoService;
	}
	@Autowired
	public void setSpecialInfoService(SpecialInfoService specialInfoService) {
		this.specialInfoService = specialInfoService;
	}
	/**
	 * 查找某一类型的特殊信息
	 * @param typeId 特殊信息id
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectByTypeId")
	public ModelAndView selectByTypeId(int typeId,int pageNum,int pageSize, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			List<SpecialInfo> list =new ArrayList();
			list=this.specialInfoService.selectByInfoType(typeId);
			
			int maxNum = list.size();
			int maxPage = maxNum/pageSize;
			if(maxNum%pageSize !=0){
				maxPage+=1;
			}
			int beginNum = (pageNum-1) * pageSize;
			int endNum=beginNum+pageSize;
			if(endNum>maxNum){
				endNum=maxNum;
			}
			
			List<SpecialInfo> infoList = new ArrayList();
			
			for(int i=beginNum;i<endNum;i++){
				SpecialInfo test = new SpecialInfo();
				test=list.get(i);
				test.setTime(DATE_FORMAT.format(test.getSpinTime()));
				infoList.add(test);
			}
			if(infoList.size()>0){
				map.put("result", Boolean.TRUE);
				map.put("infoList",infoList );
				map.put("maxPage",maxPage );
				
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
	 * 添加一条特殊信息
	 * @param studentId 学生id
	 * @param typeId 特殊信息类型id
	 * @param times 时间
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/insertOneInfo")
	public ModelAndView insertOneInfo(int studentId,int typeId,String times, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			java.util.Date date=DATE_FORMAT.parse(times);  
			
			SpecialInfo specialInfo=new SpecialInfo();
			specialInfo.setSpinStudentid(studentId);
			specialInfo.setSpinClassno(typeId);
			specialInfo.setSpinTime(date);
		
			int key=0;
			key=this.specialInfoService.insertOneInfo(specialInfo);
			
			if(key==1){
				map.put("result", Boolean.TRUE);
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
}
