package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: receiver */
public enum ContextInputSearchType implements JsonSerializable {
    CITY_ONLY("CITY_ONLY"),
    CHECKIN("CHECKIN"),
    COMPOSER("COMPOSER"),
    DISSIMILARITY("DISSIMILARITY"),
    SUGGESTION("SUGGESTION"),
    FEED_SUGGESTION("FEED_SUGGESTION"),
    COMPOSER_SUGGESTION("COMPOSER_SUGGESTION"),
    PHOTONETEGO_SUGGESTION("PHOTONETEGO_SUGGESTION"),
    PHOTOSNOWLIFT_SUGGESTION("PHOTOSNOWLIFT_SUGGESTION"),
    UPSELL_SUGGESTION("UPSELL_SUGGESTION"),
    BELLEROPHON("BELLEROPHON"),
    CITY_SEARCH("CITY_SEARCH"),
    NON_GEOHUB_PLACES("NON_GEOHUB_PLACES"),
    SOCIAL_SEARCH_CONVERSION("SOCIAL_SEARCH_CONVERSION"),
    SOCIAL_SEARCH_COMMENT("SOCIAL_SEARCH_COMMENT"),
    FORSALE_POST("FORSALE_POST");
    
    protected final String serverValue;

    private ContextInputSearchType(String str) {
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
