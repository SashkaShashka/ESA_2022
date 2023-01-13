package com.example.lab_4_andreev_zaimov.service;

import com.example.lab_4_andreev_zaimov.config.JmsConfig;
import com.example.lab_4_andreev_zaimov.model.*;
import com.example.lab_4_andreev_zaimov.repository.AnimalAuditRepository;
import com.example.lab_4_andreev_zaimov.repository.AuditRepository;
import com.example.lab_4_andreev_zaimov.repository.OwnerAuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DBLoggerService {

    @Autowired
    private AuditRepository auditRepository;
    @Autowired
    private AnimalAuditRepository animalAuditRepository;
    @Autowired
    private OwnerAuditRepository  ownerAuditRepository;
    @Autowired
    private JMSParserService jmsParserService;

    @JmsListener(destination = JmsConfig.CHANGE_TOPIC)
    public void listen(@Payload Map<String, String> payload, @Headers MessageHeaders messageHeaders,
                       Message message) throws JMSException, ParseException {

        InfoChange parsedMessage = jmsParserService.parse(payload, messageHeaders, message);
        String eventType = parsedMessage.getEventType();

        switch (eventType) {
            case "Create" -> logCreateEvent(parsedMessage.getObject1(), parsedMessage.getTable(), parsedMessage.getDate());
            case "Delete" -> logDeleteEvent(parsedMessage.getObject1(), parsedMessage.getTable(), parsedMessage.getDate());
            case "Update" -> logUpdateEvent(parsedMessage.getObject1(), parsedMessage.getObject2(), parsedMessage.getTable(), parsedMessage.getDate());
        }
    }

    public void logCreateEvent(Map<String, String> object, String table, Date date){
        switch (table) {
            // ПОЧЕМУ В ДЖАВЕ НЕТ АНАЛОГА nameOf, который есть в C#??!?!?!?!?!?!?
            case "animal" -> logAnimalChange(object, null, "Create", date);
            case "owner" -> logOwnerChange(object, null, "Create", date);
        }
    }

    public void logDeleteEvent(Map<String, String> object, String table, Date date){
        switch (table) {
            case "animal" -> logAnimalChange(null, object, "Delete", date);
            case "owner" -> logOwnerChange(null, object, "Delete", date);
        }
    }

    public void logUpdateEvent(Map<String, String> objectNew, Map<String, String> objectOld, String table, Date date){
        switch (table) {
            case "animal" -> logAnimalChange(objectNew, objectOld, "Update", date);
            case "owner" -> logOwnerChange(objectNew, objectOld, "Update", date);
        }
    }

    private void logAnimalChange(Map<String, String> objectNew, Map<String, String> objectOld, String eventType, Date date){

        Animal animalOld = Animal.fromMap(objectOld);
        Animal animalNew = Animal.fromMap(objectNew);

        AnimalAudit animalAudit = new AnimalAudit(animalOld, animalNew);

        animalAudit = animalAuditRepository.save(animalAudit);

        //add eventType
        DBChange dbChange = new DBChange("animal", animalAudit.getId(), eventType, new java.sql.Date(date.getTime()));
        auditRepository.saveAndFlush(dbChange);
    }

    private void logOwnerChange(Map<String, String> objectNew, Map<String, String> objectOld, String eventType, Date date){
        Owner ownerOld = Owner.fromMap(objectOld);
        Owner ownerNew = Owner.fromMap(objectNew);

        OwnerAudit ownerAudit = new OwnerAudit(ownerOld, ownerNew);

        ownerAudit = ownerAuditRepository.save(ownerAudit);

        DBChange dbChange = new DBChange("owner", ownerAudit.getId(), eventType, new java.sql.Date(date.getTime()));
        auditRepository.saveAndFlush(dbChange);
    }
}