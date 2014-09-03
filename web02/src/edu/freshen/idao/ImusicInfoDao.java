package edu.freshen.idao;

import java.util.List;

import edu.freshen.entity.MusicInfo;

public interface ImusicInfoDao {
	/**
	 * 查询所有的 音乐文件数据
	 * @return  返回List集合，封装音乐文件数据对象
	 */
	public List<MusicInfo> queryAllMusic();
}
