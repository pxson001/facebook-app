package com.facebook.react.views.scroll;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.UIManagerModule;

/* compiled from: back_button_pressed */
public class ReactScrollViewHelper {
    public static void m19059a(ViewGroup viewGroup) {
        m19060a(viewGroup, ScrollEventType.SCROLL);
    }

    public static void m19061b(ViewGroup viewGroup) {
        m19060a(viewGroup, ScrollEventType.BEGIN_DRAG);
    }

    public static void m19062c(ViewGroup viewGroup) {
        m19060a(viewGroup, ScrollEventType.END_DRAG);
    }

    public static void m19063d(ViewGroup viewGroup) {
        m19060a(viewGroup, ScrollEventType.MOMENTUM_BEGIN);
    }

    public static void m19064e(ViewGroup viewGroup) {
        m19060a(viewGroup, ScrollEventType.MOMENTUM_END);
    }

    private static void m19060a(ViewGroup viewGroup, ScrollEventType scrollEventType) {
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null) {
            ((UIManagerModule) ((ReactContext) viewGroup.getContext()).b(UIManagerModule.class)).a.a(ScrollEvent.m19075a(viewGroup.getId(), SystemClock.b(), scrollEventType, viewGroup.getScrollX(), viewGroup.getScrollY(), childAt.getWidth(), childAt.getHeight(), viewGroup.getWidth(), viewGroup.getHeight()));
        }
    }
}
