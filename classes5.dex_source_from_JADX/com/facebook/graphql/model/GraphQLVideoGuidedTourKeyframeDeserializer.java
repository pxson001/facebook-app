package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: message_summary */
public class GraphQLVideoGuidedTourKeyframeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoGuidedTourKeyframe.class, new GraphQLVideoGuidedTourKeyframeDeserializer());
    }

    public GraphQLVideoGuidedTourKeyframeDeserializer() {
        a(GraphQLVideoGuidedTourKeyframe.class);
    }

    public Object m22460a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLVideoGuidedTourKeyframe__JsonHelper.m22462a(jsonParser);
    }
}
