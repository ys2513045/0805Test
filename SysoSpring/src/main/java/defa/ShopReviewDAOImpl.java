//package com.itwillbs.dao;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.stereotype.Repository;
//
//import com.itwillbs.domain.ShopReviewVO;
//
//@Repository
//public class ShopReviewDAOImpl implements ShopReviewDAO {
//
//	@Inject
//	private SqlSession sqlSession;
//	
//	private static final String namespace ="com.itwillbs.shopReviewMapper";
//
//	@Override
//	public List<ShopReviewVO> getShopReviewList(String shop_member_id) {
//		return sqlSession.selectList(namespace+".getShopReviewList", shop_member_id);
//	}
//	
//	
//}
