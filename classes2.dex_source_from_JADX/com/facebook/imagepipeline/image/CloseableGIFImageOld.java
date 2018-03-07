package com.facebook.imagepipeline.image;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import gifdrawable.pl.droidsonroids.gif.DecodedGifData;
import gifdrawable.pl.droidsonroids.gif.GifDrawable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: last_ping_timeout */
public class CloseableGIFImageOld extends CloseableImage {
    private final EncodedImage f17917a;
    public DecodedGifData f17918b;

    public CloseableGIFImageOld(EncodedImage encodedImage) {
        this.f17917a = EncodedImage.m15702a(encodedImage);
        Preconditions.a(this.f17917a);
        SoLoaderShim.a("gifdrawable");
        try {
            this.f17918b = GifDrawable.a(encodedImage.m15711b());
        } catch (Throwable e) {
            throw Throwables.m15700b(e);
        }
    }

    public final int mo2984f() {
        return mo2981c() ? 0 : this.f17918b.b[0];
    }

    public final int mo2985g() {
        return mo2981c() ? 0 : this.f17918b.b[1];
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f17918b;	 Catch:{ all -> 0x0016 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);	 Catch:{ all -> 0x0016 }
    L_0x0006:
        return;
    L_0x0007:
        r0 = r2.f17918b;	 Catch:{ all -> 0x0016 }
        r1 = 0;
        r2.f17918b = r1;	 Catch:{ all -> 0x0016 }
        monitor-exit(r2);	 Catch:{ all -> 0x0016 }
        gifdrawable.pl.droidsonroids.gif.GifDrawable.a(r0);	 Catch:{ all -> 0x0019 }
        r0 = r2.f17917a;
        r0.close();
        goto L_0x0006;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{  }
        throw r0;
    L_0x0019:
        r0 = move-exception;
        r1 = r2.f17917a;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.CloseableGIFImageOld.close():void");
    }

    public final synchronized boolean mo2981c() {
        return this.f17918b == null;
    }

    public final int mo2980b() {
        CloseableReference a = this.f17917a.m15708a();
        try {
            int a2 = (mo2981c() || !CloseableReference.m15679a(a)) ? 0 : ((NativePooledByteBuffer) a.m15682a()).m15689a();
            CloseableReference.m15681c(a);
            return a2;
        } catch (Throwable th) {
            CloseableReference.m15681c(a);
        }
    }

    public final boolean mo2992e() {
        return true;
    }
}
