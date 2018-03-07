package com.facebook.video.videostreaming.opengl;

import android.opengl.GLES20;
import com.facebook.video.videostreaming.opengl.Drawable2d.Prefab;
import java.nio.FloatBuffer;

/* compiled from: rtmpPublishUrl */
public class FullFrameRect {
    private final Drawable2d f5425a = new Drawable2d(Prefab.FULL_RECTANGLE);
    private Texture2dProgram f5426b;

    public FullFrameRect(Texture2dProgram texture2dProgram) {
        this.f5426b = texture2dProgram;
    }

    public final void m8116a(boolean z) {
        if (this.f5426b != null) {
            if (z) {
                Texture2dProgram texture2dProgram = this.f5426b;
                Integer.valueOf(texture2dProgram.f5432c);
                GLES20.glDeleteProgram(texture2dProgram.f5432c);
                texture2dProgram.f5432c = -1;
            }
            this.f5426b = null;
        }
    }

    public final int m8113a() {
        Texture2dProgram texture2dProgram = this.f5426b;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLUtil.m8120a("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(texture2dProgram.f5440k, i);
        GLUtil.m8120a("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLUtil.m8120a("glTexParameter");
        return i;
    }

    public final void m8115a(int i, float[] fArr, boolean z) {
        FloatBuffer c;
        Texture2dProgram texture2dProgram = this.f5426b;
        float[] fArr2 = GLUtil.f5427a;
        FloatBuffer floatBuffer = this.f5425a.f5407o;
        int d = this.f5425a.m8100d();
        int g = this.f5425a.m8103g();
        int e = this.f5425a.m8101e();
        if (z) {
            c = this.f5425a.m8099c();
        } else {
            c = this.f5425a.m8098b();
        }
        texture2dProgram.m8123a(fArr2, floatBuffer, 0, d, g, e, fArr, c, i, this.f5425a.m8102f());
    }

    public final void m8114a(int i, int i2, int i3, float f) {
        this.f5425a.m8097a(i, i2, i3, f);
    }
}
