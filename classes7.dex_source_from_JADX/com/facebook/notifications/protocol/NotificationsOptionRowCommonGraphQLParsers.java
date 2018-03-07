package com.facebook.notifications.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: music_sprout_clicked_with_song */
public class NotificationsOptionRowCommonGraphQLParsers {

    /* compiled from: music_sprout_clicked_with_song */
    public final class StyleOnlyNotifOptionSetDisplayFragmentParser {
        public static int m10654a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("style")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLNotifOptionRowSetDisplayStyle.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m10655a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            jsonGenerator.g();
        }
    }
}
