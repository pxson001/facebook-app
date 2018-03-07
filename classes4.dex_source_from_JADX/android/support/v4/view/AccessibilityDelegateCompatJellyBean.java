package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;

/* compiled from: upload_step */
class AccessibilityDelegateCompatJellyBean {
    AccessibilityDelegateCompatJellyBean() {
    }

    public static Object m757a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m758a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
