package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WOMENS_HEALTH */
public class GraphQLPeopleYouMayKnowFeedUnitItemSerializer extends JsonSerializer<GraphQLPeopleYouMayKnowFeedUnitItem> {
    public final void m20685a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper.m20687a(jsonGenerator, (GraphQLPeopleYouMayKnowFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouMayKnowFeedUnitItem.class, new GraphQLPeopleYouMayKnowFeedUnitItemSerializer());
    }
}
