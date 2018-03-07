package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: og_suggestion_mechanism */
public class GraphQLMobilePageAdminPanelFeedUnitItemDeserializer {
    public static int m5373a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[6];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("aymt_channel_image")) {
                    iArr[0] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("aymt_channel_url")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("aymt_hpp_channel")) {
                    iArr[2] = GraphQLAYMTChannelDeserializer.m4505a(jsonParser, flatBufferBuilder);
                } else if (i.equals("context_rows")) {
                    int i2 = 0;
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(GraphQLEntityCardContextItemDeserializer.m4750a(jsonParser, flatBufferBuilder)));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        int[] iArr2 = new int[arrayList.size()];
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                        }
                        i2 = flatBufferBuilder.a(iArr2, true);
                    }
                    iArr[3] = i2;
                } else if (i.equals("profile")) {
                    iArr[4] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
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

    public static int m5375b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5373a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m5374a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5373a(jsonParser, flatBufferBuilder);
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

    public static void m5376b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("aymt_channel_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("aymt_channel_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("aymt_hpp_channel");
            GraphQLAYMTChannelDeserializer.m4507a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("context_rows");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLEntityCardContextItemDeserializer.m4752b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("profile");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        jsonGenerator.g();
    }
}
