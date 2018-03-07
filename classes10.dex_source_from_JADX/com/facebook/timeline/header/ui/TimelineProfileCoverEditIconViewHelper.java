package com.facebook.timeline.header.ui;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.ViewStub;

/* compiled from: fetchNotificationSettings */
public class TimelineProfileCoverEditIconViewHelper {
    public static int m12055a(Resources resources) {
        String string = resources.getString(2131234991);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131429898);
        Paint paint = new Paint();
        paint.setTextSize((float) dimensionPixelSize);
        paint.setTypeface(Typeface.DEFAULT);
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return rect.width();
    }

    public static void m12056a(ViewStub viewStub, ViewStub viewStub2) {
        viewStub.setLayoutResource(2130906431);
        viewStub2.setLayoutResource(2130906431);
    }

    public static void m12057b(ViewStub viewStub, ViewStub viewStub2) {
        viewStub.setLayoutResource(2130906430);
        viewStub2.setLayoutResource(2130906430);
    }
}
