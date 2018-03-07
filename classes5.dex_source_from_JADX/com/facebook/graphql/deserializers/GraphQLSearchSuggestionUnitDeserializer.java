package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: mtouch_post_checkin_prompt */
public class GraphQLSearchSuggestionUnitDeserializer {
    public static int m5868a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[12];
        boolean[] zArr = new boolean[4];
        boolean[] zArr2 = new boolean[3];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("does_viewer_like")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("icon_image")) {
                    iArr[2] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_verified")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("is_viewer_friend")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("name")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profile_picture")) {
                    iArr[7] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("query_title")) {
                    iArr[8] = GraphQLGraphSearchQueryTitleDeserializer.m5103a(jsonParser, flatBufferBuilder);
                } else if (i.equals("search_result_style_list")) {
                    iArr[9] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLGraphSearchResultsDisplayStyle.class);
                } else if (i.equals("url")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("viewer_saved_state")) {
                    zArr[3] = true;
                    enumArr[0] = GraphQLSavedState.fromString(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(12);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, zArr2[0]);
        }
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(5, zArr2[2]);
        }
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        if (zArr[3]) {
            flatBufferBuilder.a(11, enumArr[0]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5869a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5868a(jsonParser, flatBufferBuilder);
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

    public static void m5870a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        boolean a = mutableFlatBuffer.a(i, 1);
        if (a) {
            jsonGenerator.a("does_viewer_like");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("icon_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("is_verified");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 5);
        if (a) {
            jsonGenerator.a("is_viewer_friend");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("query_title");
            GraphQLGraphSearchQueryTitleDeserializer.m5105a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("search_result_style_list");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 9), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        if (mutableFlatBuffer.a(i, 11, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_saved_state");
            jsonGenerator.b(((GraphQLSavedState) mutableFlatBuffer.a(i, 11, GraphQLSavedState.class)).name());
        }
        jsonGenerator.g();
    }
}
