package com.example.android_resume;


public class Infos {
	private int pic;
	private String name;
	private String sex;
	
	
	
	public Infos(int pic, String name, String sex) {
		this.pic = pic;
		this.name = name;
		this.sex = sex;
	}
	public int getPic() {
		return pic;
	}
	public void setPic(int pic) {
		this.pic = pic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
