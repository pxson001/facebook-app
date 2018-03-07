package com.facebook.tigon.tigonapi;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.nio.ByteBuffer;

@DoNotStrip
/* compiled from: no_campaign_id */
class TigonXplatBodyStream implements TigonBodyStream {
    @DoNotStrip
    private final HybridData mHybridData;

    private native void reportErrorNative(ByteBuffer byteBuffer, int i);

    private native int transferBytesNative(ByteBuffer byteBuffer, int i);

    private native void writeEOMNative();

    static {
        TigonApiModule.m6340a();
    }

    public TigonXplatBodyStream(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public final int mo129a(ByteBuffer byteBuffer, int i) {
        return transferBytesNative(byteBuffer, i);
    }

    public final void mo130a() {
        writeEOMNative();
    }

    public final void mo131a(TigonError tigonError) {
        ByteBuffer a = FlatBufferSerializer.m6335a(tigonError);
        reportErrorNative(a, a.position());
    }
}
