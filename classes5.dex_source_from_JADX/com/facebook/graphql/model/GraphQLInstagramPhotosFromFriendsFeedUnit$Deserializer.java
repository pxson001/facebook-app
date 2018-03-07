package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLInstagramPhotosFromFriendsFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: filtered_claim_count */
public class GraphQLInstagramPhotosFromFriendsFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInstagramPhotosFromFriendsFeedUnit.class, new GraphQLInstagramPhotosFromFriendsFeedUnit$Deserializer());
    }

    public Object m8705a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLInstagramPhotosFromFriendsFeedUnitDeserializer.m5255a(jsonParser, (short) 115);
        Object graphQLInstagramPhotosFromFriendsFeedUnit = new GraphQLInstagramPhotosFromFriendsFeedUnit();
        ((BaseModel) graphQLInstagramPhotosFromFriendsFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLInstagramPhotosFromFriendsFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLInstagramPhotosFromFriendsFeedUnit).a();
        }
        return graphQLInstagramPhotosFromFriendsFeedUnit;
    }
}
