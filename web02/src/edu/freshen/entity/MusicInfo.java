package edu.freshen.entity;

import java.util.Date;

public class MusicInfo {
	private int id;
	private String musicName,musicAuthro,type,filePath;
	private Date createDate;
	private float money;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getMusicAuthro() {
		return musicAuthro;
	}
	public void setMusicAuthro(String musicAuthro) {
		this.musicAuthro = musicAuthro;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "MusicInfo [id=" + id + ", musicName=" + musicName
				+ ", musicAuthro=" + musicAuthro + ", type=" + type
				+ ", filePath=" + filePath + "]";
	}
	
}
