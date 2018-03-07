package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPageMenuInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: encryptChannelRequestMethod */
public final class GraphQLPageMenuInfo$Serializer extends JsonSerializer<GraphQLPageMenuInfo> {
    public final void m9497a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageMenuInfo graphQLPageMenuInfo = (GraphQLPageMenuInfo) obj;
        GraphQLPageMenuInfoDeserializer.m5514a(graphQLPageMenuInfo.w_(), graphQLPageMenuInfo.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLPageMenuInfo.class, new GraphQLPageMenuInfo$Serializer());
        FbSerializerProvider.a(GraphQLPageMenuInfo.class, new GraphQLPageMenuInfo$Serializer());
    }
}
