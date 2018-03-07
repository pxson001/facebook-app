package com.facebook.messaging.ui.threaditem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;

/* compiled from: pinned_posts */
public class ThreadItemDividerDrawer {
    private int f4888a;
    private int f4889b;
    private int f4890c;
    private int f4891d;
    private Paint f4892e;

    public static ThreadItemDividerDrawer m4412a(InjectorLike injectorLike) {
        return new ThreadItemDividerDrawer();
    }

    public final void m4413a(Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThreadItemView, i, 0);
        this.f4888a = obtainStyledAttributes.getColor(0, 0);
        this.f4889b = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f4890c = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.f4891d = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
        obtainStyledAttributes.recycle();
        if (this.f4889b > 0) {
            this.f4892e = new Paint();
            this.f4892e.setColor(this.f4888a);
            return;
        }
        this.f4892e = null;
    }

    public final boolean m4415a() {
        return this.f4892e != null;
    }

    public final void m4414a(Canvas canvas, int i, int i2) {
        if (this.f4892e != null) {
            canvas.drawRect((float) this.f4890c, (float) (i2 - this.f4889b), (float) (i - this.f4891d), (float) i2, this.f4892e);
        }
    }
}
