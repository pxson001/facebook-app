package com.facebook.katana.dbl;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: update_check_minutes */
public class FetchDBLNonceInfoQueryParsers {

    /* compiled from: update_check_minutes */
    public final class FetchDBLNonceInfoQueryParser {

        /* compiled from: update_check_minutes */
        public final class DeviceBasedLoginNonceInfosParser {

            /* compiled from: update_check_minutes */
            public final class NodesParser {

                /* compiled from: update_check_minutes */
                public final class DeviceTypeParser {
                    public static int m965a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("text")) {
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

                    public static void m966a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("text");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m967b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[6];
                    boolean[] zArr = new boolean[3];
                    boolean[] zArr2 = new boolean[2];
                    long[] jArr = new long[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("datr")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("device_type")) {
                                iArr[1] = DeviceTypeParser.m965a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("has_pin")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("is_current_device")) {
                                zArr[1] = true;
                                zArr2[1] = jsonParser.H();
                            } else if (i.equals("last_used_time")) {
                                zArr[2] = true;
                                jArr[0] = jsonParser.F();
                            } else if (i.equals("user_agent")) {
                                iArr[5] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(2, zArr2[0]);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(3, zArr2[1]);
                    }
                    if (zArr[2]) {
                        flatBufferBuilder.a(4, jArr[0], 0);
                    }
                    flatBufferBuilder.b(5, iArr[5]);
                    return flatBufferBuilder.d();
                }

                public static void m968b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("datr");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("device_type");
                        DeviceTypeParser.m966a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    boolean a = mutableFlatBuffer.a(i, 2);
                    if (a) {
                        jsonGenerator.a("has_pin");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 3);
                    if (a) {
                        jsonGenerator.a("is_current_device");
                        jsonGenerator.a(a);
                    }
                    long a2 = mutableFlatBuffer.a(i, 4, 0);
                    if (a2 != 0) {
                        jsonGenerator.a("last_used_time");
                        jsonGenerator.a(a2);
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("user_agent");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m969a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(NodesParser.m967b(jsonParser, flatBufferBuilder)));
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

            public static void m970a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m968b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m971a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("device_based_login_nonce_infos")) {
                        iArr[0] = DeviceBasedLoginNonceInfosParser.m969a(jsonParser, flatBufferBuilder);
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
