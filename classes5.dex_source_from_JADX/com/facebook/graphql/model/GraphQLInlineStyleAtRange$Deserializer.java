package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLInlineStyleAtRangeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: finch_more */
public class GraphQLInlineStyleAtRange$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInlineStyleAtRange.class, new GraphQLInlineStyleAtRange$Deserializer());
    }

    public Object m8699a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLInlineStyleAtRangeDeserializer.m5251a(jsonParser, (short) 284);
        Object graphQLInlineStyleAtRange = new GraphQLInlineStyleAtRange();
        ((BaseModel) graphQLInlineStyleAtRange).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLInlineStyleAtRange instanceof Postprocessable) {
            return ((Postprocessable) graphQLInlineStyleAtRange).a();
        }
        return graphQLInlineStyleAtRange;
    }
}
