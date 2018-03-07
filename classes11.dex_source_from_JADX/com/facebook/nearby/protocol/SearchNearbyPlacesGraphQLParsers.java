package com.facebook.nearby.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNearbySearchResultCategory;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyGeoRectangleParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: top_up_value_null */
public class SearchNearbyPlacesGraphQLParsers {

    /* compiled from: top_up_value_null */
    public final class SearchNearbyPlacesParser {

        /* compiled from: top_up_value_null */
        public final class ResultSectionsParser {

            /* compiled from: top_up_value_null */
            public final class EdgesParser {

                /* compiled from: top_up_value_null */
                public final class NodeParser {

                    /* compiled from: top_up_value_null */
                    public final class ResultsParser {

                        /* compiled from: top_up_value_null */
                        public final class ResultsEdgesParser {

                            /* compiled from: top_up_value_null */
                            public final class ResultsEdgesNodeParser {

                                /* compiled from: top_up_value_null */
                                public final class AddressParser {
                                    public static int m987a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        int[] iArr = new int[3];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("city")) {
                                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                                } else if (i.equals("full_address")) {
                                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                                } else if (i.equals("street")) {
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

                                    public static void m988a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        if (mutableFlatBuffer.g(i, 0) != 0) {
                                            jsonGenerator.a("city");
                                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                        }
                                        if (mutableFlatBuffer.g(i, 1) != 0) {
                                            jsonGenerator.a("full_address");
                                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                        }
                                        if (mutableFlatBuffer.g(i, 2) != 0) {
                                            jsonGenerator.a("street");
                                            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                public static int m989a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    int[] iArr = new int[13];
                                    boolean[] zArr = new boolean[4];
                                    boolean[] zArr2 = new boolean[2];
                                    int[] iArr2 = new int[1];
                                    double[] dArr = new double[1];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("__type__")) {
                                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                            } else if (i.equals("address")) {
                                                iArr[1] = AddressParser.m987a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("categories")) {
                                                iArr[2] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("does_viewer_like")) {
                                                zArr[0] = true;
                                                zArr2[0] = jsonParser.H();
                                            } else if (i.equals("id")) {
                                                iArr[4] = flatBufferBuilder.b(jsonParser.o());
                                            } else if (i.equals("is_owned")) {
                                                zArr[1] = true;
                                                zArr2[1] = jsonParser.H();
                                            } else if (i.equals("location")) {
                                                iArr[6] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("map_zoom_level")) {
                                                zArr[2] = true;
                                                iArr2[0] = jsonParser.E();
                                            } else if (i.equals("name")) {
                                                iArr[8] = flatBufferBuilder.b(jsonParser.o());
                                            } else if (i.equals("overall_rating")) {
                                                zArr[3] = true;
                                                dArr[0] = jsonParser.G();
                                            } else if (i.equals("place_type")) {
                                                iArr[10] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
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
                                    flatBufferBuilder.b(2, iArr[2]);
                                    if (zArr[0]) {
                                        flatBufferBuilder.a(3, zArr2[0]);
                                    }
                                    flatBufferBuilder.b(4, iArr[4]);
                                    if (zArr[1]) {
                                        flatBufferBuilder.a(5, zArr2[1]);
                                    }
                                    flatBufferBuilder.b(6, iArr[6]);
                                    if (zArr[2]) {
                                        flatBufferBuilder.a(7, iArr2[0], 0);
                                    }
                                    flatBufferBuilder.b(8, iArr[8]);
                                    if (zArr[3]) {
                                        flatBufferBuilder.a(9, dArr[0], 0.0d);
                                    }
                                    flatBufferBuilder.b(10, iArr[10]);
                                    flatBufferBuilder.b(11, iArr[11]);
                                    flatBufferBuilder.b(12, iArr[12]);
                                    return flatBufferBuilder.d();
                                }

                                public static void m990a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    jsonGenerator.f();
                                    if (mutableFlatBuffer.g(i, 0) != 0) {
                                        jsonGenerator.a("__type__");
                                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                                    }
                                    int g = mutableFlatBuffer.g(i, 1);
                                    if (g != 0) {
                                        jsonGenerator.a("address");
                                        AddressParser.m988a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    if (mutableFlatBuffer.g(i, 2) != 0) {
                                        jsonGenerator.a("categories");
                                        SerializerHelpers.a(mutableFlatBuffer.f(i, 2), jsonGenerator);
                                    }
                                    boolean a = mutableFlatBuffer.a(i, 3);
                                    if (a) {
                                        jsonGenerator.a("does_viewer_like");
                                        jsonGenerator.a(a);
                                    }
                                    if (mutableFlatBuffer.g(i, 4) != 0) {
                                        jsonGenerator.a("id");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                                    }
                                    a = mutableFlatBuffer.a(i, 5);
                                    if (a) {
                                        jsonGenerator.a("is_owned");
                                        jsonGenerator.a(a);
                                    }
                                    g = mutableFlatBuffer.g(i, 6);
                                    if (g != 0) {
                                        jsonGenerator.a("location");
                                        DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    g = mutableFlatBuffer.a(i, 7, 0);
                                    if (g != 0) {
                                        jsonGenerator.a("map_zoom_level");
                                        jsonGenerator.b(g);
                                    }
                                    if (mutableFlatBuffer.g(i, 8) != 0) {
                                        jsonGenerator.a("name");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 8));
                                    }
                                    double a2 = mutableFlatBuffer.a(i, 9, 0.0d);
                                    if (a2 != 0.0d) {
                                        jsonGenerator.a("overall_rating");
                                        jsonGenerator.a(a2);
                                    }
                                    if (mutableFlatBuffer.g(i, 10) != 0) {
                                        jsonGenerator.a("place_type");
                                        jsonGenerator.b(mutableFlatBuffer.b(i, 10));
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

                            public static int m991b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("node")) {
                                            iArr[0] = ResultsEdgesNodeParser.m989a(jsonParser, flatBufferBuilder);
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, iArr[0]);
                                return flatBufferBuilder.d();
                            }

                            public static void m992b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int g = mutableFlatBuffer.g(i, 0);
                                if (g != 0) {
                                    jsonGenerator.a("node");
                                    ResultsEdgesNodeParser.m990a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m993a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                                arrayList.add(Integer.valueOf(ResultsEdgesParser.m991b(jsonParser, flatBufferBuilder)));
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

                        public static void m994a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("edges");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    ResultsEdgesParser.m992b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.e();
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m995a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("result_category")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLNearbySearchResultCategory.fromString(jsonParser.o()));
                                } else if (i.equals("results")) {
                                    iArr[1] = ResultsParser.m993a(jsonParser, flatBufferBuilder);
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

                    public static void m996a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("result_category");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                        }
                        int g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("results");
                            ResultsParser.m994a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m997b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m995a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m998b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m996a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: top_up_value_null */
            public final class NodesParser {

                /* compiled from: top_up_value_null */
                public final class TopicSuggestionsParser {

                    /* compiled from: top_up_value_null */
                    public final class TopicSuggestionsNodesParser {

                        /* compiled from: top_up_value_null */
                        public final class TopicParser {
                            public static int m999a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[4];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("id")) {
                                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("location")) {
                                            iArr[1] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                                        } else if (i.equals("name")) {
                                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("url")) {
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

                            public static void m1000a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("id");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                int g = mutableFlatBuffer.g(i, 1);
                                if (g != 0) {
                                    jsonGenerator.a("location");
                                    DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                if (mutableFlatBuffer.g(i, 2) != 0) {
                                    jsonGenerator.a("name");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                                }
                                if (mutableFlatBuffer.g(i, 3) != 0) {
                                    jsonGenerator.a("url");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m1001b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[4];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("bounds")) {
                                        iArr[0] = NearbyGeoRectangleParser.m832a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("results_title")) {
                                        iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("suggestion_text")) {
                                        iArr[2] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("topic")) {
                                        iArr[3] = TopicParser.m999a(jsonParser, flatBufferBuilder);
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

                        public static void m1002b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("bounds");
                                NearbyGeoRectangleParser.m833a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.g(i, 1);
                            if (g != 0) {
                                jsonGenerator.a("results_title");
                                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.g(i, 2);
                            if (g != 0) {
                                jsonGenerator.a("suggestion_text");
                                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.g(i, 3);
                            if (g != 0) {
                                jsonGenerator.a("topic");
                                TopicParser.m1000a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m1003a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                            arrayList.add(Integer.valueOf(TopicSuggestionsNodesParser.m1001b(jsonParser, flatBufferBuilder)));
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

                    public static void m1004a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("nodes");
                            jsonGenerator.d();
                            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                TopicSuggestionsNodesParser.m1002b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                            }
                            jsonGenerator.e();
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m1006b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("result_category")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLNearbySearchResultCategory.fromString(jsonParser.o()));
                            } else if (i.equals("topic_suggestions")) {
                                iArr[1] = TopicSuggestionsParser.m1003a(jsonParser, flatBufferBuilder);
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

                public static int m1005a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(m1006b(jsonParser, flatBufferBuilder)));
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

                public static void m1007b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("result_category");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("topic_suggestions");
                        TopicSuggestionsParser.m1004a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m1008a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m997b(jsonParser, flatBufferBuilder)));
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
                        } else if (i.equals("nodes")) {
                            iArr[1] = NodesParser.m1005a(jsonParser, flatBufferBuilder);
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

            public static void m1009a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                int i2;
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m998b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m1007b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m1010a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("result_sections")) {
                        iArr[0] = ResultSectionsParser.m1008a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("search_session_id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
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
