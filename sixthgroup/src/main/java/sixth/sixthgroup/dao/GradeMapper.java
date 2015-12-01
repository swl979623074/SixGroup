package sixth.sixthgroup.dao;

import sixth.sixthgroup.model.Grade;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer gradId);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer gradId);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}