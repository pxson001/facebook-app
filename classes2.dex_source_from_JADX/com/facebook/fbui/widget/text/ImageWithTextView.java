package com.facebook.fbui.widget.text;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterTextView;

/* compiled from: media_downloader_failure */
public class ImageWithTextView extends BetterTextView {
    public Drawable f14549a;
    private boolean f14550b = true;
    private float f14551c = 1.0f;
    private float f14552d = 1.0f;
    private int f14553e;
    private int f14554f;
    private float f14555g;
    private float f14556h;
    private int f14557i;
    public boolean f14558j = true;

    public ImageWithTextView(Context context) {
        super(context);
        setGravity(17);
    }

    public ImageWithTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20981a(context, attributeSet, 0);
    }

    public ImageWithTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20981a(context, attributeSet, i);
    }

    private void m20981a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageWithTextView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            setImageResource(resourceId);
        }
        this.f14557i = obtainStyledAttributes.getInteger(1, 0);
        obtainStyledAttributes.recycle();
        setGravity(17);
    }

    private boolean mo3275b() {
        return this.f14550b && this.f14549a != null;
    }

    public final void mo2813a(boolean z) {
        if (this.f14550b != z) {
            this.f14550b = z;
            requestLayout();
            invalidate();
        }
    }

    public Drawable getDrawable() {
        return this.f14549a;
    }

    public void setImageResource(int i) {
        if (i != 0) {
            this.f14550b = true;
            setupDrawable(getResources().getDrawable(i));
        } else {
            this.f14550b = false;
        }
        requestLayout();
        invalidate();
    }

    public void setImageDrawable(Drawable drawable) {
        setupDrawable(drawable);
        requestLayout();
        invalidate();
    }

    private void setupDrawable(Drawable drawable) {
        if (this.f14549a != drawable) {
            if (this.f14549a != null) {
                this.f14549a.setCallback(null);
            }
            this.f14549a = drawable;
            if (this.f14549a != null) {
                this.f14549a.setCallback(this);
                if (this.f14549a.isStateful()) {
                    this.f14549a.setState(getDrawableState());
                }
                this.f14553e = this.f14549a.getIntrinsicWidth();
                this.f14554f = this.f14549a.getIntrinsicHeight();
                this.f14549a.setBounds(0, 0, this.f14553e, this.f14554f);
                return;
            }
            this.f14553e = 0;
            this.f14554f = 0;
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        if (mo3275b() && m20985d()) {
            return compoundPaddingLeft + (this.f14553e + getCompoundDrawablePadding());
        }
        return compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        int compoundPaddingRight = super.getCompoundPaddingRight();
        if (mo3275b() && m20986e()) {
            return compoundPaddingRight + (this.f14553e + getCompoundDrawablePadding());
        }
        return compoundPaddingRight;
    }

    public int getCompoundPaddingTop() {
        int compoundPaddingTop = super.getCompoundPaddingTop();
        if (mo3275b() && this.f14557i == 1) {
            return compoundPaddingTop + (this.f14554f + getCompoundDrawablePadding());
        }
        return compoundPaddingTop;
    }

    public int getCompoundPaddingBottom() {
        int compoundPaddingBottom = super.getCompoundPaddingBottom();
        if (mo3275b() && this.f14557i == 3) {
            return compoundPaddingBottom + (this.f14554f + getCompoundDrawablePadding());
        }
        return compoundPaddingBottom;
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 55814491);
        super.onMeasure(i, i2);
        if (this.f14550b) {
            this.f14558j = ViewCompat.m10967h(this) == 0;
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            float lineWidth;
            if (this.f14557i == 0 || this.f14557i == 2) {
                paddingTop = (this.f14554f + getPaddingTop()) + getPaddingBottom();
                int measuredWidth = getMeasuredWidth();
                paddingTop = Math.max(paddingTop, getMeasuredHeight());
                setMeasuredDimension(measuredWidth, paddingTop);
                lineWidth = (((((float) measuredWidth) - (getLayout().getLineWidth(0) + ((float) (getCompoundDrawablePadding() + this.f14553e)))) - ((float) paddingLeft)) - ((float) paddingRight)) / 2.0f;
                if (m20985d()) {
                    this.f14555g = ((float) paddingLeft) + lineWidth;
                } else {
                    this.f14555g = ((((float) measuredWidth) - lineWidth) - ((float) this.f14553e)) - ((float) paddingRight);
                }
                this.f14556h = ((float) (paddingTop - this.f14554f)) / 2.0f;
            } else {
                paddingLeft = Math.max((this.f14553e + getPaddingLeft()) + getPaddingRight(), getMeasuredWidth());
                paddingRight = getMeasuredHeight();
                setMeasuredDimension(paddingLeft, paddingRight);
                lineWidth = (float) (getLayout().getLineBottom(0) + (getCompoundDrawablePadding() + this.f14554f));
                this.f14555g = ((float) (paddingLeft - this.f14553e)) / 2.0f;
                lineWidth = (((((float) paddingRight) - lineWidth) - ((float) paddingTop)) - ((float) paddingBottom)) / 2.0f;
                if (this.f14557i == 1) {
                    this.f14556h = ((float) paddingTop) + lineWidth;
                } else {
                    this.f14556h = ((((float) paddingRight) - lineWidth) - ((float) this.f14554f)) - ((float) paddingBottom);
                }
            }
            LogUtils.g(-39834095, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -379645937, a);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14550b && this.f14549a != null) {
            m20982a(canvas);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f14549a || super.verifyDrawable(drawable);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f14549a != null && this.f14549a.isStateful()) {
            this.f14549a.setState(getDrawableState());
        }
    }

    public void setOrientation(int i) {
        if (this.f14557i != i) {
            this.f14557i = i;
            requestLayout();
            invalidate();
        }
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f14549a != null) {
            this.f14549a.jumpToCurrentState();
        }
    }

    private void m20982a(Canvas canvas) {
        canvas.save();
        canvas.translate(((float) getScrollX()) + this.f14555g, ((float) getScrollY()) + this.f14556h);
        canvas.scale(this.f14551c, this.f14552d, ((float) this.f14553e) / 2.0f, ((float) this.f14554f) / 2.0f);
        this.f14549a.draw(canvas);
        canvas.restore();
    }

    private boolean m20984c() {
        return this.f14558j;
    }

    private boolean m20985d() {
        if (this.f14558j) {
            if (this.f14557i == 0) {
                return true;
            }
            return false;
        } else if (this.f14557i != 2) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m20986e() {
        if (this.f14558j) {
            if (this.f14557i == 2) {
                return true;
            }
            return false;
        } else if (this.f14557i != 0) {
            return false;
        } else {
            return true;
        }
    }

    public float getImageScaleX() {
        return this.f14551c;
    }

    public void setImageScaleX(float f) {
        float a = m20980a(this.f14553e, f);
        if (Float.compare(this.f14551c, a) != 0) {
            this.f14551c = a;
            invalidate();
        }
    }

    public float getImageScaleY() {
        return this.f14552d;
    }

    public void setImageScaleY(float f) {
        float a = m20980a(this.f14554f, f);
        if (Float.compare(this.f14552d, a) != 0) {
            this.f14552d = a;
            invalidate();
        }
    }

    public void setImageScale(float f) {
        setImageScaleX(f);
        setImageScaleY(f);
    }

    private static float m20980a(int i, float f) {
        return Math.abs(((double) f) - 1.0d) < ((double) (1.0f / ((float) i))) ? 1.0f : f;
    }
}
