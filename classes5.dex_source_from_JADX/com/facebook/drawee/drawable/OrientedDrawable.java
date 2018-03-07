package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;

/* compiled from: [SuffixTransformer(' */
public class OrientedDrawable extends ForwardingDrawable {
    @VisibleForTesting
    final Matrix f11902a;
    private int f11903c;
    private final Matrix f11904d = new Matrix();
    private final RectF f11905e = new RectF();

    public OrientedDrawable(Drawable drawable, int i) {
        super(drawable);
        Preconditions.a(i % 90 == 0);
        this.f11902a = new Matrix();
        this.f11903c = i;
    }

    public void draw(Canvas canvas) {
        if (this.f11903c <= 0) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.concat(this.f11902a);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    public int getIntrinsicWidth() {
        return this.f11903c % 180 == 0 ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    public int getIntrinsicHeight() {
        return this.f11903c % 180 == 0 ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    protected void onBoundsChange(Rect rect) {
        Drawable current = getCurrent();
        if (this.f11903c > 0) {
            this.f11902a.setRotate((float) this.f11903c, (float) rect.centerX(), (float) rect.centerY());
            this.f11904d.reset();
            this.f11902a.invert(this.f11904d);
            this.f11905e.set(rect);
            this.f11904d.mapRect(this.f11905e);
            current.setBounds((int) this.f11905e.left, (int) this.f11905e.top, (int) this.f11905e.right, (int) this.f11905e.bottom);
            return;
        }
        current.setBounds(rect);
    }

    public final void m19948a(Matrix matrix) {
        b(matrix);
        if (!this.f11902a.isIdentity()) {
            matrix.preConcat(this.f11902a);
        }
    }
}
