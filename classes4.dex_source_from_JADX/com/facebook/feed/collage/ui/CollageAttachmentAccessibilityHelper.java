package com.facebook.feed.collage.ui;

import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import java.util.List;

/* compiled from: notag */
public class CollageAttachmentAccessibilityHelper extends ExploreByTouchHelper {
    private final Rect f6977b = new Rect();
    private final CollageAttachmentView f6978c;

    public CollageAttachmentAccessibilityHelper(CollageAttachmentView collageAttachmentView) {
        super(collageAttachmentView);
        this.f6978c = collageAttachmentView;
    }

    protected final int m7270a(float f, float f2) {
        int i = Integer.MIN_VALUE;
        int visibleAttachmentsCount = this.f6978c.getVisibleAttachmentsCount();
        for (int i2 = 0; i2 < visibleAttachmentsCount; i2++) {
            if (this.f6978c.m6806e(i2).contains((int) f, (int) f2)) {
                i = i2;
            }
        }
        return i;
    }

    protected final void m7273a(List<Integer> list) {
        int i = 0;
        int visibleAttachmentsCount = this.f6978c.getVisibleAttachmentsCount();
        while (i < visibleAttachmentsCount) {
            if (this.f6978c.m6803c(i) != null && this.f6978c.m6807f(i)) {
                list.add(Integer.valueOf(i));
            }
            i++;
        }
    }

    private CharSequence m7269b(int i) {
        int visibleAttachmentsCount = this.f6978c.getVisibleAttachmentsCount();
        int i2 = i + 1;
        if (this.f6978c.f6329l > 1) {
            if (i2 == visibleAttachmentsCount) {
                return this.f6978c.getResources().getString(2131235682, new Object[]{Integer.valueOf(r1)});
            }
            visibleAttachmentsCount--;
        }
        String[] strArr = this.f6978c.f6335r;
        if (strArr == null || strArr[i] == null) {
            return this.f6978c.getResources().getString(2131235681, new Object[]{Integer.valueOf(i2), Integer.valueOf(visibleAttachmentsCount)});
        }
        return this.f6978c.getResources().getString(2131235683, new Object[]{Integer.valueOf(i2), Integer.valueOf(visibleAttachmentsCount), strArr[i]});
    }

    private Rect m7268a(int i, Rect rect) {
        Rect c = this.f6978c.m6803c(i);
        Rect rect2 = new Rect(c.left + this.f6978c.getPaddingLeft(), c.top + this.f6978c.getPaddingTop(), c.right + this.f6978c.getPaddingLeft(), c.bottom + this.f6978c.getPaddingTop());
        if (rect == null) {
            return rect2;
        }
        rect.set(rect2);
        return rect;
    }

    protected final void m7272a(int i, AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setContentDescription(m7269b(i));
    }

    protected final void m7271a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (i < this.f6978c.getVisibleAttachmentsCount()) {
            CharSequence b = m7269b(i);
            m7268a(i, this.f6977b);
            accessibilityNodeInfoCompat.b(this.f6977b);
            accessibilityNodeInfoCompat.d(b);
            accessibilityNodeInfoCompat.a(16);
            accessibilityNodeInfoCompat.f(true);
            accessibilityNodeInfoCompat.b(Button.class.getName());
        }
    }

    protected final boolean m7274b(int i, int i2) {
        return false;
    }
}
