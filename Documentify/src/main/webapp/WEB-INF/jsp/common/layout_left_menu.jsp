<%-- 
    Document   : layout_left_menu
    Created on : 06-Nov-2015, 14:22:53
    Author     : Russ
--%>

<%@include file="taglibs.jsp" %>

<s:layout-definition>
    <s:layout-render name="/WEB-INF/jsp/common/layout_menu.jsp" title="${title}" currentSection="${currentSection}">
        <s:layout-component name="body">
            <div id="left_menu">
                <s:layout-component name="menu">
                    <s:url var="url" beanclass="documentify.action.MenuViewHelper" prependContext="false">
                        <s:param name="currentSection" value="${currentSection}"/>
                    </s:url>
                    <jsp:include page="${url}"/>
                </s:layout-component>
            </div>
            <div id="main">
                ${body}
            </div>
        </s:layout-component>
    </s:layout-render>
</s:layout-definition>