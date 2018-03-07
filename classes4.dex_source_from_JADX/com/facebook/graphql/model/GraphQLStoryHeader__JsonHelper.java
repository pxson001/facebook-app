package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLStoryHeaderStyle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: prev_user_login_time */
public final class GraphQLStoryHeader__JsonHelper {
    public static GraphQLStoryHeader m4781a(JsonParser jsonParser) {
        GraphQLStoryHeader graphQLStoryHeader = new GraphQLStoryHeader();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m4783a(graphQLStoryHeader, i, jsonParser);
            jsonParser.f();
        }
        return graphQLStoryHeader;
    }

    private static boolean m4783a(GraphQLStoryHeader graphQLStoryHeader, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("action_link".equals(str)) {
            GraphQLStoryActionLink a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLStoryActionLink__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "action_link"));
            }
            graphQLStoryHeader.d = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLStoryHeader, "action_link", graphQLStoryHeader.a_, 0, true);
            return true;
        } else if ("background_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "background_image"));
            }
            graphQLStoryHeader.e = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLStoryHeader, "background_image", graphQLStoryHeader.B_(), 1, true);
            return true;
        } else if ("description".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "description"));
            }
            graphQLStoryHeader.f = graphQLTextWithEntities;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLStoryHeader, "description", graphQLStoryHeader.B_(), 2, true);
            return true;
        } else if ("icon_source".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "icon_source"));
            }
            graphQLStoryHeader.g = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLStoryHeader, "icon_source", graphQLStoryHeader.B_(), 3, true);
            return true;
        } else if ("style_list".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryHeaderStyle fromString = GraphQLStoryHeaderStyle.fromString(jsonParser.o());
                    if (fromString != null) {
                        arrayList.add(fromString);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLStoryHeader.h = copyOf;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLStoryHeader, "style_list", graphQLStoryHeader.B_(), 4, false);
            return true;
        } else if ("subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "subtitle"));
            }
            graphQLStoryHeader.i = graphQLTextWithEntities;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLStoryHeader, "subtitle", graphQLStoryHeader.B_(), 5, true);
            return true;
        } else if (!"title".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "title"));
            }
            graphQLStoryHeader.j = graphQLTextWithEntities;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLStoryHeader, "title", graphQLStoryHeader.B_(), 6, true);
            return true;
        }
    }

    public static void m4782a(JsonGenerator jsonGenerator, GraphQLStoryHeader graphQLStoryHeader, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLStoryHeader.a() != null) {
            jsonGenerator.a("action_link");
            GraphQLStoryActionLink__JsonHelper.a(jsonGenerator, graphQLStoryHeader.a(), true);
        }
        if (graphQLStoryHeader.j() != null) {
            jsonGenerator.a("background_image");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLStoryHeader.j(), true);
        }
        if (graphQLStoryHeader.k() != null) {
            jsonGenerator.a("description");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLStoryHeader.k(), true);
        }
        if (graphQLStoryHeader.l() != null) {
            jsonGenerator.a("icon_source");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLStoryHeader.l(), true);
        }
        jsonGenerator.a("style_list");
        if (graphQLStoryHeader.m() != null) {
            jsonGenerator.d();
            for (GraphQLStoryHeaderStyle graphQLStoryHeaderStyle : graphQLStoryHeader.m()) {
                if (graphQLStoryHeaderStyle != null) {
                    jsonGenerator.b(graphQLStoryHeaderStyle.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStoryHeader.n() != null) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLStoryHeader.n(), true);
        }
        if (graphQLStoryHeader.o() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLStoryHeader.o(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
