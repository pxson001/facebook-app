package com.facebook.video.livemap.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: extra_dashboard_filter_type */
public class LiveMapVideosGraphQLParsers {

    /* compiled from: extra_dashboard_filter_type */
    public final class LiveMapVideosQueryParser {

        /* compiled from: extra_dashboard_filter_type */
        public final class VideosParser {

            /* compiled from: extra_dashboard_filter_type */
            public final class EdgesParser {

                /* compiled from: extra_dashboard_filter_type */
                public final class NodeParser {

                    /* compiled from: extra_dashboard_filter_type */
                    public final class LocationParser {
                        public static int m12986a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                        public static void m12987a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

                    /* compiled from: extra_dashboard_filter_type */
                    public final class VideoParser {

                        /* compiled from: extra_dashboard_filter_type */
                        public final class CreationStoryParser {
                            public static int m12988a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("id")) {
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

                            public static void m12989a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("id");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: extra_dashboard_filter_type */
                        public final class OwnerParser {
                            public static int m12990a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[2];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("__type__")) {
                                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                        } else if (i.equals("name")) {
                                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
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

                            public static void m12991a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("__type__");
                                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                                }
                                if (mutableFlatBuffer.g(i, 1) != 0) {
                                    jsonGenerator.a("name");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: extra_dashboard_filter_type */
                        public final class SavableDescriptionParser {
                            public static int m12992a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                            public static void m12993a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("text");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m12994a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[12];
                            boolean[] zArr = new boolean[6];
                            boolean[] zArr2 = new boolean[2];
                            int[] iArr2 = new int[3];
                            long[] jArr = new long[1];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("created_time")) {
                                        zArr[0] = true;
                                        jArr[0] = jsonParser.F();
                                    } else if (i.equals("creation_story")) {
                                        iArr[1] = CreationStoryParser.m12988a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("height")) {
                                        zArr[1] = true;
                                        iArr2[0] = jsonParser.E();
                                    } else if (i.equals("id")) {
                                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("is_expired")) {
                                        zArr[2] = true;
                                        zArr2[0] = jsonParser.H();
                                    } else if (i.equals("is_playable")) {
                                        zArr[3] = true;
                                        zArr2[1] = jsonParser.H();
                                    } else if (i.equals("owner")) {
                                        iArr[6] = OwnerParser.m12990a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("playable_duration")) {
                                        zArr[4] = true;
                                        iArr2[1] = jsonParser.E();
                                    } else if (i.equals("playable_url")) {
                                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("savable_description")) {
                                        iArr[9] = SavableDescriptionParser.m12992a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("url")) {
                                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("width")) {
                                        zArr[5] = true;
                                        iArr2[2] = jsonParser.E();
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(12);
                            if (zArr[0]) {
                                flatBufferBuilder.a(0, jArr[0], 0);
                            }
                            flatBufferBuilder.b(1, iArr[1]);
                            if (zArr[1]) {
                                flatBufferBuilder.a(2, iArr2[0], 0);
                            }
                            flatBufferBuilder.b(3, iArr[3]);
                            if (zArr[2]) {
                                flatBufferBuilder.a(4, zArr2[0]);
                            }
                            if (zArr[3]) {
                                flatBufferBuilder.a(5, zArr2[1]);
                            }
                            flatBufferBuilder.b(6, iArr[6]);
                            if (zArr[4]) {
                                flatBufferBuilder.a(7, iArr2[1], 0);
                            }
                            flatBufferBuilder.b(8, iArr[8]);
                            flatBufferBuilder.b(9, iArr[9]);
                            flatBufferBuilder.b(10, iArr[10]);
                            if (zArr[5]) {
                                flatBufferBuilder.a(11, iArr2[2], 0);
                            }
                            return flatBufferBuilder.d();
                        }

                        public static void m12995a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            long a = mutableFlatBuffer.a(i, 0, 0);
                            if (a != 0) {
                                jsonGenerator.a("created_time");
                                jsonGenerator.a(a);
                            }
                            int g = mutableFlatBuffer.g(i, 1);
                            if (g != 0) {
                                jsonGenerator.a("creation_story");
                                CreationStoryParser.m12989a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.a(i, 2, 0);
                            if (g != 0) {
                                jsonGenerator.a("height");
                                jsonGenerator.b(g);
                            }
                            if (mutableFlatBuffer.g(i, 3) != 0) {
                                jsonGenerator.a("id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                            }
                            boolean a2 = mutableFlatBuffer.a(i, 4);
                            if (a2) {
                                jsonGenerator.a("is_expired");
                                jsonGenerator.a(a2);
                            }
                            a2 = mutableFlatBuffer.a(i, 5);
                            if (a2) {
                                jsonGenerator.a("is_playable");
                                jsonGenerator.a(a2);
                            }
                            g = mutableFlatBuffer.g(i, 6);
                            if (g != 0) {
                                jsonGenerator.a("owner");
                                OwnerParser.m12991a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            g = mutableFlatBuffer.a(i, 7, 0);
                            if (g != 0) {
                                jsonGenerator.a("playable_duration");
                                jsonGenerator.b(g);
                            }
                            if (mutableFlatBuffer.g(i, 8) != 0) {
                                jsonGenerator.a("playable_url");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
                            }
                            g = mutableFlatBuffer.g(i, 9);
                            if (g != 0) {
                                jsonGenerator.a("savable_description");
                                SavableDescriptionParser.m12993a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            if (mutableFlatBuffer.g(i, 10) != 0) {
                                jsonGenerator.a("url");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
                            }
                            g = mutableFlatBuffer.a(i, 11, 0);
                            if (g != 0) {
                                jsonGenerator.a("width");
                                jsonGenerator.b(g);
                            }
                            jsonGenerator.g();
                        }
                    }

                    /* compiled from: extra_dashboard_filter_type */
                    public final class ViewerLocationsParser {
                        public static int m12998b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                        public static int m12996a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(m12998b(jsonParser, flatBufferBuilder)));
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

                        public static void m12997a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

                    public static int m12999a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[7];
                        boolean[] zArr = new boolean[1];
                        int[] iArr2 = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("location")) {
                                    iArr[0] = LocationParser.m12986a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("preview_image")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("profile_picture")) {
                                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("publisher_category")) {
                                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("video")) {
                                    iArr[4] = VideoParser.m12994a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("viewer_count")) {
                                    zArr[0] = true;
                                    iArr2[0] = jsonParser.E();
                                } else if (i.equals("viewer_locations")) {
                                    iArr[6] = ViewerLocationsParser.m12996a(jsonParser, flatBufferBuilder);
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
                        if (zArr[0]) {
                            flatBufferBuilder.a(5, iArr2[0], 0);
                        }
                        flatBufferBuilder.b(6, iArr[6]);
                        return flatBufferBuilder.d();
                    }

                    public static void m13000a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("location");
                            LocationParser.m12987a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("preview_image");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        if (mutableFlatBuffer.g(i, 2) != 0) {
                            jsonGenerator.a("profile_picture");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                        }
                        if (mutableFlatBuffer.g(i, 3) != 0) {
                            jsonGenerator.a("publisher_category");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                        }
                        g = mutableFlatBuffer.g(i, 4);
                        if (g != 0) {
                            jsonGenerator.a("video");
                            VideoParser.m12995a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        g = mutableFlatBuffer.a(i, 5, 0);
                        if (g != 0) {
                            jsonGenerator.a("viewer_count");
                            jsonGenerator.b(g);
                        }
                        g = mutableFlatBuffer.g(i, 6);
                        if (g != 0) {
                            jsonGenerator.a("viewer_locations");
                            jsonGenerator.d();
                            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                ViewerLocationsParser.m12997a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                            }
                            jsonGenerator.e();
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m13001b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m12999a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m13002b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m13000a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m13003a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m13001b(jsonParser, flatBufferBuilder)));
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

            public static void m13004a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m13002b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m13005a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("videos")) {
                        iArr[0] = VideosParser.m13003a(jsonParser, flatBufferBuilder);
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
}
