package com.facebook.graphql.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.Maps;
import java.util.Map;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PrivacyTypeDeserializer.class)
/* compiled from: TV_NETWORK */
public enum PrivacyType {
    ACQUAINTANCES("acquaintances"),
    CLOSE_FRIENDS("close_friends"),
    CUSTOM("custom"),
    EVERYONE("everyone"),
    EVENT("event"),
    FACEBOOK("facebook"),
    FAMILY("family"),
    FRIENDS("friends"),
    FRIENDS_EXCEPT_ACQUAINTANCES("friends_except_acquaintances"),
    FRIENDS_OF_FRIENDS("friends_of_friends"),
    ONLY_ME("only_me"),
    GENERIC_LIST("generic_list"),
    GROUP("group"),
    LIST_MEMBERS("list_members"),
    LOCATION("location"),
    SCHOOL("school"),
    SCHOOL_GROUP("school_group"),
    WORK("work");
    
    private static final Map<String, PrivacyType> stringToEnum = null;
    private final String name;

    static {
        stringToEnum = Maps.c();
        PrivacyType[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            PrivacyType privacyType = values[i];
            stringToEnum.put(privacyType.toString(), privacyType);
            i++;
        }
    }

    private PrivacyType(String str) {
        this.name = str;
    }

    public final String toString() {
        return this.name;
    }

    @JsonCreator
    public static PrivacyType getByValue(String str) {
        if (stringToEnum.containsKey(str)) {
            return (PrivacyType) stringToEnum.get(str);
        }
        return CUSTOM;
    }
}
