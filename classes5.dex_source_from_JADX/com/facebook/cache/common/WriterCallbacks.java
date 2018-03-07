package com.facebook.cache.common;

import com.facebook.common.internal.ByteStreams;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: subattachments */
public class WriterCallbacks {

    /* compiled from: subattachments */
    public final class C01631 implements WriterCallback {
        final /* synthetic */ InputStream f2471a;

        public C01631(InputStream inputStream) {
            this.f2471a = inputStream;
        }

        public final void m3597a(OutputStream outputStream) {
            ByteStreams.a(this.f2471a, outputStream);
        }
    }
}
