<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>김우진 전화번호 수정페이지</h1>
	<p>수정 화면 입니다.
	   아래항목을 수정 하시고 "수정" 버튼을 눌러주세요	</p>
	   
	<Form action="${pageContext.request.contextPath}/phone/modify2" method="get">
	이름(name)<input type="text" name="name" value="${requestScope.pMap.NAME}"><br>
	핸드폰(hp)<input type="text" name="hp" value="${requestScope.pMap.HP}"><br>
	회사(company)<input type="text" name="company" value="${requestScope.pMap.COMPANY}"><br>
	<input type="hidden" name="personid" value="${requestScope.pMap.PERSONID}"><br>
	<!-- //지금은 set으로 가지고 오는게 아닌 키값으로 가지고 오기 때문에 오는 값으로 받아야한다 -->
	<button type="submit">수정</button>
	</Form>
</body>
</html>