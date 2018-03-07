package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPagesYouMayLikeFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: eglInitialize */
public class GraphQLPagesYouMayLikeFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPagesYouMayLikeFeedUnit.class, new GraphQLPagesYouMayLikeFeedUnit$Deserializer());
    }

    public Object m9575a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPagesYouMayLikeFeedUnitDeserializer.m5544a(jsonParser, (short) 123);
        Object graphQLPagesYouMayLikeFeedUnit = new GraphQLPagesYouMayLikeFeedUnit();
        ((BaseModel) graphQLPagesYouMayLikeFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPagesYouMayLikeFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLPagesYouMayLikeFeedUnit).a();
        }
        return graphQLPagesYouMayLikeFeedUnit;
    }
}
