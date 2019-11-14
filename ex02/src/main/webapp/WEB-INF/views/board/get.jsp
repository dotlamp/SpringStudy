<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
                    <h1 class="page-header">Board Register</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Register
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                   			<label>Bno</label>
                     		<form id='operForm' action="/boad/modify" method="get">
								<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
								<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
								<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
								<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
								<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'> 
							</form>
                            	<div class="form-group">
                        			<label>Title</label>
                        			<input class="form-control" name='title' value='<c:out value="${board.title }" />' readonly="readonly">
                        		</div>
                        		<div class="form-group">
                        			<label>Text area</label>
                        			<textarea class="form-control" rows="3" name='content' readonly="readonly"><c:out value="${board.content }" /></textarea>
                        		</div>
                        		<div class="form-group">
                        			<label>Writer</label>
                        			<input class="form-control" name='writer' value='<c:out value="${board.writer }" />' readonly="readonly">
                        		</div>
                        		<div class="form-group">
                        			<label>Regdate</label>
                        			<input class="form-control" name='regdate' value='<c:out value="${board.regdate }" />' readonly="readonly">
                        		</div>
                        		
<!--                         		<button date-oper='modify' class="btn btn-default">Modify</button> -->
<!--                         		<button date-oper='list' class="btn btn-info">List</button> -->
                        		
                        		<button data-oper='modify' class="btn btn-default">Modify</button>
       							<button data-oper='list' class="btn btn-info">List</button>
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
$(document).ready(function() {
  
  var operForm = $("#operForm"); 
  
  $("button[data-oper='modify']").on("click", function(e){
    
    operForm.attr("action","/board/modify").submit();
    
  });
  
    
  $("button[data-oper='list']").on("click", function(e){
    
    operForm.find("#bno").remove();
    operForm.attr("action","/board/list")
    operForm.submit();
    
  });  
});
</script>

</body>
</html>