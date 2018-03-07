package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UNSEEN */
public final class GraphQLTaggableActivityPreviewTemplate__JsonHelper {
    public static GraphQLTaggableActivityPreviewTemplate m22061a(JsonParser jsonParser) {
        GraphQLTaggableActivityPreviewTemplate graphQLTaggableActivityPreviewTemplate = new GraphQLTaggableActivityPreviewTemplate();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            int i2;
            if ("template_string".equals(i)) {
                String o;
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    o = jsonParser.o();
                }
                graphQLTaggableActivityPreviewTemplate.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityPreviewTemplate, "template_string", graphQLTaggableActivityPreviewTemplate.a_, 0, false);
                i2 = 1;
            } else if ("template_tokens".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLActivityTemplateToken a = GraphQLActivityTemplateToken__JsonHelper.m6394a(FieldAccessQueryTracker.a(jsonParser, "template_tokens"));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    list = ImmutableList.copyOf(arrayList);
                }
                graphQLTaggableActivityPreviewTemplate.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityPreviewTemplate, "template_tokens", graphQLTaggableActivityPreviewTemplate.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLTaggableActivityPreviewTemplate;
    }

    public static void m22062a(JsonGenerator jsonGenerator, GraphQLTaggableActivityPreviewTemplate graphQLTaggableActivityPreviewTemplate, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTaggableActivityPreviewTemplate.a() != null) {
            jsonGenerator.a("template_string", graphQLTaggableActivityPreviewTemplate.a());
        }
        jsonGenerator.a("template_tokens");
        if (graphQLTaggableActivityPreviewTemplate.j() != null) {
            jsonGenerator.d();
            for (GraphQLActivityTemplateToken graphQLActivityTemplateToken : graphQLTaggableActivityPreviewTemplate.j()) {
                if (graphQLActivityTemplateToken != null) {
                    GraphQLActivityTemplateToken__JsonHelper.m6395a(jsonGenerator, graphQLActivityTemplateToken, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
