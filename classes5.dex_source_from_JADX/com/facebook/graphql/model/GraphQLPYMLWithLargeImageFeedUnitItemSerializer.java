package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: error_calling_setSoSndTimeout */
public class GraphQLPYMLWithLargeImageFeedUnitItemSerializer extends JsonSerializer<GraphQLPYMLWithLargeImageFeedUnitItem> {
    public final void m9443a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPYMLWithLargeImageFeedUnitItem__JsonHelper.m9445a(jsonGenerator, (GraphQLPYMLWithLargeImageFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnitItem.class, new GraphQLPYMLWithLargeImageFeedUnitItemSerializer());
    }
}
