package com.facebook.zero.protocol.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: xout_nux_type */
public class ZeroOptinGraphQLParsers {

    /* compiled from: xout_nux_type */
    public final class FetchZeroOptinQueryParser {
        public static MutableFlatBuffer m162a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("zero_optin")) {
                        iArr[0] = ZeroDefaultOptinFieldsParser.m163a(jsonParser, flatBufferBuilder);
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

    /* compiled from: xout_nux_type */
    public final class ZeroDefaultOptinFieldsParser {
        public static int m163a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[24];
            boolean[] zArr = new boolean[4];
            boolean[] zArr2 = new boolean[2];
            int[] iArr2 = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("campaign_id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("campaign_token_to_refresh_type")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("clickable_link_text")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("clickable_link_url")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("delay_interval")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("description_text")) {
                        iArr[5] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("facepile_profile_picture_urls")) {
                        iArr[6] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("facepile_text")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image_url")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("optin_type")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("primary_button_action")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("primary_button_intent")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("primary_button_step")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("primary_button_text")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("secondary_button_action")) {
                        iArr[14] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("secondary_button_intent")) {
                        iArr[15] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("secondary_button_override_back_only")) {
                        zArr[1] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("secondary_button_step")) {
                        iArr[17] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("secondary_button_text")) {
                        iArr[18] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("should_use_default_image")) {
                        zArr[2] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("subtitle")) {
                        iArr[20] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("terms_and_conditions_text")) {
                        iArr[21] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("title")) {
                        iArr[22] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("ttl")) {
                        zArr[3] = true;
                        iArr2[1] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(24);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[0]) {
                flatBufferBuilder.a(4, iArr2[0], 0);
            }
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            flatBufferBuilder.b(15, iArr[15]);
            if (zArr[1]) {
                flatBufferBuilder.a(16, zArr2[0]);
            }
            flatBufferBuilder.b(17, iArr[17]);
            flatBufferBuilder.b(18, iArr[18]);
            if (zArr[2]) {
                flatBufferBuilder.a(19, zArr2[1]);
            }
            flatBufferBuilder.b(20, iArr[20]);
            flatBufferBuilder.b(21, iArr[21]);
            flatBufferBuilder.b(22, iArr[22]);
            if (zArr[3]) {
                flatBufferBuilder.a(23, iArr2[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m164a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("campaign_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("campaign_token_to_refresh_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("clickable_link_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("clickable_link_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            int a = mutableFlatBuffer.a(i, 4, 0);
            if (a != 0) {
                jsonGenerator.a("delay_interval");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("description_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 5));
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("facepile_profile_picture_urls");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 6), jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("facepile_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("image_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("optin_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("primary_button_action");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("primary_button_intent");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("primary_button_step");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("primary_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("secondary_button_action");
                jsonGenerator.b(mutableFlatBuffer.c(i, 14));
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("secondary_button_intent");
                jsonGenerator.b(mutableFlatBuffer.c(i, 15));
            }
            boolean a2 = mutableFlatBuffer.a(i, 16);
            if (a2) {
                jsonGenerator.a("secondary_button_override_back_only");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("secondary_button_step");
                jsonGenerator.b(mutableFlatBuffer.c(i, 17));
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("secondary_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 18));
            }
            a2 = mutableFlatBuffer.a(i, 19);
            if (a2) {
                jsonGenerator.a("should_use_default_image");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 20) != 0) {
                jsonGenerator.a("subtitle");
                jsonGenerator.b(mutableFlatBuffer.c(i, 20));
            }
            if (mutableFlatBuffer.g(i, 21) != 0) {
                jsonGenerator.a("terms_and_conditions_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 21));
            }
            if (mutableFlatBuffer.g(i, 22) != 0) {
                jsonGenerator.a("title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 22));
            }
            a = mutableFlatBuffer.a(i, 23, 0);
            if (a != 0) {
                jsonGenerator.a("ttl");
                jsonGenerator.b(a);
            }
            jsonGenerator.g();
        }
    }
}
