package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;

/* compiled from: graph.secure */
public class MatrixDrawable extends ForwardingDrawable {
    private Matrix f22036a;
    private Matrix f22037c;
    private int f22038d = 0;
    private int f22039e = 0;

    public MatrixDrawable(Drawable drawable, Matrix matrix) {
        super((Drawable) Preconditions.a(drawable));
        this.f22036a = matrix;
    }

    public final Drawable mo2744b(Drawable drawable) {
        Drawable b = super.mo2744b(drawable);
        m29804c();
        return b;
    }

    public void draw(Canvas canvas) {
        m29803b();
        if (this.f22037c != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.f22037c);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m29804c();
    }

    private void m29803b() {
        if (this.f22038d != getCurrent().getIntrinsicWidth() || this.f22039e != getCurrent().getIntrinsicHeight()) {
            m29804c();
        }
    }

    private void m29804c() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.f22038d = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.f22039e = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.f22037c = null;
            return;
        }
        current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.f22037c = this.f22036a;
    }

    public final void mo2741a(Matrix matrix) {
        super.mo2741a(matrix);
        if (this.f22037c != null) {
            matrix.preConcat(this.f22037c);
        }
    }
}
