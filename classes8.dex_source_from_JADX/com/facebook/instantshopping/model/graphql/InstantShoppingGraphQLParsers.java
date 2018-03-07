package com.facebook.instantshopping.model.graphql;

import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.FBFullImageFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.graphql.enums.GraphQLInstantShoppingActionType;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentAlignmentDescriptorType;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentElementType;
import com.facebook.graphql.enums.GraphQLInstantShoppingHeaderElementType;
import com.facebook.graphql.enums.GraphQLInstantShoppingPostActionNoticeStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBVideoParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: update_activity_log */
public class InstantShoppingGraphQLParsers {

    /* compiled from: update_activity_log */
    public final class InstantShoppingActionFragmentParser {
        public static int m1277a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action_type")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLInstantShoppingActionType.fromString(jsonParser.o()));
                    } else if (i.equals("notice_style")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLInstantShoppingPostActionNoticeStyle.fromString(jsonParser.o()));
                    } else if (i.equals("notice_text")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("options")) {
                        iArr[4] = InstantShoppingSelectorOptionsFragmentParser.m1325a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("post_uri")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("should_reload")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("target_uri")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("title")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(9);
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
            return flatBufferBuilder.d();
        }

        public static void m1278a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("action_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("notice_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("notice_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            int g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("options");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    InstantShoppingSelectorOptionsFragmentParser.m1327b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("post_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            boolean a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("should_reload");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("target_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingCatalogQueryParser {
        public static MutableFlatBuffer m1279a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("catalog_document")) {
                        iArr[0] = InstantShoppingDocumentFragmentParser.m1299a(jsonParser, flatBufferBuilder);
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

    /* compiled from: update_activity_log */
    public final class InstantShoppingColorSelectorColorFragmentParser {
        public static int m1282b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("fill_color")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image")) {
                        iArr[2] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("style")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("text")) {
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

        public static int m1280a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m1282b(jsonParser, flatBufferBuilder)));
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

        public static void m1281a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m1283b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m1283b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("action");
                InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("fill_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("image");
                FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("style");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingCompositeBlockElementFragmentParser {

        /* compiled from: update_activity_log */
        public final class BlockElementsParser {
            public static int m1286b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[22];
                boolean[] zArr = new boolean[2];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("action")) {
                            iArr[1] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("annotations")) {
                            iArr[2] = InstantShoppingTextElementFragmentParser.m1330b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("autoplay_style")) {
                            iArr[3] = flatBufferBuilder.a(GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o()));
                        } else if (i.equals("child_elements")) {
                            iArr[4] = InstantShoppingPhotoElementFragmentParser.m1320a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("color")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("color_types")) {
                            iArr[6] = InstantShoppingColorSelectorColorFragmentParser.m1280a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("content_element")) {
                            iArr[7] = InstantShoppingTextElementFragmentParser.m1328a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("control_style")) {
                            iArr[8] = flatBufferBuilder.a(GraphQLDocumentVideoControlStyle.fromString(jsonParser.o()));
                        } else if (i.equals("document_element_type")) {
                            iArr[9] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                        } else if (i.equals("element_descriptor")) {
                            iArr[10] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_photo")) {
                            iArr[11] = ElementPhotoParser.m1318a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_text")) {
                            iArr[12] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_video")) {
                            iArr[13] = FBVideoParser.m6473a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("grid_width_percent")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("image")) {
                            iArr[15] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("logging_token")) {
                            iArr[16] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("looping_style")) {
                            iArr[17] = flatBufferBuilder.a(GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o()));
                        } else if (i.equals("section_header")) {
                            iArr[18] = InstantShoppingTextElementFragmentParser.m1328a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("selected_index")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("style_list")) {
                            iArr[20] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("target_uri")) {
                            iArr[21] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(22);
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
                flatBufferBuilder.b(16, iArr[16]);
                flatBufferBuilder.b(17, iArr[17]);
                flatBufferBuilder.b(18, iArr[18]);
                if (zArr[1]) {
                    flatBufferBuilder.a(19, iArr2[1], 0);
                }
                flatBufferBuilder.b(20, iArr[20]);
                flatBufferBuilder.b(21, iArr[21]);
                return flatBufferBuilder.d();
            }

            public static int m1284a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m1286b(jsonParser, flatBufferBuilder)));
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

            public static void m1285a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m1287b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m1287b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("annotations");
                    InstantShoppingTextElementFragmentParser.m1329a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("autoplay_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("child_elements");
                    InstantShoppingPhotoElementFragmentParser.m1321a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("color_types");
                    InstantShoppingColorSelectorColorFragmentParser.m1281a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("content_element");
                    InstantShoppingTextElementFragmentParser.m1331b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 8) != 0) {
                    jsonGenerator.a("control_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 8));
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 9));
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("element_descriptor");
                    InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("element_photo");
                    ElementPhotoParser.m1319a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 12);
                if (g != 0) {
                    jsonGenerator.a("element_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 13);
                if (g != 0) {
                    jsonGenerator.a("element_video");
                    FBVideoParser.m6474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 14, 0);
                if (g != 0) {
                    jsonGenerator.a("grid_width_percent");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("image");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 16) != 0) {
                    jsonGenerator.a("logging_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 16));
                }
                if (mutableFlatBuffer.g(i, 17) != 0) {
                    jsonGenerator.a("looping_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 17));
                }
                g = mutableFlatBuffer.g(i, 18);
                if (g != 0) {
                    jsonGenerator.a("section_header");
                    InstantShoppingTextElementFragmentParser.m1331b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 19, 0);
                if (g != 0) {
                    jsonGenerator.a("selected_index");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 20) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 20), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 21) != 0) {
                    jsonGenerator.a("target_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 21));
                }
                jsonGenerator.g();
            }
        }

        public static int m1288a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("block_elements")) {
                        iArr[0] = BlockElementsParser.m1284a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_element_type")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                    } else if (i.equals("element_descriptor")) {
                        iArr[2] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("grid_width_percent")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("logging_token")) {
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
            if (zArr[0]) {
                flatBufferBuilder.a(3, iArr2[0], 0);
            }
            flatBufferBuilder.b(4, iArr[4]);
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingDocumentFragmentParser {

        /* compiled from: update_activity_log */
        public final class DocumentBodyElementsParser {
            public static int m1289a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(ShoppingDocumentElementsEdgeParser.m1337b(jsonParser, flatBufferBuilder)));
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

            public static void m1290a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        ShoppingDocumentElementsEdgeParser.m1338b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: update_activity_log */
        public final class FooterElementsParser {
            public static int m1292b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[15];
                boolean[] zArr = new boolean[2];
                boolean[] zArr2 = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("action")) {
                            iArr[1] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("color")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("do_action")) {
                            iArr[3] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("document_element_type")) {
                            iArr[4] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                        } else if (i.equals("element_descriptor")) {
                            iArr[5] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_text")) {
                            iArr[6] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("grid_width_percent")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("is_on")) {
                            zArr[1] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("logging_token")) {
                            iArr[9] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("off_text")) {
                            iArr[10] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("on_text")) {
                            iArr[11] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("style_list")) {
                            iArr[12] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("target_uri")) {
                            iArr[13] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("undo_action")) {
                            iArr[14] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(15);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                if (zArr[0]) {
                    flatBufferBuilder.a(7, iArr2[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(8, zArr2[0]);
                }
                flatBufferBuilder.b(9, iArr[9]);
                flatBufferBuilder.b(10, iArr[10]);
                flatBufferBuilder.b(11, iArr[11]);
                flatBufferBuilder.b(12, iArr[12]);
                flatBufferBuilder.b(13, iArr[13]);
                flatBufferBuilder.b(14, iArr[14]);
                return flatBufferBuilder.d();
            }

            public static int m1291a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m1292b(jsonParser, flatBufferBuilder)));
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

            public static void m1293b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("do_action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 4));
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("element_descriptor");
                    InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("element_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 7, 0);
                if (g != 0) {
                    jsonGenerator.a("grid_width_percent");
                    jsonGenerator.b(g);
                }
                boolean a = mutableFlatBuffer.a(i, 8);
                if (a) {
                    jsonGenerator.a("is_on");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("logging_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("off_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("on_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 12) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 12), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("target_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("undo_action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: update_activity_log */
        public final class FooterParser {
            public static int m1294a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[13];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("action")) {
                            iArr[1] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("annotations")) {
                            iArr[2] = InstantShoppingTextElementFragmentParser.m1330b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("color")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("document_element_type")) {
                            iArr[4] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                        } else if (i.equals("element_descriptor")) {
                            iArr[5] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_photo")) {
                            iArr[6] = ElementPhotoParser.m1318a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_text")) {
                            iArr[7] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("grid_width_percent")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("image")) {
                            iArr[9] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("logging_token")) {
                            iArr[10] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("style_list")) {
                            iArr[11] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("target_uri")) {
                            iArr[12] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(13);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                flatBufferBuilder.b(7, iArr[7]);
                if (zArr[0]) {
                    flatBufferBuilder.a(8, iArr2[0], 0);
                }
                flatBufferBuilder.b(9, iArr[9]);
                flatBufferBuilder.b(10, iArr[10]);
                flatBufferBuilder.b(11, iArr[11]);
                flatBufferBuilder.b(12, iArr[12]);
                return flatBufferBuilder.d();
            }

            public static void m1295a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("annotations");
                    InstantShoppingTextElementFragmentParser.m1329a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 4));
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("element_descriptor");
                    InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("element_photo");
                    ElementPhotoParser.m1319a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("element_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 8, 0);
                if (g != 0) {
                    jsonGenerator.a("grid_width_percent");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 9);
                if (g != 0) {
                    jsonGenerator.a("image");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 10) != 0) {
                    jsonGenerator.a("logging_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 10));
                }
                if (mutableFlatBuffer.g(i, 11) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 11), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 12) != 0) {
                    jsonGenerator.a("target_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: update_activity_log */
        public final class HeaderElementsParser {
            public static int m1297b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[6];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("action")) {
                            iArr[1] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("header_element_type")) {
                            iArr[2] = flatBufferBuilder.a(GraphQLInstantShoppingHeaderElementType.fromString(jsonParser.o()));
                        } else if (i.equals("logging_token")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("selected")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("tooltip_title")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                if (zArr[0]) {
                    flatBufferBuilder.a(4, zArr2[0]);
                }
                flatBufferBuilder.b(5, iArr[5]);
                return flatBufferBuilder.d();
            }

            public static int m1296a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m1297b(jsonParser, flatBufferBuilder)));
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

            public static void m1298b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("header_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("logging_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                boolean a = mutableFlatBuffer.a(i, 4);
                if (a) {
                    jsonGenerator.a("selected");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("tooltip_title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                jsonGenerator.g();
            }
        }

        public static int m1299a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[10];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("background_color")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("custom_fonts")) {
                        iArr[1] = InstantShoppingFontObjectFragmentParser.m1303a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_body_elements")) {
                        iArr[2] = DocumentBodyElementsParser.m1289a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("footer")) {
                        iArr[3] = FooterParser.m1294a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("footer_elements")) {
                        iArr[4] = FooterElementsParser.m1291a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_elements")) {
                        iArr[5] = HeaderElementsParser.m1296a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("show_see_more_chrome")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("style_list")) {
                        iArr[7] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("third_party_logging_urls")) {
                        iArr[8] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
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
            return flatBufferBuilder.d();
        }

        public static void m1300a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            int i2;
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("custom_fonts");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    InstantShoppingFontObjectFragmentParser.m1304a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("document_body_elements");
                DocumentBodyElementsParser.m1290a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("footer");
                FooterParser.m1295a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("footer_elements");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    FooterElementsParser.m1293b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("header_elements");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    HeaderElementsParser.m1298b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            boolean a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("show_see_more_chrome");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("style_list");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 7), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("third_party_logging_urls");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 8), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingElementDescriptorFragmentParser {
        public static int m1301a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[8];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("alignment")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentAlignmentDescriptorType.fromString(jsonParser.o()));
                    } else if (i.equals("background_color")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("bottom_margin")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("left_margin")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("right_margin")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("text_metrics")) {
                        iArr[5] = InstantShoppingTextMetricsDescriptorFragmentParser.m1332a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("top_margin")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("vertical_constraint")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            return flatBufferBuilder.d();
        }

        public static void m1302a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("alignment");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("bottom_margin");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("left_margin");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("right_margin");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            int g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("text_metrics");
                InstantShoppingTextMetricsDescriptorFragmentParser.m1333a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("top_margin");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("vertical_constraint");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingFontObjectFragmentParser {
        public static int m1305b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("is_compressed")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("is_font_family")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("resource_name")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("resource_version")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(5);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            return flatBufferBuilder.d();
        }

        public static int m1303a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m1305b(jsonParser, flatBufferBuilder)));
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

        public static void m1304a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("is_compressed");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("is_font_family");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("resource_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("resource_version");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingFooterElementFragmentParser {

        /* compiled from: update_activity_log */
        public final class FooterElementsParser {
            public static int m1308b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[28];
                boolean[] zArr = new boolean[3];
                boolean[] zArr2 = new boolean[1];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("action")) {
                            iArr[1] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("annotations")) {
                            iArr[2] = InstantShoppingTextElementFragmentParser.m1330b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("autoplay_style")) {
                            iArr[3] = flatBufferBuilder.a(GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o()));
                        } else if (i.equals("block_elements")) {
                            iArr[4] = BlockElementsParser.m1284a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("child_elements")) {
                            iArr[5] = InstantShoppingPhotoElementFragmentParser.m1320a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("color")) {
                            iArr[6] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("color_types")) {
                            iArr[7] = InstantShoppingColorSelectorColorFragmentParser.m1280a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("content_element")) {
                            iArr[8] = InstantShoppingTextElementFragmentParser.m1328a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("control_style")) {
                            iArr[9] = flatBufferBuilder.a(GraphQLDocumentVideoControlStyle.fromString(jsonParser.o()));
                        } else if (i.equals("do_action")) {
                            iArr[10] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("document_element_type")) {
                            iArr[11] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                        } else if (i.equals("element_descriptor")) {
                            iArr[12] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_photo")) {
                            iArr[13] = ElementPhotoParser.m1318a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_text")) {
                            iArr[14] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_video")) {
                            iArr[15] = FBVideoParser.m6473a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("grid_width_percent")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("image")) {
                            iArr[17] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("is_on")) {
                            zArr[1] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("logging_token")) {
                            iArr[19] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("looping_style")) {
                            iArr[20] = flatBufferBuilder.a(GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o()));
                        } else if (i.equals("off_text")) {
                            iArr[21] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("on_text")) {
                            iArr[22] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("section_header")) {
                            iArr[23] = InstantShoppingTextElementFragmentParser.m1328a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("selected_index")) {
                            zArr[2] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("style_list")) {
                            iArr[25] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("target_uri")) {
                            iArr[26] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("undo_action")) {
                            iArr[27] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(28);
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
                flatBufferBuilder.b(14, iArr[14]);
                flatBufferBuilder.b(15, iArr[15]);
                if (zArr[0]) {
                    flatBufferBuilder.a(16, iArr2[0], 0);
                }
                flatBufferBuilder.b(17, iArr[17]);
                if (zArr[1]) {
                    flatBufferBuilder.a(18, zArr2[0]);
                }
                flatBufferBuilder.b(19, iArr[19]);
                flatBufferBuilder.b(20, iArr[20]);
                flatBufferBuilder.b(21, iArr[21]);
                flatBufferBuilder.b(22, iArr[22]);
                flatBufferBuilder.b(23, iArr[23]);
                if (zArr[2]) {
                    flatBufferBuilder.a(24, iArr2[1], 0);
                }
                flatBufferBuilder.b(25, iArr[25]);
                flatBufferBuilder.b(26, iArr[26]);
                flatBufferBuilder.b(27, iArr[27]);
                return flatBufferBuilder.d();
            }

            public static int m1306a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m1308b(jsonParser, flatBufferBuilder)));
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

            public static void m1307a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m1309b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m1309b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("annotations");
                    InstantShoppingTextElementFragmentParser.m1329a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("autoplay_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("block_elements");
                    BlockElementsParser.m1285a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("child_elements");
                    InstantShoppingPhotoElementFragmentParser.m1321a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("color_types");
                    InstantShoppingColorSelectorColorFragmentParser.m1281a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 8);
                if (g != 0) {
                    jsonGenerator.a("content_element");
                    InstantShoppingTextElementFragmentParser.m1331b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("control_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 9));
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("do_action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 11) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 11));
                }
                g = mutableFlatBuffer.g(i, 12);
                if (g != 0) {
                    jsonGenerator.a("element_descriptor");
                    InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 13);
                if (g != 0) {
                    jsonGenerator.a("element_photo");
                    ElementPhotoParser.m1319a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("element_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("element_video");
                    FBVideoParser.m6474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 16, 0);
                if (g != 0) {
                    jsonGenerator.a("grid_width_percent");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("image");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(i, 18);
                if (a) {
                    jsonGenerator.a("is_on");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 19) != 0) {
                    jsonGenerator.a("logging_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 19));
                }
                if (mutableFlatBuffer.g(i, 20) != 0) {
                    jsonGenerator.a("looping_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 20));
                }
                g = mutableFlatBuffer.g(i, 21);
                if (g != 0) {
                    jsonGenerator.a("off_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 22);
                if (g != 0) {
                    jsonGenerator.a("on_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 23);
                if (g != 0) {
                    jsonGenerator.a("section_header");
                    InstantShoppingTextElementFragmentParser.m1331b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 24, 0);
                if (g != 0) {
                    jsonGenerator.a("selected_index");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 25) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 25), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 26) != 0) {
                    jsonGenerator.a("target_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 26));
                }
                g = mutableFlatBuffer.g(i, 27);
                if (g != 0) {
                    jsonGenerator.a("undo_action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m1310a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("document_element_type")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                    } else if (i.equals("element_descriptor")) {
                        iArr[1] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("footer_elements")) {
                        iArr[2] = FooterElementsParser.m1306a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("style_list")) {
                        iArr[3] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingHeaderElementFragmentParser {

        /* compiled from: update_activity_log */
        public final class HeaderElementsParser {
            public static int m1313b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[28];
                boolean[] zArr = new boolean[3];
                boolean[] zArr2 = new boolean[1];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("action")) {
                            iArr[1] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("annotations")) {
                            iArr[2] = InstantShoppingTextElementFragmentParser.m1330b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("autoplay_style")) {
                            iArr[3] = flatBufferBuilder.a(GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o()));
                        } else if (i.equals("block_elements")) {
                            iArr[4] = BlockElementsParser.m1284a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("child_elements")) {
                            iArr[5] = InstantShoppingPhotoElementFragmentParser.m1320a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("color")) {
                            iArr[6] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("color_types")) {
                            iArr[7] = InstantShoppingColorSelectorColorFragmentParser.m1280a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("content_element")) {
                            iArr[8] = InstantShoppingTextElementFragmentParser.m1328a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("control_style")) {
                            iArr[9] = flatBufferBuilder.a(GraphQLDocumentVideoControlStyle.fromString(jsonParser.o()));
                        } else if (i.equals("do_action")) {
                            iArr[10] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("document_element_type")) {
                            iArr[11] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                        } else if (i.equals("element_descriptor")) {
                            iArr[12] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_photo")) {
                            iArr[13] = ElementPhotoParser.m1318a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_text")) {
                            iArr[14] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_video")) {
                            iArr[15] = FBVideoParser.m6473a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("grid_width_percent")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("image")) {
                            iArr[17] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("is_on")) {
                            zArr[1] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("logging_token")) {
                            iArr[19] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("looping_style")) {
                            iArr[20] = flatBufferBuilder.a(GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o()));
                        } else if (i.equals("off_text")) {
                            iArr[21] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("on_text")) {
                            iArr[22] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("section_header")) {
                            iArr[23] = InstantShoppingTextElementFragmentParser.m1328a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("selected_index")) {
                            zArr[2] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("style_list")) {
                            iArr[25] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("target_uri")) {
                            iArr[26] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("undo_action")) {
                            iArr[27] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(28);
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
                flatBufferBuilder.b(14, iArr[14]);
                flatBufferBuilder.b(15, iArr[15]);
                if (zArr[0]) {
                    flatBufferBuilder.a(16, iArr2[0], 0);
                }
                flatBufferBuilder.b(17, iArr[17]);
                if (zArr[1]) {
                    flatBufferBuilder.a(18, zArr2[0]);
                }
                flatBufferBuilder.b(19, iArr[19]);
                flatBufferBuilder.b(20, iArr[20]);
                flatBufferBuilder.b(21, iArr[21]);
                flatBufferBuilder.b(22, iArr[22]);
                flatBufferBuilder.b(23, iArr[23]);
                if (zArr[2]) {
                    flatBufferBuilder.a(24, iArr2[1], 0);
                }
                flatBufferBuilder.b(25, iArr[25]);
                flatBufferBuilder.b(26, iArr[26]);
                flatBufferBuilder.b(27, iArr[27]);
                return flatBufferBuilder.d();
            }

            public static int m1311a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m1313b(jsonParser, flatBufferBuilder)));
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

            public static void m1312a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m1314b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m1314b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("annotations");
                    InstantShoppingTextElementFragmentParser.m1329a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("autoplay_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("block_elements");
                    BlockElementsParser.m1285a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("child_elements");
                    InstantShoppingPhotoElementFragmentParser.m1321a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("color_types");
                    InstantShoppingColorSelectorColorFragmentParser.m1281a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 8);
                if (g != 0) {
                    jsonGenerator.a("content_element");
                    InstantShoppingTextElementFragmentParser.m1331b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("control_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 9));
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("do_action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 11) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 11));
                }
                g = mutableFlatBuffer.g(i, 12);
                if (g != 0) {
                    jsonGenerator.a("element_descriptor");
                    InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 13);
                if (g != 0) {
                    jsonGenerator.a("element_photo");
                    ElementPhotoParser.m1319a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("element_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("element_video");
                    FBVideoParser.m6474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 16, 0);
                if (g != 0) {
                    jsonGenerator.a("grid_width_percent");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("image");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(i, 18);
                if (a) {
                    jsonGenerator.a("is_on");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 19) != 0) {
                    jsonGenerator.a("logging_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 19));
                }
                if (mutableFlatBuffer.g(i, 20) != 0) {
                    jsonGenerator.a("looping_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 20));
                }
                g = mutableFlatBuffer.g(i, 21);
                if (g != 0) {
                    jsonGenerator.a("off_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 22);
                if (g != 0) {
                    jsonGenerator.a("on_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 23);
                if (g != 0) {
                    jsonGenerator.a("section_header");
                    InstantShoppingTextElementFragmentParser.m1331b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 24, 0);
                if (g != 0) {
                    jsonGenerator.a("selected_index");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 25) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 25), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 26) != 0) {
                    jsonGenerator.a("target_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 26));
                }
                g = mutableFlatBuffer.g(i, 27);
                if (g != 0) {
                    jsonGenerator.a("undo_action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m1315a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("document_element_type")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                    } else if (i.equals("element_descriptor")) {
                        iArr[1] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_elements")) {
                        iArr[2] = HeaderElementsParser.m1311a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("logging_token")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("style_list")) {
                        iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingOptionsActionFragmentParser {
        public static int m1316a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("action_type")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLInstantShoppingActionType.fromString(jsonParser.o()));
                    } else if (i.equals("notice_style")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLInstantShoppingPostActionNoticeStyle.fromString(jsonParser.o()));
                    } else if (i.equals("notice_text")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("post_uri")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("should_reload")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("target_uri")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
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
                flatBufferBuilder.a(5, zArr2[0]);
            }
            flatBufferBuilder.b(6, iArr[6]);
            return flatBufferBuilder.d();
        }

        public static void m1317a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("action_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("notice_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("notice_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("post_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            boolean a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("should_reload");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("target_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingPhotoElementFragmentParser {

        /* compiled from: update_activity_log */
        public final class ElementPhotoParser {
            public static int m1318a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("preview_payload")) {
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

            public static void m1319a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("preview_payload");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m1322b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[10];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("annotations")) {
                        iArr[1] = InstantShoppingTextElementFragmentParser.m1330b(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_element_type")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                    } else if (i.equals("element_descriptor")) {
                        iArr[3] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("element_photo")) {
                        iArr[4] = ElementPhotoParser.m1318a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("grid_width_percent")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("image")) {
                        iArr[6] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("logging_token")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("style_list")) {
                        iArr[8] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("target_uri")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[0]) {
                flatBufferBuilder.a(5, iArr2[0], 0);
            }
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            return flatBufferBuilder.d();
        }

        public static int m1320a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m1322b(jsonParser, flatBufferBuilder)));
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

        public static void m1321a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m1323b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m1323b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("action");
                InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("annotations");
                InstantShoppingTextElementFragmentParser.m1329a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("document_element_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("element_descriptor");
                InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("element_photo");
                ElementPhotoParser.m1319a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 5, 0);
            if (g != 0) {
                jsonGenerator.a("grid_width_percent");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("image");
                FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("logging_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("style_list");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 8), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("target_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingProductQueryParser {
        public static MutableFlatBuffer m1324a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("product_document")) {
                        iArr[0] = InstantShoppingDocumentFragmentParser.m1299a(jsonParser, flatBufferBuilder);
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

    /* compiled from: update_activity_log */
    public final class InstantShoppingSelectorOptionsFragmentParser {
        public static int m1326b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = InstantShoppingOptionsActionFragmentParser.m1316a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_enabled")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("name")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            return flatBufferBuilder.d();
        }

        public static int m1325a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m1326b(jsonParser, flatBufferBuilder)));
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

        public static void m1327b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("action");
                InstantShoppingOptionsActionFragmentParser.m1317a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("is_enabled");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingTextElementFragmentParser {
        public static int m1328a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("action")) {
                        iArr[0] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_element_type")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                    } else if (i.equals("element_descriptor")) {
                        iArr[2] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("element_text")) {
                        iArr[3] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("grid_width_percent")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("logging_token")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("style_list")) {
                        iArr[6] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
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
            if (zArr[0]) {
                flatBufferBuilder.a(4, iArr2[0], 0);
            }
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            return flatBufferBuilder.d();
        }

        public static int m1330b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m1328a(jsonParser, flatBufferBuilder)));
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

        public static void m1329a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m1331b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m1331b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("action");
                InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("document_element_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("element_descriptor");
                InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("element_text");
                RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.a(i, 4, 0);
            if (g != 0) {
                jsonGenerator.a("grid_width_percent");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("logging_token");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("style_list");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 6), jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: update_activity_log */
    public final class InstantShoppingTextMetricsDescriptorFragmentParser {
        public static int m1332a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("capitalization_style")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("font_family")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("font_size")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("line_height")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("max_lines")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("text_color")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("word_kerning")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
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
            if (zArr[0]) {
                flatBufferBuilder.a(4, iArr2[0], 0);
            }
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            return flatBufferBuilder.d();
        }

        public static void m1333a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("capitalization_style");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("font_family");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("font_size");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("line_height");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            int a = mutableFlatBuffer.a(i, 4, 0);
            if (a != 0) {
                jsonGenerator.a("max_lines");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("text_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("word_kerning");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: update_activity_log */
    public final class RichMediaDocumentQueryParser {
        public static MutableFlatBuffer m1334a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("document")) {
                        iArr[0] = InstantShoppingDocumentFragmentParser.m1299a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: update_activity_log */
    public final class ShoppingDocumentElementsEdgeParser {

        /* compiled from: update_activity_log */
        public final class NodeParser {
            public static int m1335a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[30];
                boolean[] zArr = new boolean[3];
                boolean[] zArr2 = new boolean[1];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("action")) {
                            iArr[1] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("annotations")) {
                            iArr[2] = InstantShoppingTextElementFragmentParser.m1330b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("autoplay_style")) {
                            iArr[3] = flatBufferBuilder.a(GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o()));
                        } else if (i.equals("block_elements")) {
                            iArr[4] = BlockElementsParser.m1284a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("child_elements")) {
                            iArr[5] = InstantShoppingPhotoElementFragmentParser.m1320a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("color")) {
                            iArr[6] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("color_types")) {
                            iArr[7] = InstantShoppingColorSelectorColorFragmentParser.m1280a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("content_element")) {
                            iArr[8] = InstantShoppingTextElementFragmentParser.m1328a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("control_style")) {
                            iArr[9] = flatBufferBuilder.a(GraphQLDocumentVideoControlStyle.fromString(jsonParser.o()));
                        } else if (i.equals("do_action")) {
                            iArr[10] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("document_element_type")) {
                            iArr[11] = flatBufferBuilder.a(GraphQLInstantShoppingDocumentElementType.fromString(jsonParser.o()));
                        } else if (i.equals("element_descriptor")) {
                            iArr[12] = InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_photo")) {
                            iArr[13] = ElementPhotoParser.m1318a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_text")) {
                            iArr[14] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_video")) {
                            iArr[15] = FBVideoParser.m6473a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("footer_elements")) {
                            iArr[16] = FooterElementsParser.m1306a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("grid_width_percent")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("header_elements")) {
                            iArr[18] = HeaderElementsParser.m1311a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image")) {
                            iArr[19] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("is_on")) {
                            zArr[1] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("logging_token")) {
                            iArr[21] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("looping_style")) {
                            iArr[22] = flatBufferBuilder.a(GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o()));
                        } else if (i.equals("off_text")) {
                            iArr[23] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("on_text")) {
                            iArr[24] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("section_header")) {
                            iArr[25] = InstantShoppingTextElementFragmentParser.m1328a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("selected_index")) {
                            zArr[2] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("style_list")) {
                            iArr[27] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("target_uri")) {
                            iArr[28] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("undo_action")) {
                            iArr[29] = InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(30);
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
                flatBufferBuilder.b(14, iArr[14]);
                flatBufferBuilder.b(15, iArr[15]);
                flatBufferBuilder.b(16, iArr[16]);
                if (zArr[0]) {
                    flatBufferBuilder.a(17, iArr2[0], 0);
                }
                flatBufferBuilder.b(18, iArr[18]);
                flatBufferBuilder.b(19, iArr[19]);
                if (zArr[1]) {
                    flatBufferBuilder.a(20, zArr2[0]);
                }
                flatBufferBuilder.b(21, iArr[21]);
                flatBufferBuilder.b(22, iArr[22]);
                flatBufferBuilder.b(23, iArr[23]);
                flatBufferBuilder.b(24, iArr[24]);
                flatBufferBuilder.b(25, iArr[25]);
                if (zArr[2]) {
                    flatBufferBuilder.a(26, iArr2[1], 0);
                }
                flatBufferBuilder.b(27, iArr[27]);
                flatBufferBuilder.b(28, iArr[28]);
                flatBufferBuilder.b(29, iArr[29]);
                return flatBufferBuilder.d();
            }

            public static void m1336a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("annotations");
                    InstantShoppingTextElementFragmentParser.m1329a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("autoplay_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("block_elements");
                    BlockElementsParser.m1285a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("child_elements");
                    InstantShoppingPhotoElementFragmentParser.m1321a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("color_types");
                    InstantShoppingColorSelectorColorFragmentParser.m1281a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 8);
                if (g != 0) {
                    jsonGenerator.a("content_element");
                    InstantShoppingTextElementFragmentParser.m1331b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("control_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 9));
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("do_action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 11) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 11));
                }
                g = mutableFlatBuffer.g(i, 12);
                if (g != 0) {
                    jsonGenerator.a("element_descriptor");
                    InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 13);
                if (g != 0) {
                    jsonGenerator.a("element_photo");
                    ElementPhotoParser.m1319a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("element_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("element_video");
                    FBVideoParser.m6474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 16);
                if (g != 0) {
                    jsonGenerator.a("footer_elements");
                    FooterElementsParser.m1307a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 17, 0);
                if (g != 0) {
                    jsonGenerator.a("grid_width_percent");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(i, 18);
                if (g != 0) {
                    jsonGenerator.a("header_elements");
                    HeaderElementsParser.m1312a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 19);
                if (g != 0) {
                    jsonGenerator.a("image");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(i, 20);
                if (a) {
                    jsonGenerator.a("is_on");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 21) != 0) {
                    jsonGenerator.a("logging_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 21));
                }
                if (mutableFlatBuffer.g(i, 22) != 0) {
                    jsonGenerator.a("looping_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 22));
                }
                g = mutableFlatBuffer.g(i, 23);
                if (g != 0) {
                    jsonGenerator.a("off_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 24);
                if (g != 0) {
                    jsonGenerator.a("on_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 25);
                if (g != 0) {
                    jsonGenerator.a("section_header");
                    InstantShoppingTextElementFragmentParser.m1331b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 26, 0);
                if (g != 0) {
                    jsonGenerator.a("selected_index");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 27) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 27), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 28) != 0) {
                    jsonGenerator.a("target_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 28));
                }
                g = mutableFlatBuffer.g(i, 29);
                if (g != 0) {
                    jsonGenerator.a("undo_action");
                    InstantShoppingActionFragmentParser.m1278a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m1337b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("node")) {
                        iArr[0] = NodeParser.m1335a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m1338b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("node");
                NodeParser.m1336a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }
}
