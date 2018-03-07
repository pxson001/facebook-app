package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStorySaveInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to copy attachment for bug report. */
public final class GraphQLStorySaveInfo$Serializer extends JsonSerializer<GraphQLStorySaveInfo> {
    public final void m21882a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStorySaveInfo graphQLStorySaveInfo = (GraphQLStorySaveInfo) obj;
        GraphQLStorySaveInfoDeserializer.m5978a(graphQLStorySaveInfo.w_(), graphQLStorySaveInfo.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLStorySaveInfo.class, new GraphQLStorySaveInfo$Serializer());
        FbSerializerProvider.a(GraphQLStorySaveInfo.class, new GraphQLStorySaveInfo$Serializer());
    }
}
