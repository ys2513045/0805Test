package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.ItemVO;
import com.itwillbs.domain.likesVO;

public interface ItemService {
	public List<ItemVO> getItem() throws Exception;

	public List<ItemVO> infiniteScrollDown(ItemVO itemVO);

	public List<ItemVO> getItemDetail(int item_idx);

	public likesVO getLikesItem(likesVO vo);

	public void changeToRed(likesVO lVO);

//	public void increaseLikesCount(ItemVO ivo);

	public void changeToGray(likesVO lVO);

	public void decreaseLikesCount(ItemVO ivo);

	public int getLikesCount(likesVO lvo);

	public void increaseReadCount(int item_idx);

//	public String getCategoryName(int category_idx);

	public List<String> getTagNames(int item_idx);

	public List<ItemVO> getRelatedItem(ItemVO ivo);

	public List<ItemVO> getShopItemPhoto(ItemVO ivo);

}
