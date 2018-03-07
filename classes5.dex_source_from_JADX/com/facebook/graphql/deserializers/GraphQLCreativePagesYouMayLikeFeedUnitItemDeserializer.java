package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: photo cap result fetch failed */
public class GraphQLCreativePagesYouMayLikeFeedUnitItemDeserializer {
    public static int m4692a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[10];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("creative_image")) {
                    iArr[0] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creative_text")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("creative_title")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("hideable_token")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("like_sentence")) {
                    iArr[4] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("negative_feedback_actions")) {
                    iArr[5] = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5415a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile")) {
                    iArr[6] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("social_context")) {
                    iArr[7] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sponsored_data")) {
                    iArr[8] = GraphQLSponsoredDataDeserializer.m5921a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
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
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        return flatBufferBuilder.d();
    }

    public static int m4695b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m4692a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m4693a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4692a(jsonParser, flatBufferBuilder);
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

    public static void m4694a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m4696b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m4696b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("creative_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("creative_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("creative_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("hideable_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("like_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("profile");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredDataDeserializer.m5923a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        jsonGenerator.g();
    }
}
