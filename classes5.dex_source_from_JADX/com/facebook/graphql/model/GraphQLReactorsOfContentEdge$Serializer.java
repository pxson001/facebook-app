package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLReactorsOfContentEdgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_STORIES */
public final class GraphQLReactorsOfContentEdge$Serializer extends JsonSerializer<GraphQLReactorsOfContentEdge> {
    public final void m21349a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLReactorsOfContentEdge graphQLReactorsOfContentEdge = (GraphQLReactorsOfContentEdge) obj;
        GraphQLReactorsOfContentEdgeDeserializer.m5792b(graphQLReactorsOfContentEdge.w_(), graphQLReactorsOfContentEdge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLReactorsOfContentEdge.class, new GraphQLReactorsOfContentEdge$Serializer());
        FbSerializerProvider.a(GraphQLReactorsOfContentEdge.class, new GraphQLReactorsOfContentEdge$Serializer());
    }
}
