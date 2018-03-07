package com.facebook.widget.touch;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import com.facebook.common.util.RectUtil;
import com.facebook.common.util.SizeUtil;

/* compiled from: production_prompts_use_aggressive_clipboard */
public class TouchDelegateUtils {
    public static TouchDelegate m13819a(View view, int i) {
        return m13822a(view, view.getParent(), i);
    }

    public static TouchDelegate m13823a(View view, ViewParent viewParent, int i, int i2, int i3, int i4) {
        int a;
        int a2;
        int a3;
        int a4;
        Rect rect = new Rect();
        RectUtil.m13824a(view, viewParent, rect);
        boolean z = viewParent instanceof View;
        if (i != -1) {
            a = SizeUtil.m19191a(view.getContext(), (float) i);
        } else if (z) {
            a = view.getLeft();
        } else {
            a = 0;
        }
        if (i2 != -1) {
            a2 = SizeUtil.m19191a(view.getContext(), (float) i2);
        } else if (z) {
            a2 = view.getTop();
        } else {
            a2 = 0;
        }
        if (i3 != -1) {
            a3 = SizeUtil.m19191a(view.getContext(), (float) i3);
        } else if (z) {
            a3 = ((View) viewParent).getWidth() - view.getRight();
        } else {
            a3 = 0;
        }
        if (i4 != -1) {
            a4 = SizeUtil.m19191a(view.getContext(), (float) i4);
        } else if (z) {
            a4 = ((View) viewParent).getHeight() - view.getBottom();
        } else {
            a4 = 0;
        }
        rect.left -= a;
        rect.top -= a2;
        rect.right += a3;
        rect.bottom = a4 + rect.bottom;
        return new TouchDelegate(rect, view);
    }

    public static TouchDelegate m13822a(View view, ViewParent viewParent, int i) {
        return m13823a(view, viewParent, i, i, i, i);
    }

    public static TouchDelegate m13820a(View view, int i, int i2) {
        ViewParent parent = view.getParent();
        Rect rect = new Rect();
        RectUtil.m13824a(view, parent, rect);
        rect.top = i;
        rect.bottom = i2;
        return new TouchDelegate(rect, view);
    }

    public static TouchDelegate m13821a(View view, int i, int i2, int i3) {
        ViewParent parent = view.getParent();
        Rect rect = new Rect();
        RectUtil.m13824a(view, parent, rect);
        int a = SizeUtil.m19191a(view.getContext(), (float) i3);
        rect.left -= a;
        rect.right = a + rect.right;
        rect.top = i;
        rect.bottom = i2;
        return new TouchDelegate(rect, view);
    }
}
