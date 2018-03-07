package com.facebook.react.uimanager;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.RadioButton;

/* compiled from: friend_finder_undo_invite_clicked */
public class AccessibilityHelper {
    private static final AccessibilityDelegate f11707a = new C10371();
    private static final AccessibilityDelegate f11708b = new C10382();
    private static final AccessibilityDelegate f11709c = new C10393();

    /* compiled from: friend_finder_undo_invite_clicked */
    final class C10371 extends AccessibilityDelegate {
        C10371() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(Button.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(Button.class.getName());
        }
    }

    /* compiled from: friend_finder_undo_invite_clicked */
    final class C10382 extends AccessibilityDelegate {
        C10382() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(RadioButton.class.getName());
            accessibilityEvent.setChecked(true);
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(RadioButton.class.getName());
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(true);
        }
    }

    /* compiled from: friend_finder_undo_invite_clicked */
    final class C10393 extends AccessibilityDelegate {
        C10393() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(RadioButton.class.getName());
            accessibilityEvent.setChecked(false);
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(RadioButton.class.getName());
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(false);
        }
    }

    AccessibilityHelper() {
    }

    public static void m13786a(View view, String str) {
        if (str == null) {
            view.setAccessibilityDelegate(null);
            return;
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1377687758:
                if (str.equals("button")) {
                    obj = null;
                    break;
                }
                break;
            case -1320494052:
                if (str.equals("radiobutton_unchecked")) {
                    obj = 2;
                    break;
                }
                break;
            case -714126251:
                if (str.equals("radiobutton_checked")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                view.setAccessibilityDelegate(f11707a);
                return;
            case 1:
                view.setAccessibilityDelegate(f11708b);
                return;
            case 2:
                view.setAccessibilityDelegate(f11709c);
                return;
            default:
                view.setAccessibilityDelegate(null);
                return;
        }
    }

    public static void m13785a(View view, int i) {
        view.sendAccessibilityEvent(i);
    }
}
