package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLInlineActivityDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: fire_review_after_snap */
public class GraphQLInlineActivity$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInlineActivity.class, new GraphQLInlineActivity$Deserializer());
    }

    public Object m8692a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLInlineActivityDeserializer.m5248a(jsonParser, (short) 66);
        Object graphQLInlineActivity = new GraphQLInlineActivity();
        ((BaseModel) graphQLInlineActivity).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLInlineActivity instanceof Postprocessable) {
            return ((Postprocessable) graphQLInlineActivity).a();
        }
        return graphQLInlineActivity;
    }
}
