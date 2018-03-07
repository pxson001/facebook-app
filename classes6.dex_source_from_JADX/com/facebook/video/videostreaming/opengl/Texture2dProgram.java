package com.facebook.video.videostreaming.opengl;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* compiled from: route_to_google_reason */
public class Texture2dProgram {
    private static final String f5430a = Texture2dProgram.class.getName();
    private ProgramType f5431b;
    public int f5432c;
    private int f5433d;
    private int f5434e;
    private int f5435f;
    private int f5436g;
    private int f5437h;
    private int f5438i;
    private int f5439j;
    public int f5440k;
    private float[] f5441l = new float[9];
    public float[] f5442m;
    private float f5443n;

    /* compiled from: route_to_google_reason */
    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT
    }

    public Texture2dProgram(ProgramType programType) {
        this.f5431b = programType;
        switch (programType) {
            case TEXTURE_2D:
                this.f5440k = 3553;
                this.f5432c = GLUtil.m8117a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
                break;
            case TEXTURE_EXT:
                this.f5440k = 36197;
                this.f5432c = GLUtil.m8117a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
                break;
            case TEXTURE_EXT_BW:
                this.f5440k = 36197;
                this.f5432c = GLUtil.m8117a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n");
                break;
            case TEXTURE_EXT_FILT:
                this.f5440k = 36197;
                this.f5432c = GLUtil.m8117a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n");
                break;
            default:
                throw new RuntimeException("Unhandled type " + programType);
        }
        if (this.f5432c == 0) {
            throw new RuntimeException("Unable to create program");
        }
        Integer.valueOf(this.f5432c);
        programType.name();
        this.f5438i = GLES20.glGetAttribLocation(this.f5432c, "aPosition");
        GLUtil.m8119a(this.f5438i, "aPosition");
        this.f5439j = GLES20.glGetAttribLocation(this.f5432c, "aTextureCoord");
        GLUtil.m8119a(this.f5439j, "aTextureCoord");
        this.f5433d = GLES20.glGetUniformLocation(this.f5432c, "uMVPMatrix");
        GLUtil.m8119a(this.f5433d, "uMVPMatrix");
        this.f5434e = GLES20.glGetUniformLocation(this.f5432c, "uTexMatrix");
        GLUtil.m8119a(this.f5434e, "uTexMatrix");
        this.f5435f = GLES20.glGetUniformLocation(this.f5432c, "uKernel");
        if (this.f5435f < 0) {
            this.f5435f = -1;
            this.f5436g = -1;
            this.f5437h = -1;
            return;
        }
        this.f5436g = GLES20.glGetUniformLocation(this.f5432c, "uTexOffset");
        GLUtil.m8119a(this.f5436g, "uTexOffset");
        this.f5437h = GLES20.glGetUniformLocation(this.f5432c, "uColorAdjust");
        GLUtil.m8119a(this.f5437h, "uColorAdjust");
        m8122a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
        float f = 1.0f / ((float) 256);
        float f2 = 1.0f / ((float) 256);
        this.f5442m = new float[]{-f, -f2, 0.0f, -f2, f, -f2, -f, 0.0f, 0.0f, 0.0f, f, 0.0f, -f, f2, 0.0f, f2, f, f2};
    }

    private void m8122a(float[] fArr, float f) {
        if (fArr.length != 9) {
            throw new IllegalArgumentException("Kernel size is " + fArr.length + " vs. 9");
        }
        System.arraycopy(fArr, 0, this.f5441l, 0, 9);
        this.f5443n = f;
    }

    public final void m8123a(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        GLUtil.m8120a("draw start");
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.f5432c);
        GLUtil.m8120a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f5440k, i5);
        GLES20.glUniformMatrix4fv(this.f5433d, 1, false, fArr, 0);
        GLUtil.m8120a("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.f5434e, 1, false, fArr2, 0);
        GLUtil.m8120a("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f5438i);
        GLUtil.m8120a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f5438i, i3, 5126, false, i4, floatBuffer);
        GLUtil.m8120a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f5439j);
        GLUtil.m8120a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f5439j, 2, 5126, false, i6, floatBuffer2);
        GLUtil.m8120a("glVertexAttribPointer");
        if (this.f5435f >= 0) {
            GLES20.glUniform1fv(this.f5435f, 9, this.f5441l, 0);
            GLES20.glUniform2fv(this.f5436g, 9, this.f5442m, 0);
            GLES20.glUniform1f(this.f5437h, this.f5443n);
        }
        GLES20.glDrawArrays(5, i, i2);
        GLUtil.m8120a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f5438i);
        GLES20.glDisableVertexAttribArray(this.f5439j);
        GLES20.glBindTexture(this.f5440k, 0);
        GLES20.glUseProgram(0);
    }
}
