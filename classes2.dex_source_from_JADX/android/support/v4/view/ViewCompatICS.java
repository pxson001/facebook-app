package android.support.v4.view;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: rtc_offerack_engine_send */
class ViewCompatICS {
    ViewCompatICS() {
    }

    public static void m11167a(View view, @Nullable Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static void m11168b(View view, Object obj) {
        view.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) obj);
    }
}
