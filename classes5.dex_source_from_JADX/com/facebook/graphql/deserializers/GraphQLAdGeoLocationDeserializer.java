package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAdGeoLocationType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: place_recommendation_page */
public class GraphQLAdGeoLocationDeserializer {
    public static int m4525a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[13];
        boolean[] zArr = new boolean[6];
        boolean[] zArr2 = new boolean[2];
        double[] dArr = new double[3];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("address")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("country_code")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("display_name")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("distance_unit")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("key")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("latitude")) {
                    zArr[0] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("location_type")) {
                    zArr[1] = true;
                    enumArr[0] = GraphQLAdGeoLocationType.fromString(jsonParser.o());
                } else if (i.equals("longitude")) {
                    zArr[2] = true;
                    dArr[1] = jsonParser.G();
                } else if (i.equals("name")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("radius")) {
                    zArr[3] = true;
                    dArr[2] = jsonParser.G();
                } else if (i.equals("region_key")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("supports_city")) {
                    zArr[4] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("supports_region")) {
                    zArr[5] = true;
                    zArr2[1] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(13);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        if (zArr[0]) {
            flatBufferBuilder.a(5, dArr[0], 0.0d);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(6, enumArr[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(7, dArr[1], 0.0d);
        }
        flatBufferBuilder.b(8, iArr[8]);
        if (zArr[3]) {
            flatBufferBuilder.a(9, dArr[2], 0.0d);
        }
        flatBufferBuilder.b(10, iArr[10]);
        if (zArr[4]) {
            flatBufferBuilder.a(11, zArr2[0]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(12, zArr2[1]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4526a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4525a(jsonParser, flatBufferBuilder);
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

    public static void m4527a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("address");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("country_code");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("display_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("distance_unit");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        double a = mutableFlatBuffer.a(i, 5, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("latitude");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.a(i, 6, (short) 0) != (short) 0) {
            jsonGenerator.a("location_type");
            jsonGenerator.b(((GraphQLAdGeoLocationType) mutableFlatBuffer.a(i, 6, GraphQLAdGeoLocationType.class)).name());
        }
        a = mutableFlatBuffer.a(i, 7, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("longitude");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        a = mutableFlatBuffer.a(i, 9, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("radius");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("region_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        boolean a2 = mutableFlatBuffer.a(i, 11);
        if (a2) {
            jsonGenerator.a("supports_city");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 12);
        if (a2) {
            jsonGenerator.a("supports_region");
            jsonGenerator.a(a2);
        }
        jsonGenerator.g();
    }
}
