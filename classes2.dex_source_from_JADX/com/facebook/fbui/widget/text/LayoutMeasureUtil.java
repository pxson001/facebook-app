package com.facebook.fbui.widget.text;

import android.os.Build.VERSION;
import android.text.Layout;
import android.text.StaticLayout;

/* compiled from: graphql_feedback_id */
public class LayoutMeasureUtil {
    public static int m29743a(Layout layout) {
        int i = 0;
        if (layout != null) {
            int lineCount = layout.getLineCount();
            int i2 = 0;
            while (i2 < lineCount) {
                int max = Math.max(i, (int) layout.getLineRight(i2));
                i2++;
                i = max;
            }
        }
        return i;
    }

    public static int m29744b(Layout layout) {
        int i = 0;
        if (layout == null) {
            return 0;
        }
        if (VERSION.SDK_INT < 20 && (layout instanceof StaticLayout)) {
            i = layout.getLineAscent(layout.getLineCount() - 1);
            int lineDescent = layout.getLineDescent(layout.getLineCount() - 1);
            float spacingAdd = ((float) (lineDescent - i)) - ((((float) (lineDescent - i)) - layout.getSpacingAdd()) / layout.getSpacingMultiplier());
            i = spacingAdd >= 0.0f ? (int) (((double) spacingAdd) + 0.5d) : -((int) (((double) (-spacingAdd)) + 0.5d));
        }
        return layout.getHeight() - i;
    }
}
