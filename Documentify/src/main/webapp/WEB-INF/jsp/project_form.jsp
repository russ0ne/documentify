<%-- 
    Document   : project_form
    Created on : 06-Nov-2015
    Author     : Russ
--%>

<%@include file="common/taglibs.jsp" %>

<s:layout-render name="common/layout_main.jsp" title="Project Details">
    <s:layout-component name="body">
        <s:form beanclass="documentify.action.ProjectFormActionBean">
            <s:errors/>
            <div><s:hidden name="project"/></div>
            <table class="form">
                <tr>
                    <td><s:label for="project.id">:</s:label></td>
                    <td>${empty actionBean.project.id ? "n/a" : actionBean.project.id}</td>
                </tr>
                <tr>
                    <td><s:label for="project.projectName">:</s:label></td>
                    <td><s:text name="project.projectName"/></td>
                    <td><s:errors field="project.projectName"/></td>
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
