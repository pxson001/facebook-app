package com.facebook.photos.creativeediting.utilities;

import android.text.DynamicLayout;
import android.text.TextPaint;

/* compiled from: immediate_retry_count */
public class TextPaintUtilities {
    public static int m20257a(TextPaint textPaint, DynamicLayout dynamicLayout) {
        CharSequence text = dynamicLayout.getText();
        float f = 0.0f;
        for (int i = 0; i < dynamicLayout.getLineCount(); i++) {
            String charSequence = text.subSequence(dynamicLayout.getLineStart(i), dynamicLayout.getLineEnd(i)).toString();
            float[] fArr = new float[charSequence.length()];
            textPaint.getTextWidths(charSequence, fArr);
            float f2 = 0.0f;
            for (float f3 : fArr) {
                f2 += f3;
            }
            float f4 = f2;
            if (f < f4) {
                f = f4;
            }
        }
        return (int) (1.0f + f);
    }
}
