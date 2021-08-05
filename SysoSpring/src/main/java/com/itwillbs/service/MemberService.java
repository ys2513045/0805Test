package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	
	public void memberJoinProcess(MemberVO vo);

	public void updateAuthstatus(MemberVO vo);

	public int checkDup(String member_id);

	public MemberVO userCheck(MemberVO vo);

	public MemberVO getMember(String member_id);
}
