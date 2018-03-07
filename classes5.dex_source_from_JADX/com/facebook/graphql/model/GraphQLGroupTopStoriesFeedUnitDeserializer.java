package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: otherEventMembers */
public class GraphQLGroupTopStoriesFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m8496a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGroupTopStoriesFeedUnit graphQLGroupTopStoriesFeedUnit = new GraphQLGroupTopStoriesFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGroupTopStoriesFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLGroupTopStoriesFeedUnit__JsonHelper.m8517a(graphQLGroupTopStoriesFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGroupTopStoriesFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupTopStoriesFeedUnit.class, new GraphQLGroupTopStoriesFeedUnitDeserializer());
    }

    public GraphQLGroupTopStoriesFeedUnitDeserializer() {
        a(GraphQLGroupTopStoriesFeedUnit.class);
    }
}
