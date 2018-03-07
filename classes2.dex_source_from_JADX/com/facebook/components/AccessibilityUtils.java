package com.facebook.components;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.view.accessibility.AccessibilityManager;

/* compiled from: getIccSerialNumber */
class AccessibilityUtils {
    AccessibilityUtils() {
    }

    public static boolean m30467a(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager.isEnabled() && AccessibilityManagerCompat.b(accessibilityManager);
    }
}
