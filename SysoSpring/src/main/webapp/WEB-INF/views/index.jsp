<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!doctype html>
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
<link href="resources/css/style.css" rel="stylesheet" type="text/css">


<script src="resources/js/jquery-3.1.1.min.js"></script>
<script src="resources/js/toggle.js"></script>



</head>

<body>
	<!-- String pattern = "HH"; -->
	<!-- SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); -->

	<!-- String date = simpleDateFormat.format(new Date()); -->

	<!-- %> -->

	<div class="bar">
		<ul>
			<li id="btn"><img src="resources/images/alarm.svg">

				<ul id="layer">
					<li><a href="#">""님이 구매하셨습니다</a></li>
					<li><a href="#">""님이 구매하셨습니다</a></li>
					<li><a href="#">""님이 구매하셨습니다</a></li>
				</ul></li>

			<li><a href="#"><img src="resources/images/redheart.svg"></a>
			</li>

			<li><a href="#">TOP</a></li>

		</ul>
	</div>
	<header id="header">
		<nav id="nav">
			<div id="wrap">
				<div class="login">
					<ul>
						<c:choose>
							<c:when test="${empty sessionScope.id }">
							<li><a href="./member/login" class="sig-color">로그인</a></li>
							<li><a href="./member/join" class="sig-color">회원가입</a></li>
							</c:when>
							<c:otherwise>
							<li><a href="./member/logout" class="sig-color">로그아웃</a></li>
							<li><a href="./member/update" class="sig-color">정보수정</a></li>
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
						<li><a href="product/write_form.html"> <img
								src="resources/images/money.svg"> 판매하기
						</a></li>
						<li><img src="resources/images/shop.svg">내상점</li>

						<li><img src="resources/images/talk.svg">시소톡</li>

						<li id="btn2"><img src="resources/images/hamburg.svg">카테고리

							<ul id="layer2">
								<li class="strong"><a href="#">전체 카테고리</a></li>


								<li><a href="#">여성의류</a></li>
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
	<section id="sec1">
		<div id="wrap">
			<article class="croll_banner">
				<ul>
					<li>
						<div class="left_top">
							<img src="resources/images/mainlogo.png">
						</div>

						<div class="left_bottom">
							<h1 class="banner_title">나에게 딱 맞는 거래, 시소마켓</h1>
							<div class="slogan">
								<p>
									<span class="sig-color">S</span>elect <span class="sig-color">Y</span>our
									<span class="sig-color">S</span>uitable <span class="sig-color">O</span>bject
								</p>
							</div>
							<p>
								누구나, 무엇이든 쉽고 편하고<br> 안전하게 거래하는 세상을 꿈꾸고 있습니다.
							</p>


						</div>
					</li>

					<li>
						<div class="event_box">
							<img src="resources/images/mainEvent1.png">

							<div class="event_txt">
								<p style="color: #fff;">회원가입시 추천인 아이디 입력시 추천인과 신규 회원님 상품 구매시
									사용 가능한 3,000원 적립금 지급!</p>
							</div>

						</div>

					</li>


					<li>
						<div class="right_top"></div>

						<div class="right_bottom"></div>

					</li>
				</ul>

			</article>
		</div>
	</section>

	<section id="sec2">
		<div id="wrap">
			<h1>오늘의 상품 추천</h1>
			<article id="content_area">
				<c:forEach items="${list}" var="list">
					<div class="content" style="cursor: pointer;">
						<div class="content_top">
							<img src="resources/images/apeach.jpg" width="246" height="200">
						</div>

						<div class="content_bottom">
							<div class="con_title">${list.item_subject}</div>
							<div class="con_text">
								<div class="con_price">${list.item_price}원</div>
								<div class="con_time">
									<span id="">${list.item_date}전</span>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>


			</article>
		</div>
	</section>




	<footer> </footer>

	<script type="text/javascript">

	var startNum = 9;
	var endNum = 16;
	
		
	$(window).scroll(function(){
		
			if ($(window).scrollTop() >= $(document).height()- $(window).height()) {
			
				
			
				$.ajax({
					type:'post',
					url:'infiniteScrollDown',
					contentType : 'application/json',
					dataType : 'json',
					data:JSON.stringify({
						"startNum":startNum,"endNum":endNum
					}),
				
					success:function(data){
					var str = "";
					
					if(data != ""){
						$(data).each(function(){
							console.log(this);
							str +=   "<div class="+"'content'" +"style="+"'cursor: pointer;'"+"onclick="+"location.href='itemDetail?item_idx="+this.item_idx+"'"+">"
			               		+	 "<div class="+ "'content_top'" +">"
			               		+	 "<img src="+"'resources/images/apeach.jpg'"+ "width="+"'246'" + "height="+"'200'"+">"
			               		+	 "</div>"
			                	+	"<div class="+"'content_bottom'"+">"
			               		+	 "<div class="+"'con_title'"+">"
			                   	+	this.item_subject +"</div>"
			                  	+	  "<div class="+"'con_text'"+">"
			                	+	"<div class="+"'con_price'"+">"
			                    +   this.item_price+"원"
			                    +  "</div>"
			                    +	"<div class="+"'con_time'"+">"
			                    +   "<span>"+ this.item_date_format +"</span></div></div></div></div>";
			                  
						}); // each
						$("#content_area").append(str);
						var lastStartNum = startNum;
						var lastEndNum = endNum;
						startNum = lastEndNum + 1;
						endNum = lastStartNum + lastEndNum -1;
						
					} //if data != null
					else{
						alert("더이상 불러올 데이터가 없습니다.");
						
						
					} //else
					} //success
						
				});  //ajax
			} // if scroll ==0

});  // 스크롤






	
	
 </script>



</body>


</html>
