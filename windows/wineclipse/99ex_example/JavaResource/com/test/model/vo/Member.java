package com.test.model.vo;

public class Member {
	private String memberId, memberPwd, memberName, gender;
	private int age;
		
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String memberId, String memberPwd, String memberName, String gender, int age) {
	super();
	this.memberId = memberId;
	this.memberPwd = memberPwd;
	this.memberName = memberName;
	this.gender = gender;
	this.age = age;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
		
		
		@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName + ", gender="
				+ gender + ", age=" + age + "]";
	}
}
