package com.facebook.growth.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: element_photo */
public class ContactpointTypeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ContactpointType.class, new ContactpointTypeDeserializer());
    }

    public Object m17348a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return ContactpointType.fromString(jsonParser.o());
    }
}
