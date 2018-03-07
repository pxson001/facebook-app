package com.facebook.videocodec.effects;

import android.graphics.RectF;
import android.opengl.Matrix;

/* compiled from: review_creator_id */
public class MatrixHelper {
    public static void m8193a(float[] fArr, int i) {
        if (i != 0) {
            Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(fArr, 0, (float) i, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
        }
    }

    public static void m8194a(float[] fArr, RectF rectF) {
        Matrix.translateM(fArr, 0, rectF.left, rectF.top, 0.0f);
        Matrix.scaleM(fArr, 0, rectF.width(), rectF.height(), 1.0f);
    }

    public static void m8195c(float[] fArr, int i) {
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.scaleM(fArr, 0, (float) i, 1.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
    }
}
