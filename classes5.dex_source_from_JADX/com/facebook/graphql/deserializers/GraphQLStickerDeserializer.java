package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: model_name */
public class GraphQLStickerDeserializer {
    public static int m5945a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[54];
        boolean[] zArr = new boolean[9];
        boolean[] zArr2 = new boolean[2];
        int[] iArr2 = new int[7];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("animated_gif")) {
                    iArr[0] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("animated_image")) {
                    iArr[1] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("associated_pages")) {
                    iArr[2] = GraphQLProfileDeserializer.m5720b(jsonParser, flatBufferBuilder);
                } else if (i.equals("atom_size")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("bitrate")) {
                    zArr[1] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("hdAtomSize")) {
                    zArr[2] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("hdBitrate")) {
                    zArr[3] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("id")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image")) {
                    iArr[9] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHigh")) {
                    iArr[10] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHighOrig")) {
                    iArr[11] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLarge")) {
                    iArr[12] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLargeAspect")) {
                    iArr[13] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLargeSquare")) {
                    iArr[14] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageLow")) {
                    iArr[15] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageMedium")) {
                    iArr[16] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imagePreview")) {
                    iArr[17] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageSmallCover")) {
                    iArr[18] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageSmallSquare")) {
                    iArr[19] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageTallCover")) {
                    iArr[20] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageThumbnail")) {
                    iArr[21] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_age_restricted")) {
                    zArr[4] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("is_playable")) {
                    zArr[5] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("landscape")) {
                    iArr[24] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("largePortraitImage")) {
                    iArr[25] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("largeThumbnail")) {
                    iArr[26] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("lowres")) {
                    iArr[27] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("multiShareHDVideoUrl")) {
                    iArr[28] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("multiShareItemSquareImage")) {
                    iArr[29] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("multiShareVideoUrl")) {
                    iArr[30] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("narrowLandscapeImage")) {
                    iArr[31] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("narrowPortraitImage")) {
                    iArr[32] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("playableUrlHdString")) {
                    iArr[33] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playableUrlRtmpString")) {
                    iArr[34] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playable_duration")) {
                    zArr[6] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("playable_duration_in_ms")) {
                    zArr[7] = true;
                    iArr2[5] = jsonParser.E();
                } else if (i.equals("playable_url")) {
                    iArr[37] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("portrait")) {
                    iArr[38] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("preferredPlayableUrlString")) {
                    iArr[39] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("preview_image")) {
                    iArr[40] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageLarge")) {
                    iArr[41] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[42] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("pulseCoverPhoto")) {
                    iArr[43] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareLargeImage")) {
                    iArr[44] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sticker_image")) {
                    iArr[45] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("thread_image")) {
                    iArr[46] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[47] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("imageNatural")) {
                    iArr[48] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("image_blurred")) {
                    iArr[49] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_full_size")) {
                    zArr[8] = true;
                    iArr2[6] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(54);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[0]) {
            flatBufferBuilder.a(3, iArr2[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(5, iArr2[1], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(6, iArr2[2], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(7, iArr2[3], 0);
        }
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        if (zArr[4]) {
            flatBufferBuilder.a(22, zArr2[0]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(23, zArr2[1]);
        }
        flatBufferBuilder.b(24, iArr[24]);
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
        if (zArr[6]) {
            flatBufferBuilder.a(35, iArr2[4], 0);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(36, iArr2[5], 0);
        }
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
        if (zArr[8]) {
            flatBufferBuilder.a(53, iArr2[6], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5946a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5945a(jsonParser, flatBufferBuilder);
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

    public static void m5947a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("associated_pages");
            GraphQLProfileDeserializer.m5719a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 3, 0);
        if (g != 0) {
            jsonGenerator.a("atom_size");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 5, 0);
        if (g != 0) {
            jsonGenerator.a("bitrate");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 6, 0);
        if (g != 0) {
            jsonGenerator.a("hdAtomSize");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 7, 0);
        if (g != 0) {
            jsonGenerator.a("hdBitrate");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("imageHigh");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("imageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("imageLargeAspect");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 14);
        if (g != 0) {
            jsonGenerator.a("imageLargeSquare");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("imageLow");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 16);
        if (g != 0) {
            jsonGenerator.a("imageMedium");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("imagePreview");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 18);
        if (g != 0) {
            jsonGenerator.a("imageSmallCover");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("imageSmallSquare");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("imageTallCover");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("imageThumbnail");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        boolean a = mutableFlatBuffer.a(i, 22);
        if (a) {
            jsonGenerator.a("is_age_restricted");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 23);
        if (a) {
            jsonGenerator.a("is_playable");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("landscape");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("largePortraitImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 26);
        if (g != 0) {
            jsonGenerator.a("largeThumbnail");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("lowres");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 28) != 0) {
            jsonGenerator.a("multiShareHDVideoUrl");
            jsonGenerator.b(mutableFlatBuffer.c(i, 28));
        }
        g = mutableFlatBuffer.g(i, 29);
        if (g != 0) {
            jsonGenerator.a("multiShareItemSquareImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 30) != 0) {
            jsonGenerator.a("multiShareVideoUrl");
            jsonGenerator.b(mutableFlatBuffer.c(i, 30));
        }
        g = mutableFlatBuffer.g(i, 31);
        if (g != 0) {
            jsonGenerator.a("narrowLandscapeImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 32);
        if (g != 0) {
            jsonGenerator.a("narrowPortraitImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 33) != 0) {
            jsonGenerator.a("playableUrlHdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 33));
        }
        if (mutableFlatBuffer.g(i, 34) != 0) {
            jsonGenerator.a("playableUrlRtmpString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 34));
        }
        g = mutableFlatBuffer.a(i, 35, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 36, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration_in_ms");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 37) != 0) {
            jsonGenerator.a("playable_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 37));
        }
        g = mutableFlatBuffer.g(i, 38);
        if (g != 0) {
            jsonGenerator.a("portrait");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 39) != 0) {
            jsonGenerator.a("preferredPlayableUrlString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 39));
        }
        g = mutableFlatBuffer.g(i, 40);
        if (g != 0) {
            jsonGenerator.a("preview_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 41);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 42);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 43);
        if (g != 0) {
            jsonGenerator.a("pulseCoverPhoto");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 44);
        if (g != 0) {
            jsonGenerator.a("squareLargeImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("sticker_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 46);
        if (g != 0) {
            jsonGenerator.a("thread_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 47) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 47));
        }
        g = mutableFlatBuffer.g(i, 48);
        if (g != 0) {
            jsonGenerator.a("imageNatural");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 49);
        if (g != 0) {
            jsonGenerator.a("image_blurred");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 53, 0);
        if (g != 0) {
            jsonGenerator.a("video_full_size");
            jsonGenerator.b(g);
        }
        jsonGenerator.g();
    }
}
