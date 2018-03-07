package com.facebook.messaging.composershortcuts.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMessengerPlatformMediaType;
import com.facebook.graphql.enums.GraphQLMessengerPlatformResultType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: messageSenderFbid */
public class SampleContentQueryFragmentParsers {

    /* compiled from: messageSenderFbid */
    public final class SampleContentQueryFragmentParser {

        /* compiled from: messageSenderFbid */
        public final class AppsParser {

            /* compiled from: messageSenderFbid */
            public final class EdgesParser {

                /* compiled from: messageSenderFbid */
                public final class NodeParser {

                    /* compiled from: messageSenderFbid */
                    public final class SampleContentParser {

                        /* compiled from: messageSenderFbid */
                        public final class MediaParser {
                            public static int m10738b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                            public static void m10737a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

                        public static int m10739b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[3];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("media")) {
                                        int i2 = 0;
                                        ArrayList arrayList = new ArrayList();
                                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                                arrayList.add(Integer.valueOf(MediaParser.m10738b(jsonParser, flatBufferBuilder)));
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
                                    } else if (i.equals("result_id")) {
                                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("result_type")) {
                                        iArr[2] = flatBufferBuilder.a(GraphQLMessengerPlatformResultType.fromString(jsonParser.o()));
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(3);
                            flatBufferBuilder.b(0, iArr[0]);
                            flatBufferBuilder.b(1, iArr[1]);
                            flatBufferBuilder.b(2, iArr[2]);
                            return flatBufferBuilder.d();
                        }

                        public static void m10740b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("media");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    MediaParser.m10737a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                                }
                                jsonGenerator.e();
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("result_id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            if (mutableFlatBuffer.g(i, 2) != 0) {
                                jsonGenerator.a("result_type");
                                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m10741a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[4];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("android_package")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("fbid")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("name")) {
                                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("sample_content")) {
                                    int i2 = 0;
                                    ArrayList arrayList = new ArrayList();
                                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                                            arrayList.add(Integer.valueOf(SampleContentParser.m10739b(jsonParser, flatBufferBuilder)));
                                        }
                                    }
                                    if (!arrayList.isEmpty()) {
                                        int[] iArr2 = new int[arrayList.size()];
                                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                        }
                                        i2 = flatBufferBuilder.a(iArr2, true);
                                    }
                                    iArr[3] = i2;
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

                    public static void m10742a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("android_package");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("fbid");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        if (mutableFlatBuffer.g(i, 2) != 0) {
                            jsonGenerator.a("name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                        }
                        int g = mutableFlatBuffer.g(i, 3);
                        if (g != 0) {
                            jsonGenerator.a("sample_content");
                            jsonGenerator.d();
                            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                SampleContentParser.m10740b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                            }
                            jsonGenerator.e();
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m10743b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m10741a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m10744b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m10742a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m10745a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m10743b(jsonParser, flatBufferBuilder)));
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

            public static void m10746a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m10744b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m10747a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("apps")) {
                        iArr[0] = AppsParser.m10745a(jsonParser, flatBufferBuilder);
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
