package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBrowserPrefetchType;
import com.facebook.graphql.enums.GraphQLFeedbackReadLikelihood;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: page_unlike */
public class GraphQLFeedbackContextDeserializer {
    public static int m4889a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[11];
        boolean[] zArr = new boolean[4];
        int[] iArr2 = new int[2];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("feedback_target")) {
                    iArr[0] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("full_relevant_comments")) {
                    iArr[1] = GraphQLCommentDeserializer.m4660b(jsonParser, flatBufferBuilder);
                } else if (i.equals("inapp_browser_prefetch_type")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLBrowserPrefetchType.fromString(jsonParser.o());
                } else if (i.equals("inapp_browser_prefetch_vpv_duration_threshold")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("interesting_comments")) {
                    iArr[5] = GraphQLCommentDeserializer.m4660b(jsonParser, flatBufferBuilder);
                } else if (i.equals("read_likelihood")) {
                    zArr[2] = true;
                    enumArr[1] = GraphQLFeedbackReadLikelihood.fromString(jsonParser.o());
                } else if (i.equals("relevant_comments")) {
                    iArr[7] = GraphQLCommentDeserializer.m4660b(jsonParser, flatBufferBuilder);
                } else if (i.equals("inapp_browser_prefetch_vpv_duration_threshold_wifi")) {
                    zArr[3] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("relevant_reactors")) {
                    iArr[9] = GraphQLRelevantReactorsConnectionDeserializer.m5804a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback_to_prefetch")) {
                    iArr[10] = GraphQLFeedbackDeserializer.m4894b(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(11);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, enumArr[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(3, iArr2[0], 0);
        }
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[2]) {
            flatBufferBuilder.a(6, enumArr[1]);
        }
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[3]) {
            flatBufferBuilder.a(8, iArr2[1], 0);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4890a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4889a(jsonParser, flatBufferBuilder);
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

    public static void m4891a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("feedback_target");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("full_relevant_comments");
            GraphQLCommentDeserializer.m4659a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 2, (short) 0) != (short) 0) {
            jsonGenerator.a("inapp_browser_prefetch_type");
            jsonGenerator.b(((GraphQLBrowserPrefetchType) mutableFlatBuffer.a(i, 2, GraphQLBrowserPrefetchType.class)).name());
        }
        g = mutableFlatBuffer.a(i, 3, 0);
        if (g != 0) {
            jsonGenerator.a("inapp_browser_prefetch_vpv_duration_threshold");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("interesting_comments");
            GraphQLCommentDeserializer.m4659a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 6, (short) 0) != (short) 0) {
            jsonGenerator.a("read_likelihood");
            jsonGenerator.b(((GraphQLFeedbackReadLikelihood) mutableFlatBuffer.a(i, 6, GraphQLFeedbackReadLikelihood.class)).name());
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("relevant_comments");
            GraphQLCommentDeserializer.m4659a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 8, 0);
        if (g != 0) {
            jsonGenerator.a("inapp_browser_prefetch_vpv_duration_threshold_wifi");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("relevant_reactors");
            GraphQLRelevantReactorsConnectionDeserializer.m5806a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("feedback_to_prefetch");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        jsonGenerator.g();
    }
}
