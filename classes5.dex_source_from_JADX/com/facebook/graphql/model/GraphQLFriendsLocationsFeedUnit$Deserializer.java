package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFriendsLocationsFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: has_comprehensive_title */
public class GraphQLFriendsLocationsFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsLocationsFeedUnit.class, new GraphQLFriendsLocationsFeedUnit$Deserializer());
    }

    public Object m7633a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFriendsLocationsFeedUnitDeserializer.m4957a(jsonParser, (short) 112);
        Object graphQLFriendsLocationsFeedUnit = new GraphQLFriendsLocationsFeedUnit();
        ((BaseModel) graphQLFriendsLocationsFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFriendsLocationsFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLFriendsLocationsFeedUnit).a();
        }
        return graphQLFriendsLocationsFeedUnit;
    }
}
