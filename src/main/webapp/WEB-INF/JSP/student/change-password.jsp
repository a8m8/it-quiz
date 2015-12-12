<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<ul id="main-nav" class="student">
    <li id="firsttab">
        <a href="${context }/student/myaccount">My account</a>
    <li id="secondtab">
        <a href="${context }/student/tests">Tests</a>
    <li id="thirdtab">
        <a href="${context }/student/tests-result">Tests result</a>
</ul>

<jsp:include page="../templates/change-password.jsp"/>