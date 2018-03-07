package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: national_number */
public class GraphQLResearchPollFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m21401a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = new GraphQLResearchPollFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLResearchPollFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLResearchPollFeedUnit__JsonHelper.m21403a(graphQLResearchPollFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLResearchPollFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResearchPollFeedUnit.class, new GraphQLResearchPollFeedUnitDeserializer());
    }

    public GraphQLResearchPollFeedUnitDeserializer() {
        a(GraphQLResearchPollFeedUnit.class);
    }
}
