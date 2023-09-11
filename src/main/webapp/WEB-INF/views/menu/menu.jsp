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
<div class="container-fluid h-950">
    <div class="flex h-full">
        <aside class="w-full p-6 sm:w-80 dark:bg-gray-900 dark:text-gray-100">
            <nav class="space-y-6 text-xl">
                <ul class="relative m-0 list-none px-[0.2rem]">
                    <c:forEach var="menu" items="${menuList}">
                        <c:if test="${menu.depth == 1}">
                            <li class="relative"><a rel="space-y-2 ml-3"
                                                    onclick="getMenu('<c:out
                                                            value='${menu.menuCd }'/>')"><span>${menu.menuNm}</span></a>
                            </li>
                        </c:if>
                        <c:if test="${menu.depth == 2}">
                            <li class="relative">
                                <a
                                        class="flex h-6 ml-6 cursor-pointer items-center"
                                >${menu.menuNm}</a
                                >
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
            </nav>
        </aside>
        <div class="w-full mx-auto">
            <!-- 메뉴 -->
            <div class="w-full mx-auto">
                <!-- 메뉴 -->
                <div class="w-1/2 mx-auto bg-white shadow overflow-hidden sm:rounded-lg">
                    <div class="px-4 py-5 border-b border-gray-200 sm:px-6">
                        <h3 class="text-lg leading-6 font-medium text-gray-900">
                            메뉴 등록
                        </h3>
                    </div>
                    <div class="px-4 py-5 sm:p-6">
                        <form id="topMenuForm" method="post" action="/menu/save/topMenu">
                            <div class="mb-4">
                                <label
                                        for="topMenuCd"
                                        class="block text-sm font-medium text-gray-700">경로</label>
                                <input type="text"
                                       class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                       id="topMenuCd"
                                       disabled>
                            </div>
                            <div class="mb-4">
                                <label for="topMenuNm"
                                       class="block text-sm font-medium text-gray-700">메뉴 명</label>
                                <input type="text" name="topMenuNm"
                                       class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                       id="topMenuNm">
                            </div>
                            <div class="mb-4">
                                <label for="topLinkUrl"
                                       class="block text-sm font-medium text-gray-700">대표
                                    URL</label>
                                <input type="text" name="topLinkUrl"
                                       class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                       id="topLinkUrl">
                            </div>
                            <div class="mb-4">
                                <label for="topDisplYn"
                                       class="block text-sm font-medium text-gray-700">노출 여부</label>
                                <select name="topDisplYn"
                                        class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                        id="topDisplYn">
                                    <option value="Y">Y</option>
                                    <option value="N">N</option>
                                </select>
                            </div>
                            <input type="hidden" value="01" name="cateCd"/>
                            <input type="hidden" value="1" name="depth">
                            <div class="px-4 py-3 sm:px-6 flex justify-end">
                                <button type="submit"
                                        class="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded mr-2">
                                    저장
                                </button>
                                <button type="button"
                                        class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded mr-2">
                                    삭제
                                </button>
                                <button type="button"
                                        class="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded">
                                    초기화
                                </button>
                            </div>
                        </form>
                    </div>

                </div>

                <!-- 페이지 등록 -->
                <div class="w-2/3 mx-auto mt-5 justify-items-center bg-white p-4 bg-white shadow overflow-hidden sm:rounded-lg">

                    <div class="text-center py-3 border-b border-gray-200 sm:px-6">
                        <h3 class="text-lg leading-6 font-medium text-gray-900">
                            페이지 등록
                        </h3>
                    </div>
                    <div class="flex justify-center mt-3 text-center my-3">
                        <div class="w-full">페이지 명</div>
                        <div class="w-full">코드 설명</div>
                        <div class="w-full">삭제</div>
                    </div>
                    <div class="flex justify-center">
                        <div class="w-full">
                            <div class="mb-4 flex justify-center">
                                <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                                    <input type="text" name="pageName"
                                           class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                           id="pageName">
                                </div>
                            </div>
                        </div>
                        <div class="w-full">
                            <div class="mb-4 flex justify-center">
                                <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                                    <input type="text" name="pageName"
                                           class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                           id="pageName">
                                </div>
                            </div>
                        </div>
                        <div class="w-full">
                            <div class="mb-4">
                                <div class="mt-1 flex justify-center rounded-md ">
                                    <button type="button"
                                            class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded">
                                        삭제
                                    </button>
                                </div>
                            </div>
                            <div class="flex justify-center mt-5 space-x-4">
                                <button type="button"
                                        class="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded">
                                    저장
                                </button>
                                <button type="button"
                                        class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded">
                                    삭제
                                </button>
                                <button type="button"
                                        class="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded">
                                    초기화
                                </button>
                            </div>
                        </div>
                    </div>

                </div>

                <!-- 하위 메뉴 등록 -->
                <div class="w-full mx-auto mt-5 justify-items-center bg-white p-4 bg-white shadow overflow-hidden sm:rounded-lg"
                >

                    <div class="text-center py-3 border-b border-gray-200 sm:px-6">
                        <h3 class="text-lg leading-6 font-medium text-gray-900">
                            하위 메뉴 등록
                        </h3>
                    </div>
                    <div class="flex justify-center mt-3 text-center my-3">
                        <div class="w-full">메뉴 명</div>
                        <div class="w-full">대표 URL</div>
                        <div class="w-full">노출 여부</div>
                        <div class="w-full">삭제</div>
                    </div>
                    <div id="sub_menu_div" class="sub_menu_div">
                        <div class="flex justify-center">
                            <div class="w-full">
                                <div class="mb-4 flex justify-center">
                                    <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                                        <input type="text" name="pageName"
                                               class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                               id="pageName"
                                               disabled
                                        >
                                    </div>
                                </div>
                            </div>
                            <div class="w-full">
                                <div class="mb-4 flex justify-center">
                                    <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                                        <input type="text" name="pageName"
                                               class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                               id="pageName"
                                               disabled
                                        >
                                    </div>
                                </div>
                            </div>
                            <div class="w-full">
                                <div class="mb-4 flex justify-center">
                                    <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                                        <input type="text" name="pageName"
                                               class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                               id="pageName"
                                               disabled
                                        >
                                    </div>
                                </div>
                            </div>
                            <div class="w-full">
                                <div class="mb-4">
                                    <div class="mt-1 flex justify-center rounded-md ">
                                        <button type="button"
                                                class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded">
                                            삭제
                                        </button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="flex justify-center mt-5 space-x-4">


                        <button type="button"
                                class="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded"
                                id="add_menu_btn"
                        >
                            추가
                        </button>
                        <button type="button"
                                class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded"
                                id="save_sub_btn"
                        >
                            저장
                        </button>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <script src="/static/js/menu/menu_main.js"></script>
    <script id="add-code-row-template" type="text/template">
        <div class="flex justify-center" id="new_input_area">
            <div class="w-full">
                <div class="mb-4 flex justify-center">
                    <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                        <input type="text" name="subMenuNm"
                               class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                               id="subMenuNm">
                    </div>
                </div>
            </div>
            <div class="w-full">
                <div class="mb-4 flex justify-center">
                    <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                        <input type="text" name="subLinkUrl"
                               class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                               id="subLinkUrl">
                    </div>
                </div>
            </div>
            <div class="w-full">
                <div class="mb-4 flex justify-center">
                    <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                        <select name="subDisplYn" id="subDisplYn"
                                class="mt-1 p-2 block w-full rounded-md bg-gray-100">
                            <option value="Y" selected>Y</option>
                            <option value="N">N</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="w-full">
                <div class="mb-4">
                    <div class="mt-1 flex justify-center rounded-md ">
                        <button type="button"
                                class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded"
                                id="del_input_area"
                        >
                            삭제
                        </button>
                    </div>
                </div>

            </div>
        </div>
    </script>
    <script class="submenuTemplate" type="text/template">
        <div class="flex justify-center">
            <div class="w-full">
                <div class="mb-4 flex justify-center">
                    <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                        <input type="text" name="pageName"
                               class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                               id="pageName"
                               disabled
                        >
                    </div>
                </div>
            </div>
            <div class="w-full">
                <div class="mb-4 flex justify-center">
                    <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                        <input type="text" name="pageName"
                               class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                               id="pageName"
                               disabled
                        >
                    </div>
                </div>
            </div>
            <div class="w-full">
                <div class="mb-4 flex justify-center">
                    <div class="mt-1 w-2/3 rounded-md bg-gray-100 flex items-center">
                        <input type="text" name="pageName"
                               class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                               id="pageName"
                               disabled
                        >
                    </div>
                </div>
            </div>
            <div class="w-full">
                <div class="mb-4">
                    <div class="mt-1 flex justify-center rounded-md ">
                        <button type="button"
                                class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded">
                            삭제
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </script>
</body>
</html>
