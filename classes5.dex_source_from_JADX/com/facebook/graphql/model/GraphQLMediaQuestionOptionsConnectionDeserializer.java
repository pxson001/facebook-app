package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: onTouch/setParameters failed */
public class GraphQLMediaQuestionOptionsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMediaQuestionOptionsConnection.class, new GraphQLMediaQuestionOptionsConnectionDeserializer());
    }

    public GraphQLMediaQuestionOptionsConnectionDeserializer() {
        a(GraphQLMediaQuestionOptionsConnection.class);
    }

    public Object m9047a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMediaQuestionOptionsConnection__JsonHelper.m9049a(jsonParser);
    }
}
