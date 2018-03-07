package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: page_admin_tips */
public class GraphQLGraphSearchQueryDeserializer {
    public static int m5083a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[19];
        boolean[] zArr = new boolean[1];
        int[] iArr2 = new int[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("filtered_query")) {
                    iArr[0] = m5083a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("modules")) {
                    iArr[2] = GraphQLGraphSearchModulesConnectionDeserializer.m5080a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name_search_tokens")) {
                    iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("needle_filters")) {
                    iArr[5] = GraphQLGraphSearchQueryFilterGroupDeserializer.m5095b(jsonParser, flatBufferBuilder);
                } else if (i.equals("post_search_intent_log")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("query_function")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("query_title")) {
                    iArr[8] = GraphQLGraphSearchQueryTitleDeserializer.m5103a(jsonParser, flatBufferBuilder);
                } else if (i.equals("results")) {
                    iArr[9] = GraphQLGraphSearchResultsConnectionDeserializer.m5109a(jsonParser, flatBufferBuilder);
                } else if (i.equals("search_result_style_list")) {
                    iArr[10] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLGraphSearchResultsDisplayStyle.class);
                } else if (i.equals("session_id")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("top_filters")) {
                    iArr[12] = GraphQLGraphSearchQueryFilterGroupDeserializer.m5095b(jsonParser, flatBufferBuilder);
                } else if (i.equals("underlying_entity")) {
                    iArr[13] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("vertical_to_log")) {
                    iArr[15] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("query_role")) {
                    iArr[16] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("estimated_results")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(19);
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
            flatBufferBuilder.a(18, iArr2[0], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5084a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5083a(jsonParser, flatBufferBuilder);
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

    public static void m5085a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("filtered_query");
            m5085a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("modules");
            GraphQLGraphSearchModulesConnectionDeserializer.m5082a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("name_search_tokens");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 4), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("needle_filters");
            GraphQLGraphSearchQueryFilterGroupDeserializer.m5094a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("post_search_intent_log");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("query_function");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("query_title");
            GraphQLGraphSearchQueryTitleDeserializer.m5105a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("results");
            GraphQLGraphSearchResultsConnectionDeserializer.m5111a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("search_result_style_list");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 10), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("session_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("top_filters");
            GraphQLGraphSearchQueryFilterGroupDeserializer.m5094a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("underlying_entity");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("vertical_to_log");
            jsonGenerator.b(mutableFlatBuffer.c(i, 15));
        }
        if (mutableFlatBuffer.g(i, 16) != 0) {
            jsonGenerator.a("query_role");
            jsonGenerator.b(mutableFlatBuffer.c(i, 16));
        }
        g = mutableFlatBuffer.a(i, 18, 0);
        if (g != 0) {
            jsonGenerator.a("estimated_results");
            jsonGenerator.b(g);
        }
        jsonGenerator.g();
    }
}
