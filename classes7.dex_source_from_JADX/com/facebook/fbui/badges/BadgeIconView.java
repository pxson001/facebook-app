package com.facebook.fbui.badges;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.text.ResourceTextLayoutHelper;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;

/* compiled from: sprout_cancel */
public class BadgeIconView extends GlyphView {
    private CharSequence f3530b;
    private Drawable f3531c;
    private int f3532d;
    private int f3533e;
    private Layout f3534f;
    private final TextLayoutBuilder f3535g;
    private final Rect f3536h;

    public BadgeIconView(Context context) {
        this(context, null);
    }

    public BadgeIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BadgeIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3536h = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BadgeIconView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        this.f3531c = obtainStyledAttributes.getDrawable(0);
        this.f3532d = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.f3533e = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
        obtainStyledAttributes.recycle();
        this.f3535g = new TextLayoutBuilder();
        this.f3535g.e = false;
        this.f3535g.f = false;
        this.f3535g.a(Integer.MAX_VALUE);
        setBadgeTextAppearance(resourceId);
    }

    public CharSequence getBadgeText() {
        return this.f3530b;
    }

    public void setBadgeText(CharSequence charSequence) {
        if (!TextUtils.equals(this.f3530b, charSequence)) {
            this.f3530b = charSequence;
            this.f3535g.a(this.f3530b);
            invalidate();
            requestLayout();
        }
    }

    public void setBadgeTextAppearance(int i) {
        ResourceTextLayoutHelper.a(this.f3535g, getContext(), i);
    }

    public void setBadgeBackground(Drawable drawable) {
        this.f3531c = drawable;
        if (this.f3531c != null) {
            this.f3531c.setCallback(this);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(this.f3530b)) {
            this.f3534f = null;
        } else {
            this.f3534f = this.f3535g.d();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3534f != null && this.f3531c != null) {
            int a = m4222a(this.f3534f);
            int height = this.f3534f.getHeight();
            int i5 = (i3 - i) / 2;
            int i6 = (i4 - i2) / 2;
            this.f3531c.getPadding(this.f3536h);
            this.f3531c.setBounds(this.f3532d + i5, (((i6 - this.f3533e) - height) - this.f3536h.top) - this.f3536h.bottom, ((a + (i5 + this.f3532d)) + this.f3536h.left) + this.f3536h.right, i6 - this.f3533e);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!(this.f3531c == null || this.f3534f == null)) {
            this.f3531c.draw(canvas);
        }
        if (this.f3534f != null) {
            int width = ((getWidth() / 2) + this.f3532d) + this.f3536h.left;
            int height = (((getHeight() / 2) - this.f3533e) - this.f3534f.getHeight()) - this.f3536h.bottom;
            canvas.translate((float) width, (float) height);
            this.f3534f.draw(canvas);
            canvas.translate((float) (-width), (float) (-height));
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f3531c || super.verifyDrawable(drawable);
    }

    private static int m4222a(Layout layout) {
        int i = 0;
        if (layout == null) {
            return 0;
        }
        int i2 = 0;
        while (i < layout.getLineCount()) {
            i2 = Math.max((int) layout.getLineWidth(i), i2);
            i++;
        }
        return i2;
    }
}
