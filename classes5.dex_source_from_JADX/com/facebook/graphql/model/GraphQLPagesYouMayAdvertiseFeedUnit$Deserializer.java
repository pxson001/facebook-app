package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPagesYouMayAdvertiseFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: emailSignInOptions */
public class GraphQLPagesYouMayAdvertiseFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPagesYouMayAdvertiseFeedUnit.class, new GraphQLPagesYouMayAdvertiseFeedUnit$Deserializer());
    }

    public Object m9556a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPagesYouMayAdvertiseFeedUnitDeserializer.m5537a(jsonParser, (short) 119);
        Object graphQLPagesYouMayAdvertiseFeedUnit = new GraphQLPagesYouMayAdvertiseFeedUnit();
        ((BaseModel) graphQLPagesYouMayAdvertiseFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPagesYouMayAdvertiseFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLPagesYouMayAdvertiseFeedUnit).a();
        }
        return graphQLPagesYouMayAdvertiseFeedUnit;
    }
}
