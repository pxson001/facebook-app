package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USER_FUNDRAISER_PAGE */
public class GraphQLStoryTopicsContextSerializer extends JsonSerializer<GraphQLStoryTopicsContext> {
    public final void m21919a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryTopicsContext__JsonHelper.m21921a(jsonGenerator, (GraphQLStoryTopicsContext) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryTopicsContext.class, new GraphQLStoryTopicsContextSerializer());
    }
}
