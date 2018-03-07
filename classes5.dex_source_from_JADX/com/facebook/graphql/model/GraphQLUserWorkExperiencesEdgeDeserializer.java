package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: messenger_entry_send_as_message */
public class GraphQLUserWorkExperiencesEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUserWorkExperiencesEdge.class, new GraphQLUserWorkExperiencesEdgeDeserializer());
    }

    public GraphQLUserWorkExperiencesEdgeDeserializer() {
        a(GraphQLUserWorkExperiencesEdge.class);
    }

    public Object m22412a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLUserWorkExperiencesEdge__JsonHelper.m22414a(jsonParser);
    }
}
