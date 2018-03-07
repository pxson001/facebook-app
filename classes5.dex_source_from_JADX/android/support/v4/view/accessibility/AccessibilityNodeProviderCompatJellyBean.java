package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: variant_values */
class AccessibilityNodeProviderCompatJellyBean {

    /* compiled from: variant_values */
    interface AccessibilityNodeInfoBridge {
        Object mo155a(int i);

        List<Object> mo156a(String str, int i);

        boolean mo157a(int i, int i2, Bundle bundle);
    }

    /* compiled from: variant_values */
    public final class C00311 extends AccessibilityNodeProvider {
        final /* synthetic */ AccessibilityNodeInfoBridge f383a;

        public C00311(AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
            this.f383a = accessibilityNodeInfoBridge;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return (AccessibilityNodeInfo) this.f383a.mo155a(i);
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.f383a.mo156a(str, i);
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.f383a.mo157a(i, i2, bundle);
        }
    }

    AccessibilityNodeProviderCompatJellyBean() {
    }
}
