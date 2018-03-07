package com.facebook.pages.data.graphql.cards;

import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemsConnectionFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultAddressFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: context_item_icon_scale */
public class PageContextItemInfoCardGraphQLParsers {

    /* compiled from: context_item_icon_scale */
    public final class PageInfoCardContextItemQueryParser {

        /* compiled from: context_item_icon_scale */
        public final class MapBoundingBoxParser {
            public static int m20488a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m20489a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

        /* compiled from: context_item_icon_scale */
        public final class MenuInfoParser {
            public static int m20490a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[2];
                boolean[] zArr2 = new boolean[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("has_photo_menus")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("has_structured_menu")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, zArr2[1]);
                }
                return flatBufferBuilder.d();
            }

            public static void m20491a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("has_photo_menus");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("has_structured_menu");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m20492a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("address")) {
                        iArr[0] = DefaultAddressFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("contextItemInfoCards")) {
                        iArr[1] = ContextItemsConnectionFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_place_map_hidden")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("location")) {
                        iArr[3] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("map_bounding_box")) {
                        iArr[4] = MapBoundingBoxParser.m20488a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("map_zoom_level")) {
                        zArr[1] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("menu_info")) {
                        iArr[6] = MenuInfoParser.m20490a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("place_type")) {
                        iArr[7] = flatBufferBuilder.a(GraphQLPlaceType.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, zArr2[0]);
            }
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[1]) {
                flatBufferBuilder.a(5, iArr2[0], 0);
            }
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            return flatBufferBuilder.d();
        }
    }
}
