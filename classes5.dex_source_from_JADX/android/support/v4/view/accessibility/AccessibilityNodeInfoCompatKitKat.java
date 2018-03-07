package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

/* compiled from: verb */
class AccessibilityNodeInfoCompatKitKat {
    AccessibilityNodeInfoCompatKitKat() {
    }

    public static void m779a(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionInfo((CollectionInfo) obj2);
    }

    public static void m781b(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionItemInfo((CollectionItemInfo) obj2);
    }

    public static void m780a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setContentInvalid(z);
    }
}
