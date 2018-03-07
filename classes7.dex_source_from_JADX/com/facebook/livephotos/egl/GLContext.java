package com.facebook.livephotos.egl;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.util.Log;
import com.facebook.debug.log.BLog;
import com.google.common.base.Preconditions;
import java.util.ArrayList;

@TargetApi(19)
/* compiled from: pendingStories */
public class GLContext {
    private static final String f6656a = GLContext.class.getSimpleName();
    private int[] f6657b;
    public int[] f6658c;
    private int[] f6659d;
    public EGLConfig f6660e;
    public EGLDisplay f6661f;
    public EGLContext f6662g;
    public ArrayList<GLSurfaceBase> f6663h;

    public GLContext() {
        this.f6657b = new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
        this.f6658c = new int[]{12344};
        this.f6659d = new int[]{12440, 2, 12344};
        this.f6661f = EGL14.EGL_NO_DISPLAY;
        this.f6662g = EGL14.EGL_NO_CONTEXT;
        this.f6663h = new ArrayList();
        this.f6661f = EGL14.eglGetDisplay(0);
        boolean z = (this.f6661f == null || this.f6661f == EGL14.EGL_NO_DISPLAY) ? false : true;
        Preconditions.checkState(z, "Failed to get EGL Display");
        int[] iArr = new int[2];
        EGL14.eglInitialize(this.f6661f, iArr, 0, iArr, 1);
        m8562b("eglInitialize");
        boolean z2 = true;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[]{0};
        boolean eglChooseConfig = EGL14.eglChooseConfig(this.f6661f, this.f6657b, 0, eGLConfigArr, 0, 1, iArr2, 0);
        m8562b("eglChooseConfig");
        if (!eglChooseConfig || iArr2[0] <= 0) {
            z2 = false;
        }
        Preconditions.checkState(z2, "Failed to find matching EGL Config");
        this.f6660e = eGLConfigArr[0];
        this.f6662g = m8560a(this.f6660e);
    }

    public final boolean m8564a() {
        return (this.f6662g == null || this.f6662g == EGL14.EGL_NO_CONTEXT) ? false : true;
    }

    private EGLContext m8560a(EGLConfig eGLConfig) {
        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f6661f, eGLConfig, EGL14.EGL_NO_CONTEXT, this.f6659d, 0);
        m8562b("eglCreateContext");
        return eglCreateContext;
    }

    public final void m8565d() {
        EGL14.eglMakeCurrent(this.f6661f, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        int size = this.f6663h.size();
        for (int i = 0; i < size; i++) {
            ((GLSurfaceBase) this.f6663h.get(i)).mo363b();
        }
        if (this.f6662g != null) {
            EGL14.eglDestroyContext(this.f6661f, this.f6662g);
        }
        EGL14.eglTerminate(this.f6661f);
    }

    public static void m8561a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e(f6656a, str + ": glError 0x" + Integer.toHexString(glGetError) + " (" + GLU.gluErrorString(glGetError) + ")");
        }
    }

    public static void m8562b(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            Log.e(f6656a, str + ": eglError 0x" + Integer.toHexString(eglGetError));
        }
    }

    final int m8563a(String str, String str2) {
        int a = m8559a(35633, str);
        int a2 = m8559a(35632, str2);
        if (a == 0 || a2 == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, a);
        GLES20.glAttachShader(glCreateProgram, a2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateProgram;
        }
        BLog.b(f6656a, "createProgram failed:\n%s", new Object[]{GLES20.glGetProgramInfoLog(glCreateProgram)});
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    private int m8559a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m8561a("glCreateShader");
        GLES20.glShaderSource(glCreateShader, str);
        m8561a("glShaderSource");
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        BLog.b(f6656a, "glCompileShader failed: [%s]\n%s", new Object[]{GLES20.glGetShaderInfoLog(glCreateShader), str});
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }
}
