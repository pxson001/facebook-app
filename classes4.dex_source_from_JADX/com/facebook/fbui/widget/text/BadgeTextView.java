package com.facebook.fbui.widget.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.Locale;

/* compiled from: display_ship_date */
public class BadgeTextView extends FbTextView {
    private TextPaint f13728a;
    private ColorStateList f13729b;
    private int f13730c;
    private int f13731d;
    private int f13732e;
    private int f13733f;
    private Layout f13734g;
    public CharSequence f13735h;
    private Drawable f13736i;
    private Rect f13737j;
    private BadgePlacement f13738k;
    private int f13739l;

    /* compiled from: display_ship_date */
    public enum BadgePlacement {
        WITH_TEXT,
        AWAY_FROM_TEXT
    }

    public BadgeTextView(Context context) {
        this(context, null);
    }

    public BadgeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772436);
    }

    public BadgeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13728a = new TextPaint(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BadgeTextView, i, 0);
        m14473a(context, obtainStyledAttributes.getResourceId(1, 2131624521));
        setBadgeBackground(obtainStyledAttributes.getDrawable(4));
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            setBadgeText(getResources().getString(resourceId));
        } else {
            setBadgeText(obtainStyledAttributes.getText(0));
        }
        setBadgePadding(obtainStyledAttributes.getDimensionPixelSize(2, 0));
        setBadgeYOffset(obtainStyledAttributes.getDimensionPixelSize(3, 0));
        this.f13738k = obtainStyledAttributes.getInteger(5, 0) == 0 ? BadgePlacement.WITH_TEXT : BadgePlacement.AWAY_FROM_TEXT;
        this.f13739l = obtainStyledAttributes.getInteger(6, 16);
        obtainStyledAttributes.recycle();
    }

    public void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 520870904);
        if (TextUtils.isEmpty(this.f13735h)) {
            super.onMeasure(i, i2);
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1478945658, a);
            return;
        }
        int size = MeasureSpec.getSize(i);
        if (size == 0 || MeasureSpec.getMode(i) == 0) {
            size = Integer.MAX_VALUE;
        }
        this.f13734g = new StaticLayout(this.f13735h, this.f13728a, size, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        this.f13736i.setBounds(0, 0, getBadgeWidth(), getBadgeHeight());
        super.onMeasure(i, i2);
        int max = Math.max(getMeasuredHeight(), getBadgeHeight());
        if (max < MeasureSpec.getSize(i2)) {
            setMeasuredDimension(getMeasuredWidth(), max);
        }
        LogUtils.g(-648066588, a);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(this.f13735h) && this.f13734g != null) {
            int lineWidth = (int) getLayout().getLineWidth(0);
            int badgeWidth = getBadgeWidth();
            int badgeHeight = getBadgeHeight();
            int width = getWidth();
            int height = getHeight();
            this.f13732e = 0;
            this.f13733f = (height - badgeHeight) / 2;
            int i = this.f13739l & 112;
            if (i == 48) {
                this.f13733f = getPaddingTop();
            } else if (i == 80) {
                this.f13733f = (height - badgeHeight) - getPaddingBottom();
            }
            this.f13733f += this.f13731d;
            badgeHeight = super.getCompoundPaddingLeft();
            height = super.getCompoundPaddingRight();
            i = badgeHeight + height;
            canvas.translate((float) getScrollX(), (float) getScrollY());
            int a = GravityCompat.m4734a(getGravity(), ViewCompat.h(this)) & 7;
            if (m14472a()) {
                if (this.f13738k == BadgePlacement.WITH_TEXT) {
                    if (a == 3) {
                        this.f13732e = (lineWidth + badgeHeight) + this.f13730c;
                    } else if (a == 5) {
                        this.f13732e = (width - height) - badgeWidth;
                    } else {
                        this.f13732e = ((lineWidth + badgeHeight) + this.f13730c) + (((((width - i) - lineWidth) - badgeWidth) - this.f13730c) / 2);
                    }
                } else if (this.f13738k == BadgePlacement.AWAY_FROM_TEXT) {
                    this.f13732e = (width - height) - badgeWidth;
                }
            } else if (this.f13738k == BadgePlacement.WITH_TEXT) {
                if (a == 3) {
                    this.f13732e = badgeHeight;
                } else if (a == 5) {
                    this.f13732e = (((width - lineWidth) - height) - badgeWidth) - this.f13730c;
                } else {
                    this.f13732e = (((((width - i) - lineWidth) - badgeWidth) - this.f13730c) / 2) + badgeHeight;
                }
            } else if (this.f13738k == BadgePlacement.AWAY_FROM_TEXT) {
                this.f13732e = badgeHeight;
            }
            canvas.translate((float) this.f13732e, (float) this.f13733f);
            this.f13736i.draw(canvas);
            canvas.translate((float) this.f13737j.left, (float) this.f13737j.top);
            this.f13734g.draw(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 2056102130);
        boolean onTouchEvent;
        if (this.f13734g == null) {
            onTouchEvent = super.onTouchEvent(motionEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 563398155, a);
            return onTouchEvent;
        } else if (this.f13735h instanceof Spanned) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int y = (((int) motionEvent.getY()) - getPaddingTop()) + getScrollY();
                int x = ((((int) motionEvent.getX()) - getPaddingLeft()) + getScrollX()) - this.f13732e;
                int i = y - this.f13733f;
                if (x < 0 || x > getBadgeWidth() || i < 0 || i > getBadgeHeight()) {
                    onTouchEvent = super.onTouchEvent(motionEvent);
                    LogUtils.a(-1525408081, a);
                    return onTouchEvent;
                }
                y = this.f13734g.getOffsetForHorizontal(this.f13734g.getLineForVertical(y), (float) x);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) this.f13735h).getSpans(y, y, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    if (action == 1) {
                        clickableSpanArr[0].onClick(this);
                    }
                    LogUtils.a(984001864, a);
                    return true;
                }
                onTouchEvent = super.onTouchEvent(motionEvent);
                LogUtils.a(1229019035, a);
                return onTouchEvent;
            }
            onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(1613342457, a);
            return onTouchEvent;
        } else {
            onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(1783956658, a);
            return onTouchEvent;
        }
    }

    private static boolean m14472a() {
        return TextUtilsCompat.m4656a(Locale.getDefault()) == 0;
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        int badgeWidth = getBadgeWidth();
        if (m14472a() || badgeWidth <= 0) {
            return compoundPaddingLeft;
        }
        return (compoundPaddingLeft + badgeWidth) + this.f13730c;
    }

    public int getCompoundPaddingRight() {
        int compoundPaddingRight = super.getCompoundPaddingRight();
        int badgeWidth = getBadgeWidth();
        if (!m14472a() || badgeWidth <= 0) {
            return compoundPaddingRight;
        }
        return (compoundPaddingRight + badgeWidth) + this.f13730c;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.f13729b != null && this.f13729b.isStateful()) {
            this.f13728a.setColor(this.f13729b.getColorForState(drawableState, 0));
        }
        if (this.f13736i != null) {
            this.f13736i.setState(getDrawableState());
        }
    }

    private int getBadgeWidth() {
        if (TextUtils.isEmpty(this.f13735h) || this.f13734g == null) {
            return 0;
        }
        return ((int) this.f13734g.getLineWidth(0)) + (this.f13737j.left + this.f13737j.right);
    }

    private int getBadgeHeight() {
        if (TextUtils.isEmpty(this.f13735h) || this.f13734g == null) {
            return 0;
        }
        return (this.f13734g.getLineBottom(0) + this.f13737j.top) + this.f13737j.bottom;
    }

    public int getBadgePadding() {
        return this.f13730c;
    }

    public void setBadgePadding(int i) {
        if (this.f13730c != i) {
            this.f13730c = i;
            requestLayout();
            invalidate();
        }
    }

    public int getBadgeYOffset() {
        return this.f13731d;
    }

    public void setBadgeYOffset(int i) {
        if (this.f13731d != i) {
            this.f13731d = i;
            requestLayout();
            invalidate();
        }
    }

    public Drawable getBadgeBackground() {
        return this.f13736i;
    }

    public void setBadgeBackground(int i) {
        setBadgeBackground(getResources().getDrawable(i));
    }

    public void setBadgeBackground(Drawable drawable) {
        this.f13736i = drawable;
        if (this.f13736i == null) {
            this.f13736i = new ColorDrawable(0);
        }
        this.f13737j = new Rect();
        this.f13736i.getPadding(this.f13737j);
    }

    public BadgePlacement getBadgePlacement() {
        return this.f13738k;
    }

    public void setBadgePlacement(BadgePlacement badgePlacement) {
        if (this.f13738k != badgePlacement) {
            this.f13738k = badgePlacement;
            invalidate();
            requestLayout();
        }
    }

    public int getBadgeGravity() {
        return this.f13739l;
    }

    public void setBadgeGravity(int i) {
        if (this.f13739l != i) {
            this.f13739l = i;
            invalidate();
            requestLayout();
        }
    }

    public final void m14473a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.BadgeTextViewBadgeAppearance);
        this.f13729b = obtainStyledAttributes.getColorStateList(2);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 15);
        int i2 = obtainStyledAttributes.getInt(3, 0);
        float f = obtainStyledAttributes.getFloat(4, 0.0f);
        float f2 = obtainStyledAttributes.getFloat(5, 0.0f);
        float f3 = obtainStyledAttributes.getFloat(6, 0.0f);
        int i3 = obtainStyledAttributes.getInt(1, -1);
        obtainStyledAttributes.recycle();
        if (this.f13729b != null) {
            this.f13728a.setColor(this.f13729b.getDefaultColor());
        }
        this.f13728a.setTextSize((float) dimensionPixelSize);
        this.f13728a.setShadowLayer(f3, f, f2, i2);
        if (i3 != -1) {
            this.f13728a.setTypeface(Typeface.defaultFromStyle(i3));
        }
    }

    public CharSequence getBadgeText() {
        return this.f13735h;
    }

    public void setBadgeText(CharSequence charSequence) {
        if (!TextUtils.equals(this.f13735h, charSequence)) {
            this.f13735h = charSequence;
            this.f13734g = null;
            invalidate();
            requestLayout();
        }
    }
}
