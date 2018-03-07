package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLVect2Deserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TimelineAppSection */
public final class GraphQLVect2$Serializer extends JsonSerializer<GraphQLVect2> {
    public final void m22418a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVect2 graphQLVect2 = (GraphQLVect2) obj;
        GraphQLVect2Deserializer.m6167a(graphQLVect2.w_(), graphQLVect2.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLVect2.class, new GraphQLVect2$Serializer());
        FbSerializerProvider.a(GraphQLVect2.class, new GraphQLVect2$Serializer());
    }
}
