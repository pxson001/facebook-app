package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPageDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: entry no longer in map */
public class GraphQLPage$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPage.class, new GraphQLPage$Deserializer());
    }

    public Object m9461a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPageDeserializer.m5502a(jsonParser, (short) 1);
        Object graphQLPage = new GraphQLPage();
        ((BaseModel) graphQLPage).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPage instanceof Postprocessable) {
            return ((Postprocessable) graphQLPage).a();
        }
        return graphQLPage;
    }
}
