package com.facebook.search.api;

/* compiled from: limit_probability */
public enum GraphSearchQuery$ScopedEntityType {
    URL("url"),
    USER("user"),
    GROUP("group"),
    PAGE("page"),
    EVENT("event"),
    VIDEO("video"),
    MARKETPLACE("marketplace");
    
    private final String name;

    private GraphSearchQuery$ScopedEntityType(String str) {
        this.name = str;
    }

    public final String toString() {
        return this.name;
    }
}
