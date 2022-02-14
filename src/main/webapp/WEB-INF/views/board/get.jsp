<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Read
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	 	 <div class="form-group">
                                     <label>BNO</label>
                                     <input class="form-control" name="title" readonly="readonly" value= '<c:out value="${board.bno}"/>'>
                                 </div>
                       	 		 <div class="form-group">
                                     <label>Title</label>
                                     <input class="form-control" name="title" readonly="readonly" value= '<c:out value="${board.title}"/>'>
                                 </div>
                                 
                                 <div class="form-group">
                                     <label>Content</label>
                                     <textarea rows="10" cols="50"  name="content" style="resize: none" class="form-control"><c:out value="${board.content}"/></textarea>
                                 </div>
                                 
                                 <div class="form-group">
                                     <label>Writer</label>
                                     <input class="form-control" name="writer" value= '<c:out value="${board.writer}"/>'>
                                 </div>
                                 
                                <form id='actionForm' action="/board/list" method='get'>
                         		  <input type='hidden' name='pageNum' value = '${cri.pageNum}'>
                           	      <input type='hidden' name='amount' value = '${cri.amount}'>
                           	      <input type='hidden' name='bno' value = '${board.bno}'>
                           	      <input type='hidden' name='type' value = '${cri.type}'>
                           		  <input type='hidden' name='keyword' value = '${cri.keyword}'>
                           	                   	      
                         		</form>
                      		     <button type="button" class="btn btn-default listBtn"><a href='/board/list'>List</a></button>
                                 <button type="button" class="btn btn-default modBtn"><a href='/board/modify?bno=<c:out value="${board.bno}"/>'>Modify</a></button>
	                       		 
	                       		 
	                       		 
	                       		 
	                       		 <script type="text/javascript" src="/resources/js/reply.js"></script>
	                       		 
	                       		 <script type="text/javascript">
	                       		 
	                       		 $(document).ready(function() {
	                       		
	                       			 console.log("===============");
	                       			 console.log("JS TEST");

	                       		 var bnoValue = '<c:out value="${board.bno}"/>';
	                       			 
/*                       			 replyService.add(
	                      			{reply:"JS Test", replyer:"tester", bno:bnoValue} 
	                      			,
	                      			function(result){
	                      				alert("RESULT: " + result);
	                      		 
	                      		 }); 
 
	                       		 replyService.getList({bno:bnoValue, page:1}, function(list){
	                       			 
	                       			 for(var i = 0, len = list.length||0; i < len; i++) {
	                       				 console.log(list[i]);
	                       			 }
	                       		 }); 
	                       		 
	                       		 replyService.remove(23, function(count) {
	                       			 
	                       			 console.log("dleele");
	                       			 
	                       			 if (count === "success") {
	                       				 alert("REMOVED");
	                       			 }
	                       		 }, function(err) {
	                       		   alert('ERROR...');
	                       		 }); 
	                       		 
	                       		 replyService.update({
	                       			 rno : 13,
	                       			 bno : bnoValue,
	                       			 reply : "Modified Reply..........."
	                       		 }, function(result) {
	                       			 alert("수정 완료......");
	                       		 }); */
	                       		 
	                       		 replyService.get(10, function(data){
	                       			 console.log(data);
	                       		 });
	                       		 
	                       		 }); 
	                      		 
	                       		 </script>
	                       		 
	                       		 <script>
	                       		 $(document).ready(function() {
	                       		 
		                       			 var actionForm = $("#actionForm");
		                       		 
		                       		 $(".listBtn").click(function(e) {
		                       			 e.preventDefault();
		                       			 actionForm.find("input[name='bno']").remove();
		                       			 actionForm.submit();
		                       		 });
		                       		 
		                       		 $(".modBtn").click(function(e) {
		                       			 e.preventDefault();
		                       			 actionForm.attr("action", "/board/modify");
		                       			 actionForm.submit();
		                       		 });
	                       		 
	                       		 });
	                       		 
	                       		 
	                       		 </script>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

            <!-- /.row -->

            <!-- /.row -->
          
            <!-- /.row -->
	<%@include file="../includes/footer.jsp" %>
  