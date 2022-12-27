<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>
</head>
<body>
<h3>Животные:</h3>(<a href="AnimalEdit">добавить</a>)
<ol>
    <c:forEach items="${animal}" var = "summaryOfTheAnimal">
        <li>
                ${summaryOfTheAnimal.getInfo()}
            <a href="AnimalEdit?chipId=${summaryOfTheAnimal.getId()}">Редактировать</a> | <a href="AnimalRemove?chipId=${summaryOfTheAnimal.getId()}">Удалить</a>
        </li>
    </c:forEach>
</ol>


<h3>Хозяева:</h3>(<a href="OwnerEdit">Добавить</a>)
<ol>
    <c:forEach items="${owner}" var = "animalOwnerInformation">
        <li>
                ${animalOwnerInformation.getInfo()}
            <a href="OwnerEdit?animalOwnerId=${animalOwnerInformation.getId()}">Редактировать</a> | <a href="OwnerRemove?animalOwnerId=${animalOwnerInformation.getId()}">Удалить</a>
        </li>
    </c:forEach>
</ol>
</body>
</html>