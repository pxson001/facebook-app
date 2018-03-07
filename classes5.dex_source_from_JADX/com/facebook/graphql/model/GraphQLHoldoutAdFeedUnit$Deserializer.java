package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLHoldoutAdFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: forceCodeForRefreshToken */
public class GraphQLHoldoutAdFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLHoldoutAdFeedUnit.class, new GraphQLHoldoutAdFeedUnit$Deserializer());
    }

    public Object m8605a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLHoldoutAdFeedUnitDeserializer.m5217a(jsonParser, (short) 127);
        Object graphQLHoldoutAdFeedUnit = new GraphQLHoldoutAdFeedUnit();
        ((BaseModel) graphQLHoldoutAdFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLHoldoutAdFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLHoldoutAdFeedUnit).a();
        }
        return graphQLHoldoutAdFeedUnit;
    }
}
