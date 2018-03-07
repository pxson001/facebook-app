package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: no suitable creator method found to deserialize from JSON integer number */
public class GraphQLPhotoDeserializer {
    public static int m5601a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[109];
        boolean[] zArr = new boolean[26];
        boolean[] zArr2 = new boolean[17];
        int[] iArr2 = new int[7];
        long[] jArr = new long[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("accessibility_caption")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("album")) {
                    iArr[1] = GraphQLAlbumDeserializer.m4549a(jsonParser, flatBufferBuilder);
                } else if (i.equals("animated_gif")) {
                    iArr[2] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("animated_image")) {
                    iArr[3] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("atom_size")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("attribution_app")) {
                    iArr[6] = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attribution_app_metadata")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("bitrate")) {
                    zArr[1] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("can_viewer_add_tags")) {
                    zArr[2] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_delete")) {
                    zArr[3] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_edit")) {
                    zArr[4] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_export")) {
                    zArr[5] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_make_cover_photo")) {
                    zArr[6] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("can_viewer_make_profile_picture")) {
                    zArr[7] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("can_viewer_report")) {
                    zArr[8] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("can_viewer_suggest_location")) {
                    zArr[9] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("can_viewer_untag")) {
                    zArr[10] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("container_story")) {
                    iArr[19] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("created_time")) {
                    zArr[11] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("creation_story")) {
                    iArr[21] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("explicit_place")) {
                    iArr[22] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("face_boxes")) {
                    iArr[23] = GraphQLPhotoFaceBoxesConnectionDeserializer.m5611a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[27] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("focus")) {
                    iArr[28] = GraphQLVect2Deserializer.m6165a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_stickers")) {
                    zArr[12] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("hdAtomSize")) {
                    zArr[13] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("hdBitrate")) {
                    zArr[14] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("id")) {
                    iArr[32] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image")) {
                    iArr[33] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("image320")) {
                    iArr[34] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHigh")) {
                    iArr[35] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHighOrig")) {
                    iArr[36] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHighRes")) {
                    iArr[37] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLandscape")) {
                    iArr[38] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLarge")) {
                    iArr[39] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLargeAspect")) {
                    iArr[40] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLargeSquare")) {
                    iArr[41] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLow")) {
                    iArr[42] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLowRes")) {
                    iArr[43] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLowres")) {
                    iArr[44] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageMedium")) {
                    iArr[45] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageMedres")) {
                    iArr[46] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageMidRes")) {
                    iArr[47] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imagePortrait")) {
                    iArr[48] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imagePreview")) {
                    iArr[49] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageSmallCover")) {
                    iArr[50] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageSmallSquare")) {
                    iArr[51] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageTallCover")) {
                    iArr[52] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageThumbnail")) {
                    iArr[53] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("implicit_place")) {
                    iArr[54] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_activities")) {
                    iArr[55] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("intermediate_image")) {
                    iArr[56] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_age_restricted")) {
                    zArr[15] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("is_disturbing")) {
                    zArr[16] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("is_playable")) {
                    zArr[17] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("is_viewer_suggested_tagger")) {
                    zArr[18] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("landscape")) {
                    iArr[62] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("largeImage")) {
                    iArr[63] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("largePortraitImage")) {
                    iArr[64] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("largeThumbnail")) {
                    iArr[65] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("location_tag_suggestion")) {
                    iArr[66] = GraphQLPlaceSuggestionInfoDeserializer.m5670a(jsonParser, flatBufferBuilder);
                } else if (i.equals("lowres")) {
                    iArr[67] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("mediumImage")) {
                    iArr[68] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("message")) {
                    iArr[69] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("modified_time")) {
                    zArr[19] = true;
                    jArr[1] = jsonParser.F();
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
                } else if (i.equals("playableUrlHdString")) {
                    iArr[80] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playableUrlRtmpString")) {
                    iArr[81] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playable_duration")) {
                    zArr[20] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("playable_duration_in_ms")) {
                    zArr[21] = true;
                    iArr2[5] = jsonParser.E();
                } else if (i.equals("playable_url")) {
                    iArr[84] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("portrait")) {
                    iArr[85] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("preferredPlayableUrlString")) {
                    iArr[86] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("preview_payload")) {
                    iArr[87] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("privacy_scope")) {
                    iArr[88] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageLarge")) {
                    iArr[89] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[90] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePhoto")) {
                    iArr[91] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_overlay")) {
                    iArr[92] = GraphQLImageOverlayDeserializer.m5226a(jsonParser, flatBufferBuilder);
                } else if (i.equals("pulseCoverPhoto")) {
                    iArr[93] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("should_upsell_as_viewer_profile_picture")) {
                    zArr[22] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("show_objectionable_warning_in_feed")) {
                    zArr[23] = true;
                    zArr2[15] = jsonParser.H();
                } else if (i.equals("squareLargeImage")) {
                    iArr[96] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tags")) {
                    iArr[97] = GraphQLPhotoTagsConnectionDeserializer.m5617a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[98] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("with_tags")) {
                    iArr[99] = GraphQLWithTagsConnectionDeserializer.m6205a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageNatural")) {
                    iArr[100] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("image_blurred")) {
                    iArr[101] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_delegating_delete")) {
                    zArr[24] = true;
                    zArr2[16] = jsonParser.H();
                } else if (i.equals("video_full_size")) {
                    zArr[25] = true;
                    iArr2[6] = jsonParser.E();
                } else if (i.equals("dominant_color")) {
                    iArr[107] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("open_graph_action")) {
                    iArr[108] = GraphQLOpenGraphActionDeserializer.m5457a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(109);
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
            flatBufferBuilder.a(8, iArr2[1], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(9, zArr2[0]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(10, zArr2[1]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(11, zArr2[2]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(12, zArr2[3]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(13, zArr2[4]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(14, zArr2[5]);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(15, zArr2[6]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(17, zArr2[7]);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(18, zArr2[8]);
        }
        flatBufferBuilder.b(19, iArr[19]);
        if (zArr[11]) {
            flatBufferBuilder.a(20, jArr[0], 0);
        }
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(27, iArr[27]);
        flatBufferBuilder.b(28, iArr[28]);
        if (zArr[12]) {
            flatBufferBuilder.a(29, zArr2[9]);
        }
        if (zArr[13]) {
            flatBufferBuilder.a(30, iArr2[2], 0);
        }
        if (zArr[14]) {
            flatBufferBuilder.a(31, iArr2[3], 0);
        }
        flatBufferBuilder.b(32, iArr[32]);
        flatBufferBuilder.b(33, iArr[33]);
        flatBufferBuilder.b(34, iArr[34]);
        flatBufferBuilder.b(35, iArr[35]);
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
        flatBufferBuilder.b(50, iArr[50]);
        flatBufferBuilder.b(51, iArr[51]);
        flatBufferBuilder.b(52, iArr[52]);
        flatBufferBuilder.b(53, iArr[53]);
        flatBufferBuilder.b(54, iArr[54]);
        flatBufferBuilder.b(55, iArr[55]);
        flatBufferBuilder.b(56, iArr[56]);
        if (zArr[15]) {
            flatBufferBuilder.a(57, zArr2[10]);
        }
        if (zArr[16]) {
            flatBufferBuilder.a(58, zArr2[11]);
        }
        if (zArr[17]) {
            flatBufferBuilder.a(59, zArr2[12]);
        }
        if (zArr[18]) {
            flatBufferBuilder.a(60, zArr2[13]);
        }
        flatBufferBuilder.b(62, iArr[62]);
        flatBufferBuilder.b(63, iArr[63]);
        flatBufferBuilder.b(64, iArr[64]);
        flatBufferBuilder.b(65, iArr[65]);
        flatBufferBuilder.b(66, iArr[66]);
        flatBufferBuilder.b(67, iArr[67]);
        flatBufferBuilder.b(68, iArr[68]);
        flatBufferBuilder.b(69, iArr[69]);
        if (zArr[19]) {
            flatBufferBuilder.a(70, jArr[1], 0);
        }
        flatBufferBuilder.b(71, iArr[71]);
        flatBufferBuilder.b(72, iArr[72]);
        flatBufferBuilder.b(73, iArr[73]);
        flatBufferBuilder.b(74, iArr[74]);
        flatBufferBuilder.b(75, iArr[75]);
        flatBufferBuilder.b(76, iArr[76]);
        flatBufferBuilder.b(77, iArr[77]);
        flatBufferBuilder.b(78, iArr[78]);
        flatBufferBuilder.b(79, iArr[79]);
        flatBufferBuilder.b(80, iArr[80]);
        flatBufferBuilder.b(81, iArr[81]);
        if (zArr[20]) {
            flatBufferBuilder.a(82, iArr2[4], 0);
        }
        if (zArr[21]) {
            flatBufferBuilder.a(83, iArr2[5], 0);
        }
        flatBufferBuilder.b(84, iArr[84]);
        flatBufferBuilder.b(85, iArr[85]);
        flatBufferBuilder.b(86, iArr[86]);
        flatBufferBuilder.b(87, iArr[87]);
        flatBufferBuilder.b(88, iArr[88]);
        flatBufferBuilder.b(89, iArr[89]);
        flatBufferBuilder.b(90, iArr[90]);
        flatBufferBuilder.b(91, iArr[91]);
        flatBufferBuilder.b(92, iArr[92]);
        flatBufferBuilder.b(93, iArr[93]);
        if (zArr[22]) {
            flatBufferBuilder.a(94, zArr2[14]);
        }
        if (zArr[23]) {
            flatBufferBuilder.a(95, zArr2[15]);
        }
        flatBufferBuilder.b(96, iArr[96]);
        flatBufferBuilder.b(97, iArr[97]);
        flatBufferBuilder.b(98, iArr[98]);
        flatBufferBuilder.b(99, iArr[99]);
        flatBufferBuilder.b(100, iArr[100]);
        flatBufferBuilder.b(101, iArr[101]);
        if (zArr[24]) {
            flatBufferBuilder.a(105, zArr2[16]);
        }
        if (zArr[25]) {
            flatBufferBuilder.a(106, iArr2[6], 0);
        }
        flatBufferBuilder.b(107, iArr[107]);
        flatBufferBuilder.b(108, iArr[108]);
        return flatBufferBuilder.d();
    }

    public static int m5604b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5601a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m5602a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5601a(jsonParser, flatBufferBuilder);
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

    public static void m5603a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m5605b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m5605b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("accessibility_caption");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("album");
            GraphQLAlbumDeserializer.m4551b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("animated_gif");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
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
        g = mutableFlatBuffer.a(i, 8, 0);
        if (g != 0) {
            jsonGenerator.a("bitrate");
            jsonGenerator.b(g);
        }
        boolean a = mutableFlatBuffer.a(i, 9);
        if (a) {
            jsonGenerator.a("can_viewer_add_tags");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 10);
        if (a) {
            jsonGenerator.a("can_viewer_delete");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 11);
        if (a) {
            jsonGenerator.a("can_viewer_edit");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 12);
        if (a) {
            jsonGenerator.a("can_viewer_export");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 13);
        if (a) {
            jsonGenerator.a("can_viewer_make_cover_photo");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 14);
        if (a) {
            jsonGenerator.a("can_viewer_make_profile_picture");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 15);
        if (a) {
            jsonGenerator.a("can_viewer_report");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 17);
        if (a) {
            jsonGenerator.a("can_viewer_suggest_location");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 18);
        if (a) {
            jsonGenerator.a("can_viewer_untag");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("container_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        long a2 = mutableFlatBuffer.a(i, 20, 0);
        if (a2 != 0) {
            jsonGenerator.a("created_time");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("creation_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("explicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("face_boxes");
            GraphQLPhotoFaceBoxesConnectionDeserializer.m5613a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 28);
        if (g != 0) {
            jsonGenerator.a("focus");
            GraphQLVect2Deserializer.m6167a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 29);
        if (a) {
            jsonGenerator.a("has_stickers");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 30, 0);
        if (g != 0) {
            jsonGenerator.a("hdAtomSize");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 31, 0);
        if (g != 0) {
            jsonGenerator.a("hdBitrate");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 32) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 32));
        }
        g = mutableFlatBuffer.g(i, 33);
        if (g != 0) {
            jsonGenerator.a("image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 34);
        if (g != 0) {
            jsonGenerator.a("image320");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 35);
        if (g != 0) {
            jsonGenerator.a("imageHigh");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 36);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 37);
        if (g != 0) {
            jsonGenerator.a("imageHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 38);
        if (g != 0) {
            jsonGenerator.a("imageLandscape");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 39);
        if (g != 0) {
            jsonGenerator.a("imageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 40);
        if (g != 0) {
            jsonGenerator.a("imageLargeAspect");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 41);
        if (g != 0) {
            jsonGenerator.a("imageLargeSquare");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 42);
        if (g != 0) {
            jsonGenerator.a("imageLow");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 43);
        if (g != 0) {
            jsonGenerator.a("imageLowRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 44);
        if (g != 0) {
            jsonGenerator.a("imageLowres");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("imageMedium");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 46);
        if (g != 0) {
            jsonGenerator.a("imageMedres");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 47);
        if (g != 0) {
            jsonGenerator.a("imageMidRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 48);
        if (g != 0) {
            jsonGenerator.a("imagePortrait");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 49);
        if (g != 0) {
            jsonGenerator.a("imagePreview");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 50);
        if (g != 0) {
            jsonGenerator.a("imageSmallCover");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 51);
        if (g != 0) {
            jsonGenerator.a("imageSmallSquare");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 52);
        if (g != 0) {
            jsonGenerator.a("imageTallCover");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 53);
        if (g != 0) {
            jsonGenerator.a("imageThumbnail");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 54);
        if (g != 0) {
            jsonGenerator.a("implicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 55);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 56);
        if (g != 0) {
            jsonGenerator.a("intermediate_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 57);
        if (a) {
            jsonGenerator.a("is_age_restricted");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 58);
        if (a) {
            jsonGenerator.a("is_disturbing");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 59);
        if (a) {
            jsonGenerator.a("is_playable");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 60);
        if (a) {
            jsonGenerator.a("is_viewer_suggested_tagger");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 62);
        if (g != 0) {
            jsonGenerator.a("landscape");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 63);
        if (g != 0) {
            jsonGenerator.a("largeImage");
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
        g = mutableFlatBuffer.g(i, 66);
        if (g != 0) {
            jsonGenerator.a("location_tag_suggestion");
            GraphQLPlaceSuggestionInfoDeserializer.m5672a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 67);
        if (g != 0) {
            jsonGenerator.a("lowres");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 68);
        if (g != 0) {
            jsonGenerator.a("mediumImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 69);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 70, 0);
        if (a2 != 0) {
            jsonGenerator.a("modified_time");
            jsonGenerator.a(a2);
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
        if (mutableFlatBuffer.g(i, 80) != 0) {
            jsonGenerator.a("playableUrlHdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 80));
        }
        if (mutableFlatBuffer.g(i, 81) != 0) {
            jsonGenerator.a("playableUrlRtmpString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 81));
        }
        g = mutableFlatBuffer.a(i, 82, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 83, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration_in_ms");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 84) != 0) {
            jsonGenerator.a("playable_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 84));
        }
        g = mutableFlatBuffer.g(i, 85);
        if (g != 0) {
            jsonGenerator.a("portrait");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 86) != 0) {
            jsonGenerator.a("preferredPlayableUrlString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 86));
        }
        if (mutableFlatBuffer.g(i, 87) != 0) {
            jsonGenerator.a("preview_payload");
            jsonGenerator.b(mutableFlatBuffer.c(i, 87));
        }
        g = mutableFlatBuffer.g(i, 88);
        if (g != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 89);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 90);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 91);
        if (g != 0) {
            jsonGenerator.a("profilePhoto");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 92);
        if (g != 0) {
            jsonGenerator.a("profile_picture_overlay");
            GraphQLImageOverlayDeserializer.m5230b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 93);
        if (g != 0) {
            jsonGenerator.a("pulseCoverPhoto");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 94);
        if (a) {
            jsonGenerator.a("should_upsell_as_viewer_profile_picture");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 95);
        if (a) {
            jsonGenerator.a("show_objectionable_warning_in_feed");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 96);
        if (g != 0) {
            jsonGenerator.a("squareLargeImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 97);
        if (g != 0) {
            jsonGenerator.a("tags");
            GraphQLPhotoTagsConnectionDeserializer.m5619a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 98) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 98));
        }
        g = mutableFlatBuffer.g(i, 99);
        if (g != 0) {
            jsonGenerator.a("with_tags");
            GraphQLWithTagsConnectionDeserializer.m6207a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 100);
        if (g != 0) {
            jsonGenerator.a("imageNatural");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 101);
        if (g != 0) {
            jsonGenerator.a("image_blurred");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 105);
        if (a) {
            jsonGenerator.a("is_delegating_delete");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 106, 0);
        if (g != 0) {
            jsonGenerator.a("video_full_size");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 107) != 0) {
            jsonGenerator.a("dominant_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 107));
        }
        g = mutableFlatBuffer.g(i, 108);
        if (g != 0) {
            jsonGenerator.a("open_graph_action");
            GraphQLOpenGraphActionDeserializer.m5461b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
