<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Start Bootstrap - SB Admin Version 2.0 Demo</title>

    <!-- Core CSS - Include with every page -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Page-Level Plugin CSS - Tables -->
    <link href="/resources/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <!-- SB Admin CSS - Include with every page -->
    <link href="/resources/css/sb-admin.css" rel="stylesheet">

</head>

<body>

   

        <%@include file="../includes/header.jsp" %>
        
       
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board List Page</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board List Page
                            <button id='regBtn' type="button" class="btn btn-xs pull-right">Register</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
											<th>번호</th>
											<th>제목</th>
											<th>내용</th>
											<th>작성자</th>
											<th>작성일</th>
											<th>수정일</th>
                                        </tr>
                                    </thead>
                                    <c:forEach items="${list }" var="board">
                                    	<tr>
                                     		<td><a class='move' href='<c:out value="${board.bno }"/>'><c:out value="${board.bno }" /></a></td>
                                    		<td>
                                    		<a class='move' href='<c:out value="${board.bno }"/>'><c:out value="${board.title }" />
                                    			<b>[ <c:out value="${board.replyCnt }" />]</b>
                                    		</a></td>
                                    		<td><c:out value="${board.content }" /></td>
                                    		<td><c:out value="${board.writer }" /></td>
                                    		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }" /></td>
                                    		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }" /></td>
                                    	</tr>
                                    </c:forEach>
                                </table>
                                <!-- /.table -->
                                
                                <!-- Search  -->
                                <div class='row'>
                                	<div class="col-lg-12">
                                		<form id='searchForm' actio='/board/list' method='get'>
                                			<select name='type'>
	                                			<option value="" <c:out value="${pageMaker.cri.type == null?'selected':'' }" />>--</option>
	                                			<option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':'' }"/>>제목</option>
	                                			<option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>내용</option>
	                                			<option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>작성자</option>
	                                			<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':'' }"/>>제목 or 내용</option>
	                                			<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'?'selected':'' }"/>>제목 or 작성자</option>
	                                			<option value="TWC" <c:out value="${pageMaker.cri.type eq 'TWC'?'selected':'' }"/>>제목 or 내용 or 작성자</option>
                                			</select>
                                			<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword }"/>' />
                                			<input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum }"/>'/>
                                			<input type='hidden' name='amount' value='<c:out value="${pageMaker.cri.amount }"/>'/>
                                			<button class='btn btn-default'>Search</button>
                                		</form>
                                	</div>
                                </div>
                                <!-- /.Search -->
                                
                                <!-- Paging  -->
                                <div class='pull-right'>
									<ul class="pagination">
										<c:if test="${pageMaker.prev}">
											<li class="paginate_button previous">
											<a href="${pageMaker.startPage -1}">Previous</a>
										</li>
										</c:if>
										
										<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
											<li class="paginate_button ${pageMaker.cri.pageNum==num ? "active": "" } " >
											<a href="${num}">${num}</a></li>
										</c:forEach>
										
										<c:if test="${pageMaker.next}">
											<li class="paginate_button next">
											<a href="${pageMaker.endPage+1}">next</a></li>
										</c:if>
										</ul>

									<form id='actionForm' action="/board/list" method='get'>
										<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
										<input type='hidden' name='amount' value='${pageMaker.cri.amount }'>
										<input type='hidden' name='type' value='<c:out value="${pageMaker.cri.type }" />'>
										<input type='hidden' name='keyword' value='<c:out value="${pageMaker.cri.keyword }" />'>
									</form>
                                </div>
                                <!-- /.Paging -->
                                
                                <!-- modal  -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                                <div class="modal-dialog">
	                                    <div class="modal-content">
	                                        <div class="modal-header">
	                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
	                                        </div>
	                                        <div class="modal-body">
												처리가 완료되었습니다.
	                                        </div>
	                                        <div class="modal-footer">
	                                            <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
	                                        </div>
	                                    </div>
	                                    <!-- /.modal-content -->
	                                </div>
	                                <!-- /.modal-dialog -->
                          		</div>
                                <!-- /.modal  -->
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
	<%@ include file="../includes/footer.jsp" %>
<script type="text/javascript">

$(document).ready(function(){
	/* 모달 관련(등록,수정,삭제)  */
	var result = '<c:out value="${result}" />';
	
	checkModal(result);
	
	history.replaceState({}, null, null)
	
	function checkModal(result){
		if(result === '' || history.state ){
			return;
		}
		if(parseInt(result) > 0 ){
			$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
		}
		$("#myModal").modal("show");
	}
	
	$("#regBtn").on("click", function(){
		self.location="/board/register";
	});
	
	/* 페이징 관련 */
	var actionForm = $("#actionForm");
	
	$(".paginate_button a").on("click", function(e){
		e.preventDefault();
		console.log('click');
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	/* 게시글 링크 */
	$(".move").on("click", function(e){
		e.preventDefault();
		actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
		actionForm.attr("action", "/board/get");
		actionForm.submit();
	});
	
	var searchForm = $("#searchForm");
	
	$("#searchForm button").on("click", function(e){
		if(!searchForm.find("option:selected").val()){
			alert("검색종류를 선택하세요");
			return false;
		}
		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요");
			return false;
		}
		searchForm.find("input[name='pageNum']").val("1");
		e.preventDefault();
		
		searchForm.submit();
		
	});
	
	
});

</script>
    
</body>

</html>