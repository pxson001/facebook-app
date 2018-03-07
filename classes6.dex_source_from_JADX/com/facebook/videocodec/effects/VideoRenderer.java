package com.facebook.videocodec.effects;

import android.graphics.SurfaceTexture;
import com.facebook.gl.GLHelpers;
import com.facebook.gl.Geometry;
import com.facebook.gl.Geometry.Builder;
import com.facebook.gl.Program;
import com.facebook.gl.ProgramFactory;
import com.facebook.gl.Texture;
import com.facebook.gl.VertexData;

/* compiled from: return_type */
public class VideoRenderer implements GLRenderer {
    private Program f5527a;
    private Geometry f5528b;
    private final float[] f5529c = new float[16];

    public VideoRenderer() {
        Builder builder = new Builder(4);
        builder.a = 5;
        this.f5528b = builder.a("aPosition", new VertexData(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}, 2)).a("aTextureCoord", new VertexData(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}, 2)).a();
    }

    public final void mo368a(ProgramFactory programFactory) {
        this.f5527a = programFactory.a(2131165340, 2131165334);
    }

    public final void mo366a() {
    }

    public final void mo367a(SurfaceTexture surfaceTexture, Texture texture, float[] fArr, float[] fArr2) {
        GLHelpers.a("onDrawFrame");
        surfaceTexture.getTransformMatrix(this.f5529c);
        this.f5527a.a().a("uSTMatrix", this.f5529c).a("uConstMatrix", fArr).a("uSceneMatrix", fArr2).a("sTexture", texture).a(this.f5528b);
    }
}
