package com.itwillbs.dao;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.domain.ShopVO;

public interface MemberDAO {

	public void memberJoin(MemberVO vo);

	public void updateAuthkey(MemberVO vo);

	public void updateAuthstatus(MemberVO vo);

	public int checkDup(String member_id);

	public MemberVO userCheck(MemberVO mb);

	public String transMember_id(String member_id);

	public MemberVO getMember(String member_id);
}
