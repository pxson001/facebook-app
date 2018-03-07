package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: friends_nearby */
public final class GraphQLGreetingCardTemplate__JsonHelper {
    public static GraphQLGreetingCardTemplate m8373a(JsonParser jsonParser) {
        GraphQLGreetingCardTemplate graphQLGreetingCardTemplate = new GraphQLGreetingCardTemplate();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8375a(graphQLGreetingCardTemplate, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGreetingCardTemplate;
    }

    private static boolean m8375a(GraphQLGreetingCardTemplate graphQLGreetingCardTemplate, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCardTemplate.d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardTemplate, "id", graphQLGreetingCardTemplate.a_, 0, false);
            return true;
        } else if ("template_images".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLImage a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "template_images"));
                    if (a != null) {
                        r1.add(a);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGreetingCardTemplate.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardTemplate, "template_images", graphQLGreetingCardTemplate.B_(), 1, true);
            return true;
        } else if ("template_themes".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLGreetingCardTemplateTheme a2 = GraphQLGreetingCardTemplateTheme__JsonHelper.m8371a(FieldAccessQueryTracker.a(jsonParser, "template_themes"));
                    if (a2 != null) {
                        r1.add(a2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGreetingCardTemplate.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardTemplate, "template_themes", graphQLGreetingCardTemplate.B_(), 2, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCardTemplate.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardTemplate, "url", graphQLGreetingCardTemplate.B_(), 3, false);
            return true;
        }
    }

    public static void m8374a(JsonGenerator jsonGenerator, GraphQLGreetingCardTemplate graphQLGreetingCardTemplate, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGreetingCardTemplate.j() != null) {
            jsonGenerator.a("id", graphQLGreetingCardTemplate.j());
        }
        jsonGenerator.a("template_images");
        if (graphQLGreetingCardTemplate.k() != null) {
            jsonGenerator.d();
            for (GraphQLImage graphQLImage : graphQLGreetingCardTemplate.k()) {
                if (graphQLImage != null) {
                    GraphQLImage__JsonHelper.a(jsonGenerator, graphQLImage, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("template_themes");
        if (graphQLGreetingCardTemplate.l() != null) {
            jsonGenerator.d();
            for (GraphQLGreetingCardTemplateTheme graphQLGreetingCardTemplateTheme : graphQLGreetingCardTemplate.l()) {
                if (graphQLGreetingCardTemplateTheme != null) {
                    GraphQLGreetingCardTemplateTheme__JsonHelper.m8372a(jsonGenerator, graphQLGreetingCardTemplateTheme, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGreetingCardTemplate.m() != null) {
            jsonGenerator.a("url", graphQLGreetingCardTemplate.m());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
