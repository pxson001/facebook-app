package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTopReactionsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNARCHIVE_BUTTON */
public class GraphQLTopReactionsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopReactionsConnection.class, new GraphQLTopReactionsConnection$Deserializer());
    }

    public Object m22248a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTopReactionsConnectionDeserializer.m6105a(jsonParser, (short) 210);
        Object graphQLTopReactionsConnection = new GraphQLTopReactionsConnection();
        ((BaseModel) graphQLTopReactionsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTopReactionsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLTopReactionsConnection).a();
        }
        return graphQLTopReactionsConnection;
    }
}
