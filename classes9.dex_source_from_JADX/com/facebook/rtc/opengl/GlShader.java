package com.facebook.rtc.opengl;

import android.opengl.GLES20;
import com.facebook.debug.log.BLog;
import java.nio.FloatBuffer;

/* compiled from: application/vnd.syncml.dm+wbxml */
public class GlShader {
    public int f19874a = GLES20.glCreateProgram();

    private static int m19593a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader == 0) {
            throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[]{0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            BLog.b("GlShader", "Could not compile shader " + i + ":" + GLES20.glGetShaderInfoLog(glCreateShader));
            throw new RuntimeException(GLES20.glGetShaderInfoLog(glCreateShader));
        }
        GlUtil.m19600a("compileShader");
        return glCreateShader;
    }

    public GlShader(String str, String str2) {
        int a = m19593a(35633, str);
        int a2 = m19593a(35632, str2);
        if (this.f19874a == 0) {
            throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
        }
        GLES20.glAttachShader(this.f19874a, a);
        GLES20.glAttachShader(this.f19874a, a2);
        GLES20.glLinkProgram(this.f19874a);
        int[] iArr = new int[]{0};
        GLES20.glGetProgramiv(this.f19874a, 35714, iArr, 0);
        if (iArr[0] != 1) {
            BLog.b("GlShader", "Could not link program: " + GLES20.glGetProgramInfoLog(this.f19874a));
            throw new RuntimeException(GLES20.glGetProgramInfoLog(this.f19874a));
        }
        GLES20.glDeleteShader(a);
        GLES20.glDeleteShader(a2);
        GlUtil.m19600a("Creating GlShader");
    }

    private int m19594b(String str) {
        if (this.f19874a == -1) {
            throw new RuntimeException("The program has been released");
        }
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f19874a, str);
        if (glGetAttribLocation >= 0) {
            return glGetAttribLocation;
        }
        throw new RuntimeException("Could not locate '" + str + "' in program");
    }

    public final void m19597a(String str, int i, FloatBuffer floatBuffer) {
        if (this.f19874a == -1) {
            throw new RuntimeException("The program has been released");
        }
        int b = m19594b(str);
        GLES20.glEnableVertexAttribArray(b);
        GLES20.glVertexAttribPointer(b, i, 5126, false, 0, floatBuffer);
        GlUtil.m19600a("setVertexAttribArray");
    }

    public final int m19595a(String str) {
        if (this.f19874a == -1) {
            throw new RuntimeException("The program has been released");
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f19874a, str);
        if (glGetUniformLocation >= 0) {
            return glGetUniformLocation;
        }
        throw new RuntimeException("Could not locate uniform '" + str + "' in program");
    }

    public final void m19596a() {
        if (this.f19874a == -1) {
            throw new RuntimeException("The program has been released");
        }
        GLES20.glUseProgram(this.f19874a);
        GlUtil.m19600a("glUseProgram");
    }
}
