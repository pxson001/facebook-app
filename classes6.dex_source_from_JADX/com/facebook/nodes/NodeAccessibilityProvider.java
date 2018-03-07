package com.facebook.nodes;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* compiled from: throwables */
public class NodeAccessibilityProvider {
    public static int f3115i;
    public int f3116a = Integer.MIN_VALUE;
    public int f3117b = Integer.MIN_VALUE;
    public int f3118c = 0;
    public CharSequence f3119d;
    public int f3120e = 0;
    public int f3121f = 0;
    public int f3122g = 0;
    public int f3123h = 0;

    public NodeAccessibilityProvider(NodeAccessibilityProvider nodeAccessibilityProvider) {
        if (nodeAccessibilityProvider != null) {
            this.f3116a = Integer.MIN_VALUE;
            this.f3118c = nodeAccessibilityProvider.f3118c;
            this.f3119d = nodeAccessibilityProvider.f3119d;
            this.f3120e = nodeAccessibilityProvider.f3120e;
            this.f3121f = nodeAccessibilityProvider.f3121f;
            this.f3122g = nodeAccessibilityProvider.f3122g;
            this.f3123h = nodeAccessibilityProvider.f3123h;
            this.f3117b = nodeAccessibilityProvider.f3117b;
        }
    }

    public void mo201a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.c(this.f3118c == 0);
        accessibilityNodeInfoCompat.d(this.f3119d);
    }
}
