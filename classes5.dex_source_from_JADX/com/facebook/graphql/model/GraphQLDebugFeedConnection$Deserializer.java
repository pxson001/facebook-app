package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLDebugFeedConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ios_places_new_suggest_edits */
public class GraphQLDebugFeedConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLDebugFeedConnection.class, new GraphQLDebugFeedConnection$Deserializer());
    }

    public Object m6930a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLDebugFeedConnectionDeserializer.m4707a(jsonParser, (short) 377);
        Object graphQLDebugFeedConnection = new GraphQLDebugFeedConnection();
        ((BaseModel) graphQLDebugFeedConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLDebugFeedConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLDebugFeedConnection).a();
        }
        return graphQLDebugFeedConnection;
    }
}
