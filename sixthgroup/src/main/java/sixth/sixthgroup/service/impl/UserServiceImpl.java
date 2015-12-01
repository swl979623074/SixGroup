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

}
