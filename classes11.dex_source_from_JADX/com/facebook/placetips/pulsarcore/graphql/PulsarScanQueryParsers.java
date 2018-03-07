package com.facebook.placetips.pulsarcore.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBeaconScanResultConfidenceLevel;
import com.facebook.graphql.enums.GraphQLPulsarScanQueryResultCode;
import com.facebook.placetips.common.graphql.PlaceTipWithReactionUnitsGraphQlFragmentParsers.PlaceTipWithReactionUnitsGraphQlFragmentParser;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentParsers.GravitySettingsGraphQlFragmentParser;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLParsers.PlaceTipsFeedUnitFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: The ViewPager adapter must implement SwipeImagePagerAdapter */
public class PulsarScanQueryParsers {

    /* compiled from: The ViewPager adapter must implement SwipeImagePagerAdapter */
    public final class PulsarScanQueryParser {

        /* compiled from: The ViewPager adapter must implement SwipeImagePagerAdapter */
        public final class BestGuessParser {

            /* compiled from: The ViewPager adapter must implement SwipeImagePagerAdapter */
            public final class PulsarParser {
                public static int m11249a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("page")) {
                                iArr[0] = PlaceTipWithReactionUnitsGraphQlFragmentParser.a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m11250a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("page");
                        PlaceTipWithReactionUnitsGraphQlFragmentParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m11251a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("pulsar")) {
                            iArr[0] = PulsarParser.m11249a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("rssi")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, iArr2[0], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m11252a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("pulsar");
                    PulsarParser.m11250a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 1, 0);
                if (g != 0) {
                    jsonGenerator.a("rssi");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m11253a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("best_guess")) {
                        iArr[0] = BestGuessParser.m11251a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("confidence_level")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLBeaconScanResultConfidenceLevel.fromString(jsonParser.o()));
                    } else if (i.equals("gravity_settings")) {
                        iArr[2] = GravitySettingsGraphQlFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("result_code")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLPulsarScanQueryResultCode.fromString(jsonParser.o()));
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: The ViewPager adapter must implement SwipeImagePagerAdapter */
    public final class SimplePulsarScanQueryParser {

        /* compiled from: The ViewPager adapter must implement SwipeImagePagerAdapter */
        public final class BestGuessParser {

            /* compiled from: The ViewPager adapter must implement SwipeImagePagerAdapter */
            public final class PulsarParser {

                /* compiled from: The ViewPager adapter must implement SwipeImagePagerAdapter */
                public final class PageParser {
                    public static int m11254a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[3];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("id")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("name")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("place_tips_feed_unit")) {
                                    iArr[2] = PlaceTipsFeedUnitFragmentParser.a(jsonParser, flatBufferBuilder);
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

                    public static void m11255a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        int g = mutableFlatBuffer.g(i, 2);
                        if (g != 0) {
                            jsonGenerator.a("place_tips_feed_unit");
                            PlaceTipsFeedUnitFragmentParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m11256a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("page")) {
                                iArr[0] = PageParser.m11254a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m11257a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("page");
                        PageParser.m11255a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m11258a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("pulsar")) {
                            iArr[0] = PulsarParser.m11256a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("rssi")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, iArr2[0], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m11259a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("pulsar");
                    PulsarParser.m11257a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 1, 0);
                if (g != 0) {
                    jsonGenerator.a("rssi");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m11260a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("best_guess")) {
                        iArr[0] = BestGuessParser.m11258a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("confidence_level")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLBeaconScanResultConfidenceLevel.fromString(jsonParser.o()));
                    } else if (i.equals("gravity_settings")) {
                        iArr[2] = GravitySettingsGraphQlFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("result_code")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLPulsarScanQueryResultCode.fromString(jsonParser.o()));
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
