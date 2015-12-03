<%-- 
    Document   : user_view
    Created on : 03-Dec-2015
    Author     : Russ
--%>

<%@include file="common/taglibs.jsp" %>

<s:layout-render name="common/layout_main.jsp" title="User Details">
    <s:layout-component name="body">
        <table class="view">
            <tr>
                <td><s:label for="user.id">:</s:label></td>
                <td class="value">${actionBean.user.id}</td>
            </tr>
            <tr>
                <td><s:label for="user.userName">:</s:label></td>
                <td class="value">${actionBean.user.userName}</td>
            </tr>
        </table>
        <p>
            <s:link beanclass="documentify.action.UserFormActionBean">
                <s:param name="user" value="${actionBean.user}"/>
                Update
            </s:link> |
            <s:link beanclass="documentify.action.UserListActionBean">
                Back to List
            </s:link>
        </p>
    </s:layout-component>
</s:layout-render>