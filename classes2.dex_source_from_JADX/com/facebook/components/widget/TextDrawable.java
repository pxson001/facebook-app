package com.facebook.components.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.components.TextContent;
import com.facebook.components.Touchable;
import com.facebook.fbui.widget.text.LayoutMeasureUtil;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: friends/immersivepymk */
public class TextDrawable extends Drawable implements TextContent, Touchable {
    public Layout f23044a;
    public float f23045c;
    public boolean f23046d;
    public CharSequence f23047e;
    public ColorStateList f23048f;
    public int f23049g;
    public int f23050h;
    public ClickableSpan[] f23051i;
    public int f23052j;
    public int f23053k;
    public Path f23054l;
    private Path f23055m;
    public boolean f23056n;
    private Paint f23057o;

    public void draw(Canvas canvas) {
        if (this.f23044a != null) {
            Rect bounds = getBounds();
            canvas.translate((float) bounds.left, ((float) bounds.top) + this.f23045c);
            Layout layout = this.f23044a;
            Path path = null;
            if (!(this.f23052j == this.f23053k || Color.alpha(this.f23050h) == 0)) {
                if (this.f23056n) {
                    if (this.f23054l == null) {
                        this.f23054l = new Path();
                    }
                    this.f23044a.getSelectionPath(this.f23052j, this.f23053k, this.f23054l);
                    this.f23056n = false;
                }
                path = this.f23054l;
            }
            layout.draw(canvas, path, this.f23057o, 0);
            canvas.translate((float) (-bounds.left), ((float) (-bounds.top)) - this.f23045c);
        }
    }

    public boolean isStateful() {
        return this.f23048f != null;
    }

    protected boolean onStateChange(int[] iArr) {
        if (!(this.f23048f == null || this.f23044a == null)) {
            int color = this.f23044a.getPaint().getColor();
            int colorForState = this.f23048f.getColorForState(iArr, this.f23049g);
            if (colorForState != color) {
                this.f23044a.getPaint().setColor(colorForState);
                invalidateSelf();
            }
        }
        return super.onStateChange(iArr);
    }

    public final boolean mo3376a(MotionEvent motionEvent, View view) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3) {
            m31175d();
            return false;
        }
        ClickableSpan clickableSpan;
        ClickableSpan clickableSpan2;
        Rect bounds = getBounds();
        int x = ((int) motionEvent.getX()) - bounds.left;
        int y = ((int) motionEvent.getY()) - bounds.top;
        float applyDimension = TypedValue.applyDimension(2, 18.0f, view.getResources().getDisplayMetrics());
        int lineForVertical = this.f23044a.getLineForVertical(y);
        if (((float) x) >= this.f23044a.getLineLeft(lineForVertical) && ((float) x) <= this.f23044a.getLineRight(lineForVertical)) {
            int offsetForHorizontal = this.f23044a.getOffsetForHorizontal(lineForVertical, (float) x);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) this.f23047e).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                clickableSpan = clickableSpanArr[0];
                clickableSpan2 = clickableSpan;
                if (clickableSpan2 == null) {
                    clickableSpan2 = m31171a((float) x, (float) y, applyDimension);
                }
                if (clickableSpan2 == null) {
                    if (actionMasked == 1) {
                        m31175d();
                        clickableSpan2.onClick(view);
                    } else if (actionMasked == 0) {
                        m31172a(clickableSpan2);
                    }
                    return true;
                }
                m31175d();
                return false;
            }
        }
        clickableSpan = null;
        clickableSpan2 = clickableSpan;
        if (clickableSpan2 == null) {
            clickableSpan2 = m31171a((float) x, (float) y, applyDimension);
        }
        if (clickableSpan2 == null) {
            m31175d();
            return false;
        }
        if (actionMasked == 1) {
            m31175d();
            clickableSpan2.onClick(view);
        } else if (actionMasked == 0) {
            m31172a(clickableSpan2);
        }
        return true;
    }

    public final boolean mo3375a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getBounds().contains((int) motionEvent.getX(), (int) motionEvent.getY());
        boolean z;
        if (actionMasked == 1 || actionMasked == 0) {
            z = true;
        } else {
            z = false;
        }
        if ((this.f23046d && contains && r0) || actionMasked == 3) {
            return true;
        }
        return false;
    }

    public final void m31177a(CharSequence charSequence, Layout layout, float f, ColorStateList colorStateList, int i, int i2, ClickableSpan[] clickableSpanArr) {
        this.f23044a = layout;
        this.f23045c = f;
        this.f23047e = charSequence;
        this.f23051i = clickableSpanArr;
        boolean z = clickableSpanArr != null && clickableSpanArr.length > 0;
        this.f23046d = z;
        this.f23050h = i2;
        if (colorStateList != null) {
            this.f23048f = colorStateList;
            this.f23049g = colorStateList.getDefaultColor();
        } else {
            this.f23048f = null;
            this.f23049g = i;
        }
        invalidateSelf();
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public final List<CharSequence> mo3385a() {
        return this.f23047e != null ? Collections.singletonList(this.f23047e) : Collections.emptyList();
    }

    @Nullable
    private ClickableSpan m31171a(float f, float f2, float f3) {
        Region region = new Region();
        Region region2 = new Region();
        if (this.f23055m == null) {
            this.f23055m = new Path();
        }
        region2.set(0, 0, LayoutMeasureUtil.m29743a(this.f23044a), LayoutMeasureUtil.m29744b(this.f23044a));
        this.f23055m.reset();
        this.f23055m.addCircle(f, f2, f3, Direction.CW);
        region.setPath(this.f23055m, region2);
        ClickableSpan[] clickableSpanArr = this.f23051i;
        int length = clickableSpanArr.length;
        int i = 0;
        ClickableSpan clickableSpan = null;
        while (i < length) {
            ClickableSpan clickableSpan2;
            ClickableSpan clickableSpan3 = clickableSpanArr[i];
            if (!m31173a(clickableSpan3, (Spanned) this.f23047e, this.f23044a, region, region2)) {
                clickableSpan2 = clickableSpan;
            } else if (clickableSpan != null) {
                return null;
            } else {
                clickableSpan2 = clickableSpan3;
            }
            i++;
            clickableSpan = clickableSpan2;
        }
        return clickableSpan;
    }

    private void m31172a(ClickableSpan clickableSpan) {
        Spanned spanned = (Spanned) this.f23047e;
        m31174b(spanned.getSpanStart(clickableSpan), spanned.getSpanEnd(clickableSpan));
    }

    private void m31174b(int i, int i2) {
        if (Color.alpha(this.f23050h) == 0) {
            return;
        }
        if (this.f23052j != i || this.f23053k != i2) {
            this.f23052j = i;
            this.f23053k = i2;
            if (this.f23057o == null) {
                this.f23057o = new Paint();
            }
            this.f23057o.setColor(this.f23050h);
            this.f23056n = true;
            invalidateSelf();
        }
    }

    private void m31175d() {
        m31174b(0, 0);
    }

    private static boolean m31173a(ClickableSpan clickableSpan, Spanned spanned, Layout layout, Region region, Region region2) {
        Region region3 = new Region();
        Path path = new Path();
        layout.getSelectionPath(spanned.getSpanStart(clickableSpan), spanned.getSpanEnd(clickableSpan), path);
        region3.setPath(path, region2);
        return region3.op(region, Op.INTERSECT);
    }
}
