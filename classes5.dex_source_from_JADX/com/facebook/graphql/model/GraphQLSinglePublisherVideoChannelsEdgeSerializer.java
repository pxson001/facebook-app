package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UserWorkExperiencesEdge */
public class GraphQLSinglePublisherVideoChannelsEdgeSerializer extends JsonSerializer<GraphQLSinglePublisherVideoChannelsEdge> {
    public final void m21670a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSinglePublisherVideoChannelsEdge__JsonHelper.m21672a(jsonGenerator, (GraphQLSinglePublisherVideoChannelsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSinglePublisherVideoChannelsEdge.class, new GraphQLSinglePublisherVideoChannelsEdgeSerializer());
    }
}
