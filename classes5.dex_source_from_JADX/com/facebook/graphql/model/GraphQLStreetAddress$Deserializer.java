package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStreetAddressDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: USER_CANCEL */
public class GraphQLStreetAddress$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStreetAddress.class, new GraphQLStreetAddress$Deserializer());
    }

    public Object m21932a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStreetAddressDeserializer.m5995a(jsonParser, (short) 164);
        Object graphQLStreetAddress = new GraphQLStreetAddress();
        ((BaseModel) graphQLStreetAddress).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStreetAddress instanceof Postprocessable) {
            return ((Postprocessable) graphQLStreetAddress).a();
        }
        return graphQLStreetAddress;
    }
}
