package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WHITELIST */
public final class GraphQLPhrasesAnalysisItem__JsonHelper {
    public static GraphQLPhrasesAnalysisItem m20807a(JsonParser jsonParser) {
        GraphQLPhrasesAnalysisItem graphQLPhrasesAnalysisItem = new GraphQLPhrasesAnalysisItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPhrasesAnalysisItem.f12579d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItem, "count", graphQLPhrasesAnalysisItem.a_, 0, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhrasesAnalysisItem.f12580e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItem, "id", graphQLPhrasesAnalysisItem.a_, 1, false);
            } else if ("more_posts_query".equals(i)) {
                GraphQLGraphSearchQuery graphQLGraphSearchQuery;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLGraphSearchQuery = null;
                } else {
                    graphQLGraphSearchQuery = GraphQLGraphSearchQuery__JsonHelper.m8265a(FieldAccessQueryTracker.a(jsonParser, "more_posts_query"));
                }
                graphQLPhrasesAnalysisItem.f12581f = graphQLGraphSearchQuery;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItem, "more_posts_query", graphQLPhrasesAnalysisItem.a_, 2, true);
            } else if ("phrase".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhrasesAnalysisItem.f12582g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItem, "phrase", graphQLPhrasesAnalysisItem.a_, 3, false);
            } else if ("phrase_length".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPhrasesAnalysisItem.f12583h = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItem, "phrase_length", graphQLPhrasesAnalysisItem.a_, 4, false);
            } else if ("phrase_offset".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPhrasesAnalysisItem.f12584i = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItem, "phrase_offset", graphQLPhrasesAnalysisItem.a_, 5, false);
            } else if ("phrase_owner".equals(i)) {
                GraphQLProfile graphQLProfile;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLProfile = null;
                } else {
                    graphQLProfile = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "phrase_owner"));
                }
                graphQLPhrasesAnalysisItem.f12585j = graphQLProfile;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItem, "phrase_owner", graphQLPhrasesAnalysisItem.a_, 6, true);
            } else if ("sample_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhrasesAnalysisItem.f12586k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItem, "sample_text", graphQLPhrasesAnalysisItem.a_, 7, false);
            } else if ("sentence".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhrasesAnalysisItem.f12587l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItem, "sentence", graphQLPhrasesAnalysisItem.a_, 8, false);
            } else if ("url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPhrasesAnalysisItem.f12588m = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhrasesAnalysisItem, "url", graphQLPhrasesAnalysisItem.a_, 9, false);
            }
            jsonParser.f();
        }
        return graphQLPhrasesAnalysisItem;
    }

    public static void m20808a(JsonGenerator jsonGenerator, GraphQLPhrasesAnalysisItem graphQLPhrasesAnalysisItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLPhrasesAnalysisItem.m20795j());
        if (graphQLPhrasesAnalysisItem.m20796k() != null) {
            jsonGenerator.a("id", graphQLPhrasesAnalysisItem.m20796k());
        }
        if (graphQLPhrasesAnalysisItem.m20797l() != null) {
            jsonGenerator.a("more_posts_query");
            GraphQLGraphSearchQuery__JsonHelper.m8266a(jsonGenerator, graphQLPhrasesAnalysisItem.m20797l(), true);
        }
        if (graphQLPhrasesAnalysisItem.m20798m() != null) {
            jsonGenerator.a("phrase", graphQLPhrasesAnalysisItem.m20798m());
        }
        jsonGenerator.a("phrase_length", graphQLPhrasesAnalysisItem.m20799n());
        jsonGenerator.a("phrase_offset", graphQLPhrasesAnalysisItem.m20800o());
        if (graphQLPhrasesAnalysisItem.m20801p() != null) {
            jsonGenerator.a("phrase_owner");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLPhrasesAnalysisItem.m20801p(), true);
        }
        if (graphQLPhrasesAnalysisItem.m20802q() != null) {
            jsonGenerator.a("sample_text", graphQLPhrasesAnalysisItem.m20802q());
        }
        if (graphQLPhrasesAnalysisItem.m20803r() != null) {
            jsonGenerator.a("sentence", graphQLPhrasesAnalysisItem.m20803r());
        }
        if (graphQLPhrasesAnalysisItem.m20804s() != null) {
            jsonGenerator.a("url", graphQLPhrasesAnalysisItem.m20804s());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
