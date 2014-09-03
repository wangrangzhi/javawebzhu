package edu.freshen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.freshen.entity.LoginUser;
import edu.freshen.idao.IloginUserDao;

public class LoginUserDao implements IloginUserDao {

	@Override
	public LoginUser checkLogin(LoginUser user) {
		Connection conn =DaoHelper.getConn();
		String sql ="select * from tb_user where userName=? and userPwd=?";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		LoginUser lu=null;
		
		try {
			pstm =conn.prepareStatement(sql);
			pstm.setString(1, user.getLoginName());
			pstm.setString(2, user.getLoginPwd());
			rs=pstm.executeQuery();
			if(rs.next()){
				lu=new LoginUser();
				lu.setId(rs.getInt("id"));
				lu.setLoginName(rs.getString("userName"));
				lu.setLoginPwd(rs.getString("userPwd"));
				lu.setLevel(rs.getInt("level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoHelper.close(null, pstm, rs);
		}		

		return lu;
	}

}
