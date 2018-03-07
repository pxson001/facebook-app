package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: versionCode= */
class AccessibilityNodeInfoCompatJellyBean {
    AccessibilityNodeInfoCompatJellyBean() {
    }

    public static void m771a(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).addChild(view, i);
    }

    public static void m774b(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setSource(view, i);
    }

    public static boolean m773a(Object obj) {
        return ((AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    public static void m772a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
    }

    public static void m777c(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setParent(view, i);
    }

    public static boolean m776b(Object obj) {
        return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }

    public static void m775b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
    }
}
