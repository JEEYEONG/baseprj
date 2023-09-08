<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html>
<head></head>
<body>
<nav class="border-gray-200 px-2 h-auto mt-10 mb-10">
    <div
            class="container mx-auto h-full flex flex-wrap items-center justify-between"
    >
        <a href="#" class="flex">
            <svg
                    class="h-10 mr-3"
                    width="51"
                    height="70"
                    viewBox="0 0 51 70"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
            >
            </svg>
            <span class="self-center text-4xl  font-semibold whitespace-nowrap"
            >ImcoreSoft</span
            >
        </a>
        <div class="flex md:order-2">
            <div class="relative mr-3 md:mr-0 hidden md:block">


            </div>
            <button
                    data-collapse-toggle="mobile-menu-3"
                    type="button"
                    class="md:hidden text-gray-400 hover:text-gray-900 focus:outline-none focus:ring-2 focus:ring-blue-300 rounded-lg inline-flex items-center justify-center"
                    aria-controls="mobile-menu-3"
                    aria-expanded="false"
            >
                <span class="sr-only">Open main menu</span>
                <svg
                        class="w-6 h-6"
                        fill="currentColor"
                        viewBox="0 0 20 20"
                        xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                            fill-rule="evenodd"
                            d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                            clip-rule="evenodd"
                    ></path>
                </svg>
                <svg
                        class="hidden w-6 h-6"
                        fill="currentColor"
                        viewBox="0 0 20 20"
                        xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                            fill-rule="evenodd"
                            d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                            clip-rule="evenodd"
                    ></path>
                </svg>
            </button>
        </div>
        <div class="order-2 md:order-3 flex flex-wrap items-center justify-end mr-0 md:mr-4"
             id="nav-content">
            <div class="auth flex items-center w-full md:w-full">
                <button
                        type="button"
                        class="inline-block rounded bg-danger px-6 pb-2 pt-2.5 text-2xl font-medium uppercase leading-normal text-white shadow-[0_4px_9px_-4px_#dc4c64] transition duration-150 ease-in-out hover:bg-danger-600 hover:shadow-[0_8px_9px_-4px_rgba(220,76,100,0.3),0_4px_18px_0_rgba(220,76,100,0.2)] focus:bg-danger-600 focus:shadow-[0_8px_9px_-4px_rgba(220,76,100,0.3),0_4px_18px_0_rgba(220,76,100,0.2)] focus:outline-none focus:ring-0 active:bg-danger-700 active:shadow-[0_8px_9px_-4px_rgba(220,76,100,0.3),0_4px_18px_0_rgba(220,76,100,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(220,76,100,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(220,76,100,0.2),0_4px_18px_0_rgba(220,76,100,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(220,76,100,0.2),0_4px_18px_0_rgba(220,76,100,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(220,76,100,0.2),0_4px_18px_0_rgba(220,76,100,0.1)]">
                    Logout
                </button>
            </div>
        </div>
        <div
                class="hidden md:flex justify-between items-center w-full md:w-auto md:order-1"
                id="mobile-menu-3"
        >
            <ul
                    class="flex-col md:flex-row flex md:space-x-8 mt-4 md:mt-0 md:text-sm md:font-medium"
            >
                <li>
                    <a
                            href="#"
                            class="bg-blue-700 md:bg-transparent text-white block pl-3 pr-4 py-2 md:text-blue-700 md:p-0 rounded"
                            aria-current="page"
                    >Home</a
                    >
                </li>
                <li>
                    <a
                            href="#"
                            class="text-gray-700 hover:bg-gray-50 text-2xl border-b border-gray-100 md:hover:bg-transparent md:border-0 block pl-3 pr-4 py-2 md:hover:text-blue-700 md:p-0"
                    >About</a
                    >
                </li>
                <li>
                    <a
                            href="#"
                            class="text-gray-700 hover:bg-gray-50 text-2xl border-b border-gray-100 md:hover:bg-transparent md:border-0 block pl-3 pr-4 py-2 md:hover:text-blue-700 md:p-0"
                    >Services</a
                    >
                </li>
                <li>
                    <a
                            href="<c:url value='code/codeList'/> "
                            class="text-gray-700 hover:bg-gray-50 text-2xl border-b border-gray-100 md:hover:bg-transparent md:border-0 block pl-3 pr-4 py-2 md:hover:text-blue-700 md:p-0"
                    >공통 코드</a
                    >
                </li>
                <li>
                    <a
                            href="<c:url value='/menu'/> "
                            class="text-gray-700 hover:bg-gray-50 text-2xl border-b border-gray-100 md:hover:bg-transparent md:border-0 block pl-3 pr-4 py-2 md:hover:text-blue-700 md:p-0"
                    >메뉴 관리</a
                    >
                </li>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>

