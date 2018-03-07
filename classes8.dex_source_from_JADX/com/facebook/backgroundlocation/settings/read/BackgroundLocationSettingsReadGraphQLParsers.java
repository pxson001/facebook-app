package com.facebook.backgroundlocation.settings.read;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: is_currently_there */
public class BackgroundLocationSettingsReadGraphQLParsers {

    /* compiled from: is_currently_there */
    public final class LocationHistoryEnabledQueryParser {
        public static MutableFlatBuffer m12571a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("location_sharing")) {
                        iArr[0] = LocationSharingFeatureStatusParser.m12572a(jsonParser, flatBufferBuilder);
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

    /* compiled from: is_currently_there */
    public final class LocationSharingFeatureStatusParser {
        public static int m12572a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            boolean[] zArr = new boolean[3];
            boolean[] zArr2 = new boolean[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("is_sharing_enabled")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("is_tracking_enabled")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("show_nux")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(2, zArr2[2]);
            }
            return flatBufferBuilder.d();
        }

        public static void m12573a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("is_sharing_enabled");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("is_tracking_enabled");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("show_nux");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }
}
