package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.ShopReviewDAO;
import com.itwillbs.domain.ShopReviewVO;
import com.itwillbs.util.TimeGap;

@Service
public class ShopReviewServiceImpl implements ShopReviewService {

	@Inject
	private ShopReviewDAO dao;

	@Inject
	private MemberDAO mdao;
	
	@Override
	public List<ShopReviewVO> getShopReviewList(String shop_member_id) {
		List<ShopReviewVO> shopReviewList = dao.getShopReviewList(shop_member_id);
		TimeGap.setShopReviewDateFormat(shopReviewList);
		
		return shopReviewList;
	}

	@Override
	public List<ShopReviewVO> getPreReview(String shop_member_id) {
		// TODO Auto-generated method stub
		List<ShopReviewVO> shopReviewList = dao.getPreReview(shop_member_id);
		for(int i = 0; i < shopReviewList.size(); i++) {
			String id = shopReviewList.get(i).getShopReview_id();
			shopReviewList.get(i).setShopReview_nickname(mdao.transMember_id(id));
		}
		
		TimeGap.setShopReviewDateFormat(shopReviewList);
//		System.out.println(shopReviewList.get(0).getShop_member_id());
//		System.out.println(shopReviewList.get(0).getShopReview_date_format());
//		System.out.println(shopReviewList.size() + "개 가져옴(상세페이지 - 리뷰개수)");
		
		if(shopReviewList.size() > 0) {
			System.out.println("상점리뷰 1개이상가져가요");
			
		}
		System.out.println("상점리뷰 service 단");
		return shopReviewList;
	}
}
