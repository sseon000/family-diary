package com.dbinfocompany.dbinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbinfocompany.dbinfo.domain.MemberDto;
import com.dbinfocompany.dbinfo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository memberRepository;

	@Override
	public int write(MemberDto memberDto) throws Exception {
		return memberRepository.insert(memberDto);
	}
	
	@Override
	public MemberDto read(String memberId) throws Exception {
		MemberDto memberDto = memberRepository.selectOne(memberId);
		return memberDto;
	}

	@Override
	public int modify(MemberDto memberDto) throws Exception {
		return memberRepository.update(memberDto);
	}

	@Override
	public int remove(Integer num) throws Exception {
		return memberRepository.delete(num);
	}

	@Override
	public List<MemberDto> getList() throws Exception {
		return memberRepository.selectAll();
	}
}
