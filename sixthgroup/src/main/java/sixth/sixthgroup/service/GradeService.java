package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.Grade;

public interface GradeService {
	/**
	 * 添加一个班级
	 * @param grade 被添加的班级信息
	 * @return
	 */
	public int addOneClass(Grade grade);
	
	/**
	 * 通过班级名称查找班级
	 * @param gradName 班级名称
	 * @return
	 */
	public Grade selectByClassName(String gradName);
	/**
	 * 获取所有班级
	 * @return
	 */
	public List<Grade> selectAll();
}
