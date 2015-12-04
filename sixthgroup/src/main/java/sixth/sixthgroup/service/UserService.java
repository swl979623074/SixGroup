package sixth.sixthgroup.service;

import sixth.sixthgroup.model.User;

public interface UserService {
	/**
	 * 通过id查找用户
	 */
	public User findUserById(int id) throws Exception;
	/**
	 * 通过账号、密码删查找用户
	 */
	public User findUserByNameAndPassword(String loginnaem,String password) throws Exception;
	/**
	 * 添加一个用户
	 */
	public int insertUser(String loginname,String password,int userpower) throws Exception;
}
