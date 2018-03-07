package com.facebook.photos.creativeediting.model;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: survey_id=%s& */
public class FrameGraphQLParsers {

    /* compiled from: survey_id=%s& */
    public final class FramePackParser {
        public static int m4643a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            boolean[] zArr = new boolean[2];
            long[] jArr = new long[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("end_time")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("frames")) {
                        iArr[1] = FrameParser.m4665a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("start_time")) {
                        zArr[1] = true;
                        jArr[1] = jsonParser.F();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(5);
            if (zArr[0]) {
                flatBufferBuilder.a(0, jArr[0], 0);
            }
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[1]) {
                flatBufferBuilder.a(4, jArr[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m4644b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            long a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("end_time");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("frames");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    FrameParser.m4667b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            a = mutableFlatBuffer.a(i, 4, 0);
            if (a != 0) {
                jsonGenerator.a("start_time");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: survey_id=%s& */
    public final class FrameParser {

        /* compiled from: survey_id=%s& */
        public final class StickerAssetsParser {

            /* compiled from: survey_id=%s& */
            public final class NodesParser {

                /* compiled from: survey_id=%s& */
                public final class LandscapePositionParser {
                    public static int m4645a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[6];
                        boolean[] zArr = new boolean[3];
                        double[] dArr = new double[3];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("asset_size")) {
                                    zArr[0] = true;
                                    dArr[0] = jsonParser.G();
                                } else if (i.equals("horizontal_alignment")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("horizontal_margin")) {
                                    zArr[1] = true;
                                    dArr[1] = jsonParser.G();
                                } else if (i.equals("size_dimension")) {
                                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("vertical_alignment")) {
                                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("vertical_margin")) {
                                    zArr[2] = true;
                                    dArr[2] = jsonParser.G();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(6);
                        if (zArr[0]) {
                            flatBufferBuilder.a(0, dArr[0], 0.0d);
                        }
                        flatBufferBuilder.b(1, iArr[1]);
                        if (zArr[1]) {
                            flatBufferBuilder.a(2, dArr[1], 0.0d);
                        }
                        flatBufferBuilder.b(3, iArr[3]);
                        flatBufferBuilder.b(4, iArr[4]);
                        if (zArr[2]) {
                            flatBufferBuilder.a(5, dArr[2], 0.0d);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m4646a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        double a = mutableFlatBuffer.a(i, 0, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("asset_size");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("horizontal_alignment");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        a = mutableFlatBuffer.a(i, 2, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("horizontal_margin");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 3) != 0) {
                            jsonGenerator.a("size_dimension");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("vertical_alignment");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                        }
                        a = mutableFlatBuffer.a(i, 5, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("vertical_margin");
                            jsonGenerator.a(a);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: survey_id=%s& */
                public final class PortraitPositionParser {
                    public static int m4647a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[6];
                        boolean[] zArr = new boolean[3];
                        double[] dArr = new double[3];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("asset_size")) {
                                    zArr[0] = true;
                                    dArr[0] = jsonParser.G();
                                } else if (i.equals("horizontal_alignment")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("horizontal_margin")) {
                                    zArr[1] = true;
                                    dArr[1] = jsonParser.G();
                                } else if (i.equals("size_dimension")) {
                                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("vertical_alignment")) {
                                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("vertical_margin")) {
                                    zArr[2] = true;
                                    dArr[2] = jsonParser.G();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(6);
                        if (zArr[0]) {
                            flatBufferBuilder.a(0, dArr[0], 0.0d);
                        }
                        flatBufferBuilder.b(1, iArr[1]);
                        if (zArr[1]) {
                            flatBufferBuilder.a(2, dArr[1], 0.0d);
                        }
                        flatBufferBuilder.b(3, iArr[3]);
                        flatBufferBuilder.b(4, iArr[4]);
                        if (zArr[2]) {
                            flatBufferBuilder.a(5, dArr[2], 0.0d);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m4648a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        double a = mutableFlatBuffer.a(i, 0, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("asset_size");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("horizontal_alignment");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        a = mutableFlatBuffer.a(i, 2, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("horizontal_margin");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 3) != 0) {
                            jsonGenerator.a("size_dimension");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("vertical_alignment");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                        }
                        a = mutableFlatBuffer.a(i, 5, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("vertical_margin");
                            jsonGenerator.a(a);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: survey_id=%s& */
                public final class StickerParser {

                    /* compiled from: survey_id=%s& */
                    public final class PreviewImageParser {
                        public static int m4649a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[3];
                            boolean[] zArr = new boolean[2];
                            int[] iArr2 = new int[2];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("height")) {
                                        zArr[0] = true;
                                        iArr2[0] = jsonParser.E();
                                    } else if (i.equals("uri")) {
                                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("width")) {
                                        zArr[1] = true;
                                        iArr2[1] = jsonParser.E();
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(3);
                            if (zArr[0]) {
                                flatBufferBuilder.a(0, iArr2[0], 0);
                            }
                            flatBufferBuilder.b(1, iArr[1]);
                            if (zArr[1]) {
                                flatBufferBuilder.a(2, iArr2[1], 0);
                            }
                            return flatBufferBuilder.d();
                        }

                        public static void m4650a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            int a = mutableFlatBuffer.a(i, 0, 0);
                            if (a != 0) {
                                jsonGenerator.a("height");
                                jsonGenerator.b(a);
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("uri");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            a = mutableFlatBuffer.a(i, 2, 0);
                            if (a != 0) {
                                jsonGenerator.a("width");
                                jsonGenerator.b(a);
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m4651a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("id")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("preview_image")) {
                                    iArr[1] = PreviewImageParser.m4649a(jsonParser, flatBufferBuilder);
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

                    public static void m4652a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        int g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("preview_image");
                            PreviewImageParser.m4650a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m4653b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[4];
                    boolean[] zArr = new boolean[1];
                    double[] dArr = new double[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("landscape_position")) {
                                iArr[0] = LandscapePositionParser.m4645a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("portrait_position")) {
                                iArr[1] = PortraitPositionParser.m4647a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("rotation_degree")) {
                                zArr[0] = true;
                                dArr[0] = jsonParser.G();
                            } else if (i.equals("sticker")) {
                                iArr[3] = StickerParser.m4651a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(2, dArr[0], 0.0d);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    return flatBufferBuilder.d();
                }

                public static void m4654b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("landscape_position");
                        LandscapePositionParser.m4646a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("portrait_position");
                        PortraitPositionParser.m4648a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    double a = mutableFlatBuffer.a(i, 2, 0.0d);
                    if (a != 0.0d) {
                        jsonGenerator.a("rotation_degree");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 3);
                    if (g != 0) {
                        jsonGenerator.a("sticker");
                        StickerParser.m4652a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m4655a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(NodesParser.m4653b(jsonParser, flatBufferBuilder)));
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
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m4656a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m4654b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: survey_id=%s& */
        public final class TextAssetsParser {

            /* compiled from: survey_id=%s& */
            public final class NodesParser {

                /* compiled from: survey_id=%s& */
                public final class LandscapePositionParser {
                    public static int m4657a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[6];
                        boolean[] zArr = new boolean[3];
                        double[] dArr = new double[3];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("asset_size")) {
                                    zArr[0] = true;
                                    dArr[0] = jsonParser.G();
                                } else if (i.equals("horizontal_alignment")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("horizontal_margin")) {
                                    zArr[1] = true;
                                    dArr[1] = jsonParser.G();
                                } else if (i.equals("size_dimension")) {
                                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("vertical_alignment")) {
                                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("vertical_margin")) {
                                    zArr[2] = true;
                                    dArr[2] = jsonParser.G();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(6);
                        if (zArr[0]) {
                            flatBufferBuilder.a(0, dArr[0], 0.0d);
                        }
                        flatBufferBuilder.b(1, iArr[1]);
                        if (zArr[1]) {
                            flatBufferBuilder.a(2, dArr[1], 0.0d);
                        }
                        flatBufferBuilder.b(3, iArr[3]);
                        flatBufferBuilder.b(4, iArr[4]);
                        if (zArr[2]) {
                            flatBufferBuilder.a(5, dArr[2], 0.0d);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m4658a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        double a = mutableFlatBuffer.a(i, 0, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("asset_size");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("horizontal_alignment");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        a = mutableFlatBuffer.a(i, 2, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("horizontal_margin");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 3) != 0) {
                            jsonGenerator.a("size_dimension");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("vertical_alignment");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                        }
                        a = mutableFlatBuffer.a(i, 5, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("vertical_margin");
                            jsonGenerator.a(a);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: survey_id=%s& */
                public final class PortraitPositionParser {
                    public static int m4659a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[6];
                        boolean[] zArr = new boolean[3];
                        double[] dArr = new double[3];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("asset_size")) {
                                    zArr[0] = true;
                                    dArr[0] = jsonParser.G();
                                } else if (i.equals("horizontal_alignment")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("horizontal_margin")) {
                                    zArr[1] = true;
                                    dArr[1] = jsonParser.G();
                                } else if (i.equals("size_dimension")) {
                                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("vertical_alignment")) {
                                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("vertical_margin")) {
                                    zArr[2] = true;
                                    dArr[2] = jsonParser.G();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(6);
                        if (zArr[0]) {
                            flatBufferBuilder.a(0, dArr[0], 0.0d);
                        }
                        flatBufferBuilder.b(1, iArr[1]);
                        if (zArr[1]) {
                            flatBufferBuilder.a(2, dArr[1], 0.0d);
                        }
                        flatBufferBuilder.b(3, iArr[3]);
                        flatBufferBuilder.b(4, iArr[4]);
                        if (zArr[2]) {
                            flatBufferBuilder.a(5, dArr[2], 0.0d);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m4660a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        double a = mutableFlatBuffer.a(i, 0, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("asset_size");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("horizontal_alignment");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        a = mutableFlatBuffer.a(i, 2, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("horizontal_margin");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 3) != 0) {
                            jsonGenerator.a("size_dimension");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("vertical_alignment");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                        }
                        a = mutableFlatBuffer.a(i, 5, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("vertical_margin");
                            jsonGenerator.a(a);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m4661b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[4];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("landscape_position")) {
                                iArr[0] = LandscapePositionParser.m4657a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("portrait_position")) {
                                iArr[1] = PortraitPositionParser.m4659a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("text_color")) {
                                iArr[2] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("text_content")) {
                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    flatBufferBuilder.b(2, iArr[2]);
                    flatBufferBuilder.b(3, iArr[3]);
                    return flatBufferBuilder.d();
                }

                public static void m4662b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("landscape_position");
                        LandscapePositionParser.m4658a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("portrait_position");
                        PortraitPositionParser.m4660a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("text_color");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("text_content");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m4663a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(NodesParser.m4661b(jsonParser, flatBufferBuilder)));
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
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m4664a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m4662b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static int m4666b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            boolean[] zArr = new boolean[2];
            long[] jArr = new long[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("end_time")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("start_time")) {
                        zArr[1] = true;
                        jArr[1] = jsonParser.F();
                    } else if (i.equals("sticker_assets")) {
                        iArr[3] = StickerAssetsParser.m4655a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("text_assets")) {
                        iArr[4] = TextAssetsParser.m4663a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(5);
            if (zArr[0]) {
                flatBufferBuilder.a(0, jArr[0], 0);
            }
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[1]) {
                flatBufferBuilder.a(2, jArr[1], 0);
            }
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            return flatBufferBuilder.d();
        }

        public static int m4665a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m4666b(jsonParser, flatBufferBuilder)));
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

        public static void m4667b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            long a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("end_time");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            a = mutableFlatBuffer.a(i, 2, 0);
            if (a != 0) {
                jsonGenerator.a("start_time");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("sticker_assets");
                StickerAssetsParser.m4656a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("text_assets");
                TextAssetsParser.m4664a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }
}
