package com.facebook.rtc.opengl;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.facebook.debug.log.BLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: application/vnd.oma.drm.rights+xml */
public class GlUtil {
    public static final float[] f19875a;
    public static final Class<?> f19876b = GlUtil.class;

    static {
        float[] fArr = new float[16];
        f19875a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    private GlUtil() {
    }

    public static int m19601b(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m19600a("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        BLog.b(f19876b, "Could not compile shader %d: %s", new Object[]{Integer.valueOf(i), GLES20.glGetShaderInfoLog(glCreateShader)});
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static void m19600a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
            BLog.b(f19876b, str2);
            throw new RuntimeException(str2);
        }
    }

    public static void m19599a(int i, String str) {
        if (i < 0) {
            throw new RuntimeException("Unable to locate '" + str + "' in program");
        }
    }

    public static FloatBuffer m19598a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }
}
