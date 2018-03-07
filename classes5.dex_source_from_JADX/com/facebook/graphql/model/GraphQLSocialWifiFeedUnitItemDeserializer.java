package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_map_report_button_menu */
public class GraphQLSocialWifiFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSocialWifiFeedUnitItem.class, new GraphQLSocialWifiFeedUnitItemDeserializer());
    }

    public GraphQLSocialWifiFeedUnitItemDeserializer() {
        a(GraphQLSocialWifiFeedUnitItem.class);
    }

    public Object m21682a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSocialWifiFeedUnitItem__JsonHelper.m21684a(jsonParser);
    }
}
