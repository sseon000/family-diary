package com.dbinfocompany.dbinfo.domain;

import java.util.Objects;

public class MemberDto {
	private int num;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birthday;
	private String ph;
	private String acept;
	private String type;
	private String hiredate;

	
	public MemberDto() {};
	public MemberDto(int num, String id, String pw, String name, String gender, String birthday, String ph,
			String acept, String type, String hiredate) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.ph = ph;
		this.acept = acept;
		this.type = type;
		this.hiredate = hiredate;
	};

	public String getHiredate() {
		return hiredate;
	};

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	};

	public int getNum() {
		return this.num;
	};

	public void setNum(int num) {
		this.num = num;
	};

	public String getId() {
		return this.id;
	};

	public void setId(String id) {
		this.id = id;
	};

	public String getPw() {
		return this.pw;
	};

	public void setPw(String pw) {
		this.pw = pw;
	};

	public String getName() {
		return this.name;
	};

	public void setName(String name) {
		this.name = name;
	};

	public String getGender() {
		return this.gender;
	};

	public void setGender(String gender) {
		this.gender = gender;
	};

	public String getBirthday() {
		return this.birthday;
	};

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	};

	public String getPh() {
		return this.ph;
	};

	public void setPh(String ph) {
		this.ph = ph;
	};

	public String getAcept() {
		return this.acept;
	};

	public void setAcept(String acept) {
		this.acept = acept;
	};

	public String getType() {
		return this.type;
	};

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(acept, birthday, gender, hiredate, id, name, num, ph, pw, type);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDto other = (MemberDto) obj;
		return Objects.equals(acept, other.acept) && Objects.equals(birthday, other.birthday)
				&& Objects.equals(gender, other.gender) && Objects.equals(hiredate, other.hiredate)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && num == other.num
				&& Objects.equals(ph, other.ph) && Objects.equals(pw, other.pw) && Objects.equals(type, other.type);
	}
	
	@Override
	public String toString() {
		return "MemberDto [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", ph=" + ph + ", acept=" + acept + ", type=" + type + ", hiredate="
				+ hiredate + "]";
	};
}
