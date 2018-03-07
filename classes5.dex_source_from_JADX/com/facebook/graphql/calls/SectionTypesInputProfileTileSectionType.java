package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: popular_at_report_not_specific */
public enum SectionTypesInputProfileTileSectionType implements JsonSerializable {
    ABOUT("ABOUT"),
    CONTACT_INFO("CONTACT_INFO"),
    FRIENDS("FRIENDS"),
    FOLLOWERS("FOLLOWERS"),
    MUTUALITY("MUTUALITY"),
    PENDING("PENDING"),
    PHOTOS("PHOTOS"),
    PYMK("PYMK"),
    QUESTIONS("QUESTIONS"),
    RECENT_ACTIVITY("RECENT_ACTIVITY"),
    VIDEOS("VIDEOS");
    
    protected final String serverValue;

    private SectionTypesInputProfileTileSectionType(String str) {
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
