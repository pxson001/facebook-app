package com.facebook.contacts;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo_num_comments */
public class ContactSurfaceDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ContactSurface.class, new ContactSurfaceDeserializer());
    }

    public Object m11679a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return ContactSurface.fromString(jsonParser.o());
    }
}
