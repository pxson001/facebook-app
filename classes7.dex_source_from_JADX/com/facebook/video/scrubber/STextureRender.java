package com.facebook.video.scrubber;

import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.facebook.debug.log.BLog;
import com.facebook.gl.Texture;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.effects.MatrixHelper;
import com.facebook.videocodec.policy.VideoMirroringMode;
import java.util.List;

/* compiled from: dispatchViewManagerCommand */
public class STextureRender {
    private static final String f15750a = STextureRender.class.getCanonicalName();
    public final float[] f15751b = new float[16];
    public final float[] f15752c = new float[16];
    public List<GLRenderer> f15753d;
    public Texture f15754e;

    public STextureRender(List<GLRenderer> list, int i, VideoMirroringMode videoMirroringMode, RectF rectF) {
        this.f15753d = list;
        Matrix.setIdentityM(this.f15751b, 0);
        Matrix.setIdentityM(this.f15752c, 0);
        float[] fArr = this.f15752c;
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.scaleM(fArr, 0, 1.0f, (float) -1, 1.0f);
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
        if (VERSION.SDK_INT < 21) {
            MatrixHelper.a(this.f15751b, i);
        }
        if (videoMirroringMode == VideoMirroringMode.MIRROR_HORIZONTALLY) {
            MatrixHelper.c(this.f15751b, -1);
        }
        MatrixHelper.a(this.f15751b, rectF);
    }

    public static void m19673a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            BLog.b(f15750a, "%s: glError %d", new Object[]{str, Integer.valueOf(glGetError)});
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }
}
