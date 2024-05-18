package com.dbinfocompany.dbinfo.service;

import java.util.List;

import com.dbinfocompany.dbinfo.domain.MemberDto;

public interface MemberService {
	int write(MemberDto memberDto) throws Exception;
	MemberDto read(String memberId) throws Exception;
	int modify(MemberDto memberDto) throws Exception;
	int remove(Integer num) throws Exception;
    List<MemberDto> getList() throws Exception;
}
