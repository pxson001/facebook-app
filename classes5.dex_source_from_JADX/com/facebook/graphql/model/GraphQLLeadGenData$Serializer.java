package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLLeadGenDataDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_type_name */
public final class GraphQLLeadGenData$Serializer extends JsonSerializer<GraphQLLeadGenData> {
    public final void m8817a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenData graphQLLeadGenData = (GraphQLLeadGenData) obj;
        GraphQLLeadGenDataDeserializer.m5285a(graphQLLeadGenData.w_(), graphQLLeadGenData.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenData.class, new GraphQLLeadGenData$Serializer());
        FbSerializerProvider.a(GraphQLLeadGenData.class, new GraphQLLeadGenData$Serializer());
    }
}
