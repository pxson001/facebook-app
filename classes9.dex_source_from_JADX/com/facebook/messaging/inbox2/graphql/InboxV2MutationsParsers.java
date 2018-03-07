package com.facebook.messaging.inbox2.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: mSelectedPaymentCard */
public class InboxV2MutationsParsers {

    /* compiled from: mSelectedPaymentCard */
    public final class MessengerInbox2UnitActionMutationParser {

        /* compiled from: mSelectedPaymentCard */
        public final class MessengerInboxUnitParser {
            public static int m11538a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("messenger_inbox_unit_hides_remaining")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, iArr2[0], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m11539a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("messenger_inbox_unit_hides_remaining");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m11540a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("messenger_inbox_unit")) {
                        iArr[0] = MessengerInboxUnitParser.m11538a(jsonParser, flatBufferBuilder);
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

    /* compiled from: mSelectedPaymentCard */
    public final class MessengerInboxItemActionMutationParser {

        /* compiled from: mSelectedPaymentCard */
        public final class MessengerInboxItemParser {
            public static int m11541a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                boolean[] zArr = new boolean[3];
                int[] iArr2 = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("messenger_inbox_item_clicks_remaining")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("messenger_inbox_item_hides_remaining")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("messenger_inbox_item_impressions_remaining")) {
                            zArr[2] = true;
                            iArr2[2] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, iArr2[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(2, iArr2[1], 0);
                }
                if (zArr[2]) {
                    flatBufferBuilder.a(3, iArr2[2], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m11542a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("messenger_inbox_item_clicks_remaining");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(i, 2, 0);
                if (a != 0) {
                    jsonGenerator.a("messenger_inbox_item_hides_remaining");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(i, 3, 0);
                if (a != 0) {
                    jsonGenerator.a("messenger_inbox_item_impressions_remaining");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m11543a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("messenger_inbox_item")) {
                        iArr[0] = MessengerInboxItemParser.m11541a(jsonParser, flatBufferBuilder);
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
