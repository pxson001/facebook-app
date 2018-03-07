package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNewsFeedEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: event_watchers */
public class GraphQLNewsFeedEdge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNewsFeedEdge.class, new GraphQLNewsFeedEdge$Deserializer());
    }

    public Object m9258a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLNewsFeedEdgeDeserializer.m5425a(jsonParser, (short) 331);
        Object graphQLNewsFeedEdge = new GraphQLNewsFeedEdge();
        ((BaseModel) graphQLNewsFeedEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLNewsFeedEdge instanceof Postprocessable) {
            return ((Postprocessable) graphQLNewsFeedEdge).a();
        }
        return graphQLNewsFeedEdge;
    }
}
