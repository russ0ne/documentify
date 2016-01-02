<%-- 
    Document   : menu
    Created on : 06-Nov-2015, 13:58:23
    Author     : Russ
--%>

<%@include file="taglibs.jsp"%>

<c:forEach var="section" items="${actionBean.sections}">
	<c:choose>
		<c:when test="${section eq actionBean.currentSection}">
			<span class="currentSection">${section.text}</span>
		</c:when>
		<c:otherwise>
			<s:link beanclass="${section.beanclass}" class="sectionLink">
                ${section.text}
            </s:link>
		</c:otherwise>
	</c:choose>
</c:forEach>
