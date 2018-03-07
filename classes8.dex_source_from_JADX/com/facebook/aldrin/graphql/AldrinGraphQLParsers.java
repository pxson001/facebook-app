package com.facebook.aldrin.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLTosRegionCodeEnum;
import com.facebook.graphql.enums.GraphQLTosTransitionTypeEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: linear-gradient */
public class AldrinGraphQLParsers {

    /* compiled from: linear-gradient */
    public final class RegionTosRespondMutationParser {
        public static MutableFlatBuffer m12153a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("region_tos_status")) {
                        iArr[0] = RegionTosStatusFragmentParser.m12155a(jsonParser, flatBufferBuilder);
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

    /* compiled from: linear-gradient */
    public final class RegionTosStatusFragmentParser {

        /* compiled from: linear-gradient */
        public final class CurrentRegionTosLinksParser {
            public static int m12154a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("cookies_url")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("privacy_url")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("terms_url")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("tos_version")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
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
        }

        public static int m12155a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("current_region")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLTosRegionCodeEnum.fromString(jsonParser.o()));
                    } else if (i.equals("current_region_tos_links")) {
                        iArr[1] = CurrentRegionTosLinksParser.m12154a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("effective_region")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLTosRegionCodeEnum.fromString(jsonParser.o()));
                    } else if (i.equals("tos_transition_type")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLTosTransitionTypeEnum.fromString(jsonParser.o()));
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
    }
}
