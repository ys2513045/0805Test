package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.ShopVO;

@Repository
public class ShopDAOImpl implements ShopDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace ="com.itwillbs.shopMapper";

	@Override
	public List<ShopVO> getShopInfo(String member_id) {
		// TODO Auto-generated method stub
		
		
		return sqlSession.selectList(namespace + ".getShopInfo", member_id);
	}


}
