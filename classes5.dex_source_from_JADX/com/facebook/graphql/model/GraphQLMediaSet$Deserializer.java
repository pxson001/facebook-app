package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLMediaSetDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: family_search */
public class GraphQLMediaSet$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMediaSet.class, new GraphQLMediaSet$Deserializer());
    }

    public Object m9065a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLMediaSetDeserializer.m5356a(jsonParser, (short) 302);
        Object graphQLMediaSet = new GraphQLMediaSet();
        ((BaseModel) graphQLMediaSet).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLMediaSet instanceof Postprocessable) {
            return ((Postprocessable) graphQLMediaSet).a();
        }
        return graphQLMediaSet;
    }
}
