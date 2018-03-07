package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: process_cpu_power */
public enum OrderbyInputGroupsOrdering implements JsonSerializable {
    NAME("name"),
    IMPORTANCE("importance"),
    VIEWER_ADDED("viewer_added"),
    VIEWER_FAVORITED("viewer_favorited"),
    VIEWER_NEWLY_ADDED("viewer_newly_added"),
    VIEWER_VISITATION("viewer_visitation"),
    LAST_ACTIVITY_TIME("last_activity_time"),
    APP_LANDING("app_landing"),
    SOCIAL("social"),
    BOOKMARK_PINNED_RANK("bookmark_pinned_rank");
    
    protected final String serverValue;

    private OrderbyInputGroupsOrdering(String str) {
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
