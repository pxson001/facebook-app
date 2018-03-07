package com.facebook.widget.tiles;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RectShape;
import com.facebook.widget.images.PathBoundShape;

/* compiled from: com.facebook.tagging.conversion.FriendSuggestionsAndSelectorFragment */
class MutableArcShape extends RectShape implements PathBoundShape {
    private float f19914a;
    private float f19915b;
    private Path f19916c = new Path();
    private boolean f19917d;
    private RectF f19918e = new RectF();

    public MutableArcShape(float f, float f2) {
        m28645a(f, f2);
    }

    public final boolean m28645a(float f, float f2) {
        if (this.f19914a == f && this.f19915b == f2) {
            return false;
        }
        this.f19914a = f;
        this.f19915b = f2;
        this.f19917d = true;
        return true;
    }

    public final void mo1515a(RectF rectF) {
        if (this.f19917d) {
            this.f19916c.reset();
            this.f19916c.addArc(rect(), this.f19914a, this.f19915b);
            this.f19916c.computeBounds(this.f19918e, true);
        }
        rectF.set(this.f19918e);
    }

    protected void onResize(float f, float f2) {
        super.onResize(f, f2);
        this.f19917d = true;
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawArc(rect(), this.f19914a, this.f19915b, true, paint);
    }
}
