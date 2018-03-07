package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNSETTLED */
public class GraphQLTaggableActivityIconSerializer extends JsonSerializer<GraphQLTaggableActivityIcon> {
    public final void m22053a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTaggableActivityIcon__JsonHelper.m22055a(jsonGenerator, (GraphQLTaggableActivityIcon) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTaggableActivityIcon.class, new GraphQLTaggableActivityIconSerializer());
    }
}
