package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterValuesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: games_pyml */
public final class GraphQLGraphSearchQueryFilterValuesConnection$Serializer extends JsonSerializer<GraphQLGraphSearchQueryFilterValuesConnection> {
    public final void m8250a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchQueryFilterValuesConnection graphQLGraphSearchQueryFilterValuesConnection = (GraphQLGraphSearchQueryFilterValuesConnection) obj;
        GraphQLGraphSearchQueryFilterValuesConnectionDeserializer.m5102a(graphQLGraphSearchQueryFilterValuesConnection.w_(), graphQLGraphSearchQueryFilterValuesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchQueryFilterValuesConnection.class, new GraphQLGraphSearchQueryFilterValuesConnection$Serializer());
        FbSerializerProvider.a(GraphQLGraphSearchQueryFilterValuesConnection.class, new GraphQLGraphSearchQueryFilterValuesConnection$Serializer());
    }
}
