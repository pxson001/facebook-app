package com.facebook.ipc.composer.intent.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLParsers.PrivacyIconFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: lifeEventType */
public class FetchComposerTargetDataPrivacyScopeParsers {

    /* compiled from: lifeEventType */
    public final class ComposerTargetDataPrivacyScopeFieldsParser {
        public static int m18318a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("icon_image")) {
                        iArr[0] = PrivacyIconFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("label")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
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

        public static void m18319a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("icon_image");
                PrivacyIconFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("label");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            jsonGenerator.g();
        }
    }
}
