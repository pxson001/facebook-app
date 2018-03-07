package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: onPostInitComplete can be called only once per call to getRemoteService */
public class GraphQLMediaSetMediaConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMediaSetMediaConnection.class, new GraphQLMediaSetMediaConnectionDeserializer());
    }

    public GraphQLMediaSetMediaConnectionDeserializer() {
        a(GraphQLMediaSetMediaConnection.class);
    }

    public Object m9071a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMediaSetMediaConnection__JsonHelper.m9073a(jsonParser);
    }
}
