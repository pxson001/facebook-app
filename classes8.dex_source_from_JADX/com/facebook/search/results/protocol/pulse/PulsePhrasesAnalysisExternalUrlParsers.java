package com.facebook.search.results.protocol.pulse;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: messenger_content_page_unsubscribe */
public class PulsePhrasesAnalysisExternalUrlParsers {

    /* compiled from: messenger_content_page_unsubscribe */
    public final class PulsePhrasesAnalysisExternalUrlParser {

        /* compiled from: messenger_content_page_unsubscribe */
        public final class PhrasesAnalysisParser {

            /* compiled from: messenger_content_page_unsubscribe */
            public final class PhrasesParser {

                /* compiled from: messenger_content_page_unsubscribe */
                public final class EdgesParser {

                    /* compiled from: messenger_content_page_unsubscribe */
                    public final class NodeParser {

                        /* compiled from: messenger_content_page_unsubscribe */
                        public final class MorePostsQueryParser {

                            /* compiled from: messenger_content_page_unsubscribe */
                            public final class QueryTitleParser {
                                public static int m10358a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                                public static void m10359a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                    jsonGenerator.f();
                                    if (mutableFlatBuffer.g(i, 0) != 0) {
                                        jsonGenerator.a("text");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            public static int m10360a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[4];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("id")) {
                                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("query_function")) {
                                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("query_title")) {
                                            iArr[2] = QueryTitleParser.m10358a(jsonParser, flatBufferBuilder);
                                        } else if (i.equals("search_result_style_list")) {
                                            iArr[3] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
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

                            public static void m10361a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("id");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                if (mutableFlatBuffer.g(i, 1) != 0) {
                                    jsonGenerator.a("query_function");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                }
                                int g = mutableFlatBuffer.g(i, 2);
                                if (g != 0) {
                                    jsonGenerator.a("query_title");
                                    QueryTitleParser.m10359a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                if (mutableFlatBuffer.g(i, 3) != 0) {
                                    jsonGenerator.a("search_result_style_list");
                                    SerializerHelpers.a(mutableFlatBuffer.f(i, 3), jsonGenerator);
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: messenger_content_page_unsubscribe */
                        public final class PhraseOwnerParser {
                            public static int m10362a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[3];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("__type__")) {
                                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                        } else if (i.equals("id")) {
                                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("profile_picture")) {
                                            iArr[2] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
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

                            public static void m10363a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("__type__");
                                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                                }
                                if (mutableFlatBuffer.g(i, 1) != 0) {
                                    jsonGenerator.a("id");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                }
                                int g = mutableFlatBuffer.g(i, 2);
                                if (g != 0) {
                                    jsonGenerator.a("profile_picture");
                                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m10364a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[9];
                            boolean[] zArr = new boolean[3];
                            int[] iArr2 = new int[3];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("count")) {
                                        zArr[0] = true;
                                        iArr2[0] = jsonParser.E();
                                    } else if (i.equals("id")) {
                                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("more_posts_query")) {
                                        iArr[2] = MorePostsQueryParser.m10360a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("phrase")) {
                                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("phrase_length")) {
                                        zArr[1] = true;
                                        iArr2[1] = jsonParser.E();
                                    } else if (i.equals("phrase_offset")) {
                                        zArr[2] = true;
                                        iArr2[2] = jsonParser.E();
                                    } else if (i.equals("phrase_owner")) {
                                        iArr[6] = PhraseOwnerParser.m10362a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("sample_text")) {
                                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("sentence")) {
                                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(9);
                            if (zArr[0]) {
                                flatBufferBuilder.a(0, iArr2[0], 0);
                            }
                            flatBufferBuilder.b(1, iArr[1]);
                            flatBufferBuilder.b(2, iArr[2]);
                            flatBufferBuilder.b(3, iArr[3]);
                            if (zArr[1]) {
                                flatBufferBuilder.a(4, iArr2[1], 0);
                            }
                            if (zArr[2]) {
                                flatBufferBuilder.a(5, iArr2[2], 0);
                            }
                            flatBufferBuilder.b(6, iArr[6]);
                            flatBufferBuilder.b(7, iArr[7]);
                            flatBufferBuilder.b(8, iArr[8]);
                            return flatBufferBuilder.d();
                        }

                        public static void m10365a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int a = mutableFlatBuffer.a(i, 0, 0);
                            if (a != 0) {
                                jsonGenerator.a("count");
                                jsonGenerator.b(a);
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            a = mutableFlatBuffer.g(i, 2);
                            if (a != 0) {
                                jsonGenerator.a("more_posts_query");
                                MorePostsQueryParser.m10361a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                            }
                            if (mutableFlatBuffer.g(i, 3) != 0) {
                                jsonGenerator.a("phrase");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                            }
                            a = mutableFlatBuffer.a(i, 4, 0);
                            if (a != 0) {
                                jsonGenerator.a("phrase_length");
                                jsonGenerator.b(a);
                            }
                            a = mutableFlatBuffer.a(i, 5, 0);
                            if (a != 0) {
                                jsonGenerator.a("phrase_offset");
                                jsonGenerator.b(a);
                            }
                            a = mutableFlatBuffer.g(i, 6);
                            if (a != 0) {
                                jsonGenerator.a("phrase_owner");
                                PhraseOwnerParser.m10363a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                            }
                            if (mutableFlatBuffer.g(i, 7) != 0) {
                                jsonGenerator.a("sample_text");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                            }
                            if (mutableFlatBuffer.g(i, 8) != 0) {
                                jsonGenerator.a("sentence");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m10366b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("node")) {
                                    iArr[0] = NodeParser.m10364a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m10367b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("node");
                            NodeParser.m10365a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m10368a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                        arrayList.add(Integer.valueOf(EdgesParser.m10366b(jsonParser, flatBufferBuilder)));
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

                public static void m10369a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("edges");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            EdgesParser.m10367b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.e();
                    }
                    jsonGenerator.g();
                }
            }

            public static int m10370a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("phrases")) {
                            iArr[0] = PhrasesParser.m10368a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m10371a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("phrases");
                    PhrasesParser.m10369a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m10372a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("phrases_analysis")) {
                        iArr[1] = PhrasesAnalysisParser.m10370a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
