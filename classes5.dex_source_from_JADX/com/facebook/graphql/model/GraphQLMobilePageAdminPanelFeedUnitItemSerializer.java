package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: facepile_profile_picture_urls */
public class GraphQLMobilePageAdminPanelFeedUnitItemSerializer extends JsonSerializer<GraphQLMobilePageAdminPanelFeedUnitItem> {
    public final void m9129a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMobilePageAdminPanelFeedUnitItem__JsonHelper.m9131a(jsonGenerator, (GraphQLMobilePageAdminPanelFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMobilePageAdminPanelFeedUnitItem.class, new GraphQLMobilePageAdminPanelFeedUnitItemSerializer());
    }
}
