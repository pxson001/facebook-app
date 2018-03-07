package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCommerceCheckoutStyle;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.enums.GraphQLProductAvailability;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: neither mData nor mUri are set */
public class GraphQLProductItemDeserializer {
    public static int m5711a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[47];
        boolean[] zArr = new boolean[11];
        boolean[] zArr2 = new boolean[3];
        int[] iArr2 = new int[1];
        long[] jArr = new long[1];
        double[] dArr = new double[2];
        Enum[] enumArr = new Enum[4];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("checkout_url")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("commerce_checkout_style")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLCommerceCheckoutStyle.fromString(jsonParser.o());
                } else if (i.equals("commerce_featured_item")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("commerce_inventory")) {
                    zArr[2] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("commerce_product_visibility")) {
                    zArr[3] = true;
                    enumArr[1] = GraphQLCommerceProductVisibility.fromString(jsonParser.o());
                } else if (i.equals("creation_time")) {
                    zArr[4] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("current_price")) {
                    iArr[6] = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                } else if (i.equals("description")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("experimental_freeform_price")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("external_url")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("feedAwesomizerProfilePicture")) {
                    iArr[10] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[11] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("front_view_image")) {
                    iArr[12] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[13] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image")) {
                    iArr[14] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHighOrig")) {
                    iArr[15] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("images")) {
                    iArr[16] = GraphQLImageDeserializer.b(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_activities")) {
                    iArr[17] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_on_sale")) {
                    zArr[5] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("item_availability")) {
                    zArr[6] = true;
                    enumArr[2] = GraphQLProductAvailability.fromString(jsonParser.o());
                } else if (i.equals("item_details")) {
                    iArr[20] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("item_price")) {
                    iArr[21] = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                } else if (i.equals("merchant_logo")) {
                    iArr[22] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[23] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("page")) {
                    iArr[24] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("parent_story")) {
                    iArr[25] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("platform_images")) {
                    iArr[26] = GraphQLImageDeserializer.b(jsonParser, flatBufferBuilder);
                } else if (i.equals("productCatalogImage")) {
                    iArr[27] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("productImageLarge")) {
                    iArr[28] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageLarge")) {
                    iArr[29] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[30] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture50")) {
                    iArr[31] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureHighRes")) {
                    iArr[32] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureLarge")) {
                    iArr[33] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[34] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[35] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[7] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("reference_url")) {
                    iArr[37] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sale_price")) {
                    iArr[38] = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                } else if (i.equals("seller")) {
                    iArr[39] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("streaming_profile_picture")) {
                    iArr[40] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("taggable_object_profile_picture")) {
                    iArr[41] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[42] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("variant_values")) {
                    iArr[43] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_saved_state")) {
                    zArr[8] = true;
                    enumArr[3] = GraphQLSavedState.fromString(jsonParser.o());
                } else if (i.equals("product_latitude")) {
                    zArr[9] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("product_longitude")) {
                    zArr[10] = true;
                    dArr[1] = jsonParser.G();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(47);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, enumArr[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(2, zArr2[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(3, iArr2[0], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(4, enumArr[1]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(5, jArr[0], 0);
        }
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        if (zArr[5]) {
            flatBufferBuilder.a(18, zArr2[1]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(19, enumArr[2]);
        }
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        flatBufferBuilder.b(27, iArr[27]);
        flatBufferBuilder.b(28, iArr[28]);
        flatBufferBuilder.b(29, iArr[29]);
        flatBufferBuilder.b(30, iArr[30]);
        flatBufferBuilder.b(31, iArr[31]);
        flatBufferBuilder.b(32, iArr[32]);
        flatBufferBuilder.b(33, iArr[33]);
        flatBufferBuilder.b(34, iArr[34]);
        flatBufferBuilder.b(35, iArr[35]);
        if (zArr[7]) {
            flatBufferBuilder.a(36, zArr2[2]);
        }
        flatBufferBuilder.b(37, iArr[37]);
        flatBufferBuilder.b(38, iArr[38]);
        flatBufferBuilder.b(39, iArr[39]);
        flatBufferBuilder.b(40, iArr[40]);
        flatBufferBuilder.b(41, iArr[41]);
        flatBufferBuilder.b(42, iArr[42]);
        flatBufferBuilder.b(43, iArr[43]);
        if (zArr[8]) {
            flatBufferBuilder.a(44, enumArr[3]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(45, dArr[0], 0.0d);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(46, dArr[1], 0.0d);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5712a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5711a(jsonParser, flatBufferBuilder);
        if (1 != 0) {
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, s, 0);
            flatBufferBuilder.b(1, a);
            a = flatBufferBuilder.d();
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        return mutableFlatBuffer;
    }

    public static void m5713a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("checkout_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.a(i, 1, (short) 0) != (short) 0) {
            jsonGenerator.a("commerce_checkout_style");
            jsonGenerator.b(((GraphQLCommerceCheckoutStyle) mutableFlatBuffer.a(i, 1, GraphQLCommerceCheckoutStyle.class)).name());
        }
        boolean a = mutableFlatBuffer.a(i, 2);
        if (a) {
            jsonGenerator.a("commerce_featured_item");
            jsonGenerator.a(a);
        }
        int a2 = mutableFlatBuffer.a(i, 3, 0);
        if (a2 != 0) {
            jsonGenerator.a("commerce_inventory");
            jsonGenerator.b(a2);
        }
        if (mutableFlatBuffer.a(i, 4, (short) 0) != (short) 0) {
            jsonGenerator.a("commerce_product_visibility");
            jsonGenerator.b(((GraphQLCommerceProductVisibility) mutableFlatBuffer.a(i, 4, GraphQLCommerceProductVisibility.class)).name());
        }
        long a3 = mutableFlatBuffer.a(i, 5, 0);
        if (a3 != 0) {
            jsonGenerator.a("creation_time");
            jsonGenerator.a(a3);
        }
        a2 = mutableFlatBuffer.g(i, 6);
        if (a2 != 0) {
            jsonGenerator.a("current_price");
            GraphQLCurrencyQuantityDeserializer.m4702a(mutableFlatBuffer, a2, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("experimental_freeform_price");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("external_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        a2 = mutableFlatBuffer.g(i, 10);
        if (a2 != 0) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 11);
        if (a2 != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, a2, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.g(i, 12);
        if (a2 != 0) {
            jsonGenerator.a("front_view_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 13) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 13));
        }
        a2 = mutableFlatBuffer.g(i, 14);
        if (a2 != 0) {
            jsonGenerator.a("image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 15);
        if (a2 != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 16);
        if (a2 != 0) {
            jsonGenerator.a("images");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.g(i, 17);
        if (a2 != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, a2, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 18);
        if (a) {
            jsonGenerator.a("is_on_sale");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.a(i, 19, (short) 0) != (short) 0) {
            jsonGenerator.a("item_availability");
            jsonGenerator.b(((GraphQLProductAvailability) mutableFlatBuffer.a(i, 19, GraphQLProductAvailability.class)).name());
        }
        if (mutableFlatBuffer.g(i, 20) != 0) {
            jsonGenerator.a("item_details");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 20), jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 21);
        if (a2 != 0) {
            jsonGenerator.a("item_price");
            GraphQLCurrencyQuantityDeserializer.m4702a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 22);
        if (a2 != 0) {
            jsonGenerator.a("merchant_logo");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 23) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 23));
        }
        a2 = mutableFlatBuffer.g(i, 24);
        if (a2 != 0) {
            jsonGenerator.a("page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, a2, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.g(i, 25);
        if (a2 != 0) {
            jsonGenerator.a("parent_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, a2, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.g(i, 26);
        if (a2 != 0) {
            jsonGenerator.a("platform_images");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.g(i, 27);
        if (a2 != 0) {
            jsonGenerator.a("productCatalogImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 28);
        if (a2 != 0) {
            jsonGenerator.a("productImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 29);
        if (a2 != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 30);
        if (a2 != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 31);
        if (a2 != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 32);
        if (a2 != 0) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 33);
        if (a2 != 0) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 34);
        if (a2 != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, a2, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.g(i, 35);
        if (a2 != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 36);
        if (a) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 37) != 0) {
            jsonGenerator.a("reference_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 37));
        }
        a2 = mutableFlatBuffer.g(i, 38);
        if (a2 != 0) {
            jsonGenerator.a("sale_price");
            GraphQLCurrencyQuantityDeserializer.m4702a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 39);
        if (a2 != 0) {
            jsonGenerator.a("seller");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, a2, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.g(i, 40);
        if (a2 != 0) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 41);
        if (a2 != 0) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 42) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 42));
        }
        if (mutableFlatBuffer.g(i, 43) != 0) {
            jsonGenerator.a("variant_values");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 43), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 44, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_saved_state");
            jsonGenerator.b(((GraphQLSavedState) mutableFlatBuffer.a(i, 44, GraphQLSavedState.class)).name());
        }
        double a4 = mutableFlatBuffer.a(i, 45, 0.0d);
        if (a4 != 0.0d) {
            jsonGenerator.a("product_latitude");
            jsonGenerator.a(a4);
        }
        a4 = mutableFlatBuffer.a(i, 46, 0.0d);
        if (a4 != 0.0d) {
            jsonGenerator.a("product_longitude");
            jsonGenerator.a(a4);
        }
        jsonGenerator.g();
    }
}
