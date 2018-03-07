package com.facebook.widget.tiles;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.common.util.SizeUtil;
import com.facebook.widget.images.PathBoundShape;
import com.facebook.widget.images.PathFittingBitmapShaderFactory;
import com.google.common.base.Preconditions;

/* compiled from: com.facebook.tagging.conversion.FriendSuggestionsAndSelectorActivity */
public class ThreadTileDrawable extends Drawable implements Callback {
    private static final int f19920a = Color.argb(127, 255, 255, 255);
    private static final int f19921b = Color.rgb(238, 238, 238);
    public DrawableShape f19922c = DrawableShape.SQUARE;
    private final Paint f19923d;
    public float f19924e;
    public float f19925f;
    private int f19926g = 255;
    private ColorFilter f19927h;
    public ShapeDrawable[] f19928i;
    public int f19929j = 0;

    /* compiled from: com.facebook.tagging.conversion.FriendSuggestionsAndSelectorActivity */
    public enum DrawableShape {
        SQUARE,
        CIRCLE,
        FILLED_ROUND_RECT
    }

    public ThreadTileDrawable(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThreadTileDrawable, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(3, false);
        float f = obtainStyledAttributes.getFloat(2, 0.0f);
        obtainStyledAttributes.recycle();
        if (f > 0.0f) {
            this.f19924e = f;
        } else {
            this.f19924e = 0.6666667f;
        }
        if (z) {
            m28653a();
        }
        this.f19923d = new Paint();
        this.f19923d.setStrokeWidth((float) SizeUtil.a(context, 1.0f));
        this.f19923d.setColor(f19920a);
        this.f19928i = new ShapeDrawable[3];
    }

    public final void m28653a() {
        Preconditions.checkState(this.f19929j == 0);
        this.f19922c = DrawableShape.CIRCLE;
        this.f19924e = 0.5f;
    }

    public final void m28654a(int i) {
        int i2 = 1;
        boolean z = i >= 0 && i <= this.f19928i.length;
        Preconditions.checkArgument(z);
        if (i != this.f19929j) {
            m28652g();
            while (i2 < this.f19928i.length) {
                if (i2 >= i) {
                    this.f19928i[i2] = null;
                } else if (this.f19928i[i2] == null) {
                    this.f19928i[i2] = m28648c();
                }
                i2++;
            }
            this.f19929j = i;
            switch (this.f19922c) {
                case CIRCLE:
                    m28650e();
                    return;
                case FILLED_ROUND_RECT:
                    m28649d();
                    return;
                default:
                    m28651f();
                    return;
            }
        }
    }

    public final void m28655a(int i, Bitmap bitmap) {
        boolean z = i >= 0 && i < this.f19929j && bitmap != null;
        Preconditions.checkArgument(z);
        ShapeDrawable shapeDrawable = this.f19928i[i];
        Shape shape = shapeDrawable.getShape();
        shapeDrawable.setShaderFactory(new PathFittingBitmapShaderFactory(shape instanceof PathBoundShape ? (PathBoundShape) shape : null, bitmap));
        shapeDrawable.setShape(shape);
    }

    private ShapeDrawable m28648c() {
        Shape mutableArcShape;
        switch (this.f19922c) {
            case CIRCLE:
                mutableArcShape = new MutableArcShape(90.0f, 360.0f);
                break;
            case FILLED_ROUND_RECT:
                mutableArcShape = new BetterRoundRectShape(new float[]{this.f19925f, this.f19925f, this.f19925f, this.f19925f, this.f19925f, this.f19925f, this.f19925f, this.f19925f}, null, null);
                break;
            default:
                mutableArcShape = new RectShape();
                break;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(mutableArcShape);
        shapeDrawable.setCallback(this);
        shapeDrawable.setAlpha(this.f19926g);
        shapeDrawable.setColorFilter(this.f19927h);
        shapeDrawable.setBounds(getBounds());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(f19921b);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        return shapeDrawable;
    }

    private void m28649d() {
        Preconditions.checkState(this.f19922c == DrawableShape.FILLED_ROUND_RECT);
        switch (this.f19929j) {
            case 0:
            case 1:
                m28647a(0, new float[]{this.f19925f, this.f19925f, this.f19925f, this.f19925f, this.f19925f, this.f19925f, this.f19925f, this.f19925f});
                return;
            case 2:
                m28647a(0, new float[]{this.f19925f, this.f19925f, 0.0f, 0.0f, 0.0f, 0.0f, this.f19925f, this.f19925f});
                m28647a(1, new float[]{0.0f, 0.0f, this.f19925f, this.f19925f, this.f19925f, this.f19925f, 0.0f, 0.0f});
                return;
            default:
                m28647a(0, new float[]{this.f19925f, this.f19925f, 0.0f, 0.0f, 0.0f, 0.0f, this.f19925f, this.f19925f});
                m28647a(1, new float[]{0.0f, 0.0f, this.f19925f, this.f19925f, 0.0f, 0.0f, 0.0f, 0.0f});
                m28647a(2, new float[]{0.0f, 0.0f, 0.0f, 0.0f, this.f19925f, this.f19925f, 0.0f, 0.0f});
                return;
        }
    }

    private void m28650e() {
        Preconditions.checkState(this.f19922c == DrawableShape.CIRCLE);
        switch (this.f19929j) {
            case 0:
            case 1:
                m28646a(0, 90.0f, 360.0f);
                return;
            case 2:
                m28646a(0, 90.0f, 180.0f);
                m28646a(1, 270.0f, 180.0f);
                return;
            default:
                m28646a(0, 90.0f, 180.0f);
                m28646a(1, 270.0f, 90.0f);
                m28646a(2, 0.0f, 90.0f);
                return;
        }
    }

    private void m28647a(int i, float[] fArr) {
        boolean z = true;
        boolean z2 = i == 0 || (i >= 0 && i < this.f19929j);
        Preconditions.checkArgument(z2);
        if (fArr == null || fArr.length == 8) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (this.f19922c != DrawableShape.FILLED_ROUND_RECT) {
            z = false;
        }
        Preconditions.checkState(z);
        ShapeDrawable shapeDrawable = this.f19928i[i];
        BetterRoundRectShape betterRoundRectShape = (BetterRoundRectShape) shapeDrawable.getShape();
        betterRoundRectShape.m28627a(fArr);
        shapeDrawable.setShape(betterRoundRectShape);
    }

    private void m28646a(int i, float f, float f2) {
        boolean z = true;
        boolean z2 = i == 0 || (i >= 0 && i < this.f19929j);
        Preconditions.checkArgument(z2);
        if (this.f19922c != DrawableShape.CIRCLE) {
            z = false;
        }
        Preconditions.checkState(z);
        ShapeDrawable shapeDrawable = this.f19928i[i];
        MutableArcShape mutableArcShape = (MutableArcShape) shapeDrawable.getShape();
        if (mutableArcShape.m28645a(f, f2)) {
            shapeDrawable.setShape(mutableArcShape);
        }
    }

    private void m28651f() {
        Preconditions.checkState(this.f19922c == DrawableShape.SQUARE);
        m28652g();
        Rect bounds = getBounds();
        int width = (int) (((float) bounds.left) + (((float) bounds.width()) * this.f19924e));
        switch (this.f19929j) {
            case 0:
            case 1:
                this.f19928i[0].setBounds(bounds);
                return;
            case 2:
                this.f19928i[0].setBounds(bounds.left, bounds.top, width, bounds.bottom);
                this.f19928i[1].setBounds(width, bounds.top, bounds.right, bounds.bottom);
                return;
            default:
                this.f19928i[0].setBounds(bounds.left, bounds.top, width, bounds.bottom);
                this.f19928i[1].setBounds(width, bounds.top, bounds.right, bounds.centerY());
                this.f19928i[2].setBounds(width, bounds.centerY(), bounds.right, bounds.bottom);
                return;
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        switch (this.f19922c) {
            case CIRCLE:
                for (ShapeDrawable shapeDrawable : this.f19928i) {
                    if (shapeDrawable != null) {
                        shapeDrawable.setBounds(i, i2, i3, i4);
                    }
                }
                return;
            case FILLED_ROUND_RECT:
                m28649d();
                return;
            default:
                m28651f();
                return;
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        Rect bounds = getBounds();
        m28652g();
        for (ShapeDrawable shapeDrawable : this.f19928i) {
            if (shapeDrawable != null) {
                shapeDrawable.draw(canvas);
            }
        }
        if (this.f19929j > 1) {
            i = bounds.left;
            int i3 = bounds.top;
            i2 = bounds.right;
            int i4 = bounds.bottom;
            int i5 = i + ((int) (((float) (i2 - i)) * this.f19924e));
            int i6 = i3 + ((i4 - i3) / 2);
            canvas.drawLine((float) i5, (float) i3, (float) i5, (float) i4, this.f19923d);
            if (this.f19929j > 2) {
                canvas.drawLine((float) i5, (float) i6, (float) i4, (float) i6, this.f19923d);
            }
        }
    }

    private void m28652g() {
        if (this.f19928i[0] == null) {
            this.f19928i[0] = m28648c();
        }
    }

    public void setAlpha(int i) {
        this.f19926g = i;
        for (ShapeDrawable shapeDrawable : this.f19928i) {
            if (shapeDrawable != null) {
                shapeDrawable.setAlpha(i);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f19927h = colorFilter;
        for (ShapeDrawable shapeDrawable : this.f19928i) {
            if (shapeDrawable != null) {
                shapeDrawable.setColorFilter(colorFilter);
            }
        }
    }

    public int getOpacity() {
        int i = 0;
        for (ShapeDrawable shapeDrawable : this.f19928i) {
            if (shapeDrawable != null) {
                i = Drawable.resolveOpacity(i, shapeDrawable.getOpacity());
            }
        }
        return i;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
