package com.facebook.common.quickcam;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import com.facebook.common.ui.util.BetterRotationManager;
import com.facebook.inject.InjectorLike;
import com.facebook.libyuv.YUVColorConverter;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: provider_name */
public class QuickCamBitmapUtil {
    private final BetterRotationManager f6049a;
    private final QuickCamOrientationHelper f6050b;
    private final YUVColorConverter f6051c;

    public static QuickCamBitmapUtil m6393b(InjectorLike injectorLike) {
        return new QuickCamBitmapUtil(BetterRotationManager.b(injectorLike), new QuickCamOrientationHelper(), YUVColorConverter.a(injectorLike));
    }

    public static QuickCamBitmapUtil m6392a(InjectorLike injectorLike) {
        return m6393b(injectorLike);
    }

    @Inject
    public QuickCamBitmapUtil(BetterRotationManager betterRotationManager, QuickCamOrientationHelper quickCamOrientationHelper, YUVColorConverter yUVColorConverter) {
        this.f6049a = betterRotationManager;
        this.f6050b = quickCamOrientationHelper;
        this.f6051c = yUVColorConverter;
    }

    public final Matrix m6394a(Bitmap bitmap, Bitmap bitmap2, int i) {
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int width2 = (bitmap.getWidth() - width) / 2;
        int height2 = (bitmap.getHeight() - height) / 2;
        int i2 = width2 + width;
        int i3 = height2 + height;
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF((float) width2, (float) height2, (float) i2, (float) i3), new RectF(0.0f, 0.0f, (float) width, (float) height), ScaleToFit.FILL);
        if (i == -1) {
            return matrix;
        }
        switch (m6391a(this.f6049a.a(), i)) {
            case 1:
                width = 90;
                break;
            case 2:
                width = 180;
                break;
            case 3:
                width = 270;
                break;
            default:
                width = 0;
                break;
        }
        matrix.postRotate((float) (-width), (float) (bitmap2.getWidth() / 2), (float) (bitmap2.getHeight() / 2));
        return matrix;
    }

    public final Matrix m6395a(Bitmap bitmap, Bitmap bitmap2, int i, boolean z) {
        int height;
        int width;
        int a = m6391a(i, 1);
        Matrix matrix = new Matrix();
        if (a == 1 || a == 3) {
            height = bitmap.getHeight();
            width = bitmap.getWidth();
        } else {
            height = bitmap.getWidth();
            width = bitmap.getHeight();
        }
        if (z) {
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            boolean z2 = true;
            if (!(a == 0 || a == 1 || a == 2 || a == 3)) {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
            switch (a) {
                case 1:
                    matrix.postRotate(-90.0f);
                    matrix.postTranslate(0.0f, (float) width2);
                    break;
                case 2:
                    matrix.postRotate(180.0f);
                    matrix.postTranslate((float) width2, (float) height2);
                    break;
                case 3:
                    matrix.postRotate(270.0f);
                    matrix.postTranslate((float) height2, 0.0f);
                    break;
            }
            matrix.postScale(-1.0f, 1.0f);
            matrix.postTranslate((float) height, 0.0f);
        } else {
            QuickCamOrientationHelper.m6411a(a, bitmap.getWidth(), bitmap.getHeight(), matrix);
        }
        matrix.postScale(((float) bitmap2.getWidth()) / ((float) height), ((float) bitmap2.getHeight()) / ((float) width));
        return matrix;
    }

    public static int m6391a(int i, int i2) {
        return ((i2 - i) + 4) % 4;
    }

    public final boolean m6396a(int i) {
        int a = this.f6049a.a();
        if (i == 0 || i == 2) {
            if (a == 1 || a == 3) {
                return true;
            }
            return false;
        } else if (a == 0 || a == 2) {
            return true;
        } else {
            return false;
        }
    }
}
