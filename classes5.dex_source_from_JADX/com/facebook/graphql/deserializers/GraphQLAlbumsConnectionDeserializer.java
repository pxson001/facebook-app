package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: place_holder */
public class GraphQLAlbumsConnectionDeserializer {
    public static int m4552a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("nodes")) {
                    int i2 = 0;
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(GraphQLAlbumDeserializer.m4549a(jsonParser, flatBufferBuilder)));
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
                } else if (i.equals("page_info")) {
                    iArr[1] = GraphQLPageInfoDeserializer.m5506a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4553a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4552a(jsonParser, flatBufferBuilder);
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

    public static void m4554a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("nodes");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLAlbumDeserializer.m4551b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("page_info");
            GraphQLPageInfoDeserializer.m5508a(mutableFlatBuffer, g, jsonGenerator);
        }
        jsonGenerator.g();
    }
}
