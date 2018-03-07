package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_CHANNEL_RECOMMENDATION_SQUARE */
public final class GraphQLResearchPollResponseRespondersConnection__JsonHelper {
    public static GraphQLResearchPollResponseRespondersConnection m21463a(JsonParser jsonParser) {
        GraphQLResearchPollResponseRespondersConnection graphQLResearchPollResponseRespondersConnection = new GraphQLResearchPollResponseRespondersConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("count".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLResearchPollResponseRespondersConnection.f12930d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollResponseRespondersConnection, "count", graphQLResearchPollResponseRespondersConnection.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLResearchPollResponseRespondersConnection;
    }

    public static void m21464a(JsonGenerator jsonGenerator, GraphQLResearchPollResponseRespondersConnection graphQLResearchPollResponseRespondersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLResearchPollResponseRespondersConnection.m21457a());
        if (z) {
            jsonGenerator.g();
        }
    }
}
