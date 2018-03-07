package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: invite_policy */
public final class GraphQLEmotionalAnalysisItem__JsonHelper {
    public static GraphQLEmotionalAnalysisItem m7014a(JsonParser jsonParser) {
        GraphQLEmotionalAnalysisItem graphQLEmotionalAnalysisItem = new GraphQLEmotionalAnalysisItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPage graphQLPage = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLEmotionalAnalysisItem.f3525d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEmotionalAnalysisItem, "count", graphQLEmotionalAnalysisItem.a_, 0, false);
                i2 = 1;
            } else if ("icon_image".equals(i)) {
                GraphQLImage a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "icon_image"));
                }
                graphQLEmotionalAnalysisItem.f3526e = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLEmotionalAnalysisItem, "icon_image", graphQLEmotionalAnalysisItem.a_, 1, true);
                i2 = 1;
            } else if ("mood_page".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "mood_page"));
                }
                graphQLEmotionalAnalysisItem.f3527f = graphQLPage;
                FieldAccessQueryTracker.a(jsonParser, graphQLEmotionalAnalysisItem, "mood_page", graphQLEmotionalAnalysisItem.a_, 2, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLEmotionalAnalysisItem;
    }

    public static void m7015a(JsonGenerator jsonGenerator, GraphQLEmotionalAnalysisItem graphQLEmotionalAnalysisItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLEmotionalAnalysisItem.m7006a());
        if (graphQLEmotionalAnalysisItem.m7010j() != null) {
            jsonGenerator.a("icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEmotionalAnalysisItem.m7010j(), true);
        }
        if (graphQLEmotionalAnalysisItem.m7011k() != null) {
            jsonGenerator.a("mood_page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLEmotionalAnalysisItem.m7011k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
