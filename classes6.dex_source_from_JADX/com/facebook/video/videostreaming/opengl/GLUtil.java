package com.facebook.video.videostreaming.opengl;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.facebook.debug.log.BLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: rtc_call_data */
public class GLUtil {
    public static final float[] f5427a;
    private static final String f5428b = GLUtil.class.getName();

    static {
        float[] fArr = new float[16];
        f5427a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static void m8120a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            BLog.b(f5428b, "%s: glError %d", new Object[]{str, Integer.valueOf(glGetError)});
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }

    public static void m8119a(int i, String str) {
        if (i < 0) {
            throw new RuntimeException("Unable to locate '" + str + "' in program");
        }
    }

    public static FloatBuffer m8118a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int m8117a(String str, String str2) {
        int b = m8121b(35633, str);
        if (b == 0) {
            return 0;
        }
        int b2 = m8121b(35632, str2);
        if (b2 == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        m8120a("glCreateProgram");
        if (glCreateProgram == 0) {
            BLog.b(f5428b, "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, b);
        m8120a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, b2);
        m8120a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        BLog.b(f5428b, "Could not link program: ");
        BLog.b(f5428b, GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    private static int m8121b(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m8120a("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        BLog.b(f5428b, "Could not compile shader %d:", new Object[]{Integer.valueOf(i)});
        BLog.b(f5428b, " %s", new Object[]{GLES20.glGetShaderInfoLog(glCreateShader)});
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }
}
