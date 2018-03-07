package com.facebook.privacy.checkup.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionsContentEdgeDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultVect2FieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLParsers.ImageOverlayFieldsParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataAttributionAppParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataInlineActivitiesParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataOwnerParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataWithoutFeedbackParser.AlbumParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataWithoutFeedbackParser.ExplicitPlaceParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataWithoutFeedbackParser.PendingPlaceParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataWithoutFeedbackParser.WithTagsParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.PhotosFaceBoxesQueryParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.SimpleMediaFeedbackParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.TagInfoQueryParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaPageInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: page/{#%s}/contactinbox */
public class FetchPhotoCheckupParsers {

    /* compiled from: page/{#%s}/contactinbox */
    public final class FetchProfilePhotoCheckupMediaOnlyQueryParser {
        public static MutableFlatBuffer m5500a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("photo_checkup_info")) {
                        iArr[0] = PhotoCheckupPOPMediaParser.m5514a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: page/{#%s}/contactinbox */
    public final class FetchProfilePhotoCheckupQueryParser {

        /* compiled from: page/{#%s}/contactinbox */
        public final class PhotoCheckupInfoParser {
            public static int m5501a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("checkup_cover")) {
                            iArr[0] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("header_image")) {
                            iArr[1] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photos")) {
                            iArr[2] = PhotosParser.m5512a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m5502a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("checkup_cover");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("header_image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("photos");
                    PhotosParser.m5513a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m5503a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("photo_checkup_info")) {
                        iArr[0] = PhotoCheckupInfoParser.m5501a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: page/{#%s}/contactinbox */
    public final class MediaCreatorPrivacyScopeParser {

        /* compiled from: page/{#%s}/contactinbox */
        public final class IconImageParser {
            public static int m5504a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("uri")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m5505a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: page/{#%s}/contactinbox */
        public final class PrivacyOptionsParser {
            public static int m5506a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            iArr[0] = GraphQLPrivacyOptionsContentEdgeDeserializer.b(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m5507a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    GraphQLPrivacyOptionsContentEdgeDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m5508a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("can_viewer_edit")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("icon_image")) {
                        iArr[1] = IconImageParser.m5504a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("privacy_options")) {
                        iArr[2] = PrivacyOptionsParser.m5506a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            return flatBufferBuilder.d();
        }

        public static void m5509a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("can_viewer_edit");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("icon_image");
                IconImageParser.m5505a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("privacy_options");
                PrivacyOptionsParser.m5507a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: page/{#%s}/contactinbox */
    public final class MediaMetadataWithCreatorPrivacyOptionsParser {
        public static int m5510b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[41];
            boolean[] zArr = new boolean[14];
            boolean[] zArr2 = new boolean[12];
            int[] iArr2 = new int[1];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("album")) {
                        iArr[1] = AlbumParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attribution_app")) {
                        iArr[2] = MediaMetadataAttributionAppParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attribution_app_metadata")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("can_viewer_add_tags")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_delete")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("can_viewer_edit")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("can_viewer_export")) {
                        zArr[3] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("can_viewer_make_cover_photo")) {
                        zArr[4] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("can_viewer_make_profile_picture")) {
                        zArr[5] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("can_viewer_report")) {
                        zArr[6] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("can_viewer_share")) {
                        zArr[7] = true;
                        zArr2[7] = jsonParser.H();
                    } else if (i.equals("can_viewer_suggest_location")) {
                        zArr[8] = true;
                        zArr2[8] = jsonParser.H();
                    } else if (i.equals("can_viewer_untag")) {
                        zArr[9] = true;
                        zArr2[9] = jsonParser.H();
                    } else if (i.equals("created_time")) {
                        zArr[10] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("creation_story")) {
                        iArr[15] = MediaMetadataCreationStoryParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("explicit_place")) {
                        iArr[16] = ExplicitPlaceParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("face_boxes")) {
                        iArr[17] = PhotosFaceBoxesQueryParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[18] = SimpleMediaFeedbackParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("focus")) {
                        iArr[19] = DefaultVect2FieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("has_stickers")) {
                        zArr[11] = true;
                        zArr2[10] = jsonParser.H();
                    } else if (i.equals("hd_playable_url")) {
                        iArr[21] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[22] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image")) {
                        iArr[23] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageHigh")) {
                        iArr[24] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageHighOrig")) {
                        iArr[25] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageLow")) {
                        iArr[26] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageMedium")) {
                        iArr[27] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageThumbnail")) {
                        iArr[28] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("inline_activities")) {
                        iArr[29] = MediaMetadataInlineActivitiesParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_playable")) {
                        zArr[12] = true;
                        zArr2[11] = jsonParser.H();
                    } else if (i.equals("largeThumbnail")) {
                        iArr[31] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[32] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("owner")) {
                        iArr[33] = MediaMetadataOwnerParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("pending_place")) {
                        iArr[34] = PendingPlaceParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("playable_duration_in_ms")) {
                        zArr[13] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("playable_url")) {
                        iArr[36] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("privacy_scope")) {
                        iArr[37] = MediaCreatorPrivacyScopeParser.m5508a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_picture_overlay")) {
                        iArr[38] = ImageOverlayFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tags")) {
                        iArr[39] = TagInfoQueryParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("with_tags")) {
                        iArr[40] = WithTagsParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(41);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[0]) {
                flatBufferBuilder.a(4, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(5, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(6, zArr2[2]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(7, zArr2[3]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(8, zArr2[4]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(9, zArr2[5]);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(10, zArr2[6]);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(11, zArr2[7]);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(12, zArr2[8]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(13, zArr2[9]);
            }
            if (zArr[10]) {
                flatBufferBuilder.a(14, jArr[0], 0);
            }
            flatBufferBuilder.b(15, iArr[15]);
            flatBufferBuilder.b(16, iArr[16]);
            flatBufferBuilder.b(17, iArr[17]);
            flatBufferBuilder.b(18, iArr[18]);
            flatBufferBuilder.b(19, iArr[19]);
            if (zArr[11]) {
                flatBufferBuilder.a(20, zArr2[10]);
            }
            flatBufferBuilder.b(21, iArr[21]);
            flatBufferBuilder.b(22, iArr[22]);
            flatBufferBuilder.b(23, iArr[23]);
            flatBufferBuilder.b(24, iArr[24]);
            flatBufferBuilder.b(25, iArr[25]);
            flatBufferBuilder.b(26, iArr[26]);
            flatBufferBuilder.b(27, iArr[27]);
            flatBufferBuilder.b(28, iArr[28]);
            flatBufferBuilder.b(29, iArr[29]);
            if (zArr[12]) {
                flatBufferBuilder.a(30, zArr2[11]);
            }
            flatBufferBuilder.b(31, iArr[31]);
            flatBufferBuilder.b(32, iArr[32]);
            flatBufferBuilder.b(33, iArr[33]);
            flatBufferBuilder.b(34, iArr[34]);
            if (zArr[13]) {
                flatBufferBuilder.a(35, iArr2[0], 0);
            }
            flatBufferBuilder.b(36, iArr[36]);
            flatBufferBuilder.b(37, iArr[37]);
            flatBufferBuilder.b(38, iArr[38]);
            flatBufferBuilder.b(39, iArr[39]);
            flatBufferBuilder.b(40, iArr[40]);
            return flatBufferBuilder.d();
        }

        public static void m5511b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("attribution_app");
                MediaMetadataAttributionAppParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("attribution_app_metadata");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            boolean a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("can_viewer_add_tags");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("can_viewer_delete");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("can_viewer_edit");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 7);
            if (a) {
                jsonGenerator.a("can_viewer_export");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 8);
            if (a) {
                jsonGenerator.a("can_viewer_make_cover_photo");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("can_viewer_make_profile_picture");
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
            a = mutableFlatBuffer.a(i, 12);
            if (a) {
                jsonGenerator.a("can_viewer_suggest_location");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 13);
            if (a) {
                jsonGenerator.a("can_viewer_untag");
                jsonGenerator.a(a);
            }
            long a2 = mutableFlatBuffer.a(i, 14, 0);
            if (a2 != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("creation_story");
                MediaMetadataCreationStoryParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("explicit_place");
                ExplicitPlaceParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("face_boxes");
                PhotosFaceBoxesQueryParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("feedback");
                SimpleMediaFeedbackParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 19);
            if (g != 0) {
                jsonGenerator.a("focus");
                DefaultVect2FieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 20);
            if (a) {
                jsonGenerator.a("has_stickers");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 21) != 0) {
                jsonGenerator.a("hd_playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 21));
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
                jsonGenerator.a("imageHighOrig");
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
                jsonGenerator.a("imageThumbnail");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 29);
            if (g != 0) {
                jsonGenerator.a("inline_activities");
                MediaMetadataInlineActivitiesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 30);
            if (a) {
                jsonGenerator.a("is_playable");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 31);
            if (g != 0) {
                jsonGenerator.a("largeThumbnail");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 32);
            if (g != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 33);
            if (g != 0) {
                jsonGenerator.a("owner");
                MediaMetadataOwnerParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 34);
            if (g != 0) {
                jsonGenerator.a("pending_place");
                PendingPlaceParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 35, 0);
            if (g != 0) {
                jsonGenerator.a("playable_duration_in_ms");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 36) != 0) {
                jsonGenerator.a("playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 36));
            }
            g = mutableFlatBuffer.g(i, 37);
            if (g != 0) {
                jsonGenerator.a("privacy_scope");
                MediaCreatorPrivacyScopeParser.m5509a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 38);
            if (g != 0) {
                jsonGenerator.a("profile_picture_overlay");
                ImageOverlayFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 39);
            if (g != 0) {
                jsonGenerator.a("tags");
                TagInfoQueryParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 40);
            if (g != 0) {
                jsonGenerator.a("with_tags");
                WithTagsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: page/{#%s}/contactinbox */
    public final class PhotoCheckupPOPMediaParser {

        /* compiled from: page/{#%s}/contactinbox */
        public final class PhotosParser {
            public static int m5512a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(MediaMetadataWithCreatorPrivacyOptionsParser.m5510b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr2 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr2, true);
                            }
                            iArr[0] = i2;
                        } else if (i.equals("page_info")) {
                            iArr[1] = MediaPageInfoParser.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m5513a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        MediaMetadataWithCreatorPrivacyOptionsParser.m5511b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("page_info");
                    MediaPageInfoParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m5514a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("photos")) {
                        iArr[0] = PhotosParser.m5512a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m5515a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("photos");
                PhotosParser.m5513a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }
}
