package com.facebook.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.CompoundButton;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: com.google.common.base.FinalizableReference */
public class BetterSwitch extends CompoundButton {
    private static final int[] f5548H = new int[]{16842912};
    private TextPaint f5549A;
    private ColorStateList f5550B;
    private ColorStateList f5551C;
    private ColorStateList f5552D;
    private Layout f5553E;
    private Layout f5554F;
    private final Rect f5555G = new Rect();
    private Drawable f5556a;
    private Drawable f5557b;
    private Drawable f5558c;
    private Drawable f5559d;
    private int f5560e = 0;
    private int f5561f = 0;
    private int f5562g = 0;
    private int f5563h = 0;
    private CharSequence f5564i;
    private CharSequence f5565j;
    private boolean f5566k;
    private int f5567l;
    private int f5568m;
    private float f5569n;
    private float f5570o;
    private VelocityTracker f5571p;
    private int f5572q;
    private float f5573r;
    private int f5574s;
    private int f5575t;
    private int f5576u;
    private int f5577v;
    private int f5578w;
    private int f5579x;
    private int f5580y;
    private int f5581z;

    public BetterSwitch(Context context) {
        super(context);
        m10383a(context, null, 0);
    }

    public BetterSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10383a(context, attributeSet, 0);
    }

    public BetterSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10383a(context, attributeSet, i);
    }

    private final void m10383a(Context context, AttributeSet attributeSet, int i) {
        this.f5549A = new TextPaint(1);
        Resources resources = getResources();
        this.f5549A.density = resources.getDisplayMetrics().density;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BetterSwitch, i, 0);
            this.f5556a = obtainStyledAttributes.getDrawable(0);
            this.f5558c = obtainStyledAttributes.getDrawable(1);
            this.f5559d = obtainStyledAttributes.getDrawable(2);
            this.f5564i = obtainStyledAttributes.getText(3);
            this.f5565j = obtainStyledAttributes.getText(4);
            this.f5566k = obtainStyledAttributes.getBoolean(7, false);
            this.f5577v = obtainStyledAttributes.getDimensionPixelSize(8, this.f5577v);
            this.f5560e = obtainStyledAttributes.getDimensionPixelSize(9, this.f5560e);
            this.f5561f = obtainStyledAttributes.getDimensionPixelSize(11, this.f5561f);
            this.f5562g = obtainStyledAttributes.getDimensionPixelSize(12, this.f5562g);
            this.f5563h = obtainStyledAttributes.getDimensionPixelSize(13, this.f5563h);
            if (obtainStyledAttributes.hasValue(6)) {
                this.f5552D = obtainStyledAttributes.getColorStateList(6);
            }
            if (obtainStyledAttributes.hasValue(5)) {
                this.f5551C = obtainStyledAttributes.getColorStateList(5);
            }
            int resourceId = obtainStyledAttributes.getResourceId(10, 0);
            if (resourceId != 0) {
                m10382a(context, resourceId);
            }
            obtainStyledAttributes.recycle();
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5568m = viewConfiguration.getScaledTouchSlop();
        this.f5572q = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
        setClickable(true);
    }

    private void m10382a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearanceBetterSwitch);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        if (colorStateList != null) {
            this.f5550B = colorStateList;
        } else {
            this.f5550B = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (!(dimensionPixelSize == 0 || ((float) dimensionPixelSize) == this.f5549A.getTextSize())) {
            this.f5549A.setTextSize((float) dimensionPixelSize);
            requestLayout();
        }
        m10381a(obtainStyledAttributes.getInt(3, -1), obtainStyledAttributes.getInt(2, -1));
        obtainStyledAttributes.recycle();
    }

    private void m10381a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        m10384a(typeface, i2);
    }

    private void m10384a(Typeface typeface, int i) {
        boolean z = false;
        if (i > 0) {
            Typeface defaultFromStyle;
            int style;
            float f;
            if (typeface == null) {
                defaultFromStyle = Typeface.defaultFromStyle(i);
            } else {
                defaultFromStyle = Typeface.create(typeface, i);
            }
            setSwitchTypeface(defaultFromStyle);
            if (defaultFromStyle != null) {
                style = defaultFromStyle.getStyle();
            } else {
                style = 0;
            }
            style = (style ^ -1) & i;
            TextPaint textPaint = this.f5549A;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.f5549A;
            if ((style & 2) != 0) {
                f = -0.25f;
            } else {
                f = 0.0f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.f5549A.setFakeBoldText(false);
        this.f5549A.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.f5549A.getTypeface() != typeface) {
            this.f5549A.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.f5563h = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.f5563h;
    }

    public void setSwitchMinWidth(int i) {
        this.f5561f = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.f5561f;
    }

    public void setThumbTextPadding(int i) {
        this.f5560e = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.f5560e;
    }

    public void setTrackOffDrawable(Drawable drawable) {
        this.f5559d = drawable;
        requestLayout();
    }

    public void setTrackOffResource(int i) {
        setTrackOffDrawable(getContext().getResources().getDrawable(i));
    }

    public void setTrackOnDrawable(Drawable drawable) {
        this.f5558c = drawable;
        requestLayout();
    }

    public void setTrackOnResource(int i) {
        setTrackOnDrawable(getContext().getResources().getDrawable(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f5556a = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(getContext().getResources().getDrawable(i));
    }

    public Drawable getThumbDrawable() {
        return this.f5556a;
    }

    public CharSequence getTextOn() {
        return this.f5564i;
    }

    public void setTextOn(CharSequence charSequence) {
        this.f5564i = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.f5565j;
    }

    public void setTextOff(CharSequence charSequence) {
        this.f5565j = charSequence;
        requestLayout();
    }

    public void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -347866937);
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f5553E == null) {
            this.f5553E = m10380a(this.f5564i);
        }
        if (this.f5554F == null) {
            this.f5554F = m10380a(this.f5565j);
        }
        this.f5557b.getPadding(this.f5555G);
        int max = Math.max(this.f5561f, (((Math.max(this.f5553E.getWidth(), this.f5554F.getWidth()) * 2) + (this.f5560e * 4)) + this.f5555G.left) + this.f5555G.right);
        int max2 = Math.max(this.f5562g, Math.max(this.f5553E.getHeight(), this.f5554F.getHeight()));
        this.f5576u = Math.max(this.f5577v, ((max - this.f5555G.left) - this.f5555G.right) / 2);
        switch (mode) {
            case Integer.MIN_VALUE:
                max = Math.min(size, max);
                break;
            case 0:
                break;
            default:
                max = size;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                size2 = Math.min(size2, max2);
                break;
            case 0:
                size2 = max2;
                break;
        }
        this.f5574s = max;
        this.f5575t = size2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidth(), max2);
        }
        LogUtils.g(708221448, a);
    }

    private Layout m10380a(CharSequence charSequence) {
        CharSequence charSequence2;
        if (charSequence == null || !this.f5566k) {
            charSequence2 = charSequence;
        } else {
            charSequence2 = charSequence.toString().toUpperCase(getContext().getResources().getConfiguration().locale);
        }
        return new StaticLayout(charSequence2, this.f5549A, (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, this.f5549A)), Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 418913749);
        this.f5571p.addMovement(motionEvent);
        float x;
        float y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (isEnabled()) {
                    this.f5567l = 1;
                    this.f5569n = x;
                    this.f5570o = y;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.f5567l != 2) {
                    this.f5567l = 0;
                    this.f5571p.clear();
                    break;
                }
                m10387b(motionEvent);
                LogUtils.a(307072017, a);
                return true;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                switch (this.f5567l) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (Math.abs(x - this.f5569n) > ((float) this.f5568m) || Math.abs(y - this.f5570o) > ((float) this.f5568m)) {
                            this.f5567l = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f5569n = x;
                            this.f5570o = y;
                            LogUtils.a(-1986804680, a);
                            return true;
                        }
                    case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        x = motionEvent.getX();
                        y = Math.max(0.0f, Math.min((x - this.f5569n) + this.f5573r, (float) getThumbScrollRange()));
                        if (y != this.f5573r) {
                            this.f5573r = y;
                            this.f5569n = x;
                            invalidate();
                        }
                        LogUtils.a(-1274169083, a);
                        return true;
                    default:
                        break;
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-262032820, a);
        return onTouchEvent;
    }

    private void m10385a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void m10387b(MotionEvent motionEvent) {
        boolean z = true;
        this.f5567l = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        m10385a(motionEvent);
        if (z2) {
            this.f5571p.computeCurrentVelocity(1000);
            float xVelocity = this.f5571p.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f5572q)) {
                z = getTargetCheckedState();
            } else if (xVelocity <= 0.0f) {
                z = false;
            }
            setChecked(z);
            return;
        }
        setChecked(isChecked());
    }

    private void m10386a(boolean z) {
        setChecked(z);
    }

    private boolean getTargetCheckedState() {
        return this.f5573r >= ((float) getThumbScrollRange()) / 2.0f;
    }

    public void setChecked(boolean z) {
        this.f5573r = z ? (float) getThumbScrollRange() : 0.0f;
        this.f5557b = z ? this.f5558c : this.f5559d;
        super.setChecked(z);
        invalidate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        this.f5573r = isChecked() ? (float) getThumbScrollRange() : 0.0f;
        int width = getWidth() - getPaddingRight();
        int i6 = width - this.f5574s;
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f5575t / 2);
                i5 = this.f5575t + paddingTop;
                break;
            case 80:
                i5 = getHeight() - getPaddingBottom();
                paddingTop = i5 - this.f5575t;
                break;
            default:
                paddingTop = getPaddingTop();
                i5 = this.f5575t + paddingTop;
                break;
        }
        this.f5578w = i6;
        this.f5579x = paddingTop;
        this.f5581z = i5;
        this.f5580y = width;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f5578w;
        int i2 = this.f5579x;
        int i3 = this.f5580y;
        int i4 = this.f5581z;
        this.f5557b.setBounds(i, i2, i3, i4);
        this.f5557b.draw(canvas);
        canvas.save();
        this.f5557b.getPadding(this.f5555G);
        i += this.f5555G.left;
        int i5 = this.f5555G.top + i2;
        int i6 = i4 - this.f5555G.bottom;
        canvas.clipRect(i, i2, i3 - this.f5555G.right, i4);
        this.f5556a.getPadding(this.f5555G);
        i2 = (int) (this.f5573r + 0.5f);
        i3 = (i - this.f5555G.left) + i2;
        i2 = this.f5555G.right + ((i + i2) + this.f5576u);
        this.f5556a.setBounds(i3, i5, i2, i6);
        this.f5556a.draw(canvas);
        ColorStateList colorStateList = getTargetCheckedState() ? this.f5551C : this.f5552D;
        if (colorStateList == null) {
            colorStateList = this.f5550B;
        }
        if (colorStateList != null) {
            this.f5549A.setColor(colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor()));
        }
        this.f5549A.drawableState = getDrawableState();
        Layout layout = getTargetCheckedState() ? this.f5553E : this.f5554F;
        canvas.translate((float) (((i2 + i3) / 2) - (layout.getWidth() / 2)), (float) (((i5 + i6) / 2) - (layout.getHeight() / 2)));
        layout.draw(canvas);
        canvas.restore();
    }

    public int getCompoundPaddingRight() {
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f5574s;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.f5563h;
    }

    private int getThumbScrollRange() {
        if (this.f5557b == null) {
            return 0;
        }
        this.f5557b.getPadding(this.f5555G);
        return ((this.f5574s - this.f5576u) - this.f5555G.left) - this.f5555G.right;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f5548H);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.f5556a != null) {
            this.f5556a.setState(drawableState);
        }
        if (this.f5558c != null) {
            this.f5558c.setState(drawableState);
        }
        if (this.f5559d != null) {
            this.f5559d.setState(drawableState);
        }
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5556a || drawable == this.f5557b;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -964047311);
        super.onAttachedToWindow();
        this.f5571p = VelocityTracker.obtain();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 733240982, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1067764498);
        super.onDetachedFromWindow();
        this.f5571p.recycle();
        this.f5571p = null;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1481524082, a);
    }
}
