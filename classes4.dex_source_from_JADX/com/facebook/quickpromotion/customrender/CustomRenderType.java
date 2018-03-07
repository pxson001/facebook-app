package com.facebook.quickpromotion.customrender;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Locale;

@AutoGenJsonDeserializer
@JsonDeserialize(using = CustomRenderTypeDeserializer.class)
/* compiled from: request refresh action did not have parameter */
public enum CustomRenderType {
    PHONE_NUMBER_ACQUISITION,
    UNKNOWN;

    @JsonCreator
    public static CustomRenderType fromString(String str) {
        if (str != null) {
            return valueOf(str.toUpperCase(Locale.US));
        }
        try {
            return UNKNOWN;
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
