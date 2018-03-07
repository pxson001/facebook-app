package com.facebook.groupcommerce.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: reaction_units */
public class GroupSellInformationGraphQLParsers {

    /* compiled from: reaction_units */
    public final class GroupSellInformationParser {

        /* compiled from: reaction_units */
        public final class GroupSellConfigParser {

            /* compiled from: reaction_units */
            public final class EdgesParser {

                /* compiled from: reaction_units */
                public final class NodeParser {

                    /* compiled from: reaction_units */
                    public final class ForSaleCategoriesParser {

                        /* compiled from: reaction_units */
                        public final class ForSaleCategoriesEdgesParser {

                            /* compiled from: reaction_units */
                            public final class ForSaleCategoriesEdgesNodeParser {
                                public static int m6160a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    int[] iArr = new int[2];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("id")) {
                                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
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

                                public static void m6161a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                    jsonGenerator.f();
                                    if (mutableFlatBuffer.g(i, 0) != 0) {
                                        jsonGenerator.a("id");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                    }
                                    if (mutableFlatBuffer.g(i, 1) != 0) {
                                        jsonGenerator.a("name");
                                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            public static int m6162b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("node")) {
                                            iArr[0] = ForSaleCategoriesEdgesNodeParser.m6160a(jsonParser, flatBufferBuilder);
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, iArr[0]);
                                return flatBufferBuilder.d();
                            }

                            public static void m6163b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int g = mutableFlatBuffer.g(i, 0);
                                if (g != 0) {
                                    jsonGenerator.a("node");
                                    ForSaleCategoriesEdgesNodeParser.m6161a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m6164a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                                arrayList.add(Integer.valueOf(ForSaleCategoriesEdgesParser.m6162b(jsonParser, flatBufferBuilder)));
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

                        public static void m6165a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("edges");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    ForSaleCategoriesEdgesParser.m6163b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.e();
                            }
                            jsonGenerator.g();
                        }
                    }

                    /* compiled from: reaction_units */
                    public final class LocationPickerSettingParser {
                        public static int m6166a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            boolean[] zArr = new boolean[3];
                            boolean[] zArr2 = new boolean[3];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("is_compulsory")) {
                                        zArr[0] = true;
                                        zArr2[0] = jsonParser.H();
                                    } else if (i.equals("use_neighborhood_datasource")) {
                                        zArr[1] = true;
                                        zArr2[1] = jsonParser.H();
                                    } else if (i.equals("use_zip_code")) {
                                        zArr[2] = true;
                                        zArr2[2] = jsonParser.H();
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(3);
                            if (zArr[0]) {
                                flatBufferBuilder.a(0, zArr2[0]);
                            }
                            if (zArr[1]) {
                                flatBufferBuilder.a(1, zArr2[1]);
                            }
                            if (zArr[2]) {
                                flatBufferBuilder.a(2, zArr2[2]);
                            }
                            return flatBufferBuilder.d();
                        }

                        public static void m6167a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            boolean a = mutableFlatBuffer.a(i, 0);
                            if (a) {
                                jsonGenerator.a("is_compulsory");
                                jsonGenerator.a(a);
                            }
                            a = mutableFlatBuffer.a(i, 1);
                            if (a) {
                                jsonGenerator.a("use_neighborhood_datasource");
                                jsonGenerator.a(a);
                            }
                            a = mutableFlatBuffer.a(i, 2);
                            if (a) {
                                jsonGenerator.a("use_zip_code");
                                jsonGenerator.a(a);
                            }
                            jsonGenerator.g();
                        }
                    }

                    /* compiled from: reaction_units */
                    public final class MarketplaceCrossPostSettingParser {
                        public static int m6168a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[14];
                            boolean[] zArr = new boolean[4];
                            boolean[] zArr2 = new boolean[4];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("check_box_label")) {
                                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("intercept_accept_button_label")) {
                                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("intercept_decline_button_label")) {
                                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("is_compulsory")) {
                                        zArr[0] = true;
                                        zArr2[0] = jsonParser.H();
                                    } else if (i.equals("is_enabled")) {
                                        zArr[1] = true;
                                        zArr2[1] = jsonParser.H();
                                    } else if (i.equals("nux_label")) {
                                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("should_show_intercept")) {
                                        zArr[2] = true;
                                        zArr2[2] = jsonParser.H();
                                    } else if (i.equals("should_show_nux")) {
                                        zArr[3] = true;
                                        zArr2[3] = jsonParser.H();
                                    } else if (i.equals("upsell_accept_button_label")) {
                                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("upsell_decline_button_label")) {
                                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("upsell_people_label")) {
                                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("upsell_pin_label")) {
                                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("upsell_time_label")) {
                                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                                    } else if (i.equals("upsell_title_label")) {
                                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(14);
                            flatBufferBuilder.b(0, iArr[0]);
                            flatBufferBuilder.b(1, iArr[1]);
                            flatBufferBuilder.b(2, iArr[2]);
                            if (zArr[0]) {
                                flatBufferBuilder.a(3, zArr2[0]);
                            }
                            if (zArr[1]) {
                                flatBufferBuilder.a(4, zArr2[1]);
                            }
                            flatBufferBuilder.b(5, iArr[5]);
                            if (zArr[2]) {
                                flatBufferBuilder.a(6, zArr2[2]);
                            }
                            if (zArr[3]) {
                                flatBufferBuilder.a(7, zArr2[3]);
                            }
                            flatBufferBuilder.b(8, iArr[8]);
                            flatBufferBuilder.b(9, iArr[9]);
                            flatBufferBuilder.b(10, iArr[10]);
                            flatBufferBuilder.b(11, iArr[11]);
                            flatBufferBuilder.b(12, iArr[12]);
                            flatBufferBuilder.b(13, iArr[13]);
                            return flatBufferBuilder.d();
                        }

                        public static void m6169a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("check_box_label");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("intercept_accept_button_label");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            if (mutableFlatBuffer.g(i, 2) != 0) {
                                jsonGenerator.a("intercept_decline_button_label");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                            }
                            boolean a = mutableFlatBuffer.a(i, 3);
                            if (a) {
                                jsonGenerator.a("is_compulsory");
                                jsonGenerator.a(a);
                            }
                            a = mutableFlatBuffer.a(i, 4);
                            if (a) {
                                jsonGenerator.a("is_enabled");
                                jsonGenerator.a(a);
                            }
                            if (mutableFlatBuffer.g(i, 5) != 0) {
                                jsonGenerator.a("nux_label");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                            }
                            a = mutableFlatBuffer.a(i, 6);
                            if (a) {
                                jsonGenerator.a("should_show_intercept");
                                jsonGenerator.a(a);
                            }
                            a = mutableFlatBuffer.a(i, 7);
                            if (a) {
                                jsonGenerator.a("should_show_nux");
                                jsonGenerator.a(a);
                            }
                            if (mutableFlatBuffer.g(i, 8) != 0) {
                                jsonGenerator.a("upsell_accept_button_label");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
                            }
                            if (mutableFlatBuffer.g(i, 9) != 0) {
                                jsonGenerator.a("upsell_decline_button_label");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                            }
                            if (mutableFlatBuffer.g(i, 10) != 0) {
                                jsonGenerator.a("upsell_people_label");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
                            }
                            if (mutableFlatBuffer.g(i, 11) != 0) {
                                jsonGenerator.a("upsell_pin_label");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                            }
                            if (mutableFlatBuffer.g(i, 12) != 0) {
                                jsonGenerator.a("upsell_time_label");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                            }
                            if (mutableFlatBuffer.g(i, 13) != 0) {
                                jsonGenerator.a("upsell_title_label");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m6170a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[12];
                        boolean[] zArr = new boolean[4];
                        boolean[] zArr2 = new boolean[4];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("currencies")) {
                                    iArr[0] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("for_sale_categories")) {
                                    iArr[1] = ForSaleCategoriesParser.m6164a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("id")) {
                                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("is_category_optional")) {
                                    zArr[0] = true;
                                    zArr2[0] = jsonParser.H();
                                } else if (i.equals("is_post_intercept_enabled")) {
                                    zArr[1] = true;
                                    zArr2[1] = jsonParser.H();
                                } else if (i.equals("location_picker_setting")) {
                                    iArr[5] = LocationPickerSettingParser.m6166a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("marketplace_cross_post_setting")) {
                                    iArr[6] = MarketplaceCrossPostSettingParser.m6168a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("post_intercept_words")) {
                                    iArr[7] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("post_intercept_words_after_number")) {
                                    iArr[8] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("prefill_category_id")) {
                                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("should_show_autos_options_in_composer")) {
                                    zArr[2] = true;
                                    zArr2[2] = jsonParser.H();
                                } else if (i.equals("user_group_commerce_post_to_marketplace_state")) {
                                    zArr[3] = true;
                                    zArr2[3] = jsonParser.H();
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
                            flatBufferBuilder.a(3, zArr2[0]);
                        }
                        if (zArr[1]) {
                            flatBufferBuilder.a(4, zArr2[1]);
                        }
                        flatBufferBuilder.b(5, iArr[5]);
                        flatBufferBuilder.b(6, iArr[6]);
                        flatBufferBuilder.b(7, iArr[7]);
                        flatBufferBuilder.b(8, iArr[8]);
                        flatBufferBuilder.b(9, iArr[9]);
                        if (zArr[2]) {
                            flatBufferBuilder.a(10, zArr2[2]);
                        }
                        if (zArr[3]) {
                            flatBufferBuilder.a(11, zArr2[3]);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m6171a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("currencies");
                            SerializerHelpers.a(mutableFlatBuffer.f(i, 0), jsonGenerator);
                        }
                        int g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("for_sale_categories");
                            ForSaleCategoriesParser.m6165a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        if (mutableFlatBuffer.g(i, 2) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                        }
                        boolean a = mutableFlatBuffer.a(i, 3);
                        if (a) {
                            jsonGenerator.a("is_category_optional");
                            jsonGenerator.a(a);
                        }
                        a = mutableFlatBuffer.a(i, 4);
                        if (a) {
                            jsonGenerator.a("is_post_intercept_enabled");
                            jsonGenerator.a(a);
                        }
                        g = mutableFlatBuffer.g(i, 5);
                        if (g != 0) {
                            jsonGenerator.a("location_picker_setting");
                            LocationPickerSettingParser.m6167a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        g = mutableFlatBuffer.g(i, 6);
                        if (g != 0) {
                            jsonGenerator.a("marketplace_cross_post_setting");
                            MarketplaceCrossPostSettingParser.m6169a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 7) != 0) {
                            jsonGenerator.a("post_intercept_words");
                            SerializerHelpers.a(mutableFlatBuffer.f(i, 7), jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 8) != 0) {
                            jsonGenerator.a("post_intercept_words_after_number");
                            SerializerHelpers.a(mutableFlatBuffer.f(i, 8), jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 9) != 0) {
                            jsonGenerator.a("prefill_category_id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                        }
                        a = mutableFlatBuffer.a(i, 10);
                        if (a) {
                            jsonGenerator.a("should_show_autos_options_in_composer");
                            jsonGenerator.a(a);
                        }
                        a = mutableFlatBuffer.a(i, 11);
                        if (a) {
                            jsonGenerator.a("user_group_commerce_post_to_marketplace_state");
                            jsonGenerator.a(a);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m6172b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m6170a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m6173b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m6171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m6174a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m6172b(jsonParser, flatBufferBuilder)));
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

            public static void m6175a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m6173b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6176a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("group_sell_config")) {
                        iArr[0] = GroupSellConfigParser.m6174a(jsonParser, flatBufferBuilder);
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
