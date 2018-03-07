package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: page_report_dialog */
public class GraphQLFriendingPossibilitiesConnectionDeserializer {
    public static int m4939a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[3];
        boolean[] zArr = new boolean[1];
        int[] iArr2 = new int[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("edges")) {
                    int i2 = 0;
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(GraphQLFriendingPossibilitiesEdgeDeserializer.m4942a(jsonParser, flatBufferBuilder)));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        int[] iArr3 = new int[arrayList.size()];
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                        }
                        i2 = flatBufferBuilder.a(iArr3, true);
                    }
                    iArr[0] = i2;
                } else if (i.equals("page_info")) {
                    iArr[1] = GraphQLPageInfoDeserializer.m5506a(jsonParser, flatBufferBuilder);
                } else if (i.equals("total_possibility_count")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, iArr2[0], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4940a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4939a(jsonParser, flatBufferBuilder);
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

    public static void m4941a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("edges");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLFriendingPossibilitiesEdgeDeserializer.m4944b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("page_info");
            GraphQLPageInfoDeserializer.m5508a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 2, 0);
        if (g != 0) {
            jsonGenerator.a("total_possibility_count");
            jsonGenerator.b(g);
        }
        jsonGenerator.g();
    }
}
