package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCurrencyQuantityDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ios_report_duplicate */
public class GraphQLCurrencyQuantity$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCurrencyQuantity.class, new GraphQLCurrencyQuantity$Deserializer());
    }

    public Object m6920a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLCurrencyQuantityDeserializer.m4701a(jsonParser, (short) 220);
        Object graphQLCurrencyQuantity = new GraphQLCurrencyQuantity();
        ((BaseModel) graphQLCurrencyQuantity).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLCurrencyQuantity instanceof Postprocessable) {
            return ((Postprocessable) graphQLCurrencyQuantity).a();
        }
        return graphQLCurrencyQuantity;
    }
}
