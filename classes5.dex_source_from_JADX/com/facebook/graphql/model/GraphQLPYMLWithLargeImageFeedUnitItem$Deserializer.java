package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitItemDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: error_codes */
public class GraphQLPYMLWithLargeImageFeedUnitItem$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPYMLWithLargeImageFeedUnitItem.class, new GraphQLPYMLWithLargeImageFeedUnitItem$Deserializer());
    }

    public Object m9440a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPYMLWithLargeImageFeedUnitItemDeserializer.m5483a(jsonParser, (short) 268);
        Object graphQLPYMLWithLargeImageFeedUnitItem = new GraphQLPYMLWithLargeImageFeedUnitItem();
        ((BaseModel) graphQLPYMLWithLargeImageFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPYMLWithLargeImageFeedUnitItem instanceof Postprocessable) {
            return ((Postprocessable) graphQLPYMLWithLargeImageFeedUnitItem).a();
        }
        return graphQLPYMLWithLargeImageFeedUnitItem;
    }
}
