# Отчет/пояснение о проделанной работе в 3 ЛР и результаты
1) Реализована работа по REST API</br>
![image](https://user-images.githubusercontent.com/62326372/211821519-fecd51a2-ce0f-4a16-a8d1-00cef2bc6c85.png) </br>
![image](https://user-images.githubusercontent.com/62326372/211821611-929c4c64-4200-4e04-813c-6ba55f40428e.png) </br>
2) Реализованы xsl страницы с шаблонами </br>
![image](https://user-images.githubusercontent.com/62326372/211901787-8843ebb1-06a2-4fba-878e-1ebf6fe4a4db.png) </br>
![image](https://user-images.githubusercontent.com/62326372/211901884-1983754f-6f5e-4bf4-93ee-c6a03b2c249b.png) </br>
3) Проверена работа всех методов из контроллера через Thunder Client - расширение для Visual Studio Code. Аналогично для animals.  </br>
![image](https://user-images.githubusercontent.com/62326372/211826794-f5d3efab-5436-4841-8a4e-313aa7f6a216.png) </br>
![image](https://user-images.githubusercontent.com/62326372/211826906-74438dcd-eedf-4757-a277-4d4c36783dc8.png) </br>
4) Как можно видеть по Get запросам в хэдэре Accept ставя различные параметры мы получаем различные ответы. Application/json возвращает json объект, а Application/xml уже преобразованную страницу.
![image](https://user-images.githubusercontent.com/62326372/211827199-aaf7e01d-cd51-4b7d-ad67-abae444f1e7a.png) </br>
![image](https://user-images.githubusercontent.com/62326372/211828677-928ddff9-bfb7-4a94-b676-3b96b0cab762.png)
P.S. Добавлен @Autowired для репозиториев в контроллерах и поле сделано private. Почищены модели от лишних геттеров и сеттеров.
