package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pending_page_invite_netego */
public class GraphQLEntityCardContextItemIconDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEntityCardContextItemIcon.class, new GraphQLEntityCardContextItemIconDeserializer());
    }

    public GraphQLEntityCardContextItemIconDeserializer() {
        a(GraphQLEntityCardContextItemIcon.class);
    }

    public Object m7066a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEntityCardContextItemIcon__JsonHelper.m7068a(jsonParser);
    }
}
