package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* compiled from: publish */
public class ViewParentCompat {
    public static final ViewParentCompatImpl f4045a;

    /* compiled from: publish */
    class ViewParentCompatKitKatImpl extends ViewParentCompatICSImpl {
        ViewParentCompatKitKatImpl() {
        }
    }

    /* compiled from: publish */
    class ViewParentCompatICSImpl extends ViewParentCompatStubImpl {
        public final boolean mo319a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
        }

        ViewParentCompatICSImpl() {
        }
    }

    /* compiled from: publish */
    class ViewParentCompatStubImpl implements ViewParentCompatImpl {
        ViewParentCompatStubImpl() {
        }

        public boolean mo319a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            if (view == null) {
                return false;
            }
            ((AccessibilityManager) view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent);
            return true;
        }

        public boolean mo325a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void mo326b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void mo320a(ViewParent viewParent, View view) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }

        public void mo321a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void mo322a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean mo324a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean mo323a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    /* compiled from: publish */
    public interface ViewParentCompatImpl {
        void mo320a(ViewParent viewParent, View view);

        void mo321a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void mo322a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean mo323a(ViewParent viewParent, View view, float f, float f2);

        boolean mo324a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean mo325a(ViewParent viewParent, View view, View view2, int i);

        boolean mo319a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent);

        void mo326b(ViewParent viewParent, View view, View view2, int i);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f4045a = new ViewParentCompatLollipopImpl();
        } else if (i >= 19) {
            f4045a = new ViewParentCompatKitKatImpl();
        } else if (i >= 14) {
            f4045a = new ViewParentCompatICSImpl();
        } else {
            f4045a = new ViewParentCompatStubImpl();
        }
    }

    private ViewParentCompat() {
    }

    public static void m4565a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f4045a.mo321a(viewParent, view, i, i2, i3, i4);
    }

    public static void m4566a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f4045a.mo322a(viewParent, view, i, i2, iArr);
    }
}
