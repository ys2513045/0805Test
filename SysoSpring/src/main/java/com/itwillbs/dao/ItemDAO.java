package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.ItemVO;
import com.itwillbs.domain.ShopVO;
import com.itwillbs.domain.likesVO;

public interface ItemDAO {
	
	public List<ItemVO> getItem() throws Exception;

	public List<ItemVO> infiniteScrollDown(ItemVO itemVO);

	public List<ItemVO> getItemDetail(int item_idx);

	public likesVO getLikesItem(likesVO vo);

	public int changeToRed(likesVO lVO);

	public int increaseLikesCount(ItemVO ivo);

	public int changeToGray(likesVO lVO);

	public int decreaseLikesCount(ItemVO ivo);

	public int getLikesCount(likesVO lvo);

	public int increaseReadCount(int item_idx);

	public String getCategoryName(int category_idx);

	public List<String> getTagNames(int item_idx);

	public List<ItemVO> getRelatedItem(ItemVO ivo);

	public List<ItemVO> getShopItemPhoto(ItemVO ivo);


	
}
