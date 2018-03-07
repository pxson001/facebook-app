package com.facebook.groups.memberpicker.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataParsers.FBNameFragmentParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataParsers.FBTaggableUserFragmentParser.BylinesParser;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataParsers.FullImageFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: error while parsing tracking codes  */
public class UserFriendsCollectionQueryParsers {

    /* compiled from: error while parsing tracking codes  */
    public final class UserFriendsCollectionQueryParser {

        /* compiled from: error while parsing tracking codes  */
        public final class FriendsParser {

            /* compiled from: error while parsing tracking codes  */
            public final class EdgesParser {

                /* compiled from: error while parsing tracking codes  */
                public final class NodeParser {
                    public static int m16895a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[7];
                        boolean[] zArr = new boolean[1];
                        double[] dArr = new double[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("bylines")) {
                                    iArr[0] = BylinesParser.m16701a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("communicationRank")) {
                                    zArr[0] = true;
                                    dArr[0] = jsonParser.G();
                                } else if (i.equals("id")) {
                                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("name")) {
                                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("name_search_tokens")) {
                                    iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("profilePicture50")) {
                                    iArr[5] = FullImageFragmentParser.m16707a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("structured_name")) {
                                    iArr[6] = FBNameFragmentParser.m16697a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(7);
                        flatBufferBuilder.b(0, iArr[0]);
                        if (zArr[0]) {
                            flatBufferBuilder.a(1, dArr[0], 0.0d);
                        }
                        flatBufferBuilder.b(2, iArr[2]);
                        flatBufferBuilder.b(3, iArr[3]);
                        flatBufferBuilder.b(4, iArr[4]);
                        flatBufferBuilder.b(5, iArr[5]);
                        flatBufferBuilder.b(6, iArr[6]);
                        return flatBufferBuilder.d();
                    }

                    public static void m16896a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("bylines");
                            BylinesParser.m16702a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        double a = mutableFlatBuffer.a(i, 1, 0.0d);
                        if (a != 0.0d) {
                            jsonGenerator.a("communicationRank");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 2) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                        }
                        if (mutableFlatBuffer.g(i, 3) != 0) {
                            jsonGenerator.a("name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("name_search_tokens");
                            SerializerHelpers.a(mutableFlatBuffer.f(i, 4), jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 5);
                        if (g != 0) {
                            jsonGenerator.a("profilePicture50");
                            FullImageFragmentParser.m16708a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 6);
                        if (g != 0) {
                            jsonGenerator.a("structured_name");
                            FBNameFragmentParser.m16698a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m16897b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m16895a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m16898b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m16896a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: error while parsing tracking codes  */
            public final class PageInfoParser {
                public static int m16899a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[4];
                    boolean[] zArr = new boolean[2];
                    boolean[] zArr2 = new boolean[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("end_cursor")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("has_next_page")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("has_previous_page")) {
                                zArr[1] = true;
                                zArr2[1] = jsonParser.H();
                            } else if (i.equals("start_cursor")) {
                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, iArr[0]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(1, zArr2[0]);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(2, zArr2[1]);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    return flatBufferBuilder.d();
                }

                public static void m16900a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
                    a = mutableFlatBuffer.a(i, 2);
                    if (a) {
                        jsonGenerator.a("has_previous_page");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("start_cursor");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16901a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m16897b(jsonParser, flatBufferBuilder)));
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
                            iArr[1] = PageInfoParser.m16899a(jsonParser, flatBufferBuilder);
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

            public static void m16902a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m16898b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("page_info");
                    PageInfoParser.m16900a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16903a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("friends")) {
                        iArr[1] = FriendsParser.m16901a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
