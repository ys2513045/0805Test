package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.ItemDAO;
import com.itwillbs.domain.ItemVO;
import com.itwillbs.domain.ReportVO;
import com.itwillbs.domain.likesVO;
import com.itwillbs.util.TimeGap;

@Service
public class ItemServiceImpl implements ItemService {

	@Inject
	private ItemDAO dao;

	@Override
	public List<ItemVO> getItem() throws Exception {
		return dao.getItem();
	}

	@Override
	public List<ItemVO> infiniteScrollDown(ItemVO itemVO) {

		List<ItemVO> list = dao.infiniteScrollDown(itemVO);
		
		TimeGap.setDateFormat(list);

//		for (int i = 0; i < list.size(); i++) {
//
//			Timestamp item_date = list.get(i).getItem_date();
//			list.get(i).setItem_date_format(TimeGap.getTimeGap(item_date));
//
//		}

		return list;
	}

	@Override
	public List<ItemVO> getItemDetail(int item_idx) {
		List<ItemVO> list = dao.getItemDetail(item_idx);
		
		if(list != null) {
			
		int category_idx = list.get(0).getCategory_idx();
		String category_name = dao.getCategoryName(category_idx);
		list.get(0).setCategory_name(category_name);
		
		// ---- XX분 전 ----
		Timestamp item_date = list.get(0).getItem_date();
		list.get(0).setItem_date_format(TimeGap.getTimeGap(item_date));
		
		// 상품정보 개행처리
//		String str = list.get(0).getItem_detail();
//		System.out.println("!!!!!!!!!!!!!!!!!" + str);
//		str.replace("<br>", "\r\n");
//		list.get(0).setItem_detail(str);
		
//		System.out.println("!@!@!@@!@!@!" + str); 
		}
		
		return list;

	}

	@Override
	public likesVO getLikesItem(likesVO vo) {
		// TODO Auto-generated method stub
		return dao.getLikesItem(vo);
	}

	@Override
	public void changeToRed(likesVO lVO) {
		// TODO Auto-generated method stub
		System.out.println("service - changeToRed()");
		int item_idx = lVO.getItem_idx();
		
		int insertCount = dao.changeToRed(lVO);
		
		ItemVO ivo = new ItemVO();
		
		ivo.setItem_idx(item_idx);
		int updateCount = dao.increaseLikesCount(ivo);
		
		
		
		// 확인 식 =================================
		System.out.println("likes 테이블에 수정된 컬럼수 : " + insertCount);
		// ================================= 확인 식 끝
		if (updateCount > 1) {
			System.out.println("item_likesCount - 수정된 컬럼수 : " + updateCount);
		} else if (updateCount == 1) {
			System.out.println("item_likesCount - 수정된 컬럼수 : " + updateCount);
		} else {
			System.out.println("item_likesCount - 수정된 컬럼수 : " + updateCount);
		}
		
		
		
	}


	@Override
	public void changeToGray(likesVO lVO) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("service - changeToGray()");
		int insertCount = 0;
		int item_idx = lVO.getItem_idx();

		insertCount = dao.changeToGray(lVO);
		
		ItemVO ivo = new ItemVO();
		ivo.setItem_idx(item_idx);
		
		int updateCount = dao.decreaseLikesCount(ivo);
		
		// 확인 식 =========================================
		if (insertCount > 1) {
			System.out.println("likes 테이블에 수정된 컬럼수 2개이상");
		} else if (insertCount == 1) {
			System.out.println("likes 테이블에 추가된 컬럼수 1개");
		} else {
			System.out.println("likes 테이블에 추가된 컬럼수 0개");
		}
		if (updateCount > 1) {
			System.out.println("item_likesCount - 수정된 컬럼수 : " + updateCount);
		} else if (updateCount == 1) {
			System.out.println("item_likesCount - 수정된 컬럼수 : " + updateCount);
		} else {
			System.out.println("item_likesCount - 수정된 컬럼수 : " + updateCount);
		}
		// 확인식 끝 =========================================
		
	}

	@Override
	public void decreaseLikesCount(ItemVO ivo) {
		// TODO Auto-generated method stub
		System.out.println("service - increaseLikesCount");
		int updateCount = 0;

		updateCount = dao.decreaseLikesCount(ivo);

		if (updateCount > 1) {
			System.out.println("item_likesCount - 수정된 컬럼수 : " + updateCount);
		} else if (updateCount == 1) {
			System.out.println("item_likesCount - 수정된 컬럼수 : " + updateCount);
		} else {
			System.out.println("item_likesCount - 수정된 컬럼수 : " + updateCount);
		}

	}

	@Override
	public int getLikesCount(likesVO lvo) {
		// TODO Auto-generated method stub
		System.out.println("service - getLikesCount");
		return dao.getLikesCount(lvo);
	}

	@Override
	public void increaseReadCount(int item_idx) {
		// TODO Auto-generated method stub
		int updateCount = 0;
		updateCount = dao.increaseReadCount(item_idx);
		System.out.println("updateCount = " + updateCount);
	}

//	@Override
//	public String getCategoryName(int category_idx) {
//		// TODO Auto-generated method stub
//		
//		return dao.getCategoryName(category_idx);
//	}

	@Override
	public List<String> getTagNames(int item_idx) {
		// TODO Auto-generated method stub
		System.out.println("svc - getTagNames");
		return dao.getTagNames(item_idx);
	}

	@Override
	public List<ItemVO> getRelatedItem(ItemVO ivo) {
		// TODO Auto-generated method stub
//		System.out.println("svc - getRelatedItem");
		List<ItemVO> rList = null;
		
		rList = dao.getRelatedItem(ivo);
//		System.out.println(rList.get(0).getItem_img());
		return rList;
	}

	@Override
	public List<ItemVO> getShopItemPhoto(ItemVO ivo) {
		// TODO Auto-generated method stub
		System.out.println("svc - getShopItemPhoto");
		List<ItemVO> list = null;
		
		list = dao.getShopItemPhoto(ivo);
		
		
		return list;
	}

	@Override
	public void insertItemReport(ReportVO rvo) {
		// TODO Auto-generated method stub
		dao.insertItemReport(rvo);
	}

	@Override
	public void insertCommentReport(ReportVO rvo) {
		// TODO Auto-generated method stub
		dao.insertCommentReport(rvo);
	}

}
