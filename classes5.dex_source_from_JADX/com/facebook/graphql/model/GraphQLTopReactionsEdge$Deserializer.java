package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTopReactionsEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UI_EXPLORER */
public class GraphQLTopReactionsEdge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopReactionsEdge.class, new GraphQLTopReactionsEdge$Deserializer());
    }

    public Object m22253a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTopReactionsEdgeDeserializer.m6108a(jsonParser, (short) 211);
        Object graphQLTopReactionsEdge = new GraphQLTopReactionsEdge();
        ((BaseModel) graphQLTopReactionsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTopReactionsEdge instanceof Postprocessable) {
            return ((Postprocessable) graphQLTopReactionsEdge).a();
        }
        return graphQLTopReactionsEdge;
    }
}
