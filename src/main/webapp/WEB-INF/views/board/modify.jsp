<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 수정</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<style>
table {
	border: solid 1px;
	width: 1500px;
}
</style>
<script text="text/javascript">
    $(document).ready(function(){
    	var formObj = $("form[name='readForm']");
    	
    	//수정
    	$(".modify_btn").on("click", function(){
    		formObj.attr("action", "/board/modify");
    		formObj.attr("method", "get");
    		formObj.submit();
    	})
    	
    	//삭제
        $(".delete_btn").on("click", function(){
            formObj.attr("action", "/board/delete");
            formObj.attr("method", "post");
            formObj.submit();
        })
        
        //취소
        $(".cancel_btn").on("click", function(){
            //location.href = "/board/detail/<c:out value='${user_seq}'/>/<c:out value='${recipe_seq}'/>";
            history.back();
        })
    	
    })//document
</script>
<body>
<table>
    <tbody>
        <tr>
            <td>
                <label for="recipe_nm">레시피 이름 : </label><input type="text" id="recipe_nm" name="recipe_nm" value="${update.recipe_nm}" readonly="readonly"> 
            </td>
            <td>
                <label for="recipe_sumry">레시피 소개: </label><input type="text" id="recipe_sumry" name="recipe_sumry" value="${update.recipe_sumry}" readonly="readonly">
            </td>
    </tbody>
</table>
<!--     <br> 레시피 분류 : -->
<!--     <br> 재료코드 : -->
<!--     <br> 조리시간 : -->
<!--     <br> 분량 : -->
<!--     <br> 칼로리 : -->
<!--     <br> 난이도 : -->
<!--     <br> 이미지 : -->
<!--     <br> 수정자 아이디 : -->
<!--     <br> 조리방법설명 : -->
<!--     <br> 조리이미지 : -->
<!--     <br> 팁 : -->
                        <button type="submit" class="modify_btn">저장</button>
                        <button type="submit" class="cancel_btn">취소</button>
</body>
</html>