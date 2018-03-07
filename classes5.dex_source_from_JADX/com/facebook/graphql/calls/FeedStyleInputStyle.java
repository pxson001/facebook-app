package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: question */
public enum FeedStyleInputStyle implements JsonSerializable {
    NULL("NULL"),
    FRIENDS_FEED_ONLY("FRIENDS_FEED_ONLY"),
    ORIGINAL_FRIENDS_FEED_ONLY("ORIGINAL_FRIENDS_FEED_ONLY"),
    EXCLUDE_FRIENDS_CONTENT("EXCLUDE_FRIENDS_CONTENT"),
    EXCLUDE_ORIGINAL_FRIENDS_CONTENT("EXCLUDE_ORIGINAL_FRIENDS_CONTENT");
    
    protected final String serverValue;

    private FeedStyleInputStyle(String str) {
        this.serverValue = str;
    }

    public final String toString() {
        return this.serverValue;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.b(this.serverValue);
    }

    public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
    }
}
