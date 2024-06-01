package com.dbinfocompany.dbinfo.repository.member;

import java.util.List;

import com.dbinfocompany.dbinfo.domain.member.MemberDto;

public interface MemberRepository {
	int insert(MemberDto memberDto) throws Exception;
	MemberDto selectOne(String memberId) throws Exception;
	int update(MemberDto memberDto) throws Exception;
	int delete(Integer num) throws Exception;
	List<MemberDto> selectAll() throws Exception;
}
