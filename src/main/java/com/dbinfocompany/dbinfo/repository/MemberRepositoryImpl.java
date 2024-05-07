package com.dbinfocompany.dbinfo.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dbinfocompany.dbinfo.domain.MemberDto;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	@Autowired
    private SqlSession session;
    private static String namespace = "com.dbinfocompany.dbinfo.repository.MemberMapper.";

	@Override
	public MemberDto selectOne(String memberId) throws Exception {
		MemberDto memberDto = session.selectOne(namespace+"select", memberId); 
		return memberDto;
	}

}
