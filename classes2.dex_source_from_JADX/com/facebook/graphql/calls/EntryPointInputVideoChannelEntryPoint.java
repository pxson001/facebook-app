package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: response_body */
public enum EntryPointInputVideoChannelEntryPoint implements JsonSerializable {
    GROUP("GROUP"),
    NEWSFEED("NEWSFEED"),
    PAGE("PAGE"),
    PROFILE("PROFILE"),
    SAVED_STORY("SAVED_STORY"),
    SEARCH("SEARCH"),
    SEARCH_TOPIC_MEDIA("SEARCH_TOPIC_MEDIA"),
    PERMALINK("PERMALINK"),
    WWW_RHC("WWW_RHC"),
    VIDEO_HOME("VIDEO_HOME"),
    VIDEO_HOME_LATEST_FROM_PAGES_CHANNEL("VIDEO_HOME_LATEST_FROM_PAGES_CHANNEL"),
    VIDEO_HOME_SAVED_CHANNEL("VIDEO_HOME_SAVED_CHANNEL"),
    VIDEO_HOME_SHARED_WITH_YOU_CHANNEL("VIDEO_HOME_SHARED_WITH_YOU_CHANNEL"),
    VIDEO_HOME_TOP_CHANNEL("VIDEO_HOME_TOP_CHANNEL"),
    VIDEO_HOME_WATCHED_CHANNEL("VIDEO_HOME_WATCHED_CHANNEL"),
    UNKNOWN("UNKNOWN"),
    LIVE_MAP("LIVE_MAP");
    
    protected final String serverValue;

    private EntryPointInputVideoChannelEntryPoint(String str) {
        this.serverValue = str;
    }

    public final String toString() {
        return this.serverValue;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1123b(this.serverValue);
    }

    public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
    }
}
