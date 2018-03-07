package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: on_this_day_friendversary_card */
public class GraphQLMediaDeserializer {
    public static int m5338a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[127];
        boolean[] zArr = new boolean[55];
        boolean[] zArr2 = new boolean[31];
        int[] iArr2 = new int[18];
        long[] jArr = new long[2];
        double[] dArr = new double[2];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("accessibility_caption")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("album")) {
                    iArr[2] = GraphQLAlbumDeserializer.m4549a(jsonParser, flatBufferBuilder);
                } else if (i.equals("animated_image")) {
                    iArr[3] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("atom_size")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("attribution_app")) {
                    iArr[6] = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attribution_app_metadata")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("best_effort_time_taken")) {
                    zArr[1] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("bitrate")) {
                    zArr[2] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("can_viewer_add_tags")) {
                    zArr[3] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_delete")) {
                    zArr[4] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_edit")) {
                    zArr[5] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_export")) {
                    zArr[6] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_make_cover_photo")) {
                    zArr[7] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("can_viewer_make_profile_picture")) {
                    zArr[8] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("can_viewer_report")) {
                    zArr[9] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("can_viewer_share")) {
                    zArr[10] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("can_viewer_suggest_location")) {
                    zArr[11] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("can_viewer_untag")) {
                    zArr[12] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("captions_url")) {
                    iArr[20] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("container_story")) {
                    iArr[21] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("created_time")) {
                    zArr[13] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("creation_story")) {
                    iArr[23] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("explicit_place")) {
                    iArr[24] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("face_boxes")) {
                    iArr[25] = GraphQLPhotoFaceBoxesConnectionDeserializer.m5611a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[26] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("focus")) {
                    iArr[27] = GraphQLVect2Deserializer.m6165a(jsonParser, flatBufferBuilder);
                } else if (i.equals("guided_tour")) {
                    iArr[28] = GraphQLVideoGuidedTourDeserializer.m6187a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_stickers")) {
                    zArr[14] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("has_viewer_viewed")) {
                    zArr[15] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("has_viewer_watched_video")) {
                    zArr[16] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("hdAtomSize")) {
                    zArr[17] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("hdBitrate")) {
                    zArr[18] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("hd_playable_url")) {
                    iArr[34] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("height")) {
                    zArr[19] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("id")) {
                    iArr[36] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image")) {
                    iArr[37] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHigh")) {
                    iArr[38] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHighOrig")) {
                    iArr[39] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLarge")) {
                    iArr[40] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLargeAspect")) {
                    iArr[41] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLargeSquare")) {
                    iArr[42] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLow")) {
                    iArr[43] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageMedium")) {
                    iArr[44] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imagePreview")) {
                    iArr[45] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageSmallCover")) {
                    iArr[46] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageSmallSquare")) {
                    iArr[47] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageTallCover")) {
                    iArr[48] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageThumbnail")) {
                    iArr[49] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("initial_view_heading_degrees")) {
                    zArr[20] = true;
                    iArr2[5] = jsonParser.E();
                } else if (i.equals("initial_view_pitch_degrees")) {
                    zArr[21] = true;
                    iArr2[6] = jsonParser.E();
                } else if (i.equals("initial_view_roll_degrees")) {
                    zArr[22] = true;
                    iArr2[7] = jsonParser.E();
                } else if (i.equals("inline_activities")) {
                    iArr[53] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_age_restricted")) {
                    zArr[23] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("is_disturbing")) {
                    zArr[24] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("is_live_streaming")) {
                    zArr[25] = true;
                    zArr2[15] = jsonParser.H();
                } else if (i.equals("is_looping")) {
                    zArr[26] = true;
                    zArr2[16] = jsonParser.H();
                } else if (i.equals("is_playable")) {
                    zArr[27] = true;
                    zArr2[17] = jsonParser.H();
                } else if (i.equals("is_save_primary_action")) {
                    zArr[28] = true;
                    zArr2[18] = jsonParser.H();
                } else if (i.equals("is_spherical")) {
                    zArr[29] = true;
                    zArr2[19] = jsonParser.H();
                } else if (i.equals("is_video_broadcast")) {
                    zArr[30] = true;
                    zArr2[20] = jsonParser.H();
                } else if (i.equals("is_viewer_suggested_tagger")) {
                    zArr[31] = true;
                    zArr2[21] = jsonParser.H();
                } else if (i.equals("landscape")) {
                    iArr[63] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("largePortraitImage")) {
                    iArr[64] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("largeThumbnail")) {
                    iArr[65] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("live_viewer_count_read_only")) {
                    zArr[32] = true;
                    iArr2[8] = jsonParser.E();
                } else if (i.equals("location_tag_suggestion")) {
                    iArr[67] = GraphQLPlaceSuggestionInfoDeserializer.m5670a(jsonParser, flatBufferBuilder);
                } else if (i.equals("loop_count")) {
                    zArr[33] = true;
                    iArr2[9] = jsonParser.E();
                } else if (i.equals("lowres")) {
                    iArr[69] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("message")) {
                    iArr[70] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("multiShareHDVideoUrl")) {
                    iArr[71] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("multiShareItemSquareImage")) {
                    iArr[72] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("multiShareVideoUrl")) {
                    iArr[73] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("narrowLandscapeImage")) {
                    iArr[74] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("narrowPortraitImage")) {
                    iArr[75] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("owner")) {
                    iArr[76] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("paired_video")) {
                    iArr[77] = GraphQLVideoDeserializer.m6184a(jsonParser, flatBufferBuilder);
                } else if (i.equals("pending_place")) {
                    iArr[78] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("photo_encodings")) {
                    iArr[79] = GraphQLPhotoEncodingDeserializer.m5609b(jsonParser, flatBufferBuilder);
                } else if (i.equals("play_count")) {
                    zArr[34] = true;
                    iArr2[10] = jsonParser.E();
                } else if (i.equals("playableUrlHdString")) {
                    iArr[81] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playableUrlRtmpString")) {
                    iArr[82] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playable_duration")) {
                    zArr[35] = true;
                    iArr2[11] = jsonParser.E();
                } else if (i.equals("playable_duration_in_ms")) {
                    zArr[36] = true;
                    iArr2[12] = jsonParser.E();
                } else if (i.equals("playable_url")) {
                    iArr[85] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playlist")) {
                    iArr[86] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("portrait")) {
                    iArr[87] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("preferredPlayableUrlString")) {
                    iArr[88] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("privacy_scope")) {
                    iArr[89] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_overlay")) {
                    iArr[90] = GraphQLImageOverlayDeserializer.m5226a(jsonParser, flatBufferBuilder);
                } else if (i.equals("projection_type")) {
                    iArr[91] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("publisher_context")) {
                    iArr[92] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("pulseCoverPhoto")) {
                    iArr[93] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("should_open_single_publisher")) {
                    zArr[37] = true;
                    zArr2[22] = jsonParser.H();
                } else if (i.equals("should_show_live_subscribe")) {
                    zArr[38] = true;
                    zArr2[23] = jsonParser.H();
                } else if (i.equals("should_upsell_as_viewer_profile_picture")) {
                    zArr[39] = true;
                    zArr2[24] = jsonParser.H();
                } else if (i.equals("show_objectionable_warning_in_feed")) {
                    zArr[40] = true;
                    zArr2[25] = jsonParser.H();
                } else if (i.equals("show_video_home_follow_button")) {
                    zArr[41] = true;
                    zArr2[26] = jsonParser.H();
                } else if (i.equals("sphericalFullscreenAspectRatio")) {
                    zArr[42] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("sphericalInlineAspectRatio")) {
                    zArr[43] = true;
                    dArr[1] = jsonParser.G();
                } else if (i.equals("sphericalPlayableUrlHdString")) {
                    iArr[101] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sphericalPlayableUrlSdString")) {
                    iArr[102] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sphericalPreferredFov")) {
                    zArr[44] = true;
                    iArr2[13] = jsonParser.E();
                } else if (i.equals("squareLargeImage")) {
                    iArr[104] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("streaming_image")) {
                    iArr[105] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("streaming_profile_picture")) {
                    iArr[106] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tags")) {
                    iArr[107] = GraphQLPhotoTagsConnectionDeserializer.m5617a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_captions_locales")) {
                    iArr[108] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel")) {
                    iArr[109] = GraphQLVideoChannelDeserializer.m6176a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_full_size")) {
                    zArr[45] = true;
                    iArr2[14] = jsonParser.E();
                } else if (i.equals("width")) {
                    zArr[46] = true;
                    iArr2[15] = jsonParser.E();
                } else if (i.equals("with_tags")) {
                    iArr[112] = GraphQLWithTagsConnectionDeserializer.m6205a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageNatural")) {
                    iArr[113] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("broadcast_status")) {
                    zArr[47] = true;
                    enumArr[0] = GraphQLVideoBroadcastStatus.fromString(jsonParser.o());
                } else if (i.equals("show_video_channel_subscribe_button")) {
                    zArr[48] = true;
                    zArr2[27] = jsonParser.H();
                } else if (i.equals("image_blurred")) {
                    iArr[116] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_status_type")) {
                    zArr[49] = true;
                    enumArr[1] = GraphQLVideoStatusType.fromString(jsonParser.o());
                } else if (i.equals("supports_time_slices")) {
                    zArr[50] = true;
                    zArr2[28] = jsonParser.H();
                } else if (i.equals("sponsor_page")) {
                    iArr[122] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_delegating_delete")) {
                    zArr[51] = true;
                    zArr2[29] = jsonParser.H();
                } else if (i.equals("is_eligible_for_commercial_break")) {
                    zArr[52] = true;
                    zArr2[30] = jsonParser.H();
                } else if (i.equals("post_play_count")) {
                    zArr[53] = true;
                    iArr2[16] = jsonParser.E();
                } else if (i.equals("total_posts")) {
                    zArr[54] = true;
                    iArr2[17] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(127);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[0]) {
            flatBufferBuilder.a(4, iArr2[0], 0);
        }
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[1]) {
            flatBufferBuilder.a(8, jArr[0], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(9, iArr2[1], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(10, zArr2[0]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(11, zArr2[1]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(12, zArr2[2]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(13, zArr2[3]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(14, zArr2[4]);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(15, zArr2[5]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(16, zArr2[6]);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(17, zArr2[7]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(18, zArr2[8]);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(19, zArr2[9]);
        }
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        if (zArr[13]) {
            flatBufferBuilder.a(22, jArr[1], 0);
        }
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        flatBufferBuilder.b(27, iArr[27]);
        flatBufferBuilder.b(28, iArr[28]);
        if (zArr[14]) {
            flatBufferBuilder.a(29, zArr2[10]);
        }
        if (zArr[15]) {
            flatBufferBuilder.a(30, zArr2[11]);
        }
        if (zArr[16]) {
            flatBufferBuilder.a(31, zArr2[12]);
        }
        if (zArr[17]) {
            flatBufferBuilder.a(32, iArr2[2], 0);
        }
        if (zArr[18]) {
            flatBufferBuilder.a(33, iArr2[3], 0);
        }
        flatBufferBuilder.b(34, iArr[34]);
        if (zArr[19]) {
            flatBufferBuilder.a(35, iArr2[4], 0);
        }
        flatBufferBuilder.b(36, iArr[36]);
        flatBufferBuilder.b(37, iArr[37]);
        flatBufferBuilder.b(38, iArr[38]);
        flatBufferBuilder.b(39, iArr[39]);
        flatBufferBuilder.b(40, iArr[40]);
        flatBufferBuilder.b(41, iArr[41]);
        flatBufferBuilder.b(42, iArr[42]);
        flatBufferBuilder.b(43, iArr[43]);
        flatBufferBuilder.b(44, iArr[44]);
        flatBufferBuilder.b(45, iArr[45]);
        flatBufferBuilder.b(46, iArr[46]);
        flatBufferBuilder.b(47, iArr[47]);
        flatBufferBuilder.b(48, iArr[48]);
        flatBufferBuilder.b(49, iArr[49]);
        if (zArr[20]) {
            flatBufferBuilder.a(50, iArr2[5], 0);
        }
        if (zArr[21]) {
            flatBufferBuilder.a(51, iArr2[6], 0);
        }
        if (zArr[22]) {
            flatBufferBuilder.a(52, iArr2[7], 0);
        }
        flatBufferBuilder.b(53, iArr[53]);
        if (zArr[23]) {
            flatBufferBuilder.a(54, zArr2[13]);
        }
        if (zArr[24]) {
            flatBufferBuilder.a(55, zArr2[14]);
        }
        if (zArr[25]) {
            flatBufferBuilder.a(56, zArr2[15]);
        }
        if (zArr[26]) {
            flatBufferBuilder.a(57, zArr2[16]);
        }
        if (zArr[27]) {
            flatBufferBuilder.a(58, zArr2[17]);
        }
        if (zArr[28]) {
            flatBufferBuilder.a(59, zArr2[18]);
        }
        if (zArr[29]) {
            flatBufferBuilder.a(60, zArr2[19]);
        }
        if (zArr[30]) {
            flatBufferBuilder.a(61, zArr2[20]);
        }
        if (zArr[31]) {
            flatBufferBuilder.a(62, zArr2[21]);
        }
        flatBufferBuilder.b(63, iArr[63]);
        flatBufferBuilder.b(64, iArr[64]);
        flatBufferBuilder.b(65, iArr[65]);
        if (zArr[32]) {
            flatBufferBuilder.a(66, iArr2[8], 0);
        }
        flatBufferBuilder.b(67, iArr[67]);
        if (zArr[33]) {
            flatBufferBuilder.a(68, iArr2[9], 0);
        }
        flatBufferBuilder.b(69, iArr[69]);
        flatBufferBuilder.b(70, iArr[70]);
        flatBufferBuilder.b(71, iArr[71]);
        flatBufferBuilder.b(72, iArr[72]);
        flatBufferBuilder.b(73, iArr[73]);
        flatBufferBuilder.b(74, iArr[74]);
        flatBufferBuilder.b(75, iArr[75]);
        flatBufferBuilder.b(76, iArr[76]);
        flatBufferBuilder.b(77, iArr[77]);
        flatBufferBuilder.b(78, iArr[78]);
        flatBufferBuilder.b(79, iArr[79]);
        if (zArr[34]) {
            flatBufferBuilder.a(80, iArr2[10], 0);
        }
        flatBufferBuilder.b(81, iArr[81]);
        flatBufferBuilder.b(82, iArr[82]);
        if (zArr[35]) {
            flatBufferBuilder.a(83, iArr2[11], 0);
        }
        if (zArr[36]) {
            flatBufferBuilder.a(84, iArr2[12], 0);
        }
        flatBufferBuilder.b(85, iArr[85]);
        flatBufferBuilder.b(86, iArr[86]);
        flatBufferBuilder.b(87, iArr[87]);
        flatBufferBuilder.b(88, iArr[88]);
        flatBufferBuilder.b(89, iArr[89]);
        flatBufferBuilder.b(90, iArr[90]);
        flatBufferBuilder.b(91, iArr[91]);
        flatBufferBuilder.b(92, iArr[92]);
        flatBufferBuilder.b(93, iArr[93]);
        if (zArr[37]) {
            flatBufferBuilder.a(94, zArr2[22]);
        }
        if (zArr[38]) {
            flatBufferBuilder.a(95, zArr2[23]);
        }
        if (zArr[39]) {
            flatBufferBuilder.a(96, zArr2[24]);
        }
        if (zArr[40]) {
            flatBufferBuilder.a(97, zArr2[25]);
        }
        if (zArr[41]) {
            flatBufferBuilder.a(98, zArr2[26]);
        }
        if (zArr[42]) {
            flatBufferBuilder.a(99, dArr[0], 0.0d);
        }
        if (zArr[43]) {
            flatBufferBuilder.a(100, dArr[1], 0.0d);
        }
        flatBufferBuilder.b(101, iArr[101]);
        flatBufferBuilder.b(102, iArr[102]);
        if (zArr[44]) {
            flatBufferBuilder.a(103, iArr2[13], 0);
        }
        flatBufferBuilder.b(104, iArr[104]);
        flatBufferBuilder.b(105, iArr[105]);
        flatBufferBuilder.b(106, iArr[106]);
        flatBufferBuilder.b(107, iArr[107]);
        flatBufferBuilder.b(108, iArr[108]);
        flatBufferBuilder.b(109, iArr[109]);
        if (zArr[45]) {
            flatBufferBuilder.a(110, iArr2[14], 0);
        }
        if (zArr[46]) {
            flatBufferBuilder.a(111, iArr2[15], 0);
        }
        flatBufferBuilder.b(112, iArr[112]);
        flatBufferBuilder.b(113, iArr[113]);
        if (zArr[47]) {
            flatBufferBuilder.a(114, enumArr[0]);
        }
        if (zArr[48]) {
            flatBufferBuilder.a(115, zArr2[27]);
        }
        flatBufferBuilder.b(116, iArr[116]);
        if (zArr[49]) {
            flatBufferBuilder.a(117, enumArr[1]);
        }
        if (zArr[50]) {
            flatBufferBuilder.a(118, zArr2[28]);
        }
        flatBufferBuilder.b(122, iArr[122]);
        if (zArr[51]) {
            flatBufferBuilder.a(123, zArr2[29]);
        }
        if (zArr[52]) {
            flatBufferBuilder.a(124, zArr2[30]);
        }
        if (zArr[53]) {
            flatBufferBuilder.a(125, iArr2[16], 0);
        }
        if (zArr[54]) {
            flatBufferBuilder.a(126, iArr2[17], 0);
        }
        return flatBufferBuilder.d();
    }

    public static int m5341b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5338a(jsonParser, flatBufferBuilder)));
            }
        }
        if (arrayList.isEmpty()) {
            return 0;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return flatBufferBuilder.a(iArr, true);
    }

    public static MutableFlatBuffer m5339a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5338a(jsonParser, flatBufferBuilder);
        if (1 != 0) {
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, s, 0);
            flatBufferBuilder.b(1, a);
            a = flatBufferBuilder.d();
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        return mutableFlatBuffer;
    }

    public static void m5340a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m5342b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m5342b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("accessibility_caption");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        int g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("album");
            GraphQLAlbumDeserializer.m4551b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("animated_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 4, 0);
        if (g != 0) {
            jsonGenerator.a("atom_size");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("attribution_app");
            GraphQLApplicationDeserializer.m4581a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("attribution_app_metadata");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        long a = mutableFlatBuffer.a(i, 8, 0);
        if (a != 0) {
            jsonGenerator.a("best_effort_time_taken");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 9, 0);
        if (g != 0) {
            jsonGenerator.a("bitrate");
            jsonGenerator.b(g);
        }
        boolean a2 = mutableFlatBuffer.a(i, 10);
        if (a2) {
            jsonGenerator.a("can_viewer_add_tags");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 11);
        if (a2) {
            jsonGenerator.a("can_viewer_delete");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 12);
        if (a2) {
            jsonGenerator.a("can_viewer_edit");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 13);
        if (a2) {
            jsonGenerator.a("can_viewer_export");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 14);
        if (a2) {
            jsonGenerator.a("can_viewer_make_cover_photo");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 15);
        if (a2) {
            jsonGenerator.a("can_viewer_make_profile_picture");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 16);
        if (a2) {
            jsonGenerator.a("can_viewer_report");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 17);
        if (a2) {
            jsonGenerator.a("can_viewer_share");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 18);
        if (a2) {
            jsonGenerator.a("can_viewer_suggest_location");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 19);
        if (a2) {
            jsonGenerator.a("can_viewer_untag");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 20) != 0) {
            jsonGenerator.a("captions_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 20));
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("container_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 22, 0);
        if (a != 0) {
            jsonGenerator.a("created_time");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("creation_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("explicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("face_boxes");
            GraphQLPhotoFaceBoxesConnectionDeserializer.m5613a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 26);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("focus");
            GraphQLVect2Deserializer.m6167a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 28);
        if (g != 0) {
            jsonGenerator.a("guided_tour");
            GraphQLVideoGuidedTourDeserializer.m6189a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 29);
        if (a2) {
            jsonGenerator.a("has_stickers");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 30);
        if (a2) {
            jsonGenerator.a("has_viewer_viewed");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 31);
        if (a2) {
            jsonGenerator.a("has_viewer_watched_video");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.a(i, 32, 0);
        if (g != 0) {
            jsonGenerator.a("hdAtomSize");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 33, 0);
        if (g != 0) {
            jsonGenerator.a("hdBitrate");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 34) != 0) {
            jsonGenerator.a("hd_playable_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 34));
        }
        g = mutableFlatBuffer.a(i, 35, 0);
        if (g != 0) {
            jsonGenerator.a("height");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 36) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 36));
        }
        g = mutableFlatBuffer.g(i, 37);
        if (g != 0) {
            jsonGenerator.a("image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 38);
        if (g != 0) {
            jsonGenerator.a("imageHigh");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 39);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 40);
        if (g != 0) {
            jsonGenerator.a("imageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 41);
        if (g != 0) {
            jsonGenerator.a("imageLargeAspect");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 42);
        if (g != 0) {
            jsonGenerator.a("imageLargeSquare");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 43);
        if (g != 0) {
            jsonGenerator.a("imageLow");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 44);
        if (g != 0) {
            jsonGenerator.a("imageMedium");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("imagePreview");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 46);
        if (g != 0) {
            jsonGenerator.a("imageSmallCover");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 47);
        if (g != 0) {
            jsonGenerator.a("imageSmallSquare");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 48);
        if (g != 0) {
            jsonGenerator.a("imageTallCover");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 49);
        if (g != 0) {
            jsonGenerator.a("imageThumbnail");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 50, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_heading_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 51, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_pitch_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 52, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_roll_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 53);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 54);
        if (a2) {
            jsonGenerator.a("is_age_restricted");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 55);
        if (a2) {
            jsonGenerator.a("is_disturbing");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 56);
        if (a2) {
            jsonGenerator.a("is_live_streaming");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 57);
        if (a2) {
            jsonGenerator.a("is_looping");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 58);
        if (a2) {
            jsonGenerator.a("is_playable");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 59);
        if (a2) {
            jsonGenerator.a("is_save_primary_action");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 60);
        if (a2) {
            jsonGenerator.a("is_spherical");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 61);
        if (a2) {
            jsonGenerator.a("is_video_broadcast");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 62);
        if (a2) {
            jsonGenerator.a("is_viewer_suggested_tagger");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 63);
        if (g != 0) {
            jsonGenerator.a("landscape");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 64);
        if (g != 0) {
            jsonGenerator.a("largePortraitImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 65);
        if (g != 0) {
            jsonGenerator.a("largeThumbnail");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 66, 0);
        if (g != 0) {
            jsonGenerator.a("live_viewer_count_read_only");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 67);
        if (g != 0) {
            jsonGenerator.a("location_tag_suggestion");
            GraphQLPlaceSuggestionInfoDeserializer.m5672a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 68, 0);
        if (g != 0) {
            jsonGenerator.a("loop_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 69);
        if (g != 0) {
            jsonGenerator.a("lowres");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 70);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 71) != 0) {
            jsonGenerator.a("multiShareHDVideoUrl");
            jsonGenerator.b(mutableFlatBuffer.c(i, 71));
        }
        g = mutableFlatBuffer.g(i, 72);
        if (g != 0) {
            jsonGenerator.a("multiShareItemSquareImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 73) != 0) {
            jsonGenerator.a("multiShareVideoUrl");
            jsonGenerator.b(mutableFlatBuffer.c(i, 73));
        }
        g = mutableFlatBuffer.g(i, 74);
        if (g != 0) {
            jsonGenerator.a("narrowLandscapeImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 75);
        if (g != 0) {
            jsonGenerator.a("narrowPortraitImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 76);
        if (g != 0) {
            jsonGenerator.a("owner");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 77);
        if (g != 0) {
            jsonGenerator.a("paired_video");
            GraphQLVideoDeserializer.m6186a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 78);
        if (g != 0) {
            jsonGenerator.a("pending_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 79);
        if (g != 0) {
            jsonGenerator.a("photo_encodings");
            GraphQLPhotoEncodingDeserializer.m5608a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 80, 0);
        if (g != 0) {
            jsonGenerator.a("play_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 81) != 0) {
            jsonGenerator.a("playableUrlHdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 81));
        }
        if (mutableFlatBuffer.g(i, 82) != 0) {
            jsonGenerator.a("playableUrlRtmpString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 82));
        }
        g = mutableFlatBuffer.a(i, 83, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 84, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration_in_ms");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 85) != 0) {
            jsonGenerator.a("playable_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 85));
        }
        if (mutableFlatBuffer.g(i, 86) != 0) {
            jsonGenerator.a("playlist");
            jsonGenerator.b(mutableFlatBuffer.c(i, 86));
        }
        g = mutableFlatBuffer.g(i, 87);
        if (g != 0) {
            jsonGenerator.a("portrait");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 88) != 0) {
            jsonGenerator.a("preferredPlayableUrlString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 88));
        }
        g = mutableFlatBuffer.g(i, 89);
        if (g != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 90);
        if (g != 0) {
            jsonGenerator.a("profile_picture_overlay");
            GraphQLImageOverlayDeserializer.m5230b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 91) != 0) {
            jsonGenerator.a("projection_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 91));
        }
        g = mutableFlatBuffer.g(i, 92);
        if (g != 0) {
            jsonGenerator.a("publisher_context");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 93);
        if (g != 0) {
            jsonGenerator.a("pulseCoverPhoto");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a2 = mutableFlatBuffer.a(i, 94);
        if (a2) {
            jsonGenerator.a("should_open_single_publisher");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 95);
        if (a2) {
            jsonGenerator.a("should_show_live_subscribe");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 96);
        if (a2) {
            jsonGenerator.a("should_upsell_as_viewer_profile_picture");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 97);
        if (a2) {
            jsonGenerator.a("show_objectionable_warning_in_feed");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 98);
        if (a2) {
            jsonGenerator.a("show_video_home_follow_button");
            jsonGenerator.a(a2);
        }
        double a3 = mutableFlatBuffer.a(i, 99, 0.0d);
        if (a3 != 0.0d) {
            jsonGenerator.a("sphericalFullscreenAspectRatio");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 100, 0.0d);
        if (a3 != 0.0d) {
            jsonGenerator.a("sphericalInlineAspectRatio");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 101) != 0) {
            jsonGenerator.a("sphericalPlayableUrlHdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 101));
        }
        if (mutableFlatBuffer.g(i, 102) != 0) {
            jsonGenerator.a("sphericalPlayableUrlSdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 102));
        }
        g = mutableFlatBuffer.a(i, 103, 0);
        if (g != 0) {
            jsonGenerator.a("sphericalPreferredFov");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 104);
        if (g != 0) {
            jsonGenerator.a("squareLargeImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 105);
        if (g != 0) {
            jsonGenerator.a("streaming_image");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 106);
        if (g != 0) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 107);
        if (g != 0) {
            jsonGenerator.a("tags");
            GraphQLPhotoTagsConnectionDeserializer.m5619a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 108) != 0) {
            jsonGenerator.a("video_captions_locales");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 108), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 109);
        if (g != 0) {
            jsonGenerator.a("video_channel");
            GraphQLVideoChannelDeserializer.m6178a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 110, 0);
        if (g != 0) {
            jsonGenerator.a("video_full_size");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 111, 0);
        if (g != 0) {
            jsonGenerator.a("width");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 112);
        if (g != 0) {
            jsonGenerator.a("with_tags");
            GraphQLWithTagsConnectionDeserializer.m6207a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 113);
        if (g != 0) {
            jsonGenerator.a("imageNatural");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 114, (short) 0) != (short) 0) {
            jsonGenerator.a("broadcast_status");
            jsonGenerator.b(((GraphQLVideoBroadcastStatus) mutableFlatBuffer.a(i, 114, GraphQLVideoBroadcastStatus.class)).name());
        }
        a2 = mutableFlatBuffer.a(i, 115);
        if (a2) {
            jsonGenerator.a("show_video_channel_subscribe_button");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 116);
        if (g != 0) {
            jsonGenerator.a("image_blurred");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 117, (short) 0) != (short) 0) {
            jsonGenerator.a("video_status_type");
            jsonGenerator.b(((GraphQLVideoStatusType) mutableFlatBuffer.a(i, 117, GraphQLVideoStatusType.class)).name());
        }
        a2 = mutableFlatBuffer.a(i, 118);
        if (a2) {
            jsonGenerator.a("supports_time_slices");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 122);
        if (g != 0) {
            jsonGenerator.a("sponsor_page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 123);
        if (a2) {
            jsonGenerator.a("is_delegating_delete");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 124);
        if (a2) {
            jsonGenerator.a("is_eligible_for_commercial_break");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.a(i, 125, 0);
        if (g != 0) {
            jsonGenerator.a("post_play_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 126, 0);
        if (g != 0) {
            jsonGenerator.a("total_posts");
            jsonGenerator.b(g);
        }
        jsonGenerator.g();
    }
}
