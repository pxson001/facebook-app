package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: group_photorealistic_icon */
public final class GraphQLFundraiserPage__JsonHelper {
    public static GraphQLFundraiserPage m7682a(JsonParser jsonParser) {
        GraphQLFundraiserPage graphQLFundraiserPage = new GraphQLFundraiserPage();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7684a(graphQLFundraiserPage, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFundraiserPage;
    }

    private static boolean m7684a(GraphQLFundraiserPage graphQLFundraiserPage, String str, JsonParser jsonParser) {
        String str2 = null;
        GraphQLFocusedPhoto a;
        if ("blurredCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "blurredCoverPhoto"));
            }
            graphQLFundraiserPage.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "blurredCoverPhoto", graphQLFundraiserPage.a_, 0, true);
            return true;
        } else if ("campaign".equals(str)) {
            GraphQLFundraiserCampaign a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLFundraiserCampaign__JsonHelper.m7668a(FieldAccessQueryTracker.a(jsonParser, "campaign"));
            }
            graphQLFundraiserPage.e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "campaign", graphQLFundraiserPage.B_(), 1, true);
            return true;
        } else if ("cover_photo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "cover_photo"));
            }
            graphQLFundraiserPage.f = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "cover_photo", graphQLFundraiserPage.B_(), 3, true);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLFundraiserPage.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "feedAwesomizerProfilePicture", graphQLFundraiserPage.B_(), 5, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFundraiserPage.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "id", graphQLFundraiserPage.B_(), 7, false);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLFundraiserPage.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "imageHighOrig", graphQLFundraiserPage.B_(), 8, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLFundraiserPage.j = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "inline_activities", graphQLFundraiserPage.B_(), 9, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFundraiserPage.k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "name", graphQLFundraiserPage.B_(), 10, false);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLFundraiserPage.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "profileImageLarge", graphQLFundraiserPage.B_(), 11, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLFundraiserPage.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "profileImageSmall", graphQLFundraiserPage.B_(), 12, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLFundraiserPage.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "profilePicture50", graphQLFundraiserPage.B_(), 13, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLFundraiserPage.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "profilePictureHighRes", graphQLFundraiserPage.B_(), 14, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLFundraiserPage.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "profilePictureLarge", graphQLFundraiserPage.B_(), 15, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLFundraiserPage.q = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "profile_photo", graphQLFundraiserPage.B_(), 16, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLFundraiserPage.r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "profile_picture", graphQLFundraiserPage.B_(), 17, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLFundraiserPage.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "profile_picture_is_silhouette", graphQLFundraiserPage.B_(), 18, false);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLFundraiserPage.t = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "streaming_profile_picture", graphQLFundraiserPage.B_(), 19, true);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLFundraiserPage.u = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "taggable_object_profile_picture", graphQLFundraiserPage.B_(), 20, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFundraiserPage.v = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPage, "url", graphQLFundraiserPage.B_(), 21, false);
            return true;
        }
    }

    public static void m7683a(JsonGenerator jsonGenerator, GraphQLFundraiserPage graphQLFundraiserPage, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFundraiserPage.j() != null) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLFundraiserPage.j(), true);
        }
        if (graphQLFundraiserPage.k() != null) {
            jsonGenerator.a("campaign");
            GraphQLFundraiserCampaign__JsonHelper.m7669a(jsonGenerator, graphQLFundraiserPage.k(), true);
        }
        if (graphQLFundraiserPage.l() != null) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLFundraiserPage.l(), true);
        }
        if (graphQLFundraiserPage.m() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPage.m(), true);
        }
        if (graphQLFundraiserPage.n() != null) {
            jsonGenerator.a("id", graphQLFundraiserPage.n());
        }
        if (graphQLFundraiserPage.o() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPage.o(), true);
        }
        if (graphQLFundraiserPage.p() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLFundraiserPage.p(), true);
        }
        if (graphQLFundraiserPage.q() != null) {
            jsonGenerator.a("name", graphQLFundraiserPage.q());
        }
        if (graphQLFundraiserPage.r() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPage.r(), true);
        }
        if (graphQLFundraiserPage.s() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPage.s(), true);
        }
        if (graphQLFundraiserPage.t() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPage.t(), true);
        }
        if (graphQLFundraiserPage.u() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPage.u(), true);
        }
        if (graphQLFundraiserPage.v() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPage.v(), true);
        }
        if (graphQLFundraiserPage.w() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLFundraiserPage.w(), true);
        }
        if (graphQLFundraiserPage.x() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPage.x(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLFundraiserPage.y());
        if (graphQLFundraiserPage.z() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLFundraiserPage.z(), true);
        }
        if (graphQLFundraiserPage.A() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLFundraiserPage.A(), true);
        }
        if (graphQLFundraiserPage.B() != null) {
            jsonGenerator.a("url", graphQLFundraiserPage.B());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
