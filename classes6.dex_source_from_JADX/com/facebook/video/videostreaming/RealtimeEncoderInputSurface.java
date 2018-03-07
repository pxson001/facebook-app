package com.facebook.video.videostreaming;

import android.view.Surface;

/* compiled from: sTexture */
public class RealtimeEncoderInputSurface {
    public int f5388a;
    public int f5389b;
    public volatile Surface f5390c;

    public RealtimeEncoderInputSurface(Surface surface, int i, int i2) {
        this.f5390c = surface;
        this.f5388a = i;
        this.f5389b = i2;
    }
}
