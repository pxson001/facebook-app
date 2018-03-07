package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.WriterCallback;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.OutputStream;

/* compiled from: seek_match */
class BufferedDiskCache$6 implements WriterCallback {
    final /* synthetic */ EncodedImage f2920a;
    final /* synthetic */ BufferedDiskCache f2921b;

    BufferedDiskCache$6(BufferedDiskCache bufferedDiskCache, EncodedImage encodedImage) {
        this.f2921b = bufferedDiskCache;
        this.f2920a = encodedImage;
    }

    public final void mo259a(OutputStream outputStream) {
        this.f2921b.d.a(this.f2920a.b(), outputStream);
    }
}
