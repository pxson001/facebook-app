package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTEX */
public class GraphQLSideFeedConnectionSerializer extends JsonSerializer<GraphQLSideFeedConnection> {
    public final void m21636a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSideFeedConnection__JsonHelper.m21638a(jsonGenerator, (GraphQLSideFeedConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSideFeedConnection.class, new GraphQLSideFeedConnectionSerializer());
    }
}
