package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSubstoriesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UPSELL_FAILURE */
public class GraphQLSubstoriesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSubstoriesConnection.class, new GraphQLSubstoriesConnection$Deserializer());
    }

    public Object m22003a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSubstoriesConnectionDeserializer.m6015a(jsonParser, (short) 247);
        Object graphQLSubstoriesConnection = new GraphQLSubstoriesConnection();
        ((BaseModel) graphQLSubstoriesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSubstoriesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLSubstoriesConnection).a();
        }
        return graphQLSubstoriesConnection;
    }
}
