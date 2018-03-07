package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGroupMessageChattableMembersConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: friend_center_friends */
public class GraphQLGroupMessageChattableMembersConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupMessageChattableMembersConnection.class, new GraphQLGroupMessageChattableMembersConnection$Deserializer());
    }

    public Object m8471a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGroupMessageChattableMembersConnectionDeserializer.m5177a(jsonParser, (short) 418);
        Object graphQLGroupMessageChattableMembersConnection = new GraphQLGroupMessageChattableMembersConnection();
        ((BaseModel) graphQLGroupMessageChattableMembersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGroupMessageChattableMembersConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLGroupMessageChattableMembersConnection).a();
        }
        return graphQLGroupMessageChattableMembersConnection;
    }
}
