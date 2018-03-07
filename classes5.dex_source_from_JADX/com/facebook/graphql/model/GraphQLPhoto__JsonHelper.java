package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WIFI_ONLY */
public final class GraphQLPhoto__JsonHelper {
    public static GraphQLPhoto m20764a(JsonParser jsonParser) {
        GraphQLPhoto graphQLPhoto = new GraphQLPhoto();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20766a(graphQLPhoto, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPhoto;
    }

    private static boolean m20766a(GraphQLPhoto graphQLPhoto, String str, JsonParser jsonParser) {
        long j = 0;
        GraphQLOpenGraphAction graphQLOpenGraphAction = null;
        String o;
        if ("accessibility_caption".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.d = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "accessibility_caption", graphQLPhoto.a_, 0, false);
            return true;
        } else if ("album".equals(str)) {
            GraphQLAlbum a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLAlbum__JsonHelper.m6510a(FieldAccessQueryTracker.a(jsonParser, "album"));
            }
            graphQLPhoto.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "album", graphQLPhoto.B_(), 1, true);
            return true;
        } else if ("animated_gif".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "animated_gif"));
            }
            graphQLPhoto.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "animated_gif", graphQLPhoto.B_(), 2, true);
            return true;
        } else if ("animated_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "animated_image"));
            }
            graphQLPhoto.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "animated_image", graphQLPhoto.B_(), 3, true);
            return true;
        } else if ("atom_size".equals(str)) {
            graphQLPhoto.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "atom_size", graphQLPhoto.B_(), 4, false);
            return true;
        } else if ("attribution_app".equals(str)) {
            GraphQLApplication a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "attribution_app"));
            }
            graphQLPhoto.i = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "attribution_app", graphQLPhoto.B_(), 6, true);
            return true;
        } else if ("attribution_app_metadata".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.j = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "attribution_app_metadata", graphQLPhoto.B_(), 7, false);
            return true;
        } else if ("bitrate".equals(str)) {
            graphQLPhoto.k = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "bitrate", graphQLPhoto.B_(), 8, false);
            return true;
        } else if ("can_viewer_add_tags".equals(str)) {
            graphQLPhoto.l = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "can_viewer_add_tags", graphQLPhoto.B_(), 9, false);
            return true;
        } else if ("can_viewer_delete".equals(str)) {
            graphQLPhoto.m = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "can_viewer_delete", graphQLPhoto.B_(), 10, false);
            return true;
        } else if ("can_viewer_edit".equals(str)) {
            graphQLPhoto.n = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "can_viewer_edit", graphQLPhoto.B_(), 11, false);
            return true;
        } else if ("can_viewer_export".equals(str)) {
            graphQLPhoto.o = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "can_viewer_export", graphQLPhoto.B_(), 12, false);
            return true;
        } else if ("can_viewer_make_cover_photo".equals(str)) {
            graphQLPhoto.p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "can_viewer_make_cover_photo", graphQLPhoto.B_(), 13, false);
            return true;
        } else if ("can_viewer_make_profile_picture".equals(str)) {
            graphQLPhoto.q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "can_viewer_make_profile_picture", graphQLPhoto.B_(), 14, false);
            return true;
        } else if ("can_viewer_report".equals(str)) {
            graphQLPhoto.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "can_viewer_report", graphQLPhoto.B_(), 15, false);
            return true;
        } else if ("can_viewer_suggest_location".equals(str)) {
            graphQLPhoto.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "can_viewer_suggest_location", graphQLPhoto.B_(), 17, false);
            return true;
        } else if ("can_viewer_untag".equals(str)) {
            graphQLPhoto.t = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "can_viewer_untag", graphQLPhoto.B_(), 18, false);
            return true;
        } else if ("container_story".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "container_story"));
            }
            graphQLPhoto.u = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "container_story", graphQLPhoto.B_(), 19, true);
            return true;
        } else if ("created_time".equals(str)) {
            graphQLPhoto.v = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "created_time", graphQLPhoto.B_(), 20, false);
            return true;
        } else if ("creation_story".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "creation_story"));
            }
            graphQLPhoto.w = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "creation_story", graphQLPhoto.B_(), 21, true);
            return true;
        } else if ("explicit_place".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "explicit_place"));
            }
            graphQLPhoto.x = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "explicit_place", graphQLPhoto.B_(), 22, true);
            return true;
        } else if ("face_boxes".equals(str)) {
            GraphQLPhotoFaceBoxesConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPhotoFaceBoxesConnection__JsonHelper.m20730a(FieldAccessQueryTracker.a(jsonParser, "face_boxes"));
            }
            graphQLPhoto.y = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "face_boxes", graphQLPhoto.B_(), 23, true);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLPhoto.z = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "feedback", graphQLPhoto.B_(), 27, true);
            return true;
        } else if ("focus".equals(str)) {
            GraphQLVect2 a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLVect2__JsonHelper.m22421a(FieldAccessQueryTracker.a(jsonParser, "focus"));
            }
            graphQLPhoto.A = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "focus", graphQLPhoto.B_(), 28, true);
            return true;
        } else if ("has_stickers".equals(str)) {
            graphQLPhoto.B = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "has_stickers", graphQLPhoto.B_(), 29, false);
            return true;
        } else if ("hdAtomSize".equals(str)) {
            graphQLPhoto.C = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "hdAtomSize", graphQLPhoto.B_(), 30, false);
            return true;
        } else if ("hdBitrate".equals(str)) {
            graphQLPhoto.D = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "hdBitrate", graphQLPhoto.B_(), 31, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.E = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "id", graphQLPhoto.B_(), 32, false);
            return true;
        } else if ("image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLPhoto.F = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "image", graphQLPhoto.B_(), 33, true);
            return true;
        } else if ("image320".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image320"));
            }
            graphQLPhoto.G = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "image320", graphQLPhoto.B_(), 34, true);
            return true;
        } else if ("imageHigh".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHigh"));
            }
            graphQLPhoto.H = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageHigh", graphQLPhoto.B_(), 35, true);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLPhoto.I = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageHighOrig", graphQLPhoto.B_(), 36, true);
            return true;
        } else if ("imageHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighRes"));
            }
            graphQLPhoto.J = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageHighRes", graphQLPhoto.B_(), 37, true);
            return true;
        } else if ("imageLandscape".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLandscape"));
            }
            graphQLPhoto.K = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageLandscape", graphQLPhoto.B_(), 38, true);
            return true;
        } else if ("imageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLarge"));
            }
            graphQLPhoto.L = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageLarge", graphQLPhoto.B_(), 39, true);
            return true;
        } else if ("imageLargeAspect".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLargeAspect"));
            }
            graphQLPhoto.M = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageLargeAspect", graphQLPhoto.B_(), 40, true);
            return true;
        } else if ("imageLargeSquare".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLargeSquare"));
            }
            graphQLPhoto.N = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageLargeSquare", graphQLPhoto.B_(), 41, true);
            return true;
        } else if ("imageLow".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLow"));
            }
            graphQLPhoto.O = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageLow", graphQLPhoto.B_(), 42, true);
            return true;
        } else if ("imageLowRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLowRes"));
            }
            graphQLPhoto.P = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageLowRes", graphQLPhoto.B_(), 43, true);
            return true;
        } else if ("imageLowres".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLowres"));
            }
            graphQLPhoto.Q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageLowres", graphQLPhoto.B_(), 44, true);
            return true;
        } else if ("imageMedium".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageMedium"));
            }
            graphQLPhoto.R = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageMedium", graphQLPhoto.B_(), 45, true);
            return true;
        } else if ("imageMedres".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageMedres"));
            }
            graphQLPhoto.S = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageMedres", graphQLPhoto.B_(), 46, true);
            return true;
        } else if ("imageMidRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageMidRes"));
            }
            graphQLPhoto.T = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageMidRes", graphQLPhoto.B_(), 47, true);
            return true;
        } else if ("imagePortrait".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imagePortrait"));
            }
            graphQLPhoto.U = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imagePortrait", graphQLPhoto.B_(), 48, true);
            return true;
        } else if ("imagePreview".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imagePreview"));
            }
            graphQLPhoto.V = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imagePreview", graphQLPhoto.B_(), 49, true);
            return true;
        } else if ("imageSmallCover".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageSmallCover"));
            }
            graphQLPhoto.W = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageSmallCover", graphQLPhoto.B_(), 50, true);
            return true;
        } else if ("imageSmallSquare".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageSmallSquare"));
            }
            graphQLPhoto.X = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageSmallSquare", graphQLPhoto.B_(), 51, true);
            return true;
        } else if ("imageTallCover".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageTallCover"));
            }
            graphQLPhoto.Y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageTallCover", graphQLPhoto.B_(), 52, true);
            return true;
        } else if ("imageThumbnail".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageThumbnail"));
            }
            graphQLPhoto.Z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageThumbnail", graphQLPhoto.B_(), 53, true);
            return true;
        } else if ("implicit_place".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "implicit_place"));
            }
            graphQLPhoto.aa = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "implicit_place", graphQLPhoto.B_(), 54, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLPhoto.ab = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "inline_activities", graphQLPhoto.B_(), 55, true);
            return true;
        } else if ("intermediate_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "intermediate_image"));
            }
            graphQLPhoto.ac = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "intermediate_image", graphQLPhoto.B_(), 56, true);
            return true;
        } else if ("is_age_restricted".equals(str)) {
            graphQLPhoto.ad = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "is_age_restricted", graphQLPhoto.B_(), 57, false);
            return true;
        } else if ("is_disturbing".equals(str)) {
            graphQLPhoto.ae = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "is_disturbing", graphQLPhoto.B_(), 58, false);
            return true;
        } else if ("is_playable".equals(str)) {
            graphQLPhoto.af = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "is_playable", graphQLPhoto.B_(), 59, false);
            return true;
        } else if ("is_viewer_suggested_tagger".equals(str)) {
            graphQLPhoto.ag = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "is_viewer_suggested_tagger", graphQLPhoto.B_(), 60, false);
            return true;
        } else if ("landscape".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "landscape"));
            }
            graphQLPhoto.ah = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "landscape", graphQLPhoto.B_(), 62, true);
            return true;
        } else if ("largeImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "largeImage"));
            }
            graphQLPhoto.ai = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "largeImage", graphQLPhoto.B_(), 63, true);
            return true;
        } else if ("largePortraitImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "largePortraitImage"));
            }
            graphQLPhoto.aj = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "largePortraitImage", graphQLPhoto.B_(), 64, true);
            return true;
        } else if ("largeThumbnail".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "largeThumbnail"));
            }
            graphQLPhoto.ak = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "largeThumbnail", graphQLPhoto.B_(), 65, true);
            return true;
        } else if ("location_tag_suggestion".equals(str)) {
            GraphQLPlaceSuggestionInfo a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLPlaceSuggestionInfo__JsonHelper.m20918a(FieldAccessQueryTracker.a(jsonParser, "location_tag_suggestion"));
            }
            graphQLPhoto.al = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "location_tag_suggestion", graphQLPhoto.B_(), 66, true);
            return true;
        } else if ("lowres".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "lowres"));
            }
            graphQLPhoto.am = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "lowres", graphQLPhoto.B_(), 67, true);
            return true;
        } else if ("mediumImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "mediumImage"));
            }
            graphQLPhoto.an = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "mediumImage", graphQLPhoto.B_(), 68, true);
            return true;
        } else if ("message".equals(str)) {
            GraphQLTextWithEntities a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLPhoto.ao = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "message", graphQLPhoto.B_(), 69, true);
            return true;
        } else if ("modified_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLPhoto.ap = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "modified_time", graphQLPhoto.B_(), 70, false);
            return true;
        } else if ("multiShareHDVideoUrl".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.aq = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "multiShareHDVideoUrl", graphQLPhoto.B_(), 71, false);
            return true;
        } else if ("multiShareItemSquareImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "multiShareItemSquareImage"));
            }
            graphQLPhoto.ar = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "multiShareItemSquareImage", graphQLPhoto.B_(), 72, true);
            return true;
        } else if ("multiShareVideoUrl".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.as = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "multiShareVideoUrl", graphQLPhoto.B_(), 73, false);
            return true;
        } else if ("narrowLandscapeImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "narrowLandscapeImage"));
            }
            graphQLPhoto.at = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "narrowLandscapeImage", graphQLPhoto.B_(), 74, true);
            return true;
        } else if ("narrowPortraitImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "narrowPortraitImage"));
            }
            graphQLPhoto.au = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "narrowPortraitImage", graphQLPhoto.B_(), 75, true);
            return true;
        } else if ("owner".equals(str)) {
            GraphQLActor a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "owner"));
            }
            graphQLPhoto.av = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "owner", graphQLPhoto.B_(), 76, true);
            return true;
        } else if ("paired_video".equals(str)) {
            GraphQLVideo a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLVideo__JsonHelper.m22483a(FieldAccessQueryTracker.a(jsonParser, "paired_video"));
            }
            graphQLPhoto.aw = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "paired_video", graphQLPhoto.B_(), 77, true);
            return true;
        } else if ("pending_place".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "pending_place"));
            }
            graphQLPhoto.ax = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "pending_place", graphQLPhoto.B_(), 78, true);
            return true;
        } else if ("photo_encodings".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPhotoEncoding a11 = GraphQLPhotoEncoding__JsonHelper.m20723a(FieldAccessQueryTracker.a(jsonParser, "photo_encodings"));
                    if (a11 != null) {
                        arrayList.add(a11);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLPhoto.ay = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "photo_encodings", graphQLPhoto.B_(), 79, true);
            return true;
        } else if ("playableUrlHdString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.az = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "playableUrlHdString", graphQLPhoto.B_(), 80, false);
            return true;
        } else if ("playableUrlRtmpString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.aA = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "playableUrlRtmpString", graphQLPhoto.B_(), 81, false);
            return true;
        } else if ("playable_duration".equals(str)) {
            graphQLPhoto.aB = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "playable_duration", graphQLPhoto.B_(), 82, false);
            return true;
        } else if ("playable_duration_in_ms".equals(str)) {
            graphQLPhoto.aC = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "playable_duration_in_ms", graphQLPhoto.B_(), 83, false);
            return true;
        } else if ("playable_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.aD = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "playable_url", graphQLPhoto.B_(), 84, false);
            return true;
        } else if ("portrait".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "portrait"));
            }
            graphQLPhoto.aE = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "portrait", graphQLPhoto.B_(), 85, true);
            return true;
        } else if ("preferredPlayableUrlString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.aF = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "preferredPlayableUrlString", graphQLPhoto.B_(), 86, false);
            return true;
        } else if ("preview_payload".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.aG = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "preview_payload", graphQLPhoto.B_(), 87, false);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLPhoto.aH = a12;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "privacy_scope", graphQLPhoto.B_(), 88, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLPhoto.aI = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "profileImageLarge", graphQLPhoto.B_(), 89, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLPhoto.aJ = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "profileImageSmall", graphQLPhoto.B_(), 90, true);
            return true;
        } else if ("profilePhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePhoto"));
            }
            graphQLPhoto.aK = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "profilePhoto", graphQLPhoto.B_(), 91, true);
            return true;
        } else if ("profile_picture_overlay".equals(str)) {
            GraphQLImageOverlay a13;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a13 = GraphQLImageOverlay__JsonHelper.m8630a(FieldAccessQueryTracker.a(jsonParser, "profile_picture_overlay"));
            }
            graphQLPhoto.aL = a13;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "profile_picture_overlay", graphQLPhoto.B_(), 92, true);
            return true;
        } else if ("pulseCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "pulseCoverPhoto"));
            }
            graphQLPhoto.aM = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "pulseCoverPhoto", graphQLPhoto.B_(), 93, true);
            return true;
        } else if ("should_upsell_as_viewer_profile_picture".equals(str)) {
            graphQLPhoto.aN = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "should_upsell_as_viewer_profile_picture", graphQLPhoto.B_(), 94, false);
            return true;
        } else if ("show_objectionable_warning_in_feed".equals(str)) {
            graphQLPhoto.aO = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "show_objectionable_warning_in_feed", graphQLPhoto.B_(), 95, false);
            return true;
        } else if ("squareLargeImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "squareLargeImage"));
            }
            graphQLPhoto.aP = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "squareLargeImage", graphQLPhoto.B_(), 96, true);
            return true;
        } else if ("tags".equals(str)) {
            GraphQLPhotoTagsConnection a14;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a14 = GraphQLPhotoTagsConnection__JsonHelper.m20751a(FieldAccessQueryTracker.a(jsonParser, "tags"));
            }
            graphQLPhoto.aQ = a14;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "tags", graphQLPhoto.B_(), 97, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.aR = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "url", graphQLPhoto.B_(), 98, false);
            return true;
        } else if ("with_tags".equals(str)) {
            GraphQLWithTagsConnection a15;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a15 = GraphQLWithTagsConnection__JsonHelper.m22500a(FieldAccessQueryTracker.a(jsonParser, "with_tags"));
            }
            graphQLPhoto.aS = a15;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "with_tags", graphQLPhoto.B_(), 99, true);
            return true;
        } else if ("imageNatural".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageNatural"));
            }
            graphQLPhoto.aT = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "imageNatural", graphQLPhoto.B_(), 100, true);
            return true;
        } else if ("image_blurred".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image_blurred"));
            }
            graphQLPhoto.aU = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "image_blurred", graphQLPhoto.B_(), 101, true);
            return true;
        } else if ("is_delegating_delete".equals(str)) {
            graphQLPhoto.aV = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "is_delegating_delete", graphQLPhoto.B_(), 105, false);
            return true;
        } else if ("video_full_size".equals(str)) {
            graphQLPhoto.aW = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "video_full_size", graphQLPhoto.B_(), 106, false);
            return true;
        } else if ("dominant_color".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPhoto.aX = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "dominant_color", graphQLPhoto.B_(), 107, false);
            return true;
        } else if (!"open_graph_action".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLOpenGraphAction = GraphQLOpenGraphAction__JsonHelper.m9395a(FieldAccessQueryTracker.a(jsonParser, "open_graph_action"));
            }
            graphQLPhoto.aY = graphQLOpenGraphAction;
            FieldAccessQueryTracker.a(jsonParser, graphQLPhoto, "open_graph_action", graphQLPhoto.B_(), 108, true);
            return true;
        }
    }

    public static void m20765a(JsonGenerator jsonGenerator, GraphQLPhoto graphQLPhoto, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPhoto.j() != null) {
            jsonGenerator.a("accessibility_caption", graphQLPhoto.j());
        }
        if (graphQLPhoto.k() != null) {
            jsonGenerator.a("album");
            GraphQLAlbum__JsonHelper.m6511a(jsonGenerator, graphQLPhoto.k(), true);
        }
        if (graphQLPhoto.l() != null) {
            jsonGenerator.a("animated_gif");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.l(), true);
        }
        if (graphQLPhoto.m() != null) {
            jsonGenerator.a("animated_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.m(), true);
        }
        jsonGenerator.a("atom_size", graphQLPhoto.n());
        if (graphQLPhoto.o() != null) {
            jsonGenerator.a("attribution_app");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLPhoto.o(), true);
        }
        if (graphQLPhoto.p() != null) {
            jsonGenerator.a("attribution_app_metadata", graphQLPhoto.p());
        }
        jsonGenerator.a("bitrate", graphQLPhoto.q());
        jsonGenerator.a("can_viewer_add_tags", graphQLPhoto.r());
        jsonGenerator.a("can_viewer_delete", graphQLPhoto.s());
        jsonGenerator.a("can_viewer_edit", graphQLPhoto.t());
        jsonGenerator.a("can_viewer_export", graphQLPhoto.u());
        jsonGenerator.a("can_viewer_make_cover_photo", graphQLPhoto.v());
        jsonGenerator.a("can_viewer_make_profile_picture", graphQLPhoto.w());
        jsonGenerator.a("can_viewer_report", graphQLPhoto.x());
        jsonGenerator.a("can_viewer_suggest_location", graphQLPhoto.y());
        jsonGenerator.a("can_viewer_untag", graphQLPhoto.z());
        if (graphQLPhoto.A() != null) {
            jsonGenerator.a("container_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLPhoto.A(), true);
        }
        jsonGenerator.a("created_time", graphQLPhoto.B());
        if (graphQLPhoto.C() != null) {
            jsonGenerator.a("creation_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLPhoto.C(), true);
        }
        if (graphQLPhoto.D() != null) {
            jsonGenerator.a("explicit_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLPhoto.D(), true);
        }
        if (graphQLPhoto.E() != null) {
            jsonGenerator.a("face_boxes");
            GraphQLPhotoFaceBoxesConnection__JsonHelper.m20731a(jsonGenerator, graphQLPhoto.E(), true);
        }
        if (graphQLPhoto.F() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLPhoto.F(), true);
        }
        if (graphQLPhoto.G() != null) {
            jsonGenerator.a("focus");
            GraphQLVect2__JsonHelper.m22422a(jsonGenerator, graphQLPhoto.G(), true);
        }
        jsonGenerator.a("has_stickers", graphQLPhoto.H());
        jsonGenerator.a("hdAtomSize", graphQLPhoto.I());
        jsonGenerator.a("hdBitrate", graphQLPhoto.J());
        if (graphQLPhoto.K() != null) {
            jsonGenerator.a("id", graphQLPhoto.K());
        }
        if (graphQLPhoto.L() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.L(), true);
        }
        if (graphQLPhoto.M() != null) {
            jsonGenerator.a("image320");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.M(), true);
        }
        if (graphQLPhoto.N() != null) {
            jsonGenerator.a("imageHigh");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.N(), true);
        }
        if (graphQLPhoto.O() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.O(), true);
        }
        if (graphQLPhoto.P() != null) {
            jsonGenerator.a("imageHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.P(), true);
        }
        if (graphQLPhoto.Q() != null) {
            jsonGenerator.a("imageLandscape");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.Q(), true);
        }
        if (graphQLPhoto.R() != null) {
            jsonGenerator.a("imageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.R(), true);
        }
        if (graphQLPhoto.S() != null) {
            jsonGenerator.a("imageLargeAspect");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.S(), true);
        }
        if (graphQLPhoto.T() != null) {
            jsonGenerator.a("imageLargeSquare");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.T(), true);
        }
        if (graphQLPhoto.U() != null) {
            jsonGenerator.a("imageLow");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.U(), true);
        }
        if (graphQLPhoto.V() != null) {
            jsonGenerator.a("imageLowRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.V(), true);
        }
        if (graphQLPhoto.W() != null) {
            jsonGenerator.a("imageLowres");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.W(), true);
        }
        if (graphQLPhoto.X() != null) {
            jsonGenerator.a("imageMedium");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.X(), true);
        }
        if (graphQLPhoto.Y() != null) {
            jsonGenerator.a("imageMedres");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.Y(), true);
        }
        if (graphQLPhoto.Z() != null) {
            jsonGenerator.a("imageMidRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.Z(), true);
        }
        if (graphQLPhoto.aa() != null) {
            jsonGenerator.a("imagePortrait");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.aa(), true);
        }
        if (graphQLPhoto.ab() != null) {
            jsonGenerator.a("imagePreview");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.ab(), true);
        }
        if (graphQLPhoto.ac() != null) {
            jsonGenerator.a("imageSmallCover");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.ac(), true);
        }
        if (graphQLPhoto.ad() != null) {
            jsonGenerator.a("imageSmallSquare");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.ad(), true);
        }
        if (graphQLPhoto.ae() != null) {
            jsonGenerator.a("imageTallCover");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.ae(), true);
        }
        if (graphQLPhoto.af() != null) {
            jsonGenerator.a("imageThumbnail");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.af(), true);
        }
        if (graphQLPhoto.ag() != null) {
            jsonGenerator.a("implicit_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLPhoto.ag(), true);
        }
        if (graphQLPhoto.ah() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLPhoto.ah(), true);
        }
        if (graphQLPhoto.ai() != null) {
            jsonGenerator.a("intermediate_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.ai(), true);
        }
        jsonGenerator.a("is_age_restricted", graphQLPhoto.aj());
        jsonGenerator.a("is_disturbing", graphQLPhoto.ak());
        jsonGenerator.a("is_playable", graphQLPhoto.al());
        jsonGenerator.a("is_viewer_suggested_tagger", graphQLPhoto.am());
        if (graphQLPhoto.an() != null) {
            jsonGenerator.a("landscape");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.an(), true);
        }
        if (graphQLPhoto.ao() != null) {
            jsonGenerator.a("largeImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.ao(), true);
        }
        if (graphQLPhoto.ap() != null) {
            jsonGenerator.a("largePortraitImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.ap(), true);
        }
        if (graphQLPhoto.aq() != null) {
            jsonGenerator.a("largeThumbnail");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.aq(), true);
        }
        if (graphQLPhoto.ar() != null) {
            jsonGenerator.a("location_tag_suggestion");
            GraphQLPlaceSuggestionInfo__JsonHelper.m20919a(jsonGenerator, graphQLPhoto.ar(), true);
        }
        if (graphQLPhoto.as() != null) {
            jsonGenerator.a("lowres");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.as(), true);
        }
        if (graphQLPhoto.at() != null) {
            jsonGenerator.a("mediumImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.at(), true);
        }
        if (graphQLPhoto.au() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPhoto.au(), true);
        }
        jsonGenerator.a("modified_time", graphQLPhoto.av());
        if (graphQLPhoto.aw() != null) {
            jsonGenerator.a("multiShareHDVideoUrl", graphQLPhoto.aw());
        }
        if (graphQLPhoto.ax() != null) {
            jsonGenerator.a("multiShareItemSquareImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.ax(), true);
        }
        if (graphQLPhoto.ay() != null) {
            jsonGenerator.a("multiShareVideoUrl", graphQLPhoto.ay());
        }
        if (graphQLPhoto.az() != null) {
            jsonGenerator.a("narrowLandscapeImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.az(), true);
        }
        if (graphQLPhoto.aA() != null) {
            jsonGenerator.a("narrowPortraitImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.aA(), true);
        }
        if (graphQLPhoto.aB() != null) {
            jsonGenerator.a("owner");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLPhoto.aB(), true);
        }
        if (graphQLPhoto.aC() != null) {
            jsonGenerator.a("paired_video");
            GraphQLVideo__JsonHelper.m22484a(jsonGenerator, graphQLPhoto.aC(), true);
        }
        if (graphQLPhoto.aD() != null) {
            jsonGenerator.a("pending_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLPhoto.aD(), true);
        }
        jsonGenerator.a("photo_encodings");
        if (graphQLPhoto.aE() != null) {
            jsonGenerator.d();
            for (GraphQLPhotoEncoding graphQLPhotoEncoding : graphQLPhoto.aE()) {
                if (graphQLPhotoEncoding != null) {
                    GraphQLPhotoEncoding__JsonHelper.m20724a(jsonGenerator, graphQLPhotoEncoding, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPhoto.aF() != null) {
            jsonGenerator.a("playableUrlHdString", graphQLPhoto.aF());
        }
        if (graphQLPhoto.aG() != null) {
            jsonGenerator.a("playableUrlRtmpString", graphQLPhoto.aG());
        }
        jsonGenerator.a("playable_duration", graphQLPhoto.aH());
        jsonGenerator.a("playable_duration_in_ms", graphQLPhoto.aI());
        if (graphQLPhoto.aJ() != null) {
            jsonGenerator.a("playable_url", graphQLPhoto.aJ());
        }
        if (graphQLPhoto.aK() != null) {
            jsonGenerator.a("portrait");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.aK(), true);
        }
        if (graphQLPhoto.aL() != null) {
            jsonGenerator.a("preferredPlayableUrlString", graphQLPhoto.aL());
        }
        if (graphQLPhoto.aM() != null) {
            jsonGenerator.a("preview_payload", graphQLPhoto.aM());
        }
        if (graphQLPhoto.aN() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLPhoto.aN(), true);
        }
        if (graphQLPhoto.aO() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.aO(), true);
        }
        if (graphQLPhoto.aP() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.aP(), true);
        }
        if (graphQLPhoto.aQ() != null) {
            jsonGenerator.a("profilePhoto");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.aQ(), true);
        }
        if (graphQLPhoto.aR() != null) {
            jsonGenerator.a("profile_picture_overlay");
            GraphQLImageOverlay__JsonHelper.m8631a(jsonGenerator, graphQLPhoto.aR(), true);
        }
        if (graphQLPhoto.aS() != null) {
            jsonGenerator.a("pulseCoverPhoto");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.aS(), true);
        }
        jsonGenerator.a("should_upsell_as_viewer_profile_picture", graphQLPhoto.aT());
        jsonGenerator.a("show_objectionable_warning_in_feed", graphQLPhoto.aU());
        if (graphQLPhoto.aV() != null) {
            jsonGenerator.a("squareLargeImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.aV(), true);
        }
        if (graphQLPhoto.aW() != null) {
            jsonGenerator.a("tags");
            GraphQLPhotoTagsConnection__JsonHelper.m20752a(jsonGenerator, graphQLPhoto.aW(), true);
        }
        if (graphQLPhoto.aX() != null) {
            jsonGenerator.a("url", graphQLPhoto.aX());
        }
        if (graphQLPhoto.aY() != null) {
            jsonGenerator.a("with_tags");
            GraphQLWithTagsConnection__JsonHelper.m22501a(jsonGenerator, graphQLPhoto.aY(), true);
        }
        if (graphQLPhoto.aZ() != null) {
            jsonGenerator.a("imageNatural");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.aZ(), true);
        }
        if (graphQLPhoto.ba() != null) {
            jsonGenerator.a("image_blurred");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPhoto.ba(), true);
        }
        jsonGenerator.a("is_delegating_delete", graphQLPhoto.bb());
        jsonGenerator.a("video_full_size", graphQLPhoto.bc());
        if (graphQLPhoto.bd() != null) {
            jsonGenerator.a("dominant_color", graphQLPhoto.bd());
        }
        if (graphQLPhoto.be() != null) {
            jsonGenerator.a("open_graph_action");
            GraphQLOpenGraphAction__JsonHelper.m9396a(jsonGenerator, graphQLPhoto.be(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
