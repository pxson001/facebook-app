package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: friend_browser */
public class GraphQLGroupOwnerAuthoredStoriesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupOwnerAuthoredStoriesConnection.class, new GraphQLGroupOwnerAuthoredStoriesConnection$Deserializer());
    }

    public Object m8486a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer.m5183a(jsonParser, (short) 416);
        Object graphQLGroupOwnerAuthoredStoriesConnection = new GraphQLGroupOwnerAuthoredStoriesConnection();
        ((BaseModel) graphQLGroupOwnerAuthoredStoriesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGroupOwnerAuthoredStoriesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLGroupOwnerAuthoredStoriesConnection).a();
        }
        return graphQLGroupOwnerAuthoredStoriesConnection;
    }
}
