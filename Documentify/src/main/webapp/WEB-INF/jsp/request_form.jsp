<%-- 
    Document   : request_form
    Created on : 04-Nov-2015, 12:01:27
    Author     : Russ
--%>

<%@include file="common/taglibs.jsp" %>
<jsp:useBean class="documentify.view.ProjectsViewHelper" id="projects"/>
<jsp:useBean class="documentify.view.UsersViewHelper" id="users"/>

<s:layout-render name="common/layout_main.jsp" title="Request Details">
    <s:layout-component name="body">
        <s:form beanclass="documentify.action.RequestFormActionBean">
            <s:errors/>
            <div><s:hidden name="request"/></div>
            <table class="form">
                <tr>
                    <td><s:label for="request.id">:</s:label></td>
                    <td>${empty actionBean.request.id ? "n/a" : actionBean.request.id}</td>
                </tr>
                <tr>
                    <td><s:label for="request.requestTitle">:</s:label></td>
                        <td>
                        <s:text name="request.requestTitle"/>
                    </td>
                    <td><s:errors field="request.requestTitle"/></td>
                </tr>
                <tr>
                    <td><s:label for="request.requestDesc">:</s:label></td>
                        <td>
                        <s:textarea name="request.requestDesc"/>
                    </td>
                    <td><s:errors field="request.requestDesc"/></td>
                </tr>
                <tr>
                    <td><s:label for="request.project">:</s:label></td>
                    <td><s:select name="request.project">
                            <%--<s:option value="">Select a project...</s:option>--%>
                            <s:options-collection collection="${projects.projects}" value="id" label="projectName"/>   
                        </s:select>
                    </td>
                    <td><s:errors field="request.project"/></td>
                </tr>
                <tr>
                    <td><s:label for="request.dateOfRequest">:</s:label></td>
                        <td>
                        <s:text name="request.dateOfRequest" formatPattern="dd/MM/yyyy"/>
                    </td>
                    <td><s:errors field="request.dateOfRequest"/></td>
                </tr>
                <tr>
                    <td><s:label for="request.reviewDate">:</s:label></td>
                        <td>
                        <s:text name="request.reviewDate" formatPattern="dd/MM/yyyy"/>
                    </td>
                    <td><s:errors field="request.reviewDate"/></td>
                </tr>
                <tr>
                    <td><s:label for="request.pointsWorth">:</s:label></td>
                    <td><s:text name="request.pointsWorth"/></td>
                    <td><s:errors field="request.pointsWorth"/></td>
                </tr>
                <tr>
                    <td><s:label for="request.assignedPriority">:</s:label></td>
                    <td><s:select name="request.assignedPriority">
                            <%--<s:option value="">Select a project...</s:option>--%>
                            <s:options-enumeration enum="documentify.model.Priority" label="priority"/>  
                        </s:select>
                    </td>
                    <td><s:errors field="request.assignedPriority"/></td>
                </tr>
                <tr>
                    <td><s:label for="request.status">:</s:label></td>
                    <td><s:select name="request.status">
                            <s:options-enumeration enum="documentify.model.Status" label="status"/>  
                        </s:select>
                    </td>
                    <td><s:errors field="request.status"/></td>
                </tr>
                <tr>
                    <td><s:label for="request.requester">:</s:label></td>
                    <td><s:select name="request.requester">
                            <s:options-collection collection="${users.users}" value="id" label="userName"/>   
                        </s:select>
                    </td>
                    <td><s:errors field="request.requester"/></td>
                </tr>
                <tr>
                    <td><s:label for="request.comments">:</s:label></td>
                    <td><s:text name="request.comments"/></td>
                    <td><s:errors field="request.comments"/></td>
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
