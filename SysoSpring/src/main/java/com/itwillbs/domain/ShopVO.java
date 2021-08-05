package com.itwillbs.domain;

public class ShopVO {

	private String shop_intro;
	private String profilePhoto;
	private int shop_itemCount;
	private int shop_saleCount;
	
	private String member_id;
	private String member_nickName;
	
	private int shop_reviewCount;
	
	
	public int getShop_reviewCount() {
		return shop_reviewCount;
	}
	public void setShop_reviewCount(int shop_reviewCount) {
		this.shop_reviewCount = shop_reviewCount;
	}
	public String getMember_nickName() {
		return member_nickName;
	}
	public void setMember_nickName(String member_nickName) {
		this.member_nickName = member_nickName;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
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
}
