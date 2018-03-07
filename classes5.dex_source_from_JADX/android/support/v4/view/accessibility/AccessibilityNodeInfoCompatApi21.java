package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

/* compiled from: vertex */
class AccessibilityNodeInfoCompatApi21 {
    AccessibilityNodeInfoCompatApi21() {
    }

    public static Object m733a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
    }

    public static void m734a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setError(charSequence);
    }
}
