package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: is_blocking */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String f19232b = View.class.getName();
    private final Rect f19233c = new Rect();
    private final Rect f19234d = new Rect();
    public final Rect f19235e = new Rect();
    private final int[] f19236f = new int[2];
    private final AccessibilityManager f19237g;
    public final View f19238h;
    private ExploreByTouchNodeProvider f19239i;
    private int f19240j = Integer.MIN_VALUE;
    private int f19241k = Integer.MIN_VALUE;

    protected abstract int mo3099a(float f, float f2);

    protected abstract void mo3100a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    protected abstract void mo3101a(int i, AccessibilityEvent accessibilityEvent);

    public abstract void mo3102a(List<Integer> list);

    protected abstract boolean mo3104b(int i, int i2);

    public ExploreByTouchHelper(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f19238h = view;
        this.f19237g = (AccessibilityManager) view.getContext().getSystemService("accessibility");
    }

    public AccessibilityNodeProviderCompat mo3105a(View view) {
        if (this.f19239i == null) {
            this.f19239i = new ExploreByTouchNodeProvider(this);
        }
        return this.f19239i;
    }

    public final boolean m26957a(MotionEvent motionEvent) {
        if (!this.f19237g.isEnabled() || !AccessibilityManagerCompat.b(this.f19237g)) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 7:
            case 9:
                int a = mo3099a(motionEvent.getX(), motionEvent.getY());
                mo3103b(a);
                if (a == Integer.MIN_VALUE) {
                    return false;
                }
                return true;
            case 10:
                if (this.f19240j == Integer.MIN_VALUE) {
                    return false;
                }
                mo3103b(Integer.MIN_VALUE);
                return true;
            default:
                return false;
        }
    }

    public final boolean m26956a(int i, int i2) {
        if (i == Integer.MIN_VALUE || !this.f19237g.isEnabled()) {
            return false;
        }
        ViewParent parent = this.f19238h.getParent();
        if (parent == null) {
            return false;
        }
        AccessibilityEvent c = mo3098c(i, i2);
        return ViewParentCompat.a.a(parent, this.f19238h, c);
    }

    public final void m26952a(int i) {
        m26956a(i, 2048);
    }

    private void mo3103b(int i) {
        if (this.f19241k != i) {
            int i2 = this.f19241k;
            this.f19241k = i;
            m26956a(i, (int) HTTPTransportCallback.BODY_BYTES_RECEIVED);
            m26956a(i2, 256);
        }
    }

    private AccessibilityEvent mo3098c(int i, int i2) {
        switch (i) {
            case -1:
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
                ViewCompat.m10942a(this.f19238h, obtain);
                return obtain;
            default:
                return m26944d(i, i2);
        }
    }

    private AccessibilityEvent m26944d(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setEnabled(true);
        obtain.setClassName(f19232b);
        mo3101a(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setPackageName(this.f19238h.getContext().getPackageName());
        AccessibilityEventCompat.a(obtain).a(this.f19238h, i);
        return obtain;
    }

    public static AccessibilityNodeInfoCompat m26943d(ExploreByTouchHelper exploreByTouchHelper, int i) {
        switch (i) {
            case -1:
                AccessibilityNodeInfoCompat a = AccessibilityNodeInfoCompat.a(exploreByTouchHelper.f19238h);
                ViewCompat.m10941a(exploreByTouchHelper.f19238h, a);
                List linkedList = new LinkedList();
                exploreByTouchHelper.mo3102a(linkedList);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    a.c(exploreByTouchHelper.f19238h, ((Integer) it.next()).intValue());
                }
                return a;
            default:
                return exploreByTouchHelper.m26945e(i);
        }
    }

    private AccessibilityNodeInfoCompat m26945e(int i) {
        AccessibilityNodeInfoCompat c = AccessibilityNodeInfoCompat.c(AccessibilityNodeInfoCompat.a.a());
        c.h(true);
        c.b(f19232b);
        mo3100a(i, c);
        if (c.n() == null && c.o() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        c.a(this.f19234d);
        if (this.f19234d.isEmpty()) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int c2 = c.c();
        if ((c2 & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else if ((c2 & HTTPTransportCallback.BODY_BYTES_RECEIVED) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else {
            boolean z;
            c.a(this.f19238h.getContext().getPackageName());
            AccessibilityNodeInfoCompat.a.a(c.b, this.f19238h, i);
            c.d(this.f19238h);
            if (this.f19240j == i) {
                c.d(true);
                c.a(HTTPTransportCallback.BODY_BYTES_RECEIVED);
            } else {
                c.d(false);
                c.a(64);
            }
            Rect rect = this.f19234d;
            if (rect == null || rect.isEmpty()) {
                z = false;
            } else if (this.f19238h.getWindowVisibility() != 0) {
                z = false;
            } else {
                ViewParent parent = this.f19238h.getParent();
                while (parent instanceof View) {
                    View view = (View) parent;
                    if (ViewCompat.m10961f(view) <= 0.0f || view.getVisibility() != 0) {
                        z = false;
                        break;
                    }
                    parent = view.getParent();
                }
                z = parent == null ? false : !this.f19238h.getLocalVisibleRect(this.f19235e) ? false : rect.intersect(this.f19235e);
            }
            if (z) {
                c.c(true);
                c.b(this.f19234d);
            }
            this.f19238h.getLocationOnScreen(this.f19236f);
            c2 = this.f19236f[0];
            int i2 = this.f19236f[1];
            this.f19233c.set(this.f19234d);
            this.f19233c.offset(c2, i2);
            c.d(this.f19233c);
            return c;
        }
    }

    public static boolean m26939a(ExploreByTouchHelper exploreByTouchHelper, int i, int i2, Bundle bundle) {
        switch (i) {
            case -1:
                return ViewCompat.m10947a(exploreByTouchHelper.f19238h, i2, bundle);
            default:
                return exploreByTouchHelper.m26941b(i, i2, bundle);
        }
    }

    private boolean m26941b(int i, int i2, Bundle bundle) {
        switch (i2) {
            case HTTPTransportCallback.BODY_BYTES_GENERATED /*64*/:
            case HTTPTransportCallback.BODY_BYTES_RECEIVED /*128*/:
                return m26946e(i, i2);
            default:
                return mo3104b(i, i2);
        }
    }

    private boolean m26946e(int i, int i2) {
        switch (i2) {
            case HTTPTransportCallback.BODY_BYTES_GENERATED /*64*/:
                return m26948g(i);
            case HTTPTransportCallback.BODY_BYTES_RECEIVED /*128*/:
                return m26949h(i);
            default:
                return false;
        }
    }

    private boolean m26947f(int i) {
        return this.f19240j == i;
    }

    private boolean m26948g(int i) {
        if (!this.f19237g.isEnabled() || !AccessibilityManagerCompat.b(this.f19237g) || m26947f(i)) {
            return false;
        }
        this.f19240j = i;
        this.f19238h.invalidate();
        m26956a(i, 32768);
        return true;
    }

    private boolean m26949h(int i) {
        if (!m26947f(i)) {
            return false;
        }
        this.f19240j = Integer.MIN_VALUE;
        this.f19238h.invalidate();
        m26956a(i, 65536);
        return true;
    }
}
