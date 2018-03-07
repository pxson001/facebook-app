package com.facebook.facecast;

import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.gl.ProgramFactory;
import com.facebook.gl.Texture;
import com.facebook.gl.Texture.Builder;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.effects.MatrixHelper;
import com.facebook.videocodec.effects.renderers.ColorFilterRenderer;
import com.facebook.videocodec.effects.renderers.DoodleRenderer;
import com.facebook.videocodec.effects.renderers.OverlayRenderer;
import com.facebook.videocodec.effects.renderers.OverlayRendererProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: bundle_config */
public class FacecastGLRendererManager {
    private static final CallerContext f18012a = CallerContext.a(FacecastGLRendererManager.class);
    public final ProgramFactory f18013b;
    private float[] f18014c;
    private float[] f18015d;
    private float[] f18016e;
    public List<GLRenderer> f18017f = new ArrayList();
    private Texture f18018g;
    public ColorFilterRenderer f18019h = new ColorFilterRenderer();
    public DoodleRenderer f18020i;
    public OverlayRenderer f18021j = this.f18022k.m19790a(null, f18012a);
    private OverlayRendererProvider f18022k;

    @Inject
    public FacecastGLRendererManager(ProgramFactory programFactory, FacecastUtil facecastUtil, OverlayRendererProvider overlayRendererProvider) {
        this.f18013b = programFactory;
        this.f18022k = overlayRendererProvider;
        this.f18017f.add(this.f18019h);
        this.f18017f.add(this.f18021j);
        if (facecastUtil.f2822a.a(591, false)) {
            this.f18020i = new DoodleRenderer();
            this.f18017f.add(this.f18020i);
        }
        this.f18014c = new float[16];
        Matrix.setIdentityM(this.f18014c, 0);
        this.f18015d = new float[16];
        Matrix.setIdentityM(this.f18015d, 0);
        this.f18016e = new float[16];
        Matrix.setIdentityM(this.f18016e, 0);
    }

    public final void m21868b() {
        for (GLRenderer a : this.f18017f) {
            a.a(this.f18013b);
        }
    }

    public final void m21864a(int i, int i2) {
        Iterator it = this.f18017f.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final void m21866a(SurfaceTexture surfaceTexture, boolean z) {
        for (GLRenderer a : this.f18017f) {
            m21867a(surfaceTexture, z, a);
        }
    }

    public final void m21867a(SurfaceTexture surfaceTexture, boolean z, GLRenderer gLRenderer) {
        if (this.f18018g != null) {
            Object obj = (z && this.f18020i == null) ? 1 : null;
            gLRenderer.a(surfaceTexture, this.f18018g, obj != null ? this.f18015d : this.f18014c, this.f18016e);
        }
    }

    public final void m21865a(int i, int i2, int i3, float f) {
        Matrix.setIdentityM(this.f18014c, 0);
        Matrix.setIdentityM(this.f18015d, 0);
        float max = (float) Math.max(i, i2);
        float min = (float) Math.min(i, i2);
        if (f >= 1.0f) {
            f = 1.0f / f;
        }
        max = Math.abs(f - (min / max)) * 0.5f;
        RectF rectF = new RectF(0.0f, max, 1.0f, 1.0f - max);
        MatrixHelper.a(this.f18014c, rectF);
        MatrixHelper.c(this.f18015d, -1);
        MatrixHelper.a(this.f18015d, rectF);
        if (i3 == 1 || i3 == 3) {
            MatrixHelper.a(this.f18014c, 360 - (i3 * 90));
            MatrixHelper.a(this.f18015d, i3 * 90);
        }
    }

    public final int m21869d() {
        Builder builder = new Builder();
        builder.a = 36197;
        this.f18018g = builder.a(10241, 9729).a(10240, 9729).a(10242, 33071).a(10243, 33071).a();
        return this.f18018g.b;
    }
}
