package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: fallback delay ms must be >= 0 */
public final class GraphQLMedia__JsonHelper {
    public static GraphQLMedia m9078a(JsonParser jsonParser) {
        GraphQLMedia graphQLMedia = new GraphQLMedia();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("__type__".equals(i)) {
                GraphQLObjectType graphQLObjectType;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLObjectType = null;
                } else {
                    graphQLObjectType = GraphQLObjectType.a(jsonParser);
                }
                graphQLMedia.d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "__type__", graphQLMedia.a_, 0, false);
            } else if ("accessibility_caption".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "accessibility_caption", graphQLMedia.a_, 1, false);
            } else if ("album".equals(i)) {
                GraphQLAlbum graphQLAlbum;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLAlbum = null;
                } else {
                    graphQLAlbum = GraphQLAlbum__JsonHelper.m6510a(FieldAccessQueryTracker.a(jsonParser, "album"));
                }
                graphQLMedia.f = graphQLAlbum;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "album", graphQLMedia.a_, 2, true);
            } else if ("animated_image".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "animated_image"));
                }
                graphQLMedia.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "animated_image", graphQLMedia.a_, 3, true);
            } else if ("atom_size".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "atom_size", graphQLMedia.a_, 4, false);
            } else if ("attribution_app".equals(i)) {
                GraphQLApplication graphQLApplication;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLApplication = null;
                } else {
                    graphQLApplication = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "attribution_app"));
                }
                graphQLMedia.i = graphQLApplication;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "attribution_app", graphQLMedia.a_, 6, true);
            } else if ("attribution_app_metadata".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "attribution_app_metadata", graphQLMedia.a_, 7, false);
            } else if ("best_effort_time_taken".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.F();
                }
                graphQLMedia.k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "best_effort_time_taken", graphQLMedia.a_, 8, false);
            } else if ("bitrate".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "bitrate", graphQLMedia.a_, 9, false);
            } else if ("can_viewer_add_tags".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.m = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "can_viewer_add_tags", graphQLMedia.a_, 10, false);
            } else if ("can_viewer_delete".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.n = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "can_viewer_delete", graphQLMedia.a_, 11, false);
            } else if ("can_viewer_edit".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.o = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "can_viewer_edit", graphQLMedia.a_, 12, false);
            } else if ("can_viewer_export".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.p = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "can_viewer_export", graphQLMedia.a_, 13, false);
            } else if ("can_viewer_make_cover_photo".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.q = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "can_viewer_make_cover_photo", graphQLMedia.a_, 14, false);
            } else if ("can_viewer_make_profile_picture".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.r = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "can_viewer_make_profile_picture", graphQLMedia.a_, 15, false);
            } else if ("can_viewer_report".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.s = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "can_viewer_report", graphQLMedia.a_, 16, false);
            } else if ("can_viewer_share".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.t = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "can_viewer_share", graphQLMedia.a_, 17, false);
            } else if ("can_viewer_suggest_location".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.u = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "can_viewer_suggest_location", graphQLMedia.a_, 18, false);
            } else if ("can_viewer_untag".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.v = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "can_viewer_untag", graphQLMedia.a_, 19, false);
            } else if ("captions_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.w = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "captions_url", graphQLMedia.a_, 20, false);
            } else if ("container_story".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "container_story"));
                }
                graphQLMedia.x = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "container_story", graphQLMedia.a_, 21, true);
            } else if ("created_time".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.F();
                }
                graphQLMedia.y = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "created_time", graphQLMedia.a_, 22, false);
            } else if ("creation_story".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "creation_story"));
                }
                graphQLMedia.z = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "creation_story", graphQLMedia.a_, 23, true);
            } else if ("explicit_place".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "explicit_place"));
                }
                graphQLMedia.A = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "explicit_place", graphQLMedia.a_, 24, true);
            } else if ("face_boxes".equals(i)) {
                GraphQLPhotoFaceBoxesConnection graphQLPhotoFaceBoxesConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPhotoFaceBoxesConnection = null;
                } else {
                    graphQLPhotoFaceBoxesConnection = GraphQLPhotoFaceBoxesConnection__JsonHelper.m20730a(FieldAccessQueryTracker.a(jsonParser, "face_boxes"));
                }
                graphQLMedia.B = graphQLPhotoFaceBoxesConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "face_boxes", graphQLMedia.a_, 25, true);
            } else if ("feedback".equals(i)) {
                GraphQLFeedback graphQLFeedback;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLFeedback = null;
                } else {
                    graphQLFeedback = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
                }
                graphQLMedia.C = graphQLFeedback;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "feedback", graphQLMedia.a_, 26, true);
            } else if ("focus".equals(i)) {
                GraphQLVect2 graphQLVect2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLVect2 = null;
                } else {
                    graphQLVect2 = GraphQLVect2__JsonHelper.m22421a(FieldAccessQueryTracker.a(jsonParser, "focus"));
                }
                graphQLMedia.D = graphQLVect2;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "focus", graphQLMedia.a_, 27, true);
            } else if ("guided_tour".equals(i)) {
                graphQLMedia.E = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLVideoGuidedTour__JsonHelper.m22465a(FieldAccessQueryTracker.a(jsonParser, "guided_tour"));
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "guided_tour", graphQLMedia.a_, 28, true);
            } else if ("has_stickers".equals(i)) {
                graphQLMedia.F = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "has_stickers", graphQLMedia.a_, 29, false);
            } else if ("has_viewer_viewed".equals(i)) {
                graphQLMedia.G = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "has_viewer_viewed", graphQLMedia.a_, 30, false);
            } else if ("has_viewer_watched_video".equals(i)) {
                graphQLMedia.H = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "has_viewer_watched_video", graphQLMedia.a_, 31, false);
            } else if ("hdAtomSize".equals(i)) {
                graphQLMedia.I = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "hdAtomSize", graphQLMedia.a_, 32, false);
            } else if ("hdBitrate".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.J = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "hdBitrate", graphQLMedia.a_, 33, false);
            } else if ("hd_playable_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.K = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "hd_playable_url", graphQLMedia.a_, 34, false);
            } else if ("height".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.L = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "height", graphQLMedia.a_, 35, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.M = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "id", graphQLMedia.a_, 36, false);
            } else if ("image".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
                }
                graphQLMedia.N = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "image", graphQLMedia.a_, 37, true);
            } else if ("imageHigh".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHigh"));
                }
                graphQLMedia.O = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageHigh", graphQLMedia.a_, 38, true);
            } else if ("imageHighOrig".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
                }
                graphQLMedia.P = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageHighOrig", graphQLMedia.a_, 39, true);
            } else if ("imageLarge".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLarge"));
                }
                graphQLMedia.Q = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageLarge", graphQLMedia.a_, 40, true);
            } else if ("imageLargeAspect".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLargeAspect"));
                }
                graphQLMedia.R = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageLargeAspect", graphQLMedia.a_, 41, true);
            } else if ("imageLargeSquare".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLargeSquare"));
                }
                graphQLMedia.S = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageLargeSquare", graphQLMedia.a_, 42, true);
            } else if ("imageLow".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLow"));
                }
                graphQLMedia.T = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageLow", graphQLMedia.a_, 43, true);
            } else if ("imageMedium".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageMedium"));
                }
                graphQLMedia.U = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageMedium", graphQLMedia.a_, 44, true);
            } else if ("imagePreview".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imagePreview"));
                }
                graphQLMedia.V = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imagePreview", graphQLMedia.a_, 45, true);
            } else if ("imageSmallCover".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageSmallCover"));
                }
                graphQLMedia.W = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageSmallCover", graphQLMedia.a_, 46, true);
            } else if ("imageSmallSquare".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageSmallSquare"));
                }
                graphQLMedia.X = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageSmallSquare", graphQLMedia.a_, 47, true);
            } else if ("imageTallCover".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageTallCover"));
                }
                graphQLMedia.Y = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageTallCover", graphQLMedia.a_, 48, true);
            } else if ("imageThumbnail".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageThumbnail"));
                }
                graphQLMedia.Z = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageThumbnail", graphQLMedia.a_, 49, true);
            } else if ("initial_view_heading_degrees".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.aa = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "initial_view_heading_degrees", graphQLMedia.a_, 50, false);
            } else if ("initial_view_pitch_degrees".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.ab = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "initial_view_pitch_degrees", graphQLMedia.a_, 51, false);
            } else if ("initial_view_roll_degrees".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.ac = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "initial_view_roll_degrees", graphQLMedia.a_, 52, false);
            } else if ("inline_activities".equals(i)) {
                GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLInlineActivitiesConnection = null;
                } else {
                    graphQLInlineActivitiesConnection = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
                }
                graphQLMedia.ad = graphQLInlineActivitiesConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "inline_activities", graphQLMedia.a_, 53, true);
            } else if ("is_age_restricted".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.ae = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_age_restricted", graphQLMedia.a_, 54, false);
            } else if ("is_disturbing".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.af = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_disturbing", graphQLMedia.a_, 55, false);
            } else if ("is_live_streaming".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.ag = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_live_streaming", graphQLMedia.a_, 56, false);
            } else if ("is_looping".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.ah = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_looping", graphQLMedia.a_, 57, false);
            } else if ("is_playable".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.ai = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_playable", graphQLMedia.a_, 58, false);
            } else if ("is_save_primary_action".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.aj = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_save_primary_action", graphQLMedia.a_, 59, false);
            } else if ("is_spherical".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.ak = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_spherical", graphQLMedia.a_, 60, false);
            } else if ("is_video_broadcast".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.al = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_video_broadcast", graphQLMedia.a_, 61, false);
            } else if ("is_viewer_suggested_tagger".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.am = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_viewer_suggested_tagger", graphQLMedia.a_, 62, false);
            } else if ("landscape".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "landscape"));
                }
                graphQLMedia.an = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "landscape", graphQLMedia.a_, 63, true);
            } else if ("largePortraitImage".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "largePortraitImage"));
                }
                graphQLMedia.ao = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "largePortraitImage", graphQLMedia.a_, 64, true);
            } else if ("largeThumbnail".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "largeThumbnail"));
                }
                graphQLMedia.ap = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "largeThumbnail", graphQLMedia.a_, 65, true);
            } else if ("live_viewer_count_read_only".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.aq = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "live_viewer_count_read_only", graphQLMedia.a_, 66, false);
            } else if ("location_tag_suggestion".equals(i)) {
                GraphQLPlaceSuggestionInfo graphQLPlaceSuggestionInfo;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPlaceSuggestionInfo = null;
                } else {
                    graphQLPlaceSuggestionInfo = GraphQLPlaceSuggestionInfo__JsonHelper.m20918a(FieldAccessQueryTracker.a(jsonParser, "location_tag_suggestion"));
                }
                graphQLMedia.ar = graphQLPlaceSuggestionInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "location_tag_suggestion", graphQLMedia.a_, 67, true);
            } else if ("loop_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.as = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "loop_count", graphQLMedia.a_, 68, false);
            } else if ("lowres".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "lowres"));
                }
                graphQLMedia.at = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "lowres", graphQLMedia.a_, 69, true);
            } else if ("message".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
                }
                graphQLMedia.au = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "message", graphQLMedia.a_, 70, true);
            } else if ("multiShareHDVideoUrl".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.av = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "multiShareHDVideoUrl", graphQLMedia.a_, 71, false);
            } else if ("multiShareItemSquareImage".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "multiShareItemSquareImage"));
                }
                graphQLMedia.aw = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "multiShareItemSquareImage", graphQLMedia.a_, 72, true);
            } else if ("multiShareVideoUrl".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.ax = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "multiShareVideoUrl", graphQLMedia.a_, 73, false);
            } else if ("narrowLandscapeImage".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "narrowLandscapeImage"));
                }
                graphQLMedia.ay = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "narrowLandscapeImage", graphQLMedia.a_, 74, true);
            } else if ("narrowPortraitImage".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "narrowPortraitImage"));
                }
                graphQLMedia.az = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "narrowPortraitImage", graphQLMedia.a_, 75, true);
            } else if ("owner".equals(i)) {
                GraphQLActor graphQLActor;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLActor = null;
                } else {
                    graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "owner"));
                }
                graphQLMedia.aA = graphQLActor;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "owner", graphQLMedia.a_, 76, true);
            } else if ("paired_video".equals(i)) {
                GraphQLVideo graphQLVideo;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLVideo = null;
                } else {
                    graphQLVideo = GraphQLVideo__JsonHelper.m22483a(FieldAccessQueryTracker.a(jsonParser, "paired_video"));
                }
                graphQLMedia.aB = graphQLVideo;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "paired_video", graphQLMedia.a_, 77, true);
            } else if ("pending_place".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "pending_place"));
                }
                graphQLMedia.aC = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "pending_place", graphQLMedia.a_, 78, true);
            } else if ("photo_encodings".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLPhotoEncoding a = GraphQLPhotoEncoding__JsonHelper.m20723a(FieldAccessQueryTracker.a(jsonParser, "photo_encodings"));
                        if (a != null) {
                            r3.add(a);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLMedia.aD = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "photo_encodings", graphQLMedia.a_, 79, true);
            } else if ("play_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.aE = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "play_count", graphQLMedia.a_, 80, false);
            } else if ("playableUrlHdString".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.aF = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "playableUrlHdString", graphQLMedia.a_, 81, false);
            } else if ("playableUrlRtmpString".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.aG = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "playableUrlRtmpString", graphQLMedia.a_, 82, false);
            } else if ("playable_duration".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.aH = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "playable_duration", graphQLMedia.a_, 83, false);
            } else if ("playable_duration_in_ms".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.aI = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "playable_duration_in_ms", graphQLMedia.a_, 84, false);
            } else if ("playable_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.aJ = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "playable_url", graphQLMedia.a_, 85, false);
            } else if ("playlist".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.aK = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "playlist", graphQLMedia.a_, 86, false);
            } else if ("portrait".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "portrait"));
                }
                graphQLMedia.aL = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "portrait", graphQLMedia.a_, 87, true);
            } else if ("preferredPlayableUrlString".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.aM = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "preferredPlayableUrlString", graphQLMedia.a_, 88, false);
            } else if ("privacy_scope".equals(i)) {
                GraphQLPrivacyScope graphQLPrivacyScope;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPrivacyScope = null;
                } else {
                    graphQLPrivacyScope = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
                }
                graphQLMedia.aN = graphQLPrivacyScope;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "privacy_scope", graphQLMedia.a_, 89, true);
            } else if ("profile_picture_overlay".equals(i)) {
                GraphQLImageOverlay graphQLImageOverlay;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLImageOverlay = null;
                } else {
                    graphQLImageOverlay = GraphQLImageOverlay__JsonHelper.m8630a(FieldAccessQueryTracker.a(jsonParser, "profile_picture_overlay"));
                }
                graphQLMedia.aO = graphQLImageOverlay;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "profile_picture_overlay", graphQLMedia.a_, 90, true);
            } else if ("projection_type".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.aP = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "projection_type", graphQLMedia.a_, 91, false);
            } else if ("publisher_context".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "publisher_context"));
                }
                graphQLMedia.aQ = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "publisher_context", graphQLMedia.a_, 92, true);
            } else if ("pulseCoverPhoto".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "pulseCoverPhoto"));
                }
                graphQLMedia.aR = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "pulseCoverPhoto", graphQLMedia.a_, 93, true);
            } else if ("should_open_single_publisher".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.aS = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "should_open_single_publisher", graphQLMedia.a_, 94, false);
            } else if ("should_show_live_subscribe".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.aT = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "should_show_live_subscribe", graphQLMedia.a_, 95, false);
            } else if ("should_upsell_as_viewer_profile_picture".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.aU = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "should_upsell_as_viewer_profile_picture", graphQLMedia.a_, 96, false);
            } else if ("show_objectionable_warning_in_feed".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.aV = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "show_objectionable_warning_in_feed", graphQLMedia.a_, 97, false);
            } else if ("show_video_home_follow_button".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.aW = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "show_video_home_follow_button", graphQLMedia.a_, 98, false);
            } else if ("sphericalFullscreenAspectRatio".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0.0d;
                } else {
                    r3 = jsonParser.G();
                }
                graphQLMedia.aX = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "sphericalFullscreenAspectRatio", graphQLMedia.a_, 99, false);
            } else if ("sphericalInlineAspectRatio".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0.0d;
                } else {
                    r3 = jsonParser.G();
                }
                graphQLMedia.aY = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "sphericalInlineAspectRatio", graphQLMedia.a_, 100, false);
            } else if ("sphericalPlayableUrlHdString".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.aZ = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "sphericalPlayableUrlHdString", graphQLMedia.a_, 101, false);
            } else if ("sphericalPlayableUrlSdString".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMedia.ba = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "sphericalPlayableUrlSdString", graphQLMedia.a_, 102, false);
            } else if ("sphericalPreferredFov".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.bb = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "sphericalPreferredFov", graphQLMedia.a_, 103, false);
            } else if ("squareLargeImage".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "squareLargeImage"));
                }
                graphQLMedia.bc = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "squareLargeImage", graphQLMedia.a_, 104, true);
            } else if ("streaming_image".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_image"));
                }
                graphQLMedia.bd = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "streaming_image", graphQLMedia.a_, 105, true);
            } else if ("streaming_profile_picture".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
                }
                graphQLMedia.be = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "streaming_profile_picture", graphQLMedia.a_, 106, true);
            } else if ("tags".equals(i)) {
                GraphQLPhotoTagsConnection graphQLPhotoTagsConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPhotoTagsConnection = null;
                } else {
                    graphQLPhotoTagsConnection = GraphQLPhotoTagsConnection__JsonHelper.m20751a(FieldAccessQueryTracker.a(jsonParser, "tags"));
                }
                graphQLMedia.bf = graphQLPhotoTagsConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "tags", graphQLMedia.a_, 107, true);
            } else if ("video_captions_locales".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (o != null) {
                            r3.add(o);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLMedia.bg = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "video_captions_locales", graphQLMedia.a_, 108, false);
            } else if ("video_channel".equals(i)) {
                GraphQLVideoChannel graphQLVideoChannel;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLVideoChannel = null;
                } else {
                    graphQLVideoChannel = GraphQLVideoChannel__JsonHelper.m22446a(FieldAccessQueryTracker.a(jsonParser, "video_channel"));
                }
                graphQLMedia.bh = graphQLVideoChannel;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "video_channel", graphQLMedia.a_, 109, true);
            } else if ("video_full_size".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.bi = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "video_full_size", graphQLMedia.a_, 110, false);
            } else if ("width".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.bj = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "width", graphQLMedia.a_, 111, false);
            } else if ("with_tags".equals(i)) {
                GraphQLWithTagsConnection graphQLWithTagsConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLWithTagsConnection = null;
                } else {
                    graphQLWithTagsConnection = GraphQLWithTagsConnection__JsonHelper.m22500a(FieldAccessQueryTracker.a(jsonParser, "with_tags"));
                }
                graphQLMedia.bk = graphQLWithTagsConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "with_tags", graphQLMedia.a_, 112, true);
            } else if ("imageNatural".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageNatural"));
                }
                graphQLMedia.bl = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "imageNatural", graphQLMedia.a_, 113, true);
            } else if ("broadcast_status".equals(i)) {
                graphQLMedia.bm = GraphQLVideoBroadcastStatus.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "broadcast_status", graphQLMedia.a_, 114, false);
            } else if ("show_video_channel_subscribe_button".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.bn = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "show_video_channel_subscribe_button", graphQLMedia.a_, 115, false);
            } else if ("image_blurred".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image_blurred"));
                }
                graphQLMedia.bo = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "image_blurred", graphQLMedia.a_, 116, true);
            } else if ("video_status_type".equals(i)) {
                graphQLMedia.bp = GraphQLVideoStatusType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "video_status_type", graphQLMedia.a_, 117, false);
            } else if ("supports_time_slices".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.bq = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "supports_time_slices", graphQLMedia.a_, 118, false);
            } else if ("sponsor_page".equals(i)) {
                GraphQLPage graphQLPage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPage = null;
                } else {
                    graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "sponsor_page"));
                }
                graphQLMedia.br = graphQLPage;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "sponsor_page", graphQLMedia.a_, 122, true);
            } else if ("is_delegating_delete".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.bs = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_delegating_delete", graphQLMedia.a_, 123, false);
            } else if ("is_eligible_for_commercial_break".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLMedia.bt = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "is_eligible_for_commercial_break", graphQLMedia.a_, 124, false);
            } else if ("post_play_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.bu = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "post_play_count", graphQLMedia.a_, 125, false);
            } else if ("total_posts".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLMedia.bv = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMedia, "total_posts", graphQLMedia.a_, 126, false);
            }
            jsonParser.f();
        }
        return graphQLMedia;
    }

    public static void m9079a(JsonGenerator jsonGenerator, GraphQLMedia graphQLMedia, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLMedia.j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLMedia.j().e());
            jsonGenerator.g();
        }
        if (graphQLMedia.k() != null) {
            jsonGenerator.a("accessibility_caption", graphQLMedia.k());
        }
        if (graphQLMedia.l() != null) {
            jsonGenerator.a("album");
            GraphQLAlbum__JsonHelper.m6511a(jsonGenerator, graphQLMedia.l(), true);
        }
        if (graphQLMedia.m() != null) {
            jsonGenerator.a("animated_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.m(), true);
        }
        jsonGenerator.a("atom_size", graphQLMedia.n());
        if (graphQLMedia.o() != null) {
            jsonGenerator.a("attribution_app");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLMedia.o(), true);
        }
        if (graphQLMedia.p() != null) {
            jsonGenerator.a("attribution_app_metadata", graphQLMedia.p());
        }
        jsonGenerator.a("best_effort_time_taken", graphQLMedia.q());
        jsonGenerator.a("bitrate", graphQLMedia.r());
        jsonGenerator.a("can_viewer_add_tags", graphQLMedia.s());
        jsonGenerator.a("can_viewer_delete", graphQLMedia.t());
        jsonGenerator.a("can_viewer_edit", graphQLMedia.u());
        jsonGenerator.a("can_viewer_export", graphQLMedia.v());
        jsonGenerator.a("can_viewer_make_cover_photo", graphQLMedia.w());
        jsonGenerator.a("can_viewer_make_profile_picture", graphQLMedia.x());
        jsonGenerator.a("can_viewer_report", graphQLMedia.y());
        jsonGenerator.a("can_viewer_share", graphQLMedia.z());
        jsonGenerator.a("can_viewer_suggest_location", graphQLMedia.A());
        jsonGenerator.a("can_viewer_untag", graphQLMedia.B());
        if (graphQLMedia.C() != null) {
            jsonGenerator.a("captions_url", graphQLMedia.C());
        }
        if (graphQLMedia.D() != null) {
            jsonGenerator.a("container_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLMedia.D(), true);
        }
        jsonGenerator.a("created_time", graphQLMedia.E());
        if (graphQLMedia.F() != null) {
            jsonGenerator.a("creation_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLMedia.F(), true);
        }
        if (graphQLMedia.G() != null) {
            jsonGenerator.a("explicit_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLMedia.G(), true);
        }
        if (graphQLMedia.H() != null) {
            jsonGenerator.a("face_boxes");
            GraphQLPhotoFaceBoxesConnection__JsonHelper.m20731a(jsonGenerator, graphQLMedia.H(), true);
        }
        if (graphQLMedia.I() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLMedia.I(), true);
        }
        if (graphQLMedia.J() != null) {
            jsonGenerator.a("focus");
            GraphQLVect2__JsonHelper.m22422a(jsonGenerator, graphQLMedia.J(), true);
        }
        if (graphQLMedia.K() != null) {
            jsonGenerator.a("guided_tour");
            GraphQLVideoGuidedTour__JsonHelper.m22466a(jsonGenerator, graphQLMedia.K(), true);
        }
        jsonGenerator.a("has_stickers", graphQLMedia.L());
        jsonGenerator.a("has_viewer_viewed", graphQLMedia.M());
        jsonGenerator.a("has_viewer_watched_video", graphQLMedia.N());
        jsonGenerator.a("hdAtomSize", graphQLMedia.O());
        jsonGenerator.a("hdBitrate", graphQLMedia.P());
        if (graphQLMedia.Q() != null) {
            jsonGenerator.a("hd_playable_url", graphQLMedia.Q());
        }
        jsonGenerator.a("height", graphQLMedia.R());
        if (graphQLMedia.b() != null) {
            jsonGenerator.a("id", graphQLMedia.b());
        }
        if (graphQLMedia.S() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.S(), true);
        }
        if (graphQLMedia.T() != null) {
            jsonGenerator.a("imageHigh");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.T(), true);
        }
        if (graphQLMedia.U() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.U(), true);
        }
        if (graphQLMedia.V() != null) {
            jsonGenerator.a("imageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.V(), true);
        }
        if (graphQLMedia.W() != null) {
            jsonGenerator.a("imageLargeAspect");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.W(), true);
        }
        if (graphQLMedia.X() != null) {
            jsonGenerator.a("imageLargeSquare");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.X(), true);
        }
        if (graphQLMedia.Y() != null) {
            jsonGenerator.a("imageLow");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.Y(), true);
        }
        if (graphQLMedia.Z() != null) {
            jsonGenerator.a("imageMedium");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.Z(), true);
        }
        if (graphQLMedia.aa() != null) {
            jsonGenerator.a("imagePreview");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.aa(), true);
        }
        if (graphQLMedia.ab() != null) {
            jsonGenerator.a("imageSmallCover");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.ab(), true);
        }
        if (graphQLMedia.ac() != null) {
            jsonGenerator.a("imageSmallSquare");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.ac(), true);
        }
        if (graphQLMedia.ad() != null) {
            jsonGenerator.a("imageTallCover");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.ad(), true);
        }
        if (graphQLMedia.ae() != null) {
            jsonGenerator.a("imageThumbnail");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.ae(), true);
        }
        jsonGenerator.a("initial_view_heading_degrees", graphQLMedia.af());
        jsonGenerator.a("initial_view_pitch_degrees", graphQLMedia.ag());
        jsonGenerator.a("initial_view_roll_degrees", graphQLMedia.ah());
        if (graphQLMedia.ai() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLMedia.ai(), true);
        }
        jsonGenerator.a("is_age_restricted", graphQLMedia.aj());
        jsonGenerator.a("is_disturbing", graphQLMedia.ak());
        jsonGenerator.a("is_live_streaming", graphQLMedia.al());
        jsonGenerator.a("is_looping", graphQLMedia.am());
        jsonGenerator.a("is_playable", graphQLMedia.an());
        jsonGenerator.a("is_save_primary_action", graphQLMedia.ao());
        jsonGenerator.a("is_spherical", graphQLMedia.ap());
        jsonGenerator.a("is_video_broadcast", graphQLMedia.aq());
        jsonGenerator.a("is_viewer_suggested_tagger", graphQLMedia.ar());
        if (graphQLMedia.as() != null) {
            jsonGenerator.a("landscape");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.as(), true);
        }
        if (graphQLMedia.at() != null) {
            jsonGenerator.a("largePortraitImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.at(), true);
        }
        if (graphQLMedia.au() != null) {
            jsonGenerator.a("largeThumbnail");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.au(), true);
        }
        jsonGenerator.a("live_viewer_count_read_only", graphQLMedia.av());
        if (graphQLMedia.aw() != null) {
            jsonGenerator.a("location_tag_suggestion");
            GraphQLPlaceSuggestionInfo__JsonHelper.m20919a(jsonGenerator, graphQLMedia.aw(), true);
        }
        jsonGenerator.a("loop_count", graphQLMedia.ax());
        if (graphQLMedia.ay() != null) {
            jsonGenerator.a("lowres");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.ay(), true);
        }
        if (graphQLMedia.az() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLMedia.az(), true);
        }
        if (graphQLMedia.aA() != null) {
            jsonGenerator.a("multiShareHDVideoUrl", graphQLMedia.aA());
        }
        if (graphQLMedia.aB() != null) {
            jsonGenerator.a("multiShareItemSquareImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.aB(), true);
        }
        if (graphQLMedia.aC() != null) {
            jsonGenerator.a("multiShareVideoUrl", graphQLMedia.aC());
        }
        if (graphQLMedia.aD() != null) {
            jsonGenerator.a("narrowLandscapeImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.aD(), true);
        }
        if (graphQLMedia.aE() != null) {
            jsonGenerator.a("narrowPortraitImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.aE(), true);
        }
        if (graphQLMedia.aF() != null) {
            jsonGenerator.a("owner");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLMedia.aF(), true);
        }
        if (graphQLMedia.aG() != null) {
            jsonGenerator.a("paired_video");
            GraphQLVideo__JsonHelper.m22484a(jsonGenerator, graphQLMedia.aG(), true);
        }
        if (graphQLMedia.aH() != null) {
            jsonGenerator.a("pending_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLMedia.aH(), true);
        }
        jsonGenerator.a("photo_encodings");
        if (graphQLMedia.aI() != null) {
            jsonGenerator.d();
            for (GraphQLPhotoEncoding graphQLPhotoEncoding : graphQLMedia.aI()) {
                if (graphQLPhotoEncoding != null) {
                    GraphQLPhotoEncoding__JsonHelper.m20724a(jsonGenerator, graphQLPhotoEncoding, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("play_count", graphQLMedia.aJ());
        if (graphQLMedia.aK() != null) {
            jsonGenerator.a("playableUrlHdString", graphQLMedia.aK());
        }
        if (graphQLMedia.aL() != null) {
            jsonGenerator.a("playableUrlRtmpString", graphQLMedia.aL());
        }
        jsonGenerator.a("playable_duration", graphQLMedia.aM());
        jsonGenerator.a("playable_duration_in_ms", graphQLMedia.aN());
        if (graphQLMedia.aO() != null) {
            jsonGenerator.a("playable_url", graphQLMedia.aO());
        }
        if (graphQLMedia.aP() != null) {
            jsonGenerator.a("playlist", graphQLMedia.aP());
        }
        if (graphQLMedia.aQ() != null) {
            jsonGenerator.a("portrait");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.aQ(), true);
        }
        if (graphQLMedia.aR() != null) {
            jsonGenerator.a("preferredPlayableUrlString", graphQLMedia.aR());
        }
        if (graphQLMedia.aS() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLMedia.aS(), true);
        }
        if (graphQLMedia.aT() != null) {
            jsonGenerator.a("profile_picture_overlay");
            GraphQLImageOverlay__JsonHelper.m8631a(jsonGenerator, graphQLMedia.aT(), true);
        }
        if (graphQLMedia.aU() != null) {
            jsonGenerator.a("projection_type", graphQLMedia.aU());
        }
        if (graphQLMedia.aV() != null) {
            jsonGenerator.a("publisher_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLMedia.aV(), true);
        }
        if (graphQLMedia.aW() != null) {
            jsonGenerator.a("pulseCoverPhoto");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.aW(), true);
        }
        jsonGenerator.a("should_open_single_publisher", graphQLMedia.aX());
        jsonGenerator.a("should_show_live_subscribe", graphQLMedia.aY());
        jsonGenerator.a("should_upsell_as_viewer_profile_picture", graphQLMedia.aZ());
        jsonGenerator.a("show_objectionable_warning_in_feed", graphQLMedia.ba());
        jsonGenerator.a("show_video_home_follow_button", graphQLMedia.bb());
        jsonGenerator.a("sphericalFullscreenAspectRatio", graphQLMedia.bc());
        jsonGenerator.a("sphericalInlineAspectRatio", graphQLMedia.bd());
        if (graphQLMedia.be() != null) {
            jsonGenerator.a("sphericalPlayableUrlHdString", graphQLMedia.be());
        }
        if (graphQLMedia.bf() != null) {
            jsonGenerator.a("sphericalPlayableUrlSdString", graphQLMedia.bf());
        }
        jsonGenerator.a("sphericalPreferredFov", graphQLMedia.bg());
        if (graphQLMedia.bh() != null) {
            jsonGenerator.a("squareLargeImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.bh(), true);
        }
        if (graphQLMedia.bi() != null) {
            jsonGenerator.a("streaming_image");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLMedia.bi(), true);
        }
        if (graphQLMedia.bj() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLMedia.bj(), true);
        }
        if (graphQLMedia.bk() != null) {
            jsonGenerator.a("tags");
            GraphQLPhotoTagsConnection__JsonHelper.m20752a(jsonGenerator, graphQLMedia.bk(), true);
        }
        jsonGenerator.a("video_captions_locales");
        if (graphQLMedia.bl() != null) {
            jsonGenerator.d();
            for (String str : graphQLMedia.bl()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLMedia.bm() != null) {
            jsonGenerator.a("video_channel");
            GraphQLVideoChannel__JsonHelper.m22447a(jsonGenerator, graphQLMedia.bm(), true);
        }
        jsonGenerator.a("video_full_size", graphQLMedia.bn());
        jsonGenerator.a("width", graphQLMedia.bo());
        if (graphQLMedia.bp() != null) {
            jsonGenerator.a("with_tags");
            GraphQLWithTagsConnection__JsonHelper.m22501a(jsonGenerator, graphQLMedia.bp(), true);
        }
        if (graphQLMedia.bq() != null) {
            jsonGenerator.a("imageNatural");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.bq(), true);
        }
        if (graphQLMedia.br() != null) {
            jsonGenerator.a("broadcast_status", graphQLMedia.br().toString());
        }
        jsonGenerator.a("show_video_channel_subscribe_button", graphQLMedia.bs());
        if (graphQLMedia.bt() != null) {
            jsonGenerator.a("image_blurred");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMedia.bt(), true);
        }
        if (graphQLMedia.bu() != null) {
            jsonGenerator.a("video_status_type", graphQLMedia.bu().toString());
        }
        jsonGenerator.a("supports_time_slices", graphQLMedia.bv());
        if (graphQLMedia.bw() != null) {
            jsonGenerator.a("sponsor_page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLMedia.bw(), true);
        }
        jsonGenerator.a("is_delegating_delete", graphQLMedia.bx());
        jsonGenerator.a("is_eligible_for_commercial_break", graphQLMedia.by());
        jsonGenerator.a("post_play_count", graphQLMedia.bz());
        jsonGenerator.a("total_posts", graphQLMedia.bA());
        if (z) {
            jsonGenerator.g();
        }
    }
}
