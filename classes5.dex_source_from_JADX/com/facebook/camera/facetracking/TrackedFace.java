package com.facebook.camera.facetracking;

import android.graphics.Rect;

/* compiled from: allow_write_in_response */
public class TrackedFace {
    public float f10949a = 0.0f;
    public float f10950b = 0.0f;
    public Rect f10951c = null;
    public float f10952d = 0.0f;
    public float f10953e = 0.0f;
    public Rect f10954f = null;
    public double f10955g = Double.MAX_VALUE;
    public boolean f10956h = false;
    public float f10957i = 0.0f;
    public float f10958j = 0.0f;
    public int f10959k = 0;
    public long f10960l = 0;

    public /* synthetic */ Object clone() {
        return m18981b();
    }

    private TrackedFace(long j) {
        this.f10960l = j;
    }

    public TrackedFace(Rect rect) {
        this.f10954f = rect;
        this.f10952d = rect.exactCenterX();
        this.f10953e = rect.exactCenterY();
        this.f10960l = System.currentTimeMillis();
    }

    public final int m18979a() {
        return this.f10954f.width() * this.f10954f.height();
    }

    public final void m18980a(Rect rect) {
        this.f10951c = this.f10954f;
        this.f10949a = this.f10952d;
        this.f10950b = this.f10953e;
        this.f10955g = FaceTracker.m18975a(rect.exactCenterX(), rect.exactCenterY(), this.f10952d, this.f10953e);
        this.f10954f = rect;
        this.f10952d = rect.exactCenterX();
        this.f10953e = rect.exactCenterY();
    }

    public final TrackedFace m18981b() {
        TrackedFace trackedFace = new TrackedFace(this.f10960l);
        if (this.f10954f != null) {
            Rect rect = this.f10954f;
            trackedFace.f10954f = new Rect(rect);
            trackedFace.f10952d = rect.exactCenterX();
            trackedFace.f10953e = rect.exactCenterY();
        }
        if (this.f10951c != null) {
            rect = this.f10951c;
            trackedFace.f10951c = new Rect(rect);
            trackedFace.f10949a = rect.exactCenterX();
            trackedFace.f10950b = rect.exactCenterY();
        }
        trackedFace.f10955g = this.f10955g;
        trackedFace.f10956h = this.f10956h;
        trackedFace.f10957i = this.f10957i;
        trackedFace.f10958j = this.f10958j;
        trackedFace.f10959k = this.f10959k;
        return trackedFace;
    }
}
