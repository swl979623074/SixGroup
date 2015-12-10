package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.OperationLog;

public interface OperationLogService {
	/**
	 * 查找所有的操作记录
	 * @return
	 */
	List<OperationLog> selectAll();
	/**
	 * 通过用户的id查找对应的操作记录
	 * @param oploPeopleid 用户id
	 * @return
	 */
	List<OperationLog> selectByPeopleId(int oploPeopleid);
}
