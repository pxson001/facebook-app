package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: miyml */
public class GraphQLTimelineSectionUnitsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineSectionUnitsConnection.class, new GraphQLTimelineSectionUnitsConnectionDeserializer());
    }

    public GraphQLTimelineSectionUnitsConnectionDeserializer() {
        a(GraphQLTimelineSectionUnitsConnection.class);
    }

    public Object m22201a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimelineSectionUnitsConnection__JsonHelper.m22203a(jsonParser);
    }
}
