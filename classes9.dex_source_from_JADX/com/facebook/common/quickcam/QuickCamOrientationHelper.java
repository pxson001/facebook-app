package com.facebook.common.quickcam;

import android.graphics.Matrix;
import com.google.common.base.Preconditions;

/* compiled from: provider_display_name */
public class QuickCamOrientationHelper {
    public static void m6411a(int i, int i2, int i3, Matrix matrix) {
        boolean z = true;
        if (!(i == 0 || i == 1 || i == 2 || i == 3)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        switch (i) {
            case 1:
                matrix.postRotate(90.0f);
                matrix.postTranslate((float) i3, 0.0f);
                return;
            case 2:
                matrix.postRotate(180.0f);
                matrix.postTranslate((float) i2, (float) i3);
                return;
            case 3:
                matrix.postRotate(270.0f);
                matrix.postTranslate(0.0f, (float) i2);
                return;
            default:
                return;
        }
    }
}
