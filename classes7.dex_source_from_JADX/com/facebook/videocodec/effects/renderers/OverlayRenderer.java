package com.facebook.videocodec.effects.renderers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.opengl.GLES20;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.references.CloseableReference;
import com.facebook.debug.log.BLog;
import com.facebook.gl.GLHelpers;
import com.facebook.gl.Geometry;
import com.facebook.gl.Geometry.Builder;
import com.facebook.gl.Program;
import com.facebook.gl.ProgramFactory;
import com.facebook.gl.Texture;
import com.facebook.gl.VertexData;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.videocodec.effects.GLRenderer;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;

/* compiled from: destroyItem fragment state not valid at position=%d and size=%d */
public class OverlayRenderer implements GLRenderer {
    private Uri f15823a;
    private Program f15824b;
    private ImagePipeline f15825c;
    private Geometry f15826d;
    private Texture f15827e;
    private CloseableReference<CloseableImage> f15828f;
    private CallerContext f15829g;

    @Inject
    public OverlayRenderer(ImagePipeline imagePipeline, @Assisted Uri uri, @Assisted CallerContext callerContext) {
        this.f15825c = imagePipeline;
        this.f15823a = uri;
        this.f15829g = callerContext;
        Builder builder = new Builder(4);
        builder.a = 5;
        this.f15826d = builder.a("aPosition", new VertexData(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}, 2)).a("aTextureCoord", new VertexData(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f}, 2)).a();
    }

    public final void m19789a(ProgramFactory programFactory) {
        this.f15824b = programFactory.a(2131165265, 2131165264);
        m19784b();
    }

    private void m19784b() {
        Throwable e;
        if (this.f15827e == null && this.f15823a != null) {
            new Options().inScaled = false;
            try {
                this.f15828f = (CloseableReference) FutureDetour.a(DataSourceToFutureAdapter.a(this.f15825c.c(ImageRequestBuilder.a(this.f15823a).m(), this.f15829g)), -1969372038);
                CloseableImage closeableImage = (CloseableImage) this.f15828f.a();
                if (closeableImage instanceof CloseableBitmap) {
                    Bitmap a = ((CloseableBitmap) closeableImage).a();
                    GLES20.glEnable(3042);
                    GLHelpers.a("GL_BLEND");
                    GLES20.glBlendFunc(770, 771);
                    GLHelpers.a("blendFunc");
                    this.f15827e = new Texture.Builder().a(10241, 9729).a(10240, 9729).a(10242, 33071).a(10243, 33071).a(a).a();
                    return;
                }
                BLog.b("OverlayRenderer", "Retrieved overlay image was not a bitmap: %s", new Object[]{closeableImage.getClass().getName()});
                this.f15828f.close();
            } catch (ExecutionException e2) {
                e = e2;
                BLog.b("OverlayRenderer", "Failed to retrieve overlay image", e);
            } catch (InterruptedException e3) {
                e = e3;
                BLog.b("OverlayRenderer", "Failed to retrieve overlay image", e);
            }
        }
    }

    public final void m19788a(Uri uri) {
        m19785c();
        this.f15823a = uri;
    }

    public final void m19786a() {
        m19785c();
    }

    private void m19785c() {
        if (this.f15827e != null) {
            GLES20.glDeleteTextures(1, new int[]{this.f15827e.b}, 0);
            this.f15827e = null;
        }
        if (this.f15828f != null) {
            this.f15828f.close();
            this.f15828f = null;
        }
    }

    public final void m19787a(SurfaceTexture surfaceTexture, Texture texture, float[] fArr, float[] fArr2) {
        if (this.f15827e == null && this.f15823a != null) {
            m19784b();
        }
        if (this.f15827e != null) {
            this.f15824b.a().a("uSceneMatrix", fArr2).a("sOverlay", this.f15827e).a(this.f15826d);
            if (this.f15828f != null) {
                this.f15828f.close();
                this.f15828f = null;
            }
        }
    }
}
