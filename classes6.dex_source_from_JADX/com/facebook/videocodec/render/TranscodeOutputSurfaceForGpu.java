package com.facebook.videocodec.render;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.facebook.debug.log.BLog;
import com.facebook.gl.ProgramFactory;
import com.facebook.videocodec.base.VideoCodecOpenGlColorFormat;
import com.facebook.videocodec.policy.VideoTranscodeParams;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(16)
/* compiled from: results_num */
public class TranscodeOutputSurfaceForGpu {
    private static final Class<?> f5590a = TranscodeOutputSurfaceForGpu.class;
    public final ProgramFactory f5591b;
    public final int f5592c;
    public final int f5593d;
    public final VideoCodecOpenGlColorFormat f5594e;
    public TranscodeTextureRenderer f5595f;
    public SurfaceTexture f5596g;
    public TranscodeOutputSurfaceFrameHandler f5597h;
    public Surface f5598i;
    public EGL10 f5599j;
    public EGLDisplay f5600k = EGL10.EGL_NO_DISPLAY;
    public EGLContext f5601l = EGL10.EGL_NO_CONTEXT;
    public EGLSurface f5602m = EGL10.EGL_NO_SURFACE;
    public ByteBuffer f5603n;
    public long f5604o;
    public boolean f5605p;

    public TranscodeOutputSurfaceForGpu(ProgramFactory programFactory, VideoTranscodeParams videoTranscodeParams, VideoCodecOpenGlColorFormat videoCodecOpenGlColorFormat) {
        if (videoTranscodeParams.f5577d <= 0 || videoTranscodeParams.f5578e <= 0) {
            throw new IllegalArgumentException();
        }
        this.f5591b = programFactory;
        this.f5599j = (EGL10) EGLContext.getEGL();
        this.f5592c = videoTranscodeParams.f5577d;
        this.f5593d = videoTranscodeParams.f5578e;
        this.f5594e = videoCodecOpenGlColorFormat;
        m8254d();
        m8255e();
        this.f5595f = new TranscodeTextureRenderer(this.f5591b, videoTranscodeParams, this.f5594e);
        this.f5595f.m8262b();
        if (BLog.b(2)) {
            new StringBuilder("textureID=").append(this.f5595f.m8261a());
        }
        this.f5596g = new SurfaceTexture(this.f5595f.m8261a());
        this.f5597h = new TranscodeOutputSurfaceFrameHandler(this.f5596g, this.f5595f, 5000);
        this.f5596g.setOnFrameAvailableListener(this.f5597h);
        this.f5598i = new Surface(this.f5596g);
        this.f5603n = ByteBuffer.allocateDirect((this.f5592c * this.f5593d) * 4);
        this.f5603n.order(ByteOrder.LITTLE_ENDIAN);
    }

    private void m8254d() {
        this.f5600k = this.f5599j.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f5600k == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        if (this.f5599j.eglInitialize(this.f5600k, new int[2])) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (this.f5599j.eglChooseConfig(this.f5600k, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                this.f5601l = this.f5599j.eglCreateContext(this.f5600k, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                m8253a("eglCreateContext");
                if (this.f5601l == null) {
                    throw new RuntimeException("null context");
                }
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                SurfaceTexture surfaceTexture = new SurfaceTexture(iArr[0]);
                surfaceTexture.setDefaultBufferSize(this.f5592c, this.f5593d);
                this.f5602m = this.f5599j.eglCreateWindowSurface(this.f5600k, eGLConfigArr[0], surfaceTexture, null);
                m8253a("eglCreateWindowSurface");
                if (this.f5602m == null) {
                    throw new RuntimeException("surface was null");
                }
                return;
            }
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f5600k = null;
        throw new RuntimeException("unable to initialize EGL14");
    }

    private void m8255e() {
        if (!this.f5599j.eglMakeCurrent(this.f5600k, this.f5602m, this.f5602m, this.f5601l)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final TranscodedFrameResult m8256c() {
        if (!this.f5605p) {
            return null;
        }
        this.f5603n.rewind();
        GLES20.glReadPixels(0, 0, this.f5592c, this.f5593d, this.f5594e.openGlConstant, 5121, this.f5603n);
        this.f5605p = false;
        return new TranscodedFrameResult(this.f5603n, this.f5604o);
    }

    private void m8253a(String str) {
        int eglGetError = this.f5599j.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
