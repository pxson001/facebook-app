package com.facebook.gl;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES20;
import com.facebook.debug.log.BLog;

/* compiled from: WWW_HC_INLINE */
public class GLHelpers {
    private static final String f12328a = GLHelpers.class.getSimpleName();

    private static String m20405a(int i) {
        switch (i) {
            case 1280:
                return "GL_INVALID_ENUM";
            case 1281:
                return "GL_INVALID_VALUE";
            case 1282:
                return "GL_INVALID_OPERATION";
            case 1285:
                return "GL_OUT_OF_MEMORY";
            case 1286:
                return "GL_INVALID_FRAMEBUFFER_OPERATION";
            default:
                return "UNKNOWN";
        }
    }

    public static void m20406a(String str) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            BLog.b(f12328a, "%s: GL error 0x%04x %s", new Object[]{str, Integer.valueOf(glGetError), m20405a(glGetError)});
            i = glGetError;
            i2 = 1;
        }
        if (i2 != 0) {
            throw new RuntimeException(String.format("%s: GL error 0x%04x %s occurred, see logcat output", new Object[]{str, Integer.valueOf(i), m20405a(i)}));
        }
    }

    private static String m20407b(int i) {
        switch (i) {
            case 12289:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return "UNKNOWN";
        }
    }

    @TargetApi(17)
    public static void m20408b(String str) {
        int i = 12288;
        int i2 = 0;
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            BLog.b(f12328a, "%s: EGL error: 0x%04x %s", new Object[]{str, Integer.valueOf(eglGetError), m20407b(eglGetError)});
            i = eglGetError;
            i2 = 1;
        }
        if (i2 != 0) {
            throw new RuntimeException(String.format("%s: EGL error 0x%04x %s occurred, see logcat output", new Object[]{str, Integer.valueOf(i), m20407b(i)}));
        }
    }
}
