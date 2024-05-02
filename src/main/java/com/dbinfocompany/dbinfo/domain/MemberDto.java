package com.dbinfocompany.dbinfo.domain;

import java.util.Objects;

public class MemberDto {
	private String memberId;
	private String memberName;
	
	public MemberDto() {}
	public MemberDto(String memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberName=" + memberName + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(memberId, memberName);
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
		return Objects.equals(memberId, other.memberId) && Objects.equals(memberName, other.memberName);
	}	
}
