package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: full_width_image */
public class GraphQLGraphSearchResultsConnectionSerializer extends JsonSerializer<GraphQLGraphSearchResultsConnection> {
    public final void m8296a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchResultsConnection__JsonHelper.m8298a(jsonGenerator, (GraphQLGraphSearchResultsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchResultsConnection.class, new GraphQLGraphSearchResultsConnectionSerializer());
    }
}
