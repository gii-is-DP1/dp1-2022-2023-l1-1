<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="players">
    <h2>Players</h2>
    <a class="btn btn-default" href="/users/new">Create new player</a>
    <table id="playersTable" class="table table-striped">
        <thead>
        <tr>
            <th>Username</th>
            <th>Online</th>
            <th>Playing</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${players}" var="player">
            <tr>
                <td>
                    <c:out value="${player.user.username}"/>
                </td>
                <td>
                    <c:out value="${player.online}"/>
                </td>
                <td>
                    <c:out value="${player.playing}"/>
                </td>
                <td>
                    <a href="/users/${player.user.username}/edit">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </a>
                </td>
                <td>
                    <a href="/players/${player.id}/delete">
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>