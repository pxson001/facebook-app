package com.facebook.videocodec.render;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.facebook.gl.GLHelpers;
import com.facebook.gl.ProgramFactory;
import com.facebook.videocodec.base.VideoCodecOpenGlColorFormat;
import com.facebook.videocodec.policy.VideoTranscodeParams;

@TargetApi(18)
/* compiled from: results_list_id */
public class TranscodeOutputSurfaceForJBMR2 {
    private static final Class<?> f5606a = TranscodeOutputSurfaceForJBMR2.class;
    public final ProgramFactory f5607b;
    public SurfaceTexture f5608c;
    private Surface f5609d;
    public Surface f5610e;
    public EGLDisplay f5611f = EGL14.EGL_NO_DISPLAY;
    public EGLContext f5612g = EGL14.EGL_NO_CONTEXT;
    public EGLSurface f5613h = EGL14.EGL_NO_SURFACE;
    public TranscodeTextureRenderer f5614i;
    public TranscodeOutputSurfaceFrameHandler f5615j;

    public TranscodeOutputSurfaceForJBMR2(ProgramFactory programFactory, Surface surface, VideoTranscodeParams videoTranscodeParams) {
        this.f5607b = programFactory;
        this.f5609d = surface;
        m8257f();
        m8258g();
        this.f5614i = new TranscodeTextureRenderer(this.f5607b, videoTranscodeParams, VideoCodecOpenGlColorFormat.RGBA);
        this.f5614i.m8262b();
        this.f5608c = new SurfaceTexture(this.f5614i.m8261a());
        this.f5615j = new TranscodeOutputSurfaceFrameHandler(this.f5608c, this.f5614i, 5000);
        this.f5608c.setOnFrameAvailableListener(this.f5615j);
        this.f5610e = new Surface(this.f5608c);
    }

    private void m8257f() {
        this.f5611f = EGL14.eglGetDisplay(0);
        if (this.f5611f == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(this.f5611f, iArr, 0, iArr, 1)) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.f5611f, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                this.f5612g = EGL14.eglCreateContext(this.f5611f, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                GLHelpers.b("eglCreateContext");
                if (this.f5612g == null) {
                    throw new RuntimeException("null context");
                }
                this.f5613h = EGL14.eglCreateWindowSurface(this.f5611f, eGLConfigArr[0], this.f5609d, new int[]{12344}, 0);
                GLHelpers.b("eglCreateWindowSurface");
                if (this.f5613h == null) {
                    throw new RuntimeException("surface was null");
                }
                return;
            }
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f5611f = null;
        throw new RuntimeException("unable to initialize EGL14");
    }

    private void m8258g() {
        if (!EGL14.eglMakeCurrent(this.f5611f, this.f5613h, this.f5613h, this.f5612g)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }
}
