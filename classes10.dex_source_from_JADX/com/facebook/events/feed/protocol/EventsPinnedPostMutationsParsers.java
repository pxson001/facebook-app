package com.facebook.events.feed.protocol;

import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLParsers.EventPinnedPostAndRecentStoryFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: com.facebook.acra.ErrorReporter.uncaughtException */
public class EventsPinnedPostMutationsParsers {

    /* compiled from: com.facebook.acra.ErrorReporter.uncaughtException */
    public final class EventChangeStoryPinStatusMutationParser {
        public static MutableFlatBuffer m17767a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("event")) {
                        iArr[0] = EventPinnedPostAndRecentStoryFragmentParser.m17755a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("new_story_sort_key")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
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
    }
}
