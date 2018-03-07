package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: is_used */
public final class GraphQLApplication__JsonHelper {
    public static GraphQLApplication m6587a(JsonParser jsonParser) {
        GraphQLApplication graphQLApplication = new GraphQLApplication();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6589a(graphQLApplication, i, jsonParser);
            jsonParser.f();
        }
        return graphQLApplication;
    }

    private static boolean m6589a(GraphQLApplication graphQLApplication, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("android_app_config".equals(str)) {
            GraphQLAndroidAppConfig a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLAndroidAppConfig__JsonHelper.m6540a(FieldAccessQueryTracker.a(jsonParser, "android_app_config"));
            }
            graphQLApplication.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "android_app_config", graphQLApplication.a_, 0, true);
            return true;
        } else if ("android_store_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLApplication.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "android_store_url", graphQLApplication.B_(), 1, false);
            return true;
        } else if ("android_urls".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLApplication.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "android_urls", graphQLApplication.B_(), 2, false);
            return true;
        } else if ("app_center_categories".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLApplication.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "app_center_categories", graphQLApplication.B_(), 3, false);
            return true;
        } else if ("app_center_category_text".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "app_center_category_text"));
            }
            graphQLApplication.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "app_center_category_text", graphQLApplication.B_(), 4, true);
            return true;
        } else if ("app_center_cover_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "app_center_cover_image"));
            }
            graphQLApplication.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "app_center_cover_image", graphQLApplication.B_(), 5, true);
            return true;
        } else if ("application_requests_social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "application_requests_social_context"));
            }
            graphQLApplication.j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "application_requests_social_context", graphQLApplication.B_(), 6, true);
            return true;
        } else if ("average_star_rating".equals(str)) {
            graphQLApplication.k = jsonParser.g() == JsonToken.VALUE_NULL ? 0.0d : jsonParser.G();
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "average_star_rating", graphQLApplication.B_(), 7, false);
            return true;
        } else if ("canvas_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLApplication.l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "canvas_url", graphQLApplication.B_(), 8, false);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLApplication.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "feedAwesomizerProfilePicture", graphQLApplication.B_(), 9, true);
            return true;
        } else if ("global_usage_summary_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "global_usage_summary_sentence"));
            }
            graphQLApplication.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "global_usage_summary_sentence", graphQLApplication.B_(), 10, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLApplication.o = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "id", graphQLApplication.B_(), 12, false);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLApplication.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "imageHighOrig", graphQLApplication.B_(), 13, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLApplication.q = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "inline_activities", graphQLApplication.B_(), 14, true);
            return true;
        } else if ("is_game".equals(str)) {
            graphQLApplication.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "is_game", graphQLApplication.B_(), 15, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLApplication.s = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "name", graphQLApplication.B_(), 18, false);
            return true;
        } else if ("name_search_tokens".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLApplication.t = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "name_search_tokens", graphQLApplication.B_(), 19, false);
            return true;
        } else if ("native_store_object".equals(str)) {
            GraphQLMobileStoreObject a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLMobileStoreObject__JsonHelper.m9138a(FieldAccessQueryTracker.a(jsonParser, "native_store_object"));
            }
            graphQLApplication.u = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "native_store_object", graphQLApplication.B_(), 20, true);
            return true;
        } else if ("overall_star_rating".equals(str)) {
            GraphQLRating a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLRating__JsonHelper.m21310a(FieldAccessQueryTracker.a(jsonParser, "overall_star_rating"));
            }
            graphQLApplication.v = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "overall_star_rating", graphQLApplication.B_(), 21, true);
            return true;
        } else if ("privacy_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLApplication.w = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "privacy_url", graphQLApplication.B_(), 22, false);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLApplication.x = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "profileImageLarge", graphQLApplication.B_(), 23, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLApplication.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "profileImageSmall", graphQLApplication.B_(), 24, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLApplication.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "profilePicture50", graphQLApplication.B_(), 27, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLApplication.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "profilePictureHighRes", graphQLApplication.B_(), 29, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLApplication.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "profilePictureLarge", graphQLApplication.B_(), 30, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLApplication.C = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "profile_photo", graphQLApplication.B_(), 31, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLApplication.D = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "profile_picture", graphQLApplication.B_(), 32, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLApplication.E = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "profile_picture_is_silhouette", graphQLApplication.B_(), 33, false);
            return true;
        } else if ("short_description".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLApplication.F = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "short_description", graphQLApplication.B_(), 34, false);
            return true;
        } else if ("social_usage_sentence_with_names".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_usage_sentence_with_names"));
            }
            graphQLApplication.G = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "social_usage_sentence_with_names", graphQLApplication.B_(), 35, true);
            return true;
        } else if ("social_usage_summary_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_usage_summary_sentence"));
            }
            graphQLApplication.H = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "social_usage_summary_sentence", graphQLApplication.B_(), 36, true);
            return true;
        } else if ("square_logo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "square_logo"));
            }
            graphQLApplication.I = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "square_logo", graphQLApplication.B_(), 37, true);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLApplication.J = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "streaming_profile_picture", graphQLApplication.B_(), 38, true);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLApplication.K = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "taggable_object_profile_picture", graphQLApplication.B_(), 39, true);
            return true;
        } else if ("terms_of_service_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLApplication.L = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "terms_of_service_url", graphQLApplication.B_(), 40, false);
            return true;
        } else if ("unread_count".equals(str)) {
            graphQLApplication.M = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "unread_count", graphQLApplication.B_(), 41, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLApplication.N = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "url", graphQLApplication.B_(), 42, false);
            return true;
        } else if (!"username".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLApplication.O = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLApplication, "username", graphQLApplication.B_(), 43, false);
            return true;
        }
    }

    public static void m6588a(JsonGenerator jsonGenerator, GraphQLApplication graphQLApplication, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLApplication.j() != null) {
            jsonGenerator.a("android_app_config");
            GraphQLAndroidAppConfig__JsonHelper.m6541a(jsonGenerator, graphQLApplication.j(), true);
        }
        if (graphQLApplication.k() != null) {
            jsonGenerator.a("android_store_url", graphQLApplication.k());
        }
        jsonGenerator.a("android_urls");
        if (graphQLApplication.l() != null) {
            jsonGenerator.d();
            for (String str : graphQLApplication.l()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("app_center_categories");
        if (graphQLApplication.m() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLApplication.m()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLApplication.n() != null) {
            jsonGenerator.a("app_center_category_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLApplication.n(), true);
        }
        if (graphQLApplication.o() != null) {
            jsonGenerator.a("app_center_cover_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.o(), true);
        }
        if (graphQLApplication.p() != null) {
            jsonGenerator.a("application_requests_social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLApplication.p(), true);
        }
        jsonGenerator.a("average_star_rating", graphQLApplication.q());
        if (graphQLApplication.r() != null) {
            jsonGenerator.a("canvas_url", graphQLApplication.r());
        }
        if (graphQLApplication.s() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.s(), true);
        }
        if (graphQLApplication.t() != null) {
            jsonGenerator.a("global_usage_summary_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLApplication.t(), true);
        }
        if (graphQLApplication.u() != null) {
            jsonGenerator.a("id", graphQLApplication.u());
        }
        if (graphQLApplication.v() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.v(), true);
        }
        if (graphQLApplication.w() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLApplication.w(), true);
        }
        jsonGenerator.a("is_game", graphQLApplication.x());
        if (graphQLApplication.y() != null) {
            jsonGenerator.a("name", graphQLApplication.y());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLApplication.z() != null) {
            jsonGenerator.d();
            for (String str22 : graphQLApplication.z()) {
                if (str22 != null) {
                    jsonGenerator.b(str22);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLApplication.A() != null) {
            jsonGenerator.a("native_store_object");
            GraphQLMobileStoreObject__JsonHelper.m9139a(jsonGenerator, graphQLApplication.A(), true);
        }
        if (graphQLApplication.B() != null) {
            jsonGenerator.a("overall_star_rating");
            GraphQLRating__JsonHelper.m21311a(jsonGenerator, graphQLApplication.B(), true);
        }
        if (graphQLApplication.C() != null) {
            jsonGenerator.a("privacy_url", graphQLApplication.C());
        }
        if (graphQLApplication.D() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.D(), true);
        }
        if (graphQLApplication.E() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.E(), true);
        }
        if (graphQLApplication.F() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.F(), true);
        }
        if (graphQLApplication.G() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.G(), true);
        }
        if (graphQLApplication.H() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.H(), true);
        }
        if (graphQLApplication.I() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLApplication.I(), true);
        }
        if (graphQLApplication.J() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.J(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLApplication.K());
        if (graphQLApplication.L() != null) {
            jsonGenerator.a("short_description", graphQLApplication.L());
        }
        if (graphQLApplication.M() != null) {
            jsonGenerator.a("social_usage_sentence_with_names");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLApplication.M(), true);
        }
        if (graphQLApplication.N() != null) {
            jsonGenerator.a("social_usage_summary_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLApplication.N(), true);
        }
        if (graphQLApplication.O() != null) {
            jsonGenerator.a("square_logo");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.O(), true);
        }
        if (graphQLApplication.P() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLApplication.P(), true);
        }
        if (graphQLApplication.Q() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLApplication.Q(), true);
        }
        if (graphQLApplication.R() != null) {
            jsonGenerator.a("terms_of_service_url", graphQLApplication.R());
        }
        jsonGenerator.a("unread_count", graphQLApplication.S());
        if (graphQLApplication.T() != null) {
            jsonGenerator.a("url", graphQLApplication.T());
        }
        if (graphQLApplication.U() != null) {
            jsonGenerator.a("username", graphQLApplication.U());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
