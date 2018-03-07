package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPageInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: end_timestamp */
public final class GraphQLPageInfo$Serializer extends JsonSerializer<GraphQLPageInfo> {
    public final void m9488a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) obj;
        GraphQLPageInfoDeserializer.m5508a(graphQLPageInfo.w_(), graphQLPageInfo.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLPageInfo.class, new GraphQLPageInfo$Serializer());
        FbSerializerProvider.a(GraphQLPageInfo.class, new GraphQLPageInfo$Serializer());
    }
}
