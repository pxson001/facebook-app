package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLResharesOfContentConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_CHANNEL */
public final class GraphQLResharesOfContentConnection$Serializer extends JsonSerializer<GraphQLResharesOfContentConnection> {
    public final void m21501a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResharesOfContentConnection graphQLResharesOfContentConnection = (GraphQLResharesOfContentConnection) obj;
        GraphQLResharesOfContentConnectionDeserializer.m5841a(graphQLResharesOfContentConnection.w_(), graphQLResharesOfContentConnection.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLResharesOfContentConnection.class, new GraphQLResharesOfContentConnection$Serializer());
        FbSerializerProvider.a(GraphQLResharesOfContentConnection.class, new GraphQLResharesOfContentConnection$Serializer());
    }
}
