package com.facebook.photos.pandora.common.ui.views;

import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.accessibility.AccessibilityHelper;

/* compiled from: com.google.android.gms.cast.EXTRA_CAST_FLAGS */
public class PandoraAccessibilityHelper extends AccessibilityHelper<BasePandoraMultiMediaRowView> {
    public final Rect f17534b = new Rect();
    public final int[] f17535c = new int[2];
    private final BasePandoraMultiMediaRowView f17536d;

    public PandoraAccessibilityHelper(BasePandoraMultiMediaRowView basePandoraMultiMediaRowView) {
        super(basePandoraMultiMediaRowView);
        this.f17536d = basePandoraMultiMediaRowView;
    }

    protected final int m21503a(float f, float f2) {
        int a = this.f17536d.m21497a((int) f, (int) f2);
        return a != -1 ? a : -1;
    }

    protected final void m21505a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Object obj = this.f17536d;
        int numOfItems = obj.getNumOfItems();
        for (int i = 0; i < numOfItems; i++) {
            accessibilityNodeInfoCompat.c(obj, i);
        }
    }

    protected final void m21504a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ThumbnailEntry thumbnailEntry;
        BasePandoraMultiMediaRowView basePandoraMultiMediaRowView = this.f17536d;
        if (i < 0 || i >= basePandoraMultiMediaRowView.getNumOfItems()) {
            thumbnailEntry = null;
        } else {
            thumbnailEntry = basePandoraMultiMediaRowView.f17523l[i];
        }
        ThumbnailEntry thumbnailEntry2 = thumbnailEntry;
        if (thumbnailEntry2 != null) {
            accessibilityNodeInfoCompat.d(this.f17536d);
            accessibilityNodeInfoCompat.a(1);
            accessibilityNodeInfoCompat.a(16);
            BasePandoraMultiMediaRowView basePandoraMultiMediaRowView2 = this.f17536d;
            if (thumbnailEntry2.f17567b != null) {
                basePandoraMultiMediaRowView2.getLocationOnScreen(this.f17535c);
                int i2 = this.f17535c[0];
                int i3 = this.f17535c[1];
                this.f17534b.set(thumbnailEntry2.f17567b.left + i2, thumbnailEntry2.f17567b.top + i3, i2 + thumbnailEntry2.f17567b.right, i3 + thumbnailEntry2.f17567b.bottom);
                accessibilityNodeInfoCompat.d(this.f17534b);
            }
            accessibilityNodeInfoCompat.d(thumbnailEntry2.f17573h);
            accessibilityNodeInfoCompat.c(true);
            accessibilityNodeInfoCompat.a(true);
            accessibilityNodeInfoCompat.f(true);
            accessibilityNodeInfoCompat.h(true);
        }
    }
}
