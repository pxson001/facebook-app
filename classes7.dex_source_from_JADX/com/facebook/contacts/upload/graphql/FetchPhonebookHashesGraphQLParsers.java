package com.facebook.contacts.upload.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: tapped_add_photos */
public class FetchPhonebookHashesGraphQLParsers {

    /* compiled from: tapped_add_photos */
    public final class FetchPhonebookHashesQueryParser {

        /* compiled from: tapped_add_photos */
        public final class AddressbooksParser {

            /* compiled from: tapped_add_photos */
            public final class EdgesParser {

                /* compiled from: tapped_add_photos */
                public final class NodeParser {

                    /* compiled from: tapped_add_photos */
                    public final class AddressbookContactsParser {

                        /* compiled from: tapped_add_photos */
                        public final class NodesParser {
                            public static int m2174b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[2];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("record_id")) {
                                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("uuid")) {
                                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
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

                            public static void m2173a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("record_id");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                if (mutableFlatBuffer.g(i, 1) != 0) {
                                    jsonGenerator.a("uuid");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m2175a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                                arrayList.add(Integer.valueOf(NodesParser.m2174b(jsonParser, flatBufferBuilder)));
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

                        public static void m2176a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("nodes");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    NodesParser.m2173a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                                }
                                jsonGenerator.e();
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m2177a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[3];
                        boolean[] zArr = new boolean[2];
                        boolean[] zArr2 = new boolean[1];
                        int[] iArr2 = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("addressbook_contacts")) {
                                    iArr[0] = AddressbookContactsParser.m2175a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("is_in_sync")) {
                                    zArr[0] = true;
                                    zArr2[0] = jsonParser.H();
                                } else if (i.equals("max_contacts_allowed")) {
                                    zArr[1] = true;
                                    iArr2[0] = jsonParser.E();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, iArr[0]);
                        if (zArr[0]) {
                            flatBufferBuilder.a(1, zArr2[0]);
                        }
                        if (zArr[1]) {
                            flatBufferBuilder.a(2, iArr2[0], 0);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m2178a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("addressbook_contacts");
                            AddressbookContactsParser.m2176a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        boolean a = mutableFlatBuffer.a(i, 1);
                        if (a) {
                            jsonGenerator.a("is_in_sync");
                            jsonGenerator.a(a);
                        }
                        g = mutableFlatBuffer.a(i, 2, 0);
                        if (g != 0) {
                            jsonGenerator.a("max_contacts_allowed");
                            jsonGenerator.b(g);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m2179b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m2177a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m2180b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m2178a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m2181a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m2179b(jsonParser, flatBufferBuilder)));
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

            public static void m2182a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m2180b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m2183a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("addressbooks")) {
                        iArr[0] = AddressbooksParser.m2181a(jsonParser, flatBufferBuilder);
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
