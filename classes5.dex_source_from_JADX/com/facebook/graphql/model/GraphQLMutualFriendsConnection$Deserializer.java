package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLMutualFriendsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: facebookSignInOptions */
public class GraphQLMutualFriendsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMutualFriendsConnection.class, new GraphQLMutualFriendsConnection$Deserializer());
    }

    public Object m9142a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLMutualFriendsConnectionDeserializer.m5381a(jsonParser, (short) 269);
        Object graphQLMutualFriendsConnection = new GraphQLMutualFriendsConnection();
        ((BaseModel) graphQLMutualFriendsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLMutualFriendsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLMutualFriendsConnection).a();
        }
        return graphQLMutualFriendsConnection;
    }
}
