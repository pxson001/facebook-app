package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNoContentGoodFriendsFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: event_ticket_order_id */
public class GraphQLNoContentGoodFriendsFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNoContentGoodFriendsFeedUnit.class, new GraphQLNoContentGoodFriendsFeedUnit$Deserializer());
    }

    public Object m9278a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLNoContentGoodFriendsFeedUnitDeserializer.m5434a(jsonParser, (short) 559);
        Object graphQLNoContentGoodFriendsFeedUnit = new GraphQLNoContentGoodFriendsFeedUnit();
        ((BaseModel) graphQLNoContentGoodFriendsFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLNoContentGoodFriendsFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLNoContentGoodFriendsFeedUnit).a();
        }
        return graphQLNoContentGoodFriendsFeedUnit;
    }
}
