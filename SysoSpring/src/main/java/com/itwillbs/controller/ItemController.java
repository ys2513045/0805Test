package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.CommentVO;
import com.itwillbs.domain.ItemVO;
import com.itwillbs.domain.ReportVO;
import com.itwillbs.domain.ShopReviewVO;
import com.itwillbs.domain.ShopVO;
import com.itwillbs.domain.likesVO;
import com.itwillbs.service.CommentService;
import com.itwillbs.service.ItemService;
import com.itwillbs.service.ShopReviewService;
import com.itwillbs.service.ShopService;

@Controller
public class ItemController {
	@Inject
	private ItemService service;

	@Inject
	private CommentService cService;
	
	@Inject
	private ShopService sService;
	
	@Inject
	private ShopReviewService reviewService;
	

	@RequestMapping(value = "/itemDetail", method = RequestMethod.GET)
	public String itemDetail(@RequestParam int item_idx, Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("세션값 : " + session.getAttribute("id")); // 세션값 받아와짐
		// 1. 조회수 (쿠키) 있는지 판별================
		// 2. 없으면 생성, 있으면 무시(?)
		String cookie_idx = Integer.toString(item_idx);

		Cookie cookie = null;
		Cookie[] cookies = null;

		cookies = request.getCookies();

		boolean isContainRead = false;
		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {

				cookie = cookies[i];
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
				if (cookie.getValue().equals(cookie_idx)) {

					isContainRead = true;

				}

			}

		} else {

			isContainRead = false;

		}

		if (isContainRead) {

			System.out.println("해당하는 쿠키값이 있습니다.");

		} else {

			System.out.println("해당하는 쿠키값이 없습니다.");
			service.increaseReadCount(item_idx); // 조회수 증가
			// 쿠키값 지정
			cookie = new Cookie("isRead" + cookie_idx, cookie_idx);
			cookie.setMaxAge(60 * 60 * 24); // 24시간
			response.addCookie(cookie);

		}
		// ==================================== 조회수 (쿠키) 끝

		// item_idx에 맞는 item정보를 전부 가져옴(+ 서비스단에서 처리해놓음)
		String member_id = (String) session.getAttribute("id");
		List<ItemVO> list = service.getItemDetail(item_idx);
		model.addAttribute("list", list);

		// 해시태그 ===============================
		List<String> hashtag_names = service.getTagNames(item_idx);
		if (hashtag_names != null) {
			model.addAttribute("tagNames", hashtag_names);

		}
		// =============================== 해시태그

		// 찜기능 ===============================
		// member_id 랑 item_idx 를 가져가서 있는지 조회
		likesVO vo = new likesVO();
		vo.setItem_idx(item_idx);
		vo.setMember_id(member_id);
		likesVO vo2 = service.getLikesItem(vo);
		int likesCount = service.getLikesCount(vo);

		// Model 객체에 저장
		if (vo2 != null) {
			// 값이 있으면 == 찜이 눌러져 있으면
			model.addAttribute("isLike", "like");
			System.out.println("찜 눌려져있어요");
		} else {
			model.addAttribute("isLike", "notLike");
			System.out.println("찜 안눌려져 있어요");
		}

		model.addAttribute("likesCount", likesCount);
		// =============================== 찜기능 끝

		// 댓글 List 들고오기 ==========================
		CommentVO cvo = new CommentVO();

		cvo.setItem_idx(item_idx);
		List<CommentVO> cList = cService.getComment(cvo);

		model.addAttribute("cList", cList);
		// ===================================== 댓글 끝
		
		// 연관상품 item_img랑 item_idx 들고오기
		// rList
		int rNum = list.get(0).getCategory_idx(); // 보여줄 상품의 카테고리
		ItemVO ivo = new ItemVO();
		ivo.setCategory_idx(rNum);
		ivo.setItem_idx(item_idx);
		
		List<ItemVO> rList = null;
		rList = service.getRelatedItem(ivo);
		
		model.addAttribute("rList", rList);
		
		
		// ====================================== 연관상품 끝
		// 상점정보 ===================================
		ItemVO Ivo = new ItemVO();
		Ivo.setMember_id(list.get(0).getMember_id());
		Ivo.setItem_idx(item_idx);
		List<ShopVO> sList = sService.getShopInfo(Ivo);
		model.addAttribute("sList", sList);
		
		// 상점에 있는 제품 중 랜덤으로 2개 뽑아 저장하기
		List<ItemVO> shopItemPhotoList = service.getShopItemPhoto(Ivo);
		
		model.addAttribute("pList", shopItemPhotoList);
		System.out.println(shopItemPhotoList.size() + "개 가져왔음");
		// =================================== 상점정보 끝
		// 상점리뷰 =====================================
		List<ShopReviewVO> reviewList = null;
		String shop_member_id = sList.get(0).getMember_id();
		reviewList = reviewService.getPreReview(shop_member_id);
		
		model.addAttribute("reviewList", reviewList);
		// ==================================== 상점리뷰 끝

		return "./product/product_detail";
	}

	// 찜버튼 클릭시 동작
	// 찜이 안되어 있는 경우 item/changeToRed mapping
	//
	@RequestMapping(value = "/item/changeToRed",  method = RequestMethod.POST)
	public @ResponseBody int changeToRed(@RequestParam String member_id, int item_idx) throws Exception {

		// likesVO에 값 저장
		likesVO lVO = new likesVO();
		lVO.setItem_idx(item_idx);
		lVO.setMember_id(member_id);

		service.changeToRed(lVO);


		int likesCount = service.getLikesCount(lVO);
		// 값을 리턴
		return likesCount;
	}

	// 찜버튼 클릭시 동작
	// 찜이 되어 있는 경우 item/changeToGray mapping
	@RequestMapping(value = "/item/changeToGray", method = RequestMethod.POST)
	public @ResponseBody int changeToGray(@RequestParam String member_id, int item_idx) throws Exception {

		likesVO lvo = new likesVO();
		
		lvo.setItem_idx(item_idx);
		lvo.setMember_id(member_id);

		service.changeToGray(lvo);

//		ItemVO ivo = new ItemVO();
//		ivo.setItem_idx(item_idx);
//
//		service.decreaseLikesCount(ivo);

		int likesCount = service.getLikesCount(lvo);

		return likesCount;

	}

	// item/insertComment
	@RequestMapping(value = "/item/insertComment", method = RequestMethod.POST)
	public @ResponseBody List<CommentVO> insertComment(@RequestBody CommentVO cvo) throws Exception {

		System.out.println("itemcontroller /item/insertComment");
		System.out.println("member_id : " + cvo.getMember_id());
		System.out.println("item_idx: " + cvo.getItem_idx());

		List<CommentVO> cList = null;

		cList = cService.insertComment(cvo);

		return cList;
	}
	
		// item/deleteComment
		@RequestMapping(value = "/item/deleteComment", method = RequestMethod.POST)
		public @ResponseBody List<CommentVO> deleteComment(@RequestBody CommentVO cvo) throws Exception {

			System.out.println("itemcontroller /item/deleteComment");
			System.out.println("댓글쓴 아이디이면서 로그인되어있는 아이디 : " + cvo.getMember_id());
			System.out.println("item_idx : " + cvo.getItem_idx());
			System.out.println("comment_idx : " + cvo.getComment_idx());
			List<CommentVO> cList = null;
			
			cList = cService.deleteComment(cvo);

			return cList;
		}
		
		@RequestMapping(value = "/report_item", method = RequestMethod.POST)
		public String report_item(@RequestParam int item_idx, @RequestParam String report_content, Model model, HttpSession session) {
			
			System.out.println(item_idx);
			System.out.println(report_content);
			
			ReportVO rvo = new ReportVO();
			rvo.setItem_idx(item_idx);
			rvo.setMember_id((String)session.getAttribute("id"));
			rvo.setReport_content(report_content);
			
			service.insertItemReport(rvo);
			
			model.addAttribute("msg", "신고해주셔서 감사합니다. 고객님의 신고는 모두가 즐겁게 이용할 수 있는 쾌적한 시소마켓을 만드는 데에 큰 도움이 됩니다.");
			
			return "./product/msg";
		}
		
		
		@RequestMapping(value = "/report_comment", method = RequestMethod.POST)
		public String report_comment(@RequestParam int comment_idx, @RequestParam String report_content, Model model, HttpSession session) {
			
			System.out.println(comment_idx + ": comment_idx");
			System.out.println(report_content);
			
			ReportVO rvo = new ReportVO();
			rvo.setComment_idx(comment_idx);
			rvo.setMember_id((String)session.getAttribute("id"));
			rvo.setReport_content(report_content);
			
			service.insertCommentReport(rvo);
			
			model.addAttribute("msg", "신고해주셔서 감사합니다. 고객님의 신고는 모두가 즐겁게 이용할 수 있는 쾌적한 시소마켓을 만드는 데에 큰 도움이 됩니다.");
			
			return "./product/msg";
		}
		

}
