package com.facebook.photos.tagging.shared;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import com.facebook.photos.tagging.shared.layout.InsetContainerBounds;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: has_results_loaded */
public class BubbleLayout extends CustomLinearLayout {
    private final float f13258a;
    public final float f13259b;
    private final float f13260c;
    private final float f13261d;
    private final Paint f13262e;
    private final Paint f13263f;
    private Path f13264g;
    private float f13265h;
    private int f13266i;
    private int f13267j;
    public ArrowDirection f13268k;
    private InsetContainerBounds f13269l;

    /* compiled from: has_results_loaded */
    public enum ArrowDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        DOWNLEFT,
        DOWNRIGHT,
        UPLEFT,
        UPRIGHT
    }

    public BubbleLayout(Context context) {
        this(context, null);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13269l = new InsetContainerBounds();
        this.f13258a = getResources().getDimension(2131430308);
        this.f13259b = getResources().getDimension(2131430309);
        this.f13260c = getResources().getDimension(2131430310);
        this.f13261d = getResources().getDimension(2131430311);
        setWillNotDraw(false);
        setPadding((int) this.f13260c, (int) (this.f13260c + this.f13259b), (int) this.f13260c, (int) this.f13260c);
        this.f13262e = new Paint(1);
        this.f13262e.setARGB(204, 255, 255, 255);
        this.f13262e.setStrokeWidth(this.f13260c);
        this.f13262e.setStyle(Style.STROKE);
        this.f13262e.setAntiAlias(true);
        this.f13263f = new Paint(1);
        this.f13263f.setARGB(204, 0, 0, 0);
        this.f13263f.setStrokeWidth(this.f13260c);
        this.f13263f.setStyle(Style.FILL_AND_STROKE);
        this.f13263f.setAntiAlias(true);
        this.f13265h = 0.5f;
        this.f13268k = ArrowDirection.UP;
    }

    public float getArrowLength() {
        return this.f13259b;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f13266i != 0 && MeasureSpec.getSize(i) > this.f13266i) {
            i = MeasureSpec.makeMeasureSpec(this.f13266i, Integer.MIN_VALUE);
        }
        if (this.f13267j != 0 && MeasureSpec.getSize(i2) > this.f13267j) {
            i2 = MeasureSpec.makeMeasureSpec(this.f13267j, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m20936b();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f13264g, this.f13263f);
        canvas.drawPath(this.f13264g, this.f13262e);
    }

    public float getArrowOffset() {
        if (m20935a()) {
            return (this.f13259b + this.f13258a) + this.f13261d;
        }
        return 0.0f;
    }

    public void setArrowPosition(float f) {
        if (m20935a()) {
            m20944a(f, 0.0f);
        }
    }

    public final void m20944a(float f, float f2) {
        if (m20935a()) {
            float arrowOffset = getArrowOffset() / ((float) getWidth());
            arrowOffset = Math.max(Math.min(f, 1.0f - arrowOffset), arrowOffset);
            if (f2 > 0.0f) {
                final float f3 = this.f13265h;
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                ofFloat.setDuration((long) f2);
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ BubbleLayout f13256c;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.f13256c.m20932a((floatValue * (arrowOffset - f3)) + f3);
                    }
                });
                ofFloat.start();
                return;
            }
            m20932a(arrowOffset);
        }
    }

    private boolean m20935a() {
        return this.f13268k == ArrowDirection.DOWN || this.f13268k == ArrowDirection.UP;
    }

    public float getArrowPosition() {
        return this.f13265h;
    }

    public final void m20945a(ArrowDirection arrowDirection, InsetContainerBounds insetContainerBounds) {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        insetContainerBounds.f13387a.set((-width) / 2, (-height) / 2, width / 2, height / 2);
        insetContainerBounds.f13388b.set(insetContainerBounds.f13387a);
        insetContainerBounds.f13388b.inset((int) (-this.f13260c), (int) (-this.f13260c));
        if (arrowDirection == ArrowDirection.UP || arrowDirection == ArrowDirection.UPRIGHT || arrowDirection == ArrowDirection.UPLEFT) {
            width = ((int) this.f13259b) + (insetContainerBounds.f13388b.height() / 2);
            insetContainerBounds.f13387a.offset(0, width);
            insetContainerBounds.f13388b.offset(0, width);
            Rect rect = insetContainerBounds.f13388b;
            rect.top = (int) (((float) rect.top) - this.f13259b);
        }
        if (arrowDirection == ArrowDirection.DOWN || arrowDirection == ArrowDirection.DOWNLEFT || arrowDirection == ArrowDirection.DOWNRIGHT) {
            width = ((int) this.f13259b) + (insetContainerBounds.f13388b.height() / 2);
            insetContainerBounds.f13387a.offset(0, -width);
            insetContainerBounds.f13388b.offset(0, -width);
            rect = insetContainerBounds.f13388b;
            rect.bottom = (int) (((float) rect.bottom) + this.f13259b);
        }
        if (arrowDirection == ArrowDirection.LEFT || arrowDirection == ArrowDirection.DOWNLEFT || arrowDirection == ArrowDirection.UPLEFT) {
            width = ((int) this.f13259b) + (insetContainerBounds.f13388b.width() / 2);
            insetContainerBounds.f13387a.offset(width, 0);
            insetContainerBounds.f13388b.offset(width, 0);
            rect = insetContainerBounds.f13388b;
            rect.left = (int) (((float) rect.left) - this.f13259b);
        }
        if (arrowDirection == ArrowDirection.RIGHT || arrowDirection == ArrowDirection.DOWNRIGHT || arrowDirection == ArrowDirection.UPRIGHT) {
            width = ((int) this.f13259b) + (insetContainerBounds.f13388b.width() / 2);
            insetContainerBounds.f13387a.offset(-width, 0);
            insetContainerBounds.f13388b.offset(-width, 0);
            rect = insetContainerBounds.f13388b;
            rect.right = (int) (((float) rect.right) + this.f13259b);
        }
    }

    public void setArrowDirection(ArrowDirection arrowDirection) {
        this.f13268k = arrowDirection;
        m20945a(arrowDirection, this.f13269l);
        setPadding(this.f13269l.m21056a(), this.f13269l.m21057b(), this.f13269l.m21058c(), this.f13269l.m21059d());
        m20936b();
        invalidate();
    }

    public ArrowDirection getArrowDirection() {
        return this.f13268k;
    }

    public void setMaxWidth(int i) {
        this.f13266i = i;
        requestLayout();
    }

    public void setMaxHeight(int i) {
        this.f13267j = i;
        requestLayout();
    }

    private void m20932a(float f) {
        this.f13265h = f;
        m20936b();
        invalidate();
    }

    private void m20936b() {
        float f = this.f13260c / 2.0f;
        RectF rectF = new RectF(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
        f = this.f13258a * 2.0f;
        this.f13264g = new Path();
        this.f13264g.setFillType(FillType.EVEN_ODD);
        switch (this.f13268k) {
            case DOWN:
                m20933a(this.f13264g, rectF, f);
                return;
            case LEFT:
                m20938c(this.f13264g, rectF, f);
                return;
            case RIGHT:
                m20939d(this.f13264g, rectF, f);
                return;
            case UPLEFT:
                m20942g(this.f13264g, rectF, f);
                return;
            case UPRIGHT:
                m20943h(this.f13264g, rectF, f);
                return;
            case DOWNLEFT:
                m20940e(this.f13264g, rectF, f);
                return;
            case DOWNRIGHT:
                m20941f(this.f13264g, rectF, f);
                return;
            default:
                m20937b(this.f13264g, rectF, f);
                return;
        }
    }

    private void m20933a(Path path, RectF rectF, float f) {
        path.moveTo((rectF.left + (this.f13265h * rectF.width())) + this.f13259b, rectF.bottom - this.f13259b);
        path.lineTo(rectF.left + (this.f13265h * rectF.width()), rectF.bottom);
        path.lineTo((rectF.left + (this.f13265h * rectF.width())) - this.f13259b, rectF.bottom - this.f13259b);
        path.arcTo(new RectF(rectF.left, (rectF.bottom - this.f13259b) - f, rectF.left + f, rectF.bottom - this.f13259b), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left, rectF.top, rectF.left + f, rectF.top + f), 180.0f, 90.0f);
        path.arcTo(new RectF(rectF.right - f, rectF.top, rectF.right, rectF.top + f), 270.0f, 90.0f);
        path.arcTo(new RectF(rectF.right - f, (rectF.bottom - this.f13259b) - f, rectF.right, rectF.bottom - this.f13259b), 0.0f, 90.0f);
        path.close();
    }

    private void m20937b(Path path, RectF rectF, float f) {
        path.setFillType(FillType.EVEN_ODD);
        path.moveTo((rectF.left + (this.f13265h * rectF.width())) - this.f13259b, rectF.top + this.f13259b);
        path.lineTo(rectF.left + (this.f13265h * rectF.width()), rectF.top);
        path.lineTo((rectF.left + (this.f13265h * rectF.width())) + this.f13259b, rectF.top + this.f13259b);
        path.arcTo(new RectF(rectF.right - f, rectF.top + this.f13259b, rectF.right, (rectF.top + this.f13259b) + f), 270.0f, 90.0f);
        path.arcTo(new RectF(rectF.right - f, rectF.bottom - f, rectF.right, rectF.bottom), 0.0f, 90.0f);
        path.arcTo(new RectF(rectF.left, rectF.bottom - f, rectF.left + f, rectF.bottom), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left, rectF.top + this.f13259b, rectF.left + f, (rectF.top + this.f13259b) + f), 180.0f, 90.0f);
        path.close();
    }

    private void m20938c(Path path, RectF rectF, float f) {
        path.setFillType(FillType.EVEN_ODD);
        path.moveTo(rectF.left + this.f13259b, (rectF.top + (rectF.height() / 2.0f)) + this.f13259b);
        path.lineTo(rectF.left, rectF.top + (rectF.height() / 2.0f));
        path.lineTo(rectF.left + this.f13259b, (rectF.top + (rectF.height() / 2.0f)) - this.f13259b);
        path.arcTo(new RectF(rectF.left + this.f13259b, rectF.top, (rectF.left + this.f13259b) + f, rectF.top + f), -180.0f, 90.0f);
        path.arcTo(new RectF(rectF.right - f, rectF.top, rectF.right, rectF.top + f), -90.0f, 90.0f);
        path.arcTo(new RectF(rectF.right - f, rectF.bottom - f, rectF.right, rectF.bottom), 0.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + this.f13259b, rectF.bottom - f, (rectF.left + this.f13259b) + f, rectF.bottom), 90.0f, 90.0f);
        path.close();
    }

    private void m20939d(Path path, RectF rectF, float f) {
        path.setFillType(FillType.EVEN_ODD);
        path.moveTo(rectF.right - this.f13259b, (rectF.top + (rectF.height() / 2.0f)) - this.f13259b);
        path.lineTo(rectF.right, rectF.top + (rectF.height() / 2.0f));
        path.lineTo(rectF.right - this.f13259b, (rectF.top + (rectF.height() / 2.0f)) + this.f13259b);
        path.arcTo(new RectF((rectF.right - this.f13259b) - f, rectF.bottom - f, rectF.right - this.f13259b, rectF.bottom), 0.0f, 90.0f);
        path.arcTo(new RectF(rectF.left, rectF.bottom - f, rectF.left + f, rectF.bottom), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left, rectF.top, rectF.left + f, rectF.top + f), 180.0f, 90.0f);
        path.arcTo(new RectF((rectF.right - this.f13259b) - f, rectF.top, rectF.right - this.f13259b, rectF.top + f), 270.0f, 90.0f);
        path.close();
    }

    private void m20940e(Path path, RectF rectF, float f) {
        path.setFillType(FillType.EVEN_ODD);
        path.moveTo(rectF.left + (this.f13259b * 2.0f), rectF.bottom - this.f13259b);
        path.lineTo(rectF.left, rectF.bottom);
        path.lineTo(rectF.left + this.f13259b, rectF.bottom - (this.f13259b * 2.0f));
        path.arcTo(new RectF(rectF.left + this.f13259b, rectF.top, (rectF.left + this.f13259b) + f, rectF.top + f), -180.0f, 90.0f);
        path.arcTo(new RectF(rectF.right - f, rectF.top, rectF.right, rectF.top + f), -90.0f, 90.0f);
        path.arcTo(new RectF(rectF.right - f, (rectF.bottom - this.f13259b) - f, rectF.right, rectF.bottom - this.f13259b), 0.0f, 90.0f);
        path.close();
    }

    private void m20941f(Path path, RectF rectF, float f) {
        path.setFillType(FillType.EVEN_ODD);
        path.moveTo(rectF.right - this.f13259b, rectF.bottom - (this.f13259b * 2.0f));
        path.lineTo(rectF.right, rectF.bottom);
        path.lineTo(rectF.right - (this.f13259b * 2.0f), rectF.bottom - this.f13259b);
        path.arcTo(new RectF(rectF.left, (rectF.bottom - this.f13259b) - f, rectF.left + f, rectF.bottom - this.f13259b), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left, rectF.top, rectF.left + f, rectF.top + f), 180.0f, 90.0f);
        path.arcTo(new RectF((rectF.right - this.f13259b) - f, rectF.top, rectF.right - this.f13259b, rectF.top + f), 270.0f, 90.0f);
        path.close();
    }

    private void m20942g(Path path, RectF rectF, float f) {
        path.setFillType(FillType.EVEN_ODD);
        path.moveTo(rectF.left + this.f13259b, rectF.top + (this.f13259b * 2.0f));
        path.lineTo(rectF.left, rectF.top);
        path.lineTo(rectF.left + (this.f13259b * 2.0f), rectF.top + this.f13259b);
        path.arcTo(new RectF(rectF.right - f, rectF.top + this.f13259b, rectF.right, (rectF.top + this.f13259b) + f), 270.0f, 90.0f);
        path.arcTo(new RectF(rectF.right - f, rectF.bottom - f, rectF.right, rectF.bottom), 0.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + this.f13259b, rectF.bottom - f, (rectF.left + this.f13259b) + f, rectF.bottom), 90.0f, 90.0f);
        path.close();
    }

    private void m20943h(Path path, RectF rectF, float f) {
        path.setFillType(FillType.EVEN_ODD);
        path.moveTo(rectF.right - (this.f13259b * 2.0f), rectF.top + this.f13259b);
        path.lineTo(rectF.right, rectF.top);
        path.lineTo(rectF.right - this.f13259b, rectF.top + (this.f13259b * 2.0f));
        path.arcTo(new RectF((rectF.right - this.f13259b) - f, rectF.bottom - f, rectF.right - this.f13259b, rectF.bottom), 0.0f, 90.0f);
        path.arcTo(new RectF(rectF.left, rectF.bottom - f, rectF.left + f, rectF.bottom), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left, rectF.top + this.f13259b, rectF.left + f, (rectF.top + this.f13259b) + f), 180.0f, 90.0f);
        path.close();
    }
}
