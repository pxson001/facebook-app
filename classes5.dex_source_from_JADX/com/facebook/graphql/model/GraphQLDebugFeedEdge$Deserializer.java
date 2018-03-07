package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLDebugFeedEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ios_place_picker_report_swipe_button */
public class GraphQLDebugFeedEdge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLDebugFeedEdge.class, new GraphQLDebugFeedEdge$Deserializer());
    }

    public Object m6936a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLDebugFeedEdgeDeserializer.m4710a(jsonParser, (short) 378);
        Object graphQLDebugFeedEdge = new GraphQLDebugFeedEdge();
        ((BaseModel) graphQLDebugFeedEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLDebugFeedEdge instanceof Postprocessable) {
            return ((Postprocessable) graphQLDebugFeedEdge).a();
        }
        return graphQLDebugFeedEdge;
    }
}
