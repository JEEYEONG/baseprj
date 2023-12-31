<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="grid grid-rows-1 h-full flex m-6">
    <div class=" col-md-12 h-100">
        <table class="table">
            <thead>
            <tr>
                <th colspan="4">
                    Menu
                </th>
            </tr>
            </thead>
            <tbody id="groupCd_tbody">
            <tr>
                <td colspan="4">
                    <div class="form-group row">
                        <label for="groupCd" class="col-sm-2 col-form-label">구분 코드</label>
                        <div class="col-sm-10">
                            <input type="text" name="groupCd" class="form-control" id="groupCd" readonly
                                   value="${groupCode.groupCd}">
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <form>
                        <div class="form-group row">
                            <label for="groupCdNm" class="col-sm-2 col-form-label">구분 코드 명</label>
                            <div class="col-sm-10">
                                <input type="text" name="groupCdNm" class="form-control" id="groupCdNm"
                                       value="${groupCode.groupCdNm}">
                            </div>
                        </div>
                    </form>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <div class="form-group row">
                        <label for="delYn" class="col-sm-2 col-form-label">삭제 여부</label>
                        <div class="col-sm-10">
                            <select name="groupCd_delYn" class="form-control" id="delYn">
                                <c:if test="${groupCode.delYn.equals('Y')}">
                                    <option selected value="Y">Y</option>
                                    <option value="N">N</option>
                                </c:if>
                                <c:if test="${groupCode.delYn.equals('N')}">
                                    <option selected value="N">N</option>
                                    <option value="Y">Y</option>
                                </c:if>
                            </select>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <div class="form-group row">
                        <label for="groupCd_descrt" class="col-sm-2 col-form-label">비고</label>
                        <div class="col-sm-10">
                            <input type="text" name="descrt" class="form-control" id="groupCd_descrt"
                                   value="${groupCode.descrt}">
                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="flex space-x-4 justify-end">
            <button type="button"
                    class="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                    data-group-cd="${groupCode.groupCd}"
                    data-page="${param.get('page') ? param.get('page') : 1}"
                    id="mod_btn">
                저장
            </button>
            <button type="button"
                    class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                    onclick="location.href='/code/codeList';"
            >
                목록
            </button>
        </div>
        <table class="min-w-max w-full table-auto mt-5">
            <thead>
            <tr class="bg-gray-200 text-gray-600 uppercase text-sm leading-normal">
                <th class="py-3 px-6 text-left">코드</th>
                <th class="py-3 px-6 text-left">코드명</th>
                <th class="py-3 px-6 text-center">삭제 여부</th>
                <th class="py-3 px-6 text-center">비고</th>
                <th class="py-3 px-6 text-center"></th>
            </tr>
            </thead>
            <tbody class="text-gray-600 text-sm font-light">
            <c:if test="${stCodeList != null}">
                <c:forEach var="stCode" items="${stCodeList}">
                    <tr class="border-b border-gray-200 hover:bg-gray-100">
                        <td class="py-3 px-6 text-left whitespace-nowrap">
                            <div class="flex items-center">
                                <div class="mr-2">
                                    <path
                                            fill="#80deea"
                                            d="M24,34C11.1,34,1,29.6,1,24c0-5.6,10.1-10,23-10c12.9,0,23,4.4,23,10C47,29.6,36.9,34,24,34z M24,16	c-12.6,0-21,4.1-21,8c0,3.9,8.4,8,21,8s21-4.1,21-8C45,20.1,36.6,16,24,16z"
                                    >
                                    </path>
                                    <path
                                            fill="#80deea"
                                            d="M15.1,44.6c-1,0-1.8-0.2-2.6-0.7C7.6,41.1,8.9,30.2,15.3,19l0,0c3-5.2,6.7-9.6,10.3-12.4c3.9-3,7.4-3.9,9.8-2.5	c2.5,1.4,3.4,4.9,2.8,9.8c-0.6,4.6-2.6,10-5.6,15.2c-3,5.2-6.7,9.6-10.3,12.4C19.7,43.5,17.2,44.6,15.1,44.6z M32.9,5.4	c-1.6,0-3.7,0.9-6,2.7c-3.4,2.7-6.9,6.9-9.8,11.9l0,0c-6.3,10.9-6.9,20.3-3.6,22.2c1.7,1,4.5,0.1,7.6-2.3c3.4-2.7,6.9-6.9,9.8-11.9	c2.9-5,4.8-10.1,5.4-14.4c0.5-4-0.1-6.8-1.8-7.8C34,5.6,33.5,5.4,32.9,5.4z"
                                    >
                                    </path>
                                    <path
                                            fill="#80deea"
                                            d="M33,44.6c-5,0-12.2-6.1-17.6-15.6C8.9,17.8,7.6,6.9,12.5,4.1l0,0C17.4,1.3,26.2,7.8,32.7,19	c3,5.2,5,10.6,5.6,15.2c0.7,4.9-0.3,8.3-2.8,9.8C34.7,44.4,33.9,44.6,33,44.6z M13.5,5.8c-3.3,1.9-2.7,11.3,3.6,22.2	c6.3,10.9,14.1,16.1,17.4,14.2c1.7-1,2.3-3.8,1.8-7.8c-0.6-4.3-2.5-9.4-5.4-14.4C24.6,9.1,16.8,3.9,13.5,5.8L13.5,5.8z"
                                    >
                                    </path>
                                    <circle cx="24" cy="24" r="4" fill="#80deea"></circle>
                                </div>
                                <span class="font-medium">${stCode.cd}</span>
                            </div>
                        </td>
                        <td class="py-3 px-6 text-left">
                            <div class="flex items-center">
                                <div class="mr-2"></div>
                                <span>${stCode.stCdNm}</span>
                            </div>
                        </td>
                        <td class="py-3 px-6 text-center">
                            <div class="flex items-center justify-center">
                                <span>${stCode.delYn}</span>
                            </div>
                        </td>
                        <td class="py-3 px-6 text-center">
                                ${stCode.descrt}
                        </td>
                        <td class="py-3 px-6 text-center">
                            <button type="button"
                                    data-cd="${stCode.cd}"
                                    data-group-cd="${stCode.groupCd}"
                                    data-page="${param.get('page') ? param.get('page') : 1}"
                                    class="delete-code-row-btn bg-red-500 hover:bg-red-600 text-white font-bold py-1 px-2 rounded"
                                    id="del_btn"
                            >
                                삭제
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
        <div class="flex justify-center bg-white p-4 rounded-xl">
            <ul class="flex items-center -mx-[6px]">
                <c:if test="${ph.showPrev}  ">
                    <li class="px-[6px]">
                        <a
                                href="javascript:void(0)"
                                class="w-9 h-9 flex items-center justify-center rounded-md border border-[#EDEFF1] text-[#838995] text-base hover:bg-primary hover:border-primary hover:text-white"
                        >
          <span>
            <svg
                    width="8"
                    height="15"
                    viewBox="0 0 8 15"
                    class="fill-current stroke-current"
            >
              <path
                      d="M7.12979 1.91389L7.1299 1.914L7.1344 1.90875C7.31476 1.69833 7.31528 1.36878 7.1047 1.15819C7.01062 1.06412 6.86296 1.00488 6.73613 1.00488C6.57736 1.00488 6.4537 1.07206 6.34569 1.18007L6.34564 1.18001L6.34229 1.18358L0.830207 7.06752C0.830152 7.06757 0.830098 7.06763 0.830043 7.06769C0.402311 7.52078 0.406126 8.26524 0.827473 8.73615L0.827439 8.73618L0.829982 8.73889L6.34248 14.6014L6.34243 14.6014L6.34569 14.6047C6.546 14.805 6.88221 14.8491 7.1047 14.6266C7.30447 14.4268 7.34883 14.0918 7.12833 13.8693L1.62078 8.01209C1.55579 7.93114 1.56859 7.82519 1.61408 7.7797L1.61413 7.77975L1.61729 7.77639L7.12979 1.91389Z"
                      stroke-width="0.3"
              ></path>
            </svg>
          </span>
                        </a>
                    </li>
                </c:if>
                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                    <li class="px-[6px]">
                        <a
                                href="<c:url value="/code/${groupCd}${ph.sc.getQueryString(i)}"/>"
                                class="w-9 h-9 flex items-center justify-center rounded-md border border-[#EDEFF1] text-[#838995] text-base hover:bg-primary hover:border-primary hover:text-white"
                        >
                                ${i}
                        </a>
                    </li>
                </c:forEach>
                <c:if test="${ph.showNext}">
                    <li class="px-[6px]">
                        <a
                                href="javascript:void(0)"
                                class="w-9 h-9 flex items-center justify-center rounded-md border border-[#EDEFF1] text-[#838995] text-base hover:bg-primary hover:border-primary hover:text-white"
                        >
          <span>
            <svg
                    width="8"
                    height="15"
                    viewBox="0 0 8 15"
                    class="fill-current stroke-current"
            >
              <path
                      d="M0.870212 13.0861L0.870097 13.086L0.865602 13.0912C0.685237 13.3017 0.684716 13.6312 0.895299 13.8418C0.989374 13.9359 1.13704 13.9951 1.26387 13.9951C1.42264 13.9951 1.5463 13.9279 1.65431 13.8199L1.65436 13.82L1.65771 13.8164L7.16979 7.93248C7.16985 7.93243 7.1699 7.93237 7.16996 7.93231C7.59769 7.47923 7.59387 6.73477 7.17253 6.26385L7.17256 6.26382L7.17002 6.26111L1.65752 0.398611L1.65757 0.398563L1.65431 0.395299C1.454 0.194997 1.11779 0.150934 0.895299 0.373424C0.695526 0.573197 0.651169 0.908167 0.871667 1.13067L6.37922 6.98791C6.4442 7.06886 6.43141 7.17481 6.38592 7.2203L6.38587 7.22025L6.38271 7.22361L0.870212 13.0861Z"
                      stroke-width="0.3"
              ></path>
            </svg>
          </span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
        <div class="flex space-x-4 justify-end">
            <button type="button"
                    class="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                    id="add_code_btn">코드 추가
            </button>
            <button type="button"
                    class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                    id="save_code_btn"
            >
                코드 저장
            </button>
        </div>


    </div>
</div>
<script id="add-code-row-template" type="text/template">
    <tr class="add-code-row border-b border-gray-200 hover:bg-gray-100">
        <td class="py-3 px-6 text-left whitespace-nowrap">
            <input type="text" name="cd" class="form-control">
        </td>
        <td class="py-3 px-6 text-left">
            <input type="text" name="stCdNm" class="form-control">
        </td>
        <td class="py-3 px-6 text-center">
            <select name="delYn" class="form-control">
                <option value="Y">Y</option>
                <option value="N">N</option>
            </select>
        </td>
        <td class="py-3 px-6 text-center">
            <input type="text" name="descrt" class="form-control" id="stCd_descrt">
        </td>
        <td class="py-3 px-6 text-center">
            <button type="button"
                    class="delete-code-row-btn bg-red-500 hover:bg-red-600 text-white font-bold py-1 px-2 rounded"
                    id="del_input_area"
            >
                삭제
            </button>
        </td>
    </tr>
</script>

<script src="/static/js/code/code-detail-form.js"></script>
</body>
</html>
