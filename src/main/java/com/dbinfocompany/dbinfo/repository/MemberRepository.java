package com.dbinfocompany.dbinfo.repository;

import com.dbinfocompany.dbinfo.domain.MemberDto;

public interface MemberRepository {
	MemberDto selectOne(String memberId) throws Exception;
}
