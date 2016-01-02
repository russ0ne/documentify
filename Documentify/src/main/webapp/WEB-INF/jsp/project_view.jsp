<%-- 
    Document   : project_view
    Created on : 06-Nov-2015
    Author     : Russ
--%>

<%@include file="common/taglibs.jsp"%>

<s:layout-render name="common/layout_main.jsp" title="Project Details">
	<s:layout-component name="body">
		<table class="view">
			<tr>
				<td><s:label for="project.id">:</s:label></td>
				<td class="value">${actionBean.project.id}</td>
			</tr>
			<tr>
				<td><s:label for="project.projectName">:</s:label></td>
				<td class="value">${actionBean.project.projectName}</td>
			</tr>
		</table>
		<p>
			<s:link beanclass="documentify.action.ProjectFormActionBean">
				<s:param name="project" value="${actionBean.project}" />
                Update
            </s:link>
			|
			<s:link beanclass="documentify.action.ProjectListActionBean">
                Back to List
            </s:link>
		</p>
	</s:layout-component>
</s:layout-render>