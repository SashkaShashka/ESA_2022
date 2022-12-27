<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${namePage}</title>
</head>
<body>
<form action="AnimalEdit" method="post">
    <label for="firstName">Введите кличку:
        <input type="text" id="firstName" value="${animal.name}" name="name" />
    </label>  <br />
    <label for="sex">Выберите пол:
        <select  id="sex" name="sex">
            <option value="Кабель">Кабель</option>
            <option value="Сука">Сука</option>
            <option value="Не указано">Не указано</option>
        </select>
    </label>  <br />
    <label for="color">Введите цвет:
        <input type="text" id="color" value="${animal.color}" name="color" />
    </label>  <br />
    <label for="breed">Введите породу:
        <input type="text" id="breed" value="${animal.breed}" name="breed" />
    </label>  <br />
    <label for="breed">Выберите хозяина:
    <select  id="idOwner" name="idOwner">
        <option value="null">Не указан</option>
        <c:forEach var="item" items="${owners}">
            <option value="${item.getId()}">${item.getInfo()}</option>
        </c:forEach>
    </select>
    </label>  <br />
    <input type="hidden" id="chipId" value="${animal.chipId}" name="chipId" />
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>