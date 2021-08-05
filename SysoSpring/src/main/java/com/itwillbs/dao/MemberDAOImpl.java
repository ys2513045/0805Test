package com.itwillbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.domain.ShopVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.itwillbs.itemMapper";

	private static final String namespace2 = "com.itwillbs.MemberMapper";

	@Override
	public void memberJoin(MemberVO vo) {
		System.out.println("멤퍼 dao");
		sqlSession.insert(namespace + ".join", vo);
	}

	@Override
	public void updateAuthkey(MemberVO vo) {

		System.out.println("맵퍼 인증키 업데이트");
		sqlSession.update(namespace + ".authkey", vo);
	}

	@Override
	public void updateAuthstatus(MemberVO vo) {
		System.out.println("맵퍼 인증 완료 업데이트");
		sqlSession.update(namespace + ".authstatus", vo);

	}

	@Override
	public int checkDup(String member_id) {

		System.out.println("DAO 중복확인");
		int cnt = sqlSession.selectOne(namespace + ".checkdup", member_id);
		System.out.println("cnt");
		return cnt;
	}

	@Override
	public MemberVO userCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		System.out.println("DAO - userCheck");

		return sqlSession.selectOne(namespace + ".userCheck", vo);
	}

	@Override
	public String transMember_id(String member_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace2 + ".transMemberid", member_id);
	}

	@Override
	public MemberVO getMember(String member_id) {
		System.out.println("MemberDAOImpl_member_id");
		return sqlSession.selectOne(namespace2 + ".getMember", member_id);
	}

}
