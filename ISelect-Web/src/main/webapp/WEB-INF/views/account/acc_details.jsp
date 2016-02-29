<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form:form class="form-horizontal" role="form" modelAttribute="account">
    <div class="form-group">
        <div class="col-sm-12"> 
            <label class="control-label" for="username"><spring:message code="msg.username"/></label>
            <input type="text" class="form-control" name="username" placeholder="<spring:message code="msg.username"/>" value="${account.username}">
            <form:errors path="username" cssClass="text-danger"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-6"> 
            <label class="control-label" for="password"><spring:message code="msg.password"/></label>
            <input type="password" class="form-control" name="password" placeholder="<spring:message code="msg.password"/>" value="${account.password}">
        </div>
        <div class="col-sm-6">
            <label class="control-label" for="password2"><spring:message code="msg.password.retype"/></label>
            <input type="password" class="form-control" id="password2" placeholder="<spring:message code="msg.password.retype"/>" value="${account.password}">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2 dropdown">
            <label class="control-label" for="suffix"><spring:message code="msg.prof.suffix"/></label>
            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" id="suffix" name="profile.suffix">Select
                <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="#">HTML</a></li>
                <li><a href="#">CSS</a></li>
                <li><a href="#">JavaScript</a></li>
                <li class="divider"></li>
                <li><a href="#">About Us</a></li>
            </ul>
        </div>
        <div class="col-sm-4"> 
            <label class="control-label" for="fName"><spring:message code="msg.prof.first_name"/></label>
            <input type="text" class="form-control" id="fName" name="profile.firstName" placeholder="<spring:message code="msg.prof.first_name"/>" value="${account.profile.firstName}">
        </div>
        <div class="col-sm-2"> 
            <label class="control-label" for="mName"><spring:message code="msg.prof.middle_name"/></label>
            <input type="text" class="form-control" id="mName" name="profile.middleName" placeholder="<spring:message code="msg.prof.middle_name"/>" value="${account.profile.middleName}">
        </div>
        <div class="col-sm-4"> 
            <label class="control-label" for="lName"><spring:message code="msg.prof.last_name"/></label>
            <input type="text" class="form-control" id="lName" name="profile.lastName" placeholder="<spring:message code="msg.prof.last_name"/>" value="${account.profile.lastName}">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-6"> 
            <label class="control-label" for="email"><spring:message code="msg.prof.email"/></label>
            <input type="text" class="form-control" id="email" name="profile.email" placeholder="<spring:message code="msg.prof.email"/>" value="${account.profile.email}">
        </div>
    </div>
    <div class="form-group">        
        <div class="col-sm-offset-10 col-sm-12">
            <button type="submit" class="btn btn-default"><spring:message code="btn.submit"/></button>
        </div>
    </div>
</form:form>
