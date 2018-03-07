package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAudienceInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_privacy_locked */
public final class GraphQLAudienceInfo$Serializer extends JsonSerializer<GraphQLAudienceInfo> {
    public final void m6620a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAudienceInfo graphQLAudienceInfo = (GraphQLAudienceInfo) obj;
        GraphQLAudienceInfoDeserializer.m4599a(graphQLAudienceInfo.w_(), graphQLAudienceInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLAudienceInfo.class, new GraphQLAudienceInfo$Serializer());
        FbSerializerProvider.a(GraphQLAudienceInfo.class, new GraphQLAudienceInfo$Serializer());
    }
}
