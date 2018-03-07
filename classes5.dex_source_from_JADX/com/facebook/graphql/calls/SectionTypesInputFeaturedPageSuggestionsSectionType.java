package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: popular_at_report_spam_or_scam */
public enum SectionTypesInputFeaturedPageSuggestionsSectionType implements JsonSerializable {
    CAUSES("CAUSES"),
    INTERESTS("INTERESTS"),
    MOVIES("MOVIES"),
    MUSIC("MUSIC"),
    SPORTS("SPORTS"),
    TV_SHOWS("TV_SHOWS");
    
    protected final String serverValue;

    private SectionTypesInputFeaturedPageSuggestionsSectionType(String str) {
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
