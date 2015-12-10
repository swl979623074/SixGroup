package sixth.sixthgroup.dao;

import java.util.List;

import sixth.sixthgroup.model.SpecialInfo;

public interface SpecialInfoMapper {
    int deleteByPrimaryKey(Integer spinId);

    int insert(SpecialInfo record);

    int insertSelective(SpecialInfo record);

    SpecialInfo selectByPrimaryKey(Integer spinId);

    int updateByPrimaryKeySelective(SpecialInfo record);

    int updateByPrimaryKey(SpecialInfo record);
    
    /** 自己写的方法**/
    List<SpecialInfo> selectByInfoType(Integer spinClassno);
}