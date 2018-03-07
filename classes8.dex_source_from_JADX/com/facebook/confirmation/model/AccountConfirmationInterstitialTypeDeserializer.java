package com.facebook.confirmation.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: instantshopping_document_fetch_query */
public class AccountConfirmationInterstitialTypeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(AccountConfirmationInterstitialType.class, new AccountConfirmationInterstitialTypeDeserializer());
    }

    public Object m12730a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return AccountConfirmationInterstitialType.fromString(jsonParser.o());
    }
}
