package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: need_split_flow */
public class GraphQLQuestionOptionVotersConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuestionOptionVotersConnection.class, new GraphQLQuestionOptionVotersConnectionDeserializer());
    }

    public GraphQLQuestionOptionVotersConnectionDeserializer() {
        a(GraphQLQuestionOptionVotersConnection.class);
    }

    public Object m21178a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuestionOptionVotersConnection__JsonHelper.m21180a(jsonParser);
    }
}
