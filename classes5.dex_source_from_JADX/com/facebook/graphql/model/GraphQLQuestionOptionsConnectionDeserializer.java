package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: need_invitable_contacts */
public class GraphQLQuestionOptionsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuestionOptionsConnection.class, new GraphQLQuestionOptionsConnectionDeserializer());
    }

    public GraphQLQuestionOptionsConnectionDeserializer() {
        a(GraphQLQuestionOptionsConnection.class);
    }

    public Object m21189a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuestionOptionsConnection__JsonHelper.m21191a(jsonParser);
    }
}
