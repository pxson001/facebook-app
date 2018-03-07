package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: minutiae_tag */
public class GraphQLTopLevelCommentsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopLevelCommentsConnection.class, new GraphQLTopLevelCommentsConnectionDeserializer());
    }

    public GraphQLTopLevelCommentsConnectionDeserializer() {
        a(GraphQLTopLevelCommentsConnection.class);
    }

    public Object m22246a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTopLevelCommentsConnection__JsonHelper.a(jsonParser);
    }
}
