package com.facebook.facecast;

import com.facebook.debug.log.BLog;
import com.facebook.video.videostreaming.RealtimeEncoderInputSurface;
import com.facebook.video.videostreaming.RecordingListenerDelegate;
import com.facebook.video.videostreaming.opengl.EglCore;
import com.facebook.video.videostreaming.opengl.WindowSurface;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: cache_key */
public class EncoderSurface2 {
    private static final String f17911a = EncoderSurface2.class.getSimpleName();
    private WeakReference<RecordingListenerDelegate> f17912b;
    public WindowSurface f17913c;
    public int f17914d;
    public int f17915e;
    public boolean f17916f;

    public final void m21755a(EglCore eglCore) {
        RecordingListenerDelegate h = m21753h();
        if (h == null || this.f17913c != null || eglCore == null) {
            BLog.a(f17911a, "Discarding the recorder init surface request.");
            return;
        }
        RealtimeEncoderInputSurface realtimeEncoderInputSurface = (RealtimeEncoderInputSurface) h.j().get(0);
        if (realtimeEncoderInputSurface == null || !realtimeEncoderInputSurface.c.isValid()) {
            BLog.a(f17911a, "The recorder surface invalid. Delegate %s", new Object[]{h});
            return;
        }
        this.f17913c = new WindowSurface(eglCore, realtimeEncoderInputSurface.c, false);
        this.f17914d = realtimeEncoderInputSurface.a;
        this.f17915e = realtimeEncoderInputSurface.b;
        h.l();
    }

    @Nullable
    private RecordingListenerDelegate m21753h() {
        if (this.f17912b == null) {
            return null;
        }
        return (RecordingListenerDelegate) this.f17912b.get();
    }

    public final void m21754a(RecordingListenerDelegate recordingListenerDelegate) {
        this.f17912b = new WeakReference(recordingListenerDelegate);
    }

    public final void m21756d() {
        if (this.f17913c != null) {
            this.f17913c.b();
            this.f17913c.d();
            this.f17913c = null;
        }
        this.f17916f = false;
    }

    public final void m21757e() {
        RecordingListenerDelegate h = m21753h();
        if (h != null) {
            h.k();
        }
    }

    public final void m21758f() {
        Preconditions.checkNotNull(this.f17913c);
    }

    public final boolean m21759g() {
        return this.f17916f;
    }
}
