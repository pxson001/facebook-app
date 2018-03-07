package android.support.v4.view;

import android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: video_profile */
class AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl$1 implements AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge {
    final /* synthetic */ AccessibilityDelegateCompat f274a;
    final /* synthetic */ AccessibilityDelegateIcsImpl f275b;

    AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl$1(AccessibilityDelegateIcsImpl accessibilityDelegateIcsImpl, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        this.f275b = accessibilityDelegateIcsImpl;
        this.f274a = accessibilityDelegateCompat;
    }

    public final boolean mo47a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f274a.b(view, accessibilityEvent);
    }

    public final void mo49b(View view, AccessibilityEvent accessibilityEvent) {
        this.f274a.d(view, accessibilityEvent);
    }

    public final void mo46a(View view, Object obj) {
        this.f274a.a(view, new AccessibilityNodeInfoCompat(obj));
    }

    public final void mo50c(View view, AccessibilityEvent accessibilityEvent) {
        this.f274a.c(view, accessibilityEvent);
    }

    public final boolean mo48a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f274a.a(viewGroup, view, accessibilityEvent);
    }

    public final void mo45a(View view, int i) {
        AccessibilityDelegateCompat.a(view, i);
    }

    public final void mo51d(View view, AccessibilityEvent accessibilityEvent) {
        AccessibilityDelegateCompat.a(view, accessibilityEvent);
    }
}
