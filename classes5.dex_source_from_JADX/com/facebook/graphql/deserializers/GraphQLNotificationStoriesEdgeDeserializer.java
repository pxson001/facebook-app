package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: offer_code */
public class GraphQLNotificationStoriesEdgeDeserializer {
    public static int m5454a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[12];
        boolean[] zArr = new boolean[6];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = new int[3];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("cursor")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("highlight_state")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLNotifHighlightState.fromString(jsonParser.o());
                } else if (i.equals("importance_reason_text")) {
                    iArr[2] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("importance_score")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("importance_type")) {
                    zArr[2] = true;
                    enumArr[1] = GraphQLNotifImportanceType.fromString(jsonParser.o());
                } else if (i.equals("local_seen_state_session_number")) {
                    zArr[3] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("node")) {
                    iArr[7] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("notif_option_rows")) {
                    iArr[8] = GraphQLNotifOptionRowDeserializer.m5446b(jsonParser, flatBufferBuilder);
                } else if (i.equals("reaction_unit")) {
                    iArr[9] = GraphQLReactionUnitDeserializer.m5784a(jsonParser, flatBufferBuilder);
                } else if (i.equals("local_num_impressions")) {
                    zArr[4] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("local_is_rich_notif_collapsed")) {
                    zArr[5] = true;
                    zArr2[0] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(12);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, enumArr[0]);
        }
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[1]) {
            flatBufferBuilder.a(3, iArr2[0], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(4, enumArr[1]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(5, iArr2[1], 0);
        }
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        if (zArr[4]) {
            flatBufferBuilder.a(10, iArr2[2], 0);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(11, zArr2[0]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5455a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5454a(jsonParser, flatBufferBuilder);
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

    public static void m5456a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("cursor");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.a(i, 1, (short) 0) != (short) 0) {
            jsonGenerator.a("highlight_state");
            jsonGenerator.b(((GraphQLNotifHighlightState) mutableFlatBuffer.a(i, 1, GraphQLNotifHighlightState.class)).name());
        }
        int g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("importance_reason_text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 3, 0);
        if (g != 0) {
            jsonGenerator.a("importance_score");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 4, (short) 0) != (short) 0) {
            jsonGenerator.a("importance_type");
            jsonGenerator.b(((GraphQLNotifImportanceType) mutableFlatBuffer.a(i, 4, GraphQLNotifImportanceType.class)).name());
        }
        g = mutableFlatBuffer.a(i, 5, 0);
        if (g != 0) {
            jsonGenerator.a("local_seen_state_session_number");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("node");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("notif_option_rows");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLNotifOptionRowDeserializer.m5447b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("reaction_unit");
            GraphQLReactionUnitDeserializer.m5786a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 10, 0);
        if (g != 0) {
            jsonGenerator.a("local_num_impressions");
            jsonGenerator.b(g);
        }
        boolean a = mutableFlatBuffer.a(i, 11);
        if (a) {
            jsonGenerator.a("local_is_rich_notif_collapsed");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
