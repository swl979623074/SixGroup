package sixth.sixthgroup.dao;

import sixth.sixthgroup.model.HistoryStudent;

public interface HistoryStudentMapper {
    int deleteByPrimaryKey(Integer histId);

    int insert(HistoryStudent record);

    int insertSelective(HistoryStudent record);

    HistoryStudent selectByPrimaryKey(Integer histId);

    int updateByPrimaryKeySelective(HistoryStudent record);

    int updateByPrimaryKey(HistoryStudent record);
}