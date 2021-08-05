//package com.itwillbs.controller;
//
//import java.util.List;
//
//import javax.inject.Inject;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.itwillbs.domain.ItemVO;
//import com.itwillbs.domain.LikesVO;
//import com.itwillbs.service.ItemService;
//import com.itwillbs.service.LikesService;
//
//@Controller
//public class ItemController {
//	
//	@Inject
//	private ItemService itemService;
//	@Inject
//	private LikesService likesService;
//	
//	
//	@RequestMapping(value = "/item/insert", method = RequestMethod.GET)
//	public String insert() {
//		return "product/insertForm";
//	}
//
//	@RequestMapping(value = "/itemDetail", method = RequestMethod.GET)
//	public String imtemDetail(@RequestParam int item_idx,Model model, HttpSession session) throws Exception {
//		System.out.println("itemcontroller/ detail");
//		System.out.println("item_idx : " + item_idx);
//		
//		String member_id = (String)session.getAttribute("id");
//		List<ItemVO> list = itemService.getItemDetail(item_idx);
//		
//		LikesVO vo = new LikesVO();
//		vo.setItem_idx(item_idx);
//		vo.setMember_id(member_id);
//		
//		int countLikes = likesService.countLikes(item_idx);
//		int myLike = 0;
//		if(countLikes > 0) {
//			if(likesService.myLike(vo)) {
//				myLike++;
//			}
//			System.out.println("myLike" + myLike);
//			model.addAttribute("myLike", myLike);
//		}
//		
//		model.addAttribute("countLikes", countLikes);
//		model.addAttribute("myLike", myLike);
//		model.addAttribute("list",list);
//		return "./product/product_detail";
//	}
//
//	
//	
//}
