package com.facebook.dialtone.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: [^a-zA-Z0-9_ ] */
public class DialtoneGraphQLParsers {

    /* compiled from: [^a-zA-Z0-9_ ] */
    public final class DialtonePhotoUnblockMutationParser {

        /* compiled from: [^a-zA-Z0-9_ ] */
        public final class DialtonePhotoQuotaParser {

            /* compiled from: [^a-zA-Z0-9_ ] */
            public final class FreePhotosParser {
                public static int m19925b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    boolean[] zArr = new boolean[1];
                    long[] jArr = new long[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("expiration")) {
                                zArr[0] = true;
                                jArr[0] = jsonParser.F();
                            } else if (i.equals("photo_regex")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(2);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, jArr[0], 0);
                    }
                    flatBufferBuilder.b(1, iArr[1]);
                    return flatBufferBuilder.d();
                }

                public static int m19923a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(m19925b(jsonParser, flatBufferBuilder)));
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

                public static void m19924a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    long a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("expiration");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("photo_regex");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m19926a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                boolean[] zArr = new boolean[3];
                int[] iArr2 = new int[2];
                long[] jArr = new long[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("expiration")) {
                            zArr[0] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("free_photos")) {
                            iArr[1] = FreePhotosParser.m19923a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("remaining_quota")) {
                            zArr[1] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("total_quota")) {
                            zArr[2] = true;
                            iArr2[1] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(4);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, jArr[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                if (zArr[1]) {
                    flatBufferBuilder.a(2, iArr2[0], 0);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(3, iArr2[1], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m19927a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                long a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("expiration");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("free_photos");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        FreePhotosParser.m19924a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.a(i, 2, 0);
                if (g != 0) {
                    jsonGenerator.a("remaining_quota");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 3, 0);
                if (g != 0) {
                    jsonGenerator.a("total_quota");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m19928a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("dialtone_photo_quota")) {
                        iArr[0] = DialtonePhotoQuotaParser.m19926a(jsonParser, flatBufferBuilder);
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

    /* compiled from: [^a-zA-Z0-9_ ] */
    public final class FetchDialtonePhotoQuotaParser {

        /* compiled from: [^a-zA-Z0-9_ ] */
        public final class DialtonePhotoQuotaParser {

            /* compiled from: [^a-zA-Z0-9_ ] */
            public final class FreePhotosParser {
                public static int m19931b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    boolean[] zArr = new boolean[1];
                    long[] jArr = new long[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("expiration")) {
                                zArr[0] = true;
                                jArr[0] = jsonParser.F();
                            } else if (i.equals("photo_regex")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(2);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, jArr[0], 0);
                    }
                    flatBufferBuilder.b(1, iArr[1]);
                    return flatBufferBuilder.d();
                }

                public static int m19929a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(m19931b(jsonParser, flatBufferBuilder)));
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

                public static void m19930a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    long a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("expiration");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("photo_regex");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m19932a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                boolean[] zArr = new boolean[3];
                int[] iArr2 = new int[2];
                long[] jArr = new long[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("expiration")) {
                            zArr[0] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("free_photos")) {
                            iArr[1] = FreePhotosParser.m19929a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("remaining_quota")) {
                            zArr[1] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("total_quota")) {
                            zArr[2] = true;
                            iArr2[1] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(4);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, jArr[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                if (zArr[1]) {
                    flatBufferBuilder.a(2, iArr2[0], 0);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(3, iArr2[1], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m19933a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                long a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("expiration");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("free_photos");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        FreePhotosParser.m19930a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.a(i, 2, 0);
                if (g != 0) {
                    jsonGenerator.a("remaining_quota");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 3, 0);
                if (g != 0) {
                    jsonGenerator.a("total_quota");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m19934a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("dialtone_photo_quota")) {
                        iArr[0] = DialtonePhotoQuotaParser.m19932a(jsonParser, flatBufferBuilder);
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
}
