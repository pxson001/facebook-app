package com.facebook.videocodec.render;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.facebook.gl.GLHelpers;
import com.facebook.gl.Geometry;
import com.facebook.gl.Geometry.Builder;
import com.facebook.gl.Program;
import com.facebook.gl.ProgramFactory;
import com.facebook.gl.Texture;
import com.facebook.gl.VertexData;
import com.facebook.videocodec.base.VideoCodecOpenGlColorFormat;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.facebook.videocodec.policy.VideoTranscodeParams;
import com.google.common.base.Preconditions;
import java.util.List;

@TargetApi(14)
/* compiled from: results_fetched */
public class TranscodeTextureRenderer {
    public final ProgramFactory f5622a;
    public final Geometry f5623b;
    public Program f5624c;
    private final VideoCodecOpenGlColorFormat f5625d;
    public final float[] f5626e;
    public final float[] f5627f;
    public final float[] f5628g;
    public int f5629h;
    public final List<GLRenderer> f5630i;
    public Texture f5631j;

    public TranscodeTextureRenderer(ProgramFactory programFactory, VideoTranscodeParams videoTranscodeParams, VideoCodecOpenGlColorFormat videoCodecOpenGlColorFormat) {
        Builder builder = new Builder(4);
        builder.a = 5;
        this.f5623b = builder.a("aPosition", new VertexData(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}, 2)).a("aTextureCoord", new VertexData(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}, 2)).a();
        this.f5626e = new float[16];
        this.f5627f = new float[16];
        this.f5628g = new float[16];
        this.f5629h = -12345;
        this.f5625d = videoCodecOpenGlColorFormat;
        this.f5622a = programFactory;
        this.f5630i = videoTranscodeParams.f5587n;
        Matrix.setIdentityM(this.f5626e, 0);
        Matrix.setIdentityM(this.f5627f, 0);
        Matrix.setIdentityM(this.f5628g, 0);
        if (VERSION.SDK_INT < 21) {
            Matrix.translateM(this.f5627f, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(this.f5627f, 0, (float) videoTranscodeParams.f5576c, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(this.f5627f, 0, -0.5f, -0.5f, 0.0f);
        }
        Matrix.translateM(this.f5627f, 0, videoTranscodeParams.f5581h.left, videoTranscodeParams.f5581h.top, 0.0f);
        Matrix.scaleM(this.f5627f, 0, videoTranscodeParams.f5581h.width(), videoTranscodeParams.f5581h.height(), 1.0f);
        Matrix.translateM(this.f5627f, 0, 0.5f, 0.5f, 0.0f);
        if (videoTranscodeParams.f5582i == VideoMirroringMode.MIRROR_HORIZONTALLY) {
            Matrix.scaleM(this.f5627f, 0, -1.0f, 1.0f, 1.0f);
        }
        Matrix.rotateM(this.f5627f, 0, (float) videoTranscodeParams.f5579f, 0.0f, 0.0f, -1.0f);
        Matrix.translateM(this.f5627f, 0, -0.5f, -0.5f, 0.0f);
    }

    public final int m8261a() {
        if (this.f5630i == null) {
            return this.f5629h;
        }
        Preconditions.checkNotNull(this.f5631j);
        return this.f5631j.b;
    }

    public final void m8262b() {
        GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        if (this.f5625d == VideoCodecOpenGlColorFormat.RGBA) {
            this.f5624c = this.f5622a.a(2131165339, 2131165338);
        } else {
            this.f5624c = this.f5622a.a(2131165339, 2131165337);
        }
        if (this.f5630i != null) {
            Texture.Builder builder = new Texture.Builder();
            builder.a = 36197;
            this.f5631j = builder.a(10241, 9729).a(10240, 9729).a(10242, 33071).a(10243, 33071).a();
            for (GLRenderer a : this.f5630i) {
                a.mo368a(this.f5622a);
            }
            GLHelpers.a("video texture");
            return;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f5629h = iArr[0];
        GLES20.glBindTexture(36197, this.f5629h);
        GLHelpers.a("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLHelpers.a("glTexParameter");
    }
}
