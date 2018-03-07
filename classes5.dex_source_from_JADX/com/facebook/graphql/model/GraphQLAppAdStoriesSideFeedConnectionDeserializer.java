package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_edit_dialog_v2 */
public class GraphQLAppAdStoriesSideFeedConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAppAdStoriesSideFeedConnection.class, new GraphQLAppAdStoriesSideFeedConnectionDeserializer());
    }

    public GraphQLAppAdStoriesSideFeedConnectionDeserializer() {
        a(GraphQLAppAdStoriesSideFeedConnection.class);
    }

    public Object m6547a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAppAdStoriesSideFeedConnection__JsonHelper.m6549a(jsonParser);
    }
}
