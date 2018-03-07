package com.facebook.livephotos.exoplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.WindowManager;

@TargetApi(16)
/* compiled from: page_unsave_success */
public final class VideoFrameReleaseTimeHelper {
    public final VSyncSampler f6884a;
    public final boolean f6885b;
    private final long f6886c;
    private final long f6887d;
    private long f6888e;
    private long f6889f;
    private long f6890g;
    public boolean f6891h;
    private long f6892i;
    private long f6893j;
    private long f6894k;

    /* compiled from: page_unsave_success */
    public final class VSyncSampler implements Callback, FrameCallback {
        public static final VSyncSampler f6878b = new VSyncSampler();
        public volatile long f6879a;
        public final Handler f6880c;
        private final HandlerThread f6881d = new HandlerThread("ChoreographerOwner:Handler");
        public Choreographer f6882e;
        public int f6883f;

        private VSyncSampler() {
            this.f6881d.start();
            this.f6880c = new Handler(this.f6881d.getLooper(), this);
            this.f6880c.sendEmptyMessage(0);
        }

        public final void doFrame(long j) {
            this.f6879a = j;
            this.f6882e.postFrameCallbackDelayed(this, 500);
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.f6882e = Choreographer.getInstance();
                    return true;
                case 1:
                    this.f6883f++;
                    if (this.f6883f == 1) {
                        this.f6882e.postFrameCallback(this);
                    }
                    return true;
                case 2:
                    this.f6883f--;
                    if (this.f6883f == 0) {
                        this.f6882e.removeFrameCallback(this);
                        this.f6879a = 0;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    public VideoFrameReleaseTimeHelper() {
        this(-1.0f, false);
    }

    private VideoFrameReleaseTimeHelper(float f, boolean z) {
        this.f6885b = z;
        if (z) {
            this.f6884a = VSyncSampler.f6878b;
            this.f6886c = (long) (1.0E9d / ((double) f));
            this.f6887d = (this.f6886c * 80) / 100;
            return;
        }
        this.f6884a = null;
        this.f6886c = -1;
        this.f6887d = -1;
    }

    public final long m8773a(long j, long j2) {
        long j3;
        long j4;
        long j5 = j * 1000;
        if (this.f6891h) {
            if (j != this.f6888e) {
                this.f6894k++;
                this.f6889f = this.f6890g;
            }
            if (this.f6894k >= 6) {
                j3 = this.f6889f + ((j5 - this.f6893j) / this.f6894k);
                if (m8772b(j3, j2)) {
                    this.f6891h = false;
                    j4 = j2;
                    j3 = j5;
                } else {
                    j4 = (this.f6892i + j3) - this.f6893j;
                }
                if (!this.f6891h) {
                    this.f6893j = j5;
                    this.f6892i = j2;
                    this.f6894k = 0;
                    this.f6891h = true;
                }
                this.f6888e = j;
                this.f6890g = j3;
                return (this.f6884a == null || this.f6884a.f6879a == 0) ? j4 : m8771a(j4, this.f6884a.f6879a, this.f6886c) - this.f6887d;
            } else if (m8772b(j5, j2)) {
                this.f6891h = false;
            }
        }
        j4 = j2;
        j3 = j5;
        if (this.f6891h) {
            this.f6893j = j5;
            this.f6892i = j2;
            this.f6894k = 0;
            this.f6891h = true;
        }
        this.f6888e = j;
        this.f6890g = j3;
        if (this.f6884a == null) {
            return j4;
        }
    }

    private boolean m8772b(long j, long j2) {
        return Math.abs((j2 - this.f6892i) - (j - this.f6893j)) > 20000000;
    }

    private static long m8771a(long j, long j2, long j3) {
        long j4;
        long j5 = (((j - j2) / j3) * j3) + j2;
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j4 = j5;
            j5 += j3;
        }
        if (j5 - j < j - j4) {
            return j5;
        }
        return j4;
    }

    public VideoFrameReleaseTimeHelper(Context context) {
        this(((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate(), true);
    }
}
