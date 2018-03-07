package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_spyml */
public class GraphQLStoryAttachmentStyleInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryAttachmentStyleInfo.class, new GraphQLStoryAttachmentStyleInfoDeserializer());
    }

    public GraphQLStoryAttachmentStyleInfoDeserializer() {
        a(GraphQLStoryAttachmentStyleInfo.class);
    }

    public Object m21857a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStoryAttachmentStyleInfo__JsonHelper.m21859a(jsonParser);
    }
}
