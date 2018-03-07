package com.facebook.components;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* compiled from: getItemPosition() called for fragment that was not created by this adapter */
class ComponentAccessibilityDelegate extends ExploreByTouchHelper {
    private final ComponentHost f22570b;

    ComponentAccessibilityDelegate(ComponentHost componentHost) {
        super(componentHost);
        this.f22570b = componentHost;
    }

    public final void mo1503a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.mo1503a(view, accessibilityNodeInfoCompat);
        MountItem a = m30459a(this.f22570b);
        if (a != null) {
            Component component = a.f22615a;
            component.f22589c.mo3140a(accessibilityNodeInfoCompat, component);
        }
    }

    protected final void mo3102a(List<Integer> list) {
        MountItem a = m30459a(this.f22570b);
        if (a != null) {
            Component component = a.f22615a;
            int a2 = component.f22589c.mo3370a(component);
            for (int i = 0; i < a2; i++) {
                list.add(Integer.valueOf(i));
            }
        }
    }

    protected final void mo3100a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        MountItem a = m30459a(this.f22570b);
        if (a != null) {
            Rect bounds = ((Drawable) a.f22616b).getBounds();
            Component component = a.f22615a;
            ComponentLifecycle componentLifecycle = component.f22589c;
            accessibilityNodeInfoCompat.b(componentLifecycle.getClass().getName());
            componentLifecycle.mo3371a(accessibilityNodeInfoCompat, i, bounds.left, bounds.top, component);
        }
    }

    protected final int mo3099a(float f, float f2) {
        MountItem a = m30459a(this.f22570b);
        if (a == null) {
            return Integer.MIN_VALUE;
        }
        Component component = a.f22615a;
        ComponentLifecycle componentLifecycle = component.f22589c;
        if (componentLifecycle.mo3370a(component) == 0) {
            return Integer.MIN_VALUE;
        }
        Rect bounds = ((Drawable) a.f22616b).getBounds();
        int a2 = componentLifecycle.mo3369a(((int) f) - bounds.left, ((int) f2) - bounds.top, component);
        return a2 < 0 ? Integer.MIN_VALUE : a2;
    }

    protected final void mo3101a(int i, AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setContentDescription("");
    }

    protected final boolean mo3104b(int i, int i2) {
        return false;
    }

    public final AccessibilityNodeProviderCompat mo3105a(View view) {
        if (m30459a(this.f22570b) != null) {
            return super.mo3105a(view);
        }
        return null;
    }

    private static MountItem m30459a(ComponentHost componentHost) {
        int a = componentHost.f22537a.m6348a();
        for (int i = 0; i < a; i++) {
            MountItem mountItem = (MountItem) componentHost.f22537a.m6357f(i);
            if (mountItem.m30542i()) {
                return mountItem;
            }
        }
        return null;
    }
}
