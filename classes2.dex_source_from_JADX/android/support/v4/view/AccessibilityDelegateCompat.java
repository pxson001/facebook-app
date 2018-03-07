package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompatIcs.1;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: rtc_snake_engine_gk */
public class AccessibilityDelegateCompat {
    private static final AccessibilityDelegateImpl f6435b;
    private static final Object f6436c = f6435b.mo1509a();
    public final Object f6437a = f6435b.mo1507a(this);

    /* compiled from: rtc_snake_engine_gk */
    class AccessibilityDelegateJellyBeanImpl extends AccessibilityDelegateIcsImpl {
        AccessibilityDelegateJellyBeanImpl() {
        }

        public final Object mo1507a(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return new AccessibilityDelegateCompatJellyBean$1(new C0288xc6995d9d(this) {
                final /* synthetic */ AccessibilityDelegateJellyBeanImpl f6439b;

                public final boolean mo1521a(View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.m10874b(view, accessibilityEvent);
                }

                public final void mo1523b(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.mo1505d(view, accessibilityEvent);
                }

                public final void mo1519a(View view, Object obj) {
                    accessibilityDelegateCompat.mo1503a(view, new AccessibilityNodeInfoCompat(obj));
                }

                public final void mo1524c(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.m10875c(view, accessibilityEvent);
                }

                public final boolean mo1522a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.m10873a(viewGroup, view, accessibilityEvent);
                }

                public final void mo1518a(View view, int i) {
                    AccessibilityDelegateCompat.m10868a(view, i);
                }

                public final void mo1525d(View view, AccessibilityEvent accessibilityEvent) {
                    AccessibilityDelegateCompat.m10869a(view, accessibilityEvent);
                }

                public final Object mo1517a(View view) {
                    AccessibilityNodeProviderCompat a = accessibilityDelegateCompat.mo3105a(view);
                    return a != null ? a.f23062b : null;
                }

                public final boolean mo1520a(View view, int i, Bundle bundle) {
                    return accessibilityDelegateCompat.mo1504a(view, i, bundle);
                }
            });
        }

        public final AccessibilityNodeProviderCompat mo1506a(Object obj, View view) {
            Object a = AccessibilityDelegateCompatJellyBean.a(obj, view);
            if (a != null) {
                return new AccessibilityNodeProviderCompat(a);
            }
            return null;
        }

        public final boolean mo1508a(Object obj, View view, int i, Bundle bundle) {
            return AccessibilityDelegateCompatJellyBean.a(obj, view, i, bundle);
        }
    }

    /* compiled from: rtc_snake_engine_gk */
    class AccessibilityDelegateIcsImpl extends AccessibilityDelegateStubImpl {
        public final Object mo1509a() {
            return new AccessibilityDelegate();
        }

        AccessibilityDelegateIcsImpl() {
        }

        public Object mo1507a(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return new 1(new 1(this, accessibilityDelegateCompat));
        }

        public final boolean mo1512a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return AccessibilityDelegateCompatIcs.m30086a(obj, view, accessibilityEvent);
        }

        public final void mo1514b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.m30088b(obj, view, accessibilityEvent);
        }

        public final void mo1515c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.m30089c(obj, view, accessibilityEvent);
        }

        public final boolean mo1513a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return AccessibilityDelegateCompatIcs.m30087a(obj, viewGroup, view, accessibilityEvent);
        }

        public final void mo1510a(Object obj, View view, int i) {
            AccessibilityDelegateCompatIcs.m30084a(obj, view, i);
        }

        public final void mo1516d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.m30090d(obj, view, accessibilityEvent);
        }

        public final void mo1511a(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityDelegateCompatIcs.m30085a(obj, view, accessibilityNodeInfoCompat.b);
        }
    }

    /* compiled from: rtc_snake_engine_gk */
    class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl {
        AccessibilityDelegateStubImpl() {
        }

        public Object mo1509a() {
            return null;
        }

        public Object mo1507a(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return null;
        }

        public boolean mo1512a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public void mo1514b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void mo1511a(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public void mo1515c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean mo1513a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void mo1510a(Object obj, View view, int i) {
        }

        public void mo1516d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public AccessibilityNodeProviderCompat mo1506a(Object obj, View view) {
            return null;
        }

        public boolean mo1508a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }
    }

    /* compiled from: rtc_snake_engine_gk */
    interface AccessibilityDelegateImpl {
        AccessibilityNodeProviderCompat mo1506a(Object obj, View view);

        Object mo1509a();

        Object mo1507a(AccessibilityDelegateCompat accessibilityDelegateCompat);

        void mo1510a(Object obj, View view, int i);

        void mo1511a(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        boolean mo1508a(Object obj, View view, int i, Bundle bundle);

        boolean mo1512a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean mo1513a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo1514b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo1515c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo1516d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f6435b = new AccessibilityDelegateJellyBeanImpl();
        } else if (VERSION.SDK_INT >= 14) {
            f6435b = new AccessibilityDelegateIcsImpl();
        } else {
            f6435b = new AccessibilityDelegateStubImpl();
        }
    }

    public static void m10868a(View view, int i) {
        f6435b.mo1510a(f6436c, view, i);
    }

    public static void m10869a(View view, AccessibilityEvent accessibilityEvent) {
        f6435b.mo1516d(f6436c, view, accessibilityEvent);
    }

    public boolean m10874b(View view, AccessibilityEvent accessibilityEvent) {
        return f6435b.mo1512a(f6436c, view, accessibilityEvent);
    }

    public void m10875c(View view, AccessibilityEvent accessibilityEvent) {
        f6435b.mo1515c(f6436c, view, accessibilityEvent);
    }

    public void mo1505d(View view, AccessibilityEvent accessibilityEvent) {
        f6435b.mo1514b(f6436c, view, accessibilityEvent);
    }

    public void mo1503a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f6435b.mo1511a(f6436c, view, accessibilityNodeInfoCompat);
    }

    public boolean m10873a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f6435b.mo1513a(f6436c, viewGroup, view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat mo3105a(View view) {
        return f6435b.mo1506a(f6436c, view);
    }

    public boolean mo1504a(View view, int i, Bundle bundle) {
        return f6435b.mo1508a(f6436c, view, i, bundle);
    }
}
