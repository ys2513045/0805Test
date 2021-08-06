package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.ItemVO;
import com.itwillbs.domain.ReportVO;
import com.itwillbs.domain.likesVO;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	private static final String namespace ="com.itwillbs.itemMapper";
	private static final String namespace2 = "com.itwillbs.likesMapper";
	private static final String namespace3 = "com.itwillbs.CommentMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<ItemVO> getItem() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".getItem");
	}

	@Override
	public List<ItemVO> infiniteScrollDown(ItemVO itemVO) {
		
		return sqlSession.selectList(namespace+".infinite",itemVO);
	}

	@Override
	public List<ItemVO> getItemDetail(int item_idx) {
		
		return sqlSession.selectList(namespace+".getItemDetail",item_idx);
		
	}

	@Override
	public likesVO getLikesItem(likesVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace2 + ".getLikesItem", vo);
	}

	@Override
	public int changeToRed(likesVO lVO) {
		// TODO Auto-generated method stub
		System.out.println("DAO - changeToRed");
		return sqlSession.insert(namespace2 + ".changeToRed", lVO);
	}

	@Override
	public int increaseLikesCount(ItemVO ivo) {
		// TODO Auto-generated method stub
		System.out.println("DAO - increaseLikesCount");
		return sqlSession.update(namespace + ".increaseLikesCount", ivo);
	}

	@Override
	public int changeToGray(likesVO lVO) {
		// TODO Auto-generated method stub
		System.out.println("DAO - changeToGray");
		
		return sqlSession.delete(namespace2 + ".changeToGray", lVO);
	}

	@Override
	public int decreaseLikesCount(ItemVO ivo) {
		// TODO Auto-generated method stub
		System.out.println("DAO - increaseLikesCount");
		return sqlSession.update(namespace + ".decreaseLikesCount", ivo);
	}

	@Override
	public int getLikesCount(likesVO lvo) {
		// TODO Auto-generated method stub
		System.out.println("dao - getLikesCount");
		return sqlSession.selectOne(namespace2 + ".getLikesCount", lvo);
	}

	@Override
	public int increaseReadCount(int item_idx) {
		// TODO Auto-generated method stub
		System.out.println("daoImpl - increaseReadcount");
		return sqlSession.update(namespace + ".increaseReadCount", item_idx);
	}

	@Override
	public String getCategoryName(int category_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getCategoryName", category_idx);
	}

	@Override
	public List<String> getTagNames(int item_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getTagNames", item_idx);
	}

	@Override
	public List<ItemVO> getRelatedItem(ItemVO ivo) {
		// TODO Auto-generated method stub
		
		
		return sqlSession.selectList(namespace + ".getRelatedItem", ivo);
	}


	@Override
	public List<ItemVO> getShopItemPhoto(ItemVO ivo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getShopItemPhoto", ivo);
	}

	@Override
	public void insertItemReport(ReportVO rvo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertItemReport", rvo);
	}

	@Override
	public void insertCommentReport(ReportVO rvo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace3 + ".insertCommentReport", rvo);
	}


}
