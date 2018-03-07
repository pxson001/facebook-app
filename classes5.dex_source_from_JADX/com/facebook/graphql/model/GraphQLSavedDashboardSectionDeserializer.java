package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: multiShareItemSquareImage */
public class GraphQLSavedDashboardSectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSavedDashboardSection.class, new GraphQLSavedDashboardSectionDeserializer());
    }

    public GraphQLSavedDashboardSectionDeserializer() {
        a(GraphQLSavedDashboardSection.class);
    }

    public Object m21555a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSavedDashboardSection__JsonHelper.m21557a(jsonParser);
    }
}
