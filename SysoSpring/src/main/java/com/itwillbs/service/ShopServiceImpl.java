package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.ItemDAO;
import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.ShopDAO;
import com.itwillbs.dao.ShopReviewDAO;
import com.itwillbs.domain.ItemVO;
import com.itwillbs.domain.ShopVO;

@Service
public class ShopServiceImpl implements ShopService {

	@Inject
	private ShopDAO dao;

	@Inject
	private MemberDAO mdao;

//	@Inject
//	private ItemDAO idao;
	
	@Inject
	private ShopReviewDAO reviewdao;
	
	@Override
	public List<ShopVO> getShopInfo(ItemVO Ivo) {
		// TODO Auto-generated method stub
		System.out.println("svc - getShopInfo");

		List<ShopVO> sList = dao.getShopInfo(Ivo.getMember_id());

		String shopId = Ivo.getMember_id();
		sList.get(0).setMember_nickName(mdao.transMember_id(shopId));
		sList.get(0).setShop_reviewCount(reviewdao.getreviewCount(shopId));

		return sList;
	}

}
