package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: og_suggestion_mechanism */
public class GraphQLMobilePageAdminPanelFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMobilePageAdminPanelFeedUnitItem.class, new GraphQLMobilePageAdminPanelFeedUnitItemDeserializer());
    }

    public GraphQLMobilePageAdminPanelFeedUnitItemDeserializer() {
        a(GraphQLMobilePageAdminPanelFeedUnitItem.class);
    }

    public Object m9128a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMobilePageAdminPanelFeedUnitItem__JsonHelper.m9130a(jsonParser);
    }
}
