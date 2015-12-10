package sixth.sixthgroup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixth.sixthgroup.dao.UserMapper;
import sixth.sixthgroup.model.User;
import sixth.sixthgroup.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 查找用户
	 * 参数  id
	 * 返回值 User
	 */
	@SuppressWarnings("finally")
	public User findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		try{
			user=userMapper.selectByPrimaryKey(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			return  user;
		}
	}
	/**
	 * 查找用户 
	 * 参数 loginnaem，password
	 * 返回值 User
	 */
	@SuppressWarnings("finally")
	public User findUserByNameAndPassword(String loginnaem, String password)
			throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(loginnaem);
		user.setUserPassword(password);
		
		User myUser=new User();
		try{
			myUser=this.userMapper.slectUserByNameAndPasword(user);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			return myUser;
		}
	}
	/**
	 * 添加一个用户
	 * 参数 loginname password userpower
	 * 返回值 int
	 */
	@SuppressWarnings("finally")
	public int insertUser(String loginname, String password, int userpower)
			throws Exception {
		// TODO Auto-generated method stub
		int key=0;
		
		User user = new User();
		user.setUserName(loginname);
		user.setUserPassword(password);
		user.setUserPower(userpower);
		
		try{
			User reUser=new User();
			reUser=this.findUserByNameAndPassword(loginname, password);
			if(reUser==null){
				key=this.userMapper.insert(user);	
			}
			System.out.println(key);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return key;
		}
	}
	public int insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		int key=0;
		User reUser = new User();
		reUser=this.findUserByNameAndPassword(user.getUserName(), user.getUserPassword());
		if(reUser==null){
			key=this.userMapper.insert(user);
		}
		return key;
	}
	
}
