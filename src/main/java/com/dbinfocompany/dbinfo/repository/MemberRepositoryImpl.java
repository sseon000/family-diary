package com.dbinfocompany.dbinfo.repository;

import java.util.List;

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
	public int insert(MemberDto memberDto) throws Exception {
		return session.insert(namespace+"insert", memberDto);
	}
    
	@Override
	public MemberDto selectOne(String memberId) throws Exception {
		MemberDto memberDto = session.selectOne(namespace+"select", memberId); 
		return memberDto;
	}

	@Override
	public int update(MemberDto memberDto) throws Exception {
		return 0;
	}

	@Override
	public int delete(MemberDto memberDto) throws Exception {
		return 0;
	}

	@Override
	public List<MemberDto> selectAll() throws Exception {
		return session.selectList(namespace+"selectAll");
	}
}
