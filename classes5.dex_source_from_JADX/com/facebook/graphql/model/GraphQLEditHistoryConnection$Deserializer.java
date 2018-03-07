package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEditHistoryConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ios_nearby_friends_self_view_unknown_region */
public class GraphQLEditHistoryConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEditHistoryConnection.class, new GraphQLEditHistoryConnection$Deserializer());
    }

    public Object m6964a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEditHistoryConnectionDeserializer.m4722a(jsonParser, (short) 198);
        Object graphQLEditHistoryConnection = new GraphQLEditHistoryConnection();
        ((BaseModel) graphQLEditHistoryConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEditHistoryConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLEditHistoryConnection).a();
        }
        return graphQLEditHistoryConnection;
    }
}
