<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${namePage}</title>
</head>
<body>
<form action="edit" method="post">
    <label for="firstName">Введите имя:
        <input type="text" id="firstName" value="${owner.firstName}" name="firstName" />
    </label>  <br />
    <label for="surname">Введите фамилию:
        <input type="text" id="surname" value="${owner.surname}" name="surname" />
    </label>  <br />
    <label for="patronymic">Введите отчество:
        <input type="text" id="patronymic" value="${owner.patronymic}" name="patronymic" />
    </label>  <br />
    <label for="phoneNumber">Введите телефон:
        <input type="text" id="phoneNumber" value="${owner.phoneNumber}" name="phoneNumber" />
    </label>  <br />
    <label for="address">Введите адрес:
        <input type="text" id="address" value="${owner.address}" name="address" />
    </label>  <br />
    <input type="hidden" id="animalOwnerId" value="${owner.animalOwnerId}" name="animalOwnerId" />
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>
