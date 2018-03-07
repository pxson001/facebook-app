package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: persistent_fragment */
public class GraphQLCustomizedStoryDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCustomizedStory.class, new GraphQLCustomizedStoryDeserializer());
    }

    public GraphQLCustomizedStoryDeserializer() {
        a(GraphQLCustomizedStory.class);
    }

    public Object m6928a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLCustomizedStory__JsonHelper.a(jsonParser);
    }
}
