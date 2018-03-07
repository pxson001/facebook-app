package com.facebook.api.graphql.textwithentities;

import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithRangesFieldsParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.TextWithEntitiesAggregatedRangeFieldsParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAppStoreApplicationInstallState;
import com.facebook.graphql.enums.GraphQLAppStoreDownloadConnectivityPolicy;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageUriFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: tagger */
public class NewsFeedApplicationGraphQLParsers {

    /* compiled from: tagger */
    public final class AppSocialContextTextWithEntitiesEntityRangeFieldsParser {

        /* compiled from: tagger */
        public final class EntityParser {
            public static int m3069a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[5];
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
                        } else if (i.equals("profile_picture")) {
                            iArr[3] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("url")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
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

            public static void m3070a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                int g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                jsonGenerator.g();
            }
        }

        public static int m3071b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            boolean[] zArr = new boolean[2];
            int[] iArr2 = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("entity")) {
                        iArr[0] = EntityParser.m3069a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("length")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("offset")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, iArr2[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(2, iArr2[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m3072b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("entity");
                EntityParser.m3070a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.a(i, 1, 0);
            if (g != 0) {
                jsonGenerator.a("length");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 2, 0);
            if (g != 0) {
                jsonGenerator.a("offset");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: tagger */
    public final class AppSocialContextTextWithEntitiesWithRangesParser {
        public static int m3073a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("aggregated_ranges")) {
                        iArr[0] = TextWithEntitiesAggregatedRangeFieldsParser.m3161a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("ranges")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(AppSocialContextTextWithEntitiesEntityRangeFieldsParser.m3071b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[1] = i2;
                    } else if (i.equals("text")) {
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

        public static void m3074a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("aggregated_ranges");
                TextWithEntitiesAggregatedRangeFieldsParser.m3162a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("ranges");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    AppSocialContextTextWithEntitiesEntityRangeFieldsParser.m3072b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: tagger */
    public final class AppStoreApplicationFragmentParser {
        public static int m3075a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[16];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("app_store_identifier")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("artifact_size_description")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("banner_screenshots")) {
                        iArr[2] = DefaultImageFieldsParser.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("description")) {
                        iArr[3] = DefaultTextWithEntitiesWithRangesFieldsParser.m3144a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("download_connectivity_policy")) {
                        iArr[4] = flatBufferBuilder.a(GraphQLAppStoreDownloadConnectivityPolicy.fromString(jsonParser.o()));
                    } else if (i.equals("install_id")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("install_state")) {
                        iArr[6] = flatBufferBuilder.a(GraphQLAppStoreApplicationInstallState.fromString(jsonParser.o()));
                    } else if (i.equals("likes_context_sentence")) {
                        iArr[7] = DefaultTextWithEntitiesWithRangesFieldsParser.m3144a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("permissions")) {
                        iArr[8] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("phone_screenshots")) {
                        iArr[9] = DefaultImageFieldsParser.b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("platform_application")) {
                        iArr[10] = AppStorePlatformApplicationFieldsParser.m3077a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("publisher")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("supported_app_stores")) {
                        iArr[12] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("usage_context_sentence")) {
                        iArr[13] = AppSocialContextTextWithEntitiesWithRangesParser.m3073a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("version_code")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("version_name")) {
                        iArr[15] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(16);
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
            if (zArr[0]) {
                flatBufferBuilder.a(14, iArr2[0], 0);
            }
            flatBufferBuilder.b(15, iArr[15]);
            return flatBufferBuilder.d();
        }

        public static void m3076a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("app_store_identifier");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("artifact_size_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("banner_screenshots");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("description");
                DefaultTextWithEntitiesWithRangesFieldsParser.m3145a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("download_connectivity_policy");
                jsonGenerator.b(mutableFlatBuffer.b(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("install_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("install_state");
                jsonGenerator.b(mutableFlatBuffer.b(i, 6));
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("likes_context_sentence");
                DefaultTextWithEntitiesWithRangesFieldsParser.m3145a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("permissions");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 8), jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("phone_screenshots");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("platform_application");
                AppStorePlatformApplicationFieldsParser.m3078a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("publisher");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("supported_app_stores");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 12), jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("usage_context_sentence");
                AppSocialContextTextWithEntitiesWithRangesParser.m3074a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.a(i, 14, 0);
            if (g != 0) {
                jsonGenerator.a("version_code");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("version_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 15));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: tagger */
    public final class AppStorePlatformApplicationFieldsParser {
        public static int m3077a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[12];
            boolean[] zArr = new boolean[1];
            double[] dArr = new double[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("android_app_config")) {
                        iArr[0] = AndroidAppConfigParser.m3079a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("android_store_url")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("app_center_cover_image")) {
                        iArr[2] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("average_star_rating")) {
                        zArr[0] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("canvas_url")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("global_usage_summary_sentence")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.m9834a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("privacy_url")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("social_usage_summary_sentence")) {
                        iArr[9] = DefaultTextWithEntitiesFieldsParser.m9834a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("square_logo")) {
                        iArr[10] = DefaultImageUriFieldsParser.m9758a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("terms_of_service_url")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[0]) {
                flatBufferBuilder.a(3, dArr[0], 0.0d);
            }
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            return flatBufferBuilder.d();
        }

        public static void m3078a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("android_app_config");
                AndroidAppConfigParser.m3080a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("android_store_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("app_center_cover_image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            double a = mutableFlatBuffer.a(i, 3, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("average_star_rating");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("canvas_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("global_usage_summary_sentence");
                DefaultTextWithEntitiesFieldsParser.m9835a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("privacy_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("social_usage_summary_sentence");
                DefaultTextWithEntitiesFieldsParser.m9835a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("square_logo");
                DefaultImageUriFieldsParser.m9759a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("terms_of_service_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: tagger */
    public final class InnerApplicationFieldsParser {

        /* compiled from: tagger */
        public final class AndroidAppConfigParser {
            public static int m3079a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("class_name")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("package_name")) {
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

            public static void m3080a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("class_name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("package_name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static int m3081a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[10];
            boolean[] zArr = new boolean[1];
            double[] dArr = new double[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("android_app_config")) {
                        iArr[0] = AndroidAppConfigParser.m3079a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("android_store_url")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("app_center_cover_image")) {
                        iArr[2] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("average_star_rating")) {
                        zArr[0] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("canvas_url")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("global_usage_summary_sentence")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.m9834a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("social_usage_summary_sentence")) {
                        iArr[8] = DefaultTextWithEntitiesFieldsParser.m9834a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("square_logo")) {
                        iArr[9] = DefaultImageUriFieldsParser.m9758a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[0]) {
                flatBufferBuilder.a(3, dArr[0], 0.0d);
            }
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            return flatBufferBuilder.d();
        }

        public static void m3082a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("android_app_config");
                AndroidAppConfigParser.m3080a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("android_store_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("app_center_cover_image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            double a = mutableFlatBuffer.a(i, 3, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("average_star_rating");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("canvas_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("global_usage_summary_sentence");
                DefaultTextWithEntitiesFieldsParser.m9835a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("social_usage_summary_sentence");
                DefaultTextWithEntitiesFieldsParser.m9835a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("square_logo");
                DefaultImageUriFieldsParser.m9759a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }
}
