package com.facebook.gl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: WWW_FEED_RHC */
public class IndexArray {
    public final ByteBuffer f12341a;
    public final int f12342b;

    public IndexArray(byte[] bArr) {
        this.f12341a = (ByteBuffer) ByteBuffer.allocateDirect(bArr.length).order(ByteOrder.nativeOrder()).put(bArr).position(0);
        this.f12342b = bArr.length;
    }
}
