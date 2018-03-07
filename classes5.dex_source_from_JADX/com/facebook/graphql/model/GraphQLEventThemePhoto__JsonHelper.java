package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: implementation */
public final class GraphQLEventThemePhoto__JsonHelper {
    public static GraphQLEventThemePhoto m7280a(JsonParser jsonParser) {
        GraphQLEventThemePhoto graphQLEventThemePhoto = new GraphQLEventThemePhoto();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7282a(graphQLEventThemePhoto, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEventThemePhoto;
    }

    private static boolean m7282a(GraphQLEventThemePhoto graphQLEventThemePhoto, String str, JsonParser jsonParser) {
        String str2 = null;
        GraphQLImage a;
        if ("coverPhotoImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "coverPhotoImage"));
            }
            graphQLEventThemePhoto.f3659d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "coverPhotoImage", graphQLEventThemePhoto.a_, 0, true);
            return true;
        } else if ("hi_res_theme_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "hi_res_theme_image"));
            }
            graphQLEventThemePhoto.f3660e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "hi_res_theme_image", graphQLEventThemePhoto.B_(), 1, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEventThemePhoto.f3661f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "id", graphQLEventThemePhoto.B_(), 2, false);
            return true;
        } else if ("image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLEventThemePhoto.f3662g = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "image", graphQLEventThemePhoto.B_(), 3, true);
            return true;
        } else if ("low_res_theme_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "low_res_theme_image"));
            }
            graphQLEventThemePhoto.f3663h = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "low_res_theme_image", graphQLEventThemePhoto.B_(), 4, true);
            return true;
        } else if ("med_res_theme_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "med_res_theme_image"));
            }
            graphQLEventThemePhoto.f3664i = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "med_res_theme_image", graphQLEventThemePhoto.B_(), 5, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLEventThemePhoto.f3665j = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "profileImageLarge", graphQLEventThemePhoto.B_(), 6, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLEventThemePhoto.f3666k = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "profileImageSmall", graphQLEventThemePhoto.B_(), 7, true);
            return true;
        } else if ("themeListImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "themeListImage"));
            }
            graphQLEventThemePhoto.f3667l = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "themeListImage", graphQLEventThemePhoto.B_(), 8, true);
            return true;
        } else if ("theme_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "theme_image"));
            }
            graphQLEventThemePhoto.f3668m = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "theme_image", graphQLEventThemePhoto.B_(), 9, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEventThemePhoto.f3669n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventThemePhoto, "url", graphQLEventThemePhoto.B_(), 10, false);
            return true;
        }
    }

    public static void m7281a(JsonGenerator jsonGenerator, GraphQLEventThemePhoto graphQLEventThemePhoto, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEventThemePhoto.m7267j() != null) {
            jsonGenerator.a("coverPhotoImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEventThemePhoto.m7267j(), true);
        }
        if (graphQLEventThemePhoto.m7268k() != null) {
            jsonGenerator.a("hi_res_theme_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEventThemePhoto.m7268k(), true);
        }
        if (graphQLEventThemePhoto.m7269l() != null) {
            jsonGenerator.a("id", graphQLEventThemePhoto.m7269l());
        }
        if (graphQLEventThemePhoto.m7270m() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEventThemePhoto.m7270m(), true);
        }
        if (graphQLEventThemePhoto.m7271n() != null) {
            jsonGenerator.a("low_res_theme_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEventThemePhoto.m7271n(), true);
        }
        if (graphQLEventThemePhoto.m7272o() != null) {
            jsonGenerator.a("med_res_theme_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEventThemePhoto.m7272o(), true);
        }
        if (graphQLEventThemePhoto.m7273p() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEventThemePhoto.m7273p(), true);
        }
        if (graphQLEventThemePhoto.m7274q() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEventThemePhoto.m7274q(), true);
        }
        if (graphQLEventThemePhoto.m7275r() != null) {
            jsonGenerator.a("themeListImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEventThemePhoto.m7275r(), true);
        }
        if (graphQLEventThemePhoto.m7276s() != null) {
            jsonGenerator.a("theme_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLEventThemePhoto.m7276s(), true);
        }
        if (graphQLEventThemePhoto.m7277t() != null) {
            jsonGenerator.a("url", graphQLEventThemePhoto.m7277t());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
