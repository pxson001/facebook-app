package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: mobile_android_place_creation */
public class GraphQLTextWithEntitiesDeserializer {
    public static int m6056a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[6];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("aggregated_ranges")) {
                    int i2 = 0;
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(GraphQLAggregatedEntitiesAtRangeDeserializer.m4546a(jsonParser, flatBufferBuilder)));
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
                } else if (i.equals("image_ranges")) {
                    iArr[1] = GraphQLImageAtRangeDeserializer.m5224b(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_style_ranges")) {
                    iArr[2] = GraphQLInlineStyleAtRangeDeserializer.m5253b(jsonParser, flatBufferBuilder);
                } else if (i.equals("ranges")) {
                    iArr[3] = GraphQLEntityAtRangeDeserializer.m4748b(jsonParser, flatBufferBuilder);
                } else if (i.equals("text")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("__typename")) {
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
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        return flatBufferBuilder.d();
    }

    public static int m6059b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m6056a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m6057a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6056a(jsonParser, flatBufferBuilder);
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

    public static void m6058a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m6060b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m6060b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        int i2;
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("aggregated_ranges");
            jsonGenerator.d();
            for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLAggregatedEntitiesAtRangeDeserializer.m4548b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("image_ranges");
            jsonGenerator.d();
            for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLImageAtRangeDeserializer.m5225b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("inline_style_ranges");
            jsonGenerator.d();
            for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLInlineStyleAtRangeDeserializer.m5252a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("ranges");
            jsonGenerator.d();
            for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLEntityAtRangeDeserializer.m4749b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("__typename");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        jsonGenerator.g();
    }
}
