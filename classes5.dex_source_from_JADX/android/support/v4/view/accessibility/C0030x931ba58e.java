package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.C00311;
import java.util.ArrayList;
import java.util.List;

/* compiled from: values */
class C0030x931ba58e extends AccessibilityNodeProviderStubImpl {
    C0030x931ba58e() {
    }

    public final Object m788a(final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
        return new C00311(new AccessibilityNodeInfoBridge(this) {
            final /* synthetic */ C0030x931ba58e f382b;

            public final boolean mo157a(int i, int i2, Bundle bundle) {
                return accessibilityNodeProviderCompat.a(i, i2, bundle);
            }

            public final Object mo155a(int i) {
                AccessibilityNodeInfoCompat a = accessibilityNodeProviderCompat.a(i);
                if (a == null) {
                    return null;
                }
                return a.f380b;
            }

            public final List<Object> mo156a(String str, int i) {
                List list = null;
                List<Object> arrayList = new ArrayList();
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(((AccessibilityNodeInfoCompat) list.get(i2)).f380b);
                }
                return arrayList;
            }
        });
    }
}
