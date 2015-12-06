package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.Student;

public interface StudentService {
	/**
	 * 获取所有学生
	 * @return studentList
	 */
	public  List<Student> getAll();
	/**
	 * 根据学号获取一个学生
	 * @param studNum 学号
	 * @return student
	 */
	public Student getOneStudent(String studNum);
	/**
	 * 添加一个学生
	 * @param student 被添加的学生的详细信息
	 * @return
	 */
	public int addOneStudent(Student student);
}
