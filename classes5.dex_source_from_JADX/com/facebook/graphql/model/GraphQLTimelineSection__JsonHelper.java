package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNDO_DISMISS */
public final class GraphQLTimelineSection__JsonHelper {
    public static GraphQLTimelineSection m22217a(JsonParser jsonParser) {
        GraphQLTimelineSection graphQLTimelineSection = new GraphQLTimelineSection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTimelineSection.f13335d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSection, "id", graphQLTimelineSection.a_, 0, false);
            } else if ("label".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTimelineSection.f13336e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSection, "label", graphQLTimelineSection.a_, 1, false);
            } else if ("timeline_units".equals(i)) {
                GraphQLTimelineSectionUnitsConnection graphQLTimelineSectionUnitsConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTimelineSectionUnitsConnection = null;
                } else {
                    graphQLTimelineSectionUnitsConnection = GraphQLTimelineSectionUnitsConnection__JsonHelper.m22203a(FieldAccessQueryTracker.a(jsonParser, "timeline_units"));
                }
                graphQLTimelineSection.f13337f = graphQLTimelineSectionUnitsConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSection, "timeline_units", graphQLTimelineSection.a_, 2, true);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTimelineSection.f13338g = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSection, "url", graphQLTimelineSection.a_, 3, false);
            } else if ("year".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLTimelineSection.f13339h = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSection, "year", graphQLTimelineSection.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLTimelineSection;
    }

    public static void m22218a(JsonGenerator jsonGenerator, GraphQLTimelineSection graphQLTimelineSection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTimelineSection.m22188j() != null) {
            jsonGenerator.a("id", graphQLTimelineSection.m22188j());
        }
        if (graphQLTimelineSection.m22189k() != null) {
            jsonGenerator.a("label", graphQLTimelineSection.m22189k());
        }
        if (graphQLTimelineSection.m22190l() != null) {
            jsonGenerator.a("timeline_units");
            GraphQLTimelineSectionUnitsConnection__JsonHelper.m22204a(jsonGenerator, graphQLTimelineSection.m22190l(), true);
        }
        if (graphQLTimelineSection.m22191m() != null) {
            jsonGenerator.a("url", graphQLTimelineSection.m22191m());
        }
        jsonGenerator.a("year", graphQLTimelineSection.m22192n());
        if (z) {
            jsonGenerator.g();
        }
    }
}
