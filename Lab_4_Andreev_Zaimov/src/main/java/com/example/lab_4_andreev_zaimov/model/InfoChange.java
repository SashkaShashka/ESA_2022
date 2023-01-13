package com.example.lab_4_andreev_zaimov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoChange {
    Map<String, String> object1;
    Map<String, String> object2;
    String eventType;
    String table;
    Date date;
}
