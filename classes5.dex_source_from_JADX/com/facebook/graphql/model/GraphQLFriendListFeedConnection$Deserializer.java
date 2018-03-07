package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFriendListFeedConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: hc_reminder_birthday */
public class GraphQLFriendListFeedConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendListFeedConnection.class, new GraphQLFriendListFeedConnection$Deserializer());
    }

    public Object m7545a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFriendListFeedConnectionDeserializer.m4929a(jsonParser, (short) 327);
        Object graphQLFriendListFeedConnection = new GraphQLFriendListFeedConnection();
        ((BaseModel) graphQLFriendListFeedConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFriendListFeedConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLFriendListFeedConnection).a();
        }
        return graphQLFriendListFeedConnection;
    }
}
