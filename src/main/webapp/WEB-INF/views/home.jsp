<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>To do list</title>
</head>

<body>
<h1 align=center>To do list</h1>

<form action="<c:url value="save"/>" method="post">
    <input type="text" id="taskname" name="taskname"
           placeholder="Taskname"/>
    <button id="save">Save</button>
</form>

<table border="2" cellpadding="2" cellspacing="2" width="100%">
    <tr>
        <th width="25%">ID</th>
        <th width="25%">Name</th>
        <th width="25%">Status</th>
        <th width="25%">Delete</th>
    </tr>
    <c:forEach items="${data}" var="d" varStatus="varStatus">
        <tr>
            <td width="25%">
                <span>
                    <c:out value="${varStatus.index}"/>
                </span>
            </td>
            <td width="25%">
                <span>
                    <c:out value="${d.item}"/>
                </span>
            </td>
            <td width="25%">
                <c:choose>
                    <c:when test="${d.status eq true}">
                        Done
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value="update?id=${d.id}" />">Undone</a>
                    </c:otherwise>
                </c:choose>
            </td>
            <td width="25%">
                <a href="<c:url value="delete?id=${d.id}" />">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>


<form action="<c:url value="/"/>" method="get">
    <select name="status">
        <c:forEach var="st" items="${statuses}">
            <option value="${st.key}" <c:if test="${st.value eq true}">selected</c:if>>
                    ${st.key}
            </option>
        </c:forEach>
    </select>
    <button id="filter">Filter</button>
</form>
<c:out value="Enter the task and press \"Save\" to add the task."/> <br/>
<c:out value="Press \"Not done\" for changing status of the task to \"Done\"."/> <br/>
<c:out value="Press \"Delete\" to delete the task."/> <br/>
<c:out value="Choose the option and press \"Filter\" to filter the tasks."/> <br/>
</body>
</html>
