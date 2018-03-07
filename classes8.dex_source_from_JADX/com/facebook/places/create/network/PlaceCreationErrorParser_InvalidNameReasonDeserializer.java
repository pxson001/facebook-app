package com.facebook.places.create.network;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.places.create.network.PlaceCreationErrorParser.InvalidNameReason;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: card_form_done_click */
public class PlaceCreationErrorParser_InvalidNameReasonDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(InvalidNameReason.class, new PlaceCreationErrorParser_InvalidNameReasonDeserializer());
    }

    public Object m22317a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return InvalidNameReason.fromString(jsonParser.o());
    }
}
