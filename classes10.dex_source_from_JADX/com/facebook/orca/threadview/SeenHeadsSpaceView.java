package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;
import com.facebook.messaging.threadview.rows.RowReceiptItem;
import com.facebook.orca.threadview.seenheads.SeenHeadsRowContainer;

/* compiled from: message_image */
public class SeenHeadsSpaceView extends View implements SeenHeadsRowContainer {
    private final int f7401a;
    private final int f7402b;
    private final int f7403c;
    private final int f7404d;
    private final int f7405e;
    private RowReceiptItem f7406f;

    public SeenHeadsSpaceView(Context context) {
        super(context);
        Resources resources = context.getResources();
        this.f7401a = resources.getDimensionPixelSize(2131428631);
        this.f7402b = resources.getDimensionPixelOffset(2131428633);
        this.f7403c = resources.getDimensionPixelSize(2131428634);
        this.f7404d = resources.getDimensionPixelSize(2131428635);
        this.f7405e = resources.getDimensionPixelSize(2131428636);
    }

    public void setRowReceiptItem(RowReceiptItem rowReceiptItem) {
        int i = 0;
        this.f7406f = rowReceiptItem;
        int i2 = (this.f7406f.f4759b == null || this.f7406f.f4759b.isEmpty()) ? 0 : 1;
        if (i2 != 0) {
            i = getResources().getDimensionPixelOffset(2131428632);
        }
        if (i != getSuggestedMinimumHeight()) {
            setMinimumHeight(i);
        }
    }

    public void draw(Canvas canvas) {
    }

    private int getSeenHeadCount() {
        return this.f7406f.f4759b != null ? Math.min(this.f7406f.f4759b.size(), getMaxSeenHeadCount()) : 0;
    }

    public int getBaseSeenHeadRightMarginPx() {
        return this.f7403c;
    }

    public int getBaseSeenHeadBottomMarginPx() {
        return this.f7404d;
    }

    public int getSeenHeadSpacingPx() {
        return this.f7405e;
    }

    public int getMaxSeenHeadCount() {
        return Math.min((getWidth() - this.f7402b) / (this.f7401a + this.f7405e), 14);
    }
}
