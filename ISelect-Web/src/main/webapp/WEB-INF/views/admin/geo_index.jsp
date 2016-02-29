<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
    <thead>
        <tr>
            <th><spring:message code="msg.geo.country.code"/></th>
            <th><spring:message code="msg.geo.country.name"/></th>
            <th><spring:message code="msg.geo.country.phone"/></th>
            <th><spring:message code="msg.actions"/></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${countries}" var="country">
            <tr>
                <td>${country.countryCode}</td>
                <td>${country.countryName}</td>
                <td>${country.phoneCode}</td>
                <td>
                    <a href="<c:url value="./view/${country.id}"/>"><span class="glyphicon glyphicon-eye-open"></span></a>
                    <a href="<c:url value="./edit/${country.id}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="<c:url value="/geo/country/${country.id}/state/new"/>"><span class="glyphicon glyphicon-plus"></span></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>