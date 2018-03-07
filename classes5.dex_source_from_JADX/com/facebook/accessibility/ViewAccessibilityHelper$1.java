package com.facebook.accessibility;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: bd_hovercard */
class ViewAccessibilityHelper$1 extends AccessibilityDelegate {
    final /* synthetic */ int f8001a;
    final /* synthetic */ View f8002b;
    final /* synthetic */ ViewAccessibilityHelper f8003c;

    ViewAccessibilityHelper$1(ViewAccessibilityHelper viewAccessibilityHelper, int i, View view) {
        this.f8003c = viewAccessibilityHelper;
        this.f8001a = i;
        this.f8002b = view;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (this.f8001a == 2 && (view instanceof ViewGroup)) {
            this.f8002b.setTag(2131558568, Boolean.valueOf(this.f8002b.isClickable()));
            this.f8002b.setTag(2131558569, Boolean.valueOf(this.f8002b.isFocusable()));
            this.f8002b.setTag(2131558570, Boolean.valueOf(this.f8002b.isLongClickable()));
            this.f8002b.setTag(2131558571, this.f8002b.getContentDescription());
            this.f8002b.setClickable(false);
            this.f8002b.setFocusable(false);
            this.f8002b.setLongClickable(false);
            this.f8002b.setContentDescription(null);
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (this.f8001a == 4 || viewGroup == null) {
            return false;
        }
        return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void sendAccessibilityEvent(View view, int i) {
        if (i != 32768 && i != 128) {
            super.sendAccessibilityEvent(view, i);
        }
    }
}
