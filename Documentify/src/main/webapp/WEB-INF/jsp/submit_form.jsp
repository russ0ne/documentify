<%-- 
    Document   : request_form
    Created on : 04-Nov-2015, 12:01:27
    Author     : Russ
--%>

<%@include file="common/taglibs.jsp" %>
<jsp:useBean class="documentify.view.ProjectsViewHelper" id="projects"/>
<jsp:useBean class="documentify.view.UsersViewHelper" id="users"/>

<s:layout-render name="common/layout_main.jsp" title="Submission">
    <s:layout-component name="body">
        <s:form beanclass="documentify.action.SubmissionFormActionBean">
            <s:errors/>
            <div><s:hidden name="submission"/></div>
            <table class="form">
                <tr>
                    <td><s:label for="submission.body"></s:label></td>
                        <td>
                        <s:textarea name="submission.body"/>
                    </td>
                    <td><s:errors field="submission.body"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <s:submit name="submit" value="Submit"/>
                        <s:submit name="cancel" value="Cancel"/>
                    </td>
                </tr>
            </table>
        </s:form>
    </s:layout-component>
</s:layout-render>
