package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: friends/ */
public class AccessibilityNodeProviderCompat {
    private static final AccessibilityNodeProviderImpl f23061a;
    public final Object f23062b;

    /* compiled from: friends/ */
    class AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderKitKatImpl() {
        }

        public final Object mo3388a(final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return new AccessibilityNodeProviderCompatKitKat$1(new C0931x9a16f6e(this) {
                final /* synthetic */ AccessibilityNodeProviderKitKatImpl f23064b;

                public final boolean mo3391a(int i, int i2, Bundle bundle) {
                    return accessibilityNodeProviderCompat.mo3401a(i, i2, bundle);
                }

                public final Object mo3389a(int i) {
                    AccessibilityNodeInfoCompat a = accessibilityNodeProviderCompat.mo3400a(i);
                    if (a == null) {
                        return null;
                    }
                    return a.b;
                }

                public final List<Object> mo3390a(String str, int i) {
                    List list = null;
                    List<Object> arrayList = new ArrayList();
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((AccessibilityNodeInfoCompat) list.get(i2)).b);
                    }
                    return arrayList;
                }

                public final Object mo3392b(int i) {
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = null;
                    if (accessibilityNodeInfoCompat == null) {
                        return null;
                    }
                    return accessibilityNodeInfoCompat.b;
                }
            });
        }
    }

    /* compiled from: friends/ */
    class AccessibilityNodeProviderStubImpl implements AccessibilityNodeProviderImpl {
        AccessibilityNodeProviderStubImpl() {
        }

        public Object mo3388a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return null;
        }
    }

    /* compiled from: friends/ */
    interface AccessibilityNodeProviderImpl {
        Object mo3388a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat);
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f23061a = new AccessibilityNodeProviderKitKatImpl();
        } else if (VERSION.SDK_INT >= 16) {
            f23061a = new AccessibilityNodeProviderJellyBeanImpl();
        } else {
            f23061a = new AccessibilityNodeProviderStubImpl();
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.f23062b = f23061a.mo3388a(this);
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f23062b = obj;
    }

    public AccessibilityNodeInfoCompat mo3400a(int i) {
        return null;
    }

    public boolean mo3401a(int i, int i2, Bundle bundle) {
        return false;
    }
}
