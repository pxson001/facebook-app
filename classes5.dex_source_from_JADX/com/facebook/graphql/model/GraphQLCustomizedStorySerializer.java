package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_places_suggest_edits */
public class GraphQLCustomizedStorySerializer extends JsonSerializer<GraphQLCustomizedStory> {
    public final void m6929a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCustomizedStory__JsonHelper.a(jsonGenerator, (GraphQLCustomizedStory) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLCustomizedStory.class, new GraphQLCustomizedStorySerializer());
    }
}
