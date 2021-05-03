package com.test.model.vo;

public class Member {
	private String memberId, memberPwd;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String memberId, String memberPwd) {
	super();
	this.memberId = memberId;
	this.memberPwd = memberPwd;
	
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
	
		
		@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + "]";
	}
}
