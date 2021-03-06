<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            등록
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<form action="/board/register" method="post">
                        	
                        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	                        	   <div class="form-group">
                                       <label>Title</label>
                                       <input class="form-control" name="title">
                                   </div>
                                   
                                   <div class="form-group">
                                       <label>Content</label>
                                       <textarea rows="10" cols="50"  name="content" style="resize: none" class="form-control"></textarea>
                                   </div>
                                   
                                   <div class="form-group">
                                       <label>Writer</label>
                                       <input class="form-control" name="writer" value='<sec:authentication property="principal.username"/>' readonly="readonly">
                                   </div>
                        		   <button type="submit" class="btn btn-default">Register</button>
                                   <button type="reset" class="btn btn-default">Reset</button>
                        	</form>
	                       	
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
  