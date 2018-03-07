package com.facebook.photos.upload.retry;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.upload.uploaders.WakeLockHandler;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: full_screen_gallery */
public class UploaderImmediateRetryPolicy implements ImmediateRetryPolicy {
    private static final Class<?> f14221a = UploaderImmediateRetryPolicy.class;
    private final DefaultAndroidThreadUtil f14222b;
    private final int f14223c;
    private final int[] f14224d;
    private final FbNetworkManager f14225e;
    private final WakeLockHandler f14226f;
    private int f14227g = 0;
    private boolean f14228h = false;
    private Semaphore f14229i = null;

    public UploaderImmediateRetryPolicy(DefaultAndroidThreadUtil defaultAndroidThreadUtil, int i, int[] iArr, FbNetworkManager fbNetworkManager, WakeLockHandler wakeLockHandler) {
        this.f14222b = defaultAndroidThreadUtil;
        this.f14223c = i;
        this.f14224d = iArr;
        this.f14226f = wakeLockHandler;
        this.f14225e = fbNetworkManager;
    }

    public final void mo1149a(Semaphore semaphore) {
        this.f14229i = semaphore;
    }

    public final void mo1146a() {
        this.f14227g = 0;
        this.f14228h = false;
    }

    public final void mo1148a(Exception exception) {
        mo1147a(new ExceptionInterpreter(exception));
    }

    public final void mo1147a(ExceptionInterpreter exceptionInterpreter) {
        if (!exceptionInterpreter.m19969j()) {
            throw exceptionInterpreter.m19959a();
        } else if (exceptionInterpreter.m19968i() && ((this.f14228h && this.f14227g >= this.f14223c) || !this.f14225e.d())) {
            throw exceptionInterpreter.m19959a();
        } else if (this.f14227g >= this.f14224d.length || this.f14224d[this.f14227g] < 0) {
            throw exceptionInterpreter.m19959a();
        } else {
            this.f14226f.m22171b();
            int[] iArr = this.f14224d;
            int i = this.f14227g;
            this.f14227g = i + 1;
            long j = ((long) iArr[i]) * 1000;
            try {
                if (this.f14229i == null) {
                    this.f14222b.a(j);
                } else if (this.f14229i.tryAcquire(j, TimeUnit.MILLISECONDS)) {
                    this.f14229i.release();
                    throw new CancellationException("Cancel during retry wait");
                }
                this.f14226f.m22170a();
            } catch (Throwable th) {
                this.f14226f.m22170a();
            }
        }
    }

    public final int mo1151b() {
        return 5;
    }

    public final void mo1150a(boolean z) {
        this.f14228h = z;
    }

    public final boolean mo1152c() {
        return this.f14228h;
    }
}
