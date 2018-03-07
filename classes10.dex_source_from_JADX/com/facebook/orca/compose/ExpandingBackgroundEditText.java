package com.facebook.orca.compose;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterEditTextView;

/* compiled from: orca_composer_hot_like_clicks */
public class ExpandingBackgroundEditText extends BetterEditTextView {
    public Drawable f5504b;
    private ValueAnimator f5505c;
    private int f5506d;

    /* compiled from: orca_composer_hot_like_clicks */
    class C07781 implements AnimatorUpdateListener {
        final /* synthetic */ ExpandingBackgroundEditText f5503a;

        C07781(ExpandingBackgroundEditText expandingBackgroundEditText) {
            this.f5503a = expandingBackgroundEditText;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            Rect bounds = this.f5503a.f5504b.getBounds();
            this.f5503a.f5504b.setBounds(bounds.left, bounds.top, intValue + bounds.left, bounds.bottom);
            this.f5503a.invalidate();
        }
    }

    public ExpandingBackgroundEditText(Context context) {
        super(context);
        this.f5506d = Integer.MAX_VALUE;
    }

    public ExpandingBackgroundEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public ExpandingBackgroundEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5506d = Integer.MAX_VALUE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandingBackgroundEditText);
        this.f5504b = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandingBackground(Drawable drawable) {
        this.f5504b = drawable;
        invalidate();
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return super.onKeyPreIme(i, keyEvent);
    }

    public Drawable getExpandingBackground() {
        return this.f5504b;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f5504b;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -971317445);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f5504b != null) {
            this.f5504b.setBounds(0, 0, i, i2);
            if (i >= this.f5506d && this.f5505c == null) {
                if (this.f5505c != null) {
                    this.f5505c.cancel();
                }
                this.f5505c = ValueAnimator.ofInt(new int[]{this.f5506d, i});
                this.f5505c.addUpdateListener(new C07781(this));
                this.f5505c.setDuration(100);
                this.f5505c.start();
            } else if (this.f5505c != null) {
                this.f5505c.cancel();
                this.f5505c = null;
            }
        }
        this.f5506d = i;
        LogUtils.g(1478750740, a);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f5504b != null) {
            this.f5504b.draw(canvas);
        }
        super.onDraw(canvas);
    }
}
