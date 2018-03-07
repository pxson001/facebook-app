package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_cancelable */
public class GraphQLCollectionsRatingFeedUnitItemSerializer extends JsonSerializer<GraphQLCollectionsRatingFeedUnitItem> {
    public final void m6797a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCollectionsRatingFeedUnitItem graphQLCollectionsRatingFeedUnitItem = (GraphQLCollectionsRatingFeedUnitItem) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLCollectionsRatingFeedUnitItem.m6793a() != null) {
            jsonGenerator.a("profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLCollectionsRatingFeedUnitItem.m6793a(), true);
        }
        if (graphQLCollectionsRatingFeedUnitItem.m6795j() != null) {
            jsonGenerator.a("tracking", graphQLCollectionsRatingFeedUnitItem.m6795j());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLCollectionsRatingFeedUnitItem.class, new GraphQLCollectionsRatingFeedUnitItemSerializer());
    }
}
