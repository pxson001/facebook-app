package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPostTranslatabilityDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Visible child  */
public class GraphQLPostTranslatability$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPostTranslatability.class, new GraphQLPostTranslatability$Deserializer());
    }

    public Object m20966a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPostTranslatabilityDeserializer.m5683a(jsonParser, (short) 155);
        Object graphQLPostTranslatability = new GraphQLPostTranslatability();
        ((BaseModel) graphQLPostTranslatability).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPostTranslatability instanceof Postprocessable) {
            return ((Postprocessable) graphQLPostTranslatability).a();
        }
        return graphQLPostTranslatability;
    }
}
