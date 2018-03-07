package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNPINNED */
public final class GraphQLTaggableActivity__JsonHelper {
    public static GraphQLTaggableActivity m22082a(JsonParser jsonParser) {
        GraphQLTaggableActivity graphQLTaggableActivity = new GraphQLTaggableActivity();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m22084a(graphQLTaggableActivity, i, jsonParser);
            jsonParser.f();
        }
        return graphQLTaggableActivity;
    }

    private static boolean m22084a(GraphQLTaggableActivity graphQLTaggableActivity, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("all_icons".equals(str)) {
            GraphQLTaggableActivityAllIconsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTaggableActivityAllIconsConnection__JsonHelper.m22046a(FieldAccessQueryTracker.a(jsonParser, "all_icons"));
            }
            graphQLTaggableActivity.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "all_icons", graphQLTaggableActivity.a_, 0, true);
            return true;
        } else if ("glyph".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "glyph"));
            }
            graphQLTaggableActivity.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "glyph", graphQLTaggableActivity.B_(), 1, true);
            return true;
        } else if ("iconImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "iconImageLarge"));
            }
            graphQLTaggableActivity.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "iconImageLarge", graphQLTaggableActivity.B_(), 2, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTaggableActivity.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "id", graphQLTaggableActivity.B_(), 3, false);
            return true;
        } else if ("is_linking_verb".equals(str)) {
            graphQLTaggableActivity.h = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "is_linking_verb", graphQLTaggableActivity.B_(), 4, false);
            return true;
        } else if ("legacy_api_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTaggableActivity.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "legacy_api_id", graphQLTaggableActivity.B_(), 5, false);
            return true;
        } else if ("prefetch_priority".equals(str)) {
            graphQLTaggableActivity.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "prefetch_priority", graphQLTaggableActivity.B_(), 6, false);
            return true;
        } else if ("present_participle".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTaggableActivity.k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "present_participle", graphQLTaggableActivity.B_(), 7, false);
            return true;
        } else if ("previewTemplateAtPlace".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22061a(FieldAccessQueryTracker.a(jsonParser, "previewTemplateAtPlace"));
            }
            graphQLTaggableActivity.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "previewTemplateAtPlace", graphQLTaggableActivity.B_(), 8, true);
            return true;
        } else if ("previewTemplateNoTags".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22061a(FieldAccessQueryTracker.a(jsonParser, "previewTemplateNoTags"));
            }
            graphQLTaggableActivity.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "previewTemplateNoTags", graphQLTaggableActivity.B_(), 9, true);
            return true;
        } else if ("previewTemplateWithPeople".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22061a(FieldAccessQueryTracker.a(jsonParser, "previewTemplateWithPeople"));
            }
            graphQLTaggableActivity.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "previewTemplateWithPeople", graphQLTaggableActivity.B_(), 10, true);
            return true;
        } else if ("previewTemplateWithPeopleAtPlace".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22061a(FieldAccessQueryTracker.a(jsonParser, "previewTemplateWithPeopleAtPlace"));
            }
            graphQLTaggableActivity.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "previewTemplateWithPeopleAtPlace", graphQLTaggableActivity.B_(), 11, true);
            return true;
        } else if ("previewTemplateWithPerson".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22061a(FieldAccessQueryTracker.a(jsonParser, "previewTemplateWithPerson"));
            }
            graphQLTaggableActivity.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "previewTemplateWithPerson", graphQLTaggableActivity.B_(), 12, true);
            return true;
        } else if ("previewTemplateWithPersonAtPlace".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22061a(FieldAccessQueryTracker.a(jsonParser, "previewTemplateWithPersonAtPlace"));
            }
            graphQLTaggableActivity.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "previewTemplateWithPersonAtPlace", graphQLTaggableActivity.B_(), 13, true);
            return true;
        } else if ("prompt".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTaggableActivity.r = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "prompt", graphQLTaggableActivity.B_(), 14, false);
            return true;
        } else if ("supports_audio_suggestions".equals(str)) {
            graphQLTaggableActivity.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "supports_audio_suggestions", graphQLTaggableActivity.B_(), 15, false);
            return true;
        } else if ("supports_freeform".equals(str)) {
            graphQLTaggableActivity.t = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "supports_freeform", graphQLTaggableActivity.B_(), 16, false);
            return true;
        } else if ("supports_offline_posting".equals(str)) {
            graphQLTaggableActivity.u = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "supports_offline_posting", graphQLTaggableActivity.B_(), 17, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTaggableActivity.v = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivity, "url", graphQLTaggableActivity.B_(), 18, false);
            return true;
        }
    }

    public static void m22083a(JsonGenerator jsonGenerator, GraphQLTaggableActivity graphQLTaggableActivity, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTaggableActivity.j() != null) {
            jsonGenerator.a("all_icons");
            GraphQLTaggableActivityAllIconsConnection__JsonHelper.m22047a(jsonGenerator, graphQLTaggableActivity.j(), true);
        }
        if (graphQLTaggableActivity.k() != null) {
            jsonGenerator.a("glyph");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTaggableActivity.k(), true);
        }
        if (graphQLTaggableActivity.l() != null) {
            jsonGenerator.a("iconImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTaggableActivity.l(), true);
        }
        if (graphQLTaggableActivity.m() != null) {
            jsonGenerator.a("id", graphQLTaggableActivity.m());
        }
        jsonGenerator.a("is_linking_verb", graphQLTaggableActivity.n());
        if (graphQLTaggableActivity.o() != null) {
            jsonGenerator.a("legacy_api_id", graphQLTaggableActivity.o());
        }
        jsonGenerator.a("prefetch_priority", graphQLTaggableActivity.p());
        if (graphQLTaggableActivity.q() != null) {
            jsonGenerator.a("present_participle", graphQLTaggableActivity.q());
        }
        if (graphQLTaggableActivity.r() != null) {
            jsonGenerator.a("previewTemplateAtPlace");
            GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22062a(jsonGenerator, graphQLTaggableActivity.r(), true);
        }
        if (graphQLTaggableActivity.s() != null) {
            jsonGenerator.a("previewTemplateNoTags");
            GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22062a(jsonGenerator, graphQLTaggableActivity.s(), true);
        }
        if (graphQLTaggableActivity.t() != null) {
            jsonGenerator.a("previewTemplateWithPeople");
            GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22062a(jsonGenerator, graphQLTaggableActivity.t(), true);
        }
        if (graphQLTaggableActivity.u() != null) {
            jsonGenerator.a("previewTemplateWithPeopleAtPlace");
            GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22062a(jsonGenerator, graphQLTaggableActivity.u(), true);
        }
        if (graphQLTaggableActivity.v() != null) {
            jsonGenerator.a("previewTemplateWithPerson");
            GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22062a(jsonGenerator, graphQLTaggableActivity.v(), true);
        }
        if (graphQLTaggableActivity.w() != null) {
            jsonGenerator.a("previewTemplateWithPersonAtPlace");
            GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22062a(jsonGenerator, graphQLTaggableActivity.w(), true);
        }
        if (graphQLTaggableActivity.x() != null) {
            jsonGenerator.a("prompt", graphQLTaggableActivity.x());
        }
        jsonGenerator.a("supports_audio_suggestions", graphQLTaggableActivity.y());
        jsonGenerator.a("supports_freeform", graphQLTaggableActivity.z());
        jsonGenerator.a("supports_offline_posting", graphQLTaggableActivity.A());
        if (graphQLTaggableActivity.B() != null) {
            jsonGenerator.a("url", graphQLTaggableActivity.B());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
