<%-- 
    Document   : layout_main
    Created on : 03-Nov-2015, 17:06:05
    Updated on : 06-Nov-2015
    Author     : Russ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="taglibs.jsp" %>
<s:layout-definition>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>${title}</title>
            <link rel="stylesheet" type="text/css"
                  href="${contextPath}/css/style.css">
        </head>
        <body>
            <div id="header">
                <span class="title">${title}</span>
                <span class="menu">
                    <s:layout-component name="menu">
                        Welcome to Documentify
                    </s:layout-component>
                </span>
            </div>
            <s:messages/>
            <div id="body">
                <s:layout-component name="body"/>
            </div>
        </body>
    </html>
</s:layout-definition>