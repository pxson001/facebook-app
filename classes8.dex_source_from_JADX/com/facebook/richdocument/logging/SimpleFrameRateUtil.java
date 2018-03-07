package com.facebook.richdocument.logging;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

/* compiled from: place_home */
public class SimpleFrameRateUtil extends OnScrollListener {
    public final Choreographer f5568a;
    public final int f5569b;
    public boolean f5570c = false;
    public long f5571d = -1;
    public final LogMode f5572e;
    private final int f5573f;
    public final long f5574g;
    public int f5575h = 0;
    public final FrameCallback f5576i;

    /* compiled from: place_home */
    class C07141 implements FrameCallback {
        final /* synthetic */ SimpleFrameRateUtil f5567a;

        C07141(SimpleFrameRateUtil simpleFrameRateUtil) {
            this.f5567a = simpleFrameRateUtil;
        }

        public void doFrame(long j) {
            if (this.f5567a.f5570c) {
                SimpleFrameRateUtil simpleFrameRateUtil = this.f5567a;
                int i = 0;
                if (simpleFrameRateUtil.f5571d == -1) {
                    simpleFrameRateUtil.f5571d = j;
                } else {
                    long j2 = j - simpleFrameRateUtil.f5571d;
                    float round = (float) Math.round((((float) j2) / ((float) simpleFrameRateUtil.f5574g)) - 1.0f);
                    if (simpleFrameRateUtil.f5572e == LogMode.ONLY_DROPS) {
                        simpleFrameRateUtil.f5575h = (int) (((float) simpleFrameRateUtil.f5575h) + round);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder(String.format("frame interval = %.2f ms ", new Object[]{Double.valueOf(((double) j2) * 1.0E-6d)}));
                        if (((double) j2) * 1.0E-6d > ((double) simpleFrameRateUtil.f5569b)) {
                            while (((float) i) < round) {
                                stringBuilder.append("*");
                                i++;
                            }
                        }
                    }
                    simpleFrameRateUtil.f5571d = j;
                }
                this.f5567a.f5568a.postFrameCallback(this);
            }
        }
    }

    /* compiled from: place_home */
    public enum LogMode {
        ONLY_DROPS,
        ALL_FRAME_INTERVALS
    }

    public SimpleFrameRateUtil(Context context, LogMode logMode) {
        this.f5572e = logMode;
        if (VERSION.SDK_INT > 17) {
            this.f5573f = (int) ((DisplayManager) context.getSystemService("display")).getDisplay(0).getRefreshRate();
        } else {
            this.f5573f = 60;
        }
        float f = 1000.0f / ((float) this.f5573f);
        this.f5574g = (long) (1000000.0f * f);
        this.f5569b = Math.round(f) + 3;
        Object[] objArr = new Object[]{Integer.valueOf(this.f5573f), Float.valueOf(f), Integer.valueOf(this.f5569b)};
        this.f5568a = Choreographer.getInstance();
        this.f5576i = new C07141(this);
    }

    public final void m5411a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            m5410a();
            if (this.f5572e == LogMode.ONLY_DROPS) {
                Integer.valueOf(this.f5575h);
                return;
            }
            return;
        }
        if (!this.f5570c) {
            this.f5575h = 0;
            this.f5571d = -1;
            this.f5570c = true;
            this.f5568a.postFrameCallback(this.f5576i);
        }
    }

    public final void m5412a(RecyclerView recyclerView, int i, int i2) {
    }

    public final void m5410a() {
        this.f5570c = false;
        this.f5568a.removeFrameCallback(this.f5576i);
    }
}
