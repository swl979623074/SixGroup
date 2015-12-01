package swl;

import static org.junit.Assert.*;
import jxl.common.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import com.alibaba.fastjson.JSON;

import sixth.sixthgroup.model.User;
import sixth.sixthgroup.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class UserControllerTest {

	private static final Logger LOGGER = Logger
			.getLogger(UserControllerTest.class);

	@Autowired
	private UserService userService;

	
	@Test
	public void testQueryById1() throws Exception {
		User userInfo = userService.findUserById(1);
		//LOGGER.info(JSON.toJSON(userInfo));
		System.out.println(JSON.toJSON(userInfo));
		
		User exp=new User();
		exp.setUserId(1);
		exp.setUserName("swl");
		exp.setUserPassword("123");
		exp.setUserPower(1);
		assertEquals(JSON.toJSON(userInfo),JSON.toJSON(exp));
		/*
		 * 将对象转化成json对象再进行比对
		 */
	}
}
