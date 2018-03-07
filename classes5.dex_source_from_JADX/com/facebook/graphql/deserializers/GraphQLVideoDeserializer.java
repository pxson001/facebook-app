package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: messenger_content_subscription_option */
public class GraphQLVideoDeserializer {
    public static int m6184a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[141];
        boolean[] zArr = new boolean[49];
        boolean[] zArr2 = new boolean[22];
        int[] iArr2 = new int[20];
        long[] jArr = new long[2];
        double[] dArr = new double[2];
        Enum[] enumArr = new Enum[3];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("animated_gif")) {
                    iArr[0] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("animated_image")) {
                    iArr[1] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("atom_size")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("attribution_app")) {
                    iArr[4] = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attribution_app_metadata")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("best_effort_time_taken")) {
                    zArr[1] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("bitrate")) {
                    zArr[2] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("broadcast_status")) {
                    zArr[3] = true;
                    enumArr[0] = GraphQLVideoBroadcastStatus.fromString(jsonParser.o());
                } else if (i.equals("can_viewer_delete")) {
                    zArr[4] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_report")) {
                    zArr[5] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_share")) {
                    zArr[6] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("captions_url")) {
                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("created_time")) {
                    zArr[7] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("creation_story")) {
                    iArr[14] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("explicit_place")) {
                    iArr[15] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedAwesomizerProfilePicture")) {
                    iArr[16] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[17] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("guided_tour")) {
                    iArr[18] = GraphQLVideoGuidedTourDeserializer.m6187a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_viewer_viewed")) {
                    zArr[8] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("has_viewer_watched_video")) {
                    zArr[9] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("hdAtomSize")) {
                    zArr[10] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("hdBitrate")) {
                    zArr[11] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("hd_playable_url")) {
                    iArr[23] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("height")) {
                    zArr[12] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("id")) {
                    iArr[25] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image")) {
                    iArr[26] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHigh")) {
                    iArr[27] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHighOrig")) {
                    iArr[28] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLarge")) {
                    iArr[29] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLargeAspect")) {
                    iArr[30] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLargeSquare")) {
                    iArr[31] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLow")) {
                    iArr[32] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageMedium")) {
                    iArr[33] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imagePreview")) {
                    iArr[34] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageSmallCover")) {
                    iArr[35] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageSmallSquare")) {
                    iArr[36] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageTallCover")) {
                    iArr[37] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageThumbnail")) {
                    iArr[38] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageVideoThumbnail")) {
                    iArr[39] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("initial_view_heading_degrees")) {
                    zArr[13] = true;
                    iArr2[5] = jsonParser.E();
                } else if (i.equals("initial_view_pitch_degrees")) {
                    zArr[14] = true;
                    iArr2[6] = jsonParser.E();
                } else if (i.equals("initial_view_roll_degrees")) {
                    zArr[15] = true;
                    iArr2[7] = jsonParser.E();
                } else if (i.equals("inline_activities")) {
                    iArr[43] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_age_restricted")) {
                    zArr[16] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("is_disturbing")) {
                    zArr[17] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("is_live_streaming")) {
                    zArr[18] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("is_looping")) {
                    zArr[19] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("is_playable")) {
                    zArr[20] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("is_save_primary_action")) {
                    zArr[21] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("is_spherical")) {
                    zArr[22] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("is_video_broadcast")) {
                    zArr[23] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("landscape")) {
                    iArr[52] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("largePortraitImage")) {
                    iArr[53] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("largeThumbnail")) {
                    iArr[54] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("live_viewer_count")) {
                    zArr[24] = true;
                    iArr2[8] = jsonParser.E();
                } else if (i.equals("live_viewer_count_read_only")) {
                    zArr[25] = true;
                    iArr2[9] = jsonParser.E();
                } else if (i.equals("loop_count")) {
                    zArr[26] = true;
                    iArr2[10] = jsonParser.E();
                } else if (i.equals("lowres")) {
                    iArr[58] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("message")) {
                    iArr[59] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("multiShareHDVideoUrl")) {
                    iArr[60] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("multiShareItemSquareImage")) {
                    iArr[61] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("multiShareVideoUrl")) {
                    iArr[62] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name")) {
                    iArr[63] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("narrowLandscapeImage")) {
                    iArr[64] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("narrowPortraitImage")) {
                    iArr[65] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("owner")) {
                    iArr[66] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("play_count")) {
                    zArr[27] = true;
                    iArr2[11] = jsonParser.E();
                } else if (i.equals("playableUrlHdString")) {
                    iArr[68] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playableUrlRtmpString")) {
                    iArr[69] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playable_duration")) {
                    zArr[28] = true;
                    iArr2[12] = jsonParser.E();
                } else if (i.equals("playable_duration_in_ms")) {
                    zArr[29] = true;
                    iArr2[13] = jsonParser.E();
                } else if (i.equals("playable_url")) {
                    iArr[72] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playable_url_hd")) {
                    iArr[73] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playable_url_preferred")) {
                    iArr[74] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playlist")) {
                    iArr[75] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("portrait")) {
                    iArr[76] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("preferredPlayableUrlString")) {
                    iArr[77] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("processing_progress")) {
                    zArr[30] = true;
                    iArr2[14] = jsonParser.E();
                } else if (i.equals("profileImageLarge")) {
                    iArr[79] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[80] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture50")) {
                    iArr[81] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureHighRes")) {
                    iArr[82] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureLarge")) {
                    iArr[83] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[84] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[85] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[31] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("projection_type")) {
                    iArr[87] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("publisher_context")) {
                    iArr[88] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("pulseCoverPhoto")) {
                    iArr[89] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("rating")) {
                    iArr[90] = GraphQLRatingDeserializer.m5778a(jsonParser, flatBufferBuilder);
                } else if (i.equals("saved_collection")) {
                    iArr[91] = GraphQLTimelineAppCollectionDeserializer.m6066a(jsonParser, flatBufferBuilder);
                } else if (i.equals("should_open_single_publisher")) {
                    zArr[32] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("should_show_live_subscribe")) {
                    zArr[33] = true;
                    zArr2[15] = jsonParser.H();
                } else if (i.equals("show_video_home_follow_button")) {
                    zArr[34] = true;
                    zArr2[16] = jsonParser.H();
                } else if (i.equals("sphericalFullscreenAspectRatio")) {
                    zArr[35] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("sphericalInlineAspectRatio")) {
                    zArr[36] = true;
                    dArr[1] = jsonParser.G();
                } else if (i.equals("sphericalPlayableUrlHdString")) {
                    iArr[98] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sphericalPlayableUrlSdString")) {
                    iArr[99] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sphericalPreferredFov")) {
                    zArr[37] = true;
                    iArr2[15] = jsonParser.E();
                } else if (i.equals("squareLargeImage")) {
                    iArr[101] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("streaming_image")) {
                    iArr[102] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("streaming_profile_picture")) {
                    iArr[103] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("taggable_object_profile_picture")) {
                    iArr[104] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("title")) {
                    iArr[105] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("titleForSummary")) {
                    iArr[106] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[107] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("videoThumbnail")) {
                    iArr[108] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_captions_locales")) {
                    iArr[109] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel")) {
                    iArr[110] = GraphQLVideoChannelDeserializer.m6176a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_full_size")) {
                    zArr[38] = true;
                    iArr2[16] = jsonParser.E();
                } else if (i.equals("video_preview_image")) {
                    iArr[112] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_status_type")) {
                    zArr[39] = true;
                    enumArr[1] = GraphQLVideoStatusType.fromString(jsonParser.o());
                } else if (i.equals("viewer_saved_state")) {
                    zArr[40] = true;
                    enumArr[2] = GraphQLSavedState.fromString(jsonParser.o());
                } else if (i.equals("viewer_timeline_collections_containing")) {
                    iArr[115] = GraphQLTimelineAppCollectionDeserializer.m6069b(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_timeline_collections_supported")) {
                    iArr[116] = GraphQLTimelineAppCollectionDeserializer.m6069b(jsonParser, flatBufferBuilder);
                } else if (i.equals("width")) {
                    zArr[41] = true;
                    iArr2[17] = jsonParser.E();
                } else if (i.equals("imageNatural")) {
                    iArr[118] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("copyrights_violation_dialog_state")) {
                    iArr[119] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("copyrights_violation_ui_notification_texts")) {
                    iArr[120] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_cast_video")) {
                    zArr[42] = true;
                    zArr2[17] = jsonParser.H();
                } else if (i.equals("video_cast_payload")) {
                    iArr[122] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("moments_of_interest")) {
                    iArr[123] = DeserializerHelpers.b(jsonParser, flatBufferBuilder);
                } else if (i.equals("playableUrlHD")) {
                    iArr[124] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("show_video_channel_subscribe_button")) {
                    zArr[43] = true;
                    zArr2[18] = jsonParser.H();
                } else if (i.equals("image_blurred")) {
                    iArr[126] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("supports_time_slices")) {
                    zArr[44] = true;
                    zArr2[19] = jsonParser.H();
                } else if (i.equals("sponsor_page")) {
                    iArr[131] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("default_quality")) {
                    iArr[132] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("hd_playable_uri")) {
                    iArr[133] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_eligible_for_commercial_break")) {
                    zArr[45] = true;
                    zArr2[20] = jsonParser.H();
                } else if (i.equals("sphericalPlaylist")) {
                    iArr[135] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("post_play_count")) {
                    zArr[46] = true;
                    iArr2[18] = jsonParser.E();
                } else if (i.equals("total_posts")) {
                    zArr[47] = true;
                    iArr2[19] = jsonParser.E();
                } else if (i.equals("already_invited_live_viewers")) {
                    iArr[138] = GraphQLUserDeserializer.m6151b(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_expired")) {
                    zArr[48] = true;
                    zArr2[21] = jsonParser.H();
                } else if (i.equals("savable_description")) {
                    iArr[140] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(141);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, iArr2[0], 0);
        }
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[1]) {
            flatBufferBuilder.a(6, jArr[0], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(7, iArr2[1], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(8, enumArr[0]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(9, zArr2[0]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(10, zArr2[1]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(11, zArr2[2]);
        }
        flatBufferBuilder.b(12, iArr[12]);
        if (zArr[7]) {
            flatBufferBuilder.a(13, jArr[1], 0);
        }
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        if (zArr[8]) {
            flatBufferBuilder.a(19, zArr2[3]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(20, zArr2[4]);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(21, iArr2[2], 0);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(22, iArr2[3], 0);
        }
        flatBufferBuilder.b(23, iArr[23]);
        if (zArr[12]) {
            flatBufferBuilder.a(24, iArr2[4], 0);
        }
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        flatBufferBuilder.b(27, iArr[27]);
        flatBufferBuilder.b(28, iArr[28]);
        flatBufferBuilder.b(29, iArr[29]);
        flatBufferBuilder.b(30, iArr[30]);
        flatBufferBuilder.b(31, iArr[31]);
        flatBufferBuilder.b(32, iArr[32]);
        flatBufferBuilder.b(33, iArr[33]);
        flatBufferBuilder.b(34, iArr[34]);
        flatBufferBuilder.b(35, iArr[35]);
        flatBufferBuilder.b(36, iArr[36]);
        flatBufferBuilder.b(37, iArr[37]);
        flatBufferBuilder.b(38, iArr[38]);
        flatBufferBuilder.b(39, iArr[39]);
        if (zArr[13]) {
            flatBufferBuilder.a(40, iArr2[5], 0);
        }
        if (zArr[14]) {
            flatBufferBuilder.a(41, iArr2[6], 0);
        }
        if (zArr[15]) {
            flatBufferBuilder.a(42, iArr2[7], 0);
        }
        flatBufferBuilder.b(43, iArr[43]);
        if (zArr[16]) {
            flatBufferBuilder.a(44, zArr2[5]);
        }
        if (zArr[17]) {
            flatBufferBuilder.a(45, zArr2[6]);
        }
        if (zArr[18]) {
            flatBufferBuilder.a(46, zArr2[7]);
        }
        if (zArr[19]) {
            flatBufferBuilder.a(47, zArr2[8]);
        }
        if (zArr[20]) {
            flatBufferBuilder.a(48, zArr2[9]);
        }
        if (zArr[21]) {
            flatBufferBuilder.a(49, zArr2[10]);
        }
        if (zArr[22]) {
            flatBufferBuilder.a(50, zArr2[11]);
        }
        if (zArr[23]) {
            flatBufferBuilder.a(51, zArr2[12]);
        }
        flatBufferBuilder.b(52, iArr[52]);
        flatBufferBuilder.b(53, iArr[53]);
        flatBufferBuilder.b(54, iArr[54]);
        if (zArr[24]) {
            flatBufferBuilder.a(55, iArr2[8], 0);
        }
        if (zArr[25]) {
            flatBufferBuilder.a(56, iArr2[9], 0);
        }
        if (zArr[26]) {
            flatBufferBuilder.a(57, iArr2[10], 0);
        }
        flatBufferBuilder.b(58, iArr[58]);
        flatBufferBuilder.b(59, iArr[59]);
        flatBufferBuilder.b(60, iArr[60]);
        flatBufferBuilder.b(61, iArr[61]);
        flatBufferBuilder.b(62, iArr[62]);
        flatBufferBuilder.b(63, iArr[63]);
        flatBufferBuilder.b(64, iArr[64]);
        flatBufferBuilder.b(65, iArr[65]);
        flatBufferBuilder.b(66, iArr[66]);
        if (zArr[27]) {
            flatBufferBuilder.a(67, iArr2[11], 0);
        }
        flatBufferBuilder.b(68, iArr[68]);
        flatBufferBuilder.b(69, iArr[69]);
        if (zArr[28]) {
            flatBufferBuilder.a(70, iArr2[12], 0);
        }
        if (zArr[29]) {
            flatBufferBuilder.a(71, iArr2[13], 0);
        }
        flatBufferBuilder.b(72, iArr[72]);
        flatBufferBuilder.b(73, iArr[73]);
        flatBufferBuilder.b(74, iArr[74]);
        flatBufferBuilder.b(75, iArr[75]);
        flatBufferBuilder.b(76, iArr[76]);
        flatBufferBuilder.b(77, iArr[77]);
        if (zArr[30]) {
            flatBufferBuilder.a(78, iArr2[14], 0);
        }
        flatBufferBuilder.b(79, iArr[79]);
        flatBufferBuilder.b(80, iArr[80]);
        flatBufferBuilder.b(81, iArr[81]);
        flatBufferBuilder.b(82, iArr[82]);
        flatBufferBuilder.b(83, iArr[83]);
        flatBufferBuilder.b(84, iArr[84]);
        flatBufferBuilder.b(85, iArr[85]);
        if (zArr[31]) {
            flatBufferBuilder.a(86, zArr2[13]);
        }
        flatBufferBuilder.b(87, iArr[87]);
        flatBufferBuilder.b(88, iArr[88]);
        flatBufferBuilder.b(89, iArr[89]);
        flatBufferBuilder.b(90, iArr[90]);
        flatBufferBuilder.b(91, iArr[91]);
        if (zArr[32]) {
            flatBufferBuilder.a(93, zArr2[14]);
        }
        if (zArr[33]) {
            flatBufferBuilder.a(94, zArr2[15]);
        }
        if (zArr[34]) {
            flatBufferBuilder.a(95, zArr2[16]);
        }
        if (zArr[35]) {
            flatBufferBuilder.a(96, dArr[0], 0.0d);
        }
        if (zArr[36]) {
            flatBufferBuilder.a(97, dArr[1], 0.0d);
        }
        flatBufferBuilder.b(98, iArr[98]);
        flatBufferBuilder.b(99, iArr[99]);
        if (zArr[37]) {
            flatBufferBuilder.a(100, iArr2[15], 0);
        }
        flatBufferBuilder.b(101, iArr[101]);
        flatBufferBuilder.b(102, iArr[102]);
        flatBufferBuilder.b(103, iArr[103]);
        flatBufferBuilder.b(104, iArr[104]);
        flatBufferBuilder.b(105, iArr[105]);
        flatBufferBuilder.b(106, iArr[106]);
        flatBufferBuilder.b(107, iArr[107]);
        flatBufferBuilder.b(108, iArr[108]);
        flatBufferBuilder.b(109, iArr[109]);
        flatBufferBuilder.b(110, iArr[110]);
        if (zArr[38]) {
            flatBufferBuilder.a(111, iArr2[16], 0);
        }
        flatBufferBuilder.b(112, iArr[112]);
        if (zArr[39]) {
            flatBufferBuilder.a(113, enumArr[1]);
        }
        if (zArr[40]) {
            flatBufferBuilder.a(114, enumArr[2]);
        }
        flatBufferBuilder.b(115, iArr[115]);
        flatBufferBuilder.b(116, iArr[116]);
        if (zArr[41]) {
            flatBufferBuilder.a(117, iArr2[17], 0);
        }
        flatBufferBuilder.b(118, iArr[118]);
        flatBufferBuilder.b(119, iArr[119]);
        flatBufferBuilder.b(120, iArr[120]);
        if (zArr[42]) {
            flatBufferBuilder.a(121, zArr2[17]);
        }
        flatBufferBuilder.b(122, iArr[122]);
        flatBufferBuilder.b(123, iArr[123]);
        flatBufferBuilder.b(124, iArr[124]);
        if (zArr[43]) {
            flatBufferBuilder.a(125, zArr2[18]);
        }
        flatBufferBuilder.b(126, iArr[126]);
        if (zArr[44]) {
            flatBufferBuilder.a(127, zArr2[19]);
        }
        flatBufferBuilder.b(131, iArr[131]);
        flatBufferBuilder.b(132, iArr[132]);
        flatBufferBuilder.b(133, iArr[133]);
        if (zArr[45]) {
            flatBufferBuilder.a(134, zArr2[20]);
        }
        flatBufferBuilder.b(135, iArr[135]);
        if (zArr[46]) {
            flatBufferBuilder.a(136, iArr2[18], 0);
        }
        if (zArr[47]) {
            flatBufferBuilder.a(137, iArr2[19], 0);
        }
        flatBufferBuilder.b(138, iArr[138]);
        if (zArr[48]) {
            flatBufferBuilder.a(139, zArr2[21]);
        }
        flatBufferBuilder.b(140, iArr[140]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m6185a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6184a(jsonParser, flatBufferBuilder);
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

    public static void m6186a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("animated_gif");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("animated_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 2, 0);
        if (g != 0) {
            jsonGenerator.a("atom_size");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("attribution_app");
            GraphQLApplicationDeserializer.m4581a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("attribution_app_metadata");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        long a = mutableFlatBuffer.a(i, 6, 0);
        if (a != 0) {
            jsonGenerator.a("best_effort_time_taken");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 7, 0);
        if (g != 0) {
            jsonGenerator.a("bitrate");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 8, (short) 0) != (short) 0) {
            jsonGenerator.a("broadcast_status");
            jsonGenerator.b(((GraphQLVideoBroadcastStatus) mutableFlatBuffer.a(i, 8, GraphQLVideoBroadcastStatus.class)).name());
        }
        boolean a2 = mutableFlatBuffer.a(i, 9);
        if (a2) {
            jsonGenerator.a("can_viewer_delete");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 10);
        if (a2) {
            jsonGenerator.a("can_viewer_report");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 11);
        if (a2) {
            jsonGenerator.a("can_viewer_share");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("captions_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        a = mutableFlatBuffer.a(i, 13, 0);
        if (a != 0) {
            jsonGenerator.a("created_time");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 14);
        if (g != 0) {
            jsonGenerator.a("creation_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("explicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 16);
        if (g != 0) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 18);
        if (g != 0) {
            jsonGenerator.a("guided_tour");
            GraphQLVideoGuidedTourDeserializer.m6189a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 19);
        if (a2) {
            jsonGenerator.a("has_viewer_viewed");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 20);
        if (a2) {
            jsonGenerator.a("has_viewer_watched_video");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.a(i, 21, 0);
        if (g != 0) {
            jsonGenerator.a("hdAtomSize");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 22, 0);
        if (g != 0) {
            jsonGenerator.a("hdBitrate");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 23) != 0) {
            jsonGenerator.a("hd_playable_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 23));
        }
        g = mutableFlatBuffer.a(i, 24, 0);
        if (g != 0) {
            jsonGenerator.a("height");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 25) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 25));
        }
        g = mutableFlatBuffer.g(i, 26);
        if (g != 0) {
            jsonGenerator.a("image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("imageHigh");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 28);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 29);
        if (g != 0) {
            jsonGenerator.a("imageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 30);
        if (g != 0) {
            jsonGenerator.a("imageLargeAspect");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 31);
        if (g != 0) {
            jsonGenerator.a("imageLargeSquare");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 32);
        if (g != 0) {
            jsonGenerator.a("imageLow");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 33);
        if (g != 0) {
            jsonGenerator.a("imageMedium");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 34);
        if (g != 0) {
            jsonGenerator.a("imagePreview");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 35);
        if (g != 0) {
            jsonGenerator.a("imageSmallCover");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 36);
        if (g != 0) {
            jsonGenerator.a("imageSmallSquare");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 37);
        if (g != 0) {
            jsonGenerator.a("imageTallCover");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 38);
        if (g != 0) {
            jsonGenerator.a("imageThumbnail");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 39);
        if (g != 0) {
            jsonGenerator.a("imageVideoThumbnail");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 40, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_heading_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 41, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_pitch_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 42, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_roll_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 43);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 44);
        if (a2) {
            jsonGenerator.a("is_age_restricted");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 45);
        if (a2) {
            jsonGenerator.a("is_disturbing");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 46);
        if (a2) {
            jsonGenerator.a("is_live_streaming");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 47);
        if (a2) {
            jsonGenerator.a("is_looping");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 48);
        if (a2) {
            jsonGenerator.a("is_playable");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 49);
        if (a2) {
            jsonGenerator.a("is_save_primary_action");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 50);
        if (a2) {
            jsonGenerator.a("is_spherical");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 51);
        if (a2) {
            jsonGenerator.a("is_video_broadcast");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 52);
        if (g != 0) {
            jsonGenerator.a("landscape");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 53);
        if (g != 0) {
            jsonGenerator.a("largePortraitImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 54);
        if (g != 0) {
            jsonGenerator.a("largeThumbnail");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 55, 0);
        if (g != 0) {
            jsonGenerator.a("live_viewer_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 56, 0);
        if (g != 0) {
            jsonGenerator.a("live_viewer_count_read_only");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 57, 0);
        if (g != 0) {
            jsonGenerator.a("loop_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 58);
        if (g != 0) {
            jsonGenerator.a("lowres");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 59);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 60) != 0) {
            jsonGenerator.a("multiShareHDVideoUrl");
            jsonGenerator.b(mutableFlatBuffer.c(i, 60));
        }
        g = mutableFlatBuffer.g(i, 61);
        if (g != 0) {
            jsonGenerator.a("multiShareItemSquareImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 62) != 0) {
            jsonGenerator.a("multiShareVideoUrl");
            jsonGenerator.b(mutableFlatBuffer.c(i, 62));
        }
        if (mutableFlatBuffer.g(i, 63) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 63));
        }
        g = mutableFlatBuffer.g(i, 64);
        if (g != 0) {
            jsonGenerator.a("narrowLandscapeImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 65);
        if (g != 0) {
            jsonGenerator.a("narrowPortraitImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 66);
        if (g != 0) {
            jsonGenerator.a("owner");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 67, 0);
        if (g != 0) {
            jsonGenerator.a("play_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 68) != 0) {
            jsonGenerator.a("playableUrlHdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 68));
        }
        if (mutableFlatBuffer.g(i, 69) != 0) {
            jsonGenerator.a("playableUrlRtmpString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 69));
        }
        g = mutableFlatBuffer.a(i, 70, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 71, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration_in_ms");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 72) != 0) {
            jsonGenerator.a("playable_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 72));
        }
        if (mutableFlatBuffer.g(i, 73) != 0) {
            jsonGenerator.a("playable_url_hd");
            jsonGenerator.b(mutableFlatBuffer.c(i, 73));
        }
        if (mutableFlatBuffer.g(i, 74) != 0) {
            jsonGenerator.a("playable_url_preferred");
            jsonGenerator.b(mutableFlatBuffer.c(i, 74));
        }
        if (mutableFlatBuffer.g(i, 75) != 0) {
            jsonGenerator.a("playlist");
            jsonGenerator.b(mutableFlatBuffer.c(i, 75));
        }
        g = mutableFlatBuffer.g(i, 76);
        if (g != 0) {
            jsonGenerator.a("portrait");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 77) != 0) {
            jsonGenerator.a("preferredPlayableUrlString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 77));
        }
        g = mutableFlatBuffer.a(i, 78, 0);
        if (g != 0) {
            jsonGenerator.a("processing_progress");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 79);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 80);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 81);
        if (g != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 82);
        if (g != 0) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 83);
        if (g != 0) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 84);
        if (g != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 85);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a2 = mutableFlatBuffer.a(i, 86);
        if (a2) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 87) != 0) {
            jsonGenerator.a("projection_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 87));
        }
        g = mutableFlatBuffer.g(i, 88);
        if (g != 0) {
            jsonGenerator.a("publisher_context");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 89);
        if (g != 0) {
            jsonGenerator.a("pulseCoverPhoto");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 90);
        if (g != 0) {
            jsonGenerator.a("rating");
            GraphQLRatingDeserializer.m5780a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 91);
        if (g != 0) {
            jsonGenerator.a("saved_collection");
            GraphQLTimelineAppCollectionDeserializer.m6070b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 93);
        if (a2) {
            jsonGenerator.a("should_open_single_publisher");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 94);
        if (a2) {
            jsonGenerator.a("should_show_live_subscribe");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 95);
        if (a2) {
            jsonGenerator.a("show_video_home_follow_button");
            jsonGenerator.a(a2);
        }
        double a3 = mutableFlatBuffer.a(i, 96, 0.0d);
        if (a3 != 0.0d) {
            jsonGenerator.a("sphericalFullscreenAspectRatio");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 97, 0.0d);
        if (a3 != 0.0d) {
            jsonGenerator.a("sphericalInlineAspectRatio");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 98) != 0) {
            jsonGenerator.a("sphericalPlayableUrlHdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 98));
        }
        if (mutableFlatBuffer.g(i, 99) != 0) {
            jsonGenerator.a("sphericalPlayableUrlSdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 99));
        }
        g = mutableFlatBuffer.a(i, 100, 0);
        if (g != 0) {
            jsonGenerator.a("sphericalPreferredFov");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 101);
        if (g != 0) {
            jsonGenerator.a("squareLargeImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 102);
        if (g != 0) {
            jsonGenerator.a("streaming_image");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 103);
        if (g != 0) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 104);
        if (g != 0) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 105);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 106);
        if (g != 0) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 107) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 107));
        }
        g = mutableFlatBuffer.g(i, 108);
        if (g != 0) {
            jsonGenerator.a("videoThumbnail");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 109) != 0) {
            jsonGenerator.a("video_captions_locales");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 109), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 110);
        if (g != 0) {
            jsonGenerator.a("video_channel");
            GraphQLVideoChannelDeserializer.m6178a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 111, 0);
        if (g != 0) {
            jsonGenerator.a("video_full_size");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 112);
        if (g != 0) {
            jsonGenerator.a("video_preview_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 113, (short) 0) != (short) 0) {
            jsonGenerator.a("video_status_type");
            jsonGenerator.b(((GraphQLVideoStatusType) mutableFlatBuffer.a(i, 113, GraphQLVideoStatusType.class)).name());
        }
        if (mutableFlatBuffer.a(i, 114, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_saved_state");
            jsonGenerator.b(((GraphQLSavedState) mutableFlatBuffer.a(i, 114, GraphQLSavedState.class)).name());
        }
        g = mutableFlatBuffer.g(i, 115);
        if (g != 0) {
            jsonGenerator.a("viewer_timeline_collections_containing");
            GraphQLTimelineAppCollectionDeserializer.m6068a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 116);
        if (g != 0) {
            jsonGenerator.a("viewer_timeline_collections_supported");
            GraphQLTimelineAppCollectionDeserializer.m6068a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 117, 0);
        if (g != 0) {
            jsonGenerator.a("width");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 118);
        if (g != 0) {
            jsonGenerator.a("imageNatural");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 119) != 0) {
            jsonGenerator.a("copyrights_violation_dialog_state");
            jsonGenerator.b(mutableFlatBuffer.c(i, 119));
        }
        if (mutableFlatBuffer.g(i, 120) != 0) {
            jsonGenerator.a("copyrights_violation_ui_notification_texts");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 120), jsonGenerator);
        }
        a2 = mutableFlatBuffer.a(i, 121);
        if (a2) {
            jsonGenerator.a("can_cast_video");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 122) != 0) {
            jsonGenerator.a("video_cast_payload");
            jsonGenerator.b(mutableFlatBuffer.c(i, 122));
        }
        if (mutableFlatBuffer.g(i, 123) != 0) {
            jsonGenerator.a("moments_of_interest");
            SerializerHelpers.b(mutableFlatBuffer.d(i, 123), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 124) != 0) {
            jsonGenerator.a("playableUrlHD");
            jsonGenerator.b(mutableFlatBuffer.c(i, 124));
        }
        a2 = mutableFlatBuffer.a(i, 125);
        if (a2) {
            jsonGenerator.a("show_video_channel_subscribe_button");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 126);
        if (g != 0) {
            jsonGenerator.a("image_blurred");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a2 = mutableFlatBuffer.a(i, 127);
        if (a2) {
            jsonGenerator.a("supports_time_slices");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 131);
        if (g != 0) {
            jsonGenerator.a("sponsor_page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 132) != 0) {
            jsonGenerator.a("default_quality");
            jsonGenerator.b(mutableFlatBuffer.c(i, 132));
        }
        if (mutableFlatBuffer.g(i, 133) != 0) {
            jsonGenerator.a("hd_playable_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 133));
        }
        a2 = mutableFlatBuffer.a(i, 134);
        if (a2) {
            jsonGenerator.a("is_eligible_for_commercial_break");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 135) != 0) {
            jsonGenerator.a("sphericalPlaylist");
            jsonGenerator.b(mutableFlatBuffer.c(i, 135));
        }
        g = mutableFlatBuffer.a(i, 136, 0);
        if (g != 0) {
            jsonGenerator.a("post_play_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 137, 0);
        if (g != 0) {
            jsonGenerator.a("total_posts");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 138);
        if (g != 0) {
            jsonGenerator.a("already_invited_live_viewers");
            GraphQLUserDeserializer.m6150a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 139);
        if (a2) {
            jsonGenerator.a("is_expired");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 140);
        if (g != 0) {
            jsonGenerator.a("savable_description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
