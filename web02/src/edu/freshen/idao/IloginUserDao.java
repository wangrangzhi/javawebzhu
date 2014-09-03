package edu.freshen.idao;

import edu.freshen.entity.LoginUser;

/**
 * 处理登录用户的 数据层接口
 * @author Administrator
 *
 */
public interface IloginUserDao {
	/**
	 * 用于检测 登录用户是否成功
	 * @param user	登录用户对象
	 * @return	如果用户存在，则返回该对象，否则返回null
	 */
	public LoginUser checkLogin(LoginUser user);
	
	
}
