package com.facebook.nearby.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.facebook.nearby.protocol.FetchNearbyPlacesGraphQLFragmentsParsers.NearbyFacepilesFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: traditional_composer */
public class NearbyTilesGraphQLParsers {

    /* compiled from: traditional_composer */
    public final class NearbyGeoRectangleParser {
        public static int m832a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            boolean[] zArr = new boolean[4];
            double[] dArr = new double[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("east")) {
                        zArr[0] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("north")) {
                        zArr[1] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("south")) {
                        zArr[2] = true;
                        dArr[2] = jsonParser.G();
                    } else if (i.equals("west")) {
                        zArr[3] = true;
                        dArr[3] = jsonParser.G();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            if (zArr[0]) {
                flatBufferBuilder.a(0, dArr[0], 0.0d);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, dArr[1], 0.0d);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(2, dArr[2], 0.0d);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(3, dArr[3], 0.0d);
            }
            return flatBufferBuilder.d();
        }

        public static void m833a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            double a = mutableFlatBuffer.a(i, 0, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("east");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("north");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 2, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("south");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 3, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("west");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: traditional_composer */
    public final class NearbyTilesParser {

        /* compiled from: traditional_composer */
        public final class TilesParser {

            /* compiled from: traditional_composer */
            public final class EdgesParser {

                /* compiled from: traditional_composer */
                public final class NodeParser {

                    /* compiled from: traditional_composer */
                    public final class PlacesRenderPriority1Parser {

                        /* compiled from: traditional_composer */
                        public final class PlacesRenderPriority1EdgesParser {

                            /* compiled from: traditional_composer */
                            public final class PlacesRenderPriority1EdgesNodeParser {

                                /* compiled from: traditional_composer */
                                public final class AddressParser {
                                    public static int m834a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                                    public static void m835a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

                                /* compiled from: traditional_composer */
                                public final class PageLikersParser {
                                    public static int m836a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        boolean[] zArr = new boolean[1];
                                        int[] iArr = new int[1];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("count")) {
                                                    zArr[0] = true;
                                                    iArr[0] = jsonParser.E();
                                                } else {
                                                    jsonParser.f();
                                                }
                                            }
                                        }
                                        flatBufferBuilder.c(1);
                                        if (zArr[0]) {
                                            flatBufferBuilder.a(0, iArr[0], 0);
                                        }
                                        return flatBufferBuilder.d();
                                    }

                                    public static void m837a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        int a = mutableFlatBuffer.a(i, 0, 0);
                                        if (a != 0) {
                                            jsonGenerator.a("count");
                                            jsonGenerator.b(a);
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                /* compiled from: traditional_composer */
                                public final class PageVisitsParser {
                                    public static int m838a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        boolean[] zArr = new boolean[1];
                                        int[] iArr = new int[1];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("count")) {
                                                    zArr[0] = true;
                                                    iArr[0] = jsonParser.E();
                                                } else {
                                                    jsonParser.f();
                                                }
                                            }
                                        }
                                        flatBufferBuilder.c(1);
                                        if (zArr[0]) {
                                            flatBufferBuilder.a(0, iArr[0], 0);
                                        }
                                        return flatBufferBuilder.d();
                                    }

                                    public static void m839a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        int a = mutableFlatBuffer.a(i, 0, 0);
                                        if (a != 0) {
                                            jsonGenerator.a("count");
                                            jsonGenerator.b(a);
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                /* compiled from: traditional_composer */
                                public final class PhoneNumberParser {
                                    public static int m840a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        int[] iArr = new int[1];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("universal_number")) {
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

                                    public static void m841a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        if (mutableFlatBuffer.g(i, 0) != 0) {
                                            jsonGenerator.a("universal_number");
                                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                /* compiled from: traditional_composer */
                                public final class ProfilePictureParser {
                                    public static int m842a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                                    public static void m843a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        if (mutableFlatBuffer.g(i, 0) != 0) {
                                            jsonGenerator.a("uri");
                                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                /* compiled from: traditional_composer */
                                public final class RatersParser {
                                    public static int m844a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        boolean[] zArr = new boolean[1];
                                        int[] iArr = new int[1];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("count")) {
                                                    zArr[0] = true;
                                                    iArr[0] = jsonParser.E();
                                                } else {
                                                    jsonParser.f();
                                                }
                                            }
                                        }
                                        flatBufferBuilder.c(1);
                                        if (zArr[0]) {
                                            flatBufferBuilder.a(0, iArr[0], 0);
                                        }
                                        return flatBufferBuilder.d();
                                    }

                                    public static void m845a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        int a = mutableFlatBuffer.a(i, 0, 0);
                                        if (a != 0) {
                                            jsonGenerator.a("count");
                                            jsonGenerator.b(a);
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                public static int m846a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    int[] iArr = new int[19];
                                    boolean[] zArr = new boolean[6];
                                    boolean[] zArr2 = new boolean[4];
                                    int[] iArr2 = new int[1];
                                    double[] dArr = new double[1];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("address")) {
                                                iArr[0] = AddressParser.m834a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("can_viewer_message")) {
                                                zArr[0] = true;
                                                zArr2[0] = jsonParser.H();
                                            } else if (i.equals("does_viewer_like")) {
                                                zArr[1] = true;
                                                zArr2[1] = jsonParser.H();
                                            } else if (i.equals("id")) {
                                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                            } else if (i.equals("is_owned")) {
                                                zArr[2] = true;
                                                zArr2[2] = jsonParser.H();
                                            } else if (i.equals("location")) {
                                                iArr[5] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("map_zoom_level")) {
                                                zArr[3] = true;
                                                iArr2[0] = jsonParser.E();
                                            } else if (i.equals("name")) {
                                                iArr[7] = flatBufferBuilder.b(jsonParser.o());
                                            } else if (i.equals("overall_rating")) {
                                                zArr[4] = true;
                                                dArr[0] = jsonParser.G();
                                            } else if (i.equals("page_likers")) {
                                                iArr[9] = PageLikersParser.m836a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("page_visits")) {
                                                iArr[10] = PageVisitsParser.m838a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("phone_number")) {
                                                iArr[11] = PhoneNumberParser.m840a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("place_type")) {
                                                iArr[12] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                                            } else if (i.equals("profile_picture")) {
                                                iArr[13] = ProfilePictureParser.m842a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("profile_picture_is_silhouette")) {
                                                zArr[5] = true;
                                                zArr2[3] = jsonParser.H();
                                            } else if (i.equals("raters")) {
                                                iArr[15] = RatersParser.m844a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("short_category_names")) {
                                                iArr[16] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("url")) {
                                                iArr[17] = flatBufferBuilder.b(jsonParser.o());
                                            } else if (i.equals("viewer_saved_state")) {
                                                iArr[18] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                                            } else {
                                                jsonParser.f();
                                            }
                                        }
                                    }
                                    flatBufferBuilder.c(19);
                                    flatBufferBuilder.b(0, iArr[0]);
                                    if (zArr[0]) {
                                        flatBufferBuilder.a(1, zArr2[0]);
                                    }
                                    if (zArr[1]) {
                                        flatBufferBuilder.a(2, zArr2[1]);
                                    }
                                    flatBufferBuilder.b(3, iArr[3]);
                                    if (zArr[2]) {
                                        flatBufferBuilder.a(4, zArr2[2]);
                                    }
                                    flatBufferBuilder.b(5, iArr[5]);
                                    if (zArr[3]) {
                                        flatBufferBuilder.a(6, iArr2[0], 0);
                                    }
                                    flatBufferBuilder.b(7, iArr[7]);
                                    if (zArr[4]) {
                                        flatBufferBuilder.a(8, dArr[0], 0.0d);
                                    }
                                    flatBufferBuilder.b(9, iArr[9]);
                                    flatBufferBuilder.b(10, iArr[10]);
                                    flatBufferBuilder.b(11, iArr[11]);
                                    flatBufferBuilder.b(12, iArr[12]);
                                    flatBufferBuilder.b(13, iArr[13]);
                                    if (zArr[5]) {
                                        flatBufferBuilder.a(14, zArr2[3]);
                                    }
                                    flatBufferBuilder.b(15, iArr[15]);
                                    flatBufferBuilder.b(16, iArr[16]);
                                    flatBufferBuilder.b(17, iArr[17]);
                                    flatBufferBuilder.b(18, iArr[18]);
                                    return flatBufferBuilder.d();
                                }

                                public static void m847a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    jsonGenerator.f();
                                    int g = mutableFlatBuffer.g(i, 0);
                                    if (g != 0) {
                                        jsonGenerator.a("address");
                                        AddressParser.m835a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    boolean a = mutableFlatBuffer.a(i, 1);
                                    if (a) {
                                        jsonGenerator.a("can_viewer_message");
                                        jsonGenerator.a(a);
                                    }
                                    a = mutableFlatBuffer.a(i, 2);
                                    if (a) {
                                        jsonGenerator.a("does_viewer_like");
                                        jsonGenerator.a(a);
                                    }
                                    if (mutableFlatBuffer.g(i, 3) != 0) {
                                        jsonGenerator.a("id");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                                    }
                                    a = mutableFlatBuffer.a(i, 4);
                                    if (a) {
                                        jsonGenerator.a("is_owned");
                                        jsonGenerator.a(a);
                                    }
                                    g = mutableFlatBuffer.g(i, 5);
                                    if (g != 0) {
                                        jsonGenerator.a("location");
                                        DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    g = mutableFlatBuffer.a(i, 6, 0);
                                    if (g != 0) {
                                        jsonGenerator.a("map_zoom_level");
                                        jsonGenerator.b(g);
                                    }
                                    if (mutableFlatBuffer.g(i, 7) != 0) {
                                        jsonGenerator.a("name");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                                    }
                                    double a2 = mutableFlatBuffer.a(i, 8, 0.0d);
                                    if (a2 != 0.0d) {
                                        jsonGenerator.a("overall_rating");
                                        jsonGenerator.a(a2);
                                    }
                                    g = mutableFlatBuffer.g(i, 9);
                                    if (g != 0) {
                                        jsonGenerator.a("page_likers");
                                        PageLikersParser.m837a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    g = mutableFlatBuffer.g(i, 10);
                                    if (g != 0) {
                                        jsonGenerator.a("page_visits");
                                        PageVisitsParser.m839a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    g = mutableFlatBuffer.g(i, 11);
                                    if (g != 0) {
                                        jsonGenerator.a("phone_number");
                                        PhoneNumberParser.m841a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    if (mutableFlatBuffer.g(i, 12) != 0) {
                                        jsonGenerator.a("place_type");
                                        jsonGenerator.b(mutableFlatBuffer.b(i, 12));
                                    }
                                    g = mutableFlatBuffer.g(i, 13);
                                    if (g != 0) {
                                        jsonGenerator.a("profile_picture");
                                        ProfilePictureParser.m843a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    a = mutableFlatBuffer.a(i, 14);
                                    if (a) {
                                        jsonGenerator.a("profile_picture_is_silhouette");
                                        jsonGenerator.a(a);
                                    }
                                    g = mutableFlatBuffer.g(i, 15);
                                    if (g != 0) {
                                        jsonGenerator.a("raters");
                                        RatersParser.m845a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    if (mutableFlatBuffer.g(i, 16) != 0) {
                                        jsonGenerator.a("short_category_names");
                                        SerializerHelpers.a(mutableFlatBuffer.f(i, 16), jsonGenerator);
                                    }
                                    if (mutableFlatBuffer.g(i, 17) != 0) {
                                        jsonGenerator.a("url");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 17));
                                    }
                                    if (mutableFlatBuffer.g(i, 18) != 0) {
                                        jsonGenerator.a("viewer_saved_state");
                                        jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            /* compiled from: traditional_composer */
                            public final class SocialContextParser {
                                public static int m848a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                                public static void m849a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                    jsonGenerator.f();
                                    if (mutableFlatBuffer.g(i, 0) != 0) {
                                        jsonGenerator.a("text");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            public static int m850b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[4];
                                boolean[] zArr = new boolean[1];
                                double[] dArr = new double[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("node")) {
                                            iArr[0] = PlacesRenderPriority1EdgesNodeParser.m846a(jsonParser, flatBufferBuilder);
                                        } else if (i.equals("result_decoration")) {
                                            iArr[1] = NearbyFacepilesFragmentParser.m643a(jsonParser, flatBufferBuilder);
                                        } else if (i.equals("search_score")) {
                                            zArr[0] = true;
                                            dArr[0] = jsonParser.G();
                                        } else if (i.equals("social_context")) {
                                            iArr[3] = SocialContextParser.m848a(jsonParser, flatBufferBuilder);
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(4);
                                flatBufferBuilder.b(0, iArr[0]);
                                flatBufferBuilder.b(1, iArr[1]);
                                if (zArr[0]) {
                                    flatBufferBuilder.a(2, dArr[0], 0.0d);
                                }
                                flatBufferBuilder.b(3, iArr[3]);
                                return flatBufferBuilder.d();
                            }

                            public static void m851b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int g = mutableFlatBuffer.g(i, 0);
                                if (g != 0) {
                                    jsonGenerator.a("node");
                                    PlacesRenderPriority1EdgesNodeParser.m847a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                g = mutableFlatBuffer.g(i, 1);
                                if (g != 0) {
                                    jsonGenerator.a("result_decoration");
                                    NearbyFacepilesFragmentParser.m644a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                double a = mutableFlatBuffer.a(i, 2, 0.0d);
                                if (a != 0.0d) {
                                    jsonGenerator.a("search_score");
                                    jsonGenerator.a(a);
                                }
                                g = mutableFlatBuffer.g(i, 3);
                                if (g != 0) {
                                    jsonGenerator.a("social_context");
                                    SocialContextParser.m849a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m852a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                                arrayList.add(Integer.valueOf(PlacesRenderPriority1EdgesParser.m850b(jsonParser, flatBufferBuilder)));
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

                        public static void m853a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("edges");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    PlacesRenderPriority1EdgesParser.m851b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.e();
                            }
                            jsonGenerator.g();
                        }
                    }

                    /* compiled from: traditional_composer */
                    public final class PlacesRenderPriority2Parser {

                        /* compiled from: traditional_composer */
                        public final class PlacesRenderPriority2EdgesParser {

                            /* compiled from: traditional_composer */
                            public final class PlacesRenderPriority2EdgesNodeParser {

                                /* compiled from: traditional_composer */
                                public final class AddressParser {
                                    public static int m854a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                                    public static void m855a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

                                /* compiled from: traditional_composer */
                                public final class PageLikersParser {
                                    public static int m856a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        boolean[] zArr = new boolean[1];
                                        int[] iArr = new int[1];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("count")) {
                                                    zArr[0] = true;
                                                    iArr[0] = jsonParser.E();
                                                } else {
                                                    jsonParser.f();
                                                }
                                            }
                                        }
                                        flatBufferBuilder.c(1);
                                        if (zArr[0]) {
                                            flatBufferBuilder.a(0, iArr[0], 0);
                                        }
                                        return flatBufferBuilder.d();
                                    }

                                    public static void m857a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        int a = mutableFlatBuffer.a(i, 0, 0);
                                        if (a != 0) {
                                            jsonGenerator.a("count");
                                            jsonGenerator.b(a);
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                /* compiled from: traditional_composer */
                                public final class PageVisitsParser {
                                    public static int m858a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        boolean[] zArr = new boolean[1];
                                        int[] iArr = new int[1];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("count")) {
                                                    zArr[0] = true;
                                                    iArr[0] = jsonParser.E();
                                                } else {
                                                    jsonParser.f();
                                                }
                                            }
                                        }
                                        flatBufferBuilder.c(1);
                                        if (zArr[0]) {
                                            flatBufferBuilder.a(0, iArr[0], 0);
                                        }
                                        return flatBufferBuilder.d();
                                    }

                                    public static void m859a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        int a = mutableFlatBuffer.a(i, 0, 0);
                                        if (a != 0) {
                                            jsonGenerator.a("count");
                                            jsonGenerator.b(a);
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                /* compiled from: traditional_composer */
                                public final class PhoneNumberParser {
                                    public static int m860a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        int[] iArr = new int[1];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("universal_number")) {
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

                                    public static void m861a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        if (mutableFlatBuffer.g(i, 0) != 0) {
                                            jsonGenerator.a("universal_number");
                                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                /* compiled from: traditional_composer */
                                public final class ProfilePictureParser {
                                    public static int m862a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                                    public static void m863a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        if (mutableFlatBuffer.g(i, 0) != 0) {
                                            jsonGenerator.a("uri");
                                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                /* compiled from: traditional_composer */
                                public final class RatersParser {
                                    public static int m864a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        boolean[] zArr = new boolean[1];
                                        int[] iArr = new int[1];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("count")) {
                                                    zArr[0] = true;
                                                    iArr[0] = jsonParser.E();
                                                } else {
                                                    jsonParser.f();
                                                }
                                            }
                                        }
                                        flatBufferBuilder.c(1);
                                        if (zArr[0]) {
                                            flatBufferBuilder.a(0, iArr[0], 0);
                                        }
                                        return flatBufferBuilder.d();
                                    }

                                    public static void m865a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        int a = mutableFlatBuffer.a(i, 0, 0);
                                        if (a != 0) {
                                            jsonGenerator.a("count");
                                            jsonGenerator.b(a);
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                public static int m866a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    int[] iArr = new int[19];
                                    boolean[] zArr = new boolean[6];
                                    boolean[] zArr2 = new boolean[4];
                                    int[] iArr2 = new int[1];
                                    double[] dArr = new double[1];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("address")) {
                                                iArr[0] = AddressParser.m854a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("can_viewer_message")) {
                                                zArr[0] = true;
                                                zArr2[0] = jsonParser.H();
                                            } else if (i.equals("does_viewer_like")) {
                                                zArr[1] = true;
                                                zArr2[1] = jsonParser.H();
                                            } else if (i.equals("id")) {
                                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                            } else if (i.equals("is_owned")) {
                                                zArr[2] = true;
                                                zArr2[2] = jsonParser.H();
                                            } else if (i.equals("location")) {
                                                iArr[5] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("map_zoom_level")) {
                                                zArr[3] = true;
                                                iArr2[0] = jsonParser.E();
                                            } else if (i.equals("name")) {
                                                iArr[7] = flatBufferBuilder.b(jsonParser.o());
                                            } else if (i.equals("overall_rating")) {
                                                zArr[4] = true;
                                                dArr[0] = jsonParser.G();
                                            } else if (i.equals("page_likers")) {
                                                iArr[9] = PageLikersParser.m856a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("page_visits")) {
                                                iArr[10] = PageVisitsParser.m858a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("phone_number")) {
                                                iArr[11] = PhoneNumberParser.m860a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("place_type")) {
                                                iArr[12] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                                            } else if (i.equals("profile_picture")) {
                                                iArr[13] = ProfilePictureParser.m862a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("profile_picture_is_silhouette")) {
                                                zArr[5] = true;
                                                zArr2[3] = jsonParser.H();
                                            } else if (i.equals("raters")) {
                                                iArr[15] = RatersParser.m864a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("short_category_names")) {
                                                iArr[16] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("url")) {
                                                iArr[17] = flatBufferBuilder.b(jsonParser.o());
                                            } else if (i.equals("viewer_saved_state")) {
                                                iArr[18] = flatBufferBuilder.a(GraphQLSavedState.fromString(jsonParser.o()));
                                            } else {
                                                jsonParser.f();
                                            }
                                        }
                                    }
                                    flatBufferBuilder.c(19);
                                    flatBufferBuilder.b(0, iArr[0]);
                                    if (zArr[0]) {
                                        flatBufferBuilder.a(1, zArr2[0]);
                                    }
                                    if (zArr[1]) {
                                        flatBufferBuilder.a(2, zArr2[1]);
                                    }
                                    flatBufferBuilder.b(3, iArr[3]);
                                    if (zArr[2]) {
                                        flatBufferBuilder.a(4, zArr2[2]);
                                    }
                                    flatBufferBuilder.b(5, iArr[5]);
                                    if (zArr[3]) {
                                        flatBufferBuilder.a(6, iArr2[0], 0);
                                    }
                                    flatBufferBuilder.b(7, iArr[7]);
                                    if (zArr[4]) {
                                        flatBufferBuilder.a(8, dArr[0], 0.0d);
                                    }
                                    flatBufferBuilder.b(9, iArr[9]);
                                    flatBufferBuilder.b(10, iArr[10]);
                                    flatBufferBuilder.b(11, iArr[11]);
                                    flatBufferBuilder.b(12, iArr[12]);
                                    flatBufferBuilder.b(13, iArr[13]);
                                    if (zArr[5]) {
                                        flatBufferBuilder.a(14, zArr2[3]);
                                    }
                                    flatBufferBuilder.b(15, iArr[15]);
                                    flatBufferBuilder.b(16, iArr[16]);
                                    flatBufferBuilder.b(17, iArr[17]);
                                    flatBufferBuilder.b(18, iArr[18]);
                                    return flatBufferBuilder.d();
                                }

                                public static void m867a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    jsonGenerator.f();
                                    int g = mutableFlatBuffer.g(i, 0);
                                    if (g != 0) {
                                        jsonGenerator.a("address");
                                        AddressParser.m855a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    boolean a = mutableFlatBuffer.a(i, 1);
                                    if (a) {
                                        jsonGenerator.a("can_viewer_message");
                                        jsonGenerator.a(a);
                                    }
                                    a = mutableFlatBuffer.a(i, 2);
                                    if (a) {
                                        jsonGenerator.a("does_viewer_like");
                                        jsonGenerator.a(a);
                                    }
                                    if (mutableFlatBuffer.g(i, 3) != 0) {
                                        jsonGenerator.a("id");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                                    }
                                    a = mutableFlatBuffer.a(i, 4);
                                    if (a) {
                                        jsonGenerator.a("is_owned");
                                        jsonGenerator.a(a);
                                    }
                                    g = mutableFlatBuffer.g(i, 5);
                                    if (g != 0) {
                                        jsonGenerator.a("location");
                                        DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    g = mutableFlatBuffer.a(i, 6, 0);
                                    if (g != 0) {
                                        jsonGenerator.a("map_zoom_level");
                                        jsonGenerator.b(g);
                                    }
                                    if (mutableFlatBuffer.g(i, 7) != 0) {
                                        jsonGenerator.a("name");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                                    }
                                    double a2 = mutableFlatBuffer.a(i, 8, 0.0d);
                                    if (a2 != 0.0d) {
                                        jsonGenerator.a("overall_rating");
                                        jsonGenerator.a(a2);
                                    }
                                    g = mutableFlatBuffer.g(i, 9);
                                    if (g != 0) {
                                        jsonGenerator.a("page_likers");
                                        PageLikersParser.m857a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    g = mutableFlatBuffer.g(i, 10);
                                    if (g != 0) {
                                        jsonGenerator.a("page_visits");
                                        PageVisitsParser.m859a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    g = mutableFlatBuffer.g(i, 11);
                                    if (g != 0) {
                                        jsonGenerator.a("phone_number");
                                        PhoneNumberParser.m861a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    if (mutableFlatBuffer.g(i, 12) != 0) {
                                        jsonGenerator.a("place_type");
                                        jsonGenerator.b(mutableFlatBuffer.b(i, 12));
                                    }
                                    g = mutableFlatBuffer.g(i, 13);
                                    if (g != 0) {
                                        jsonGenerator.a("profile_picture");
                                        ProfilePictureParser.m863a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    a = mutableFlatBuffer.a(i, 14);
                                    if (a) {
                                        jsonGenerator.a("profile_picture_is_silhouette");
                                        jsonGenerator.a(a);
                                    }
                                    g = mutableFlatBuffer.g(i, 15);
                                    if (g != 0) {
                                        jsonGenerator.a("raters");
                                        RatersParser.m865a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    if (mutableFlatBuffer.g(i, 16) != 0) {
                                        jsonGenerator.a("short_category_names");
                                        SerializerHelpers.a(mutableFlatBuffer.f(i, 16), jsonGenerator);
                                    }
                                    if (mutableFlatBuffer.g(i, 17) != 0) {
                                        jsonGenerator.a("url");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 17));
                                    }
                                    if (mutableFlatBuffer.g(i, 18) != 0) {
                                        jsonGenerator.a("viewer_saved_state");
                                        jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            /* compiled from: traditional_composer */
                            public final class SocialContextParser {
                                public static int m868a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                                public static void m869a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                    jsonGenerator.f();
                                    if (mutableFlatBuffer.g(i, 0) != 0) {
                                        jsonGenerator.a("text");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            public static int m870b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[4];
                                boolean[] zArr = new boolean[1];
                                double[] dArr = new double[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("node")) {
                                            iArr[0] = PlacesRenderPriority2EdgesNodeParser.m866a(jsonParser, flatBufferBuilder);
                                        } else if (i.equals("result_decoration")) {
                                            iArr[1] = NearbyFacepilesFragmentParser.m643a(jsonParser, flatBufferBuilder);
                                        } else if (i.equals("search_score")) {
                                            zArr[0] = true;
                                            dArr[0] = jsonParser.G();
                                        } else if (i.equals("social_context")) {
                                            iArr[3] = SocialContextParser.m868a(jsonParser, flatBufferBuilder);
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(4);
                                flatBufferBuilder.b(0, iArr[0]);
                                flatBufferBuilder.b(1, iArr[1]);
                                if (zArr[0]) {
                                    flatBufferBuilder.a(2, dArr[0], 0.0d);
                                }
                                flatBufferBuilder.b(3, iArr[3]);
                                return flatBufferBuilder.d();
                            }

                            public static void m871b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int g = mutableFlatBuffer.g(i, 0);
                                if (g != 0) {
                                    jsonGenerator.a("node");
                                    PlacesRenderPriority2EdgesNodeParser.m867a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                g = mutableFlatBuffer.g(i, 1);
                                if (g != 0) {
                                    jsonGenerator.a("result_decoration");
                                    NearbyFacepilesFragmentParser.m644a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                double a = mutableFlatBuffer.a(i, 2, 0.0d);
                                if (a != 0.0d) {
                                    jsonGenerator.a("search_score");
                                    jsonGenerator.a(a);
                                }
                                g = mutableFlatBuffer.g(i, 3);
                                if (g != 0) {
                                    jsonGenerator.a("social_context");
                                    SocialContextParser.m869a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m872a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                                arrayList.add(Integer.valueOf(PlacesRenderPriority2EdgesParser.m870b(jsonParser, flatBufferBuilder)));
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

                        public static void m873a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("edges");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    PlacesRenderPriority2EdgesParser.m871b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.e();
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m874a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[8];
                        boolean[] zArr = new boolean[4];
                        int[] iArr2 = new int[1];
                        long[] jArr = new long[1];
                        double[] dArr = new double[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("bounds")) {
                                    iArr[0] = NearbyGeoRectangleParser.m832a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("creation_time")) {
                                    zArr[0] = true;
                                    jArr[0] = jsonParser.F();
                                } else if (i.equals("max_zoom")) {
                                    zArr[1] = true;
                                    dArr[0] = jsonParser.G();
                                } else if (i.equals("min_zoom")) {
                                    zArr[2] = true;
                                    dArr[1] = jsonParser.G();
                                } else if (i.equals("placesRenderPriority1")) {
                                    iArr[4] = PlacesRenderPriority1Parser.m852a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("placesRenderPriority2")) {
                                    iArr[5] = PlacesRenderPriority2Parser.m872a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("tile_key")) {
                                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("ttl")) {
                                    zArr[3] = true;
                                    iArr2[0] = jsonParser.E();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(8);
                        flatBufferBuilder.b(0, iArr[0]);
                        if (zArr[0]) {
                            flatBufferBuilder.a(1, jArr[0], 0);
                        }
                        if (zArr[1]) {
                            flatBufferBuilder.a(2, dArr[0], 0.0d);
                        }
                        if (zArr[2]) {
                            flatBufferBuilder.a(3, dArr[1], 0.0d);
                        }
                        flatBufferBuilder.b(4, iArr[4]);
                        flatBufferBuilder.b(5, iArr[5]);
                        flatBufferBuilder.b(6, iArr[6]);
                        if (zArr[3]) {
                            flatBufferBuilder.a(7, iArr2[0], 0);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m875a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("bounds");
                            NearbyGeoRectangleParser.m833a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        long a = mutableFlatBuffer.a(i, 1, 0);
                        if (a != 0) {
                            jsonGenerator.a("creation_time");
                            jsonGenerator.a(a);
                        }
                        double a2 = mutableFlatBuffer.a(i, 2, 0.0d);
                        if (a2 != 0.0d) {
                            jsonGenerator.a("max_zoom");
                            jsonGenerator.a(a2);
                        }
                        a2 = mutableFlatBuffer.a(i, 3, 0.0d);
                        if (a2 != 0.0d) {
                            jsonGenerator.a("min_zoom");
                            jsonGenerator.a(a2);
                        }
                        g = mutableFlatBuffer.g(i, 4);
                        if (g != 0) {
                            jsonGenerator.a("placesRenderPriority1");
                            PlacesRenderPriority1Parser.m853a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        g = mutableFlatBuffer.g(i, 5);
                        if (g != 0) {
                            jsonGenerator.a("placesRenderPriority2");
                            PlacesRenderPriority2Parser.m873a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        if (mutableFlatBuffer.g(i, 6) != 0) {
                            jsonGenerator.a("tile_key");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                        }
                        g = mutableFlatBuffer.a(i, 7, 0);
                        if (g != 0) {
                            jsonGenerator.a("ttl");
                            jsonGenerator.b(g);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m876b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m874a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m877b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m875a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m878a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("canonicalization")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("display_region_hint")) {
                            iArr[1] = NearbyGeoRectangleParser.m832a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m876b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr2 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr2, true);
                            }
                            iArr[2] = i2;
                        } else if (i.equals("version")) {
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

            public static void m879a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("canonicalization");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("display_region_hint");
                    NearbyGeoRectangleParser.m833a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m877b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("version");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m880a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("search_session_key")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("tiles")) {
                        iArr[1] = TilesParser.m878a(jsonParser, flatBufferBuilder);
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
