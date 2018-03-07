package com.facebook.api.feedcache.omnistore;

import com.google.flatbuffers.FlatBufferBuilder;
import java.nio.ByteBuffer;

/* compiled from: approved */
public class FeedUnitTranscription {
    public static byte[] m14707a(String str, int i, int i2, int i3) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(256);
        int a = flatBufferBuilder.a(str);
        flatBufferBuilder.b(4);
        flatBufferBuilder.b(3, i3, 0);
        flatBufferBuilder.b(2, i2, 0);
        flatBufferBuilder.b(1, i, 0);
        flatBufferBuilder.c(0, a, 0);
        flatBufferBuilder.c(flatBufferBuilder.c());
        ByteBuffer byteBuffer = flatBufferBuilder.a;
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }
}
