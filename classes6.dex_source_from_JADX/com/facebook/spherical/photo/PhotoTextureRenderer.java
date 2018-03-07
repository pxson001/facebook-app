package com.facebook.spherical.photo;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.facebook.gl.GLHelpers;
import com.facebook.gl.Geometry;
import com.facebook.gl.Program;
import com.facebook.gl.ProgramFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.spherical.CubeGeometry;
import com.facebook.spherical.TextureRenderer;

@TargetApi(14)
/* compiled from: errorUrl */
public class PhotoTextureRenderer implements TextureRenderer {
    private final ProgramFactory f16231a;
    private Program f16232b;
    private Geometry f16233c;
    private int f16234d = -1;
    private int f16235e = -1;
    private int f16236f = -1;

    public PhotoTextureRenderer(Resources resources) {
        this.f16231a = new ProgramFactory(resources);
        this.f16233c = CubeGeometry.m23671a(false);
    }

    public final int mo1254a() {
        return this.f16234d;
    }

    public final void mo1256b() {
        this.f16232b = this.f16231a.a(2131165267, 2131165266);
    }

    public final void mo1255a(float[] fArr, float[] fArr2, int i, int i2) {
        if (this.f16234d != -1) {
            if (!(i == this.f16235e && i2 == this.f16236f)) {
                GLES20.glViewport(0, 0, i, i2);
                this.f16235e = i;
                this.f16236f = i2;
            }
            GLES20.glClear(16384);
            GLES20.glBindTexture(34067, this.f16234d);
            this.f16232b.a().a("sTexture", 0, 34067, this.f16234d).a("uMVPMatrix", fArr).a(this.f16233c);
        }
    }

    public final void m23782a(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            this.f16234d = iArr[0];
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(34067, this.f16234d);
            GLHelpers.a("glBindTexture GL_TEXTURE_CUBE_MAP textureId: " + this.f16234d);
            GLES20.glTexParameterf(34067, 10241, 9729.0f);
            GLES20.glTexParameterf(34067, 10240, 9729.0f);
            GLES20.glTexParameteri(34067, 10242, 33071);
            GLES20.glTexParameteri(34067, 10243, 33071);
            GLHelpers.a("glTexParameter");
            GLES20.glEnable(2884);
            GLES20.glCullFace(1028);
            GLHelpers.a("glCullFace");
            int byteCount = bitmap.getByteCount();
            int sqrt = (int) Math.sqrt((double) (byteCount / 24));
            for (int i = 0; i < 6; i++) {
                GLES20.glTexImage2D(34069 + i, 0, 6408, sqrt, sqrt, 0, 6408, 5121, Bitmaps.a(bitmap, (long) ((byteCount / 6) * i), (long) (byteCount / 6)));
                GLES20.glFinish();
                Bitmaps.b(bitmap);
            }
            GLHelpers.a("glTexImage2D textureId: " + this.f16234d);
        }
    }
}
