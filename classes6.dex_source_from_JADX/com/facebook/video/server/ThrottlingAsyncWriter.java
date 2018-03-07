package com.facebook.video.server;

import com.facebook.ui.media.cache.FileMetadata;
import com.google.common.base.Preconditions;
import com.google.common.io.CountingOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: commerce_contact_merchant_store_create */
public class ThrottlingAsyncWriter implements AsyncWriter {
    public final AsyncWriter f19531a;
    public final ThrottlingPolicy f19532b;
    public final VideoServerRequestIdentifier f19533c;
    public final ScheduledExecutorService f19534d;
    public final boolean f19535e;
    private final long f19536f;

    /* compiled from: commerce_contact_merchant_store_create */
    public class ThrottledHandler implements AsyncWriter$Handler {
        final /* synthetic */ ThrottlingAsyncWriter f19523a;
        public final AsyncWriter$Handler f19524b;
        private final long f19525c;
        public long f19526d;
        public OutputStream f19527e;
        public CountingOutputStream f19528f;
        private long f19529g;
        private ThrottledRunnable f19530h;

        /* compiled from: commerce_contact_merchant_store_create */
        class C14561 implements Runnable {
            final /* synthetic */ ThrottledHandler f19521a;

            C14561(ThrottledHandler throttledHandler) {
                this.f19521a = throttledHandler;
            }

            public void run() {
                ThrottledHandler.m28252a(this.f19521a);
            }
        }

        /* compiled from: commerce_contact_merchant_store_create */
        class ThrottledRunnable implements Runnable {
            final /* synthetic */ ThrottledHandler f19522a;

            public ThrottledRunnable(ThrottledHandler throttledHandler) {
                this.f19522a = throttledHandler;
            }

            public void run() {
                ThrottledHandler.m28252a(this.f19522a);
            }
        }

        public ThrottledHandler(ThrottlingAsyncWriter throttlingAsyncWriter, long j, long j2, AsyncWriter$Handler asyncWriter$Handler) {
            this.f19523a = throttlingAsyncWriter;
            this.f19524b = asyncWriter$Handler;
            this.f19525c = j;
            this.f19529g = j;
            this.f19526d = j2;
        }

        public final void mo1419a(IOException iOException) {
            if (this.f19528f == null) {
                this.f19524b.mo1419a(iOException);
            } else {
                this.f19524b.mo1420a(this.f19527e, iOException);
            }
        }

        public final OutputStream mo1418a(FileMetadata fileMetadata) {
            if (this.f19528f == null) {
                this.f19527e = this.f19524b.mo1418a(fileMetadata);
                if (this.f19527e != null) {
                    this.f19528f = new CountingOutputStream(this.f19527e);
                    if (this.f19526d <= 0 && fileMetadata.a > 0) {
                        this.f19526d = fileMetadata.a;
                    }
                }
            }
            return this.f19528f;
        }

        public final void mo1420a(OutputStream outputStream, IOException iOException) {
            if (iOException != null) {
                this.f19524b.mo1420a(this.f19527e, iOException);
                return;
            }
            long j = this.f19525c + this.f19528f.a;
            if (this.f19529g != j) {
                this.f19529g = j;
                if (this.f19526d <= 0 || this.f19529g < this.f19526d) {
                    m28252a(this);
                    return;
                }
            }
            this.f19524b.mo1420a(this.f19527e, null);
        }

        public static void m28252a(ThrottledHandler throttledHandler) {
            long j;
            if (throttledHandler.f19523a.f19533c.c == null) {
                j = -2;
            } else {
                j = throttledHandler.f19523a.f19532b.a(throttledHandler.f19523a.f19533c, throttledHandler.f19529g);
            }
            if (j == -1) {
                IOException asyncWriter$CancelledException = new AsyncWriter$CancelledException("Throttling stopped", null);
                if (throttledHandler.f19527e == null) {
                    throttledHandler.f19524b.mo1419a(asyncWriter$CancelledException);
                } else {
                    throttledHandler.f19524b.mo1420a(throttledHandler.f19527e, asyncWriter$CancelledException);
                }
            } else if (j != 0) {
                throttledHandler.f19523a.f19531a.a(throttledHandler.f19529g, ThrottlingAsyncWriter.m28256a(throttledHandler.f19523a, throttledHandler.f19529g, j == -2 ? throttledHandler.f19526d : j + throttledHandler.f19529g), throttledHandler);
            } else if (throttledHandler.f19523a.f19535e) {
                if (throttledHandler.f19530h == null) {
                    throttledHandler.f19530h = new ThrottledRunnable(throttledHandler);
                }
                throttledHandler.f19523a.f19534d.schedule(throttledHandler.f19530h, 20, TimeUnit.MILLISECONDS);
            } else {
                throttledHandler.f19523a.f19534d.schedule(new C14561(throttledHandler), 20, TimeUnit.MILLISECONDS);
            }
        }
    }

    public ThrottlingAsyncWriter(VideoServerRequestIdentifier videoServerRequestIdentifier, AsyncWriter asyncWriter, ScheduledExecutorService scheduledExecutorService, ThrottlingPolicy throttlingPolicy, boolean z, int i) {
        this.f19533c = (VideoServerRequestIdentifier) Preconditions.checkNotNull(videoServerRequestIdentifier);
        this.f19531a = (AsyncWriter) Preconditions.checkNotNull(asyncWriter);
        this.f19532b = (ThrottlingPolicy) Preconditions.checkNotNull(throttlingPolicy);
        this.f19534d = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        this.f19535e = z;
        this.f19536f = (long) i;
    }

    public final void m28257a(long j, long j2, AsyncWriter$Handler asyncWriter$Handler) {
        ThrottledHandler.m28252a(new ThrottledHandler(this, j, j2, asyncWriter$Handler));
    }

    public static long m28256a(ThrottlingAsyncWriter throttlingAsyncWriter, long j, long j2) {
        long j3 = throttlingAsyncWriter.f19536f + j;
        return (j2 <= 0 || j3 < j2) ? j3 : j2;
    }
}
