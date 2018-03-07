package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: focus_point */
public class GraphQLImageDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLImage.class, new GraphQLImageDeserializer());
    }

    public GraphQLImageDeserializer() {
        a(GraphQLImage.class);
    }

    public Object m8625a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLImage__JsonHelper.a(jsonParser);
    }
}
