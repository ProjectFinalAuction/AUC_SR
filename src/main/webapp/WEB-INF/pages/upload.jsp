<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring 4 MVC File Upload Example</title>
    <script type="text/javascript" src="/resources/static/js/jQuery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/jquery.form.min.js"></script>
</head>
<body> 
 		<input type="file" name="image" id="image" />
 		<h1>ORIGINAL</h1>
 		<img src="" id="result"/>
 		<h1>THUMBNAIL</h1>
 		<img src="" id="resultThumbnail"/>
 		
	<script>
 		$(function(){
 			$("#image").change(function(){
 				var formData = new FormData();
 				formData.append('image',  $("#image")[0].files[0]);
 		     	$.ajax({
 		            url: "/api/v1/uploading",
 		            type:"POST",
 		         	enctype : 'multipart/form-data',
 					data : formData ,
 					cache: false,
 					crossDomain: true,
 					processData : false, // tell jQuery not to process the data
 					contentType : false, // tell jQuery not to set contentType
 		  	        beforeSend: function(xhr) {
 						xhr.setRequestHeader('Access-Control-Allow-Origin', '*');
 						xhr.setRequestHeader('Authorization', 'Basic ZWxpYnJhcnlBRE1JTjplbGlicmFyeVBAU1NXT1JE');
 		  	        },
 		            success: function(data) {
 		            	console.log(data);
 		            	$("#result").attr("src", data.ORIGINAL_IMAGE);
 		            	$("#resultThumbnail").attr("src", data.THUMBNAIL_IMAGE);
 		            },
 		         	error: function(data){
 		         		console.log(data);
 					}
 		        });
 			});
 		});	
	</script>
</body>
</html>