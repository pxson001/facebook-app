package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unable to start a media-picker. */
public class GraphQLStory$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStory.class, new GraphQLStory$Deserializer());
    }

    public Object m21839a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStoryDeserializer.m5963a(jsonParser, (short) 27);
        Object graphQLStory = new GraphQLStory();
        ((BaseModel) graphQLStory).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStory instanceof Postprocessable) {
            return ((Postprocessable) graphQLStory).a();
        }
        return graphQLStory;
    }
}
