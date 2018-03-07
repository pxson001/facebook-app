package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLLinkTargetStoreDataDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: fc_search */
public class GraphQLLinkTargetStoreData$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLinkTargetStoreData.class, new GraphQLLinkTargetStoreData$Deserializer());
    }

    public Object m8943a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLLinkTargetStoreDataDeserializer.m5325a(jsonParser, (short) 194);
        Object graphQLLinkTargetStoreData = new GraphQLLinkTargetStoreData();
        ((BaseModel) graphQLLinkTargetStoreData).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLLinkTargetStoreData instanceof Postprocessable) {
            return ((Postprocessable) graphQLLinkTargetStoreData).a();
        }
        return graphQLLinkTargetStoreData;
    }
}
