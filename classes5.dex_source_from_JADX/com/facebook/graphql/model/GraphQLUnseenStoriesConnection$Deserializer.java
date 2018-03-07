package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLUnseenStoriesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Total bluetooth usage  */
public class GraphQLUnseenStoriesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUnseenStoriesConnection.class, new GraphQLUnseenStoriesConnection$Deserializer());
    }

    public Object m22352a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLUnseenStoriesConnectionDeserializer.m6143a(jsonParser, (short) 499);
        Object graphQLUnseenStoriesConnection = new GraphQLUnseenStoriesConnection();
        ((BaseModel) graphQLUnseenStoriesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLUnseenStoriesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLUnseenStoriesConnection).a();
        }
        return graphQLUnseenStoriesConnection;
    }
}
