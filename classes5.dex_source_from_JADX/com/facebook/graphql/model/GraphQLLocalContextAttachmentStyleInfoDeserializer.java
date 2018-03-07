package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: open_fd_hard_limit */
public class GraphQLLocalContextAttachmentStyleInfoDeserializer extends FbJsonDeserializer {
    public Object m8957a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLLocalContextAttachmentStyleInfo graphQLLocalContextAttachmentStyleInfo = new GraphQLLocalContextAttachmentStyleInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLLocalContextAttachmentStyleInfo = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLLocalContextAttachmentStyleInfo__JsonHelper.m8959a(graphQLLocalContextAttachmentStyleInfo, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLLocalContextAttachmentStyleInfo;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLocalContextAttachmentStyleInfo.class, new GraphQLLocalContextAttachmentStyleInfoDeserializer());
    }

    public GraphQLLocalContextAttachmentStyleInfoDeserializer() {
        a(GraphQLLocalContextAttachmentStyleInfo.class);
    }
}
