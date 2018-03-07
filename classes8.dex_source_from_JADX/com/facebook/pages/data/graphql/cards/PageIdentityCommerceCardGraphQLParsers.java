package com.facebook.pages.data.graphql.cards;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsParsers.ProductItemPriceFieldsParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: content_element */
public class PageIdentityCommerceCardGraphQLParsers {

    /* compiled from: content_element */
    public final class PageIdentityCommerceCardQueryParser {

        /* compiled from: content_element */
        public final class CommerceStoreParser {

            /* compiled from: content_element */
            public final class CommerceMerchantSettingsParser {
                public static int m20556a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    boolean[] zArr = new boolean[2];
                    boolean[] zArr2 = new boolean[1];
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("payment_provider")) {
                                zArr[0] = true;
                                iArr[0] = jsonParser.E();
                            } else if (i.equals("show_edit_interface")) {
                                zArr[1] = true;
                                zArr2[0] = jsonParser.H();
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
                        flatBufferBuilder.a(1, zArr2[0]);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m20557a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("payment_provider");
                        jsonGenerator.b(a);
                    }
                    boolean a2 = mutableFlatBuffer.a(i, 1);
                    if (a2) {
                        jsonGenerator.a("show_edit_interface");
                        jsonGenerator.a(a2);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: content_element */
            public final class OrderedCollectionsParser {

                /* compiled from: content_element */
                public final class NodesParser {

                    /* compiled from: content_element */
                    public final class CollectionProductItemsParser {

                        /* compiled from: content_element */
                        public final class CollectionProductItemsNodesParser {

                            /* compiled from: content_element */
                            public final class OrderedImagesParser {

                                /* compiled from: content_element */
                                public final class ImageParser {
                                    public static int m20558a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                                    public static void m20559a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                        jsonGenerator.f();
                                        if (mutableFlatBuffer.g(i, 0) != 0) {
                                            jsonGenerator.a("uri");
                                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                public static int m20560b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    int[] iArr = new int[1];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("image")) {
                                                iArr[0] = ImageParser.m20558a(jsonParser, flatBufferBuilder);
                                            } else {
                                                jsonParser.f();
                                            }
                                        }
                                    }
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, iArr[0]);
                                    return flatBufferBuilder.d();
                                }

                                public static void m20561b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    jsonGenerator.f();
                                    int g = mutableFlatBuffer.g(i, 0);
                                    if (g != 0) {
                                        jsonGenerator.a("image");
                                        ImageParser.m20559a(mutableFlatBuffer, g, jsonGenerator);
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            public static int m20562b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[4];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("id")) {
                                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("name")) {
                                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                        } else if (i.equals("ordered_images")) {
                                            int i2 = 0;
                                            ArrayList arrayList = new ArrayList();
                                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                                    arrayList.add(Integer.valueOf(OrderedImagesParser.m20560b(jsonParser, flatBufferBuilder)));
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
                                        } else if (i.equals("product_item_price")) {
                                            iArr[3] = ProductItemPriceFieldsParser.a(jsonParser, flatBufferBuilder);
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

                            public static void m20563b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("id");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                if (mutableFlatBuffer.g(i, 1) != 0) {
                                    jsonGenerator.a("name");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                }
                                int g = mutableFlatBuffer.g(i, 2);
                                if (g != 0) {
                                    jsonGenerator.a("ordered_images");
                                    jsonGenerator.d();
                                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                        OrderedImagesParser.m20561b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                    }
                                    jsonGenerator.e();
                                }
                                g = mutableFlatBuffer.g(i, 3);
                                if (g != 0) {
                                    jsonGenerator.a("product_item_price");
                                    ProductItemPriceFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m20564a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                                arrayList.add(Integer.valueOf(CollectionProductItemsNodesParser.m20562b(jsonParser, flatBufferBuilder)));
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

                        public static void m20565a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("nodes");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    CollectionProductItemsNodesParser.m20563b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.e();
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m20566b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("collection_product_items")) {
                                    iArr[0] = CollectionProductItemsParser.m20564a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("id")) {
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

                    public static void m20567b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("collection_product_items");
                            CollectionProductItemsParser.m20565a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m20568a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                        arrayList.add(Integer.valueOf(NodesParser.m20566b(jsonParser, flatBufferBuilder)));
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

                public static void m20569a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("nodes");
                        jsonGenerator.d();
                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                            NodesParser.m20567b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                        }
                        jsonGenerator.e();
                    }
                    jsonGenerator.g();
                }
            }

            public static int m20570a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("commerce_merchant_settings")) {
                            iArr[0] = CommerceMerchantSettingsParser.m20556a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("ordered_collections")) {
                            iArr[1] = OrderedCollectionsParser.m20568a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("url")) {
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

            public static void m20571a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("commerce_merchant_settings");
                    CommerceMerchantSettingsParser.m20557a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("ordered_collections");
                    OrderedCollectionsParser.m20569a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m20572a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("commerce_store")) {
                        iArr[0] = CommerceStoreParser.m20570a(jsonParser, flatBufferBuilder);
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
