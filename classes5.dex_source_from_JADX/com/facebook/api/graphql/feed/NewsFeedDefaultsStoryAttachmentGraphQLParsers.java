package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.NewsFeedDefaultsStoryActionLinkFieldsParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.AttachmentPropertiesParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.SourceParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.StyleInfosParser;
import com.facebook.api.graphql.attachmenttarget.NewsFeedAttachmentTargetFieldsParsers.StoryAttachmentFieldsWithoutMediaParser.TargetParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.CreationStoryParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.OwnerParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.PairedVideoParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.Photo360FieldsParser.PhotoEncodingsParser;
import com.facebook.api.graphql.feedback.NewsFeedFeedbackGraphQLParsers.NewsFeedDefaultsFeedbackParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.AttributionAppMediaMetadataParser.AttributionAppParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.SphericalMetadataParser.GuidedTourParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.VideoChannelIdForVideoFragmentParser.VideoChannelParser;
import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLParsers.AppStoreApplicationFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultVect2FieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: api_add */
public class NewsFeedDefaultsStoryAttachmentGraphQLParsers {

    /* compiled from: api_add */
    public final class StoryAttachmentFieldsParser {

        /* compiled from: api_add */
        public final class MediaParser {
            public static int m16136a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[72];
                boolean[] zArr = new boolean[38];
                boolean[] zArr2 = new boolean[19];
                int[] iArr2 = new int[16];
                long[] jArr = new long[1];
                double[] dArr = new double[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("accessibility_caption")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("animated_image")) {
                            iArr[2] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("atom_size")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("attribution_app")) {
                            iArr[4] = AttributionAppParser.m16864a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("attribution_app_metadata")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("bitrate")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("broadcast_status")) {
                            iArr[7] = flatBufferBuilder.a(GraphQLVideoBroadcastStatus.fromString(jsonParser.o()));
                        } else if (i.equals("can_viewer_delete")) {
                            zArr[2] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("can_viewer_export")) {
                            zArr[3] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("can_viewer_report")) {
                            zArr[4] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("can_viewer_share")) {
                            zArr[5] = true;
                            zArr2[3] = jsonParser.H();
                        } else if (i.equals("captions_url")) {
                            iArr[12] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("created_time")) {
                            zArr[6] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("creation_story")) {
                            iArr[14] = CreationStoryParser.m16060a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("feedback")) {
                            iArr[15] = NewsFeedDefaultsFeedbackParser.m16377a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("focus")) {
                            iArr[16] = DefaultVect2FieldsParser.m9656a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("guided_tour")) {
                            iArr[17] = GuidedTourParser.m16869a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("has_stickers")) {
                            zArr[7] = true;
                            zArr2[4] = jsonParser.H();
                        } else if (i.equals("hdAtomSize")) {
                            zArr[8] = true;
                            iArr2[2] = jsonParser.E();
                        } else if (i.equals("hdBitrate")) {
                            zArr[9] = true;
                            iArr2[3] = jsonParser.E();
                        } else if (i.equals("height")) {
                            zArr[10] = true;
                            iArr2[4] = jsonParser.E();
                        } else if (i.equals("id")) {
                            iArr[22] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("image")) {
                            iArr[23] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("imageHigh")) {
                            iArr[24] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("imageLargeAspect")) {
                            iArr[25] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("imageLow")) {
                            iArr[26] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("imageMedium")) {
                            iArr[27] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image_blurred")) {
                            iArr[28] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("initial_view_heading_degrees")) {
                            zArr[11] = true;
                            iArr2[5] = jsonParser.E();
                        } else if (i.equals("initial_view_pitch_degrees")) {
                            zArr[12] = true;
                            iArr2[6] = jsonParser.E();
                        } else if (i.equals("initial_view_roll_degrees")) {
                            zArr[13] = true;
                            iArr2[7] = jsonParser.E();
                        } else if (i.equals("is_age_restricted")) {
                            zArr[14] = true;
                            zArr2[5] = jsonParser.H();
                        } else if (i.equals("is_disturbing")) {
                            zArr[15] = true;
                            zArr2[6] = jsonParser.H();
                        } else if (i.equals("is_eligible_for_commercial_break")) {
                            zArr[16] = true;
                            zArr2[7] = jsonParser.H();
                        } else if (i.equals("is_live_streaming")) {
                            zArr[17] = true;
                            zArr2[8] = jsonParser.H();
                        } else if (i.equals("is_looping")) {
                            zArr[18] = true;
                            zArr2[9] = jsonParser.H();
                        } else if (i.equals("is_playable")) {
                            zArr[19] = true;
                            zArr2[10] = jsonParser.H();
                        } else if (i.equals("is_save_primary_action")) {
                            zArr[20] = true;
                            zArr2[11] = jsonParser.H();
                        } else if (i.equals("is_spherical")) {
                            zArr[21] = true;
                            zArr2[12] = jsonParser.H();
                        } else if (i.equals("is_video_broadcast")) {
                            zArr[22] = true;
                            zArr2[13] = jsonParser.H();
                        } else if (i.equals("loop_count")) {
                            zArr[23] = true;
                            iArr2[8] = jsonParser.E();
                        } else if (i.equals("message")) {
                            iArr[42] = DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("owner")) {
                            iArr[43] = OwnerParser.m16062a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("paired_video")) {
                            iArr[44] = PairedVideoParser.m16064a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photo_encodings")) {
                            iArr[45] = PhotoEncodingsParser.m16070a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("play_count")) {
                            zArr[24] = true;
                            iArr2[9] = jsonParser.E();
                        } else if (i.equals("playableUrlHdString")) {
                            iArr[47] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("playableUrlRtmpString")) {
                            iArr[48] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("playable_duration_in_ms")) {
                            zArr[25] = true;
                            iArr2[10] = jsonParser.E();
                        } else if (i.equals("playable_url")) {
                            iArr[50] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("playlist")) {
                            iArr[51] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("post_play_count")) {
                            zArr[26] = true;
                            iArr2[11] = jsonParser.E();
                        } else if (i.equals("preferredPlayableUrlString")) {
                            iArr[53] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("projection_type")) {
                            iArr[54] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("publisher_context")) {
                            iArr[55] = DefaultTextWithEntitiesFieldsParser.m9834a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("should_open_single_publisher")) {
                            zArr[27] = true;
                            zArr2[14] = jsonParser.H();
                        } else if (i.equals("should_show_live_subscribe")) {
                            zArr[28] = true;
                            zArr2[15] = jsonParser.H();
                        } else if (i.equals("show_video_channel_subscribe_button")) {
                            zArr[29] = true;
                            zArr2[16] = jsonParser.H();
                        } else if (i.equals("show_video_home_follow_button")) {
                            zArr[30] = true;
                            zArr2[17] = jsonParser.H();
                        } else if (i.equals("sphericalFullscreenAspectRatio")) {
                            zArr[31] = true;
                            dArr[0] = jsonParser.G();
                        } else if (i.equals("sphericalInlineAspectRatio")) {
                            zArr[32] = true;
                            dArr[1] = jsonParser.G();
                        } else if (i.equals("sphericalPlayableUrlHdString")) {
                            iArr[62] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("sphericalPlayableUrlSdString")) {
                            iArr[63] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("sphericalPreferredFov")) {
                            zArr[33] = true;
                            iArr2[12] = jsonParser.E();
                        } else if (i.equals("supports_time_slices")) {
                            zArr[34] = true;
                            zArr2[18] = jsonParser.H();
                        } else if (i.equals("total_posts")) {
                            zArr[35] = true;
                            iArr2[13] = jsonParser.E();
                        } else if (i.equals("video_captions_locales")) {
                            iArr[67] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_channel")) {
                            iArr[68] = VideoChannelParser.m16873a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_full_size")) {
                            zArr[36] = true;
                            iArr2[14] = jsonParser.E();
                        } else if (i.equals("video_status_type")) {
                            iArr[70] = flatBufferBuilder.a(GraphQLVideoStatusType.fromString(jsonParser.o()));
                        } else if (i.equals("width")) {
                            zArr[37] = true;
                            iArr2[15] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(72);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                if (zArr[0]) {
                    flatBufferBuilder.a(3, iArr2[0], 0);
                }
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                if (zArr[1]) {
                    flatBufferBuilder.a(6, iArr2[1], 0);
                }
                flatBufferBuilder.b(7, iArr[7]);
                if (zArr[2]) {
                    flatBufferBuilder.a(8, zArr2[0]);
                }
                if (zArr[3]) {
                    flatBufferBuilder.a(9, zArr2[1]);
                }
                if (zArr[4]) {
                    flatBufferBuilder.a(10, zArr2[2]);
                }
                if (zArr[5]) {
                    flatBufferBuilder.a(11, zArr2[3]);
                }
                flatBufferBuilder.b(12, iArr[12]);
                if (zArr[6]) {
                    flatBufferBuilder.a(13, jArr[0], 0);
                }
                flatBufferBuilder.b(14, iArr[14]);
                flatBufferBuilder.b(15, iArr[15]);
                flatBufferBuilder.b(16, iArr[16]);
                flatBufferBuilder.b(17, iArr[17]);
                if (zArr[7]) {
                    flatBufferBuilder.a(18, zArr2[4]);
                }
                if (zArr[8]) {
                    flatBufferBuilder.a(19, iArr2[2], 0);
                }
                if (zArr[9]) {
                    flatBufferBuilder.a(20, iArr2[3], 0);
                }
                if (zArr[10]) {
                    flatBufferBuilder.a(21, iArr2[4], 0);
                }
                flatBufferBuilder.b(22, iArr[22]);
                flatBufferBuilder.b(23, iArr[23]);
                flatBufferBuilder.b(24, iArr[24]);
                flatBufferBuilder.b(25, iArr[25]);
                flatBufferBuilder.b(26, iArr[26]);
                flatBufferBuilder.b(27, iArr[27]);
                flatBufferBuilder.b(28, iArr[28]);
                if (zArr[11]) {
                    flatBufferBuilder.a(29, iArr2[5], 0);
                }
                if (zArr[12]) {
                    flatBufferBuilder.a(30, iArr2[6], 0);
                }
                if (zArr[13]) {
                    flatBufferBuilder.a(31, iArr2[7], 0);
                }
                if (zArr[14]) {
                    flatBufferBuilder.a(32, zArr2[5]);
                }
                if (zArr[15]) {
                    flatBufferBuilder.a(33, zArr2[6]);
                }
                if (zArr[16]) {
                    flatBufferBuilder.a(34, zArr2[7]);
                }
                if (zArr[17]) {
                    flatBufferBuilder.a(35, zArr2[8]);
                }
                if (zArr[18]) {
                    flatBufferBuilder.a(36, zArr2[9]);
                }
                if (zArr[19]) {
                    flatBufferBuilder.a(37, zArr2[10]);
                }
                if (zArr[20]) {
                    flatBufferBuilder.a(38, zArr2[11]);
                }
                if (zArr[21]) {
                    flatBufferBuilder.a(39, zArr2[12]);
                }
                if (zArr[22]) {
                    flatBufferBuilder.a(40, zArr2[13]);
                }
                if (zArr[23]) {
                    flatBufferBuilder.a(41, iArr2[8], 0);
                }
                flatBufferBuilder.b(42, iArr[42]);
                flatBufferBuilder.b(43, iArr[43]);
                flatBufferBuilder.b(44, iArr[44]);
                flatBufferBuilder.b(45, iArr[45]);
                if (zArr[24]) {
                    flatBufferBuilder.a(46, iArr2[9], 0);
                }
                flatBufferBuilder.b(47, iArr[47]);
                flatBufferBuilder.b(48, iArr[48]);
                if (zArr[25]) {
                    flatBufferBuilder.a(49, iArr2[10], 0);
                }
                flatBufferBuilder.b(50, iArr[50]);
                flatBufferBuilder.b(51, iArr[51]);
                if (zArr[26]) {
                    flatBufferBuilder.a(52, iArr2[11], 0);
                }
                flatBufferBuilder.b(53, iArr[53]);
                flatBufferBuilder.b(54, iArr[54]);
                flatBufferBuilder.b(55, iArr[55]);
                if (zArr[27]) {
                    flatBufferBuilder.a(56, zArr2[14]);
                }
                if (zArr[28]) {
                    flatBufferBuilder.a(57, zArr2[15]);
                }
                if (zArr[29]) {
                    flatBufferBuilder.a(58, zArr2[16]);
                }
                if (zArr[30]) {
                    flatBufferBuilder.a(59, zArr2[17]);
                }
                if (zArr[31]) {
                    flatBufferBuilder.a(60, dArr[0], 0.0d);
                }
                if (zArr[32]) {
                    flatBufferBuilder.a(61, dArr[1], 0.0d);
                }
                flatBufferBuilder.b(62, iArr[62]);
                flatBufferBuilder.b(63, iArr[63]);
                if (zArr[33]) {
                    flatBufferBuilder.a(64, iArr2[12], 0);
                }
                if (zArr[34]) {
                    flatBufferBuilder.a(65, zArr2[18]);
                }
                if (zArr[35]) {
                    flatBufferBuilder.a(66, iArr2[13], 0);
                }
                flatBufferBuilder.b(67, iArr[67]);
                flatBufferBuilder.b(68, iArr[68]);
                if (zArr[36]) {
                    flatBufferBuilder.a(69, iArr2[14], 0);
                }
                flatBufferBuilder.b(70, iArr[70]);
                if (zArr[37]) {
                    flatBufferBuilder.a(71, iArr2[15], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m16137a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("accessibility_caption");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("animated_image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 3, 0);
                if (g != 0) {
                    jsonGenerator.a("atom_size");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("attribution_app");
                    AttributionAppParser.m16865a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("attribution_app_metadata");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                g = mutableFlatBuffer.a(i, 6, 0);
                if (g != 0) {
                    jsonGenerator.a("bitrate");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 7) != 0) {
                    jsonGenerator.a("broadcast_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 7));
                }
                boolean a = mutableFlatBuffer.a(i, 8);
                if (a) {
                    jsonGenerator.a("can_viewer_delete");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 9);
                if (a) {
                    jsonGenerator.a("can_viewer_export");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 10);
                if (a) {
                    jsonGenerator.a("can_viewer_report");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 11);
                if (a) {
                    jsonGenerator.a("can_viewer_share");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 12) != 0) {
                    jsonGenerator.a("captions_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                }
                long a2 = mutableFlatBuffer.a(i, 13, 0);
                if (a2 != 0) {
                    jsonGenerator.a("created_time");
                    jsonGenerator.a(a2);
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("creation_story");
                    CreationStoryParser.m16061a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    NewsFeedDefaultsFeedbackParser.m16378a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 16);
                if (g != 0) {
                    jsonGenerator.a("focus");
                    DefaultVect2FieldsParser.m9657a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("guided_tour");
                    GuidedTourParser.m16870a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.a(i, 18);
                if (a) {
                    jsonGenerator.a("has_stickers");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.a(i, 19, 0);
                if (g != 0) {
                    jsonGenerator.a("hdAtomSize");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 20, 0);
                if (g != 0) {
                    jsonGenerator.a("hdBitrate");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 21, 0);
                if (g != 0) {
                    jsonGenerator.a("height");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 22) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 22));
                }
                g = mutableFlatBuffer.g(i, 23);
                if (g != 0) {
                    jsonGenerator.a("image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 24);
                if (g != 0) {
                    jsonGenerator.a("imageHigh");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 25);
                if (g != 0) {
                    jsonGenerator.a("imageLargeAspect");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 26);
                if (g != 0) {
                    jsonGenerator.a("imageLow");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 27);
                if (g != 0) {
                    jsonGenerator.a("imageMedium");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 28);
                if (g != 0) {
                    jsonGenerator.a("image_blurred");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 29, 0);
                if (g != 0) {
                    jsonGenerator.a("initial_view_heading_degrees");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 30, 0);
                if (g != 0) {
                    jsonGenerator.a("initial_view_pitch_degrees");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 31, 0);
                if (g != 0) {
                    jsonGenerator.a("initial_view_roll_degrees");
                    jsonGenerator.b(g);
                }
                a = mutableFlatBuffer.a(i, 32);
                if (a) {
                    jsonGenerator.a("is_age_restricted");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 33);
                if (a) {
                    jsonGenerator.a("is_disturbing");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 34);
                if (a) {
                    jsonGenerator.a("is_eligible_for_commercial_break");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 35);
                if (a) {
                    jsonGenerator.a("is_live_streaming");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 36);
                if (a) {
                    jsonGenerator.a("is_looping");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 37);
                if (a) {
                    jsonGenerator.a("is_playable");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 38);
                if (a) {
                    jsonGenerator.a("is_save_primary_action");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 39);
                if (a) {
                    jsonGenerator.a("is_spherical");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 40);
                if (a) {
                    jsonGenerator.a("is_video_broadcast");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.a(i, 41, 0);
                if (g != 0) {
                    jsonGenerator.a("loop_count");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 42);
                if (g != 0) {
                    jsonGenerator.a("message");
                    DefaultTextWithEntitiesLongFieldsParser.m9844b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 43);
                if (g != 0) {
                    jsonGenerator.a("owner");
                    OwnerParser.m16063a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 44);
                if (g != 0) {
                    jsonGenerator.a("paired_video");
                    PairedVideoParser.m16065a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 45);
                if (g != 0) {
                    jsonGenerator.a("photo_encodings");
                    PhotoEncodingsParser.m16071a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 46, 0);
                if (g != 0) {
                    jsonGenerator.a("play_count");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 47) != 0) {
                    jsonGenerator.a("playableUrlHdString");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 47));
                }
                if (mutableFlatBuffer.g(i, 48) != 0) {
                    jsonGenerator.a("playableUrlRtmpString");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 48));
                }
                g = mutableFlatBuffer.a(i, 49, 0);
                if (g != 0) {
                    jsonGenerator.a("playable_duration_in_ms");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 50) != 0) {
                    jsonGenerator.a("playable_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 50));
                }
                if (mutableFlatBuffer.g(i, 51) != 0) {
                    jsonGenerator.a("playlist");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 51));
                }
                g = mutableFlatBuffer.a(i, 52, 0);
                if (g != 0) {
                    jsonGenerator.a("post_play_count");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 53) != 0) {
                    jsonGenerator.a("preferredPlayableUrlString");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 53));
                }
                if (mutableFlatBuffer.g(i, 54) != 0) {
                    jsonGenerator.a("projection_type");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 54));
                }
                g = mutableFlatBuffer.g(i, 55);
                if (g != 0) {
                    jsonGenerator.a("publisher_context");
                    DefaultTextWithEntitiesFieldsParser.m9835a(mutableFlatBuffer, g, jsonGenerator);
                }
                a = mutableFlatBuffer.a(i, 56);
                if (a) {
                    jsonGenerator.a("should_open_single_publisher");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 57);
                if (a) {
                    jsonGenerator.a("should_show_live_subscribe");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 58);
                if (a) {
                    jsonGenerator.a("show_video_channel_subscribe_button");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 59);
                if (a) {
                    jsonGenerator.a("show_video_home_follow_button");
                    jsonGenerator.a(a);
                }
                double a3 = mutableFlatBuffer.a(i, 60, 0.0d);
                if (a3 != 0.0d) {
                    jsonGenerator.a("sphericalFullscreenAspectRatio");
                    jsonGenerator.a(a3);
                }
                a3 = mutableFlatBuffer.a(i, 61, 0.0d);
                if (a3 != 0.0d) {
                    jsonGenerator.a("sphericalInlineAspectRatio");
                    jsonGenerator.a(a3);
                }
                if (mutableFlatBuffer.g(i, 62) != 0) {
                    jsonGenerator.a("sphericalPlayableUrlHdString");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 62));
                }
                if (mutableFlatBuffer.g(i, 63) != 0) {
                    jsonGenerator.a("sphericalPlayableUrlSdString");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 63));
                }
                g = mutableFlatBuffer.a(i, 64, 0);
                if (g != 0) {
                    jsonGenerator.a("sphericalPreferredFov");
                    jsonGenerator.b(g);
                }
                a = mutableFlatBuffer.a(i, 65);
                if (a) {
                    jsonGenerator.a("supports_time_slices");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.a(i, 66, 0);
                if (g != 0) {
                    jsonGenerator.a("total_posts");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 67) != 0) {
                    jsonGenerator.a("video_captions_locales");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 67), jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 68);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    VideoChannelParser.m16874a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 69, 0);
                if (g != 0) {
                    jsonGenerator.a("video_full_size");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 70) != 0) {
                    jsonGenerator.a("video_status_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 70));
                }
                g = mutableFlatBuffer.a(i, 71, 0);
                if (g != 0) {
                    jsonGenerator.a("width");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        public static int m16138b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[15];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action_links")) {
                        iArr[0] = NewsFeedDefaultsStoryActionLinkFieldsParser.m15378a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("associated_application")) {
                        iArr[1] = AppStoreApplicationFragmentParser.m3075a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attachment_properties")) {
                        iArr[2] = AttachmentPropertiesParser.m15645a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("deduplication_key")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("description")) {
                        iArr[4] = DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("media")) {
                        iArr[5] = MediaParser.m16136a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("media_reference_token")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("source")) {
                        iArr[7] = SourceParser.m15649a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("style_infos")) {
                        iArr[8] = StyleInfosParser.m15651a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("style_list")) {
                        iArr[9] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subtitle")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("target")) {
                        iArr[11] = TargetParser.m15665a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("tracking")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            return flatBufferBuilder.d();
        }

        public static void m16139b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("action_links");
                NewsFeedDefaultsStoryActionLinkFieldsParser.m15379a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("associated_application");
                AppStoreApplicationFragmentParser.m3076a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("attachment_properties");
                AttachmentPropertiesParser.m15646a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("deduplication_key");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("description");
                DefaultTextWithEntitiesLongFieldsParser.m9844b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("media");
                MediaParser.m16137a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("media_reference_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("source");
                SourceParser.m15650a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("style_infos");
                StyleInfosParser.m15652a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("style_list");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 9), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("subtitle");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("target");
                TargetParser.m15666a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("tracking");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            jsonGenerator.g();
        }
    }
}
