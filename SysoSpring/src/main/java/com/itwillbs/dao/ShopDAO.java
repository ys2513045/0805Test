package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.ShopVO;

public interface ShopDAO {

	List<ShopVO> getShopInfo(String member_id);



}
