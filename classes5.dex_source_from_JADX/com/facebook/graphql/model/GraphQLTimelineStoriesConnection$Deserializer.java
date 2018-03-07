package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTimelineStoriesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNDERAGE_FAN_REMOVAL */
public class GraphQLTimelineStoriesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineStoriesConnection.class, new GraphQLTimelineStoriesConnection$Deserializer());
    }

    public Object m22225a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTimelineStoriesConnectionDeserializer.m6096a(jsonParser, (short) 556);
        Object graphQLTimelineStoriesConnection = new GraphQLTimelineStoriesConnection();
        ((BaseModel) graphQLTimelineStoriesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTimelineStoriesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLTimelineStoriesConnection).a();
        }
        return graphQLTimelineStoriesConnection;
    }
}
