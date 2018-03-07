package com.facebook.user.tiles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* compiled from: contributor_pic_width */
public class BorderedUserTileView extends UserTileView {
    private int f18471c;

    public BorderedUserTileView(Context context) {
        this(context, null);
    }

    public BorderedUserTileView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BorderedUserTileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18471c = getResources().getDimensionPixelSize(2131430730);
        this.a.a(true);
    }

    protected final void m27086a(Canvas canvas, Drawable drawable) {
        if (this.b) {
            this.a.a(getWidth(), getHeight(), getPaddingLeft() + this.f18471c, getPaddingTop() + this.f18471c, getPaddingRight() + this.f18471c, getPaddingBottom() + this.f18471c);
            this.b = false;
        }
        Rect bounds = this.a.n.getBounds();
        Paint paint = new Paint(1);
        paint.setStyle(Style.FILL);
        paint.setColor(getResources().getColor(2131363189));
        canvas.drawCircle((float) bounds.centerX(), (float) bounds.centerY(), (float) (getWidth() / 2), paint);
        drawable.draw(canvas);
    }
}
