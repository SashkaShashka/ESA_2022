<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h3>Животные:</h3>(<a href="edit">добавить</a>)
<ol>

    <c:forEach items="${animal}" var = "summaryOfTheAnimal">
        <li>
            ${summaryOfTheAnimal.name} ${summaryOfTheAnimal.sex} ${summaryOfTheAnimal.color} ${summaryOfTheAnimal.bread}
            <a href="add?edit=${summaryOfTheAnimal.chipId}">Редактировать</a> | <a href="delete?id=${summaryOfTheAnimal.chipid}">удалить</a>
        </li>
    </c:forEach>
</ol>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>