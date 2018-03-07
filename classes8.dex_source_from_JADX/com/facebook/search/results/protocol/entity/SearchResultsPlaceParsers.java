package com.facebook.search.results.protocol.entity;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: method/user.sendconfirmationcode */
public class SearchResultsPlaceParsers {

    /* compiled from: method/user.sendconfirmationcode */
    public final class SearchResultsPlaceParser {

        /* compiled from: method/user.sendconfirmationcode */
        public final class AddressParser {
            public static int m10090a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("single_line_full_address")) {
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

            public static void m10091a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("single_line_full_address");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: method/user.sendconfirmationcode */
        public final class LocationParser {
            public static int m10092a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[2];
                double[] dArr = new double[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("latitude")) {
                            zArr[0] = true;
                            dArr[0] = jsonParser.G();
                        } else if (i.equals("longitude")) {
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

            public static void m10093a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                double a = mutableFlatBuffer.a(i, 0, 0.0d);
                if (a != 0.0d) {
                    jsonGenerator.a("latitude");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0.0d);
                if (a != 0.0d) {
                    jsonGenerator.a("longitude");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: method/user.sendconfirmationcode */
        public final class OverallStarRatingParser {
            public static int m10094a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[2];
                int[] iArr = new int[1];
                double[] dArr = new double[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("rating_count")) {
                            zArr[0] = true;
                            iArr[0] = jsonParser.E();
                        } else if (i.equals("value")) {
                            zArr[1] = true;
                            dArr[0] = jsonParser.G();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, dArr[0], 0.0d);
                }
                return flatBufferBuilder.d();
            }

            public static void m10095a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("rating_count");
                    jsonGenerator.b(a);
                }
                double a2 = mutableFlatBuffer.a(i, 1, 0.0d);
                if (a2 != 0.0d) {
                    jsonGenerator.a("value");
                    jsonGenerator.a(a2);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: method/user.sendconfirmationcode */
        public final class PlaceOpenStatusParser {
            public static int m10096a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m10097a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m10098a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[13];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("address")) {
                        iArr[0] = AddressParser.m10090a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("category_names")) {
                        iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("expressed_as_place")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("id")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_verified")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("location")) {
                        iArr[5] = LocationParser.m10092a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("name")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("overall_star_rating")) {
                        iArr[7] = OverallStarRatingParser.m10094a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_open_status")) {
                        iArr[8] = PlaceOpenStatusParser.m10096a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_open_status_type")) {
                        iArr[9] = flatBufferBuilder.a(GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o()));
                    } else if (i.equals("price_range_description")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profile_picture")) {
                        iArr[11] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_saved_state")) {
                        iArr[12] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(13);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, zArr2[0]);
            }
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[1]) {
                flatBufferBuilder.a(4, zArr2[1]);
            }
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            return flatBufferBuilder.d();
        }

        public static void m10099a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("address");
                AddressParser.m10091a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("category_names");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 1), jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("expressed_as_place");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("is_verified");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("location");
                LocationParser.m10093a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("overall_star_rating");
                OverallStarRatingParser.m10095a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("place_open_status");
                PlaceOpenStatusParser.m10097a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("place_open_status_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 9));
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("price_range_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("profile_picture");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("viewer_saved_state");
                jsonGenerator.b(mutableFlatBuffer.b(i, 12));
            }
            jsonGenerator.g();
        }
    }
}
