<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function getMethod(){
		$.ajax({
			url: "rest", type: "GET", dataType: "json",
			success: function(data){ $("#label").text(data.execute)}
		})
	}
	function postMethod(){
		$.ajax({
			url: "rest", type: "POST", dataType: "json",
			success: function(data){ $("#label").text(data.execute)}
		})
	}
	function putMethod(){
		$.ajax({
			url: "rest", type: "PUT", dataType: "json",
			success: function(data){ $("#label").text(data.execute)}
		})
	}
	function deleteMethod(){
		$.ajax({
			url: "rest", type: "DELETE", dataType: "json", 
			success: function(data){ $("#label").text(data.execute)}
		})
	}
</script>
</head>
<body>
	<label id="label"></label><hr>
	<button type="button" onclick="getMethod()">get</button>
	<button type="button" onclick="postMethod()">post</button>
	<button type="button" onclick="putMethod()">put</button>
	<button type="button" onclick="deleteMethod()">delete</button>
</body>
</html>