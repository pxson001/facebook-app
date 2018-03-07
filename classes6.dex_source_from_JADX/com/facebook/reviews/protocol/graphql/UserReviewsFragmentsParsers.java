package com.facebook.reviews.protocol.graphql;

import android.net.Uri;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.EditReviewActionLinkFieldsParser.ReviewParser.RepresentedProfileParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenActionLinkFieldsFragParser.LeadGenDataParser.PagesParser.PrivacyDataParser;
import com.facebook.api.graphql.actionlink.NewsFeedActionLinkGraphQLParsers.LeadGenDefaultInfoFieldsParser;
import com.facebook.bugreporter.BugReport;
import com.facebook.bugreporter.BugReportSource;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.flatteners.UriFlattener;
import com.facebook.graphql.deserializers.GraphQLStoryDeserializer;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultAddressFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewBasicFieldsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewBasicFieldsParser.ValueParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewWithFeedbackParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.SelectedPrivacyOptionFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: setInitialSlideshowData */
public class UserReviewsFragmentsParsers {

    /* compiled from: setInitialSlideshowData */
    public final class PlaceToReviewParser {

        /* compiled from: setInitialSlideshowData */
        public final class ProfilePhotoParser {

            /* compiled from: setInitialSlideshowData */
            public final class ImageParser {
                public static int m7509a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m7510a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m7511a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("image")) {
                            iArr[0] = ImageParser.m7509a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m7512a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("image");
                    ImageParser.m7510a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: setInitialSlideshowData */
        public final class ViewerStarRatingParser {
            public static int m7513a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[2];
                int[] iArr = new int[1];
                double[] dArr = new double[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("scale")) {
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

            public static void m7514a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("scale");
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

        public static int m7515b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("address")) {
                        iArr[0] = DefaultAddressFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profile_photo")) {
                        iArr[3] = ProfilePhotoParser.m7511a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("review_context")) {
                        iArr[4] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_recommendation")) {
                        iArr[5] = ReviewBasicFieldsParser.m7306a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_star_rating")) {
                        iArr[6] = ViewerStarRatingParser.m7513a(jsonParser, flatBufferBuilder);
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
            return flatBufferBuilder.d();
        }

        public static void m7516b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("address");
                DefaultAddressFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("profile_photo");
                ProfilePhotoParser.m7512a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("review_context");
                DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("viewer_recommendation");
                ReviewBasicFieldsParser.m7307a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("viewer_star_rating");
                ViewerStarRatingParser.m7514a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: setInitialSlideshowData */
    public final class PlacesToReviewParser {

        /* compiled from: setInitialSlideshowData */
        public final class PlaceReviewSuggestionsParser {

            /* compiled from: setInitialSlideshowData */
            public final class PageInfoParser {
                public static int m7517a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    boolean[] zArr = new boolean[1];
                    boolean[] zArr2 = new boolean[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("end_cursor")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("has_next_page")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, iArr[0]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(1, zArr2[0]);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m7518a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("end_cursor");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    boolean a = mutableFlatBuffer.a(i, 1);
                    if (a) {
                        jsonGenerator.a("has_next_page");
                        jsonGenerator.a(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m7519a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(PlaceToReviewParser.m7515b(jsonParser, flatBufferBuilder)));
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
                            iArr[1] = PageInfoParser.m7517a(jsonParser, flatBufferBuilder);
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

            public static void m7520a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        PlaceToReviewParser.m7516b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("page_info");
                    PageInfoParser.m7518a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m7521a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("place_review_suggestions")) {
                        iArr[0] = PlaceReviewSuggestionsParser.m7519a(jsonParser, flatBufferBuilder);
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

    /* compiled from: setInitialSlideshowData */
    public final class UpdatedPageReviewParser {

        /* compiled from: setInitialSlideshowData */
        public final class ReviewStoryParser {
            public static int m7522a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("story")) {
                            iArr[0] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m7523a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("story");
                    GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m7524a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("review_story")) {
                        iArr[0] = ReviewStoryParser.m7522a(jsonParser, flatBufferBuilder);
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

    /* compiled from: setInitialSlideshowData */
    public final class UserReviewsParser {

        /* compiled from: setInitialSlideshowData */
        public final class AuthoredReviewsParser {

            /* compiled from: setInitialSlideshowData */
            public final class EdgesParser {

                /* compiled from: setInitialSlideshowData */
                public final class ReviewStoryParser {
                    public static int m7525a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("story")) {
                                    iArr[0] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m7526a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("story");
                            GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m7527b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("review_story")) {
                                iArr[0] = ReviewStoryParser.m7525a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("review_with_feedback")) {
                                iArr[1] = ReviewWithFeedbackParser.m7323a(jsonParser, flatBufferBuilder);
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

                public static void m7528b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("review_story");
                        ReviewStoryParser.m7526a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("review_with_feedback");
                        ReviewWithFeedbackParser.m7324a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: setInitialSlideshowData */
            public final class PageInfoParser {
                public static int m7529a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    boolean[] zArr = new boolean[1];
                    boolean[] zArr2 = new boolean[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("end_cursor")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("has_next_page")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, iArr[0]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(1, zArr2[0]);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m7530a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("end_cursor");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    boolean a = mutableFlatBuffer.a(i, 1);
                    if (a) {
                        jsonGenerator.a("has_next_page");
                        jsonGenerator.a(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m7531a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m7527b(jsonParser, flatBufferBuilder)));
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
                            iArr[1] = PageInfoParser.m7529a(jsonParser, flatBufferBuilder);
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

            public static void m7532a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m7528b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("page_info");
                    PageInfoParser.m7530a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m7533a(BugReport bugReport, FlatBufferBuilder flatBufferBuilder) {
            int a = flatBufferBuilder.a(bugReport.a, UriFlattener.a);
            int b = flatBufferBuilder.b(bugReport.b);
            int a2 = flatBufferBuilder.a(bugReport.c, UriFlattener.a);
            int a3 = flatBufferBuilder.a(bugReport.d, UriFlattener.a, false);
            int b2 = flatBufferBuilder.b(bugReport.e, false);
            int b3 = flatBufferBuilder.b(bugReport.f, false);
            int b4 = flatBufferBuilder.b(bugReport.g);
            int b5 = flatBufferBuilder.b(bugReport.h);
            int b6 = flatBufferBuilder.b(bugReport.i);
            int b7 = flatBufferBuilder.b(bugReport.j);
            int b8 = flatBufferBuilder.b(bugReport.k);
            int b9 = flatBufferBuilder.b(bugReport.l);
            int b10 = flatBufferBuilder.b(bugReport.m);
            int b11 = flatBufferBuilder.b(bugReport.n);
            int b12 = flatBufferBuilder.b(bugReport.o);
            int b13 = flatBufferBuilder.b(bugReport.p);
            int a4 = flatBufferBuilder.a(bugReport.q);
            int b14 = flatBufferBuilder.b(bugReport.r);
            int b15 = flatBufferBuilder.b(bugReport.t, false);
            int b16 = flatBufferBuilder.b(bugReport.u);
            int b17 = flatBufferBuilder.b(bugReport.v);
            int b18 = flatBufferBuilder.b(bugReport.w);
            flatBufferBuilder.c(24);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, b4);
            flatBufferBuilder.b(8, b5);
            flatBufferBuilder.b(9, b6);
            flatBufferBuilder.b(10, b7);
            flatBufferBuilder.b(11, b8);
            flatBufferBuilder.b(12, b9);
            flatBufferBuilder.b(13, b10);
            flatBufferBuilder.b(14, b11);
            flatBufferBuilder.b(15, b12);
            flatBufferBuilder.b(16, b13);
            flatBufferBuilder.b(17, a4);
            flatBufferBuilder.b(18, b14);
            flatBufferBuilder.a(19, bugReport.s, 0);
            flatBufferBuilder.b(20, b15);
            flatBufferBuilder.b(21, b16);
            flatBufferBuilder.b(22, b17);
            flatBufferBuilder.b(23, b18);
            return flatBufferBuilder.d();
        }

        public static void m7535a(BugReport bugReport, ByteBuffer byteBuffer, int i) {
            ImmutableMap copyOf;
            ImmutableMap immutableMap = null;
            bugReport.a = (Uri) FlatBuffer.a(byteBuffer, i, 1, UriFlattener.a);
            bugReport.b = FlatBuffer.b(byteBuffer, i, 2);
            bugReport.c = (Uri) FlatBuffer.a(byteBuffer, i, 3, UriFlattener.a);
            Collection a = FlatBuffer.a(byteBuffer, i, 4, ArrayList.class, UriFlattener.a);
            bugReport.d = a != null ? ImmutableList.copyOf(a) : null;
            Map f = FlatBuffer.f(byteBuffer, i, 5, HashMap.class);
            if (f != null) {
                copyOf = ImmutableMap.copyOf(f);
            } else {
                copyOf = null;
            }
            bugReport.e = copyOf;
            f = FlatBuffer.f(byteBuffer, i, 6, HashMap.class);
            if (f != null) {
                copyOf = ImmutableMap.copyOf(f);
            } else {
                copyOf = null;
            }
            bugReport.f = copyOf;
            bugReport.g = FlatBuffer.b(byteBuffer, i, 7);
            bugReport.h = FlatBuffer.b(byteBuffer, i, 8);
            bugReport.i = FlatBuffer.b(byteBuffer, i, 9);
            bugReport.j = FlatBuffer.b(byteBuffer, i, 10);
            bugReport.k = FlatBuffer.b(byteBuffer, i, 11);
            bugReport.l = FlatBuffer.b(byteBuffer, i, 12);
            bugReport.m = FlatBuffer.b(byteBuffer, i, 13);
            bugReport.n = FlatBuffer.b(byteBuffer, i, 14);
            bugReport.o = FlatBuffer.b(byteBuffer, i, 15);
            bugReport.p = FlatBuffer.b(byteBuffer, i, 16);
            String b = FlatBuffer.b(byteBuffer, i, 17);
            if (b == null) {
                try {
                    bugReport.q = null;
                } catch (IllegalArgumentException e) {
                }
            } else {
                bugReport.q = (BugReportSource) Enum.valueOf(BugReportSource.class, b);
            }
            bugReport.r = FlatBuffer.b(byteBuffer, i, 18);
            bugReport.s = FlatBuffer.a(byteBuffer, i, 19, 0);
            f = FlatBuffer.f(byteBuffer, i, 20, HashMap.class);
            if (f != null) {
                immutableMap = ImmutableMap.copyOf(f);
            }
            bugReport.t = immutableMap;
            bugReport.u = FlatBuffer.b(byteBuffer, i, 21);
            bugReport.v = FlatBuffer.b(byteBuffer, i, 22);
            bugReport.w = FlatBuffer.b(byteBuffer, i, 23);
        }

        public static void m7536a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("broadcast_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            jsonGenerator.g();
        }

        public static void m7538b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("info_fields");
                LeadGenDefaultInfoFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("privacy_data");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    PrivacyDataParser.a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }

        public static MutableFlatBuffer m7534a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("authored_reviews")) {
                        iArr[0] = AuthoredReviewsParser.m7531a(jsonParser, flatBufferBuilder);
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

        public static void m7537a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int a = mutableFlatBuffer.a(i, 1, 0);
            if (a != 0) {
                jsonGenerator.a("page_rating");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.g(i, 2);
            if (a != 0) {
                jsonGenerator.a("privacy_scope");
                SelectedPrivacyOptionFieldsParser.m7330a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 3);
            if (a != 0) {
                jsonGenerator.a("represented_profile");
                RepresentedProfileParser.a(mutableFlatBuffer, a, jsonGenerator);
            }
            a = mutableFlatBuffer.g(i, 4);
            if (a != 0) {
                jsonGenerator.a("value");
                ValueParser.m7305a(mutableFlatBuffer, a, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }
}
