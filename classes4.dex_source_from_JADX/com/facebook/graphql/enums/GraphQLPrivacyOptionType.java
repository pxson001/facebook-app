package com.facebook.graphql.enums;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.util.StringLocaleUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = GraphQLPrivacyOptionTypeDeserializer.class)
/* compiled from: sim_info */
public enum GraphQLPrivacyOptionType {
    EVERYONE,
    FRIENDS,
    FRIENDS_EXCEPT,
    FRIENDS_EXCEPT_ACQUAINTANCES,
    FRIENDS_OF_FRIENDS,
    SPECIFIC_FRIENDS,
    FACEBOOK,
    ONLY_ME,
    CUSTOM,
    CLOSE_FRIENDS,
    ACQUAINTANCES,
    FAMILY_LIST,
    LOCATION_LIST,
    SCHOOL_LIST,
    WORK_LIST,
    GENERIC_LIST,
    WORK_COMMUNITY,
    GROUP,
    EVENT;

    @JsonCreator
    public static GraphQLPrivacyOptionType fromIconName(String str) {
        if (str == null) {
            return CUSTOM;
        }
        try {
            return valueOf(StringLocaleUtil.b(str));
        } catch (IllegalArgumentException e) {
            return CUSTOM;
        }
    }
}
