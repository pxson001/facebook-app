package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputDomain;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: optin_decline_button_cancel_text */
public class GraphQLLeadGenInfoFieldDataDeserializer {
    public static int m5294a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[10];
        boolean[] zArr = new boolean[5];
        boolean[] zArr2 = new boolean[3];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("customized_tokens")) {
                    iArr[0] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("field_key")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("input_domain")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLLeadGenInfoFieldInputDomain.fromString(jsonParser.o());
                } else if (i.equals("input_type")) {
                    zArr[1] = true;
                    enumArr[1] = GraphQLLeadGenInfoFieldInputType.fromString(jsonParser.o());
                } else if (i.equals("is_custom_type")) {
                    zArr[2] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("is_editable")) {
                    zArr[3] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("is_required")) {
                    zArr[4] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("name")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("place_holder")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("values")) {
                    iArr[9] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(10);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, enumArr[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(3, enumArr[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(4, zArr2[0]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(5, zArr2[1]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(6, zArr2[2]);
        }
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        return flatBufferBuilder.d();
    }

    public static int m5298b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5294a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m5295a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5294a(jsonParser, flatBufferBuilder);
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

    public static void m5297a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m5296a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
        }
        jsonGenerator.e();
    }

    public static void m5296a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("customized_tokens");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 0), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("field_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.a(i, 2, (short) 0) != (short) 0) {
            jsonGenerator.a("input_domain");
            jsonGenerator.b(((GraphQLLeadGenInfoFieldInputDomain) mutableFlatBuffer.a(i, 2, GraphQLLeadGenInfoFieldInputDomain.class)).name());
        }
        if (mutableFlatBuffer.a(i, 3, (short) 0) != (short) 0) {
            jsonGenerator.a("input_type");
            jsonGenerator.b(((GraphQLLeadGenInfoFieldInputType) mutableFlatBuffer.a(i, 3, GraphQLLeadGenInfoFieldInputType.class)).name());
        }
        boolean a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("is_custom_type");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 5);
        if (a) {
            jsonGenerator.a("is_editable");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 6);
        if (a) {
            jsonGenerator.a("is_required");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("place_holder");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("values");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 9), jsonGenerator);
        }
        jsonGenerator.g();
    }
}
