package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGroupMembersConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: friend_description */
public class GraphQLGroupMembersConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupMembersConnection.class, new GraphQLGroupMembersConnection$Deserializer());
    }

    public Object m8454a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGroupMembersConnectionDeserializer.m5170a(jsonParser, (short) 313);
        Object graphQLGroupMembersConnection = new GraphQLGroupMembersConnection();
        ((BaseModel) graphQLGroupMembersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGroupMembersConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLGroupMembersConnection).a();
        }
        return graphQLGroupMembersConnection;
    }
}
