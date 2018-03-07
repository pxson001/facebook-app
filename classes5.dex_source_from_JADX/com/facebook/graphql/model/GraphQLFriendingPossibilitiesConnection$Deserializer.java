package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFriendingPossibilitiesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: has_viewer_viewed */
public class GraphQLFriendingPossibilitiesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendingPossibilitiesConnection.class, new GraphQLFriendingPossibilitiesConnection$Deserializer());
    }

    public Object m7583a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFriendingPossibilitiesConnectionDeserializer.m4940a(jsonParser, (short) 384);
        Object graphQLFriendingPossibilitiesConnection = new GraphQLFriendingPossibilitiesConnection();
        ((BaseModel) graphQLFriendingPossibilitiesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFriendingPossibilitiesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLFriendingPossibilitiesConnection).a();
        }
        return graphQLFriendingPossibilitiesConnection;
    }
}
