package sixth.sixthgroup.dao;

import sixth.sixthgroup.model.Academy;

public interface AcademyMapper {
    int deleteByPrimaryKey(Integer acadId);

    int insert(Academy record);

    int insertSelective(Academy record);

    Academy selectByPrimaryKey(Integer acadId);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);
}