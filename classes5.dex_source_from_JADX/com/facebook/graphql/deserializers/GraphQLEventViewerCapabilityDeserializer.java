package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: parentIds */
public class GraphQLEventViewerCapabilityDeserializer {
    public static int m4842a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[16];
        boolean[] zArr2 = new boolean[14];
        int[] iArr = new int[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("can_viewer_decline")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_delete")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_edit")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_edit_host")) {
                    zArr[3] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_invite")) {
                    zArr[4] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("can_viewer_join")) {
                    zArr[5] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("can_viewer_maybe")) {
                    zArr[6] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("can_viewer_remove_self")) {
                    zArr[7] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("can_viewer_report")) {
                    zArr[8] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("can_viewer_save")) {
                    zArr[9] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("can_viewer_send_message_to_guests")) {
                    zArr[10] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("can_viewer_share")) {
                    zArr[11] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("is_viewer_admin")) {
                    zArr[12] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("remaining_invites")) {
                    zArr[13] = true;
                    iArr[0] = jsonParser.E();
                } else if (i.equals("seen_event")) {
                    zArr[14] = true;
                    enumArr[0] = GraphQLEventSeenState.fromString(jsonParser.o());
                } else if (i.equals("can_viewer_promote_as_parent")) {
                    zArr[15] = true;
                    zArr2[13] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(17);
        if (zArr[0]) {
            flatBufferBuilder.a(0, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(2, zArr2[2]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(3, zArr2[3]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(4, zArr2[4]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(5, zArr2[5]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(6, zArr2[6]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(7, zArr2[7]);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(8, zArr2[8]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(9, zArr2[9]);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(10, zArr2[10]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(11, zArr2[11]);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(12, zArr2[12]);
        }
        if (zArr[13]) {
            flatBufferBuilder.a(13, iArr[0], 0);
        }
        if (zArr[14]) {
            flatBufferBuilder.a(14, enumArr[0]);
        }
        if (zArr[15]) {
            flatBufferBuilder.a(16, zArr2[13]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4843a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4842a(jsonParser, flatBufferBuilder);
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

    public static void m4844a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("can_viewer_decline");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 1);
        if (a) {
            jsonGenerator.a("can_viewer_delete");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 2);
        if (a) {
            jsonGenerator.a("can_viewer_edit");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 3);
        if (a) {
            jsonGenerator.a("can_viewer_edit_host");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("can_viewer_invite");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 5);
        if (a) {
            jsonGenerator.a("can_viewer_join");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 6);
        if (a) {
            jsonGenerator.a("can_viewer_maybe");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 7);
        if (a) {
            jsonGenerator.a("can_viewer_remove_self");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 8);
        if (a) {
            jsonGenerator.a("can_viewer_report");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 9);
        if (a) {
            jsonGenerator.a("can_viewer_save");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 10);
        if (a) {
            jsonGenerator.a("can_viewer_send_message_to_guests");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 11);
        if (a) {
            jsonGenerator.a("can_viewer_share");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 12);
        if (a) {
            jsonGenerator.a("is_viewer_admin");
            jsonGenerator.a(a);
        }
        int a2 = mutableFlatBuffer.a(i, 13, 0);
        if (a2 != 0) {
            jsonGenerator.a("remaining_invites");
            jsonGenerator.b(a2);
        }
        if (mutableFlatBuffer.a(i, 14, (short) 0) != (short) 0) {
            jsonGenerator.a("seen_event");
            jsonGenerator.b(((GraphQLEventSeenState) mutableFlatBuffer.a(i, 14, GraphQLEventSeenState.class)).name());
        }
        a = mutableFlatBuffer.a(i, 16);
        if (a) {
            jsonGenerator.a("can_viewer_promote_as_parent");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
