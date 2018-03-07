package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: pending */
public class GraphQLEntityDeserializer {
    public static int m4763a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[42];
        boolean[] zArr = new boolean[12];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = new int[7];
        double[] dArr = new double[2];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("android_urls")) {
                    iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("app_section")) {
                    iArr[2] = GraphQLTimelineAppSectionDeserializer.m6080a(jsonParser, flatBufferBuilder);
                } else if (i.equals("backing_application")) {
                    iArr[3] = GraphQLAppStoreApplicationDeserializer.m4573a(jsonParser, flatBufferBuilder);
                } else if (i.equals("cache_id")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("event_buy_ticket_display_url")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("event_buy_ticket_url")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("external_url")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("friendship_status")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLFriendshipStatus.fromString(jsonParser.o());
                } else if (i.equals("height")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("id")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image")) {
                    iArr[11] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("initial_view_heading_degrees")) {
                    zArr[2] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("initial_view_pitch_degrees")) {
                    zArr[3] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("initial_view_roll_degrees")) {
                    zArr[4] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("intermediate_image")) {
                    iArr[15] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_spherical")) {
                    zArr[5] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("message")) {
                    iArr[17] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("page")) {
                    iArr[19] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("playable_duration_in_ms")) {
                    zArr[6] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("playable_url")) {
                    iArr[21] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playable_url_hd")) {
                    iArr[22] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playable_url_preferred")) {
                    iArr[23] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playlist")) {
                    iArr[24] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("preview_payload")) {
                    iArr[25] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profilePicture50")) {
                    iArr[26] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[27] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("projection_type")) {
                    iArr[28] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("redirection_info")) {
                    iArr[29] = GraphQLRedirectionInfoDeserializer.m5802b(jsonParser, flatBufferBuilder);
                } else if (i.equals("shareable")) {
                    iArr[30] = m4763a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sphericalFullscreenAspectRatio")) {
                    zArr[7] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("sphericalInlineAspectRatio")) {
                    zArr[8] = true;
                    dArr[1] = jsonParser.G();
                } else if (i.equals("sphericalPlayableUrlHdString")) {
                    iArr[33] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sphericalPlayableUrlSdString")) {
                    iArr[34] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sphericalPreferredFov")) {
                    zArr[9] = true;
                    iArr2[5] = jsonParser.E();
                } else if (i.equals("subscribe_status")) {
                    zArr[10] = true;
                    enumArr[1] = GraphQLSubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("tag")) {
                    iArr[37] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[38] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("video_preview_image")) {
                    iArr[39] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("width")) {
                    zArr[11] = true;
                    iArr2[6] = jsonParser.E();
                } else if (i.equals("sphericalPlaylist")) {
                    iArr[41] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(42);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[0]) {
            flatBufferBuilder.a(8, enumArr[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(9, iArr2[0], 0);
        }
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        if (zArr[2]) {
            flatBufferBuilder.a(12, iArr2[1], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(13, iArr2[2], 0);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(14, iArr2[3], 0);
        }
        flatBufferBuilder.b(15, iArr[15]);
        if (zArr[5]) {
            flatBufferBuilder.a(16, zArr2[0]);
        }
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        if (zArr[6]) {
            flatBufferBuilder.a(20, iArr2[4], 0);
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
        flatBufferBuilder.b(30, iArr[30]);
        if (zArr[7]) {
            flatBufferBuilder.a(31, dArr[0], 0.0d);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(32, dArr[1], 0.0d);
        }
        flatBufferBuilder.b(33, iArr[33]);
        flatBufferBuilder.b(34, iArr[34]);
        if (zArr[9]) {
            flatBufferBuilder.a(35, iArr2[5], 0);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(36, enumArr[1]);
        }
        flatBufferBuilder.b(37, iArr[37]);
        flatBufferBuilder.b(38, iArr[38]);
        flatBufferBuilder.b(39, iArr[39]);
        if (zArr[11]) {
            flatBufferBuilder.a(40, iArr2[6], 0);
        }
        flatBufferBuilder.b(41, iArr[41]);
        return flatBufferBuilder.d();
    }

    public static int m4765b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m4763a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m4764a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4763a(jsonParser, flatBufferBuilder);
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

    public static void m4766b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("android_urls");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 1), jsonGenerator);
        }
        int g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("app_section");
            GraphQLTimelineAppSectionDeserializer.m6082a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("backing_application");
            GraphQLAppStoreApplicationDeserializer.m4575a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("cache_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("event_buy_ticket_display_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("event_buy_ticket_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("external_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.a(i, 8, (short) 0) != (short) 0) {
            jsonGenerator.a("friendship_status");
            jsonGenerator.b(((GraphQLFriendshipStatus) mutableFlatBuffer.a(i, 8, GraphQLFriendshipStatus.class)).name());
        }
        g = mutableFlatBuffer.a(i, 9, 0);
        if (g != 0) {
            jsonGenerator.a("height");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 12, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_heading_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 13, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_pitch_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 14, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_roll_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("intermediate_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        boolean a = mutableFlatBuffer.a(i, 16);
        if (a) {
            jsonGenerator.a("is_spherical");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 20, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration_in_ms");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 21) != 0) {
            jsonGenerator.a("playable_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 21));
        }
        if (mutableFlatBuffer.g(i, 22) != 0) {
            jsonGenerator.a("playable_url_hd");
            jsonGenerator.b(mutableFlatBuffer.c(i, 22));
        }
        if (mutableFlatBuffer.g(i, 23) != 0) {
            jsonGenerator.a("playable_url_preferred");
            jsonGenerator.b(mutableFlatBuffer.c(i, 23));
        }
        if (mutableFlatBuffer.g(i, 24) != 0) {
            jsonGenerator.a("playlist");
            jsonGenerator.b(mutableFlatBuffer.c(i, 24));
        }
        if (mutableFlatBuffer.g(i, 25) != 0) {
            jsonGenerator.a("preview_payload");
            jsonGenerator.b(mutableFlatBuffer.c(i, 25));
        }
        g = mutableFlatBuffer.g(i, 26);
        if (g != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 28) != 0) {
            jsonGenerator.a("projection_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 28));
        }
        g = mutableFlatBuffer.g(i, 29);
        if (g != 0) {
            jsonGenerator.a("redirection_info");
            GraphQLRedirectionInfoDeserializer.m5801a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 30);
        if (g != 0) {
            jsonGenerator.a("shareable");
            m4766b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        double a2 = mutableFlatBuffer.a(i, 31, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("sphericalFullscreenAspectRatio");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 32, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("sphericalInlineAspectRatio");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 33) != 0) {
            jsonGenerator.a("sphericalPlayableUrlHdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 33));
        }
        if (mutableFlatBuffer.g(i, 34) != 0) {
            jsonGenerator.a("sphericalPlayableUrlSdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 34));
        }
        g = mutableFlatBuffer.a(i, 35, 0);
        if (g != 0) {
            jsonGenerator.a("sphericalPreferredFov");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 36, (short) 0) != (short) 0) {
            jsonGenerator.a("subscribe_status");
            jsonGenerator.b(((GraphQLSubscribeStatus) mutableFlatBuffer.a(i, 36, GraphQLSubscribeStatus.class)).name());
        }
        if (mutableFlatBuffer.g(i, 37) != 0) {
            jsonGenerator.a("tag");
            jsonGenerator.b(mutableFlatBuffer.c(i, 37));
        }
        if (mutableFlatBuffer.g(i, 38) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 38));
        }
        g = mutableFlatBuffer.g(i, 39);
        if (g != 0) {
            jsonGenerator.a("video_preview_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 40, 0);
        if (g != 0) {
            jsonGenerator.a("width");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 41) != 0) {
            jsonGenerator.a("sphericalPlaylist");
            jsonGenerator.b(mutableFlatBuffer.c(i, 41));
        }
        jsonGenerator.g();
    }
}
