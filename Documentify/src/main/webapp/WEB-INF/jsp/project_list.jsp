<%-- 
    Document   : project_list
    Created on : 06-Nov-2015
    Author     : Russ
--%>
<%@include file="common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/layout_menu.jsp"
  title="Project List" currentSection="ProjectList">
    <s:layout-component name="body">
        <s:link beanclass="documentify.action.ProjectFormActionBean">
            Create a New Project
        </s:link>
            <p></p>
        <d:table name="${actionBean.projects}" id="aProject" requestURI="" defaultsort="1">
            <d:column title="Project ID" property="id" sortable="true"/>
            <d:column title="Project Name" property="projectName" sortable="true"/>
            <%--<d:column title="Date Requested" property="dateOfRequest" sortable="true" format="{0,date,dd/MM/yyyy}"/>--%>
            <%--<d:column title="Points Available" property="pointsWorth" sortable="true"/>--%>
            <d:column title="Actions">
                <s:link beanclass="documentify.action.ProjectListActionBean" event="view">
                    <s:param name="project" value="${aProject}"/>View
                </s:link> |
                <s:link beanclass="documentify.action.ProjectFormActionBean">
                    <s:param name="project" value="${aProject}"/>Update
                </s:link> |
                <s:link beanclass="documentify.action.ProjectListActionBean" event="delete" onclick="return confirm('Delete project ID = ${aProject}?');">
                    <s:param name="project" value="${aProject}"/>Delete
                </s:link>
            </d:column>
        </d:table>
    </s:layout-component>
</s:layout-render>
