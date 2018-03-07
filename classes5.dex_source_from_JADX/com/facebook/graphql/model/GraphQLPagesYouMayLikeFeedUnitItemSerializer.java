package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND */
public class GraphQLPagesYouMayLikeFeedUnitItemSerializer extends JsonSerializer<GraphQLPagesYouMayLikeFeedUnitItem> {
    public final void m20578a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPagesYouMayLikeFeedUnitItem__JsonHelper.m20580a(jsonGenerator, (GraphQLPagesYouMayLikeFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPagesYouMayLikeFeedUnitItem.class, new GraphQLPagesYouMayLikeFeedUnitItemSerializer());
    }
}
