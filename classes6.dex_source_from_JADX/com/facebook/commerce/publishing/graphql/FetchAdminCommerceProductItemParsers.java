package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.ProductItemPriceFieldsParser;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsParsers.AdminCommerceProductItemParser.OrderedImagesParser;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsParsers.AdminCommerceProductItemParser.ProductImageLargeParser;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductCreationFieldsParsers.PageShopProductCreationFieldsParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: platform/ */
public class FetchAdminCommerceProductItemParsers {

    /* compiled from: platform/ */
    public final class FetchAdminCommerceProductItemParser {
        public static int m10916a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[10];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("commerce_featured_item")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("commerce_product_visibility")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLCommerceProductVisibility.fromString(jsonParser.o()));
                    } else if (i.equals("description")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("ordered_images")) {
                        iArr[6] = OrderedImagesParser.m10806a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[7] = PageShopProductCreationFieldsParser.m10897a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("productImageLarge")) {
                        iArr[8] = ProductImageLargeParser.m10812a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("product_item_price")) {
                        iArr[9] = ProductItemPriceFieldsParser.m10644a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            return flatBufferBuilder.d();
        }

        public static void m10917a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("commerce_featured_item");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("commerce_product_visibility");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
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
                jsonGenerator.a("ordered_images");
                OrderedImagesParser.m10807a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("page");
                PageShopProductCreationFieldsParser.m10898a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("productImageLarge");
                ProductImageLargeParser.m10813a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("product_item_price");
                ProductItemPriceFieldsParser.m10645a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }
}
