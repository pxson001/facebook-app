package com.facebook.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: com.google.android.c2dm.intent.REGISTRATION */
public class SwitchCompat extends CompoundButton {
    private static final int[] f5783G = new int[]{16842912};
    private static final int[] f5784a = new int[]{16842904, 16842901, 2130772104};
    private Layout f5785A;
    private Layout f5786B;
    private TransformationMethod f5787C;
    private Animation f5788D;
    private final Rect f5789E;
    private final TintManager f5790F;
    private Drawable f5791b;
    private Drawable f5792c;
    private int f5793d;
    private int f5794e;
    private int f5795f;
    private boolean f5796g;
    private CharSequence f5797h;
    private CharSequence f5798i;
    private boolean f5799j;
    private int f5800k;
    private int f5801l;
    private float f5802m;
    private float f5803n;
    private VelocityTracker f5804o;
    private int f5805p;
    private float f5806q;
    private int f5807r;
    private int f5808s;
    private int f5809t;
    private int f5810u;
    private int f5811v;
    private int f5812w;
    private int f5813x;
    private TextPaint f5814y;
    private ColorStateList f5815z;

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772843);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5804o = VelocityTracker.obtain();
        this.f5789E = new Rect();
        this.f5814y = new TextPaint(1);
        Resources resources = getResources();
        this.f5814y.density = resources.getDisplayMetrics().density;
        TintTypedArray a = TintTypedArray.m1693a(context, attributeSet, R.styleable.SwitchCompat, i, 2131624646);
        this.f5791b = a.m1695a(2);
        this.f5792c = a.m1695a(3);
        this.f5797h = a.m1697b(0);
        this.f5798i = a.m1697b(1);
        this.f5799j = a.m1696a(5, true);
        this.f5793d = a.m1701d(6, 0);
        this.f5794e = a.m1701d(8, 0);
        this.f5795f = a.m1701d(9, 0);
        this.f5796g = a.m1696a(4, false);
        int f = a.m1704f(10, 0);
        if (f != 0) {
            m10544a(context, f);
        }
        this.f5790F = a.m1700c();
        a.m1698b();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5801l = viewConfiguration.getScaledTouchSlop();
        this.f5805p = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
        setClickable(true);
    }

    private void m10544a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, f5784a);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        if (colorStateList != null) {
            this.f5815z = colorStateList;
        } else {
            this.f5815z = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (!(dimensionPixelSize == 0 || ((float) dimensionPixelSize) == this.f5814y.getTextSize())) {
            this.f5814y.setTextSize((float) dimensionPixelSize);
            requestLayout();
        }
        if (obtainStyledAttributes.getBoolean(2, false)) {
            this.f5787C = new AllCapsTransformationMethod(getContext());
        } else {
            this.f5787C = null;
        }
        obtainStyledAttributes.recycle();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.f5814y.getTypeface() != typeface) {
            this.f5814y.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.f5795f = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.f5795f;
    }

    public void setSwitchMinWidth(int i) {
        this.f5794e = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.f5794e;
    }

    public void setThumbTextPadding(int i) {
        this.f5793d = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.f5793d;
    }

    public void setTrackDrawable(Drawable drawable) {
        this.f5792c = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.f5790F.m1690a(i));
    }

    public Drawable getTrackDrawable() {
        return this.f5792c;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f5791b = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.f5790F.m1690a(i));
    }

    public Drawable getThumbDrawable() {
        return this.f5791b;
    }

    public void setSplitTrack(boolean z) {
        this.f5796g = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.f5796g;
    }

    public CharSequence getTextOn() {
        return this.f5797h;
    }

    public void setTextOn(CharSequence charSequence) {
        this.f5797h = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.f5798i;
    }

    public void setTextOff(CharSequence charSequence) {
        this.f5798i = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.f5799j != z) {
            this.f5799j = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.f5799j;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int max;
        int i3 = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2109127893);
        if (this.f5799j) {
            if (this.f5785A == null) {
                this.f5785A = m10542a(this.f5797h);
            }
            if (this.f5786B == null) {
                this.f5786B = m10542a(this.f5798i);
            }
        }
        Rect rect = this.f5789E;
        if (this.f5791b != null) {
            this.f5791b.getPadding(rect);
            intrinsicWidth = (this.f5791b.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f5791b.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (this.f5799j) {
            max = Math.max(this.f5785A.getWidth(), this.f5786B.getWidth()) + (this.f5793d * 2);
        } else {
            max = 0;
        }
        this.f5809t = Math.max(max, intrinsicWidth);
        if (this.f5792c != null) {
            this.f5792c.getPadding(rect);
            i3 = this.f5792c.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        intrinsicWidth = rect.left;
        intrinsicWidth = Math.max(this.f5794e, (intrinsicWidth + (this.f5809t * 2)) + rect.right);
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.f5807r = intrinsicWidth;
        this.f5808s = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(ViewCompat.k(this), intrinsicHeight);
        }
        LogUtils.g(-1366973374, a);
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.f5797h : this.f5798i;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout m10542a(CharSequence charSequence) {
        CharSequence transformation;
        if (this.f5787C != null) {
            transformation = this.f5787C.getTransformation(charSequence, this);
        } else {
            transformation = charSequence;
        }
        return new StaticLayout(transformation, this.f5814y, (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.f5814y)), Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean m10548a(float f, float f2) {
        int thumbOffset = getThumbOffset();
        this.f5791b.getPadding(this.f5789E);
        thumbOffset = (thumbOffset + this.f5810u) - this.f5801l;
        return f > ((float) thumbOffset) && f < ((float) ((((this.f5809t + thumbOffset) + this.f5789E.left) + this.f5789E.right) + this.f5801l)) && f2 > ((float) (this.f5811v - this.f5801l)) && f2 < ((float) (this.f5813x + this.f5801l));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -776708318);
        this.f5804o.addMovement(motionEvent);
        float x;
        float y;
        switch (MotionEventCompat.a(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (isEnabled() && m10548a(x, y)) {
                    this.f5800k = 1;
                    this.f5802m = x;
                    this.f5803n = y;
                    break;
                }
            case 1:
            case 3:
                if (this.f5800k != 2) {
                    this.f5800k = 0;
                    this.f5804o.clear();
                    break;
                }
                m10549b(motionEvent);
                super.onTouchEvent(motionEvent);
                LogUtils.a(-289943391, a);
                return true;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                switch (this.f5800k) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (Math.abs(x - this.f5802m) > ((float) this.f5801l) || Math.abs(y - this.f5803n) > ((float) this.f5801l)) {
                            this.f5800k = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f5802m = x;
                            this.f5803n = y;
                            LogUtils.a(-1633596936, a);
                            return true;
                        }
                    case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x2 - this.f5802m;
                        x = thumbScrollRange != 0 ? f / ((float) thumbScrollRange) : f > 0.0f ? 1.0f : -1.0f;
                        if (ViewUtils.m1756a(this)) {
                            x = -x;
                        }
                        x = m10541a(x + this.f5806q, 0.0f, 1.0f);
                        if (x != this.f5806q) {
                            this.f5802m = x2;
                            setThumbPosition(this, x);
                        }
                        LogUtils.a(-708793994, a);
                        return true;
                    default:
                        break;
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(1508222111, a);
        return onTouchEvent;
    }

    private void m10545a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void m10549b(MotionEvent motionEvent) {
        boolean z = true;
        this.f5800k = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        if (z2) {
            this.f5804o.computeCurrentVelocity(1000);
            float xVelocity = this.f5804o.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f5805p)) {
                z = getTargetCheckedState();
            } else if (ViewUtils.m1756a(this)) {
                if (xVelocity >= 0.0f) {
                    z = false;
                }
            } else if (xVelocity <= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked();
        }
        setChecked(z);
        m10545a(motionEvent);
    }

    private void m10547a(boolean z) {
        final float f = this.f5806q;
        final float f2 = (z ? 1.0f : 0.0f) - f;
        this.f5788D = new Animation(this) {
            final /* synthetic */ SwitchCompat f5782c;

            protected void applyTransformation(float f, Transformation transformation) {
                SwitchCompat.setThumbPosition(this.f5782c, f + (f2 * f));
            }
        };
        this.f5788D.setDuration(250);
        startAnimation(this.f5788D);
    }

    private void m10543a() {
        if (this.f5788D != null) {
            clearAnimation();
            this.f5788D = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.f5806q > 0.5f;
    }

    public static void setThumbPosition(SwitchCompat switchCompat, float f) {
        switchCompat.f5806q = f;
        switchCompat.invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        setChecked$25decb5(true);
    }

    public void setCheckedNoAnimation(boolean z) {
        super.setChecked(z);
        setChecked$25decb5(false);
    }

    private void setChecked$25decb5(boolean z) {
        boolean isChecked = isChecked();
        if (!z || getWindowToken() == null) {
            m10543a();
            setThumbPosition(this, isChecked ? 1.0f : 0.0f);
            return;
        }
        m10547a(isChecked);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int paddingTop;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f5791b != null) {
            Rect rect = this.f5789E;
            if (this.f5792c != null) {
                this.f5792c.getPadding(rect);
            } else {
                rect.setEmpty();
            }
        }
        if (ViewUtils.m1756a(this)) {
            paddingLeft = getPaddingLeft() + 0;
            i5 = ((this.f5807r + paddingLeft) + 0) + 0;
        } else {
            i5 = (getWidth() - getPaddingRight()) + 0;
            paddingLeft = ((i5 - this.f5807r) + 0) + 0;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f5808s / 2);
                i6 = this.f5808s + paddingTop;
                break;
            case 80:
                i6 = getHeight() - getPaddingBottom();
                paddingTop = i6 - this.f5808s;
                break;
            default:
                paddingTop = getPaddingTop();
                i6 = this.f5808s + paddingTop;
                break;
        }
        this.f5810u = paddingLeft;
        this.f5811v = paddingTop;
        this.f5813x = i6;
        this.f5812w = i5;
    }

    public void draw(Canvas canvas) {
        Rect rect = this.f5789E;
        int i = this.f5810u;
        int i2 = this.f5811v;
        int i3 = this.f5812w;
        int i4 = this.f5813x;
        int thumbOffset = getThumbOffset() + i;
        if (this.f5792c != null) {
            this.f5792c.getPadding(rect);
            thumbOffset += rect.left;
            this.f5792c.setBounds(i, i2, i3, i4);
        }
        if (this.f5791b != null) {
            this.f5791b.getPadding(rect);
            i = thumbOffset - rect.left;
            thumbOffset = (thumbOffset + this.f5809t) + rect.right;
            this.f5791b.setBounds(i, i2, thumbOffset, i4);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.a(background, i, i2, thumbOffset, i4);
            }
        }
        super.draw(canvas);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.f5789E;
        Drawable drawable = this.f5792c;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f5811v + rect.top;
        int i2 = this.f5813x - rect.bottom;
        Drawable drawable2 = this.f5791b;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        int save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f5785A : this.f5786B;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.f5815z != null) {
                this.f5814y.setColor(this.f5815z.getColorForState(drawableState, 0));
            }
            this.f5814y.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.m1756a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f5807r;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft;
        }
        return compoundPaddingLeft + this.f5795f;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.m1756a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f5807r;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.f5795f;
    }

    private int getThumbOffset() {
        float f;
        if (ViewUtils.m1756a(this)) {
            f = 1.0f - this.f5806q;
        } else {
            f = this.f5806q;
        }
        return (int) ((f * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.f5792c == null) {
            return 0;
        }
        Rect rect = this.f5789E;
        this.f5792c.getPadding(rect);
        return ((this.f5807r - this.f5809t) - rect.left) - rect.right;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f5783G);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.f5791b != null) {
            this.f5791b.setState(drawableState);
        }
        if (this.f5792c != null) {
            this.f5792c.setState(drawableState);
        }
        invalidate();
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f5791b != null) {
            DrawableCompat.a(this.f5791b, f, f2);
        }
        if (this.f5792c != null) {
            DrawableCompat.a(this.f5792c, f, f2);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5791b || drawable == this.f5792c;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f5791b != null) {
                this.f5791b.jumpToCurrentState();
            }
            if (this.f5792c != null) {
                this.f5792c.jumpToCurrentState();
            }
            if (this.f5788D != null && this.f5788D.hasStarted() && !this.f5788D.hasEnded()) {
                clearAnimation();
                this.f5788D = null;
            }
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SwitchCompat.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(SwitchCompat.class.getName());
            CharSequence charSequence = isChecked() ? this.f5797h : this.f5798i;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }

    private static float m10541a(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }
}
