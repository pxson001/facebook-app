package com.facebook.notifications.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: negative_action_type */
public class FetchMessengerJewelCountsGraphQLParsers {

    /* compiled from: negative_action_type */
    public final class FetchMessengerJewelCountsParser {

        /* compiled from: negative_action_type */
        public final class MessageThreadsParser {
            public static int m10028a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[2];
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("recent_unread_count")) {
                            zArr[0] = true;
                            iArr[0] = jsonParser.E();
                        } else if (i.equals("unseen_count")) {
                            zArr[1] = true;
                            iArr[1] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, iArr[1], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m10029a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("recent_unread_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("unseen_count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m10030a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("message_threads")) {
                        iArr[0] = MessageThreadsParser.m10028a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
