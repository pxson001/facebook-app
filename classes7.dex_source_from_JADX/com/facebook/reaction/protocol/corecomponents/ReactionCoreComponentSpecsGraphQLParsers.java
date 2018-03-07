package com.facebook.reaction.protocol.corecomponents;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLReactionCoreComponentMargin;
import com.facebook.graphql.enums.GraphQLReactionCoreComponentPadding;
import com.facebook.graphql.enums.GraphQLReactionCoreTextAlignment;
import com.facebook.graphql.enums.GraphQLReactionCoreTextBoldness;
import com.facebook.graphql.enums.GraphQLReactionCoreTextLineSpacing;
import com.facebook.graphql.enums.GraphQLReactionCoreTextSize;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: filter_in_gallery_entries */
public class ReactionCoreComponentSpecsGraphQLParsers {

    /* compiled from: filter_in_gallery_entries */
    public final class ReactionCoreComponentBorderSpecFieldsParser {
        public static int m15284a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            boolean[] zArr = new boolean[4];
            boolean[] zArr2 = new boolean[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("bottom")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("left")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("right")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("top")) {
                        zArr[3] = true;
                        zArr2[3] = jsonParser.H();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(2, zArr2[2]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(3, zArr2[3]);
            }
            return flatBufferBuilder.d();
        }

        public static void m15285a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("bottom");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("left");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("right");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("top");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: filter_in_gallery_entries */
    public final class ReactionCoreComponentMarginSpecFieldsParser {
        public static int m15286a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("bottom")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLReactionCoreComponentMargin.fromString(jsonParser.o()));
                    } else if (i.equals("left")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLReactionCoreComponentMargin.fromString(jsonParser.o()));
                    } else if (i.equals("right")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLReactionCoreComponentMargin.fromString(jsonParser.o()));
                    } else if (i.equals("top")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLReactionCoreComponentMargin.fromString(jsonParser.o()));
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

        public static void m15287a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("bottom");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("left");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("right");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("top");
                jsonGenerator.b(mutableFlatBuffer.b(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: filter_in_gallery_entries */
    public final class ReactionCoreComponentPaddingSpecFieldsParser {
        public static int m15288a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("bottom")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLReactionCoreComponentPadding.fromString(jsonParser.o()));
                    } else if (i.equals("left")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLReactionCoreComponentPadding.fromString(jsonParser.o()));
                    } else if (i.equals("right")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLReactionCoreComponentPadding.fromString(jsonParser.o()));
                    } else if (i.equals("top")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLReactionCoreComponentPadding.fromString(jsonParser.o()));
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

        public static void m15289a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("bottom");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("left");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("right");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("top");
                jsonGenerator.b(mutableFlatBuffer.b(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: filter_in_gallery_entries */
    public final class ReactionCoreComponentTextSpecFieldsParser {
        public static int m15290a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[10];
            boolean[] zArr = new boolean[4];
            boolean[] zArr2 = new boolean[3];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("core_attribute_alignment")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLReactionCoreTextAlignment.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_boldness")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLReactionCoreTextBoldness.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_chevron")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("core_attribute_color")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("core_attribute_line_spacing")) {
                        iArr[4] = flatBufferBuilder.a(GraphQLReactionCoreTextLineSpacing.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_line_wrap")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("core_attribute_text_size")) {
                        iArr[6] = flatBufferBuilder.a(GraphQLReactionCoreTextSize.fromString(jsonParser.o()));
                    } else if (i.equals("core_attribute_truncation_lines")) {
                        zArr[2] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("core_attribute_truncation_text")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("core_attribute_uppercase_transform")) {
                        zArr[3] = true;
                        zArr2[2] = jsonParser.H();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, zArr2[0]);
            }
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[1]) {
                flatBufferBuilder.a(5, zArr2[1]);
            }
            flatBufferBuilder.b(6, iArr[6]);
            if (zArr[2]) {
                flatBufferBuilder.a(7, iArr2[0], 0);
            }
            flatBufferBuilder.b(8, iArr[8]);
            if (zArr[3]) {
                flatBufferBuilder.a(9, zArr2[2]);
            }
            return flatBufferBuilder.d();
        }

        public static void m15291a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("core_attribute_alignment");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("core_attribute_boldness");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            boolean a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("core_attribute_chevron");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("core_attribute_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("core_attribute_line_spacing");
                jsonGenerator.b(mutableFlatBuffer.b(i, 4));
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("core_attribute_line_wrap");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("core_attribute_text_size");
                jsonGenerator.b(mutableFlatBuffer.b(i, 6));
            }
            int a2 = mutableFlatBuffer.a(i, 7, 0);
            if (a2 != 0) {
                jsonGenerator.a("core_attribute_truncation_lines");
                jsonGenerator.b(a2);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("core_attribute_truncation_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("core_attribute_uppercase_transform");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }
}
