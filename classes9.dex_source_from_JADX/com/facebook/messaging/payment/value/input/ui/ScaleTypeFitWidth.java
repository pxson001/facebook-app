package com.facebook.messaging.payment.value.input.ui;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType;

/* compiled from: editShippingAddressParams */
public class ScaleTypeFitWidth extends AbstractScaleType {
    public final void m16052a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float f5 = (float) rect.left;
        float f6 = (float) rect.top;
        matrix.setScale(f3, f3);
        matrix.postTranslate((float) ((int) (f5 + 0.5f)), (float) ((int) (f6 + 0.5f)));
    }
}
