package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNSAVE */
public class GraphQLTaggableActivitySerializer extends JsonSerializer<GraphQLTaggableActivity> {
    public final void m22063a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTaggableActivity__JsonHelper.m22083a(jsonGenerator, (GraphQLTaggableActivity) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTaggableActivity.class, new GraphQLTaggableActivitySerializer());
    }
}
