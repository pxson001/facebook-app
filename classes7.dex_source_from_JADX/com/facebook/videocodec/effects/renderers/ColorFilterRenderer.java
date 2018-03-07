package com.facebook.videocodec.effects.renderers;

import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.facebook.gl.GLHelpers;
import com.facebook.gl.Geometry;
import com.facebook.gl.Geometry.Builder;
import com.facebook.gl.Program;
import com.facebook.gl.Program.ProgramInUse;
import com.facebook.gl.ProgramFactory;
import com.facebook.gl.Texture;
import com.facebook.gl.VertexData;
import com.facebook.videocodec.effects.GLRenderer;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: device_params */
public class ColorFilterRenderer implements GLRenderer {
    private static final float[] f15798a;
    private final float[] f15799b;
    private final Geometry f15800c;
    private Program f15801d;
    private ColorFilter f15802e;
    private AtomicBoolean f15803f;

    static {
        float[] fArr = new float[16];
        f15798a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public ColorFilterRenderer() {
        this(new ColorFilter());
    }

    public ColorFilterRenderer(ColorFilter colorFilter) {
        this.f15803f = new AtomicBoolean(true);
        m19768a(colorFilter);
        this.f15799b = new float[16];
        Builder builder = new Builder(4);
        builder.a = 5;
        this.f15800c = builder.a("aPosition", new VertexData(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}, 2)).a("aTextureCoord", new VertexData(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}, 2)).a();
    }

    public final void m19768a(ColorFilter colorFilter) {
        Preconditions.checkArgument(colorFilter != null, "Must provide non null filter");
        this.f15802e = colorFilter;
        this.f15803f.set(true);
    }

    public final void m19767a(ProgramFactory programFactory) {
        this.f15801d = programFactory.a(2131165198, 2131165197);
        this.f15803f.set(true);
    }

    public final void m19765a() {
    }

    public final void m19766a(SurfaceTexture surfaceTexture, Texture texture, float[] fArr, float[] fArr2) {
        GLHelpers.a("onDrawFrame");
        surfaceTexture.getTransformMatrix(this.f15799b);
        ProgramInUse a = this.f15801d.a();
        if (this.f15803f.getAndSet(false)) {
            a.a("saturation", this.f15802e.f15793b).a("brightness", this.f15802e.f15794c).a("contrast", this.f15802e.f15795d).a("hue", this.f15802e.f15796e).a("hueColorize", this.f15802e.f15797f).a("uMVPMatrix", f15798a);
        }
        a.a("uSTMatrix", this.f15799b).a("uConstMatrix", fArr).a("sTexture", texture).a(this.f15800c);
    }
}
