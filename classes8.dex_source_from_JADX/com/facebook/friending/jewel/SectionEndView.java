package com.facebook.friending.jewel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ProgressBar;
import com.facebook.R;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: finish_activity */
public class SectionEndView extends CustomFrameLayout {
    private final Paint f13226a;
    private Drawable f13227b;
    private FbTextView f13228c;
    private ProgressBar f13229d;
    private int f13230e;
    private boolean f13231f;

    public SectionEndView(Context context) {
        this(context, null);
    }

    public SectionEndView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772407);
    }

    public SectionEndView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13226a = new Paint();
        m14885a(context, attributeSet, i);
    }

    private void m14885a(Context context, AttributeSet attributeSet, int i) {
        setContentView(2130907021);
        this.f13228c = (FbTextView) c(2131567302);
        this.f13229d = (ProgressBar) c(2131567303);
        this.f13231f = RTLUtil.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SectionEndView, i, 0);
        this.f13227b = obtainStyledAttributes.getDrawable(4);
        if (this.f13227b != null) {
            int intrinsicWidth = this.f13227b.getIntrinsicWidth();
            int intrinsicHeight = this.f13227b.getIntrinsicHeight();
            if (this.f13231f) {
                this.f13227b.setBounds(-intrinsicWidth, 0, 0, intrinsicHeight);
            } else {
                this.f13227b.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            }
        }
        this.f13226a.setColor(obtainStyledAttributes.getColor(5, getResources().getColor(2131361980)));
        this.f13230e = obtainStyledAttributes.getDimensionPixelSize(6, SizeUtil.a(getResources(), 1.0f));
        this.f13228c.setCompoundDrawablePadding(obtainStyledAttributes.getDimensionPixelSize(3, 0));
        if (obtainStyledAttributes.hasValue(2)) {
            this.f13228c.setText(obtainStyledAttributes.getResourceId(2, 0));
        }
        obtainStyledAttributes.recycle();
    }

    protected void onMeasure(int i, int i2) {
        if (this.f13229d.getVisibility() == 0) {
            i2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.f13227b != null && this.f13228c.getVisibility() == 0) {
            canvas.save();
            int measuredHeight = (getMeasuredHeight() - this.f13227b.getIntrinsicHeight()) / 2;
            if (this.f13231f) {
                canvas.translate((float) (this.f13228c.getLeft() - this.f13228c.getCompoundDrawablePadding()), (float) measuredHeight);
            } else {
                canvas.translate((float) (this.f13228c.getRight() + this.f13228c.getCompoundDrawablePadding()), (float) measuredHeight);
            }
            this.f13227b.draw(canvas);
            canvas.restore();
        }
        if (this.f13230e > 0) {
            int paddingLeft = getPaddingLeft();
            int measuredWidth = getMeasuredWidth() - getPaddingRight();
            int measuredHeight2 = getMeasuredHeight();
            canvas.drawRect((float) paddingLeft, 0.0f, (float) measuredWidth, (float) this.f13230e, this.f13226a);
            canvas.drawRect((float) paddingLeft, (float) (measuredHeight2 - this.f13230e), (float) measuredWidth, (float) measuredHeight2, this.f13226a);
        }
        super.dispatchDraw(canvas);
    }

    public void setText(int i) {
        setText(getResources().getString(i));
    }

    public void setText(CharSequence charSequence) {
        this.f13228c.setText(charSequence);
    }
}
