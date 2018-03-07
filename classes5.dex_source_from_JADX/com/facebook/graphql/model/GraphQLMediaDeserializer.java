package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: on_this_day_friendversary_card */
public class GraphQLMediaDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMedia.class, new GraphQLMediaDeserializer());
    }

    public GraphQLMediaDeserializer() {
        a(GraphQLMedia.class);
    }

    public Object m9014a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMedia__JsonHelper.m9078a(jsonParser);
    }
}
