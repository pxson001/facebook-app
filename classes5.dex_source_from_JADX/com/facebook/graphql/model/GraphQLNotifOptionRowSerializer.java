package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_declines */
public class GraphQLNotifOptionRowSerializer extends JsonSerializer<GraphQLNotifOptionRow> {
    public final void m9357a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNotifOptionRow__JsonHelper.m9359a(jsonGenerator, (GraphQLNotifOptionRow) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNotifOptionRow.class, new GraphQLNotifOptionRowSerializer());
    }
}
