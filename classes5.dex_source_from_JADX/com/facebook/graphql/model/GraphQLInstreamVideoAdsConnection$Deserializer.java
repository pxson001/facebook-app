package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLInstreamVideoAdsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: feedback_unsubscribe */
public class GraphQLInstreamVideoAdsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInstreamVideoAdsConnection.class, new GraphQLInstreamVideoAdsConnection$Deserializer());
    }

    public Object m8735a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLInstreamVideoAdsConnectionDeserializer.m5269a(jsonParser, (short) 541);
        Object graphQLInstreamVideoAdsConnection = new GraphQLInstreamVideoAdsConnection();
        ((BaseModel) graphQLInstreamVideoAdsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLInstreamVideoAdsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLInstreamVideoAdsConnection).a();
        }
        return graphQLInstreamVideoAdsConnection;
    }
}
