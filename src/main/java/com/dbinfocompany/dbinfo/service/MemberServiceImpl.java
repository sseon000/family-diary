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
		System.out.println("serveimpl : " + memberId);
		MemberDto memberDto = memberRepository.selectOne(memberId);
		System.out.println("serveimpl.memberDto : " + memberDto);
		return memberDto;
	}

}
