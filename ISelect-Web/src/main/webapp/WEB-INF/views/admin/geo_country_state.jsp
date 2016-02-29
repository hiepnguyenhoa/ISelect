<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="form-group">
    <div class="col-sm-3"> 
        <label class="control-label" for="countryCode"><spring:message code="msg.geo.country.code"/></label>
        <input disabled class="form-control" name="countryCode" value="${country.countryCode}">
    </div>
    <div class="col-sm-9">
        <label class="control-label" for="countryName"><spring:message code="msg.geo.country.name"/></label>
        <input disabled class="form-control" id="countryName" name="countryName" value="${country.countryName}">
    </div>
</div>
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
                    <a href="<c:url value="./view?id=${country.id}"/>"><span class="glyphicon glyphicon-eye-open"></span></a>
                    <a href="<c:url value="./edit?id=${country.id}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="<c:url value="/geo/state/new?id=${country.id}"/>"><span class="glyphicon glyphicon-plus"></span></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<form:form class="form-horizontal" role="form" modelAttribute="state">
    <input name="country.id" value="${country.id}" hidden>
    <div class="form-group">
        <div class="col-sm-3"> 
            <label class="control-label" for="stateCode"><spring:message code="msg.geo.state.code"/></label>
            <input <c:if test="${ISelectControler.CRUD_MODEL}">disabled</c:if> class="form-control" name="stateCode" placeholder="<spring:message code="msg.geo.state.code"/>" value="${state.stateCode}">
            </div>
            <div class="col-sm-9">
                <label class="control-label" for="stateName"><spring:message code="msg.geo.state.name"/></label>
            <input class="form-control" id="countryName" name="stateName" placeholder="<spring:message code="msg.geo.state.name"/>" value="${state.stateName}">
        </div>
    </div>
    <div class="form-group">        
        <div class="col-sm-offset-10 col-sm-12">
            <button type="submit" class="btn btn-default"><spring:message code="btn.submit"/></button>
        </div>
    </div>
</form:form>