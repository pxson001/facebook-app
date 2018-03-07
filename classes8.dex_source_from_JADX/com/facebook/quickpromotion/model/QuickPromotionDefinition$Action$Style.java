package com.facebook.quickpromotion.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Locale;

@AutoGenJsonDeserializer
@JsonDeserialize(using = QuickPromotionDefinition_Action_StyleDeserializer.class)
/* compiled from: reaction_forward_scroll */
public enum QuickPromotionDefinition$Action$Style {
    PROMINENT,
    DEFAULT,
    UNKNOWN;

    @JsonCreator
    public static QuickPromotionDefinition$Action$Style fromString(String str) {
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
