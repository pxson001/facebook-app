package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: version_name */
class AccessibilityNodeInfoCompatIcs {
    AccessibilityNodeInfoCompatIcs() {
    }

    public static Object m735a(Object obj) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
    }

    public static void m736a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public static void m738a(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).addChild(view);
    }

    public static int m741b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public static void m737a(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void m742b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static CharSequence m746c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public static CharSequence m751d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static CharSequence m755e(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public static CharSequence m757f(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public static boolean m760g(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean m761h(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean m762i(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean m763j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean m764k(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean m765l(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean m766m(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean m767n(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean m768o(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean m769p(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public static void m747c(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
    }

    public static void m752d(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
    }

    public static void m739a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void m740a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setClickable(z);
    }

    public static void m744b(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
    }

    public static void m745b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setEnabled(z);
    }

    public static void m750c(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocusable(z);
    }

    public static void m754d(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocused(z);
    }

    public static void m756e(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setLongClickable(z);
    }

    public static void m749c(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
    }

    public static void m743b(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setParent(view);
    }

    public static void m758f(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }

    public static void m759g(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setSelected(z);
    }

    public static void m748c(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setSource(view);
    }

    public static void m753d(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setText(charSequence);
    }

    public static void m770q(Object obj) {
        ((AccessibilityNodeInfo) obj).recycle();
    }
}
