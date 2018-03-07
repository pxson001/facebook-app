package com.facebook.fbui.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.AttributeSet;
import com.facebook.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: parts */
public class TextureRegionDrawable extends Drawable implements NetworkDrawable$BitmapLoadedListener {
    private static final Paint f5342a = new Paint(6);
    private static final RectF f5343b = new RectF();
    private DrawableState f5344c;
    private boolean f5345d;

    /* compiled from: parts */
    class DrawableState extends ConstantState {
        Bitmap f5346a;
        Paint f5347b;
        int f5348c;
        int f5349d;
        int f5350e;
        int f5351f;
        int f5352g;
        int f5353h;
        float f5354i;
        NetworkDrawable f5355j;
        final Rect f5356k;
        ConstantState f5357l;

        public DrawableState(DrawableState drawableState) {
            if (drawableState != null) {
                this.f5346a = drawableState.f5346a;
                this.f5347b = drawableState.f5347b != null ? new Paint(drawableState.f5347b) : null;
                this.f5348c = drawableState.f5348c;
                this.f5349d = drawableState.f5349d;
                this.f5350e = drawableState.f5350e;
                this.f5351f = drawableState.f5351f;
                this.f5352g = drawableState.f5352g;
                this.f5353h = drawableState.f5353h;
                this.f5356k = drawableState.f5356k;
                this.f5354i = drawableState.f5354i;
                this.f5357l = drawableState.f5357l;
                this.f5355j = drawableState.f5355j;
                return;
            }
            this.f5356k = new Rect();
        }

        public Drawable newDrawable() {
            return new TextureRegionDrawable(this);
        }

        public int getChangingConfigurations() {
            return 0;
        }
    }

    public TextureRegionDrawable() {
        this(new DrawableState(null));
    }

    public TextureRegionDrawable(DrawableState drawableState) {
        this.f5345d = false;
        this.f5344c = drawableState;
        if (drawableState != null && drawableState.f5346a == null && drawableState.f5355j != null) {
            drawableState.f5355j.a(this);
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        f5343b.set(((float) bounds.left) + (((float) this.f5344c.f5348c) * this.f5344c.f5354i), ((float) bounds.top) + (((float) this.f5344c.f5349d) * this.f5344c.f5354i), ((float) bounds.right) - (((float) this.f5344c.f5350e) * this.f5344c.f5354i), ((float) bounds.bottom) - (((float) this.f5344c.f5351f) * this.f5344c.f5354i));
        if (this.f5344c.f5346a != null) {
            canvas.drawBitmap(this.f5344c.f5346a, this.f5344c.f5356k, f5343b, m5848a());
        }
    }

    public Drawable mutate() {
        if (!this.f5345d && super.mutate() == this) {
            this.f5344c = new DrawableState(this.f5344c);
            this.f5345d = true;
        }
        return this;
    }

    public void setAlpha(int i) {
        m5849b().setAlpha(i);
        invalidateSelf();
    }

    public int getAlpha() {
        return m5848a().getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        m5849b().setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return m5848a().getColorFilter();
    }

    public int getOpacity() {
        Bitmap bitmap = this.f5344c.f5346a;
        if (bitmap == null || bitmap.hasAlpha() || getAlpha() < 255) {
            return -3;
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        return (int) Math.ceil((double) (((float) ((this.f5344c.f5348c + this.f5344c.f5350e) + this.f5344c.f5356k.width())) * this.f5344c.f5354i));
    }

    public int getIntrinsicHeight() {
        return (int) Math.ceil((double) (((float) ((this.f5344c.f5349d + this.f5344c.f5351f) + this.f5344c.f5356k.height())) * this.f5344c.f5354i));
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.TextureRegionDrawable);
        int dimensionPixelSize = obtainAttributes.getDimensionPixelSize(2, 0);
        int dimensionPixelSize2 = obtainAttributes.getDimensionPixelSize(3, 0);
        int dimensionPixelSize3 = obtainAttributes.getDimensionPixelSize(4, 0);
        int dimensionPixelSize4 = obtainAttributes.getDimensionPixelSize(5, 0);
        int dimensionPixelSize5 = obtainAttributes.getDimensionPixelSize(6, 0);
        int dimensionPixelSize6 = obtainAttributes.getDimensionPixelSize(7, 0);
        int dimensionPixelSize7 = obtainAttributes.getDimensionPixelSize(8, 0);
        int dimensionPixelSize8 = obtainAttributes.getDimensionPixelSize(9, 0);
        int dimensionPixelSize9 = obtainAttributes.getDimensionPixelSize(10, 0);
        int dimensionPixelSize10 = obtainAttributes.getDimensionPixelSize(11, 0);
        int integer = obtainAttributes.getInteger(0, 0);
        int i = resources.getDisplayMetrics().densityDpi;
        this.f5344c.f5354i = ((float) i) / ((float) integer);
        Drawable drawableForDensity = resources.getDrawableForDensity(obtainAttributes.getResourceId(1, 0), integer);
        obtainAttributes.recycle();
        boolean z = drawableForDensity instanceof BitmapDrawable;
        if (z || (drawableForDensity instanceof NetworkDrawable)) {
            this.f5344c.f5348c = dimensionPixelSize5;
            this.f5344c.f5349d = dimensionPixelSize6;
            this.f5344c.f5350e = dimensionPixelSize7;
            this.f5344c.f5351f = dimensionPixelSize8;
            this.f5344c.f5356k.set(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
            this.f5344c.f5353h = dimensionPixelSize9;
            this.f5344c.f5352g = dimensionPixelSize10;
            if (z) {
                this.f5344c.f5346a = ((BitmapDrawable) drawableForDensity).getBitmap();
                this.f5344c.f5357l = drawableForDensity.getConstantState();
                if (this.f5344c.f5346a.getWidth() != this.f5344c.f5353h || this.f5344c.f5346a.getHeight() != this.f5344c.f5352g) {
                    this.f5344c.f5346a = Bitmap.createScaledBitmap(this.f5344c.f5346a, this.f5344c.f5353h, this.f5344c.f5352g, true);
                    return;
                }
                return;
            }
            this.f5344c.f5355j = (NetworkDrawable) drawableForDensity;
            this.f5344c.f5355j.a(this);
            return;
        }
        throw new XmlPullParserException("app-region.atlas should resolve to a BitmapDrawable or NetworkDrawable");
    }

    public ConstantState getConstantState() {
        return this.f5344c;
    }

    private Paint m5848a() {
        return this.f5344c.f5347b == null ? f5342a : this.f5344c.f5347b;
    }

    private Paint m5849b() {
        if (this.f5344c.f5347b == null) {
            this.f5344c.f5347b = new Paint(f5342a);
        }
        return this.f5344c.f5347b;
    }

    public final void mo520a(Bitmap bitmap) {
        this.f5344c.f5346a = bitmap;
        invalidateSelf();
    }
}
