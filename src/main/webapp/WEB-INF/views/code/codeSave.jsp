<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head></head>
<div class="h-950 flex m-6">
    <div class="col-md-12 h-80">
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
                        <label for="groupCd" class="col-sm-2 col-form-label">공통 코드</label>
                        <div class="col-sm-10">
                            <input type="text" name="groupCd" class="form-control" id="groupCd">
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <form>
                        <div class="form-group row">
                            <label for="groupCdNm" class="col-sm-2 col-form-label">공통 코드 명</label>
                            <div class="col-sm-10">
                                <input type="text" name="groupCdNm" class="form-control" id="groupCdNm">
                            </div>
                        </div>
                    </form>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <div class="form-group row">
                        <label for="displYn" class="col-sm-2 col-form-label">사용 여부</label>
                        <div class="col-sm-10">
                            <select name="displYn" class="form-control" id="displYn">
                                <option selected value="Y">예</option>
                                <option selected value="N">아니요</option>
                            </select>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <div class="form-group row">
                        <label for="descrt" class="col-sm-2 col-form-label">비고</label>
                        <div class="col-sm-10">
                            <input type="text" name="descrt" class="form-control" id="descrt">
                        </div>
                    </div>
                </td>
            </tr>

            </tbody>
        </table>
        <div class="flex space-x-4 justify-end">
            <button type="button"
                    class="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                    id="save_btn">
                저장
            </button>
            <button type="button"
                    class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                    onclick="goBackList('<c:out value="${referer}" />')"
            >
                목록
            </button>
        </div>
    </div>
</div>
<script src="/static/js/code/code-save-form.js"></script>
</body>
</html>

