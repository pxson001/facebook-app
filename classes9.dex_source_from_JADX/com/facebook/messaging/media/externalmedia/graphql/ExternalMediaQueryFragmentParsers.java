package com.facebook.messaging.media.externalmedia.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMessengerPlatformMediaType;
import com.facebook.graphql.enums.GraphQLMessengerPlatformResultType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: mComponents */
public class ExternalMediaQueryFragmentParsers {

    /* compiled from: mComponents */
    public final class ExternalMediaQueryFragmentParser {

        /* compiled from: mComponents */
        public final class AppInfoParser {

            /* compiled from: mComponents */
            public final class IconParser {
                public static int m12302b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                            } else if (i.equals("url")) {
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

                public static void m12301a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("height");
                        jsonGenerator.b(a);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("url");
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

            public static int m12303b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[5];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("android_package")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("app_fbid")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("icon")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(IconParser.m12302b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr2 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr2, true);
                            }
                            iArr[2] = i2;
                        } else if (i.equals("name")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("subtitle")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                return flatBufferBuilder.d();
            }

            public static void m12304b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("android_package");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("app_fbid");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("icon");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        IconParser.m12301a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("subtitle");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: mComponents */
        public final class ResultGroupParser {

            /* compiled from: mComponents */
            public final class ResultsParser {

                /* compiled from: mComponents */
                public final class MediaParser {
                    public static int m12306b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[6];
                        boolean[] zArr = new boolean[4];
                        int[] iArr2 = new int[4];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("duration_ms")) {
                                    zArr[0] = true;
                                    iArr2[0] = jsonParser.E();
                                } else if (i.equals("format")) {
                                    iArr[1] = flatBufferBuilder.a(GraphQLMessengerPlatformMediaType.fromString(jsonParser.o()));
                                } else if (i.equals("height")) {
                                    zArr[1] = true;
                                    iArr2[1] = jsonParser.E();
                                } else if (i.equals("size_bytes")) {
                                    zArr[2] = true;
                                    iArr2[2] = jsonParser.E();
                                } else if (i.equals("url")) {
                                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("width")) {
                                    zArr[3] = true;
                                    iArr2[3] = jsonParser.E();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(6);
                        if (zArr[0]) {
                            flatBufferBuilder.a(0, iArr2[0], 0);
                        }
                        flatBufferBuilder.b(1, iArr[1]);
                        if (zArr[1]) {
                            flatBufferBuilder.a(2, iArr2[1], 0);
                        }
                        if (zArr[2]) {
                            flatBufferBuilder.a(3, iArr2[2], 0);
                        }
                        flatBufferBuilder.b(4, iArr[4]);
                        if (zArr[3]) {
                            flatBufferBuilder.a(5, iArr2[3], 0);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m12305a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("duration_ms");
                            jsonGenerator.b(a);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("format");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                        }
                        a = mutableFlatBuffer.a(i, 2, 0);
                        if (a != 0) {
                            jsonGenerator.a("height");
                            jsonGenerator.b(a);
                        }
                        a = mutableFlatBuffer.a(i, 3, 0);
                        if (a != 0) {
                            jsonGenerator.a("size_bytes");
                            jsonGenerator.b(a);
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("url");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                        }
                        a = mutableFlatBuffer.a(i, 5, 0);
                        if (a != 0) {
                            jsonGenerator.a("width");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: mComponents */
                public final class SourceParser {
                    public static int m12307a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[6];
                        boolean[] zArr = new boolean[4];
                        int[] iArr2 = new int[4];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("duration_ms")) {
                                    zArr[0] = true;
                                    iArr2[0] = jsonParser.E();
                                } else if (i.equals("height")) {
                                    zArr[1] = true;
                                    iArr2[1] = jsonParser.E();
                                } else if (i.equals("mime_type")) {
                                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("size_bytes")) {
                                    zArr[2] = true;
                                    iArr2[2] = jsonParser.E();
                                } else if (i.equals("url")) {
                                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("width")) {
                                    zArr[3] = true;
                                    iArr2[3] = jsonParser.E();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(6);
                        if (zArr[0]) {
                            flatBufferBuilder.a(0, iArr2[0], 0);
                        }
                        if (zArr[1]) {
                            flatBufferBuilder.a(1, iArr2[1], 0);
                        }
                        flatBufferBuilder.b(2, iArr[2]);
                        if (zArr[2]) {
                            flatBufferBuilder.a(3, iArr2[2], 0);
                        }
                        flatBufferBuilder.b(4, iArr[4]);
                        if (zArr[3]) {
                            flatBufferBuilder.a(5, iArr2[3], 0);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m12308a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("duration_ms");
                            jsonGenerator.b(a);
                        }
                        a = mutableFlatBuffer.a(i, 1, 0);
                        if (a != 0) {
                            jsonGenerator.a("height");
                            jsonGenerator.b(a);
                        }
                        if (mutableFlatBuffer.g(i, 2) != 0) {
                            jsonGenerator.a("mime_type");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                        }
                        a = mutableFlatBuffer.a(i, 3, 0);
                        if (a != 0) {
                            jsonGenerator.a("size_bytes");
                            jsonGenerator.b(a);
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("url");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                        }
                        a = mutableFlatBuffer.a(i, 5, 0);
                        if (a != 0) {
                            jsonGenerator.a("width");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m12309b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[5];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("app_fbid")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("media")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(MediaParser.m12306b(jsonParser, flatBufferBuilder)));
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    int[] iArr2 = new int[arrayList.size()];
                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                        iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                    }
                                    i2 = flatBufferBuilder.a(iArr2, true);
                                }
                                iArr[1] = i2;
                            } else if (i.equals("result_id")) {
                                iArr[2] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("result_type")) {
                                iArr[3] = flatBufferBuilder.a(GraphQLMessengerPlatformResultType.fromString(jsonParser.o()));
                            } else if (i.equals("source")) {
                                iArr[4] = SourceParser.m12307a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    flatBufferBuilder.b(2, iArr[2]);
                    flatBufferBuilder.b(3, iArr[3]);
                    flatBufferBuilder.b(4, iArr[4]);
                    return flatBufferBuilder.d();
                }

                public static void m12310b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("app_fbid");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("media");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            MediaParser.m12305a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                        }
                        jsonGenerator.e();
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("result_id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("result_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                    }
                    g = mutableFlatBuffer.g(i, 4);
                    if (g != 0) {
                        jsonGenerator.a("source");
                        SourceParser.m12308a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m12312b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("results")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(ResultsParser.m12309b(jsonParser, flatBufferBuilder)));
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

            public static int m12311a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m12312b(jsonParser, flatBufferBuilder)));
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

            public static void m12313b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("results");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        ResultsParser.m12310b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static int m12314a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("app_info")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(AppInfoParser.m12303b(jsonParser, flatBufferBuilder)));
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
                    } else if (i.equals("result_group")) {
                        iArr[1] = ResultGroupParser.m12311a(jsonParser, flatBufferBuilder);
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
    }
}
