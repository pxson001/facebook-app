package com.facebook.react.modules.debug;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.annotation.Nullable;

@TargetApi(16)
/* compiled from: fromControlY */
public class FpsDebugFrameCallback implements FrameCallback {
    private final Choreographer f11665a;
    private final ReactContext f11666b;
    private final UIManagerModule f11667c;
    private final DidJSUpdateUiDuringFrameDetector f11668d;
    private boolean f11669e = false;
    private long f11670f = -1;
    private long f11671g = -1;
    private int f11672h = 0;
    private int f11673i = 0;
    private int f11674j = 0;
    private int f11675k = 0;
    private boolean f11676l = false;
    @Nullable
    private TreeMap<Long, FpsInfo> f11677m;

    /* compiled from: fromControlY */
    public class FpsInfo {
        public final int f11658a;
        public final int f11659b;
        public final int f11660c;
        public final int f11661d;
        public final double f11662e;
        public final double f11663f;
        public final int f11664g;

        public FpsInfo(int i, int i2, int i3, int i4, double d, double d2, int i5) {
            this.f11658a = i;
            this.f11659b = i2;
            this.f11660c = i3;
            this.f11661d = i4;
            this.f11662e = d;
            this.f11663f = d2;
            this.f11664g = i5;
        }
    }

    public FpsDebugFrameCallback(Choreographer choreographer, ReactContext reactContext) {
        this.f11665a = choreographer;
        this.f11666b = reactContext;
        this.f11667c = (UIManagerModule) reactContext.m13525b(UIManagerModule.class);
        this.f11668d = new DidJSUpdateUiDuringFrameDetector();
    }

    public void doFrame(long j) {
        if (!this.f11669e) {
            if (this.f11670f == -1) {
                this.f11670f = j;
            }
            long j2 = this.f11671g;
            this.f11671g = j;
            if (this.f11668d.m13730a(j2, j)) {
                this.f11675k++;
            }
            this.f11672h++;
            int h = m13739h();
            if ((h - this.f11673i) - 1 >= 4) {
                this.f11674j++;
            }
            if (this.f11676l) {
                Assertions.b(this.f11677m);
                this.f11677m.put(Long.valueOf(System.currentTimeMillis()), new FpsInfo(m13737f(), m13738g(), h, this.f11674j, m13735d(), m13736e(), m13740i()));
            }
            this.f11673i = h;
            this.f11665a.postFrameCallback(this);
        }
    }

    private void m13734c() {
        this.f11669e = false;
        this.f11666b.m13513a().mo651a(this.f11668d);
        this.f11667c.m14035a(this.f11668d);
        this.f11665a.postFrameCallback(this);
    }

    public final void m13742a() {
        this.f11677m = new TreeMap();
        this.f11676l = true;
        m13734c();
    }

    public final void m13743b() {
        this.f11669e = true;
        this.f11666b.m13513a().mo654b(this.f11668d);
        this.f11667c.m14035a(null);
    }

    private double m13735d() {
        if (this.f11671g == this.f11670f) {
            return 0.0d;
        }
        return (((double) m13737f()) * 1.0E9d) / ((double) (this.f11671g - this.f11670f));
    }

    private double m13736e() {
        if (this.f11671g == this.f11670f) {
            return 0.0d;
        }
        return (((double) m13738g()) * 1.0E9d) / ((double) (this.f11671g - this.f11670f));
    }

    private int m13737f() {
        return this.f11672h - 1;
    }

    private int m13738g() {
        return this.f11675k - 1;
    }

    private int m13739h() {
        return (int) ((((double) m13740i()) / 16.9d) + 1.0d);
    }

    private int m13740i() {
        return ((int) (((double) this.f11671g) - ((double) this.f11670f))) / 1000000;
    }

    @Nullable
    public final FpsInfo m13741a(long j) {
        Assertions.a(this.f11677m, "FPS was not recorded at each frame!");
        Entry floorEntry = this.f11677m.floorEntry(Long.valueOf(j));
        if (floorEntry == null) {
            return null;
        }
        return (FpsInfo) floorEntry.getValue();
    }
}
