package com.facebook.ui.media.cache;

import com.facebook.cache.common.WriterCallback;
import java.io.OutputStream;

/* compiled from: search_error/ */
class MediaCache$1 implements WriterCallback {
    final /* synthetic */ byte[] f5231a;
    final /* synthetic */ MediaCache f5232b;

    MediaCache$1(MediaCache mediaCache, byte[] bArr) {
        this.f5232b = mediaCache;
        this.f5231a = bArr;
    }

    public final void m7931a(OutputStream outputStream) {
        outputStream.write(this.f5231a);
    }
}
