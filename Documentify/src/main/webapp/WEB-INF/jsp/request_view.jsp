<%-- 
    Document   : request_view
    Created on : 04-Nov-2015, 11:05:35
    Author     : Russ
--%>

<%@include file="common/taglibs.jsp" %>

<s:layout-render name="common/layout_main.jsp" title="Request Details">
    <s:layout-component name="body">
        <table class="view">
            <tr>
                <td><s:label for="request.id">:</s:label></td>
                <td class="value">${actionBean.request.id}</td>
            </tr>
            <tr>
                <td><s:label for="request.requestTitle">:</s:label></td>
                <td class="value">${actionBean.request.requestTitle}</td>
            </tr>
            <tr>
                <td><s:label for="request.requestDesc">:</s:label></td>
                <td class="value">${actionBean.request.requestDesc}</td>
            </tr>
            <tr>
                <td><s:label for="request.project">:</s:label></td>
                <td class="value">${actionBean.request.project}</td>
            </tr>
            <tr>
                <td><s:label for="request.dateOfRequest">:</s:label></td>
                    <td class="value">
                    <s:format value="${actionBean.request.dateOfRequest}" formatPattern="dd/MM/yyyy"/>
                </td>
            </tr>
            <tr>
                <td><s:label for="request.reviewDate">:</s:label></td>
                    <td class="value">
                    <s:format value="${actionBean.request.reviewDate}" formatPattern="dd/MM/yyyy"/>
                </td>
            </tr>
            <tr>
                <td><s:label for="request.pointsWorth">:</s:label></td>
                <td class="value">${actionBean.request.pointsWorth}</td>
            </tr>
            <tr>
                <td><s:label for="request.assignedPriority">:</s:label></td>
                <td class="value">${actionBean.request.assignedPriority}</td>
            </tr>
            <tr>
                <td><s:label for="request.status">:</s:label></td>
                <td class="value">${actionBean.request.status}</td>
            </tr>
            <tr>
                <td><s:label for="request.requester">:</s:label></td>
                <td class="value">${actionBean.request.requester}</td>
            </tr>
            <tr>
                <td><s:label for="request.comments">:</s:label></td>
                <td class="value">${actionBean.request.comments}</td>
            </tr>
        </table>
        <p>
            <s:link beanclass="documentify.action.RequestFormActionBean">
                <s:param name="request" value="${actionBean.request}"/>
                Update
            </s:link> |
            <s:link beanclass="documentify.action.SubmissionFormActionBean">
            	<s:param name="request" value="${actionBean.request}"/>
                Submit Documentation
            </s:link> |
            <s:link beanclass="documentify.action.RequestListActionBean">
                Back to List
            </s:link>
        </p>
    </s:layout-component>
</s:layout-render>