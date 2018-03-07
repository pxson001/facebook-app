package com.facebook.productionprompts.graphql;

import com.facebook.auth.protocol.LoggedInUserQueryFragmentParsers$LoggedInUserQueryFragmentParser.AllPhonesParser.PhoneNumberParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers$DefaultNameFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers$DefaultImageFieldsParser;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: rules */
public final class C0141xeb903f2e {

    /* compiled from: rules */
    public final class ClientProductionPromptsParser {
        public static int m3289a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("nodes")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(C0142xd632f9b.m3292b(jsonParser, flatBufferBuilder)));
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
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m3290a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("nodes");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    C0142xd632f9b.m3291a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: rules */
    public final class ProductionPromptsParser {
        public static int m3293a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("nodes")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(ProductionPromptsInfoParser.b(jsonParser, flatBufferBuilder)));
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
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m3294a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("nodes");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    ProductionPromptsInfoParser.b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    public static void m3288b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("is_verified");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("phone_number");
            PhoneNumberParser.a(mutableFlatBuffer, g, jsonGenerator);
        }
        jsonGenerator.g();
    }

    public static MutableFlatBuffer m3285a(JsonParser jsonParser) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int[] iArr = new int[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("client_production_prompts")) {
                    iArr[0] = ClientProductionPromptsParser.m3289a(jsonParser, flatBufferBuilder);
                } else if (i.equals("production_prompts")) {
                    iArr[1] = ProductionPromptsParser.m3293a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        return mutableFlatBuffer;
    }

    public static void m3286a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("current_location_prediction");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("home_location_prediction");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        jsonGenerator.g();
    }

    public static void m3287a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("all_phones");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                C0141xeb903f2e.m3288b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("email_addresses");
            SerializerHelpers.m4182a(mutableFlatBuffer.f(i, 1), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("gender");
            jsonGenerator.b(mutableFlatBuffer.b(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        boolean a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("is_deactivated_allowed_on_messenger");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 5);
        if (a) {
            jsonGenerator.a("is_minor");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 6);
        if (a) {
            jsonGenerator.a("is_mobile_pushable");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 7);
        if (a) {
            jsonGenerator.a("is_partial");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 8);
        if (a) {
            jsonGenerator.a("is_work_user");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("messaging_geo");
            C0141xeb903f2e.m3286a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        a = mutableFlatBuffer.a(i, 11);
        if (a) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicBig");
            CommonGraphQLParsers$DefaultImageFieldsParser.m2040a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicHuge");
            CommonGraphQLParsers$DefaultImageFieldsParser.m2040a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 14);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicSmall");
            CommonGraphQLParsers$DefaultImageFieldsParser.m2040a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("structured_name");
            CommonGraphQL2Parsers$DefaultNameFieldsParser.m2044a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 16) != 0) {
            jsonGenerator.a("username");
            jsonGenerator.b(mutableFlatBuffer.c(i, 16));
        }
        jsonGenerator.g();
    }
}
