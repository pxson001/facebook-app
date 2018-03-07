package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WIZARD_CLASSMATES_COWORKERS */
public class GraphQLPeopleYouShouldFollowFeedUnitItemSerializer extends JsonSerializer<GraphQLPeopleYouShouldFollowFeedUnitItem> {
    public final void m20704a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouShouldFollowFeedUnitItem__JsonHelper.m20706a(jsonGenerator, (GraphQLPeopleYouShouldFollowFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouShouldFollowFeedUnitItem.class, new GraphQLPeopleYouShouldFollowFeedUnitItemSerializer());
    }
}
