package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNOWNED_PAGE_INFORMATION_STORY_LINK */
public class GraphQLTargetingDescriptionSerializer extends JsonSerializer<GraphQLTargetingDescription> {
    public final void m22098a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTargetingDescription graphQLTargetingDescription = (GraphQLTargetingDescription) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLTargetingDescription.m22089a() != null) {
            jsonGenerator.a("content", graphQLTargetingDescription.m22089a());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLTargetingDescription.class, new GraphQLTargetingDescriptionSerializer());
    }
}
