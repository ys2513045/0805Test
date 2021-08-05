package com.itwillbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.ItemVO;
import com.itwillbs.domain.ShopVO;

@Service
public interface ShopService {

	List<ShopVO> getShopInfo(ItemVO ivo);
	
	

}
