package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStorySetStoriesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: USER_SETTING */
public class GraphQLStorySetStoriesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStorySetStoriesConnection.class, new GraphQLStorySetStoriesConnection$Deserializer());
    }

    public Object m21909a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStorySetStoriesConnectionDeserializer.m5986a(jsonParser, (short) 324);
        Object graphQLStorySetStoriesConnection = new GraphQLStorySetStoriesConnection();
        ((BaseModel) graphQLStorySetStoriesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStorySetStoriesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLStorySetStoriesConnection).a();
        }
        return graphQLStorySetStoriesConnection;
    }
}
