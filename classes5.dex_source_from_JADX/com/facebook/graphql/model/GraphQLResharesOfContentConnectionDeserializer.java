package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: music_pyml */
public class GraphQLResharesOfContentConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResharesOfContentConnection.class, new GraphQLResharesOfContentConnectionDeserializer());
    }

    public GraphQLResharesOfContentConnectionDeserializer() {
        a(GraphQLResharesOfContentConnection.class);
    }

    public Object m21502a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLResharesOfContentConnection__JsonHelper.m21504a(jsonParser);
    }
}
