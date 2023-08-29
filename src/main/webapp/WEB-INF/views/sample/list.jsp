<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head></head>
<body>
sample list <br/>
<c:forEach items="${list}" var="list">
    ${list.mngrId} : ${list.mngrName}  <br/>
</c:forEach>
</body>
</html>