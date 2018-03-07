package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNSET */
public final class GraphQLTaggableActivityIcon__JsonHelper {
    public static GraphQLTaggableActivityIcon m22054a(JsonParser jsonParser) {
        GraphQLTaggableActivityIcon graphQLTaggableActivityIcon = new GraphQLTaggableActivityIcon();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("icon_background_color".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTaggableActivityIcon.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityIcon, "icon_background_color", graphQLTaggableActivityIcon.a_, 0, false);
            } else if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTaggableActivityIcon.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityIcon, "id", graphQLTaggableActivityIcon.a_, 1, false);
            } else if ("image".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
                }
                graphQLTaggableActivityIcon.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityIcon, "image", graphQLTaggableActivityIcon.a_, 2, true);
            } else if ("imageLarge".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLarge"));
                }
                graphQLTaggableActivityIcon.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityIcon, "imageLarge", graphQLTaggableActivityIcon.a_, 3, true);
            } else if ("profileImageLarge".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
                }
                graphQLTaggableActivityIcon.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityIcon, "profileImageLarge", graphQLTaggableActivityIcon.a_, 4, true);
            } else if ("profileImageSmall".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
                }
                graphQLTaggableActivityIcon.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityIcon, "profileImageSmall", graphQLTaggableActivityIcon.a_, 5, true);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTaggableActivityIcon.j = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityIcon, "url", graphQLTaggableActivityIcon.a_, 6, false);
            }
            jsonParser.f();
        }
        return graphQLTaggableActivityIcon;
    }

    public static void m22055a(JsonGenerator jsonGenerator, GraphQLTaggableActivityIcon graphQLTaggableActivityIcon, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTaggableActivityIcon.j() != null) {
            jsonGenerator.a("icon_background_color", graphQLTaggableActivityIcon.j());
        }
        if (graphQLTaggableActivityIcon.k() != null) {
            jsonGenerator.a("id", graphQLTaggableActivityIcon.k());
        }
        if (graphQLTaggableActivityIcon.l() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTaggableActivityIcon.l(), true);
        }
        if (graphQLTaggableActivityIcon.m() != null) {
            jsonGenerator.a("imageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTaggableActivityIcon.m(), true);
        }
        if (graphQLTaggableActivityIcon.n() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTaggableActivityIcon.n(), true);
        }
        if (graphQLTaggableActivityIcon.o() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTaggableActivityIcon.o(), true);
        }
        if (graphQLTaggableActivityIcon.p() != null) {
            jsonGenerator.a("url", graphQLTaggableActivityIcon.p());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
