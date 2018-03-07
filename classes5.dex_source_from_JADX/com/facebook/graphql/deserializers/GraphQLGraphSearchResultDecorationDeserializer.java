package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: page_admin_overview_identity_card */
public class GraphQLGraphSearchResultDecorationDeserializer {
    public static int m5106a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[9];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("comments")) {
                    iArr[0] = GraphQLCommentDeserializer.m4660b(jsonParser, flatBufferBuilder);
                } else if (i.equals("connected_friends")) {
                    iArr[1] = GraphQLGraphSearchConnectedFriendsConnectionDeserializer.m5074a(jsonParser, flatBufferBuilder);
                } else if (i.equals("info_snippets")) {
                    iArr[2] = GraphQLGraphSearchSnippetDeserializer.m5119b(jsonParser, flatBufferBuilder);
                } else if (i.equals("lineage_snippets")) {
                    iArr[3] = GraphQLGraphSearchSnippetDeserializer.m5119b(jsonParser, flatBufferBuilder);
                } else if (i.equals("match_words")) {
                    iArr[4] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("ordered_snippets")) {
                    iArr[5] = GraphQLGraphSearchSnippetDeserializer.m5119b(jsonParser, flatBufferBuilder);
                } else if (i.equals("snippet_source")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("social_snippet")) {
                    iArr[7] = GraphQLGraphSearchSnippetDeserializer.m5116a(jsonParser, flatBufferBuilder);
                } else if (i.equals("summary_snippet")) {
                    iArr[8] = GraphQLGraphSearchSnippetDeserializer.m5116a(jsonParser, flatBufferBuilder);
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
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5107a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5106a(jsonParser, flatBufferBuilder);
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

    public static void m5108a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("comments");
            GraphQLCommentDeserializer.m4659a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("connected_friends");
            GraphQLGraphSearchConnectedFriendsConnectionDeserializer.m5076a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("info_snippets");
            GraphQLGraphSearchSnippetDeserializer.m5118a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("lineage_snippets");
            GraphQLGraphSearchSnippetDeserializer.m5118a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("match_words");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 4), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("ordered_snippets");
            GraphQLGraphSearchSnippetDeserializer.m5118a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("snippet_source");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("social_snippet");
            GraphQLGraphSearchSnippetDeserializer.m5120b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("summary_snippet");
            GraphQLGraphSearchSnippetDeserializer.m5120b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
