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
            <nav class="space-y-8 text-xl">
                <div class="space-y-2">
                    <h2 class="text-2xl font-semibold tracki uppercase dark:text-gray-400">Getting
                        Started</h2>
                    <div class="flex flex-col space-y-2 ml-3">
                        <a rel="noopener noreferrer" href="#">Installation</a>
                        <a rel="noopener noreferrer" href="#">Plugins</a>
                        <a rel="noopener noreferrer" href="#">Migrations</a>
                        <a rel="noopener noreferrer" href="#">Appearance</a>
                        <a rel="noopener noreferrer" href="#">Mamba UI</a>
                    </div>
                </div>

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
                        <form>
                            <div class="mb-4">
                                <label for="menuNm" class="block text-sm font-medium text-gray-700">메뉴 명</label>
                                <input type="text" name="menuNm"
                                       class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                       id="menuNm">
                            </div>
                            <div class="mb-4">
                                <label for="linkUrl"
                                       class="block text-sm font-medium text-gray-700">대표
                                    URL</label>
                                <input type="text" name="linkUrl"
                                       class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                       id="linkUrl">
                            </div>
                            <div class="mb-4">
                                <label for="displYn"
                                       class="block text-sm font-medium text-gray-700">노출 여부</label>
                                <select name="displYn"
                                        class="mt-1 p-2 block w-full rounded-md bg-gray-100"
                                        id="displYn">
                                    <option value="Y">ROOT</option>
                                    <option value="N">ADMIN</option>
                                    <option value="">USER</option>
                                </select>
                            </div>
                        </form>
                    </div>
                    <div class="px-4 py-3 sm:px-6 flex justify-end">
                        <button type="button"
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
                <div class="w-full mx-auto mt-5 justify-items-center bg-white p-4 bg-white shadow overflow-hidden sm:rounded-lg">

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
            </div>

    </div>
</div>
<script src="/static/js/menu/menu_main.js"></script>
</body>
</html>
