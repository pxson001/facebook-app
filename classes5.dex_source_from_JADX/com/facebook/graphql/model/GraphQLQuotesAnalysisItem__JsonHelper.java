package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIEW_GROUP */
public final class GraphQLQuotesAnalysisItem__JsonHelper {
    public static GraphQLQuotesAnalysisItem m21281a(JsonParser jsonParser) {
        GraphQLQuotesAnalysisItem graphQLQuotesAnalysisItem = new GraphQLQuotesAnalysisItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("count".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLQuotesAnalysisItem.f12877d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuotesAnalysisItem, "count", graphQLQuotesAnalysisItem.a_, 0, false);
            } else if ("quote".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLQuotesAnalysisItem.f12878e = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuotesAnalysisItem, "quote", graphQLQuotesAnalysisItem.a_, 1, false);
            } else {
                int i3 = 0;
            }
            jsonParser.f();
        }
        return graphQLQuotesAnalysisItem;
    }

    public static void m21282a(JsonGenerator jsonGenerator, GraphQLQuotesAnalysisItem graphQLQuotesAnalysisItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLQuotesAnalysisItem.m21274a());
        if (graphQLQuotesAnalysisItem.m21278j() != null) {
            jsonGenerator.a("quote", graphQLQuotesAnalysisItem.m21278j());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
