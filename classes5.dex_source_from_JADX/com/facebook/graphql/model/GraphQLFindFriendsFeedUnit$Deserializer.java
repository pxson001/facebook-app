package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFindFriendsFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: help_center_url */
public class GraphQLFindFriendsFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFindFriendsFeedUnit.class, new GraphQLFindFriendsFeedUnit$Deserializer());
    }

    public Object m7509a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFindFriendsFeedUnitDeserializer.m4911a(jsonParser, (short) 410);
        Object graphQLFindFriendsFeedUnit = new GraphQLFindFriendsFeedUnit();
        ((BaseModel) graphQLFindFriendsFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFindFriendsFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLFindFriendsFeedUnit).a();
        }
        return graphQLFindFriendsFeedUnit;
    }
}
