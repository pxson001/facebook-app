package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_place_map_hidden */
public class GraphQLAudioSerializer extends JsonSerializer<GraphQLAudio> {
    public final void m6626a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAudio__JsonHelper.m6628a(jsonGenerator, (GraphQLAudio) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAudio.class, new GraphQLAudioSerializer());
    }
}
