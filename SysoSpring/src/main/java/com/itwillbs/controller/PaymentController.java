package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.ItemVO;
import com.itwillbs.domain.OrderItemVO;
import com.itwillbs.service.ItemService;
import com.itwillbs.service.MemberService;

@Controller
public class PaymentController {

	@Inject
	private MemberService memberService;

	@Inject
	private ItemService itemService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(HttpSession session, Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("vo", memberService.getMember((String) session.getAttribute("id")));
		int item_idx = Integer.parseInt(request.getParameter("item_idx"));

		List<ItemVO> olist = itemService.getItemDetail(item_idx);
		model.addAttribute("olist", olist);

//		System.out.println(item_idx);

		return "/order";
	}

	@RequestMapping(value = "/orderpro", method = RequestMethod.GET)
	   public String writePro(OrderItemVO order_vo) {
	      // 주문하기 메서드 호출
//	      paymentService.orderItem(order_vo);
		
		System.out.println("writePro");

	      // /order/complete 가상주소 이동rder/complete";
	      return "redirect:/order/complete";
	   }

}
