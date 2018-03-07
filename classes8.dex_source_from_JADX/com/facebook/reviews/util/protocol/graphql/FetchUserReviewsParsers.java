package com.facebook.reviews.util.protocol.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultFeedbackFieldsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewBasicFieldsParser.ValueParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewCreationFieldsParser.CreatorParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewCreationFieldsParser.StoryParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewWithFeedbackParser.ReviewerContextParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.SelectedPrivacyOptionFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: profile_picture_overlay_launcher */
public class FetchUserReviewsParsers {

    /* compiled from: profile_picture_overlay_launcher */
    public final class FetchSingleReviewQueryParser {

        /* compiled from: profile_picture_overlay_launcher */
        public final class RepresentedProfileParser {
            public static int m5015a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
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

            public static void m5016a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static int m5017a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[11];
            boolean[] zArr = new boolean[2];
            int[] iArr2 = new int[1];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("creation_time")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("creator")) {
                        iArr[2] = CreatorParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[3] = DefaultFeedbackFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("page_rating")) {
                        zArr[1] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("privacy_scope")) {
                        iArr[6] = SelectedPrivacyOptionFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("represented_profile")) {
                        iArr[7] = RepresentedProfileParser.m5015a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reviewer_context")) {
                        iArr[8] = ReviewerContextParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("story")) {
                        iArr[9] = StoryParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("value")) {
                        iArr[10] = ValueParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, jArr[0], 0);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[1]) {
                flatBufferBuilder.a(5, iArr2[0], 0);
            }
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            return flatBufferBuilder.d();
        }

        public static void m5018a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            long a = mutableFlatBuffer.a(i, 1, 0);
            if (a != 0) {
                jsonGenerator.a("creation_time");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("creator");
                CreatorParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("feedback");
                DefaultFeedbackFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            g = mutableFlatBuffer.a(i, 5, 0);
            if (g != 0) {
                jsonGenerator.a("page_rating");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("privacy_scope");
                SelectedPrivacyOptionFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("represented_profile");
                RepresentedProfileParser.m5016a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("reviewer_context");
                ReviewerContextParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("story");
                StoryParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("value");
                ValueParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }
}
