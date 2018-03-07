package com.facebook.uicontrib.fab;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.fbui.glyph.GlyphColorizer;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mComposerSessionId */
public class FabDrawable extends Drawable {
    private static final FabType f9539c = FabType.BIG;
    private static final int f9540d = 2131361916;
    protected final Resources f9541a;
    @Nullable
    protected Drawable f9542b;
    private final GlyphColorizer f9543e;
    public FabType f9544f;
    private boolean f9545g = true;
    private Integer f9546h = Integer.valueOf(-1);
    private int f9547i = 0;
    @Nullable
    private Drawable f9548j;
    private final Paint f9549k = new Paint(1);
    private int f9550l;
    private final Rect f9551m = new Rect();

    /* compiled from: mComposerSessionId */
    public enum FabType {
        BIG(0, 2130839630, 2131427819),
        SMALL(1, 2130839631, 2131427818);
        
        private int attrEnumValue;
        public int fillSizeDimen;
        public int shadowDrawableResource;

        private FabType(int i, int i2, int i3) {
            this.attrEnumValue = i;
            this.shadowDrawableResource = i2;
            this.fillSizeDimen = i3;
        }

        public final int getAttrEnumValue() {
            return this.attrEnumValue;
        }

        public final int getFullSize(Resources resources) {
            return (int) (resources.getDimension(this.fillSizeDimen) + (2.0f * resources.getDimension(2131427817)));
        }

        public final int getFillRadius(Resources resources) {
            return ((int) resources.getDimension(this.fillSizeDimen)) / 2;
        }
    }

    @Inject
    public FabDrawable(Resources resources, GlyphColorizer glyphColorizer) {
        this.f9541a = resources;
        this.f9543e = glyphColorizer;
        m11227a(f9539c);
        this.f9549k.setColor(this.f9541a.getColor(f9540d));
    }

    public final void m11227a(FabType fabType) {
        this.f9544f = fabType;
        this.f9550l = (int) (this.f9541a.getDimension(this.f9544f.fillSizeDimen) / 2.0f);
        m11221b();
        m11222c();
    }

    private void m11221b() {
        if (this.f9545g) {
            this.f9542b = this.f9541a.getDrawable(this.f9544f.shadowDrawableResource);
            if (this.f9542b.getIntrinsicHeight() != this.f9542b.getIntrinsicWidth()) {
                throw new IllegalStateException("Shadow height is different than its width: width=" + this.f9542b.getIntrinsicWidth() + ", height=" + this.f9542b.getIntrinsicHeight());
            } else if (Math.abs(this.f9542b.getIntrinsicWidth() - this.f9544f.getFullSize(this.f9541a)) >= 2) {
                throw new IllegalStateException("Unexpected shadow width: Expected " + this.f9544f.getFullSize(this.f9541a) + " but is actually " + this.f9542b.getIntrinsicWidth());
            } else {
                this.f9542b.setBounds(m11224d(m11223d()));
                return;
            }
        }
        this.f9542b = null;
    }

    public final void m11228a(boolean z) {
        this.f9545g = z;
        m11221b();
    }

    public final void m11225a(int i) {
        this.f9549k.setColor(i);
    }

    public final void m11229b(int i) {
        this.f9546h = Integer.valueOf(i);
    }

    public final void m11230c(int i) {
        if (this.f9547i != i) {
            if (i == 0) {
                this.f9548j = null;
            } else {
                this.f9548j = this.f9541a.getDrawable(i);
                if (this.f9548j == null) {
                    throw new NullPointerException("mGlyphDrawable is null!");
                }
                this.f9548j.setColorFilter(this.f9543e.a(this.f9546h != null ? this.f9546h.intValue() : -1));
                m11222c();
            }
            this.f9547i = i;
        }
    }

    public final void m11226a(@Nullable Drawable drawable) {
        this.f9548j = drawable;
        if (this.f9548j != null) {
            m11222c();
        }
        this.f9547i = -1;
    }

    private void m11222c() {
        if (this.f9548j != null) {
            this.f9548j.setBounds(m11224d(this.f9548j.getIntrinsicHeight()));
        }
    }

    private Rect m11224d(int i) {
        int d = m11223d();
        this.f9551m.set((d - i) / 2, (d - i) / 2, (d + i) / 2, (d + i) / 2);
        return this.f9551m;
    }

    public int getIntrinsicHeight() {
        return m11223d();
    }

    public int getIntrinsicWidth() {
        return m11223d();
    }

    private int m11223d() {
        return this.f9545g ? this.f9544f.getFullSize(this.f9541a) : this.f9544f.getFillRadius(this.f9541a) * 2;
    }

    public void draw(Canvas canvas) {
        m11220a(canvas, false);
        if (this.f9542b != null) {
            this.f9542b.draw(canvas);
        }
        m11219a(canvas);
        if (this.f9548j != null) {
            this.f9548j.draw(canvas);
        }
        m11220a(canvas, true);
    }

    private void m11220a(Canvas canvas, boolean z) {
        Rect bounds = getBounds();
        int width = bounds.left + ((bounds.width() - getIntrinsicWidth()) / 2);
        int height = bounds.top + ((bounds.height() - getIntrinsicHeight()) / 2);
        canvas.translate(z ? (float) (-width) : (float) width, z ? (float) (-height) : (float) height);
    }

    private void m11219a(Canvas canvas) {
        int d = m11223d() / 2;
        canvas.drawCircle((float) d, (float) d, (float) this.f9550l, this.f9549k);
    }

    public void setAlpha(int i) {
        this.f9549k.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
