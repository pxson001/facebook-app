package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: onScale/setParameters failed */
public class GraphQLMediaQuestionOptionsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMediaQuestionOptionsEdge.class, new GraphQLMediaQuestionOptionsEdgeDeserializer());
    }

    public GraphQLMediaQuestionOptionsEdgeDeserializer() {
        a(GraphQLMediaQuestionOptionsEdge.class);
    }

    public Object m9056a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMediaQuestionOptionsEdge__JsonHelper.m9058a(jsonParser);
    }
}
