//package com.itwillbs.service;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.springframework.stereotype.Service;
//
//import com.itwillbs.dao.ShopReviewDAO;
//import com.itwillbs.domain.ShopReviewVO;
//import com.itwillbs.util.TimeGap;
//
//@Service
//public class ShopReviewServiceImpl implements ShopReviewService {
//
//	@Inject
//	private ShopReviewDAO dao;
//
//	@Override
//	public List<ShopReviewVO> getShopReviewList(String shop_member_id) {
//		List<ShopReviewVO> shopReviewList = dao.getShopReviewList(shop_member_id);
//		TimeGap.setShopReviewDateFormat(shopReviewList);
//		
//		return shopReviewList;
//	}
//}
