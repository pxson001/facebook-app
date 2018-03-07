package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: mobile_spyml */
public class GraphQLStoryAttachmentStyleInfoDeserializer {
    public static int m5958a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[22];
        boolean[] zArr = new boolean[7];
        boolean[] zArr2 = new boolean[3];
        int[] iArr2 = new int[4];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("bounding_box")) {
                    iArr[1] = GraphQLGeoRectangleDeserializer.m4993a(jsonParser, flatBufferBuilder);
                } else if (i.equals("category_name")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("label")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("lat_long_list")) {
                    iArr[4] = GraphQLLocationDeserializer.m5334b(jsonParser, flatBufferBuilder);
                } else if (i.equals("layout_height")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("layout_width")) {
                    zArr[1] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("layout_x")) {
                    zArr[2] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("layout_y")) {
                    zArr[3] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("location")) {
                    iArr[9] = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_open_status_formats")) {
                    iArr[10] = GraphQLPlaceOpenStatusFormatDeserializer.m5658b(jsonParser, flatBufferBuilder);
                } else if (i.equals("time_zone")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("logo")) {
                    iArr[12] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("nearby_locations")) {
                    iArr[13] = GraphQLLocationDeserializer.m5334b(jsonParser, flatBufferBuilder);
                } else if (i.equals("autoplay_on_cell")) {
                    zArr[4] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("autoplay_on_wifi")) {
                    zArr[5] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("game_uri")) {
                    iArr[16] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("instant_game_id")) {
                    iArr[17] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("mobile_game_uri")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("show_objectionable_warning")) {
                    zArr[6] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("splash_uri")) {
                    iArr[20] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("video_uri")) {
                    iArr[21] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(22);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        if (zArr[0]) {
            flatBufferBuilder.a(5, iArr2[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(6, iArr2[1], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(7, iArr2[2], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(8, iArr2[3], 0);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        if (zArr[4]) {
            flatBufferBuilder.a(14, zArr2[0]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(15, zArr2[1]);
        }
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        if (zArr[6]) {
            flatBufferBuilder.a(19, zArr2[2]);
        }
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        return flatBufferBuilder.d();
    }

    public static int m5960b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5958a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m5959a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5958a(jsonParser, flatBufferBuilder);
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

    public static void m5961b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("bounding_box");
            GraphQLGeoRectangleDeserializer.m4995a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("category_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("lat_long_list");
            GraphQLLocationDeserializer.m5333a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 5, 0);
        if (g != 0) {
            jsonGenerator.a("layout_height");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 6, 0);
        if (g != 0) {
            jsonGenerator.a("layout_width");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 7, 0);
        if (g != 0) {
            jsonGenerator.a("layout_x");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 8, 0);
        if (g != 0) {
            jsonGenerator.a("layout_y");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("location");
            GraphQLLocationDeserializer.m5332a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("place_open_status_formats");
            GraphQLPlaceOpenStatusFormatDeserializer.m5657a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("time_zone");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("logo");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("nearby_locations");
            GraphQLLocationDeserializer.m5333a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 14);
        if (a) {
            jsonGenerator.a("autoplay_on_cell");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 15);
        if (a) {
            jsonGenerator.a("autoplay_on_wifi");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 16) != 0) {
            jsonGenerator.a("game_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 16));
        }
        if (mutableFlatBuffer.g(i, 17) != 0) {
            jsonGenerator.a("instant_game_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 17));
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("mobile_game_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        a = mutableFlatBuffer.a(i, 19);
        if (a) {
            jsonGenerator.a("show_objectionable_warning");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 20) != 0) {
            jsonGenerator.a("splash_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 20));
        }
        if (mutableFlatBuffer.g(i, 21) != 0) {
            jsonGenerator.a("video_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 21));
        }
        jsonGenerator.g();
    }
}
