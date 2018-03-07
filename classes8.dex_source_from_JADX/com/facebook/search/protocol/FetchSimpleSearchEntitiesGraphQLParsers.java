package com.facebook.search.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: network_fetch_time */
public class FetchSimpleSearchEntitiesGraphQLParsers {

    /* compiled from: network_fetch_time */
    public final class FetchSimpleSearchEntitiesQueryParser {

        /* compiled from: network_fetch_time */
        public final class SearchResultsParser {

            /* compiled from: network_fetch_time */
            public final class EdgesParser {

                /* compiled from: network_fetch_time */
                public final class NodeParser {

                    /* compiled from: network_fetch_time */
                    public final class GroupIconParser {

                        /* compiled from: network_fetch_time */
                        public final class DarkIconParser {
                            public static int m8836a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                            public static void m8837a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("uri");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m8838a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[1];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("dark_icon")) {
                                        iArr[0] = DarkIconParser.m8836a(jsonParser, flatBufferBuilder);
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, iArr[0]);
                            return flatBufferBuilder.d();
                        }

                        public static void m8839a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("dark_icon");
                                DarkIconParser.m8837a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            jsonGenerator.g();
                        }
                    }

                    /* compiled from: network_fetch_time */
                    public final class GroupPhotorealisticIconParser {
                        public static int m8840a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                        public static void m8841a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("uri");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m8842a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[8];
                        boolean[] zArr = new boolean[1];
                        boolean[] zArr2 = new boolean[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("group_icon")) {
                                    iArr[1] = GroupIconParser.m8838a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("group_photorealistic_icon")) {
                                    iArr[2] = GroupPhotorealisticIconParser.m8840a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("id")) {
                                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("is_verified")) {
                                    zArr[0] = true;
                                    zArr2[0] = jsonParser.H();
                                } else if (i.equals("name")) {
                                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("profile_picture")) {
                                    iArr[6] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("viewer_saved_state")) {
                                    iArr[7] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(8);
                        flatBufferBuilder.b(0, iArr[0]);
                        flatBufferBuilder.b(1, iArr[1]);
                        flatBufferBuilder.b(2, iArr[2]);
                        flatBufferBuilder.b(3, iArr[3]);
                        if (zArr[0]) {
                            flatBufferBuilder.a(4, zArr2[0]);
                        }
                        flatBufferBuilder.b(5, iArr[5]);
                        flatBufferBuilder.b(6, iArr[6]);
                        flatBufferBuilder.b(7, iArr[7]);
                        return flatBufferBuilder.d();
                    }

                    public static void m8843a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        int g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("group_icon");
                            GroupIconParser.m8839a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        g = mutableFlatBuffer.g(i, 2);
                        if (g != 0) {
                            jsonGenerator.a("group_photorealistic_icon");
                            GroupPhotorealisticIconParser.m8841a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 3) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                        }
                        boolean a = mutableFlatBuffer.a(i, 4);
                        if (a) {
                            jsonGenerator.a("is_verified");
                            jsonGenerator.a(a);
                        }
                        if (mutableFlatBuffer.g(i, 5) != 0) {
                            jsonGenerator.a("name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                        }
                        g = mutableFlatBuffer.g(i, 6);
                        if (g != 0) {
                            jsonGenerator.a("profile_picture");
                            DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 7) != 0) {
                            jsonGenerator.a("viewer_saved_state");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 7));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m8844b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("category")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("node")) {
                                iArr[1] = NodeParser.m8842a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("subtext")) {
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
                    return flatBufferBuilder.d();
                }

                public static void m8845b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("category");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m8843a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("subtext");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: network_fetch_time */
            public final class PageInfoParser {
                public static int m8846a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m8847a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

            public static int m8848a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m8844b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr3 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr3, true);
                            }
                            iArr[1] = i2;
                        } else if (i.equals("page_info")) {
                            iArr[2] = PageInfoParser.m8846a(jsonParser, flatBufferBuilder);
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
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m8849a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                        EdgesParser.m8845b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                a = mutableFlatBuffer.g(i, 2);
                if (a != 0) {
                    jsonGenerator.a("page_info");
                    PageInfoParser.m8847a(mutableFlatBuffer, a, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m8850a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("search_results")) {
                        iArr[0] = SearchResultsParser.m8848a(jsonParser, flatBufferBuilder);
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
