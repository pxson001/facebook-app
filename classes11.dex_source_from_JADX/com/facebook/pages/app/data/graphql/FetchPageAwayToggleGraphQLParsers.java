package com.facebook.pages.app.data.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: targetData */
public class FetchPageAwayToggleGraphQLParsers {

    /* compiled from: targetData */
    public final class FetchPageAwayToggleQueryParser {
        public static MutableFlatBuffer m1436a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[1];
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("away_toggle_expiration")) {
                        zArr[0] = true;
                        iArr[0] = jsonParser.E();
                    } else if (i.equals("is_away_toggle_on")) {
                        zArr[1] = true;
                        zArr2[0] = jsonParser.H();
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
                flatBufferBuilder.a(1, zArr2[0]);
            }
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
