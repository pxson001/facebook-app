package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: message_res_id */
public class GraphQLVideoTimestampedCommentsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoTimestampedCommentsConnection.class, new GraphQLVideoTimestampedCommentsConnectionDeserializer());
    }

    public GraphQLVideoTimestampedCommentsConnectionDeserializer() {
        a(GraphQLVideoTimestampedCommentsConnection.class);
    }

    public Object m22470a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLVideoTimestampedCommentsConnection__JsonHelper.m22472a(jsonParser);
    }
}
