package com.facebook.facecast;

import com.facebook.video.videostreaming.RealtimeEncoderInputSurface;
import com.facebook.video.videostreaming.opengl.WindowSurface;

/* compiled from: bubbled */
public class LiveStreamOutputSurface {
    public static final String f18061a = LiveStreamOutputSurface.class.getSimpleName();
    public WindowSurface f18062b;
    public RealtimeEncoderInputSurface f18063c;
    public boolean f18064d;

    public final void m21894d() {
        if (this.f18062b != null) {
            this.f18062b.b();
            this.f18062b.d();
            this.f18062b = null;
        }
        this.f18064d = false;
    }
}
