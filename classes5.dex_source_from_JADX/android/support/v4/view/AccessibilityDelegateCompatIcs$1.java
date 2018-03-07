package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: video_share_default_message */
public final class AccessibilityDelegateCompatIcs$1 extends AccessibilityDelegate {
    final /* synthetic */ AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge f276a;

    public AccessibilityDelegateCompatIcs$1(AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge accessibilityDelegateCompatIcs$AccessibilityDelegateBridge) {
        this.f276a = accessibilityDelegateCompatIcs$AccessibilityDelegateBridge;
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f276a.mo47a(view, accessibilityEvent);
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f276a.mo49b(view, accessibilityEvent);
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f276a.mo46a(view, (Object) accessibilityNodeInfo);
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f276a.mo50c(view, accessibilityEvent);
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f276a.mo48a(viewGroup, view, accessibilityEvent);
    }

    public final void sendAccessibilityEvent(View view, int i) {
        this.f276a.mo45a(view, i);
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f276a.mo51d(view, accessibilityEvent);
    }
}
