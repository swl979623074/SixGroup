package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.ClassAccount;
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
	/**
	 * 添加一个用户
	 * @param user 被添加用户的信息
	 * @return
	 */
	public int insertUser(User user)throws Exception;
	/**
	 * 查找所有班级账号
	 * @return
	 */
	public List<ClassAccount> selectAll();
}
