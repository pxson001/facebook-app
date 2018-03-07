package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFriendsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: has_photo_menus */
public class GraphQLFriendsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsConnection.class, new GraphQLFriendsConnection$Deserializer());
    }

    public Object m7604a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFriendsConnectionDeserializer.m4946a(jsonParser, (short) 109);
        Object graphQLFriendsConnection = new GraphQLFriendsConnection();
        ((BaseModel) graphQLFriendsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFriendsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLFriendsConnection).a();
        }
        return graphQLFriendsConnection;
    }
}
