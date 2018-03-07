package com.facebook.richdocument.model.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentFontResourceParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: photo_menu_uploads_models */
public class RichDocumentLinkCoversGraphQLParsers {

    /* compiled from: photo_menu_uploads_models */
    public final class InstantArticleLinkCoverConfigFragmentParser {

        /* compiled from: photo_menu_uploads_models */
        public final class LatestVersionParser {

            /* compiled from: photo_menu_uploads_models */
            public final class FeedCoverConfigParser {
                public static int m6682a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[15];
                    boolean[] zArr = new boolean[2];
                    boolean[] zArr2 = new boolean[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("bar_configs")) {
                                iArr[0] = RichDocumentNonTextConfigParser.m6692b(jsonParser, flatBufferBuilder);
                            } else if (i.equals("border_config")) {
                                iArr[1] = RichDocumentNonTextConfigParser.m6689a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("byline_area_config")) {
                                iArr[2] = RichDocumentNonTextConfigParser.m6689a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("byline_config")) {
                                iArr[3] = RichDocumentTextConfigParser.m6693a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("cover_image_config")) {
                                iArr[4] = RichDocumentNonTextConfigParser.m6689a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("custom_fonts")) {
                                iArr[5] = RichDocumentFontResourceParser.m6511a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("description_config")) {
                                iArr[6] = RichDocumentTextConfigParser.m6693a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("device_family")) {
                                iArr[7] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("fallback_feed_style")) {
                                iArr[8] = RichDocumentLinkCoverConfigFragmentParser.m6687a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("headline_config")) {
                                iArr[9] = RichDocumentTextConfigParser.m6693a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("layout_spec_version")) {
                                iArr[10] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("page_id")) {
                                iArr[11] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("show_bottom_gradient")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("show_top_gradient")) {
                                zArr[1] = true;
                                zArr2[1] = jsonParser.H();
                            } else if (i.equals("source_image_config")) {
                                iArr[14] = RichDocumentNonTextConfigParser.m6689a(jsonParser, flatBufferBuilder);
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
                    if (zArr[0]) {
                        flatBufferBuilder.a(12, zArr2[0]);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(13, zArr2[1]);
                    }
                    flatBufferBuilder.b(14, iArr[14]);
                    return flatBufferBuilder.d();
                }

                public static void m6683a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("bar_configs");
                        RichDocumentNonTextConfigParser.m6691a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("border_config");
                        RichDocumentNonTextConfigParser.m6690a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 2);
                    if (g != 0) {
                        jsonGenerator.a("byline_area_config");
                        RichDocumentNonTextConfigParser.m6690a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 3);
                    if (g != 0) {
                        jsonGenerator.a("byline_config");
                        RichDocumentTextConfigParser.m6694a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 4);
                    if (g != 0) {
                        jsonGenerator.a("cover_image_config");
                        RichDocumentNonTextConfigParser.m6690a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 5);
                    if (g != 0) {
                        jsonGenerator.a("custom_fonts");
                        RichDocumentFontResourceParser.m6513a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 6);
                    if (g != 0) {
                        jsonGenerator.a("description_config");
                        RichDocumentTextConfigParser.m6694a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 7) != 0) {
                        jsonGenerator.a("device_family");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                    }
                    g = mutableFlatBuffer.g(i, 8);
                    if (g != 0) {
                        jsonGenerator.a("fallback_feed_style");
                        RichDocumentLinkCoverConfigFragmentParser.m6688a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 9);
                    if (g != 0) {
                        jsonGenerator.a("headline_config");
                        RichDocumentTextConfigParser.m6694a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 10) != 0) {
                        jsonGenerator.a("layout_spec_version");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 10));
                    }
                    if (mutableFlatBuffer.g(i, 11) != 0) {
                        jsonGenerator.a("page_id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                    }
                    boolean a = mutableFlatBuffer.a(i, 12);
                    if (a) {
                        jsonGenerator.a("show_bottom_gradient");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 13);
                    if (a) {
                        jsonGenerator.a("show_top_gradient");
                        jsonGenerator.a(a);
                    }
                    g = mutableFlatBuffer.g(i, 14);
                    if (g != 0) {
                        jsonGenerator.a("source_image_config");
                        RichDocumentNonTextConfigParser.m6690a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m6684a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("feed_cover_config")) {
                            iArr[0] = FeedCoverConfigParser.m6682a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m6685a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("feed_cover_config");
                    FeedCoverConfigParser.m6683a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6686a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("latest_version")) {
                        iArr[1] = LatestVersionParser.m6684a(jsonParser, flatBufferBuilder);
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

    /* compiled from: photo_menu_uploads_models */
    public final class RichDocumentLinkCoverConfigFragmentParser {
        public static int m6687a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[14];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("bar_configs")) {
                        iArr[0] = RichDocumentNonTextConfigParser.m6692b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("border_config")) {
                        iArr[1] = RichDocumentNonTextConfigParser.m6689a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("byline_area_config")) {
                        iArr[2] = RichDocumentNonTextConfigParser.m6689a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("byline_config")) {
                        iArr[3] = RichDocumentTextConfigParser.m6693a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("cover_image_config")) {
                        iArr[4] = RichDocumentNonTextConfigParser.m6689a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("custom_fonts")) {
                        iArr[5] = RichDocumentFontResourceParser.m6511a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("description_config")) {
                        iArr[6] = RichDocumentTextConfigParser.m6693a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("device_family")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("headline_config")) {
                        iArr[8] = RichDocumentTextConfigParser.m6693a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("layout_spec_version")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("page_id")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("show_bottom_gradient")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("show_top_gradient")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("source_image_config")) {
                        iArr[13] = RichDocumentNonTextConfigParser.m6689a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(14);
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
            if (zArr[0]) {
                flatBufferBuilder.a(11, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(12, zArr2[1]);
            }
            flatBufferBuilder.b(13, iArr[13]);
            return flatBufferBuilder.d();
        }

        public static void m6688a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("bar_configs");
                RichDocumentNonTextConfigParser.m6691a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("border_config");
                RichDocumentNonTextConfigParser.m6690a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("byline_area_config");
                RichDocumentNonTextConfigParser.m6690a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("byline_config");
                RichDocumentTextConfigParser.m6694a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("cover_image_config");
                RichDocumentNonTextConfigParser.m6690a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("custom_fonts");
                RichDocumentFontResourceParser.m6513a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("description_config");
                RichDocumentTextConfigParser.m6694a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("device_family");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("headline_config");
                RichDocumentTextConfigParser.m6694a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("layout_spec_version");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("page_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            boolean a = mutableFlatBuffer.a(i, 11);
            if (a) {
                jsonGenerator.a("show_bottom_gradient");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 12);
            if (a) {
                jsonGenerator.a("show_top_gradient");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("source_image_config");
                RichDocumentNonTextConfigParser.m6690a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_menu_uploads_models */
    public final class RichDocumentNonTextConfigParser {
        public static int m6689a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("color")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("config_id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("horizontal_constraint")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("horizontal_position")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("show_border")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("url")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("vertical_constraint")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("vertical_position")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
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

        public static int m6692b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m6689a(jsonParser, flatBufferBuilder)));
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

        public static void m6691a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m6690a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
            }
            jsonGenerator.e();
        }

        public static void m6690a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("config_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("horizontal_constraint");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("horizontal_position");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            boolean a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("show_border");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("vertical_constraint");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("vertical_position");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_menu_uploads_models */
    public final class RichDocumentTextConfigParser {
        public static int m6693a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[15];
            boolean[] zArr = new boolean[7];
            boolean[] zArr2 = new boolean[1];
            double[] dArr = new double[6];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("font_family")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("horizontal_constraint")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("horizontal_position")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("max_color")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("max_font_size")) {
                        zArr[0] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("max_line_height")) {
                        zArr[1] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("max_word_kerning")) {
                        zArr[2] = true;
                        dArr[2] = jsonParser.G();
                    } else if (i.equals("min_color")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("min_font_size")) {
                        zArr[3] = true;
                        dArr[3] = jsonParser.G();
                    } else if (i.equals("min_line_height")) {
                        zArr[4] = true;
                        dArr[4] = jsonParser.G();
                    } else if (i.equals("min_word_kerning")) {
                        zArr[5] = true;
                        dArr[5] = jsonParser.G();
                    } else if (i.equals("morph_alignment")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("should_shadow")) {
                        zArr[6] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("vertical_constraint")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("vertical_position")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
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
            if (zArr[0]) {
                flatBufferBuilder.a(4, dArr[0], 0.0d);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(5, dArr[1], 0.0d);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(6, dArr[2], 0.0d);
            }
            flatBufferBuilder.b(7, iArr[7]);
            if (zArr[3]) {
                flatBufferBuilder.a(8, dArr[3], 0.0d);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(9, dArr[4], 0.0d);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(10, dArr[5], 0.0d);
            }
            flatBufferBuilder.b(11, iArr[11]);
            if (zArr[6]) {
                flatBufferBuilder.a(12, zArr2[0]);
            }
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            return flatBufferBuilder.d();
        }

        public static void m6694a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("font_family");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("horizontal_constraint");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("horizontal_position");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("max_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            double a = mutableFlatBuffer.a(i, 4, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("max_font_size");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 5, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("max_line_height");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 6, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("max_word_kerning");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("min_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            a = mutableFlatBuffer.a(i, 8, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("min_font_size");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 9, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("min_line_height");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 10, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("min_word_kerning");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("morph_alignment");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            boolean a2 = mutableFlatBuffer.a(i, 12);
            if (a2) {
                jsonGenerator.a("should_shadow");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("vertical_constraint");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("vertical_position");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            jsonGenerator.g();
        }
    }
}
