package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNIT_TEST */
public final class GraphQLTimelineAppSection__JsonHelper {
    public static GraphQLTimelineAppSection m22179a(JsonParser jsonParser) {
        GraphQLTimelineAppSection graphQLTimelineAppSection = new GraphQLTimelineAppSection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m22181a(graphQLTimelineAppSection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLTimelineAppSection;
    }

    private static boolean m22181a(GraphQLTimelineAppSection graphQLTimelineAppSection, String str, JsonParser jsonParser) {
        String str2 = null;
        GraphQLTimelineAppCollectionsConnection a;
        if ("collections".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTimelineAppCollectionsConnection__JsonHelper.m22173a(FieldAccessQueryTracker.a(jsonParser, "collections"));
            }
            graphQLTimelineAppSection.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "collections", graphQLTimelineAppSection.a_, 0, true);
            return true;
        } else if ("collectionsNoItems".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTimelineAppCollectionsConnection__JsonHelper.m22173a(FieldAccessQueryTracker.a(jsonParser, "collectionsNoItems"));
            }
            graphQLTimelineAppSection.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "collectionsNoItems", graphQLTimelineAppSection.B_(), 1, true);
            return true;
        } else if ("collectionsPeek".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTimelineAppCollectionsConnection__JsonHelper.m22173a(FieldAccessQueryTracker.a(jsonParser, "collectionsPeek"));
            }
            graphQLTimelineAppSection.f = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "collectionsPeek", graphQLTimelineAppSection.B_(), 2, true);
            return true;
        } else if ("icon_image".equals(str)) {
            GraphQLImage a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "icon_image"));
            }
            graphQLTimelineAppSection.g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "icon_image", graphQLTimelineAppSection.B_(), 4, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppSection.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "id", graphQLTimelineAppSection.B_(), 5, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppSection.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "name", graphQLTimelineAppSection.B_(), 6, false);
            return true;
        } else if ("section_type".equals(str)) {
            graphQLTimelineAppSection.j = GraphQLTimelineAppSectionType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "section_type", graphQLTimelineAppSection.B_(), 7, false);
            return true;
        } else if ("standalone_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppSection.k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "standalone_url", graphQLTimelineAppSection.B_(), 9, false);
            return true;
        } else if ("subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtitle"));
            }
            graphQLTimelineAppSection.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "subtitle", graphQLTimelineAppSection.B_(), 10, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLTimelineAppSection.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "title", graphQLTimelineAppSection.B_(), 11, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLTimelineAppSection.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "titleForSummary", graphQLTimelineAppSection.B_(), 12, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppSection.o = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "tracking", graphQLTimelineAppSection.B_(), 13, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppSection.p = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppSection, "url", graphQLTimelineAppSection.B_(), 14, false);
            return true;
        }
    }

    public static void m22180a(JsonGenerator jsonGenerator, GraphQLTimelineAppSection graphQLTimelineAppSection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTimelineAppSection.j() != null) {
            jsonGenerator.a("collections");
            GraphQLTimelineAppCollectionsConnection__JsonHelper.m22174a(jsonGenerator, graphQLTimelineAppSection.j(), true);
        }
        if (graphQLTimelineAppSection.k() != null) {
            jsonGenerator.a("collectionsNoItems");
            GraphQLTimelineAppCollectionsConnection__JsonHelper.m22174a(jsonGenerator, graphQLTimelineAppSection.k(), true);
        }
        if (graphQLTimelineAppSection.l() != null) {
            jsonGenerator.a("collectionsPeek");
            GraphQLTimelineAppCollectionsConnection__JsonHelper.m22174a(jsonGenerator, graphQLTimelineAppSection.l(), true);
        }
        if (graphQLTimelineAppSection.m() != null) {
            jsonGenerator.a("icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTimelineAppSection.m(), true);
        }
        if (graphQLTimelineAppSection.n() != null) {
            jsonGenerator.a("id", graphQLTimelineAppSection.n());
        }
        if (graphQLTimelineAppSection.o() != null) {
            jsonGenerator.a("name", graphQLTimelineAppSection.o());
        }
        if (graphQLTimelineAppSection.p() != null) {
            jsonGenerator.a("section_type", graphQLTimelineAppSection.p().toString());
        }
        if (graphQLTimelineAppSection.q() != null) {
            jsonGenerator.a("standalone_url", graphQLTimelineAppSection.q());
        }
        if (graphQLTimelineAppSection.r() != null) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTimelineAppSection.r(), true);
        }
        if (graphQLTimelineAppSection.s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTimelineAppSection.s(), true);
        }
        if (graphQLTimelineAppSection.t() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTimelineAppSection.t(), true);
        }
        if (graphQLTimelineAppSection.u() != null) {
            jsonGenerator.a("tracking", graphQLTimelineAppSection.u());
        }
        if (graphQLTimelineAppSection.v() != null) {
            jsonGenerator.a("url", graphQLTimelineAppSection.v());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
