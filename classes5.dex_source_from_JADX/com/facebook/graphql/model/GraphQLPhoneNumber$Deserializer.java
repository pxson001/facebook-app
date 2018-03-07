package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPhoneNumberDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WITHIN_FEW_HOURS */
public class GraphQLPhoneNumber$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhoneNumber.class, new GraphQLPhoneNumber$Deserializer());
    }

    public Object m20709a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPhoneNumberDeserializer.m5599a(jsonParser, (short) 263);
        Object graphQLPhoneNumber = new GraphQLPhoneNumber();
        ((BaseModel) graphQLPhoneNumber).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPhoneNumber instanceof Postprocessable) {
            return ((Postprocessable) graphQLPhoneNumber).a();
        }
        return graphQLPhoneNumber;
    }
}
