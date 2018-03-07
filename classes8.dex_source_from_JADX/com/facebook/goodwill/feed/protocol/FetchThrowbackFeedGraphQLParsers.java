package com.facebook.goodwill.feed.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.goodwill.feed.protocol.ThrowbackFeedUnitsParsers.ThrowbackShareableParser;
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFeedUnitDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: fetchPageAccessToken */
public class FetchThrowbackFeedGraphQLParsers {

    /* compiled from: fetchPageAccessToken */
    public final class BirthdayThrowbackThemeFieldsParser {

        /* compiled from: fetchPageAccessToken */
        public final class SubtitleParser {
            public static int m15208a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15209a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetchPageAccessToken */
        public final class TitleParser {
            public static int m15210a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15211a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m15212a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("subtitle")) {
                        iArr[0] = SubtitleParser.m15208a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[1] = TitleParser.m15210a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetchPageAccessToken */
    public final class ThrowbackFeedFragmentParser {

        /* compiled from: fetchPageAccessToken */
        public final class AccentImagesParser {

            /* compiled from: fetchPageAccessToken */
            public final class NodesParser {
                public static int m15213b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("image")) {
                                iArr[1] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
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

                public static void m15214b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("image");
                        DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m15215a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(NodesParser.m15213b(jsonParser, flatBufferBuilder)));
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

            public static void m15216a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m15214b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetchPageAccessToken */
        public final class HeaderTextParser {
            public static int m15217a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15218a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetchPageAccessToken */
        public final class ThemeParser {
            public static int m15219a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[5];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("day_text_color")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("month_text_color")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("subtitle")) {
                            iArr[3] = SubtitleParser.m15208a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("title")) {
                            iArr[4] = TitleParser.m15210a(jsonParser, flatBufferBuilder);
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

            public static void m15220a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("day_text_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("month_text_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                int g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("subtitle");
                    SubtitleParser.m15209a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("title");
                    TitleParser.m15211a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetchPageAccessToken */
        public final class ThrowbackSettingsParser {
            public static int m15221a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("subscription_status")) {
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

            public static void m15222a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("subscription_status");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m15223a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[18];
            boolean[] zArr = new boolean[1];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("accent_images")) {
                        iArr[0] = AccentImagesParser.m15215a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("closing_image")) {
                        iArr[1] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("closing_text")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("header_decorative_image")) {
                        iArr[3] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_favicon")) {
                        iArr[4] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_text")) {
                        iArr[5] = HeaderTextParser.m15217a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("main_image")) {
                        iArr[6] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notice_button_color")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("notice_button_label")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("notice_image")) {
                        iArr[9] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("notice_subtitle")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("notice_title")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("notice_title_color")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("render_style")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("theme")) {
                        iArr[14] = ThemeParser.m15219a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("throwback_settings")) {
                        iArr[15] = ThrowbackSettingsParser.m15221a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("throwback_units")) {
                        iArr[16] = ThrowbackFeedUnitsConnectionFragmentParser.m15228a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title_date")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(18);
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
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            flatBufferBuilder.b(15, iArr[15]);
            flatBufferBuilder.b(16, iArr[16]);
            if (zArr[0]) {
                flatBufferBuilder.a(17, jArr[0], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m15224a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("accent_images");
                AccentImagesParser.m15216a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("closing_image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("closing_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("header_decorative_image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("header_favicon");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("header_text");
                HeaderTextParser.m15218a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("main_image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("notice_button_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("notice_button_label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("notice_image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("notice_subtitle");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("notice_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("notice_title_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("render_style");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("theme");
                ThemeParser.m15220a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("throwback_settings");
                ThrowbackSettingsParser.m15222a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("throwback_units");
                ThrowbackFeedUnitsConnectionFragmentParser.m15229a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            long a = mutableFlatBuffer.a(i, 17, 0);
            if (a != 0) {
                jsonGenerator.a("title_date");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetchPageAccessToken */
    public final class ThrowbackFeedQueryParser {
        public static MutableFlatBuffer m15225a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("throwback")) {
                        iArr[0] = ThrowbackFeedFragmentParser.m15223a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetchPageAccessToken */
    public final class ThrowbackFeedUnitEdgeParser {
        public static int m15226b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("node")) {
                        iArr[0] = GraphQLGoodwillThrowbackFeedUnitDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("section_key")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("shareable")) {
                        iArr[2] = ThrowbackShareableParser.m15276a(jsonParser, flatBufferBuilder);
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

        public static void m15227b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("node");
                GraphQLGoodwillThrowbackFeedUnitDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("section_key");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("shareable");
                ThrowbackShareableParser.m15277a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetchPageAccessToken */
    public final class ThrowbackFeedUnitsConnectionFragmentParser {
        public static int m15228a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("edges")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(ThrowbackFeedUnitEdgeParser.m15226b(jsonParser, flatBufferBuilder)));
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
                        iArr[1] = DefaultPageInfoFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("sections")) {
                        iArr[2] = ThrowbackSectionFragmentParser.m15237a(jsonParser, flatBufferBuilder);
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

        public static void m15229a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            int i2;
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("edges");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    ThrowbackFeedUnitEdgeParser.m15227b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("page_info");
                DefaultPageInfoFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("sections");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    ThrowbackSectionFragmentParser.m15239b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetchPageAccessToken */
    public final class ThrowbackMoreStoriesFragmentParser {
        public static int m15230a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("throwback_units")) {
                        iArr[0] = ThrowbackFeedUnitsConnectionFragmentParser.m15228a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m15231a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("throwback_units");
                ThrowbackFeedUnitsConnectionFragmentParser.m15229a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: fetchPageAccessToken */
    public final class ThrowbackMoreStoriesQueryParser {
        public static MutableFlatBuffer m15232a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("throwback")) {
                        iArr[0] = ThrowbackMoreStoriesFragmentParser.m15230a(jsonParser, flatBufferBuilder);
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

    /* compiled from: fetchPageAccessToken */
    public final class ThrowbackSectionFragmentParser {

        /* compiled from: fetchPageAccessToken */
        public final class SubtitleParser {
            public static int m15233a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15234a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: fetchPageAccessToken */
        public final class TitleParser {
            public static int m15235a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m15236a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m15238b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("key")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("subtitle")) {
                        iArr[1] = SubtitleParser.m15233a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[2] = TitleParser.m15235a(jsonParser, flatBufferBuilder);
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

        public static int m15237a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m15238b(jsonParser, flatBufferBuilder)));
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

        public static void m15239b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("key");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("subtitle");
                SubtitleParser.m15234a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("title");
                TitleParser.m15236a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }
}
