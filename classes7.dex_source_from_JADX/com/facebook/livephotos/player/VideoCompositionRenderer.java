package com.facebook.livephotos.player;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.facebook.debug.log.BLog;
import com.facebook.livephotos.egl.GLContext;
import com.facebook.livephotos.egl.GLFrameRenderer;
import com.facebook.livephotos.egl.GLOffScreenSurface;
import com.facebook.livephotos.egl.GLSurfaceBase;
import com.facebook.livephotos.egl.GLWindowSurface;
import com.facebook.livephotos.exoplayer.ExoPlayerImpl;
import com.facebook.livephotos.exoplayer.MediaCodecTrackRenderer.EventListener;
import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.TrackRenderer;
import java.util.Arrays;

/* compiled from: onTouchMoveCapture */
public class VideoCompositionRenderer extends TrackRenderer implements EventListener {
    public static final ChoreographerEvent[] f7776b = new ChoreographerEvent[]{new ScaleInChoreographerEvent(250000, 750000, 0), new BlurChoreographerEvent(250000, 1, true), new ScaleInChoreographerEvent(250000, 750000, 1), new FadeOutChoreographerEvent(250000, 750000, 1)};
    private final String f7777a = VideoCompositionRenderer.class.getSimpleName();
    private volatile long f7778c = -1;
    public float f7779d = -1.0f;
    public SurfaceParams f7780e;
    private GLFrameRenderer f7781f;
    public GLContext f7782g;
    private long f7783h;
    public GLWindowSurface f7784i;
    public TrackContext[] f7785j;
    public ExoPlayerImpl f7786k;
    public Choreographer f7787l;
    private boolean f7788m;

    /* compiled from: onTouchMoveCapture */
    public class SurfaceParams {
        public SurfaceHolder f7773a;
        public int f7774b;
        public int f7775c;

        public SurfaceParams(SurfaceHolder surfaceHolder, int i, int i2) {
            this.f7773a = surfaceHolder;
            this.f7774b = i;
            this.f7775c = i2;
        }
    }

    public VideoCompositionRenderer(ExoPlayerImpl exoPlayerImpl) {
        this.f7786k = exoPlayerImpl;
    }

    public final void mo384a(int i, Object obj) {
        switch (i) {
            case 1:
                if (!this.f7788m && this.f7778c == -1) {
                    this.f7778c = this.f7783h + 500000;
                    this.f7787l.f7749c.addAll(Arrays.asList(new ChoreographerEvent[]{new ScaleOutChoreographerEvent(this.f7783h, 500000, 0), new BlurChoreographerEvent(this.f7783h, 0, true)}));
                    return;
                }
                return;
            case 2:
                this.f7780e = (SurfaceParams) obj;
                return;
            default:
                return;
        }
    }

    private void m9397h() {
        try {
            this.f7782g.m8565d();
            this.f7782g = null;
        } catch (Throwable e) {
            BLog.b(this.f7777a, "shutGlContext", e);
        }
    }

    protected final void mo378c() {
    }

    protected final void mo373q() {
        m9397h();
    }

    protected final boolean mo367b(long j) {
        if (this.f7780e == null || this.f7785j == null) {
            return false;
        }
        int i = this.f7780e.f7774b;
        int i2 = this.f7780e.f7775c;
        Surface surface = this.f7780e.f7773a.getSurface();
        this.f7782g = new GLContext();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glViewport(0, 0, i, i2);
        GLContext gLContext = this.f7782g;
        GLWindowSurface gLWindowSurface = new GLWindowSurface(gLContext, surface);
        gLContext.f6663h.add(gLWindowSurface);
        this.f7784i = gLWindowSurface;
        this.f7784i.m8574c();
        for (int i3 = 0; i3 < this.f7785j.length; i3++) {
            TrackContext trackContext = this.f7785j[i3];
            GLContext gLContext2 = this.f7782g;
            GLOffScreenSurface gLOffScreenSurface = new GLOffScreenSurface(gLContext2, i, i2);
            gLContext2.f6663h.add(gLOffScreenSurface);
            trackContext.f7770d = gLOffScreenSurface;
            this.f7786k.m8576a(this.f7785j[i3].f7771e, 1, this.f7785j[i3].f7770d.f6682b);
        }
        this.f7787l = new Choreographer(f7776b);
        return true;
    }

    protected final boolean mo380e() {
        return this.f7788m;
    }

    protected final boolean mo381f() {
        return true;
    }

    protected final void mo366a(long j, long j2) {
        this.f7783h = j;
        if (!(this.f7788m || this.f7778c == -1 || this.f7783h < this.f7778c)) {
            m9398i();
        }
        if (!this.f7788m && this.f7779d >= 0.0f) {
            try {
                m9399j();
            } catch (Throwable e) {
                BLog.b(this.f7777a, "render", e);
                m9398i();
            }
        }
    }

    private void m9398i() {
        this.f7788m = true;
        for (TrackContext trackContext : this.f7785j) {
            ((HasUnknownDuration) trackContext.f7771e).gH_();
            if (trackContext.f7772f != null) {
                ((HasUnknownDuration) trackContext.f7772f).gH_();
            }
        }
    }

    private void m9399j() {
        int i;
        this.f7784i.m8574c();
        if (this.f7781f == null && this.f7779d > 0.0f) {
            this.f7781f = new GLFrameRenderer(this.f7782g);
        }
        GLWindowSurface gLWindowSurface = this.f7784i;
        GLES20.glClear(16384);
        for (TrackContext trackContext : this.f7785j) {
            if (trackContext.f7770d.f6685e) {
                GLOffScreenSurface gLOffScreenSurface = trackContext.f7770d;
                gLOffScreenSurface.f6683c.updateTexImage();
                gLOffScreenSurface.f6683c.getTransformMatrix(gLOffScreenSurface.f6686f);
                gLOffScreenSurface.f6685e = false;
            }
        }
        this.f7787l.m9372a(this.f7785j, this.f7783h);
        for (TrackContext trackContext2 : this.f7785j) {
            this.f7781f.m8568a(trackContext2.f7770d.f6686f, trackContext2.f7770d.f6684d, trackContext2.f7767a, trackContext2.f7768b, trackContext2.f7769c);
        }
        GLSurfaceBase gLSurfaceBase = this.f7784i;
        if (EGL14.eglSwapBuffers(gLSurfaceBase.f6681a.f6661f, gLSurfaceBase.m8572a())) {
            i = 12288;
        } else {
            i = EGL14.eglGetError();
        }
        if (i == 12302) {
            BLog.b(this.f7777a, "EGL_CONTEXT_LOST!");
        }
    }

    protected final void mo372p() {
    }

    protected final long mo371o() {
        return -1;
    }

    protected final long mo370n() {
        return -3;
    }

    protected final void mo368c(long j) {
        throw new UnsupportedOperationException();
    }

    protected final MediaFormat mo364a(int i) {
        return null;
    }

    protected final int mo374r() {
        return 1;
    }
}
