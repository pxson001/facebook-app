package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* compiled from: valueExtractFormatter */
class AccessibilityRecordCompatJellyBean {
    AccessibilityRecordCompatJellyBean() {
    }

    public static void m836a(Object obj, View view, int i) {
        ((AccessibilityRecord) obj).setSource(view, i);
    }
}
