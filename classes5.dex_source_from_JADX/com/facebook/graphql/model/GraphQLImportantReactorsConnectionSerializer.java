package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: flight_date_label */
public class GraphQLImportantReactorsConnectionSerializer extends JsonSerializer<GraphQLImportantReactorsConnection> {
    public final void m8638a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLImportantReactorsConnection__JsonHelper.a(jsonGenerator, (GraphQLImportantReactorsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLImportantReactorsConnection.class, new GraphQLImportantReactorsConnectionSerializer());
    }
}
