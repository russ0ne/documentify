<%-- 
    Document   : request_list
    Created on : 03-Nov-2015
    Author     : Russ
--%>
<%@include file="common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_menu.jsp"
	title="Request List" currentSection="RequestList">
	<s:layout-component name="body">
		<s:link beanclass="documentify.action.RequestFormActionBean">
            Create a New Request
        </s:link>
		<p></p>
		<d:table name="${actionBean.requests}" id="aRequest" requestURI=""
			defaultsort="1">
			<d:column title="Request ID" property="id" sortable="true" />
			<d:column title="Request Title" property="requestTitle"
				sortable="true" maxLength="100" />
			<d:column title="Project Name" property="project" sortable="true" />
			<d:column title="Date Requested" property="dateOfRequest"
				sortable="true" format="{0,date,dd/MM/yyyy}" />
			<d:column title="Points Available" property="pointsWorth"
				sortable="true" />
			<d:column title="Due Date" property="reviewDate" sortable="true"
				format="{0,date,dd/MM/yyyy}" />
			<d:column title="Status" property="status" sortable="true" />
			<d:column title="Actions">
				<s:link beanclass="documentify.action.RequestListActionBean"
					event="view">
					<s:param name="request" value="${aRequest}" />View Details
                </s:link> |
                <s:link
					beanclass="documentify.action.RequestFormActionBean">
					<s:param name="request" value="${aRequest}" />Update
                </s:link> |
                <s:link
					beanclass="documentify.action.RequestListActionBean" event="delete"
					onclick="return confirm('Delete request ID = ${aRequest}?');">
					<s:param name="request" value="${aRequest}" />Delete
                </s:link>
			</d:column>
		</d:table>
	</s:layout-component>
</s:layout-render>
