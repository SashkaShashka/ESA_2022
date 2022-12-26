<%--
  Created by IntelliJ IDEA.
  User: Lena
  Date: 15.12.2022
  Time: 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление</title>
</head>
<body>
<form action="edit" method="post">
    <label for="name">Введите имя:
        <input type="text" id="name" value="${animalOwnerInformation.firstName}" name="firstName" />
    </label>  <br />
    <label for="last-name">Введите фамилию:
        <input type="text" id="last-name" value="${animalOwnerInformation.surname}" name="surname" />
    </label>  <br />
    <label for="age">Введите отчество:
        <input type="text" id="patronymic" value="${animalOwnerInformation.patronymic}" name="patronymic" />
    </label>  <br />
    <label for="age">Введите телефон:
        <input type="text" id="phoneNumber" value="${animalOwnerInformation.phoneNumber}" name="phoneNumber" />
    </label>  <br />
    <label for="age">Введите адрес:
        <input type="text" id="age" value="${animalOwnerInformation.address}" name="address" />
    </label>  <br />
    <input type="hidden" id="animalOwnerId" value="${animalOwnerInformation.animalOwnerId}" name="animalOwnerId" />
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>
