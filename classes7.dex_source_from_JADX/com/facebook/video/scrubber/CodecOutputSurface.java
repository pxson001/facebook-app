package com.facebook.video.scrubber;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.view.Surface;
import com.facebook.common.references.CloseableReference;
import com.facebook.gl.ProgramFactory;
import com.facebook.gl.Texture.Builder;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.effects.VideoRenderer;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: distance_string */
public class CodecOutputSurface implements OnFrameAvailableListener {
    private static final String f15708a = CodecOutputSurface.class.getCanonicalName();
    public STextureRender f15709b;
    public SurfaceTexture f15710c;
    private Surface f15711d;
    private EGL10 f15712e;
    private EGLDisplay f15713f = EGL10.EGL_NO_DISPLAY;
    private EGLContext f15714g = EGL10.EGL_NO_CONTEXT;
    private EGLSurface f15715h = EGL10.EGL_NO_SURFACE;
    private final RectF f15716i;
    private final int f15717j;
    private final int f15718k;
    private final PlatformBitmapFactory f15719l;
    private final VideoMetadata f15720m;
    private final Object f15721n = new Object();
    private boolean f15722o;
    private ByteBuffer f15723p;
    private ProgramFactory f15724q;
    private List<GLRenderer> f15725r;

    @Inject
    public CodecOutputSurface(@Assisted VideoMetadata videoMetadata, @Assisted RectF rectF, @Assisted VideoMirroringMode videoMirroringMode, @Assisted List<GLRenderer> list, PlatformBitmapFactory platformBitmapFactory, ProgramFactory programFactory) {
        if (list == null || list.isEmpty()) {
            List arrayList = new ArrayList();
            arrayList.add(new VideoRenderer());
            this.f15725r = arrayList;
        } else {
            this.f15725r = list;
        }
        this.f15720m = videoMetadata;
        this.f15719l = platformBitmapFactory;
        this.f15724q = programFactory;
        this.f15712e = (EGL10) EGLContext.getEGL();
        this.f15716i = rectF;
        if (this.f15720m.d % 180 == 0) {
            this.f15717j = (int) (((float) this.f15720m.b) * this.f15716i.width());
            this.f15718k = (int) (((float) this.f15720m.c) * this.f15716i.height());
        } else {
            this.f15717j = (int) (((float) this.f15720m.c) * this.f15716i.width());
            this.f15718k = (int) (((float) this.f15720m.b) * this.f15716i.height());
        }
        m19648f();
        m19651c();
        m19646a(videoMirroringMode);
    }

    private void m19646a(VideoMirroringMode videoMirroringMode) {
        this.f15709b = new STextureRender(this.f15725r, this.f15720m.d, videoMirroringMode, this.f15716i);
        STextureRender sTextureRender = this.f15709b;
        Builder builder = new Builder();
        builder.a = 36197;
        sTextureRender.f15754e = builder.a(10241, 9729).a(10240, 9729).a(10242, 33071).a(10243, 33071).a();
        for (GLRenderer a : this.f15725r) {
            a.a(this.f15724q);
        }
        STextureRender sTextureRender2 = this.f15709b;
        Preconditions.checkNotNull(sTextureRender2.f15754e);
        this.f15710c = new SurfaceTexture(sTextureRender2.f15754e.b);
        this.f15710c.setOnFrameAvailableListener(this);
        this.f15711d = new Surface(this.f15710c);
        this.f15723p = ByteBuffer.allocateDirect((this.f15717j * this.f15718k) * 4);
        this.f15723p.order(ByteOrder.LITTLE_ENDIAN);
    }

    private void m19648f() {
        this.f15713f = this.f15712e.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f15713f == EGL10.EGL_NO_DISPLAY) {
            this.f15713f = null;
            throw new RuntimeException("unable to get EGL14 display");
        }
        if (this.f15712e.eglInitialize(this.f15713f, new int[2])) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (this.f15712e.eglChooseConfig(this.f15713f, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, eGLConfigArr, 1, new int[1])) {
                this.f15714g = this.f15712e.eglCreateContext(this.f15713f, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                m19647a("eglCreateContext");
                if (this.f15714g == null) {
                    throw new RuntimeException("null context");
                }
                this.f15715h = this.f15712e.eglCreatePbufferSurface(this.f15713f, eGLConfigArr[0], new int[]{12375, this.f15717j, 12374, this.f15718k, 12344});
                m19647a("eglCreatePbufferSurface");
                if (this.f15715h == null) {
                    throw new RuntimeException("surface was null");
                }
                return;
            }
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f15713f = null;
        throw new RuntimeException("unable to initialize EGL14");
    }

    public final void m19649a() {
        if (this.f15709b != null) {
            STextureRender sTextureRender = this.f15709b;
            GLES20.glDeleteTextures(1, new int[]{sTextureRender.f15754e.b}, 0);
            sTextureRender.f15754e = null;
            if (sTextureRender.f15753d != null) {
                for (GLRenderer a : sTextureRender.f15753d) {
                    a.a();
                }
            }
        }
        if (this.f15713f != EGL10.EGL_NO_DISPLAY) {
            this.f15712e.eglDestroySurface(this.f15713f, this.f15715h);
            this.f15712e.eglDestroyContext(this.f15713f, this.f15714g);
            this.f15712e.eglMakeCurrent(this.f15713f, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.f15712e.eglTerminate(this.f15713f);
        }
        this.f15713f = EGL10.EGL_NO_DISPLAY;
        this.f15714g = EGL10.EGL_NO_CONTEXT;
        this.f15715h = EGL10.EGL_NO_SURFACE;
        if (this.f15711d != null) {
            this.f15711d.release();
        }
        this.f15709b = null;
        this.f15711d = null;
        this.f15710c = null;
    }

    public final Surface m19650b() {
        return this.f15711d;
    }

    public final void m19651c() {
        if (!this.f15712e.eglMakeCurrent(this.f15713f, this.f15715h, this.f15715h, this.f15714g)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    private void m19647a(String str) {
        int eglGetError = this.f15712e.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f15721n) {
            if (this.f15722o) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.f15722o = true;
            ObjectDetour.c(this.f15721n, -1865249667);
        }
    }

    public final void m19652d() {
        synchronized (this.f15721n) {
            do {
                if (this.f15722o) {
                    this.f15722o = false;
                } else {
                    try {
                        ObjectDetour.a(this.f15721n, 2500, 1564381267);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
            } while (this.f15722o);
            throw new RuntimeException("frame wait timed out");
        }
        STextureRender.m19673a("before updateTexImage");
        this.f15710c.updateTexImage();
    }

    public final CloseableReference<Bitmap> m19653e() {
        this.f15723p.rewind();
        Object[] objArr = new Object[]{Integer.valueOf(this.f15717j), Integer.valueOf(this.f15718k)};
        GLES20.glReadPixels(0, 0, this.f15717j, this.f15718k, 6408, 5121, this.f15723p);
        CloseableReference<Bitmap> a = this.f15719l.a(this.f15717j, this.f15718k, Config.ARGB_8888);
        this.f15723p.rewind();
        ((Bitmap) a.a()).copyPixelsFromBuffer(this.f15723p);
        return a;
    }
}
