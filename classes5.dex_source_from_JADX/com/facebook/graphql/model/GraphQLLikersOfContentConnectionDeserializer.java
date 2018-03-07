package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: open_graph_composer_preview */
public class GraphQLLikersOfContentConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLikersOfContentConnection.class, new GraphQLLikersOfContentConnectionDeserializer());
    }

    public GraphQLLikersOfContentConnectionDeserializer() {
        a(GraphQLLikersOfContentConnection.class);
    }

    public Object m8918a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLikersOfContentConnection__JsonHelper.a(jsonParser);
    }
}
