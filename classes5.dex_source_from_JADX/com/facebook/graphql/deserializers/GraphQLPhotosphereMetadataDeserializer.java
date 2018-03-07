package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: nf_fr */
public class GraphQLPhotosphereMetadataDeserializer {
    public static int m5623a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[10];
        int[] iArr = new int[6];
        double[] dArr = new double[4];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("full_pano_height_pixels")) {
                    zArr[0] = true;
                    iArr[0] = jsonParser.E();
                } else if (i.equals("full_pano_width_pixels")) {
                    zArr[1] = true;
                    iArr[1] = jsonParser.E();
                } else if (i.equals("cropped_area_image_height_pixels")) {
                    zArr[2] = true;
                    iArr[2] = jsonParser.E();
                } else if (i.equals("cropped_area_image_width_pixels")) {
                    zArr[3] = true;
                    iArr[3] = jsonParser.E();
                } else if (i.equals("initial_view_heading_degrees")) {
                    zArr[4] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("initial_view_pitch_degrees")) {
                    zArr[5] = true;
                    dArr[1] = jsonParser.G();
                } else if (i.equals("initial_view_roll_degrees")) {
                    zArr[6] = true;
                    dArr[2] = jsonParser.G();
                } else if (i.equals("initial_view_vertical_fov_degrees")) {
                    zArr[7] = true;
                    dArr[3] = jsonParser.G();
                } else if (i.equals("cropped_area_left_pixels")) {
                    zArr[8] = true;
                    iArr[4] = jsonParser.E();
                } else if (i.equals("cropped_area_top_pixels")) {
                    zArr[9] = true;
                    iArr[5] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(10);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, iArr[1], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(2, iArr[2], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(3, iArr[3], 0);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(4, dArr[0], 0.0d);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(5, dArr[1], 0.0d);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(6, dArr[2], 0.0d);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(7, dArr[3], 0.0d);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(8, iArr[4], 0);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(9, iArr[5], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5624a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5623a(jsonParser, flatBufferBuilder);
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

    public static void m5625a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("full_pano_height_pixels");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 1, 0);
        if (a != 0) {
            jsonGenerator.a("full_pano_width_pixels");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 2, 0);
        if (a != 0) {
            jsonGenerator.a("cropped_area_image_height_pixels");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 3, 0);
        if (a != 0) {
            jsonGenerator.a("cropped_area_image_width_pixels");
            jsonGenerator.b(a);
        }
        double a2 = mutableFlatBuffer.a(i, 4, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("initial_view_heading_degrees");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 5, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("initial_view_pitch_degrees");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 6, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("initial_view_roll_degrees");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 7, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("initial_view_vertical_fov_degrees");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.a(i, 8, 0);
        if (a != 0) {
            jsonGenerator.a("cropped_area_left_pixels");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 9, 0);
        if (a != 0) {
            jsonGenerator.a("cropped_area_top_pixels");
            jsonGenerator.b(a);
        }
        jsonGenerator.g();
    }
}
