//package com.itwillbs.controller;
//
//import javax.inject.Inject;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.itwillbs.domain.LikesVO;
//import com.itwillbs.service.LikesService;
//
//@Controller
//public class LikesController {
//	
//	@Inject
//	private LikesService service;
//	
//	@RequestMapping(value = "/likes/insert", method = RequestMethod.POST)
//	@ResponseBody
//	public int insert(@RequestParam int item_idx, HttpSession session) throws Exception {
//		System.out.println("LikesController - insert");
//		
//		String id = (String)session.getAttribute("id");
//
//		LikesVO vo = new LikesVO();
//		vo.setItem_idx(item_idx);
//		vo.setMember_id(id);
//		
//		service.insertLike(vo);
//		
//		int countLikes = service.countLikes(item_idx);
//		
//		return countLikes;
//	}
//	
//	@RequestMapping(value = "/likes/delete", method = RequestMethod.POST)
//	@ResponseBody
//	public int delete(@RequestParam int item_idx, HttpSession session) throws Exception {
//		System.out.println("LikesController - delete");
//		
//		String id = (String)session.getAttribute("id");
//
//		LikesVO vo = new LikesVO();
//		vo.setItem_idx(item_idx);
//		vo.setMember_id(id);
//
//		service.deleteLike(vo);
//		
//		int countLikes = service.countLikes(item_idx);
//		
//		return countLikes;
//	}
//	
//
//
//}
