package com.facebook.groups.photos.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: TOP_ROW */
public class FetchGroupPhotosHeaderParsers {

    /* compiled from: TOP_ROW */
    public final class FetchGroupPhotosHeaderParser {
        public static MutableFlatBuffer m24386a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("viewer_post_status")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLGroupPostStatus.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
