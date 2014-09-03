package edu.freshen.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.freshen.entity.MusicInfo;
import edu.freshen.idao.ImusicInfoDao;
import edu.freshen.util.DateUtil;

public class MusicInfoDao implements ImusicInfoDao {

	@Override
	public List<MusicInfo> queryAllMusic() {
		Connection conn = DaoHelper.getConn();
		String sql ="select * from tb_musicinfo";
		Statement stm=null;
		ResultSet rs=null;
		//
		List<MusicInfo> musics=new ArrayList<MusicInfo>();
		try {
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);
			MusicInfo m=null;
			while(rs.next()){
				m=new MusicInfo();
				m.setId(rs.getInt("id"));
				m.setMusicName(rs.getString("musicName"));
				m.setMusicAuthro(rs.getString("musicAuthor"));
				m.setType(rs.getString("type"));
				m.setFilePath(rs.getString("filePath"));
				m.setCreateDate(DateUtil.strToDate(rs.getString("createDate")));
				m.setMoney(rs.getFloat("money"));
				//System.out.println("读出日期："+rs.getString("createDate"));
				musics.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoHelper.close(stm, null, rs);
		}
		return musics;
	}

}
