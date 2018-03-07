package com.facebook.growth.friendfinder.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: pagingEnabled */
public class FetchFriendableContactsQueryGraphQLParsers {

    /* compiled from: pagingEnabled */
    public final class FetchFriendableContactsQueryParser {

        /* compiled from: pagingEnabled */
        public final class AddressbooksParser {

            /* compiled from: pagingEnabled */
            public final class EdgesParser {

                /* compiled from: pagingEnabled */
                public final class NodeParser {

                    /* compiled from: pagingEnabled */
                    public final class FriendableContactsParser {

                        /* compiled from: pagingEnabled */
                        public final class NodesParser {

                            /* compiled from: pagingEnabled */
                            public final class MutualFriendsParser {
                                public static int m7616a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    boolean[] zArr = new boolean[1];
                                    int[] iArr = new int[1];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("count")) {
                                                zArr[0] = true;
                                                iArr[0] = jsonParser.E();
                                            } else {
                                                jsonParser.f();
                                            }
                                        }
                                    }
                                    flatBufferBuilder.c(1);
                                    if (zArr[0]) {
                                        flatBufferBuilder.a(0, iArr[0], 0);
                                    }
                                    return flatBufferBuilder.d();
                                }

                                public static void m7617a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                    jsonGenerator.f();
                                    int a = mutableFlatBuffer.a(i, 0, 0);
                                    if (a != 0) {
                                        jsonGenerator.a("count");
                                        jsonGenerator.b(a);
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            /* compiled from: pagingEnabled */
                            public final class ProfilePictureParser {
                                public static int m7618a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    int[] iArr = new int[1];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("uri")) {
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

                                public static void m7619a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                    jsonGenerator.f();
                                    if (mutableFlatBuffer.g(i, 0) != 0) {
                                        jsonGenerator.a("uri");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            public static int m7620b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[4];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("id")) {
                                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("mutual_friends")) {
                                            iArr[1] = MutualFriendsParser.m7616a(jsonParser, flatBufferBuilder);
                                        } else if (i.equals("name")) {
                                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("profile_picture")) {
                                            iArr[3] = ProfilePictureParser.m7618a(jsonParser, flatBufferBuilder);
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

                            public static void m7621b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("id");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                int g = mutableFlatBuffer.g(i, 1);
                                if (g != 0) {
                                    jsonGenerator.a("mutual_friends");
                                    MutualFriendsParser.m7617a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                if (mutableFlatBuffer.g(i, 2) != 0) {
                                    jsonGenerator.a("name");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                                }
                                g = mutableFlatBuffer.g(i, 3);
                                if (g != 0) {
                                    jsonGenerator.a("profile_picture");
                                    ProfilePictureParser.m7619a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: pagingEnabled */
                        public final class PageInfoParser {
                            public static int m7622a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[3];
                                boolean[] zArr = new boolean[1];
                                boolean[] zArr2 = new boolean[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("end_cursor")) {
                                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("has_next_page")) {
                                            zArr[0] = true;
                                            zArr2[0] = jsonParser.H();
                                        } else if (i.equals("start_cursor")) {
                                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
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
                                flatBufferBuilder.b(2, iArr[2]);
                                return flatBufferBuilder.d();
                            }

                            public static void m7623a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("end_cursor");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                boolean a = mutableFlatBuffer.a(i, 1);
                                if (a) {
                                    jsonGenerator.a("has_next_page");
                                    jsonGenerator.a(a);
                                }
                                if (mutableFlatBuffer.g(i, 2) != 0) {
                                    jsonGenerator.a("start_cursor");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m7624a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[2];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("nodes")) {
                                        int i2 = 0;
                                        ArrayList arrayList = new ArrayList();
                                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                                arrayList.add(Integer.valueOf(NodesParser.m7620b(jsonParser, flatBufferBuilder)));
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
                                    } else if (i.equals("page_info")) {
                                        iArr[1] = PageInfoParser.m7622a(jsonParser, flatBufferBuilder);
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

                        public static void m7625a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("nodes");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    NodesParser.m7621b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.e();
                            }
                            g = mutableFlatBuffer.g(i, 1);
                            if (g != 0) {
                                jsonGenerator.a("page_info");
                                PageInfoParser.m7623a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m7626a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("friendable_contacts")) {
                                    iArr[0] = FriendableContactsParser.m7624a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m7627a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("friendable_contacts");
                            FriendableContactsParser.m7625a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m7628b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m7626a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m7629b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m7627a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m7630a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m7628b(jsonParser, flatBufferBuilder)));
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

            public static void m7631a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m7629b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m7632a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("addressbooks")) {
                        iArr[0] = AddressbooksParser.m7630a(jsonParser, flatBufferBuilder);
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
