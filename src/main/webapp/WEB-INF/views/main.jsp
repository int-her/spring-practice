<%--
  Created by IntelliJ IDEA.
  User: heojeongsu
  Date: 2018. 4. 22.
  Time: PM 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<body>
    <div style="background-color: #FFFFCC;">
        div style="background-color: #FFFFCC;" 적용
        div는 폭과 가로 등의 길이를 직접 지정할 수 있다.
        줄 바꿈을 자동으로 해준다.
    </div>
    <span style="background-color: #FFFFCC;">
        span style="background-color: #FFFFCC;" 적용
        span은 자동으로 태그 안의 내용만 차지한다.
        줄 바꿈을 안해준다.
    </span>
    <br>
    <div>
        <div>윗 줄에 숫자를 쓰면 -> <input type="number" id="number"></div>
        <div>아랫 줄에 값이 복사 된다. -> <span id="number-dup"></span></div>
        <div>keyup이라는 function을 사용했다.</div>
    </div>
    <a href="/angular" class="btn btn-default">angular 연습</a>
</body>
</html>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
    $("#number").keyup(function() {
        $("#number-dup").text($("#number").val())
    })
</script>
