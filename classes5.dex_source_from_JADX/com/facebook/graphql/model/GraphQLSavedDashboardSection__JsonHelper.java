package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VERTICAL_ACTION_WITH_COMPONENTS_STATEFUL_LIST */
public final class GraphQLSavedDashboardSection__JsonHelper {
    public static GraphQLSavedDashboardSection m21557a(JsonParser jsonParser) {
        GraphQLSavedDashboardSection graphQLSavedDashboardSection = new GraphQLSavedDashboardSection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("section_type".equals(i)) {
                graphQLSavedDashboardSection.d = GraphQLSavedDashboardSectionType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLSavedDashboardSection, "section_type", graphQLSavedDashboardSection.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLSavedDashboardSection;
    }

    public static void m21558a(JsonGenerator jsonGenerator, GraphQLSavedDashboardSection graphQLSavedDashboardSection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSavedDashboardSection.a() != null) {
            jsonGenerator.a("section_type", graphQLSavedDashboardSection.a().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
