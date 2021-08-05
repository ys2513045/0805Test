<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />


<title>프로젝트명</title>
<!--[if lt IE 9]>
      <script src="js/html5.js"></script>
   <![endif]-->

<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link href="resources/css/order.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	function findAddr() {
		new daum.Postcode({
			oncomplete : function(data) {

				console.log(data);

				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var roadAddr = data.roadAddress; // 도로명 주소 변수
				var jibunAddr = data.jibunAddress; // 지번 주소 변수
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('member_post').value = data.zonecode;
				if (roadAddr !== '') {
					document.getElementById("member_addr").value = roadAddr;
				} else if (jibunAddr !== '') {
					document.getElementById("member_addr").value = jibunAddr;
				}
			}

		}).open();
	}

	// ----------------- 포인트 --------------------------------

	// 		function point_use() {
	// 			var f = document.orderWrite;

	// 			// 사용할 포인트
	// 			var o_point = Number(f.usePoint.value);

	// 		}

	// 	function usePoint(){
	// 		var order = document.order; // order.jsp 접근
	// 		var h_p = ${vo.member_point}; // 보유 포인트
	// 		var u_p = Number(order.usePoint.value); // 사용할 포인트

	// 		alert('오잉')
	// 	}
	// 	}

// 	$('#usePoint').click(function() {
// 		alert("로그인 후 사용가능한 기능입니다!");
// 		// 		$('.me').removeClass('on');
// 		// 		$(this).addClass('on');
// 	});
	
	// jQuery
	$(document).ready(function () {
		
		
		
		if($("input[name='pamentMethod']:checked").val() == 'online'){
			alert('온라인 선택');
		}
	});
	
</script>
</head>

<body>

	<header id="header">
		<nav id="nav">
			<div id="wrap">
				<div class="login">

					<ul>
						<c:choose>
							<c:when test="${empty sessionScope}">
								<li><a href="login" class="sig-color">로그인</a></li>
								<li><a href="join" class="sig-color">회원가입</a></li>
							</c:when>

							<c:otherwise>
								<li><a href="member/logout" class="sig-color">로그아웃</a></li>
								<li><a href="member/serviceCenter" class="sig-color">고객센터</a></li>
							</c:otherwise>
						</c:choose>

					</ul>


				</div>
				<h1 id="logo">
					<a href="home"><img src="resources/images/main_logo.svg"></a>
				</h1>

				<div class="search_wrap">
					<div class="search_area">
						<input type="text" class="search" placeholder="상품명,지역명,@상점명 입력">
						<a href="#" class="search_img"><img
							src="resources/images/home_search.svg"></a>
					</div>


				</div>
				<div class="nav_right">
					<ul>
						<li><a href="<c:url value="/sell" />"> <img
								src="resources/images/money.svg"> 판매하기
						</a></li>
						<li><a href="<c:url value="/myshop" />"> <img
								src="resources/images/shop.svg">내상점
						</a></li>

						<li style="cursor: pointer;" onclick="openTalk()"><img
							src="resources/images/talk.svg">시소톡</li>

						<li id="btn2"><img src="resources/images/hamburg.svg">카테고리

							<ul id="layer2">
								<li class="strong"><a href="#">전체 카테고리</a></li>


								<li><a href="itemCategory?item_category=여성의류">여성의류</a></li>
								<li><a href="#">패션잡화</a></li>
								<li><a href="#">남성의류</a></li>
								<li><a href="#">디지털/가전</a></li>
								<li><a href="#">도서/티켓/취미/반려</a></li>
								<li><a href="#">스타굿즈</a></li>
								<li><a href="#">생활/문구/가구/식품</a></li>
								<li><a href="#">스포츠/레저</a></li>
								<li><a href="#">뷰티/미용</a></li>
								<li><a href="#">유아동/출산</a></li>
								<li><a href="#">차량/오토바이</a></li>
								<li><a href="#">기타</a></li>

							</ul></li>

					</ul>
				</div>

			</div>

		</nav>


	</header>






	<section id="order_area">
		<div id="container">
			<h1 class="title">
				<span class="sig-color">주문정보 확인</span>
			</h1>
			<p class="sub_title">
				<span style="color: red">주문자 정보와 배송지가 다른 경우 직접 입력해주세요.</span>
			</p>
			<div class="order_form">
				<form action='<c:url value="/orderpro" />' method="get">
					<c:forEach items="${olist}" var="olist">
						<table>
							<tr>
								<td class="tb_title">주문번호</td>
								<td><input type="text" value="${olist.item_idx}" readonly
									name="item_idx"></td>
							</tr>

							<tr>
								<td class="tb_title">상품명</td>
								<td><input type="text" value="${olist.item_subject}"
									readonly name="item_subject"></td>
							</tr>

							<tr>
								<td class="tb_title">가격</td>
								<td><input type="text" value="${olist.item_price}원"
									name="item_price"></td>
							</tr>

						</table>

						<table>


							<tr>
								<td class="tb_title">ID</td>
								<td><input type="text" value="${sessionScope.id }" readonly
									name="member_id"></td>
							</tr>

							<tr>
								<td class="tb_title">NAME</td>
								<td><input type="text" value="${vo.member_name }"
									name="member_name"></td>
							</tr>

							<tr>
								<td class="tb_title">ADRESS</td>
								<td><input id="member_post"
									style="cursor: pointer; background: #396afc; color: #fff;"
									type="text" placeholder="우편번호(클릭)" name="member_zipcode"
									onclick="findAddr()" readonly value="${vo.member_zipcode}"></td>
							</tr>

							<tr>
								<td class="tb_title"></td>
								<td><input id="member_addr" type="text"
									name="member_address" placeholder="주소" readonly required
									class="int" value="${vo.member_address}"></td>
							</tr>

							<tr>
								<td class="tb_title"></td>
								<td><input type="text" placeholder="상세주소"
									name="member_addressDetail" id="addrD" class="int"
									value="${vo.member_addressDetail}" name="member_addressDetail"></td>
							</tr>

							<tr>
								<td class="tb_title">Eamil</td>
								<td><input type="email" value="${vo.member_email}"
									name="member_email"></td>

							</tr>

							<tr>
								<td class="tb_title">Phone</td>
								<td><input type="text" value="${vo.member_phone}"
									name="member_phone"></td>

							</tr>

							<!-- 						<tr> -->
							<!-- 							<td class="tb_title">배송 메시지</td> -->
							<!-- 							<td><input type="text" placeholder="배송 메시지" -->
							<!-- 								name="delivery_msg"></td> -->

							<!-- 						</tr> -->

						</table>

						<h1 class="title">
							<span class="sig-color">결제수단 확인</span>
						</h1>
						<div class="buyby">
							<div class="radio_area">

								<span class="how">온라인 결제<input type="radio" name="paymentMethod" value="online"></span>
								<span class="how">직거래<input type="radio" name="paymentMethod" value="direct"></span>


							</div>

							<div class="submit_area">
								<table>


									<tr>
										<td class="tb_title">상품가격</td>
										<td><input type="text" name="item_price" id="item_price"
											readonly value="${olist.item_price}"></td>
									</tr>

									<tr>
										<td class="tb_title">배송비</td>
										<td><input type="text" readonly
											value="${olist.item_charge }원"></td>
									</tr>

									<tr>
										<td class="tb_title">보유포인트</td>
										<td><input type="text" readonly
											value="${vo.member_point} 원"></td>
									</tr>
									<tr>
										<td class="tb_title">사용할 포인트</td>
										<td><input type="text" name="use_Point" id="use_Point"
											value=" 원"></td>
									</tr>
									<tr>
										<td class="tb_title"></td>
										<td><button type="button" onclick="usePoint()"
												name="usePoint" id="usePoint" class="usePoint">사용하기</button></td>
									</tr>


									<tr>
										<td class="tb_title">총 결제금액 :</td>
										<td><input type="text" readonly
											value="상품가격 + 배송비 ${olist.item_charge } - 내포인트 : ???? 원"
											style="color: green;"></td>
									</tr>


								</table>

								<div class="btn_area">
									<button type="submit">결제하기</button>
									<button type="button" onclick="back()">돌아가기</button>
								</div>

							</div>
						</div>



					</c:forEach>
				</form>

			</div>

		</div>
	</section>
	<footer class="footer">
		<div id="container">
			<p>
				ⓒ2021 Team <span class="sig-color">SYSO</span>
			</p>
			<p>Designed by Kys</p>
		</div>
	</footer>

</body>

</html>
