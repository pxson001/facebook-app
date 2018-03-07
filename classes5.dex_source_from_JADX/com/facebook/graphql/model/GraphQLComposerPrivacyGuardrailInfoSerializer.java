package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isSilent */
public class GraphQLComposerPrivacyGuardrailInfoSerializer extends JsonSerializer<GraphQLComposerPrivacyGuardrailInfo> {
    public final void m6844a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLComposerPrivacyGuardrailInfo__JsonHelper.a(jsonGenerator, (GraphQLComposerPrivacyGuardrailInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLComposerPrivacyGuardrailInfo.class, new GraphQLComposerPrivacyGuardrailInfoSerializer());
    }
}
