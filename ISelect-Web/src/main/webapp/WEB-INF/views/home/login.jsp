<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form:form class="form-horizontal" role="form" modelAttribute="account">
    <div class="form-group">
        <div class="col-sm-12"> 
            <label class="control-label" for="username"><spring:message code="msg.username"/></label>
            <input type="text" class="form-control" name="username" placeholder="<spring:message code="msg.username"/>" value="${account.userName}">
            <form:errors path="userName" cssClass="text-danger"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-6"> 
            <label class="control-label" for="password"><spring:message code="msg.password"/></label>
            <input type="password" class="form-control" name="password" placeholder="<spring:message code="msg.password"/>" value="${account.password}">
        </div>
    </div>
    <div class="form-group">        
        <div class="col-sm-offset-10 col-sm-12">
            <button type="submit" class="btn btn-default"><spring:message code="btn.submit"/></button>
        </div>
    </div>
</form:form>
