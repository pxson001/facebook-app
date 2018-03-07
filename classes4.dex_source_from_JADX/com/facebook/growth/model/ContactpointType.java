package com.facebook.growth.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ContactpointTypeDeserializer.class)
/* compiled from: extra_option_row_set_ids */
public enum ContactpointType {
    PHONE,
    EMAIL,
    UNKNOWN;

    @JsonCreator
    public static ContactpointType fromString(String str) {
        if (PHONE.name().equals(str)) {
            return PHONE;
        }
        if (EMAIL.name().equals(str)) {
            return EMAIL;
        }
        return UNKNOWN;
    }
}
