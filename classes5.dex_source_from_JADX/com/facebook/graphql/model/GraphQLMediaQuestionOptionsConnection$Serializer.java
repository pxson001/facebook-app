package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLMediaQuestionOptionsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fb4a_graphql_disk_cache_snapshot_table */
public final class GraphQLMediaQuestionOptionsConnection$Serializer extends JsonSerializer<GraphQLMediaQuestionOptionsConnection> {
    public final void m9046a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMediaQuestionOptionsConnection graphQLMediaQuestionOptionsConnection = (GraphQLMediaQuestionOptionsConnection) obj;
        GraphQLMediaQuestionOptionsConnectionDeserializer.m5351a(graphQLMediaQuestionOptionsConnection.w_(), graphQLMediaQuestionOptionsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLMediaQuestionOptionsConnection.class, new GraphQLMediaQuestionOptionsConnection$Serializer());
        FbSerializerProvider.a(GraphQLMediaQuestionOptionsConnection.class, new GraphQLMediaQuestionOptionsConnection$Serializer());
    }
}
