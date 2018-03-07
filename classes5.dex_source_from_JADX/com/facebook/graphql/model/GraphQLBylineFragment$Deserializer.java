package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLBylineFragmentDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_explicit_location */
public class GraphQLBylineFragment$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBylineFragment.class, new GraphQLBylineFragment$Deserializer());
    }

    public Object m6707a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLBylineFragmentDeserializer.m4633a(jsonParser, (short) 217);
        Object graphQLBylineFragment = new GraphQLBylineFragment();
        ((BaseModel) graphQLBylineFragment).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLBylineFragment instanceof Postprocessable) {
            return ((Postprocessable) graphQLBylineFragment).a();
        }
        return graphQLBylineFragment;
    }
}
