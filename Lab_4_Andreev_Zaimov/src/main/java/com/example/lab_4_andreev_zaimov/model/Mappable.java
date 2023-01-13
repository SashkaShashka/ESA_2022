package com.example.lab_4_andreev_zaimov.model;

import java.util.Map;

public interface Mappable<T> {
    Map<String, String> toMap();
}
