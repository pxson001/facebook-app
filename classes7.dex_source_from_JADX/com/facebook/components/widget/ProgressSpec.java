package com.facebook.components.widget;

import android.widget.ProgressBar;
import com.facebook.components.ComponentContext;
import com.facebook.components.Size;
import com.facebook.components.annotations.MountSpec;
import com.facebook.components.utils.MeasureUtils;
import com.facebook.components.utils.MeasureUtils$MeasureException;

@MountSpec
/* compiled from: transliteration_version */
public class ProgressSpec {
    protected static void m1353a(int i, int i2, Size size) {
        try {
            MeasureUtils.a(i, i2, size);
        } catch (MeasureUtils$MeasureException e) {
            size.a = 50;
            size.b = 50;
        }
    }

    protected static ProgressBar m1352a(ComponentContext componentContext, ProgressBar progressBar) {
        if (progressBar == null) {
            return new ProgressBar(componentContext);
        }
        return progressBar;
    }
}
