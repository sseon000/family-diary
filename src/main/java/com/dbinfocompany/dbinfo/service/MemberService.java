package com.dbinfocompany.dbinfo.service;

import com.dbinfocompany.dbinfo.domain.MemberDto;

public interface MemberService {
	MemberDto getMember(String memberId) throws Exception;
}
