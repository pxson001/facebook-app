package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* compiled from: value_object */
public class AccessibilityRecordCompat {
    public static final AccessibilityRecordImpl f384a;
    private final Object f385b;

    /* compiled from: value_object */
    public interface AccessibilityRecordImpl {
        Object mo158a();

        void mo159a(Object obj, int i);

        void mo160a(Object obj, View view, int i);

        void mo161a(Object obj, boolean z);

        void mo162b(Object obj, int i);

        void mo163c(Object obj, int i);

        void mo164d(Object obj, int i);

        void mo165e(Object obj, int i);

        void mo166f(Object obj, int i);

        void mo167g(Object obj, int i);
    }

    /* compiled from: value_object */
    class AccessibilityRecordStubImpl implements AccessibilityRecordImpl {
        AccessibilityRecordStubImpl() {
        }

        public Object mo158a() {
            return null;
        }

        public void mo159a(Object obj, int i) {
        }

        public void mo162b(Object obj, int i) {
        }

        public void mo166f(Object obj, int i) {
        }

        public void mo167g(Object obj, int i) {
        }

        public void mo163c(Object obj, int i) {
        }

        public void mo164d(Object obj, int i) {
        }

        public void mo161a(Object obj, boolean z) {
        }

        public void mo160a(Object obj, View view, int i) {
        }

        public void mo165e(Object obj, int i) {
        }
    }

    /* compiled from: value_object */
    class AccessibilityRecordIcsImpl extends AccessibilityRecordStubImpl {
        public final Object mo158a() {
            return AccessibilityRecord.obtain();
        }

        AccessibilityRecordIcsImpl() {
        }

        public final void mo159a(Object obj, int i) {
            AccessibilityRecordCompatIcs.m828a(obj, i);
        }

        public final void mo162b(Object obj, int i) {
            AccessibilityRecordCompatIcs.m830b(obj, i);
        }

        public final void mo163c(Object obj, int i) {
            AccessibilityRecordCompatIcs.m831c(obj, i);
        }

        public final void mo164d(Object obj, int i) {
            AccessibilityRecordCompatIcs.m832d(obj, i);
        }

        public final void mo161a(Object obj, boolean z) {
            AccessibilityRecordCompatIcs.m829a(obj, z);
        }

        public final void mo165e(Object obj, int i) {
            AccessibilityRecordCompatIcs.m833e(obj, i);
        }
    }

    /* compiled from: value_object */
    class AccessibilityRecordIcsMr1Impl extends AccessibilityRecordIcsImpl {
        AccessibilityRecordIcsMr1Impl() {
        }

        public final void mo166f(Object obj, int i) {
            AccessibilityRecordCompatIcsMr1.m834a(obj, i);
        }

        public final void mo167g(Object obj, int i) {
            AccessibilityRecordCompatIcsMr1.m835b(obj, i);
        }
    }

    /* compiled from: value_object */
    class AccessibilityRecordJellyBeanImpl extends AccessibilityRecordIcsMr1Impl {
        AccessibilityRecordJellyBeanImpl() {
        }

        public final void mo160a(Object obj, View view, int i) {
            AccessibilityRecordCompatJellyBean.m836a(obj, view, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f384a = new AccessibilityRecordJellyBeanImpl();
        } else if (VERSION.SDK_INT >= 15) {
            f384a = new AccessibilityRecordIcsMr1Impl();
        } else if (VERSION.SDK_INT >= 14) {
            f384a = new AccessibilityRecordIcsImpl();
        } else {
            f384a = new AccessibilityRecordStubImpl();
        }
    }

    public AccessibilityRecordCompat(Object obj) {
        this.f385b = obj;
    }

    public final void m820a(View view, int i) {
        f384a.mo160a(this.f385b, view, i);
    }

    public final void m821a(boolean z) {
        f384a.mo161a(this.f385b, z);
    }

    public final void m819a(int i) {
        f384a.mo162b(this.f385b, i);
    }

    public final void m822b(int i) {
        f384a.mo159a(this.f385b, i);
    }

    public final void m823c(int i) {
        f384a.mo165e(this.f385b, i);
    }

    public final void m824d(int i) {
        f384a.mo163c(this.f385b, i);
    }

    public final void m825e(int i) {
        f384a.mo164d(this.f385b, i);
    }

    public final void m826f(int i) {
        f384a.mo166f(this.f385b, i);
    }

    public final void m827g(int i) {
        f384a.mo167g(this.f385b, i);
    }

    public int hashCode() {
        return this.f385b == null ? 0 : this.f385b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        if (this.f385b == null) {
            if (accessibilityRecordCompat.f385b != null) {
                return false;
            }
            return true;
        } else if (this.f385b.equals(accessibilityRecordCompat.f385b)) {
            return true;
        } else {
            return false;
        }
    }
}
