<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>BASE ADMIN</title>
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/jquery.form.min.js"></script>
    <script src="/static/js/jquery-ui.min.js"></script>
    <script src="/static/js/common.js"></script>

    <style>
        div.left {
            width: 20%;
            float: left;
        }
        div.right {
            width: 80%;
            float: right;
        }
    </style>
</head>

<body>
<div class="left">
    <tiles:insertAttribute name="adminMenu" />
</div>
<div class="right">
    <div class="content">
        <tiles:insertAttribute name="adminHeader" />
        <div class="wrap">
            <tiles:insertAttribute name="body" />
        </div>
    </div>
</div>
</body>
</html>
