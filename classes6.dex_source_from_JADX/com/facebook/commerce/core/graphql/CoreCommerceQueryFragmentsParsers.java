package com.facebook.commerce.core.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLParsers.ZeroUpsellRecoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: previousPrivacy */
public class CoreCommerceQueryFragmentsParsers {

    /* compiled from: previousPrivacy */
    public final class CommerceMerchantPageFragmentParser {

        /* compiled from: previousPrivacy */
        public final class PageLikersParser {
            public static int m10620a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m10621a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: previousPrivacy */
        public final class ProfilePictureParser {
            public static int m10622a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m10623a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m10624a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("can_viewer_like")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("category_names")) {
                        iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("category_type")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLPageCategoryType.fromString(jsonParser.o()));
                    } else if (i.equals("does_viewer_like")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("id")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("page_likers")) {
                        iArr[6] = PageLikersParser.m10620a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_picture")) {
                        iArr[7] = ProfilePictureParser.m10622a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(8);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[1]) {
                flatBufferBuilder.a(3, zArr2[1]);
            }
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            return flatBufferBuilder.d();
        }

        public static void m10625a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("can_viewer_like");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("category_names");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 1), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("category_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("does_viewer_like");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            int g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("page_likers");
                PageLikersParser.m10621a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("profile_picture");
                ProfilePictureParser.m10623a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: previousPrivacy */
    public final class CommerceProductItemParser {

        /* compiled from: previousPrivacy */
        public final class ImagesParser {
            public static int m10628b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static int m10626a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m10628b(jsonParser, flatBufferBuilder)));
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

            public static void m10627a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: previousPrivacy */
        public final class ProductCatalogImageParser {
            public static int m10629a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m10630a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: previousPrivacy */
        public final class ProductImageLargeParser {
            public static int m10631a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m10632a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m10633a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[11];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("commerce_product_visibility")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLCommerceProductVisibility.fromString(jsonParser.o()));
                    } else if (i.equals("current_product_price")) {
                        iArr[1] = ProductItemPriceFieldsParser.m10644a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("description")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("external_url")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("images")) {
                        iArr[5] = ImagesParser.m10626a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_on_sale")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("name")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("productCatalogImage")) {
                        iArr[8] = ProductCatalogImageParser.m10629a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("productImageLarge")) {
                        iArr[9] = ProductImageLargeParser.m10631a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("product_item_price")) {
                        iArr[10] = ProductItemPriceFieldsParser.m10644a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[0]) {
                flatBufferBuilder.a(6, zArr2[0]);
            }
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            return flatBufferBuilder.d();
        }

        public static void m10634a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("commerce_product_visibility");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("current_product_price");
                ProductItemPriceFieldsParser.m10645a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("external_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("images");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    ImagesParser.m10627a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            boolean a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("is_on_sale");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("productCatalogImage");
                ProductCatalogImageParser.m10630a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("productImageLarge");
                ProductImageLargeParser.m10632a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("product_item_price");
                ProductItemPriceFieldsParser.m10645a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: previousPrivacy */
    public final class CommerceStoreFragmentParser {

        /* compiled from: previousPrivacy */
        public final class CommerceCollectionsParser {

            /* compiled from: previousPrivacy */
            public final class CollectionProductItemsParser {

                /* compiled from: previousPrivacy */
                public final class EdgesParser {
                    public static int m10635b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("node")) {
                                    iArr[0] = CommerceProductItemParser.m10633a(jsonParser, flatBufferBuilder);
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }
                }

                public static int m10636a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    boolean[] zArr = new boolean[1];
                    int[] iArr2 = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("count")) {
                                zArr[0] = true;
                                iArr2[0] = jsonParser.E();
                            } else if (i.equals("edges")) {
                                int i2 = 0;
                                ArrayList arrayList = new ArrayList();
                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                        arrayList.add(Integer.valueOf(EdgesParser.m10635b(jsonParser, flatBufferBuilder)));
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    int[] iArr3 = new int[arrayList.size()];
                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                        iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                                    }
                                    i2 = flatBufferBuilder.a(iArr3, true);
                                }
                                iArr[1] = i2;
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(2);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, iArr2[0], 0);
                    }
                    flatBufferBuilder.b(1, iArr[1]);
                    return flatBufferBuilder.d();
                }

                public static void m10637a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("count");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.g(i, 1);
                    if (a != 0) {
                        jsonGenerator.a("edges");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                            ZeroUpsellRecoParser.b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.e();
                    }
                    jsonGenerator.g();
                }
            }

            public static int m10638b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("collection_product_items")) {
                            iArr[0] = CollectionProductItemsParser.m10636a(jsonParser, flatBufferBuilder);
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

            public static void m10639b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("collection_product_items");
                    CollectionProductItemsParser.m10637a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
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

        /* compiled from: previousPrivacy */
        public final class CommerceMerchantSettingsParser {
            public static int m10640a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                boolean[] zArr = new boolean[3];
                boolean[] zArr2 = new boolean[2];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("is_user_subscribed_to_merchant")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("payment_provider")) {
                            zArr[1] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("show_edit_interface")) {
                            zArr[2] = true;
                            zArr2[1] = jsonParser.H();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(2, iArr2[0], 0);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(3, zArr2[1]);
                }
                return flatBufferBuilder.d();
            }

            public static void m10641a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                boolean a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("is_user_subscribed_to_merchant");
                    jsonGenerator.a(a);
                }
                int a2 = mutableFlatBuffer.a(i, 2, 0);
                if (a2 != 0) {
                    jsonGenerator.a("payment_provider");
                    jsonGenerator.b(a2);
                }
                a = mutableFlatBuffer.a(i, 3);
                if (a) {
                    jsonGenerator.a("show_edit_interface");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m10642a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("commerce_collections")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(CommerceCollectionsParser.m10638b(jsonParser, flatBufferBuilder)));
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
                    } else if (i.equals("commerce_merchant_settings")) {
                        iArr[1] = CommerceMerchantSettingsParser.m10640a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("intro_summary")) {
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

        public static void m10643a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("commerce_collections");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    CommerceCollectionsParser.m10639b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("commerce_merchant_settings");
                CommerceMerchantSettingsParser.m10641a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("intro_summary");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: previousPrivacy */
    public final class ProductItemPriceFieldsParser {
        public static int m10644a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("amount_in_hundredths")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("currency")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr2[0], 0);
            }
            flatBufferBuilder.b(1, iArr[1]);
            return flatBufferBuilder.d();
        }

        public static void m10645a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("amount_in_hundredths");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("currency");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            jsonGenerator.g();
        }
    }
}
