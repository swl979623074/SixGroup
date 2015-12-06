package sixth.sixthgroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixth.sixthgroup.dao.StudentMapper;
import sixth.sixthgroup.model.Student;
import sixth.sixthgroup.service.StudentService;

@Service("sudentService")
public class StudentServiceImpl implements StudentService {
	private StudentMapper studentMapper;
	
	public StudentMapper getStudentMapper() {
		return studentMapper;
	}
	@Autowired
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	
	/**
	 * 获取所有学生
	 */
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> list=this.studentMapper.selectAll();
		return list;
	}
	public Student getOneStudent(String studNum) {
		// TODO Auto-generated method stub
		Student student=new Student();
		student=this.studentMapper.selectByStudNum(studNum);
		return student;
	}
	public int addOneStudent(Student student) {
		// TODO Auto-generated method stub
		int key=0;
		Student reStudent = new Student();
		reStudent= this.studentMapper.selectByStudNum(student.getStudNum());
		if(reStudent == null){
			key=this.studentMapper.insert(student);
		}	
		return key;
	}
}
