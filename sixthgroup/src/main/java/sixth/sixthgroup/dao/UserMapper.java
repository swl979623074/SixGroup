package sixth.sixthgroup.dao;

import sixth.sixthgroup.model.User;

public interface UserMapper {
	/*
	 * 通过映射生成的基本方法
	 */
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /*
     * 自己添加的方法
     */
    User slectUserByNameAndPasword(User user);
}