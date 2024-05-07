package com.dbinfocompany.dbinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbinfocompany.dbinfo.domain.MemberDto;
import com.dbinfocompany.dbinfo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository memberRepository;

	@Override
	public MemberDto getMember(String memberId) throws Exception {
		MemberDto memberDto = memberRepository.selectOne(memberId);
		return memberDto;
	}

}
