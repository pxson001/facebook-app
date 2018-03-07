package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: error_for_logging */
public class GraphQLPYMLWithLargeImageFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPYMLWithLargeImageFeedUnit.class, new GraphQLPYMLWithLargeImageFeedUnit$Deserializer());
    }

    public Object m9437a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPYMLWithLargeImageFeedUnitDeserializer.m5480a(jsonParser, (short) 122);
        Object graphQLPYMLWithLargeImageFeedUnit = new GraphQLPYMLWithLargeImageFeedUnit();
        ((BaseModel) graphQLPYMLWithLargeImageFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPYMLWithLargeImageFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLPYMLWithLargeImageFeedUnit).a();
        }
        return graphQLPYMLWithLargeImageFeedUnit;
    }
}
