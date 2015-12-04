package sixth.sixthgroup.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import sixth.sixthgroup.model.User;
import sixth.sixthgroup.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * 通过id查找用户
	 * @param id 用户的id
	 * @return {"result":true,"user":{"userId":1,"userName":"swl","userPassword":"123","userPower":1}}
	 */
    @SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectUserById")
    public ModelAndView selectUserById(int id, HttpServletRequest request,HttpServletResponse response) {
    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			User user=new User();
			user=userService.findUserById(id);
			if(null==user){
    			map.put("result", Boolean.FALSE);
    		}else{
    			map.put("result", Boolean.TRUE);
    			map.put("user", user);
    		}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		}finally{
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
    
    /**
     * 通过用户名和密码 查找用户
     * @param loginname 用户名
     * @param password 密码
     * @return {"result":true,"user":{"userId":1,"userName":"swl","userPassword":"123","userPower":1}}
     */
    @SuppressWarnings({ "unchecked", "finally" })
	@RequestMapping("/selectUserByNameAndPassword")
    public ModelAndView selectUserByNameAndPassword(String loginname,String password, HttpServletRequest request,HttpServletResponse response) {
        	ModelAndView mav = new ModelAndView();
    	MappingJacksonJsonView view = new MappingJacksonJsonView();
    	@SuppressWarnings("rawtypes")
    	Map map = new HashMap();
    	try {
    		User user= new User();
    		user=this.userService.findUserByNameAndPassword(loginname, password);
    		if(null==user){
    			map.put("result", Boolean.FALSE);
    		}else{
    			map.put("result", Boolean.TRUE);
    			map.put("user", user);
    		}
    	} catch (Exception e) {
    		map.put("result", Boolean.FALSE);
    		e.printStackTrace();
    	}finally{
    		view.setAttributesMap(map);
    		mav.setView(view);
    		return mav;
    	}
    }
    /**
     * 添加一个用户名
     * @param loginname 用户名
     * @param password 密码
     * @param userpower 用户权限
     * @return {"result":false}
     */
    @SuppressWarnings({ "finally", "unchecked" })
    @RequestMapping("/insertUser")
    public ModelAndView insertUser(String loginname, String password, int userpower, HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
    	MappingJacksonJsonView view = new MappingJacksonJsonView();
    	@SuppressWarnings("rawtypes")
    	Map map = new HashMap();
    	try {
    		int key=0;
    		key=this.userService.insertUser(loginname, password, userpower);
    		if(key==1){
    			map.put("result", Boolean.TRUE);
    		}else{
    			map.put("result", Boolean.FALSE);
    		}
    		
    	} catch (Exception e) {
    		map.put("result", Boolean.FALSE);
    		e.printStackTrace();
    	}finally{
    		view.setAttributesMap(map);
    		mav.setView(view);
    		return mav;
    	}
    }
}
