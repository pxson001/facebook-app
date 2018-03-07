package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: num_locations_returned */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    final RecyclerView f11964b;
    public final AccessibilityDelegateCompat f11965c = new C05031(this);

    /* compiled from: num_locations_returned */
    class C05031 extends AccessibilityDelegateCompat {
        final /* synthetic */ RecyclerViewAccessibilityDelegate f11966b;

        C05031(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f11966b = recyclerViewAccessibilityDelegate;
        }

        public final void mo1503a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo1503a(view, accessibilityNodeInfoCompat);
            if (!RecyclerViewAccessibilityDelegate.m17651c(this.f11966b) && this.f11966b.f11964b.getLayoutManager() != null) {
                this.f11966b.f11964b.getLayoutManager().m17314a(view, accessibilityNodeInfoCompat);
            }
        }

        public final boolean mo1504a(View view, int i, Bundle bundle) {
            if (super.mo1504a(view, i, bundle)) {
                return true;
            }
            if (RecyclerViewAccessibilityDelegate.m17651c(this.f11966b) || this.f11966b.f11964b.getLayoutManager() == null) {
                return false;
            }
            return this.f11966b.f11964b.getLayoutManager().m17323a(view, i, bundle);
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.f11964b = recyclerView;
    }

    public static boolean m17651c(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        return recyclerViewAccessibilityDelegate.f11964b.m17174i();
    }

    public final boolean mo1504a(View view, int i, Bundle bundle) {
        if (super.mo1504a(view, i, bundle)) {
            return true;
        }
        if (m17651c(this) || this.f11964b.getLayoutManager() == null) {
            return false;
        }
        return this.f11964b.getLayoutManager().m17319a(i, bundle);
    }

    public final void mo1503a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.mo1503a(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.b(RecyclerView.class.getName());
        if (!m17651c(this) && this.f11964b.getLayoutManager() != null) {
            this.f11964b.getLayoutManager().m17299a(accessibilityNodeInfoCompat);
        }
    }

    public final void mo1505d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo1505d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m17651c(this)) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().mo2308a(accessibilityEvent);
            }
        }
    }

    final AccessibilityDelegateCompat m17654b() {
        return this.f11965c;
    }
}
