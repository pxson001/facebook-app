package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLContactDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: isIncompleteData */
public class GraphQLContact$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLContact.class, new GraphQLContact$Deserializer());
    }

    public Object m6861a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLContactDeserializer.m4678a(jsonParser, (short) 13);
        Object graphQLContact = new GraphQLContact();
        ((BaseModel) graphQLContact).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLContact instanceof Postprocessable) {
            return ((Postprocessable) graphQLContact).a();
        }
        return graphQLContact;
    }
}
