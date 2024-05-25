<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="ko" class="fontawesome-i2svg-active fontawesome-i2svg-complete">
<head>  
	<title>dbinfo</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="desc">
	<meta name="author" content="dbinfo">
	<%@ include file="/WEB-INF/views/include/head_css.jsp"%>
<style>
header.masthead {
  padding-top: 10.5rem;
  padding-bottom: 6rem;
  text-align: center;
  color: #fff;
  background-image: url(${pageContext.request.contextPath}/assets/img/AboutUs.png);
  background-repeat: no-repeat;
  background-attachment: scroll;
  background-position: center center;
  background-size: cover;
}
header.masthead .masthead-subheading {
  font-size: 1.5rem;
  font-style: italic;
  line-height: 1.5rem;
  margin-bottom: 25px;
  font-family: "Roboto Slab", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}
header.masthead .masthead-heading {
  font-size: 3.25rem;
  font-weight: 700;
  line-height: 3.25rem;
  margin-bottom: 2rem;
  font-family: "Montserrat", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
}

@media (min-width: 768px) {
  header.masthead {
    padding-top: 17rem;
    padding-bottom: 12.5rem;
  }
  header.masthead .masthead-subheading {
    font-size: 2.25rem;
    font-style: italic;
    line-height: 2.25rem;
    margin-bottom: 2rem;
  }
  header.masthead .masthead-heading {
    font-size: 4.5rem;
    font-weight: 700;
    line-height: 4.5rem;
    margin-bottom: 4rem;
  }
}

.historyPosition{
position: relative;
left: -5%;
}
</style>
</head>
<body id="page-top">
	<%@ include file="/WEB-INF/views/include/top.jsp"%>
	<header class="masthead">
		<div class="container">
			<div class="masthead-heading text-uppercase"></div><br><br><br><br><br><br>
			<div class="masthead-subheading"></div> 
		</div>
	</header>
	<div style="margin-left: 15%; margin-right: 15%; margin-top: 5%;">  
		<!-- 인사말-->
		<section class="text-start" id="ABOUTCOMPANY" style="color: black;">
			<div class="container">
				<div>
					<h2>인사말</h2>
					<hr class="col-xs-10" style="border: solid 1px;">
					<h5>
						인공지능&빅데이터! 
						상황을 인지하고
						이성적.논리적으로 판단.행동하며
						감성적.창의적 기능을 수행하는 인공지능 최고의 기술력 확보를 목표로….
					</h5>
				</div>
				<br><br>
				<div class="col-xs-10">
						<p>
							세계는 인공지능(AI)의 급속한 발전으로 인해 산업과 사회 전반에 걸친 거대한 문명사적 변화를 맞이하고 있습니다.
							과거 산업화 과정에서는 기계가 인간의 육체노동을 대체했고, 이제는 인공지능(AI)이 인간의 지적 능력을 수행하는 수준까지 발전하고 있습니다. 
							인공지능(AI)은 막대한 부가가치를 창출하는 산업인 동시에 일자리 변동과 같은 사회변화를 가져오는 핵심 요소로서 사회가 당면한 문제 해결의 솔루션을 제시하고 있습니다.
							이에 디비인텍은 인공지능 전문 연구기업으로 대 변혁의 시대에 중심에 서고자 2022년, 새로이 창업을 했습니다.
							많은 분들의 격려와 지도를 부탁드립니다.

						</p>
						<br><br>
						<p style="color: blue; size: 4%; text-align: right;">대표이사 김애숙 拜上</p>
				</div>
			</div>
		</section>
 </div>
	<!-- Footer-->
	<%--
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	--%>
	<%--
	<%@ include file="/WEB-INF/views/include/footer_script.jsp"%>
	--%>
</body>
</html>

