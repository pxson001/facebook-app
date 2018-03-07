package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

/* compiled from: vertex_add_a_category */
public class AccessibilityNodeInfoCompat {
    public static final AccessibilityNodeInfoImpl f379a;
    public final Object f380b;

    /* compiled from: vertex_add_a_category */
    public interface AccessibilityNodeInfoImpl {
        Object mo102a();

        Object mo103a(int i, int i2, int i3, int i4, boolean z, boolean z2);

        Object mo104a(int i, int i2, boolean z, int i3);

        Object mo105a(View view);

        Object mo106a(View view, int i);

        Object mo107a(Object obj);

        void mo108a(Object obj, int i);

        void mo109a(Object obj, Rect rect);

        void mo110a(Object obj, View view);

        void mo111a(Object obj, View view, int i);

        void mo112a(Object obj, CharSequence charSequence);

        void mo113a(Object obj, Object obj2);

        void mo114a(Object obj, boolean z);

        int mo115b(Object obj);

        void mo116b(Object obj, Rect rect);

        void mo117b(Object obj, View view);

        void mo118b(Object obj, View view, int i);

        void mo119b(Object obj, CharSequence charSequence);

        void mo120b(Object obj, Object obj2);

        void mo121b(Object obj, boolean z);

        CharSequence mo122c(Object obj);

        void mo123c(Object obj, Rect rect);

        void mo124c(Object obj, View view);

        void mo125c(Object obj, View view, int i);

        void mo126c(Object obj, CharSequence charSequence);

        void mo127c(Object obj, boolean z);

        CharSequence mo128d(Object obj);

        void mo129d(Object obj, Rect rect);

        void mo130d(Object obj, CharSequence charSequence);

        void mo131d(Object obj, boolean z);

        CharSequence mo132e(Object obj);

        void mo133e(Object obj, CharSequence charSequence);

        void mo134e(Object obj, boolean z);

        CharSequence mo135f(Object obj);

        void mo136f(Object obj, boolean z);

        void mo137g(Object obj, boolean z);

        boolean mo138g(Object obj);

        void mo139h(Object obj, boolean z);

        boolean mo140h(Object obj);

        void mo141i(Object obj, boolean z);

        boolean mo142i(Object obj);

        void mo143j(Object obj, boolean z);

        boolean mo144j(Object obj);

        boolean mo145k(Object obj);

        boolean mo146l(Object obj);

        boolean mo147m(Object obj);

        boolean mo148n(Object obj);

        boolean mo149o(Object obj);

        boolean mo150p(Object obj);

        void mo151q(Object obj);

        boolean mo152r(Object obj);

        boolean mo153s(Object obj);

        String mo154t(Object obj);
    }

    /* compiled from: vertex_add_a_category */
    class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        AccessibilityNodeInfoStubImpl() {
        }

        public Object mo102a() {
            return null;
        }

        public Object mo105a(View view) {
            return null;
        }

        public Object mo106a(View view, int i) {
            return null;
        }

        public Object mo107a(Object obj) {
            return null;
        }

        public void mo108a(Object obj, int i) {
        }

        public void mo110a(Object obj, View view) {
        }

        public void mo118b(Object obj, View view, int i) {
        }

        public int mo115b(Object obj) {
            return 0;
        }

        public void mo109a(Object obj, Rect rect) {
        }

        public void mo116b(Object obj, Rect rect) {
        }

        public CharSequence mo122c(Object obj) {
            return null;
        }

        public CharSequence mo128d(Object obj) {
            return null;
        }

        public CharSequence mo132e(Object obj) {
            return null;
        }

        public CharSequence mo135f(Object obj) {
            return null;
        }

        public boolean mo138g(Object obj) {
            return false;
        }

        public boolean mo140h(Object obj) {
            return false;
        }

        public boolean mo142i(Object obj) {
            return false;
        }

        public boolean mo144j(Object obj) {
            return false;
        }

        public boolean mo145k(Object obj) {
            return false;
        }

        public boolean mo146l(Object obj) {
            return false;
        }

        public boolean mo152r(Object obj) {
            return false;
        }

        public boolean mo153s(Object obj) {
            return false;
        }

        public boolean mo147m(Object obj) {
            return false;
        }

        public boolean mo148n(Object obj) {
            return false;
        }

        public boolean mo149o(Object obj) {
            return false;
        }

        public boolean mo150p(Object obj) {
            return false;
        }

        public void mo123c(Object obj, Rect rect) {
        }

        public void mo129d(Object obj, Rect rect) {
        }

        public void mo119b(Object obj, CharSequence charSequence) {
        }

        public void mo114a(Object obj, boolean z) {
        }

        public void mo126c(Object obj, CharSequence charSequence) {
        }

        public void mo121b(Object obj, boolean z) {
        }

        public void mo127c(Object obj, boolean z) {
        }

        public void mo131d(Object obj, boolean z) {
        }

        public void mo139h(Object obj, boolean z) {
        }

        public void mo141i(Object obj, boolean z) {
        }

        public void mo134e(Object obj, boolean z) {
        }

        public void mo130d(Object obj, CharSequence charSequence) {
        }

        public void mo117b(Object obj, View view) {
        }

        public void mo136f(Object obj, boolean z) {
        }

        public void mo137g(Object obj, boolean z) {
        }

        public void mo124c(Object obj, View view) {
        }

        public void mo111a(Object obj, View view, int i) {
        }

        public void mo133e(Object obj, CharSequence charSequence) {
        }

        public void mo151q(Object obj) {
        }

        public void mo125c(Object obj, View view, int i) {
        }

        public String mo154t(Object obj) {
            return null;
        }

        public void mo113a(Object obj, Object obj2) {
        }

        public void mo120b(Object obj, Object obj2) {
        }

        public Object mo104a(int i, int i2, boolean z, int i3) {
            return null;
        }

        public Object mo103a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public void mo143j(Object obj, boolean z) {
        }

        public void mo112a(Object obj, CharSequence charSequence) {
        }
    }

    /* compiled from: vertex_add_a_category */
    class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        public final Object mo102a() {
            return AccessibilityNodeInfo.obtain();
        }

        public final Object mo105a(View view) {
            return AccessibilityNodeInfo.obtain(view);
        }

        AccessibilityNodeInfoIcsImpl() {
        }

        public final Object mo107a(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m735a(obj);
        }

        public final void mo108a(Object obj, int i) {
            AccessibilityNodeInfoCompatIcs.m736a(obj, i);
        }

        public final void mo110a(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.m738a(obj, view);
        }

        public final int mo115b(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m741b(obj);
        }

        public final void mo109a(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.m737a(obj, rect);
        }

        public final void mo116b(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.m742b(obj, rect);
        }

        public final CharSequence mo122c(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m746c(obj);
        }

        public final CharSequence mo128d(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m751d(obj);
        }

        public final CharSequence mo132e(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m755e(obj);
        }

        public final CharSequence mo135f(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m757f(obj);
        }

        public final boolean mo138g(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m760g(obj);
        }

        public final boolean mo140h(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m761h(obj);
        }

        public final boolean mo142i(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m762i(obj);
        }

        public final boolean mo144j(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m763j(obj);
        }

        public final boolean mo145k(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m764k(obj);
        }

        public final boolean mo146l(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m765l(obj);
        }

        public final boolean mo147m(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m766m(obj);
        }

        public final boolean mo148n(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m767n(obj);
        }

        public final boolean mo149o(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m768o(obj);
        }

        public final boolean mo150p(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m769p(obj);
        }

        public final void mo123c(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.m747c(obj, rect);
        }

        public final void mo129d(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.m752d(obj, rect);
        }

        public final void mo119b(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.m739a(obj, charSequence);
        }

        public final void mo114a(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m740a(obj, z);
        }

        public final void mo126c(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.m744b(obj, charSequence);
        }

        public final void mo121b(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m745b(obj, z);
        }

        public final void mo127c(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m750c(obj, z);
        }

        public final void mo131d(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m754d(obj, z);
        }

        public final void mo134e(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m756e(obj, z);
        }

        public final void mo130d(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.m749c(obj, charSequence);
        }

        public final void mo117b(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.m743b(obj, view);
        }

        public final void mo136f(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m758f(obj, z);
        }

        public final void mo137g(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m759g(obj, z);
        }

        public final void mo124c(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.m748c(obj, view);
        }

        public final void mo133e(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.m753d(obj, charSequence);
        }

        public final void mo151q(Object obj) {
            AccessibilityNodeInfoCompatIcs.m770q(obj);
        }
    }

    /* compiled from: vertex_add_a_category */
    class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoIcsImpl {
        public final Object mo106a(View view, int i) {
            return AccessibilityNodeInfo.obtain(view, i);
        }

        AccessibilityNodeInfoJellybeanImpl() {
        }

        public final void mo118b(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.m771a(obj, view, i);
        }

        public final void mo111a(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.m774b(obj, view, i);
        }

        public final boolean mo152r(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.m773a(obj);
        }

        public final void mo139h(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellyBean.m772a(obj, z);
        }

        public final boolean mo153s(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.m776b(obj);
        }

        public final void mo141i(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellyBean.m775b(obj, z);
        }

        public final void mo125c(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.m777c(obj, view, i);
        }
    }

    /* compiled from: vertex_add_a_category */
    class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoJellybeanImpl {
        AccessibilityNodeInfoJellybeanMr2Impl() {
        }

        public final String mo154t(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.m778a(obj);
        }
    }

    /* compiled from: vertex_add_a_category */
    class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoJellybeanMr2Impl {
        public Object mo104a(int i, int i2, boolean z, int i3) {
            return CollectionInfo.obtain(i, i2, z);
        }

        public Object mo103a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        AccessibilityNodeInfoKitKatImpl() {
        }

        public final void mo113a(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.m779a(obj, obj2);
        }

        public final void mo120b(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.m781b(obj, obj2);
        }

        public final void mo143j(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.m780a(obj, z);
        }
    }

    /* compiled from: vertex_add_a_category */
    class AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoKitKatImpl {
        public final Object mo104a(int i, int i2, boolean z, int i3) {
            return CollectionInfo.obtain(i, i2, z, i3);
        }

        AccessibilityNodeInfoApi21Impl() {
        }

        public final Object mo103a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfoCompatApi21.m733a(i, i2, i3, i4, z, z2);
        }

        public final void mo112a(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatApi21.m734a(obj, charSequence);
        }
    }

    /* compiled from: vertex_add_a_category */
    public class CollectionInfoCompat {
        final Object f377a;

        public CollectionInfoCompat(Object obj) {
            this.f377a = obj;
        }
    }

    /* compiled from: vertex_add_a_category */
    public class CollectionItemInfoCompat {
        public final Object f378a;

        public static CollectionItemInfoCompat m696a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.f379a.mo103a(i, i2, i3, i4, z, z2));
        }

        private CollectionItemInfoCompat(Object obj) {
            this.f378a = obj;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f379a = new AccessibilityNodeInfoApi21Impl();
        } else if (VERSION.SDK_INT >= 19) {
            f379a = new AccessibilityNodeInfoKitKatImpl();
        } else if (VERSION.SDK_INT >= 18) {
            f379a = new AccessibilityNodeInfoJellybeanMr2Impl();
        } else if (VERSION.SDK_INT >= 16) {
            f379a = new AccessibilityNodeInfoJellybeanImpl();
        } else if (VERSION.SDK_INT >= 14) {
            f379a = new AccessibilityNodeInfoIcsImpl();
        } else {
            f379a = new AccessibilityNodeInfoStubImpl();
        }
    }

    public static AccessibilityNodeInfoCompat m698c(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public AccessibilityNodeInfoCompat(Object obj) {
        this.f380b = obj;
    }

    public static AccessibilityNodeInfoCompat m697a(View view) {
        return m698c(f379a.mo105a(view));
    }

    public final void m710c(View view, int i) {
        f379a.mo118b(this.f380b, view, i);
    }

    public final int m708c() {
        return f379a.mo115b(this.f380b);
    }

    public final void m699a(int i) {
        f379a.mo108a(this.f380b, i);
    }

    public final void m714d(View view) {
        f379a.mo117b(this.f380b, view);
    }

    public final void m715d(View view, int i) {
        f379a.mo125c(this.f380b, view, i);
    }

    public final void m700a(Rect rect) {
        f379a.mo109a(this.f380b, rect);
    }

    public final void m704b(Rect rect) {
        f379a.mo123c(this.f380b, rect);
    }

    public final void m709c(Rect rect) {
        f379a.mo116b(this.f380b, rect);
    }

    public final void m713d(Rect rect) {
        f379a.mo129d(this.f380b, rect);
    }

    public final boolean m718d() {
        return f379a.mo145k(this.f380b);
    }

    public final void m703a(boolean z) {
        f379a.mo127c(this.f380b, z);
    }

    public final boolean m720e() {
        return f379a.mo146l(this.f380b);
    }

    public final void m707b(boolean z) {
        f379a.mo131d(this.f380b, z);
    }

    public final void m712c(boolean z) {
        f379a.mo139h(this.f380b, z);
    }

    public final void m717d(boolean z) {
        f379a.mo141i(this.f380b, z);
    }

    public final boolean m724h() {
        return f379a.mo150p(this.f380b);
    }

    public final void m719e(boolean z) {
        f379a.mo137g(this.f380b, z);
    }

    public final boolean m726i() {
        return f379a.mo142i(this.f380b);
    }

    public final void m721f(boolean z) {
        f379a.mo114a(this.f380b, z);
    }

    public final boolean m727j() {
        return f379a.mo147m(this.f380b);
    }

    public final void m722g(boolean z) {
        f379a.mo134e(this.f380b, z);
    }

    public final boolean m728k() {
        return f379a.mo144j(this.f380b);
    }

    public final void m723h(boolean z) {
        f379a.mo121b(this.f380b, z);
    }

    public final void m725i(boolean z) {
        f379a.mo136f(this.f380b, z);
    }

    public final CharSequence m729l() {
        return f379a.mo132e(this.f380b);
    }

    public final void m701a(CharSequence charSequence) {
        f379a.mo130d(this.f380b, charSequence);
    }

    public final CharSequence m730m() {
        return f379a.mo122c(this.f380b);
    }

    public final void m705b(CharSequence charSequence) {
        f379a.mo119b(this.f380b, charSequence);
    }

    public final CharSequence m731n() {
        return f379a.mo135f(this.f380b);
    }

    public final void m711c(CharSequence charSequence) {
        f379a.mo133e(this.f380b, charSequence);
    }

    public final CharSequence m732o() {
        return f379a.mo128d(this.f380b);
    }

    public final void m716d(CharSequence charSequence) {
        f379a.mo126c(this.f380b, charSequence);
    }

    public final void m702a(Object obj) {
        f379a.mo113a(this.f380b, ((CollectionInfoCompat) obj).f377a);
    }

    public final void m706b(Object obj) {
        f379a.mo120b(this.f380b, ((CollectionItemInfoCompat) obj).f378a);
    }

    public int hashCode() {
        return this.f380b == null ? 0 : this.f380b.hashCode();
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
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        if (this.f380b == null) {
            if (accessibilityNodeInfoCompat.f380b != null) {
                return false;
            }
            return true;
        } else if (this.f380b.equals(accessibilityNodeInfoCompat.f380b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m700a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m709c(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m729l());
        stringBuilder.append("; className: ").append(m730m());
        stringBuilder.append("; text: ").append(m731n());
        stringBuilder.append("; contentDescription: ").append(m732o());
        stringBuilder.append("; viewId: ").append(f379a.mo154t(this.f380b));
        stringBuilder.append("; checkable: ").append(f379a.mo138g(this.f380b));
        stringBuilder.append("; checked: ").append(f379a.mo140h(this.f380b));
        stringBuilder.append("; focusable: ").append(m718d());
        stringBuilder.append("; focused: ").append(m720e());
        stringBuilder.append("; selected: ").append(m724h());
        stringBuilder.append("; clickable: ").append(m726i());
        stringBuilder.append("; longClickable: ").append(m727j());
        stringBuilder.append("; enabled: ").append(m728k());
        stringBuilder.append("; password: ").append(f379a.mo148n(this.f380b));
        stringBuilder.append("; scrollable: " + f379a.mo149o(this.f380b));
        stringBuilder.append("; [");
        int c = m708c();
        while (c != 0) {
            String str;
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(c);
            c &= numberOfTrailingZeros ^ -1;
            switch (numberOfTrailingZeros) {
                case 1:
                    str = "ACTION_FOCUS";
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str = "ACTION_CLEAR_FOCUS";
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    str = "ACTION_SELECT";
                    break;
                case 8:
                    str = "ACTION_CLEAR_SELECTION";
                    break;
                case 16:
                    str = "ACTION_CLICK";
                    break;
                case 32:
                    str = "ACTION_LONG_CLICK";
                    break;
                case 64:
                    str = "ACTION_ACCESSIBILITY_FOCUS";
                    break;
                case 128:
                    str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    break;
                case 256:
                    str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    break;
                case 512:
                    str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    break;
                case 1024:
                    str = "ACTION_NEXT_HTML_ELEMENT";
                    break;
                case 2048:
                    str = "ACTION_PREVIOUS_HTML_ELEMENT";
                    break;
                case 4096:
                    str = "ACTION_SCROLL_FORWARD";
                    break;
                case 8192:
                    str = "ACTION_SCROLL_BACKWARD";
                    break;
                case 16384:
                    str = "ACTION_COPY";
                    break;
                case 32768:
                    str = "ACTION_PASTE";
                    break;
                case 65536:
                    str = "ACTION_CUT";
                    break;
                case 131072:
                    str = "ACTION_SET_SELECTION";
                    break;
                default:
                    str = "ACTION_UNKNOWN";
                    break;
            }
            stringBuilder.append(str);
            if (c != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
