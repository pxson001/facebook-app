package com.facebook.accessibility;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.facebook.proxygen.HTTPTransportCallback;
import java.lang.reflect.Field;

/* compiled from: friendlist_feed */
public abstract class AccessibilityHelper<V extends View> extends AccessibilityNodeProviderCompat {
    private static final Field f23074b;
    public final V f23075a;
    private final AccessibilityManager f23076c;
    public int f23077d = Integer.MIN_VALUE;
    private int f23078e = Integer.MIN_VALUE;

    protected abstract int mo3397a(float f, float f2);

    public abstract void mo3398a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public abstract void mo3399a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    static {
        Field declaredField;
        try {
            declaredField = View.class.getDeclaredField("mPrivateFlags2");
            declaredField.setAccessible(true);
        } catch (Exception e) {
            declaredField = null;
        }
        f23074b = declaredField;
    }

    public AccessibilityHelper(V v) {
        if (v == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f23075a = v;
        this.f23076c = (AccessibilityManager) v.getContext().getSystemService("accessibility");
    }

    public final boolean m31215a(MotionEvent motionEvent) {
        if (!this.f23076c.isEnabled() || !this.f23076c.isTouchExplorationEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 7:
            case 9:
                int a = mo3397a(motionEvent.getX(), motionEvent.getY());
                m31204b(a);
                if (a == Integer.MIN_VALUE) {
                    return false;
                }
                return true;
            case 10:
                m31204b(Integer.MIN_VALUE);
                return true;
            default:
                return false;
        }
    }

    private boolean m31202a(int i, int i2) {
        if (i == Integer.MIN_VALUE || !this.f23076c.isEnabled()) {
            return false;
        }
        ViewParent parent = this.f23075a.getParent();
        if (parent == null) {
            return false;
        }
        AccessibilityEvent accessibilityEvent;
        AccessibilityEvent obtain;
        switch (i) {
            case -1:
                obtain = AccessibilityEvent.obtain(i2);
                this.f23075a.onInitializeAccessibilityEvent(obtain);
                accessibilityEvent = obtain;
                break;
            default:
                obtain = AccessibilityEvent.obtain(i2);
                AccessibilityEventCompat.a(obtain).a(this.f23075a, i);
                accessibilityEvent = obtain;
                break;
        }
        return parent.requestSendAccessibilityEvent(this.f23075a, accessibilityEvent);
    }

    private void m31204b(int i) {
        if (this.f23078e != i) {
            int i2 = this.f23078e;
            this.f23078e = i;
            m31202a(i, (int) HTTPTransportCallback.BODY_BYTES_RECEIVED);
            m31202a(i2, 256);
        }
    }

    public final AccessibilityNodeInfoCompat mo3400a(int i) {
        AccessibilityNodeInfoCompat a;
        switch (i) {
            case -1:
                a = AccessibilityNodeInfoCompat.a(this.f23075a);
                ViewCompat.m10941a(this.f23075a, a);
                mo3399a(a);
                return a;
            default:
                a = AccessibilityNodeInfoCompat.c(AccessibilityNodeInfoCompat.a.a(this.f23075a, i));
                mo3398a(i, a);
                if (this.f23077d == i) {
                    a.d(true);
                    a.a(HTTPTransportCallback.BODY_BYTES_RECEIVED);
                } else {
                    a.d(false);
                    a.a(64);
                }
                return a;
        }
    }

    public final boolean mo3401a(int i, int i2, Bundle bundle) {
        switch (i) {
            case -1:
                return m31203a(i2, bundle);
            default:
                return m31205b(i, i2, bundle);
        }
    }

    private boolean m31203a(int i, Bundle bundle) {
        boolean a = ViewCompat.m10947a(this.f23075a, i, bundle);
        if (i == 64 && a && f23074b != null) {
            try {
                f23074b.setInt(this.f23075a, f23074b.getInt(this.f23075a) | 67108864);
            } catch (Exception e) {
            }
        }
        return a;
    }

    private boolean m31205b(int i, int i2, Bundle bundle) {
        switch (i2) {
            case HTTPTransportCallback.BODY_BYTES_GENERATED /*64*/:
            case HTTPTransportCallback.BODY_BYTES_RECEIVED /*128*/:
                return m31206d(i, i2);
            default:
                return false;
        }
    }

    private boolean m31206d(int i, int i2) {
        switch (i2) {
            case HTTPTransportCallback.BODY_BYTES_GENERATED /*64*/:
                return m31208f(i);
            case HTTPTransportCallback.BODY_BYTES_RECEIVED /*128*/:
                return m31209g(i);
            default:
                return false;
        }
    }

    private boolean m31207e(int i) {
        return this.f23077d == i;
    }

    private boolean m31208f(int i) {
        if (!this.f23076c.isEnabled() || !this.f23076c.isTouchExplorationEnabled() || m31207e(i)) {
            return false;
        }
        m31209g(this.f23077d);
        this.f23077d = i;
        this.f23075a.invalidate();
        m31202a(i, 32768);
        return true;
    }

    private boolean m31209g(int i) {
        if (!m31207e(i)) {
            return false;
        }
        this.f23077d = Integer.MIN_VALUE;
        this.f23075a.invalidate();
        m31202a(i, 65536);
        return true;
    }
}
