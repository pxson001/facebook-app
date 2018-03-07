package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego */
public class GraphQLPrivateReplyContextDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivateReplyContext.class, new GraphQLPrivateReplyContextDeserializer());
    }

    public GraphQLPrivateReplyContextDeserializer() {
        a(GraphQLPrivateReplyContext.class);
    }

    public Object m21037a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivateReplyContext__JsonHelper.m21039a(jsonParser);
    }
}
