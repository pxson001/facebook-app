package com.facebook.tigon.tigonapi;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.tigon.iface.TigonServiceHolder;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: no_cache_found */
public class TigonXplatService extends TigonServiceHolder implements ITigonXplatService {
    private native TigonXplatRequestToken sendRequestBodyBufferByteBuffer(TigonRequest tigonRequest, ByteBuffer byteBuffer, int i, TigonBodyProvider tigonBodyProvider, TigonDirectBufferCallbacks tigonDirectBufferCallbacks, @Nullable Executor executor);

    private native TigonXplatRequestToken sendRequestByteBuffer(TigonRequest tigonRequest, ByteBuffer byteBuffer, int i, @Nullable ByteBuffer[] byteBufferArr, int i2, TigonDirectBufferCallbacks tigonDirectBufferCallbacks, @Nullable Executor executor);

    private native TigonXplatRequestToken sendRequestJavaBuffer(TigonRequest tigonRequest, ByteBuffer byteBuffer, int i, @Nullable byte[] bArr, TigonCallbacks tigonCallbacks, @Nullable Executor executor);

    public native boolean hasSecretaryService();

    public native void releaseBodyBuffer(ByteBuffer byteBuffer);

    static {
        TigonApiModule.m6340a();
    }

    protected TigonXplatService(HybridData hybridData) {
        super(hybridData);
    }

    protected void mo144b() {
    }

    public final TigonRequestToken mo135a(TigonRequest tigonRequest, @Nullable ByteBuffer[] byteBufferArr, int i, TigonDirectBufferCallbacks tigonDirectBufferCallbacks, @Nullable Executor executor) {
        mo144b();
        ByteBuffer a = FlatBufferSerializer.m6334a(tigonRequest);
        return sendRequestByteBuffer(tigonRequest, a, a.position(), byteBufferArr, i, tigonDirectBufferCallbacks, executor);
    }

    public final TigonRequestToken mo134a(TigonRequest tigonRequest, TigonBodyProvider tigonBodyProvider, TigonDirectBufferCallbacks tigonDirectBufferCallbacks, Executor executor) {
        mo144b();
        ByteBuffer a = FlatBufferSerializer.m6334a(tigonRequest);
        return sendRequestBodyBufferByteBuffer(tigonRequest, a, a.position(), tigonBodyProvider, tigonDirectBufferCallbacks, executor);
    }

    public final boolean mo136a() {
        return this.mHybridData.a();
    }
}
