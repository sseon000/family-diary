package com.dbinfocompany.dbinfo.repository;

import java.util.List;

import com.dbinfocompany.dbinfo.domain.MemberDto;

public interface MemberRepository {
	int insert(MemberDto memberDto) throws Exception;
	MemberDto selectOne(String memberId) throws Exception;
	int update(MemberDto memberDto) throws Exception;
	int delete(MemberDto memberDto) throws Exception;
	List<MemberDto> selectAll() throws Exception;
}
