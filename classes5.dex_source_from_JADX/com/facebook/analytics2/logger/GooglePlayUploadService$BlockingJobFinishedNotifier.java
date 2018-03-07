package com.facebook.analytics2.logger;

import android.os.SystemClock;
import com.facebook.analytics2.logger.UploadServiceLogic.JobFinishedNotifier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: themeListImage */
class GooglePlayUploadService$BlockingJobFinishedNotifier implements JobFinishedNotifier {
    private volatile boolean f2007a;
    private final CountDownLatch f2008b;

    public GooglePlayUploadService$BlockingJobFinishedNotifier() {
        this.f2008b = new CountDownLatch(1);
    }

    public final void mo500a(boolean z) {
        this.f2007a = z;
        this.f2008b.countDown();
    }

    public final boolean m2706a(long j) {
        while (true) {
            try {
                break;
            } catch (InterruptedException e) {
                j = (SystemClock.uptimeMillis() + j) - SystemClock.uptimeMillis();
            }
        }
        if (this.f2008b.await(j, TimeUnit.MILLISECONDS)) {
            return this.f2007a;
        }
        throw new TimeoutException();
    }
}
