package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSponsoredDataDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unrecognized field " */
public final class GraphQLSponsoredData$Serializer extends JsonSerializer<GraphQLSponsoredData> {
    public final void m21753a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSponsoredData graphQLSponsoredData = (GraphQLSponsoredData) obj;
        GraphQLSponsoredDataDeserializer.m5923a(graphQLSponsoredData.w_(), graphQLSponsoredData.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSponsoredData.class, new GraphQLSponsoredData$Serializer());
        FbSerializerProvider.a(GraphQLSponsoredData.class, new GraphQLSponsoredData$Serializer());
    }
}
