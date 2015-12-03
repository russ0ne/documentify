<%-- 
    Document   : user_form
    Created on : 03-Dec-2015
    Author     : Russ
--%>

<%@include file="common/taglibs.jsp" %>

<s:layout-render name="common/layout_main.jsp" title="User Details">
    <s:layout-component name="body">
        <s:form beanclass="documentify.action.UserFormActionBean">
            <s:errors/>
            <div><s:hidden name="user"/></div>
            <table class="form">
                <tr>
                    <td><s:label for="user.id">:</s:label></td>
                    <td>${empty actionBean.user.id ? "n/a" : actionBean.user.id}</td>
                </tr>
                <tr>
                    <td><s:label for="user.userName">:</s:label></td>
                    <td><s:text name="user.userName"/></td>
                    <td><s:errors field="user.userName"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <s:submit name="save" value="Save"/>
                        <s:submit name="cancel" value="Cancel"/>
                    </td>
                </tr>
            </table>
        </s:form>
    </s:layout-component>
</s:layout-render>
