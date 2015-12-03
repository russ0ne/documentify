<%-- 
    Document   : user_list
    Created on : 03-Dec-2015
    Author     : Russ
--%>
<%@include file="common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/layout_menu.jsp"
  title="User List" currentSection="UserList">
    <s:layout-component name="body">
        <s:link beanclass="documentify.action.UserFormActionBean">
            Create a New User
        </s:link>
            <p></p>
        <d:table name="${actionBean.users}" id="aUser" requestURI="" defaultsort="1">
            <d:column title="User ID" property="id" sortable="true"/>
            <d:column title="User Name" property="userName" sortable="true"/>
            <%--<d:column title="Date Requested" property="dateOfRequest" sortable="true" format="{0,date,dd/MM/yyyy}"/>--%>
            <%--<d:column title="Points Available" property="pointsWorth" sortable="true"/>--%>
            <d:column title="Actions">
                <s:link beanclass="documentify.action.UserListActionBean" event="view">
                    <s:param name="user" value="${aUser}"/>View
                </s:link> |
                <s:link beanclass="documentify.action.UserFormActionBean">
                    <s:param name="user" value="${aUser}"/>Update
                </s:link> |
                <s:link beanclass="documentify.action.UserListActionBean" event="delete" onclick="return confirm('Delete user ID = ${aUser}?');">
                    <s:param name="user" value="${aUser}"/>Delete
                </s:link>
            </d:column>
        </d:table>
    </s:layout-component>
</s:layout-render>
