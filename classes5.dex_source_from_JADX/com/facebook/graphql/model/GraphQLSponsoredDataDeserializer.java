package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: more_games */
public class GraphQLSponsoredDataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSponsoredData.class, new GraphQLSponsoredDataDeserializer());
    }

    public GraphQLSponsoredDataDeserializer() {
        a(GraphQLSponsoredData.class);
    }

    public Object m21754a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSponsoredData__JsonHelper.m21756a(jsonParser);
    }
}
