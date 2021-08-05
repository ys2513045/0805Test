package com.itwillbs.domain;

import java.sql.Timestamp;

public class Shop_ShopReviewVO {
	
	private int shopReview_idx;
	private String shop_member_id;
	private String item_idx;
	private String shopReview_id;
	private int shopReview_star;
	private String shopReview_content;
	private Timestamp shopReview_date;
	private String shopReview_date_format;
	
	private String shop_intro;
	private String profilePhoto;
	private int shop_itemCount;
	private int shop_saleCount;
	
	
	public String getShop_intro() {
		return shop_intro;
	}
	public void setShop_intro(String shop_intro) {
		this.shop_intro = shop_intro;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public int getShop_itemCount() {
		return shop_itemCount;
	}
	public void setShop_itemCount(int shop_itemCount) {
		this.shop_itemCount = shop_itemCount;
	}
	public int getShop_saleCount() {
		return shop_saleCount;
	}
	public void setShop_saleCount(int shop_saleCount) {
		this.shop_saleCount = shop_saleCount;
	}
	public int getShopReview_idx() {
		return shopReview_idx;
	}
	public void setShopReview_idx(int shopReview_idx) {
		this.shopReview_idx = shopReview_idx;
	}
	public String getShop_member_id() {
		return shop_member_id;
	}
	public void setShop_member_id(String shop_member_id) {
		this.shop_member_id = shop_member_id;
	}
	public String getItem_idx() {
		return item_idx;
	}
	public void setItem_idx(String item_idx) {
		this.item_idx = item_idx;
	}
	public String getShopReview_id() {
		return shopReview_id;
	}
	public void setShopReview_id(String shopReview_id) {
		this.shopReview_id = shopReview_id;
	}
	public int getShopReview_star() {
		return shopReview_star;
	}
	public void setShopReview_star(int shopReview_star) {
		this.shopReview_star = shopReview_star;
	}
	public String getShopReview_content() {
		return shopReview_content;
	}
	public void setShopReview_content(String shopReview_content) {
		this.shopReview_content = shopReview_content;
	}
	public Timestamp getShopReview_date() {
		return shopReview_date;
	}
	public void setShopReview_date(Timestamp shopReview_date) {
		this.shopReview_date = shopReview_date;
	}
	public String getShopReview_date_format() {
		return shopReview_date_format;
	}
	public void setShopReview_date_format(String shopReview_date_format) {
		this.shopReview_date_format = shopReview_date_format;
	}

}
