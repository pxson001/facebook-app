package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fb_percent */
public class GraphQLLocationSerializer extends JsonSerializer<GraphQLLocation> {
    public final void m8964a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLocation__JsonHelper.m8966a(jsonGenerator, (GraphQLLocation) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLocation.class, new GraphQLLocationSerializer());
    }
}
