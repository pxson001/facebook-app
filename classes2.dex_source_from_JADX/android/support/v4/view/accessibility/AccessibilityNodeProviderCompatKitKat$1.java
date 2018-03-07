package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: friends */
public final class AccessibilityNodeProviderCompatKitKat$1 extends AccessibilityNodeProvider {
    final /* synthetic */ C0931x9a16f6e f23065a;

    public AccessibilityNodeProviderCompatKitKat$1(C0931x9a16f6e c0931x9a16f6e) {
        this.f23065a = c0931x9a16f6e;
    }

    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f23065a.mo3389a(i);
    }

    public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f23065a.mo3390a(str, i);
    }

    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.f23065a.mo3391a(i, i2, bundle);
    }

    public final AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.f23065a.mo3392b(i);
    }
}
