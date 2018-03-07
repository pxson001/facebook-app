package com.facebook.confirmation.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AccountConfirmationInterstitialTypeDeserializer.class)
/* compiled from: instantshopping_document_fetch_query?catalog_id= */
public enum AccountConfirmationInterstitialType {
    HARD_CLIFF,
    SOFT_CLIFF,
    UNKNOWN;

    @JsonCreator
    public static AccountConfirmationInterstitialType fromString(String str) {
        if (HARD_CLIFF.name().equals(str)) {
            return HARD_CLIFF;
        }
        if (SOFT_CLIFF.name().equals(str)) {
            return SOFT_CLIFF;
        }
        return UNKNOWN;
    }
}
