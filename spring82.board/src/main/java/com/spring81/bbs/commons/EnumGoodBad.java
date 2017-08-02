package com.spring81.bbs.commons;

public enum EnumGoodBad {
    GOOD("good"),
    BAD ("bad" );

    private final String value;

    EnumGoodBad(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
