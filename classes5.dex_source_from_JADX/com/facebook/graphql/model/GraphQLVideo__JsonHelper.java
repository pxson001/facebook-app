package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: Temporary file is somehow already deleted */
public final class GraphQLVideo__JsonHelper {
    public static GraphQLVideo m22483a(JsonParser jsonParser) {
        GraphQLVideo graphQLVideo = new GraphQLVideo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m22485a(graphQLVideo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLVideo;
    }

    private static boolean m22485a(GraphQLVideo graphQLVideo, String str, JsonParser jsonParser) {
        long j = 0;
        double d = 0.0d;
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        GraphQLImage a;
        if ("animated_gif".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "animated_gif"));
            }
            graphQLVideo.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "animated_gif", graphQLVideo.a_, 0, true);
            return true;
        } else if ("animated_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "animated_image"));
            }
            graphQLVideo.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "animated_image", graphQLVideo.B_(), 1, true);
            return true;
        } else if ("atom_size".equals(str)) {
            graphQLVideo.f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "atom_size", graphQLVideo.B_(), 2, false);
            return true;
        } else if ("attribution_app".equals(str)) {
            GraphQLApplication a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "attribution_app"));
            }
            graphQLVideo.g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "attribution_app", graphQLVideo.B_(), 4, true);
            return true;
        } else if ("attribution_app_metadata".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "attribution_app_metadata", graphQLVideo.B_(), 5, false);
            return true;
        } else if ("best_effort_time_taken".equals(str)) {
            graphQLVideo.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "best_effort_time_taken", graphQLVideo.B_(), 6, false);
            return true;
        } else if ("bitrate".equals(str)) {
            graphQLVideo.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "bitrate", graphQLVideo.B_(), 7, false);
            return true;
        } else if ("broadcast_status".equals(str)) {
            graphQLVideo.k = GraphQLVideoBroadcastStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "broadcast_status", graphQLVideo.B_(), 8, false);
            return true;
        } else if ("can_viewer_delete".equals(str)) {
            graphQLVideo.l = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "can_viewer_delete", graphQLVideo.B_(), 9, false);
            return true;
        } else if ("can_viewer_report".equals(str)) {
            graphQLVideo.m = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "can_viewer_report", graphQLVideo.B_(), 10, false);
            return true;
        } else if ("can_viewer_share".equals(str)) {
            graphQLVideo.n = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "can_viewer_share", graphQLVideo.B_(), 11, false);
            return true;
        } else if ("captions_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "captions_url", graphQLVideo.B_(), 12, false);
            return true;
        } else if ("created_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLVideo.p = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "created_time", graphQLVideo.B_(), 13, false);
            return true;
        } else if ("creation_story".equals(str)) {
            GraphQLStory a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "creation_story"));
            }
            graphQLVideo.q = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "creation_story", graphQLVideo.B_(), 14, true);
            return true;
        } else if ("explicit_place".equals(str)) {
            GraphQLPlace a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLPlace__JsonHelper.m20921a(FieldAccessQueryTracker.a(jsonParser, "explicit_place"));
            }
            graphQLVideo.r = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "explicit_place", graphQLVideo.B_(), 15, true);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLVideo.s = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "feedAwesomizerProfilePicture", graphQLVideo.B_(), 16, true);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLVideo.t = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "feedback", graphQLVideo.B_(), 17, true);
            return true;
        } else if ("guided_tour".equals(str)) {
            GraphQLVideoGuidedTour a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLVideoGuidedTour__JsonHelper.m22465a(FieldAccessQueryTracker.a(jsonParser, "guided_tour"));
            }
            graphQLVideo.u = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "guided_tour", graphQLVideo.B_(), 18, true);
            return true;
        } else if ("has_viewer_viewed".equals(str)) {
            graphQLVideo.v = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "has_viewer_viewed", graphQLVideo.B_(), 19, false);
            return true;
        } else if ("has_viewer_watched_video".equals(str)) {
            graphQLVideo.w = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "has_viewer_watched_video", graphQLVideo.B_(), 20, false);
            return true;
        } else if ("hdAtomSize".equals(str)) {
            graphQLVideo.x = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "hdAtomSize", graphQLVideo.B_(), 21, false);
            return true;
        } else if ("hdBitrate".equals(str)) {
            graphQLVideo.y = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "hdBitrate", graphQLVideo.B_(), 22, false);
            return true;
        } else if ("hd_playable_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "hd_playable_url", graphQLVideo.B_(), 23, false);
            return true;
        } else if ("height".equals(str)) {
            graphQLVideo.A = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "height", graphQLVideo.B_(), 24, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "id", graphQLVideo.B_(), 25, false);
            return true;
        } else if ("image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLVideo.C = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "image", graphQLVideo.B_(), 26, true);
            return true;
        } else if ("imageHigh".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHigh"));
            }
            graphQLVideo.D = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageHigh", graphQLVideo.B_(), 27, true);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLVideo.E = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageHighOrig", graphQLVideo.B_(), 28, true);
            return true;
        } else if ("imageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLarge"));
            }
            graphQLVideo.F = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageLarge", graphQLVideo.B_(), 29, true);
            return true;
        } else if ("imageLargeAspect".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLargeAspect"));
            }
            graphQLVideo.G = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageLargeAspect", graphQLVideo.B_(), 30, true);
            return true;
        } else if ("imageLargeSquare".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLargeSquare"));
            }
            graphQLVideo.H = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageLargeSquare", graphQLVideo.B_(), 31, true);
            return true;
        } else if ("imageLow".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageLow"));
            }
            graphQLVideo.I = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageLow", graphQLVideo.B_(), 32, true);
            return true;
        } else if ("imageMedium".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageMedium"));
            }
            graphQLVideo.J = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageMedium", graphQLVideo.B_(), 33, true);
            return true;
        } else if ("imagePreview".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imagePreview"));
            }
            graphQLVideo.K = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imagePreview", graphQLVideo.B_(), 34, true);
            return true;
        } else if ("imageSmallCover".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageSmallCover"));
            }
            graphQLVideo.L = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageSmallCover", graphQLVideo.B_(), 35, true);
            return true;
        } else if ("imageSmallSquare".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageSmallSquare"));
            }
            graphQLVideo.M = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageSmallSquare", graphQLVideo.B_(), 36, true);
            return true;
        } else if ("imageTallCover".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageTallCover"));
            }
            graphQLVideo.N = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageTallCover", graphQLVideo.B_(), 37, true);
            return true;
        } else if ("imageThumbnail".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageThumbnail"));
            }
            graphQLVideo.O = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageThumbnail", graphQLVideo.B_(), 38, true);
            return true;
        } else if ("imageVideoThumbnail".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageVideoThumbnail"));
            }
            graphQLVideo.P = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageVideoThumbnail", graphQLVideo.B_(), 39, true);
            return true;
        } else if ("initial_view_heading_degrees".equals(str)) {
            graphQLVideo.Q = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "initial_view_heading_degrees", graphQLVideo.B_(), 40, false);
            return true;
        } else if ("initial_view_pitch_degrees".equals(str)) {
            graphQLVideo.R = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "initial_view_pitch_degrees", graphQLVideo.B_(), 41, false);
            return true;
        } else if ("initial_view_roll_degrees".equals(str)) {
            graphQLVideo.S = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "initial_view_roll_degrees", graphQLVideo.B_(), 42, false);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLVideo.T = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "inline_activities", graphQLVideo.B_(), 43, true);
            return true;
        } else if ("is_age_restricted".equals(str)) {
            graphQLVideo.U = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "is_age_restricted", graphQLVideo.B_(), 44, false);
            return true;
        } else if ("is_disturbing".equals(str)) {
            graphQLVideo.V = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "is_disturbing", graphQLVideo.B_(), 45, false);
            return true;
        } else if ("is_live_streaming".equals(str)) {
            graphQLVideo.W = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "is_live_streaming", graphQLVideo.B_(), 46, false);
            return true;
        } else if ("is_looping".equals(str)) {
            graphQLVideo.X = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "is_looping", graphQLVideo.B_(), 47, false);
            return true;
        } else if ("is_playable".equals(str)) {
            graphQLVideo.Y = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "is_playable", graphQLVideo.B_(), 48, false);
            return true;
        } else if ("is_save_primary_action".equals(str)) {
            graphQLVideo.Z = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "is_save_primary_action", graphQLVideo.B_(), 49, false);
            return true;
        } else if ("is_spherical".equals(str)) {
            graphQLVideo.aa = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "is_spherical", graphQLVideo.B_(), 50, false);
            return true;
        } else if ("is_video_broadcast".equals(str)) {
            graphQLVideo.ab = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "is_video_broadcast", graphQLVideo.B_(), 51, false);
            return true;
        } else if ("landscape".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "landscape"));
            }
            graphQLVideo.ac = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "landscape", graphQLVideo.B_(), 52, true);
            return true;
        } else if ("largePortraitImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "largePortraitImage"));
            }
            graphQLVideo.ad = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "largePortraitImage", graphQLVideo.B_(), 53, true);
            return true;
        } else if ("largeThumbnail".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "largeThumbnail"));
            }
            graphQLVideo.ae = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "largeThumbnail", graphQLVideo.B_(), 54, true);
            return true;
        } else if ("live_viewer_count".equals(str)) {
            graphQLVideo.af = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "live_viewer_count", graphQLVideo.B_(), 55, false);
            return true;
        } else if ("live_viewer_count_read_only".equals(str)) {
            graphQLVideo.ag = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "live_viewer_count_read_only", graphQLVideo.B_(), 56, false);
            return true;
        } else if ("loop_count".equals(str)) {
            graphQLVideo.ah = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "loop_count", graphQLVideo.B_(), 57, false);
            return true;
        } else if ("lowres".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "lowres"));
            }
            graphQLVideo.ai = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "lowres", graphQLVideo.B_(), 58, true);
            return true;
        } else if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLVideo.aj = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "message", graphQLVideo.B_(), 59, true);
            return true;
        } else if ("multiShareHDVideoUrl".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.ak = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "multiShareHDVideoUrl", graphQLVideo.B_(), 60, false);
            return true;
        } else if ("multiShareItemSquareImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "multiShareItemSquareImage"));
            }
            graphQLVideo.al = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "multiShareItemSquareImage", graphQLVideo.B_(), 61, true);
            return true;
        } else if ("multiShareVideoUrl".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.am = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "multiShareVideoUrl", graphQLVideo.B_(), 62, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.an = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "name", graphQLVideo.B_(), 63, false);
            return true;
        } else if ("narrowLandscapeImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "narrowLandscapeImage"));
            }
            graphQLVideo.ao = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "narrowLandscapeImage", graphQLVideo.B_(), 64, true);
            return true;
        } else if ("narrowPortraitImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "narrowPortraitImage"));
            }
            graphQLVideo.ap = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "narrowPortraitImage", graphQLVideo.B_(), 65, true);
            return true;
        } else if ("owner".equals(str)) {
            GraphQLActor a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "owner"));
            }
            graphQLVideo.aq = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "owner", graphQLVideo.B_(), 66, true);
            return true;
        } else if ("play_count".equals(str)) {
            graphQLVideo.ar = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "play_count", graphQLVideo.B_(), 67, false);
            return true;
        } else if ("playableUrlHdString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.as = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "playableUrlHdString", graphQLVideo.B_(), 68, false);
            return true;
        } else if ("playableUrlRtmpString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.at = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "playableUrlRtmpString", graphQLVideo.B_(), 69, false);
            return true;
        } else if ("playable_duration".equals(str)) {
            graphQLVideo.au = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "playable_duration", graphQLVideo.B_(), 70, false);
            return true;
        } else if ("playable_duration_in_ms".equals(str)) {
            graphQLVideo.av = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "playable_duration_in_ms", graphQLVideo.B_(), 71, false);
            return true;
        } else if ("playable_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.aw = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "playable_url", graphQLVideo.B_(), 72, false);
            return true;
        } else if ("playable_url_hd".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.ax = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "playable_url_hd", graphQLVideo.B_(), 73, false);
            return true;
        } else if ("playable_url_preferred".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.ay = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "playable_url_preferred", graphQLVideo.B_(), 74, false);
            return true;
        } else if ("playlist".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.az = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "playlist", graphQLVideo.B_(), 75, false);
            return true;
        } else if ("portrait".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "portrait"));
            }
            graphQLVideo.aA = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "portrait", graphQLVideo.B_(), 76, true);
            return true;
        } else if ("preferredPlayableUrlString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.aB = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "preferredPlayableUrlString", graphQLVideo.B_(), 77, false);
            return true;
        } else if ("processing_progress".equals(str)) {
            graphQLVideo.aC = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "processing_progress", graphQLVideo.B_(), 78, false);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLVideo.aD = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "profileImageLarge", graphQLVideo.B_(), 79, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLVideo.aE = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "profileImageSmall", graphQLVideo.B_(), 80, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLVideo.aF = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "profilePicture50", graphQLVideo.B_(), 81, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLVideo.aG = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "profilePictureHighRes", graphQLVideo.B_(), 82, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLVideo.aH = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "profilePictureLarge", graphQLVideo.B_(), 83, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLVideo.aI = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "profile_photo", graphQLVideo.B_(), 84, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLVideo.aJ = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "profile_picture", graphQLVideo.B_(), 85, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLVideo.aK = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "profile_picture_is_silhouette", graphQLVideo.B_(), 86, false);
            return true;
        } else if ("projection_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.aL = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "projection_type", graphQLVideo.B_(), 87, false);
            return true;
        } else if ("publisher_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "publisher_context"));
            }
            graphQLVideo.aM = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "publisher_context", graphQLVideo.B_(), 88, true);
            return true;
        } else if ("pulseCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "pulseCoverPhoto"));
            }
            graphQLVideo.aN = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "pulseCoverPhoto", graphQLVideo.B_(), 89, true);
            return true;
        } else if ("rating".equals(str)) {
            GraphQLRating a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLRating__JsonHelper.m21310a(FieldAccessQueryTracker.a(jsonParser, "rating"));
            }
            graphQLVideo.aO = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "rating", graphQLVideo.B_(), 90, true);
            return true;
        } else if ("saved_collection".equals(str)) {
            GraphQLTimelineAppCollection a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "saved_collection"));
            }
            graphQLVideo.aP = a11;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "saved_collection", graphQLVideo.B_(), 91, true);
            return true;
        } else if ("should_open_single_publisher".equals(str)) {
            graphQLVideo.aQ = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "should_open_single_publisher", graphQLVideo.B_(), 93, false);
            return true;
        } else if ("should_show_live_subscribe".equals(str)) {
            graphQLVideo.aR = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "should_show_live_subscribe", graphQLVideo.B_(), 94, false);
            return true;
        } else if ("show_video_home_follow_button".equals(str)) {
            graphQLVideo.aS = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "show_video_home_follow_button", graphQLVideo.B_(), 95, false);
            return true;
        } else if ("sphericalFullscreenAspectRatio".equals(str)) {
            graphQLVideo.aT = jsonParser.g() == JsonToken.VALUE_NULL ? 0.0d : jsonParser.G();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "sphericalFullscreenAspectRatio", graphQLVideo.B_(), 96, false);
            return true;
        } else if ("sphericalInlineAspectRatio".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                d = jsonParser.G();
            }
            graphQLVideo.aU = d;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "sphericalInlineAspectRatio", graphQLVideo.B_(), 97, false);
            return true;
        } else if ("sphericalPlayableUrlHdString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.aV = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "sphericalPlayableUrlHdString", graphQLVideo.B_(), 98, false);
            return true;
        } else if ("sphericalPlayableUrlSdString".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.aW = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "sphericalPlayableUrlSdString", graphQLVideo.B_(), 99, false);
            return true;
        } else if ("sphericalPreferredFov".equals(str)) {
            graphQLVideo.aX = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "sphericalPreferredFov", graphQLVideo.B_(), 100, false);
            return true;
        } else if ("squareLargeImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "squareLargeImage"));
            }
            graphQLVideo.aY = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "squareLargeImage", graphQLVideo.B_(), 101, true);
            return true;
        } else if ("streaming_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_image"));
            }
            graphQLVideo.aZ = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "streaming_image", graphQLVideo.B_(), 102, true);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLVideo.ba = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "streaming_profile_picture", graphQLVideo.B_(), 103, true);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLVideo.bb = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "taggable_object_profile_picture", graphQLVideo.B_(), 104, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLVideo.bc = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "title", graphQLVideo.B_(), 105, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLVideo.bd = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "titleForSummary", graphQLVideo.B_(), 106, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.be = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "url", graphQLVideo.B_(), 107, false);
            return true;
        } else if ("videoThumbnail".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "videoThumbnail"));
            }
            graphQLVideo.bf = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "videoThumbnail", graphQLVideo.B_(), 108, true);
            return true;
        } else if ("video_captions_locales".equals(str)) {
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
            graphQLVideo.bg = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "video_captions_locales", graphQLVideo.B_(), 109, false);
            return true;
        } else if ("video_channel".equals(str)) {
            GraphQLVideoChannel a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLVideoChannel__JsonHelper.m22446a(FieldAccessQueryTracker.a(jsonParser, "video_channel"));
            }
            graphQLVideo.bh = a12;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "video_channel", graphQLVideo.B_(), 110, true);
            return true;
        } else if ("video_full_size".equals(str)) {
            graphQLVideo.bi = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "video_full_size", graphQLVideo.B_(), 111, false);
            return true;
        } else if ("video_preview_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "video_preview_image"));
            }
            graphQLVideo.bj = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "video_preview_image", graphQLVideo.B_(), 112, true);
            return true;
        } else if ("video_status_type".equals(str)) {
            graphQLVideo.bk = GraphQLVideoStatusType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "video_status_type", graphQLVideo.B_(), 113, false);
            return true;
        } else if ("viewer_saved_state".equals(str)) {
            graphQLVideo.bl = GraphQLSavedState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "viewer_saved_state", graphQLVideo.B_(), 114, false);
            return true;
        } else if ("viewer_timeline_collections_containing".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "viewer_timeline_collections_containing"));
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
            graphQLVideo.bm = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "viewer_timeline_collections_containing", graphQLVideo.B_(), 115, true);
            return true;
        } else if ("viewer_timeline_collections_supported".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "viewer_timeline_collections_supported"));
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
            graphQLVideo.bn = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "viewer_timeline_collections_supported", graphQLVideo.B_(), 116, true);
            return true;
        } else if ("width".equals(str)) {
            graphQLVideo.bo = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "width", graphQLVideo.B_(), 117, false);
            return true;
        } else if ("imageNatural".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageNatural"));
            }
            graphQLVideo.bp = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "imageNatural", graphQLVideo.B_(), 118, true);
            return true;
        } else if ("copyrights_violation_dialog_state".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.bq = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "copyrights_violation_dialog_state", graphQLVideo.B_(), 119, false);
            return true;
        } else if ("copyrights_violation_ui_notification_texts".equals(str)) {
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
            graphQLVideo.br = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "copyrights_violation_ui_notification_texts", graphQLVideo.B_(), 120, false);
            return true;
        } else if ("can_cast_video".equals(str)) {
            graphQLVideo.bs = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "can_cast_video", graphQLVideo.B_(), 121, false);
            return true;
        } else if ("video_cast_payload".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.bt = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "video_cast_payload", graphQLVideo.B_(), 122, false);
            return true;
        } else if ("moments_of_interest".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    Integer valueOf = Integer.valueOf(jsonParser.E());
                    if (valueOf != null) {
                        r1.add(valueOf);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLVideo.bu = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "moments_of_interest", graphQLVideo.B_(), 123, false);
            return true;
        } else if ("playableUrlHD".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.bv = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "playableUrlHD", graphQLVideo.B_(), 124, false);
            return true;
        } else if ("show_video_channel_subscribe_button".equals(str)) {
            graphQLVideo.bw = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "show_video_channel_subscribe_button", graphQLVideo.B_(), 125, false);
            return true;
        } else if ("image_blurred".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image_blurred"));
            }
            graphQLVideo.bx = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "image_blurred", graphQLVideo.B_(), 126, true);
            return true;
        } else if ("supports_time_slices".equals(str)) {
            graphQLVideo.by = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "supports_time_slices", graphQLVideo.B_(), 127, false);
            return true;
        } else if ("sponsor_page".equals(str)) {
            GraphQLPage a13;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a13 = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "sponsor_page"));
            }
            graphQLVideo.bz = a13;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "sponsor_page", graphQLVideo.B_(), 131, true);
            return true;
        } else if ("default_quality".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.bA = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "default_quality", graphQLVideo.B_(), 132, false);
            return true;
        } else if ("hd_playable_uri".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.bB = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "hd_playable_uri", graphQLVideo.B_(), 133, false);
            return true;
        } else if ("is_eligible_for_commercial_break".equals(str)) {
            graphQLVideo.bC = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "is_eligible_for_commercial_break", graphQLVideo.B_(), 134, false);
            return true;
        } else if ("sphericalPlaylist".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLVideo.bD = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "sphericalPlaylist", graphQLVideo.B_(), 135, false);
            return true;
        } else if ("post_play_count".equals(str)) {
            graphQLVideo.bE = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "post_play_count", graphQLVideo.B_(), 136, false);
            return true;
        } else if ("total_posts".equals(str)) {
            graphQLVideo.bF = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "total_posts", graphQLVideo.B_(), 137, false);
            return true;
        } else if ("already_invited_live_viewers".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLUser a14 = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "already_invited_live_viewers"));
                    if (a14 != null) {
                        r1.add(a14);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLVideo.bG = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "already_invited_live_viewers", graphQLVideo.B_(), 138, true);
            return true;
        } else if ("is_expired".equals(str)) {
            graphQLVideo.bH = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "is_expired", graphQLVideo.B_(), 139, false);
            return true;
        } else if (!"savable_description".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "savable_description"));
            }
            graphQLVideo.bI = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLVideo, "savable_description", graphQLVideo.B_(), 140, true);
            return true;
        }
    }

    public static void m22484a(JsonGenerator jsonGenerator, GraphQLVideo graphQLVideo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLVideo.j() != null) {
            jsonGenerator.a("animated_gif");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.j(), true);
        }
        if (graphQLVideo.k() != null) {
            jsonGenerator.a("animated_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.k(), true);
        }
        jsonGenerator.a("atom_size", graphQLVideo.o());
        if (graphQLVideo.p() != null) {
            jsonGenerator.a("attribution_app");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLVideo.p(), true);
        }
        if (graphQLVideo.q() != null) {
            jsonGenerator.a("attribution_app_metadata", graphQLVideo.q());
        }
        jsonGenerator.a("best_effort_time_taken", graphQLVideo.r());
        jsonGenerator.a("bitrate", graphQLVideo.s());
        if (graphQLVideo.t() != null) {
            jsonGenerator.a("broadcast_status", graphQLVideo.t().toString());
        }
        jsonGenerator.a("can_viewer_delete", graphQLVideo.u());
        jsonGenerator.a("can_viewer_report", graphQLVideo.v());
        jsonGenerator.a("can_viewer_share", graphQLVideo.w());
        if (graphQLVideo.x() != null) {
            jsonGenerator.a("captions_url", graphQLVideo.x());
        }
        jsonGenerator.a("created_time", graphQLVideo.y());
        if (graphQLVideo.z() != null) {
            jsonGenerator.a("creation_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLVideo.z(), true);
        }
        if (graphQLVideo.A() != null) {
            jsonGenerator.a("explicit_place");
            GraphQLPlace__JsonHelper.m20922a(jsonGenerator, graphQLVideo.A(), true);
        }
        if (graphQLVideo.B() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.B(), true);
        }
        if (graphQLVideo.l() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLVideo.l(), true);
        }
        if (graphQLVideo.C() != null) {
            jsonGenerator.a("guided_tour");
            GraphQLVideoGuidedTour__JsonHelper.m22466a(jsonGenerator, graphQLVideo.C(), true);
        }
        jsonGenerator.a("has_viewer_viewed", graphQLVideo.D());
        jsonGenerator.a("has_viewer_watched_video", graphQLVideo.E());
        jsonGenerator.a("hdAtomSize", graphQLVideo.F());
        jsonGenerator.a("hdBitrate", graphQLVideo.G());
        if (graphQLVideo.H() != null) {
            jsonGenerator.a("hd_playable_url", graphQLVideo.H());
        }
        jsonGenerator.a("height", graphQLVideo.I());
        if (graphQLVideo.J() != null) {
            jsonGenerator.a("id", graphQLVideo.J());
        }
        if (graphQLVideo.K() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.K(), true);
        }
        if (graphQLVideo.L() != null) {
            jsonGenerator.a("imageHigh");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.L(), true);
        }
        if (graphQLVideo.M() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.M(), true);
        }
        if (graphQLVideo.N() != null) {
            jsonGenerator.a("imageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.N(), true);
        }
        if (graphQLVideo.O() != null) {
            jsonGenerator.a("imageLargeAspect");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.O(), true);
        }
        if (graphQLVideo.P() != null) {
            jsonGenerator.a("imageLargeSquare");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.P(), true);
        }
        if (graphQLVideo.Q() != null) {
            jsonGenerator.a("imageLow");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.Q(), true);
        }
        if (graphQLVideo.R() != null) {
            jsonGenerator.a("imageMedium");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.R(), true);
        }
        if (graphQLVideo.S() != null) {
            jsonGenerator.a("imagePreview");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.S(), true);
        }
        if (graphQLVideo.T() != null) {
            jsonGenerator.a("imageSmallCover");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.T(), true);
        }
        if (graphQLVideo.U() != null) {
            jsonGenerator.a("imageSmallSquare");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.U(), true);
        }
        if (graphQLVideo.V() != null) {
            jsonGenerator.a("imageTallCover");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.V(), true);
        }
        if (graphQLVideo.W() != null) {
            jsonGenerator.a("imageThumbnail");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.W(), true);
        }
        if (graphQLVideo.X() != null) {
            jsonGenerator.a("imageVideoThumbnail");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.X(), true);
        }
        jsonGenerator.a("initial_view_heading_degrees", graphQLVideo.Y());
        jsonGenerator.a("initial_view_pitch_degrees", graphQLVideo.Z());
        jsonGenerator.a("initial_view_roll_degrees", graphQLVideo.aa());
        if (graphQLVideo.ab() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLVideo.ab(), true);
        }
        jsonGenerator.a("is_age_restricted", graphQLVideo.ac());
        jsonGenerator.a("is_disturbing", graphQLVideo.ad());
        jsonGenerator.a("is_live_streaming", graphQLVideo.ae());
        jsonGenerator.a("is_looping", graphQLVideo.af());
        jsonGenerator.a("is_playable", graphQLVideo.ag());
        jsonGenerator.a("is_save_primary_action", graphQLVideo.ah());
        jsonGenerator.a("is_spherical", graphQLVideo.ai());
        jsonGenerator.a("is_video_broadcast", graphQLVideo.aj());
        if (graphQLVideo.ak() != null) {
            jsonGenerator.a("landscape");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.ak(), true);
        }
        if (graphQLVideo.al() != null) {
            jsonGenerator.a("largePortraitImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.al(), true);
        }
        if (graphQLVideo.am() != null) {
            jsonGenerator.a("largeThumbnail");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.am(), true);
        }
        jsonGenerator.a("live_viewer_count", graphQLVideo.an());
        jsonGenerator.a("live_viewer_count_read_only", graphQLVideo.ao());
        jsonGenerator.a("loop_count", graphQLVideo.ap());
        if (graphQLVideo.aq() != null) {
            jsonGenerator.a("lowres");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.aq(), true);
        }
        if (graphQLVideo.ar() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLVideo.ar(), true);
        }
        if (graphQLVideo.as() != null) {
            jsonGenerator.a("multiShareHDVideoUrl", graphQLVideo.as());
        }
        if (graphQLVideo.at() != null) {
            jsonGenerator.a("multiShareItemSquareImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.at(), true);
        }
        if (graphQLVideo.au() != null) {
            jsonGenerator.a("multiShareVideoUrl", graphQLVideo.au());
        }
        if (graphQLVideo.av() != null) {
            jsonGenerator.a("name", graphQLVideo.av());
        }
        if (graphQLVideo.aw() != null) {
            jsonGenerator.a("narrowLandscapeImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.aw(), true);
        }
        if (graphQLVideo.ax() != null) {
            jsonGenerator.a("narrowPortraitImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.ax(), true);
        }
        if (graphQLVideo.ay() != null) {
            jsonGenerator.a("owner");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLVideo.ay(), true);
        }
        jsonGenerator.a("play_count", graphQLVideo.az());
        if (graphQLVideo.aA() != null) {
            jsonGenerator.a("playableUrlHdString", graphQLVideo.aA());
        }
        if (graphQLVideo.aB() != null) {
            jsonGenerator.a("playableUrlRtmpString", graphQLVideo.aB());
        }
        jsonGenerator.a("playable_duration", graphQLVideo.aC());
        jsonGenerator.a("playable_duration_in_ms", graphQLVideo.aD());
        if (graphQLVideo.aE() != null) {
            jsonGenerator.a("playable_url", graphQLVideo.aE());
        }
        if (graphQLVideo.aF() != null) {
            jsonGenerator.a("playable_url_hd", graphQLVideo.aF());
        }
        if (graphQLVideo.aG() != null) {
            jsonGenerator.a("playable_url_preferred", graphQLVideo.aG());
        }
        if (graphQLVideo.aH() != null) {
            jsonGenerator.a("playlist", graphQLVideo.aH());
        }
        if (graphQLVideo.aI() != null) {
            jsonGenerator.a("portrait");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.aI(), true);
        }
        if (graphQLVideo.aJ() != null) {
            jsonGenerator.a("preferredPlayableUrlString", graphQLVideo.aJ());
        }
        jsonGenerator.a("processing_progress", graphQLVideo.aK());
        if (graphQLVideo.aL() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.aL(), true);
        }
        if (graphQLVideo.aM() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.aM(), true);
        }
        if (graphQLVideo.aN() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.aN(), true);
        }
        if (graphQLVideo.aO() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.aO(), true);
        }
        if (graphQLVideo.aP() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.aP(), true);
        }
        if (graphQLVideo.aQ() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLVideo.aQ(), true);
        }
        if (graphQLVideo.aR() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.aR(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLVideo.aS());
        if (graphQLVideo.aT() != null) {
            jsonGenerator.a("projection_type", graphQLVideo.aT());
        }
        if (graphQLVideo.aU() != null) {
            jsonGenerator.a("publisher_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLVideo.aU(), true);
        }
        if (graphQLVideo.aV() != null) {
            jsonGenerator.a("pulseCoverPhoto");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.aV(), true);
        }
        if (graphQLVideo.aW() != null) {
            jsonGenerator.a("rating");
            GraphQLRating__JsonHelper.m21311a(jsonGenerator, graphQLVideo.aW(), true);
        }
        if (graphQLVideo.aX() != null) {
            jsonGenerator.a("saved_collection");
            GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLVideo.aX(), true);
        }
        jsonGenerator.a("should_open_single_publisher", graphQLVideo.aY());
        jsonGenerator.a("should_show_live_subscribe", graphQLVideo.aZ());
        jsonGenerator.a("show_video_home_follow_button", graphQLVideo.ba());
        jsonGenerator.a("sphericalFullscreenAspectRatio", graphQLVideo.bb());
        jsonGenerator.a("sphericalInlineAspectRatio", graphQLVideo.bc());
        if (graphQLVideo.bd() != null) {
            jsonGenerator.a("sphericalPlayableUrlHdString", graphQLVideo.bd());
        }
        if (graphQLVideo.be() != null) {
            jsonGenerator.a("sphericalPlayableUrlSdString", graphQLVideo.be());
        }
        jsonGenerator.a("sphericalPreferredFov", graphQLVideo.bf());
        if (graphQLVideo.bg() != null) {
            jsonGenerator.a("squareLargeImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.bg(), true);
        }
        if (graphQLVideo.bh() != null) {
            jsonGenerator.a("streaming_image");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLVideo.bh(), true);
        }
        if (graphQLVideo.bi() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLVideo.bi(), true);
        }
        if (graphQLVideo.bj() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.bj(), true);
        }
        if (graphQLVideo.bk() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLVideo.bk(), true);
        }
        if (graphQLVideo.bl() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLVideo.bl(), true);
        }
        if (graphQLVideo.bm() != null) {
            jsonGenerator.a("url", graphQLVideo.bm());
        }
        if (graphQLVideo.bn() != null) {
            jsonGenerator.a("videoThumbnail");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.bn(), true);
        }
        jsonGenerator.a("video_captions_locales");
        if (graphQLVideo.bo() != null) {
            jsonGenerator.d();
            for (String str : graphQLVideo.bo()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLVideo.bp() != null) {
            jsonGenerator.a("video_channel");
            GraphQLVideoChannel__JsonHelper.m22447a(jsonGenerator, graphQLVideo.bp(), true);
        }
        jsonGenerator.a("video_full_size", graphQLVideo.bq());
        if (graphQLVideo.br() != null) {
            jsonGenerator.a("video_preview_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.br(), true);
        }
        if (graphQLVideo.bs() != null) {
            jsonGenerator.a("video_status_type", graphQLVideo.bs().toString());
        }
        if (graphQLVideo.bt() != null) {
            jsonGenerator.a("viewer_saved_state", graphQLVideo.bt().toString());
        }
        jsonGenerator.a("viewer_timeline_collections_containing");
        if (graphQLVideo.bu() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineAppCollection graphQLTimelineAppCollection : graphQLVideo.bu()) {
                if (graphQLTimelineAppCollection != null) {
                    GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLTimelineAppCollection, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("viewer_timeline_collections_supported");
        if (graphQLVideo.bv() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineAppCollection graphQLTimelineAppCollection2 : graphQLVideo.bv()) {
                if (graphQLTimelineAppCollection2 != null) {
                    GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLTimelineAppCollection2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("width", graphQLVideo.bw());
        if (graphQLVideo.bx() != null) {
            jsonGenerator.a("imageNatural");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.bx(), true);
        }
        if (graphQLVideo.by() != null) {
            jsonGenerator.a("copyrights_violation_dialog_state", graphQLVideo.by());
        }
        jsonGenerator.a("copyrights_violation_ui_notification_texts");
        if (graphQLVideo.bz() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLVideo.bz()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("can_cast_video", graphQLVideo.bA());
        if (graphQLVideo.bB() != null) {
            jsonGenerator.a("video_cast_payload", graphQLVideo.bB());
        }
        jsonGenerator.a("moments_of_interest");
        if (graphQLVideo.bC() != null) {
            jsonGenerator.d();
            for (Integer num : graphQLVideo.bC()) {
                if (num != null) {
                    jsonGenerator.b(num.intValue());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLVideo.bD() != null) {
            jsonGenerator.a("playableUrlHD", graphQLVideo.bD());
        }
        jsonGenerator.a("show_video_channel_subscribe_button", graphQLVideo.bE());
        if (graphQLVideo.bF() != null) {
            jsonGenerator.a("image_blurred");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideo.bF(), true);
        }
        jsonGenerator.a("supports_time_slices", graphQLVideo.bG());
        if (graphQLVideo.bH() != null) {
            jsonGenerator.a("sponsor_page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLVideo.bH(), true);
        }
        if (graphQLVideo.bI() != null) {
            jsonGenerator.a("default_quality", graphQLVideo.bI());
        }
        if (graphQLVideo.bJ() != null) {
            jsonGenerator.a("hd_playable_uri", graphQLVideo.bJ());
        }
        jsonGenerator.a("is_eligible_for_commercial_break", graphQLVideo.bK());
        if (graphQLVideo.bL() != null) {
            jsonGenerator.a("sphericalPlaylist", graphQLVideo.bL());
        }
        jsonGenerator.a("post_play_count", graphQLVideo.bM());
        jsonGenerator.a("total_posts", graphQLVideo.bN());
        jsonGenerator.a("already_invited_live_viewers");
        if (graphQLVideo.bO() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLVideo.bO()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("is_expired", graphQLVideo.bP());
        if (graphQLVideo.bQ() != null) {
            jsonGenerator.a("savable_description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLVideo.bQ(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
