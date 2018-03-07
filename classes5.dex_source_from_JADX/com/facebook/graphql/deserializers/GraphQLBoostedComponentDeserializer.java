package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: phrases */
public class GraphQLBoostedComponentDeserializer {
    public static int m4611a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[14];
        boolean[] zArr = new boolean[4];
        long[] jArr = new long[2];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("ad_account")) {
                    iArr[0] = GraphQLAdAccountDeserializer.m4522a(jsonParser, flatBufferBuilder);
                } else if (i.equals("boosting_status")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLBoostedComponentStatus.fromString(jsonParser.o());
                } else if (i.equals("budget")) {
                    iArr[3] = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                } else if (i.equals("budget_type")) {
                    zArr[1] = true;
                    enumArr[1] = GraphQLBoostedComponentBudgetType.fromString(jsonParser.o());
                } else if (i.equals("feed_unit_preview")) {
                    iArr[5] = FeedUnitDeserializerResolver.m4503a(jsonParser, flatBufferBuilder);
                } else if (i.equals("ineligible_message")) {
                    iArr[6] = GraphQLBoostedComponentMessageDeserializer.m4614a(jsonParser, flatBufferBuilder);
                } else if (i.equals("rejection_reason")) {
                    iArr[7] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("spent")) {
                    iArr[8] = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                } else if (i.equals("start_time")) {
                    zArr[2] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("stop_time")) {
                    zArr[3] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("messages")) {
                    iArr[12] = GraphQLBoostedComponentMessageDeserializer.m4616b(jsonParser, flatBufferBuilder);
                } else if (i.equals("aymt_post_footer_channel")) {
                    iArr[13] = GraphQLAYMTChannelDeserializer.m4505a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(14);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, enumArr[0]);
        }
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, enumArr[1]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        if (zArr[2]) {
            flatBufferBuilder.a(9, jArr[0], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(10, jArr[1], 0);
        }
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4612a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4611a(jsonParser, flatBufferBuilder);
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

    public static void m4613a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("ad_account");
            GraphQLAdAccountDeserializer.m4524a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 2, (short) 0) != (short) 0) {
            jsonGenerator.a("boosting_status");
            jsonGenerator.b(((GraphQLBoostedComponentStatus) mutableFlatBuffer.a(i, 2, GraphQLBoostedComponentStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("budget");
            GraphQLCurrencyQuantityDeserializer.m4702a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 4, (short) 0) != (short) 0) {
            jsonGenerator.a("budget_type");
            jsonGenerator.b(((GraphQLBoostedComponentBudgetType) mutableFlatBuffer.a(i, 4, GraphQLBoostedComponentBudgetType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("feed_unit_preview");
            FeedUnitDeserializerResolver.m4504a(mutableFlatBuffer, g, 5, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("ineligible_message");
            GraphQLBoostedComponentMessageDeserializer.m4617b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("rejection_reason");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("spent");
            GraphQLCurrencyQuantityDeserializer.m4702a(mutableFlatBuffer, g, jsonGenerator);
        }
        long a = mutableFlatBuffer.a(i, 9, 0);
        if (a != 0) {
            jsonGenerator.a("start_time");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 10, 0);
        if (a != 0) {
            jsonGenerator.a("stop_time");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("messages");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLBoostedComponentMessageDeserializer.m4617b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("aymt_post_footer_channel");
            GraphQLAYMTChannelDeserializer.m4507a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
