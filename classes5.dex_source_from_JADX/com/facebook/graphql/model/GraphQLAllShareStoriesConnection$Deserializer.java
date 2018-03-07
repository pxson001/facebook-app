package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAllShareStoriesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: java.util */
public class GraphQLAllShareStoriesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAllShareStoriesConnection.class, new GraphQLAllShareStoriesConnection$Deserializer());
    }

    public Object m6530a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAllShareStoriesConnectionDeserializer.m4559a(jsonParser, (short) 469);
        Object graphQLAllShareStoriesConnection = new GraphQLAllShareStoriesConnection();
        ((BaseModel) graphQLAllShareStoriesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAllShareStoriesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLAllShareStoriesConnection).a();
        }
        return graphQLAllShareStoriesConnection;
    }
}
