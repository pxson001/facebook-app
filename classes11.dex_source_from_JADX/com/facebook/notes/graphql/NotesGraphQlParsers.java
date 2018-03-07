package com.facebook.notes.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedbackDeserializer;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentFormatVersion;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoFieldsParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBPageParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBPhotoParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBProfileParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentAuthorEdgeParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentSectionEdgeParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: UNKNOWN_TYPE */
public class NotesGraphQlParsers {

    /* compiled from: UNKNOWN_TYPE */
    public final class FBPrivacyScopeParser {
        public static int m11006a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("label")) {
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

        public static void m11007a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: UNKNOWN_TYPE */
    public final class NoteEdgeParser {

        /* compiled from: UNKNOWN_TYPE */
        public final class DocumentAuthorsParser {
            public static int m11008a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            iArr[0] = RichDocumentAuthorEdgeParser.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m11009a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    RichDocumentAuthorEdgeParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: UNKNOWN_TYPE */
        public final class DocumentBodyElementsParser {
            public static int m11010a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                            iArr[1] = RichDocumentSectionEdgeParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page_info")) {
                            iArr[2] = DefaultPageInfoFieldsParser.a(jsonParser, flatBufferBuilder);
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

            public static void m11011a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("edges");
                    RichDocumentSectionEdgeParser.a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.g(i, 2);
                if (a != 0) {
                    jsonGenerator.a("page_info");
                    DefaultPageInfoFieldsParser.a(mutableFlatBuffer, a, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m11012a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[15];
            boolean[] zArr = new boolean[2];
            long[] jArr = new long[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("copyright")) {
                        iArr[0] = RichDocumentTextParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("credits")) {
                        iArr[1] = RichDocumentTextParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_authors")) {
                        iArr[2] = DocumentAuthorsParser.m11008a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_body_elements")) {
                        iArr[3] = DocumentBodyElementsParser.m11010a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_description")) {
                        iArr[4] = RichDocumentTextParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_kicker")) {
                        iArr[5] = RichDocumentTextParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_owner")) {
                        iArr[6] = FBPageParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_subtitle")) {
                        iArr[7] = RichDocumentTextParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_title")) {
                        iArr[8] = RichDocumentTextParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[9] = GraphQLFeedbackDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback_options")) {
                        iArr[10] = flatBufferBuilder.a(GraphQLDocumentFeedbackOptions.fromString(jsonParser.o()));
                    } else if (i.equals("format_version")) {
                        iArr[11] = flatBufferBuilder.a(GraphQLDocumentFormatVersion.fromString(jsonParser.o()));
                    } else if (i.equals("id")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("modified_timestamp")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("publish_timestamp")) {
                        zArr[1] = true;
                        jArr[1] = jsonParser.F();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            if (zArr[0]) {
                flatBufferBuilder.a(13, jArr[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(14, jArr[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m11013a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("copyright");
                RichDocumentTextParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("credits");
                RichDocumentTextParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("document_authors");
                DocumentAuthorsParser.m11009a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("document_body_elements");
                DocumentBodyElementsParser.m11011a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("document_description");
                RichDocumentTextParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("document_kicker");
                RichDocumentTextParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("document_owner");
                FBPageParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("document_subtitle");
                RichDocumentTextParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("document_title");
                RichDocumentTextParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("feedback");
                GraphQLFeedbackDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("feedback_options");
                jsonGenerator.b(mutableFlatBuffer.b(i, 10));
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("format_version");
                jsonGenerator.b(mutableFlatBuffer.b(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            long a = mutableFlatBuffer.a(i, 13, 0);
            if (a != 0) {
                jsonGenerator.a("modified_timestamp");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 14, 0);
            if (a != 0) {
                jsonGenerator.a("publish_timestamp");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: UNKNOWN_TYPE */
    public final class NoteMasterParser {

        /* compiled from: UNKNOWN_TYPE */
        public final class CoverPhotoParser {

            /* compiled from: UNKNOWN_TYPE */
            public final class FocusParser {
                public static int m11014a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    boolean[] zArr = new boolean[2];
                    double[] dArr = new double[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("x")) {
                                zArr[0] = true;
                                dArr[0] = jsonParser.G();
                            } else if (i.equals("y")) {
                                zArr[1] = true;
                                dArr[1] = jsonParser.G();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(2);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, dArr[0], 0.0d);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(1, dArr[1], 0.0d);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m11015a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    double a = mutableFlatBuffer.a(i, 0, 0.0d);
                    if (a != 0.0d) {
                        jsonGenerator.a("x");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 1, 0.0d);
                    if (a != 0.0d) {
                        jsonGenerator.a("y");
                        jsonGenerator.a(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m11016a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("focus")) {
                            iArr[0] = FocusParser.m11014a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photo")) {
                            iArr[1] = FBPhotoParser.a(jsonParser, flatBufferBuilder);
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

            public static void m11017a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("focus");
                    FocusParser.m11015a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    FBPhotoParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m11018a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[7];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("cover_photo")) {
                        iArr[0] = CoverPhotoParser.m11016a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[1] = GraphQLFeedbackDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("from")) {
                        iArr[2] = FBProfileParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("privacy_scope")) {
                        iArr[4] = FBPrivacyScopeParser.m11006a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("published_document")) {
                        iArr[5] = NoteEdgeParser.m11012a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("url")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
