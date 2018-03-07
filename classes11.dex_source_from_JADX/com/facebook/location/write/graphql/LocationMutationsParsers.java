package com.facebook.location.write.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: Unexpected structure of headers array */
public class LocationMutationsParsers {

    /* compiled from: Unexpected structure of headers array */
    public final class LocationUpdateMutationParser {

        /* compiled from: Unexpected structure of headers array */
        public final class ViewerParser {
            public static int m10866a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("last_location")) {
                            iArr[0] = ViewerLocationParser.m10871a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m10867a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("last_location");
                    ViewerLocationParser.m10872a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m10868a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("viewer")) {
                        iArr[0] = ViewerParser.m10866a(jsonParser, flatBufferBuilder);
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

    /* compiled from: Unexpected structure of headers array */
    public final class ViewerLocationCoordinateParser {
        public static int m10869a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            boolean[] zArr = new boolean[3];
            double[] dArr = new double[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("accuracy_meters")) {
                        zArr[0] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("latitude")) {
                        zArr[1] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("longitude")) {
                        zArr[2] = true;
                        dArr[2] = jsonParser.G();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            if (zArr[0]) {
                flatBufferBuilder.a(0, dArr[0], 0.0d);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, dArr[1], 0.0d);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(2, dArr[2], 0.0d);
            }
            return flatBufferBuilder.d();
        }

        public static void m10870a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            double a = mutableFlatBuffer.a(i, 0, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("accuracy_meters");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("latitude");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 2, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("longitude");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: Unexpected structure of headers array */
    public final class ViewerLocationParser {
        public static int m10871a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("coordinate")) {
                        iArr[0] = ViewerLocationCoordinateParser.m10869a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("stale_time_seconds")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, iArr2[0], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m10872a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("coordinate");
                ViewerLocationCoordinateParser.m10870a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 1, 0);
            if (g != 0) {
                jsonGenerator.a("stale_time_seconds");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }
}
