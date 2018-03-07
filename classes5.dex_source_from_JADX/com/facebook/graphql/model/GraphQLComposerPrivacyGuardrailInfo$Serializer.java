package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLComposerPrivacyGuardrailInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isStaleData */
public final class GraphQLComposerPrivacyGuardrailInfo$Serializer extends JsonSerializer<GraphQLComposerPrivacyGuardrailInfo> {
    public final void m6842a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLComposerPrivacyGuardrailInfo graphQLComposerPrivacyGuardrailInfo = (GraphQLComposerPrivacyGuardrailInfo) obj;
        GraphQLComposerPrivacyGuardrailInfoDeserializer.m4673a(graphQLComposerPrivacyGuardrailInfo.w_(), graphQLComposerPrivacyGuardrailInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLComposerPrivacyGuardrailInfo.class, new GraphQLComposerPrivacyGuardrailInfo$Serializer());
        FbSerializerProvider.a(GraphQLComposerPrivacyGuardrailInfo.class, new GraphQLComposerPrivacyGuardrailInfo$Serializer());
    }
}
