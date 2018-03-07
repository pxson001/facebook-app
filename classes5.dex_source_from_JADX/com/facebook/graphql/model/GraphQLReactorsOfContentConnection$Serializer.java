package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLReactorsOfContentConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_VIEWS */
public final class GraphQLReactorsOfContentConnection$Serializer extends JsonSerializer<GraphQLReactorsOfContentConnection> {
    public final void m21344a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection = (GraphQLReactorsOfContentConnection) obj;
        GraphQLReactorsOfContentConnectionDeserializer.m5789a(graphQLReactorsOfContentConnection.w_(), graphQLReactorsOfContentConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLReactorsOfContentConnection.class, new GraphQLReactorsOfContentConnection$Serializer());
        FbSerializerProvider.a(GraphQLReactorsOfContentConnection.class, new GraphQLReactorsOfContentConnection$Serializer());
    }
}
