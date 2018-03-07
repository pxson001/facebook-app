package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_timeline_action_menu_report_page */
public class GraphQLSeenByConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSeenByConnection.class, new GraphQLSeenByConnectionDeserializer());
    }

    public GraphQLSeenByConnectionDeserializer() {
        a(GraphQLSeenByConnection.class);
    }

    public Object m21631a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSeenByConnection__JsonHelper.a(jsonParser);
    }
}
