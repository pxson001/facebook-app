package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ios_context_row_suggest_edits */
public final class GraphQLEligibleClashUnitsEdge__JsonHelper {
    public static GraphQLEligibleClashUnitsEdge m6999a(JsonParser jsonParser) {
        GraphQLEligibleClashUnitsEdge graphQLEligibleClashUnitsEdge = new GraphQLEligibleClashUnitsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLClashUnit graphQLClashUnit;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLClashUnit = null;
                } else {
                    graphQLClashUnit = GraphQLClashUnit__JsonHelper.m6772a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLEligibleClashUnitsEdge.f3524d = graphQLClashUnit;
                FieldAccessQueryTracker.a(jsonParser, graphQLEligibleClashUnitsEdge, "node", graphQLEligibleClashUnitsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEligibleClashUnitsEdge;
    }

    public static void m7000a(JsonGenerator jsonGenerator, GraphQLEligibleClashUnitsEdge graphQLEligibleClashUnitsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEligibleClashUnitsEdge.m6995a() != null) {
            jsonGenerator.a("node");
            GraphQLClashUnit__JsonHelper.m6773a(jsonGenerator, graphQLEligibleClashUnitsEdge.m6995a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
