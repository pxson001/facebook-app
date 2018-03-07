package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_top_of_feed */
public class GraphQLStoryAttachmentDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryAttachment.class, new GraphQLStoryAttachmentDeserializer());
    }

    public GraphQLStoryAttachmentDeserializer() {
        a(GraphQLStoryAttachment.class);
    }

    public Object m21853a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStoryAttachment__JsonHelper.m21862a(jsonParser);
    }
}
