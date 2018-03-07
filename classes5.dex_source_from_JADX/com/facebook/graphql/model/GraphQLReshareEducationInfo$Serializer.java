package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLReshareEducationInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_CHANNEL_FEED_UNIT_CARD */
public final class GraphQLReshareEducationInfo$Serializer extends JsonSerializer<GraphQLReshareEducationInfo> {
    public final void m21493a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLReshareEducationInfo graphQLReshareEducationInfo = (GraphQLReshareEducationInfo) obj;
        GraphQLReshareEducationInfoDeserializer.m5838a(graphQLReshareEducationInfo.w_(), graphQLReshareEducationInfo.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLReshareEducationInfo.class, new GraphQLReshareEducationInfo$Serializer());
        FbSerializerProvider.a(GraphQLReshareEducationInfo.class, new GraphQLReshareEducationInfo$Serializer());
    }
}
