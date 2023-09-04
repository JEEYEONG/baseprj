<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
    <title>Title</title>
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/jquery-ui.min.js"></script>
    <script src="/static/js/common.js"></script>

    <%--    부트스트랩--%>
    <!-- CSS only -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<style>
  .menu_view_wrapper {
    margin: auto 25px;
    height: 800px;
  }


  .menu_view h2 {
    text-align: center;
  }

  .menu_view_wrapper .top {
    margin-left: 20px;
    font-weight: bold;
    font-size: 20px;
  }

  .menu_view_header_wrapper tr th {
    border: 1px solid black;
  }


  .menu_view {
    border: 1px solid black;
    width: inherit;
    height: 700px;
  }

  .menu_view tbody > tr {
    border: none;
    height: 100px;
  }

  .menu_view .second {
    margin-left: 40px;
    font-weight: lighter;
    font-size: 15px;
  }

  .menu_view .third {
    margin-left: 60px;
    font-weight: lighter;
    font-size: 12px;
  }

  .menu-level-0 {
    font-weight: bold;
  }

  .menu-level-1 {
    margin-left: 20px;
  }

  .menu-level-2 {
    margin-left: 40px;
  }

  .menu_wrapper {
    border: solid 1px black;
    height: inherit;
  }

  .button_wrapper {
    display: flex;
    justify-content: flex-end;
  }

  .button_wrapper button {
    margin-left: 10px;
  }
</style>
<body>
<div class="left">
    <tiles:insertAttribute name="adminHeader"/>
</div>
<div class="container-fluid" style="height: 950px">
    <div class="row" style="height: inherit">
        <div class="col-md-4" style="height: inherit">
            <div class="menu_wrapper" style="height: inherit">
                <table class="table">
                    <thead>
                    <tr>
                        <th colspan="4">
                            MENU
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td colspan="4">
                            <span class="menu-level-1">* TB - Monthly</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <span class="menu-level-2">- TB - Monthly</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <span class="menu-level-2">- TB - Monthly</span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-8">
            <table class="table">
                <thead>
                <tr>
                    <th colspan="4">
                        Menu
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td colspan="4">
                        <div class="form-group row">
                            <label for="menuCd" class="col-sm-2 col-form-label">경로</label>
                            <div class="col-sm-10">
                                <input type="text" name="menuCd" class="form-control" id="menuCd">
                            </div>
                        </div>
                    </td>

                </tr>
                <tr>
                    <td colspan="4">
                        <form>
                            <div class="form-group row">
                                <label for="menuNm" class="col-sm-2 col-form-label">메뉴 명</label>
                                <div class="col-sm-10">
                                    <input type="text" name="menuNm" class="form-control"
                                           id="menuNm">
                                </div>
                            </div>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <div class="form-group row">
                            <label for="linkUrl" class="col-sm-2 col-form-label">대표 URL</label>
                            <div class="col-sm-10">
                                <input type="text" name="linkUrl" class="form-control"
                                       id="linkUrl">
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <div class="form-group row">
                            <label for="displYn" class="col-sm-2 col-form-label">노출 여부</label>
                            <div class="col-sm-10">
                                <select name="displYn" class="form-control"
                                        id="displYn">
                                    <option selected value="Y">예</option>
                                    <option selected value="N">아니요</option>
                                </select>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <div class="button_wrapper">
                            <button type="button" class="btn btn-success" id="menu_add">
                                저장
                            </button>
                            <button type="button" class="btn btn-danger">
                                삭제
                            </button>
                            <button type="button" class="btn">
                                초기화
                            </button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>

            <table class="table">
                <thead>
                <tr>
                    <th colspan="6">
                        Page 등록
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td colspan="2">페이지 명</td>
                    <td colspan="2">코드 설명</td>
                    <td colspan="2">삭제</td>
                </tr>

                <tr>
                    <td colspan="2">
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <input type="text" name="pageName" class="form-control"
                                       id="pageName">
                            </div>
                        </div>
                    </td>
                    <td colspan="2">
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <input type="text" name="codeDescription" class="form-control"
                                       id="codeDescription">
                            </div>
                        </div>
                    </td>
                    <td colspan="2">
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="button" name="deleteBtn" class="btn btn-danger"
                                        id="deleteBtn">삭제
                                </button>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td colspan="6">
                        <div class="button_wrapper">
                            <button type="button" class="btn btn-success">
                                저장
                            </button>
                            <button type="button" class="btn btn-success">
                                삭제
                            </button>
                            <button type="button" class="btn btn-success">
                                초기화
                            </button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>

            <table class="table">
                <thead>
                <tr>
                    <th colspan="8">
                        하위 메뉴 등록
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td colspan="2">메뉴 명</td>
                    <td colspan="2">대표 URL</td>
                    <td colspan="2">노출 여부</td>
                    <td colspan="2">삭제</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <input type="text" name="menuName" class="form-control"
                                       id="menuName">
                            </div>
                        </div>
                    </td>
                    <td colspan="2">
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <input type="text" name="primaryUrl" class="form-control"
                                       id="primaryUrl">
                            </div>
                        </div>
                    </td>
                    <td colspan="2">
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="button" name="deleteBtn" class="btn btn-danger"
                                        id="deleteBtn">삭제
                                </button>
                            </div>
                        </div>
                    </td>
                    <td colspan="2">
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <select name="isExposed" class="form-control"
                                        id="isExposed">
                                    <option selected value="true">예</option>
                                    <option selected value="false">아니요</option>
                                </select>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td colspan="8">
                        <div class="button_wrapper">
                            <button type="button" class="btn btn-success">
                                저장
                            </button>
                            <button type="button" class="btn btn-success">
                                삭제
                            </button>
                            <button type="button" class="btn btn-success">
                                초기화
                            </button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="/static/js/menu/menu_main.js"></script>

</body>
</html>
