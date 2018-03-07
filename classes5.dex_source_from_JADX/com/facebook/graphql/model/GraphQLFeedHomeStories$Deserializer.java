package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedHomeStoriesDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: html_source */
public class GraphQLFeedHomeStories$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedHomeStories.class, new GraphQLFeedHomeStories$Deserializer());
    }

    public Object m7455a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFeedHomeStoriesDeserializer.m4880a(jsonParser, (short) 408);
        Object graphQLFeedHomeStories = new GraphQLFeedHomeStories();
        ((BaseModel) graphQLFeedHomeStories).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFeedHomeStories instanceof Postprocessable) {
            return ((Postprocessable) graphQLFeedHomeStories).a();
        }
        return graphQLFeedHomeStories;
    }
}
