# Отчет/пояснение о проделанной работе в 3 ЛР и результаты
1) Реализована работа по REST API</br>
![image](https://user-images.githubusercontent.com/62326372/211821519-fecd51a2-ce0f-4a16-a8d1-00cef2bc6c85.png) </br>
![image](https://user-images.githubusercontent.com/62326372/211821611-929c4c64-4200-4e04-813c-6ba55f40428e.png) </br>
2) Реализованы xsl страницы с шаблонами </br>
![image](https://user-images.githubusercontent.com/62326372/211901787-8843ebb1-06a2-4fba-878e-1ebf6fe4a4db.png) </br>
![image](https://user-images.githubusercontent.com/62326372/211901884-1983754f-6f5e-4bf4-93ee-c6a03b2c249b.png) </br>
3) Проверена работа всех методов из контроллера через Thunder Client - расширение для Visual Studio Code.   </br>
#### getAll
![image](https://user-images.githubusercontent.com/62326372/212365785-96e23d33-72ce-4da1-a223-ffc17c54e974.png) </br>
![image](https://user-images.githubusercontent.com/62326372/212365739-9af00e72-9b69-4c36-a06a-73e5a6e1e357.png) </br>
#### getById
![image](https://user-images.githubusercontent.com/62326372/212365449-468f4ffe-ec28-4080-9585-997958c1712d.png)
![image](https://user-images.githubusercontent.com/62326372/212365510-23b2dc35-0db8-478a-9374-bfc931966994.png)
#### create
![image](https://user-images.githubusercontent.com/62326372/212366075-9d373a51-d1ab-4de7-b5d5-a92836e5b8a2.png)
![image](https://user-images.githubusercontent.com/62326372/212366525-f8ca7ad1-c990-41cf-b245-8a45109cfeb8.png)
#### update
![image](https://user-images.githubusercontent.com/62326372/212366249-c806917d-c9a6-4391-9318-9348b0bc99ae.png)
![image](https://user-images.githubusercontent.com/62326372/212366829-23241fa5-3d66-4f5a-8164-20b3d5dec0cb.png)
#### delete
![image](https://user-images.githubusercontent.com/62326372/212366320-5c7c4780-4d41-4604-b6f2-8303a6ad36ba.png)
![image](https://user-images.githubusercontent.com/62326372/212367456-9ef1b8b6-c8d6-43cf-9684-8da9c0da4b6e.png)
4) Как можно видеть по Get запросам в хэдэре Accept ставя различные параметры мы получаем различные ответы. Application/json возвращает json объект, а Application/xml уже преобразованную страницу.
![image](https://user-images.githubusercontent.com/62326372/211827199-aaf7e01d-cd51-4b7d-ad67-abae444f1e7a.png) </br>
![image](https://user-images.githubusercontent.com/62326372/211828677-928ddff9-bfb7-4a94-b676-3b96b0cab762.png)
P.S. Добавлен @Autowired для репозиториев в контроллерах и поле сделано private. Почищены модели от лишних геттеров и сеттеров.
