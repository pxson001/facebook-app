package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNOWNED_PLACE_PHOTO_INLINE */
public class GraphQLTargetingDescriptionSentenceSerializer extends JsonSerializer<GraphQLTargetingDescriptionSentence> {
    public final void m22097a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTargetingDescriptionSentence graphQLTargetingDescriptionSentence = (GraphQLTargetingDescriptionSentence) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLTargetingDescriptionSentence.m22095a() != null) {
            jsonGenerator.a("text", graphQLTargetingDescriptionSentence.m22095a());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLTargetingDescriptionSentence.class, new GraphQLTargetingDescriptionSentenceSerializer());
    }
}
