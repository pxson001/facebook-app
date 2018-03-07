package com.facebook.rtc.opengl;

import android.opengl.GLES20;
import com.facebook.debug.log.BLog;
import java.nio.FloatBuffer;

/* compiled from: application/vnd.oma.dd2+xml */
public class Texture2dProgram {
    private static final Class<?> f19904a = Texture2dProgram.class;
    public int f19905b;
    private int f19906c;
    private int f19907d;
    private int f19908e;
    private int f19909f;
    private int f19910g;
    public int f19911h = 36197;

    public Texture2dProgram() {
        String str = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nvoid main() {\n    vec2 vTextRelToCenter;\n    vec2 vTextRelToOffCenter;\n    vTextRelToCenter[0] = scale*(vTextureCoord[0] - 0.5);\n    vTextRelToCenter[1] = (vTextureCoord[1] - 0.5);\n    vTextRelToOffCenter[0] = vTextRelToCenter[0] + 0.02;\n    vTextRelToOffCenter[1] = vTextRelToCenter[1];\n    float radius = length(vTextRelToCenter);\n    float shadowRadius = length(vTextRelToOffCenter);\n    if (radius > 0.45 && shadowRadius < 0.48) {\n       float alpha = ((0.48 - shadowRadius)/ 0.2) * 1.0;\n      gl_FragColor = vec4(0.0,0.0,0.0,alpha);\n    } else if (radius > 0.45) {\n      gl_FragColor = vec4(0.0,0.0,0.0,0.0);\n    } else {\n      gl_FragColor = texture2D(sTexture, vTextureCoord);\n    }}\n";
        int i = 0;
        int b = GlUtil.m19601b(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n   gl_Position = uMVPMatrix * aPosition;\n   vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n");
        if (b != 0) {
            int b2 = GlUtil.m19601b(35632, str);
            if (b2 != 0) {
                int glCreateProgram = GLES20.glCreateProgram();
                GlUtil.m19600a("glCreateProgram");
                if (glCreateProgram == 0) {
                    BLog.b(GlUtil.f19876b, "Could not create program");
                }
                GLES20.glAttachShader(glCreateProgram, b);
                GlUtil.m19600a("glAttachShader");
                GLES20.glAttachShader(glCreateProgram, b2);
                GlUtil.m19600a("glAttachShader");
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    BLog.b(GlUtil.f19876b, "Could not link program: ");
                    BLog.b(GlUtil.f19876b, GLES20.glGetProgramInfoLog(glCreateProgram));
                    GLES20.glDeleteProgram(glCreateProgram);
                } else {
                    i = glCreateProgram;
                }
            }
        }
        this.f19905b = i;
        if (this.f19905b == 0) {
            throw new RuntimeException("Unable to create program");
        }
        this.f19908e = GLES20.glGetAttribLocation(this.f19905b, "aPosition");
        GlUtil.m19599a(this.f19908e, "aPosition");
        this.f19910g = GLES20.glGetAttribLocation(this.f19905b, "aTextureCoord");
        GlUtil.m19599a(this.f19910g, "aTextureCoord");
        this.f19906c = GLES20.glGetUniformLocation(this.f19905b, "uMVPMatrix");
        GlUtil.m19599a(this.f19906c, "uMVPMatrix");
        this.f19907d = GLES20.glGetUniformLocation(this.f19905b, "uTexMatrix");
        GlUtil.m19599a(this.f19907d, "uTexMatrix");
        this.f19909f = GLES20.glGetUniformLocation(this.f19905b, "scale");
        GlUtil.m19599a(this.f19909f, "scale");
    }

    public final void m19617a(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6, float f) {
        GlUtil.m19600a("draw start");
        GLES20.glUseProgram(this.f19905b);
        GlUtil.m19600a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f19911h, i5);
        GLES20.glUniformMatrix4fv(this.f19906c, 1, false, fArr, 0);
        GlUtil.m19600a("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.f19907d, 1, false, fArr2, 0);
        GlUtil.m19600a("glUniformMatrix4fv");
        GLES20.glUniform1f(this.f19909f, f);
        GlUtil.m19600a("glUniform1f");
        GLES20.glEnableVertexAttribArray(this.f19908e);
        GlUtil.m19600a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f19908e, i3, 5126, false, i4, floatBuffer);
        GlUtil.m19600a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f19910g);
        GlUtil.m19600a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f19910g, 2, 5126, false, i6, floatBuffer2);
        GlUtil.m19600a("glVertexAttribPointer");
        GLES20.glDrawArrays(5, i, i2);
        GlUtil.m19600a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f19908e);
        GLES20.glDisableVertexAttribArray(this.f19910g);
        GLES20.glBindTexture(this.f19911h, 0);
        GLES20.glUseProgram(0);
    }
}
