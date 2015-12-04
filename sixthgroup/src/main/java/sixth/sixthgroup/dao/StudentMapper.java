package sixth.sixthgroup.dao;

import sixth.sixthgroup.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}