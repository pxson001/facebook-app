package com.facebook.common.ui.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: shortSummary */
public class ViewPositionUtil {
    public static boolean m3886a(MotionEvent motionEvent, View view) {
        return m3885a(motionEvent, m3884a(view));
    }

    private static boolean m3885a(MotionEvent motionEvent, Rect rect) {
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    public static Rect m3884a(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getHitRect(rect);
        view.getLocationOnScreen(iArr);
        rect.offsetTo(iArr[0], iArr[1]);
        return rect;
    }

    public static boolean m3887b(MotionEvent motionEvent, View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        rect.left = (int) view.getX();
        rect.top = (int) view.getY();
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        if (view.getParent() != null && (view.getParent() instanceof View)) {
            ((View) view.getParent()).getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
        }
        return m3885a(motionEvent, rect);
    }
}
