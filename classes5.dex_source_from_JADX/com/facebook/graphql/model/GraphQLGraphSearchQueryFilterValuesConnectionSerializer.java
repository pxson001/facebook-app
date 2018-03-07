package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: game_uri */
public class GraphQLGraphSearchQueryFilterValuesConnectionSerializer extends JsonSerializer<GraphQLGraphSearchQueryFilterValuesConnection> {
    public final void m8252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchQueryFilterValuesConnection__JsonHelper.m8254a(jsonGenerator, (GraphQLGraphSearchQueryFilterValuesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchQueryFilterValuesConnection.class, new GraphQLGraphSearchQueryFilterValuesConnectionSerializer());
    }
}
