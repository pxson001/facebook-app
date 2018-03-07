package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentFormatVersion;
import com.facebook.graphql.enums.GraphQLDocumentTextDirectionEnum;
import com.facebook.graphql.enums.GraphQLInstantArticlePublishStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: option_value */
public class GraphQLInstantArticleVersionDeserializer {
    public static int m5265a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[16];
        boolean[] zArr = new boolean[8];
        int[] iArr2 = new int[1];
        long[] jArr = new long[3];
        Enum[] enumArr = new Enum[4];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("article_canonical_url")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("article_version_number")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("creation_time")) {
                    zArr[1] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("document_owner")) {
                    iArr[3] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feed_attachment")) {
                    iArr[4] = GraphQLStoryAttachmentDeserializer.m5953a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[6] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback_options")) {
                    zArr[2] = true;
                    enumArr[0] = GraphQLDocumentFeedbackOptions.fromString(jsonParser.o());
                } else if (i.equals("format_version")) {
                    zArr[3] = true;
                    enumArr[1] = GraphQLDocumentFormatVersion.fromString(jsonParser.o());
                } else if (i.equals("id")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("modified_timestamp")) {
                    zArr[4] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("publish_status")) {
                    zArr[5] = true;
                    enumArr[2] = GraphQLInstantArticlePublishStatus.fromString(jsonParser.o());
                } else if (i.equals("publish_timestamp")) {
                    zArr[6] = true;
                    jArr[2] = jsonParser.F();
                } else if (i.equals("text_direction")) {
                    zArr[7] = true;
                    enumArr[3] = GraphQLDocumentTextDirectionEnum.fromString(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("cover_media")) {
                    iArr[15] = GraphQLDocumentElementDeserializer.m4715a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(16);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, iArr2[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(2, jArr[0], 0);
        }
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(6, iArr[6]);
        if (zArr[2]) {
            flatBufferBuilder.a(7, enumArr[0]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(8, enumArr[1]);
        }
        flatBufferBuilder.b(9, iArr[9]);
        if (zArr[4]) {
            flatBufferBuilder.a(10, jArr[1], 0);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(11, enumArr[2]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(12, jArr[2], 0);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(13, enumArr[3]);
        }
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5266a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5265a(jsonParser, flatBufferBuilder);
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

    public static void m5267a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("article_canonical_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        int a = mutableFlatBuffer.a(i, 1, 0);
        if (a != 0) {
            jsonGenerator.a("article_version_number");
            jsonGenerator.b(a);
        }
        long a2 = mutableFlatBuffer.a(i, 2, 0);
        if (a2 != 0) {
            jsonGenerator.a("creation_time");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.g(i, 3);
        if (a != 0) {
            jsonGenerator.a("document_owner");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 4);
        if (a != 0) {
            jsonGenerator.a("feed_attachment");
            GraphQLStoryAttachmentDeserializer.m5957b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 6);
        if (a != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 7, (short) 0) != (short) 0) {
            jsonGenerator.a("feedback_options");
            jsonGenerator.b(((GraphQLDocumentFeedbackOptions) mutableFlatBuffer.a(i, 7, GraphQLDocumentFeedbackOptions.class)).name());
        }
        if (mutableFlatBuffer.a(i, 8, (short) 0) != (short) 0) {
            jsonGenerator.a("format_version");
            jsonGenerator.b(((GraphQLDocumentFormatVersion) mutableFlatBuffer.a(i, 8, GraphQLDocumentFormatVersion.class)).name());
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        a2 = mutableFlatBuffer.a(i, 10, 0);
        if (a2 != 0) {
            jsonGenerator.a("modified_timestamp");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.a(i, 11, (short) 0) != (short) 0) {
            jsonGenerator.a("publish_status");
            jsonGenerator.b(((GraphQLInstantArticlePublishStatus) mutableFlatBuffer.a(i, 11, GraphQLInstantArticlePublishStatus.class)).name());
        }
        a2 = mutableFlatBuffer.a(i, 12, 0);
        if (a2 != 0) {
            jsonGenerator.a("publish_timestamp");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.a(i, 13, (short) 0) != (short) 0) {
            jsonGenerator.a("text_direction");
            jsonGenerator.b(((GraphQLDocumentTextDirectionEnum) mutableFlatBuffer.a(i, 13, GraphQLDocumentTextDirectionEnum.class)).name());
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        a = mutableFlatBuffer.g(i, 15);
        if (a != 0) {
            jsonGenerator.a("cover_media");
            GraphQLDocumentElementDeserializer.m4717a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
