package sixth.sixthgroup.dao;

import sixth.sixthgroup.model.OperationLog;

public interface OperationLogMapper {
    int deleteByPrimaryKey(Integer oploId);

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    OperationLog selectByPrimaryKey(Integer oploId);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKey(OperationLog record);
}