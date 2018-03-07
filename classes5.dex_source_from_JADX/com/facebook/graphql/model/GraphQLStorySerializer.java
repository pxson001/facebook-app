package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UTF8 */
public class GraphQLStorySerializer extends JsonSerializer<GraphQLStory> {
    public final void m21887a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStory__JsonHelper.m21923a(jsonGenerator, (GraphQLStory) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStory.class, new GraphQLStorySerializer());
    }
}
