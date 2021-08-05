package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.ShopReviewVO;

public interface ShopReviewDAO {

	List<ShopReviewVO> getShopReviewList(String shop_member_id);

	List<ShopReviewVO> getPreReview(String shop_member_id);

	Integer getreviewCount(String member_id);

}
