<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>i-Select</title>

        <script src="<c:url value='/resources/js/jquery-1.11.3.min.js' />" ></script>
        <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
        <script src="<c:url value='/resources/js/bootstrap.min.js' />" ></script>
        <link href="<c:url value='/resources/css/font-awesome.min.css' />" rel="stylesheet">
        <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <tiles:insertAttribute name = "menubar"/>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <tiles:insertAttribute name = "sidebar"/>
                </div>
                <div class="col-sm-8">
                    <tiles:insertAttribute name = "body"/>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <tiles:insertAttribute name = "footer" />
                </div>
            </div>
        </div>
    </body>
</html>
