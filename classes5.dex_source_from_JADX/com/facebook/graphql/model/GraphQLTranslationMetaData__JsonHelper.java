package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TrueTopicFeedOption */
public final class GraphQLTranslationMetaData__JsonHelper {
    public static GraphQLTranslationMetaData m22284a(JsonParser jsonParser) {
        GraphQLTranslationMetaData graphQLTranslationMetaData = new GraphQLTranslationMetaData();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("translation_confidence".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLTranslationMetaData.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLTranslationMetaData, "translation_confidence", graphQLTranslationMetaData.a_, 0, false);
            } else if ("translation_request_id".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLTranslationMetaData.e = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLTranslationMetaData, "translation_request_id", graphQLTranslationMetaData.a_, 1, false);
            } else {
                int i3 = 0;
            }
            jsonParser.f();
        }
        return graphQLTranslationMetaData;
    }

    public static void m22285a(JsonGenerator jsonGenerator, GraphQLTranslationMetaData graphQLTranslationMetaData, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("translation_confidence", graphQLTranslationMetaData.a());
        if (graphQLTranslationMetaData.j() != null) {
            jsonGenerator.a("translation_request_id", graphQLTranslationMetaData.j());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
