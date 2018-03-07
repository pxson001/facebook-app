package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: rtc_pushkit_no_delay */
public final class AccessibilityDelegateCompatJellyBean$1 extends AccessibilityDelegate {
    final /* synthetic */ C0288xc6995d9d f6440a;

    public AccessibilityDelegateCompatJellyBean$1(C0288xc6995d9d c0288xc6995d9d) {
        this.f6440a = c0288xc6995d9d;
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f6440a.mo1521a(view, accessibilityEvent);
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f6440a.mo1523b(view, accessibilityEvent);
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f6440a.mo1519a(view, (Object) accessibilityNodeInfo);
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f6440a.mo1524c(view, accessibilityEvent);
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f6440a.mo1522a(viewGroup, view, accessibilityEvent);
    }

    public final void sendAccessibilityEvent(View view, int i) {
        this.f6440a.mo1518a(view, i);
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f6440a.mo1525d(view, accessibilityEvent);
    }

    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return (AccessibilityNodeProvider) this.f6440a.mo1517a(view);
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.f6440a.mo1520a(view, i, bundle);
    }
}
