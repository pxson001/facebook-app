package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: graph_editor_edit_info_link */
public class GraphQLGoodwillHappyBirthdayStoriesEdgeSerializer extends JsonSerializer<GraphQLGoodwillHappyBirthdayStoriesEdge> {
    public final void m7906a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillHappyBirthdayStoriesEdge__JsonHelper.m7908a(jsonGenerator, (GraphQLGoodwillHappyBirthdayStoriesEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillHappyBirthdayStoriesEdge.class, new GraphQLGoodwillHappyBirthdayStoriesEdgeSerializer());
    }
}
