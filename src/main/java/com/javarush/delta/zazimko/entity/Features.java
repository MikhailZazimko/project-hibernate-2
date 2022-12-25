package com.javarush.delta.zazimko.entity;

import static java.util.Objects.isNull;

public enum Features {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String value;

    Features(String value) {
        this.value = value;
    }

    public static Features getFeaturesByValue(String value) {
        if(isNull(value)||value.isEmpty()){
            return null;
        }
        Features[] features= Features.values();
        for (Features feature : features) {
            if(value.equals(feature.value)){
                return feature;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
