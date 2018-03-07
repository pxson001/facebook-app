package com.facebook.spherical.video;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.opengl.GLES20;
import com.facebook.gl.GLHelpers;
import com.facebook.gl.Geometry;
import com.facebook.gl.Program;
import com.facebook.gl.ProgramFactory;
import com.facebook.spherical.CubeGeometry;
import com.facebook.spherical.TextureRenderer;

@TargetApi(14)
/* compiled from: entity_category_search */
public class VideoTextureRenderer implements TextureRenderer {
    private final ProgramFactory f16404a;
    private Program f16405b;
    private Geometry f16406c;
    private int f16407d = -1;
    private int f16408e = -1;
    private int f16409f = -1;

    public VideoTextureRenderer(Resources resources) {
        this.f16404a = new ProgramFactory(resources);
        this.f16406c = CubeGeometry.m23671a(true);
    }

    public final int mo1254a() {
        return this.f16407d;
    }

    public final void mo1256b() {
        this.f16405b = this.f16404a.a(2131165336, 2131165335);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f16407d = iArr[0];
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f16407d);
        GLHelpers.a("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLHelpers.a("glTexParameter");
        GLES20.glEnable(2884);
        GLES20.glCullFace(1028);
        GLHelpers.a("glCullFace");
    }

    public final void mo1255a(float[] fArr, float[] fArr2, int i, int i2) {
        if (!(i == this.f16408e && i2 == this.f16409f)) {
            GLES20.glViewport(0, 0, i, i2);
            this.f16408e = i;
            this.f16409f = i2;
        }
        GLES20.glClear(16384);
        this.f16405b.a().a("uMVPMatrix", fArr).a("uSTMatrix", fArr2).a(this.f16406c);
    }
}
