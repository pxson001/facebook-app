package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: objective */
public class GraphQLPYMLWithLargeImageFeedUnitItemDeserializer {
    public static int m5482a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[13];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("creativeImageHigh")) {
                    iArr[0] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creativeImageLow")) {
                    iArr[1] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creativeImageMedium")) {
                    iArr[2] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creative_image")) {
                    iArr[3] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creative_image_mobile_feed_focus")) {
                    iArr[4] = GraphQLVect2Deserializer.m6165a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creative_text")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("hideable_token")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("like_sentence")) {
                    iArr[7] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("negative_feedback_actions")) {
                    iArr[8] = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5415a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile")) {
                    iArr[9] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("social_context")) {
                    iArr[10] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sponsored_data")) {
                    iArr[11] = GraphQLSponsoredDataDeserializer.m5921a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
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
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        return flatBufferBuilder.d();
    }

    public static int m5484b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5482a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m5483a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5482a(jsonParser, flatBufferBuilder);
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

    public static void m5485b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("creativeImageHigh");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("creativeImageLow");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("creativeImageMedium");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("creative_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("creative_image_mobile_feed_focus");
            GraphQLVect2Deserializer.m6167a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("creative_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("hideable_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("like_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("profile");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredDataDeserializer.m5923a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        jsonGenerator.g();
    }
}
