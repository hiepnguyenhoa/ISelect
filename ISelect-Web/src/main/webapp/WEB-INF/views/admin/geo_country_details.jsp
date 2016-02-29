<%@ page import="com.iselect.kernal.web.ISelectControler"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-sm-12">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <form:form class="form-horizontal" role="form" modelAttribute="country">
        <input name="id" value="${country.id}" hidden>
        <div class="form-group">
            <div class="col-sm-3"> 
                <label class="control-label" for="countryCode"><spring:message code="msg.geo.country.code"/></label>
                <input <c:if test="${crudMode}">disabled</c:if> class="form-control" name="countryCode" placeholder="<spring:message code="msg.geo.country.code"/>" value="${country.countryCode}">
                <form:errors path="countryCode" cssClass="text-danger"/>
                </div>
                <div class="col-sm-7">
                    <label class="control-label" for="countryName"><spring:message code="msg.geo.country.name"/></label>
                <input <c:if test="${crudMode}">disabled</c:if> class="form-control" id="countryName" name="countryName" placeholder="<spring:message code="msg.geo.country.name"/>" value="${country.countryName}">
                </div>
                <div class="col-sm-2">
                    <label class="control-label" for="phoneCode"><spring:message code="msg.geo.country.phoneCode"/></label>
                <input <c:if test="${crudMode}">disabled</c:if> class="form-control" id="phoneCode" name="phoneCode" placeholder="<spring:message code="msg.geo.country.phoneCode"/>" value="${country.phoneCode}">
                </div>
            </div>
        <c:if test="${not crudMode}">
            <div class="form-group">        
                <div class="col-sm-offset-10 col-sm-12">
                    <button type="submit" class="btn btn-default"><spring:message code="btn.submit"/></button>
                </div>
            </div>
        </c:if>
    </form:form>
</div>
<c:if test="${crudMode}">
    <div class="col-sm-12">
        <table class="table">
            <thead>
                <tr>
                    <th><spring:message code="msg.geo.state.code"/></th>
                    <th><spring:message code="msg.geo.state.name"/></th>
                    <th><spring:message code="msg.actions"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${country.states}" var="state">
                    <tr>
                        <td>${state.stateCode}</td>
                        <td>${state.stateName}</td>
                        <td>
                            <span class="glyphicon glyphicon-eye-open"></span>
                            <span class="glyphicon glyphicon-pencil"></span>
                            <span class="glyphicon glyphicon-plus"></span>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
