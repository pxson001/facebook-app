package com.facebook.fbui.widget.contentview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.resources.ui.FbButton;

/* compiled from: X-FB-HTTP-Engine */
public class ContentViewWithButton extends ContentView {
    private final Rect f12239h;
    private Drawable f12240i;
    private int f12241j;
    private int f12242k;

    /* compiled from: X-FB-HTTP-Engine */
    public enum Theme {
        NONE,
        GRAY,
        BLUE,
        SPECIAL
    }

    public ContentViewWithButton(Context context) {
        this(context, null);
    }

    public ContentViewWithButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772425);
    }

    public ContentViewWithButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12239h = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ContentViewWithButton, i, 0);
        if (this.a == null) {
            FbButton fbButton = new FbButton(getContext());
            fbButton.setCompoundDrawablePadding(0);
            this.a = fbButton;
            ContentView$LayoutParams contentView$LayoutParams = new ContentView$LayoutParams(-2, -2);
            contentView$LayoutParams.b = true;
            contentView$LayoutParams.d = obtainStyledAttributes.getInt(9, -1);
            addView(this.a, contentView$LayoutParams);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(3);
        if (drawable != null) {
            setActionButtonDrawable(drawable);
        }
        int integer = obtainStyledAttributes.getInteger(8, 0);
        if (integer > 0) {
            setActionButtonTheme(Theme.values()[integer]);
        }
        drawable = obtainStyledAttributes.getDrawable(5);
        if (drawable != null) {
            setActionButtonBackground(drawable);
        }
        integer = obtainStyledAttributes.getResourceId(4, 0);
        if (integer > 0) {
            setActionButtonText(integer);
        } else {
            setActionButtonText(obtainStyledAttributes.getText(4));
        }
        setActionButtonTextAppearance(obtainStyledAttributes.getResourceId(7, 0));
        setAuxViewPadding(obtainStyledAttributes.getDimensionPixelSize(6, 0));
        setDivider(obtainStyledAttributes.getDrawable(1));
        setDividerPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0));
        setDividerThickness(obtainStyledAttributes.getDimensionPixelSize(2, 0));
        obtainStyledAttributes.recycle();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (m20268g()) {
            int measuredWidth;
            ContentView$LayoutParams contentView$LayoutParams = (ContentView$LayoutParams) this.a.getLayoutParams();
            if (c()) {
                measuredWidth = ((((getMeasuredWidth() - getSpaceRight()) - this.a.getMeasuredWidth()) - contentView$LayoutParams.leftMargin) - contentView$LayoutParams.rightMargin) - this.f12241j;
            } else {
                measuredWidth = contentView$LayoutParams.rightMargin + ((getSpaceLeft() + this.a.getMeasuredWidth()) + contentView$LayoutParams.leftMargin);
            }
            this.f12239h.set(measuredWidth, getSpaceTop() + this.f12242k, this.f12241j + measuredWidth, (getMeasuredHeight() - getSpaceBottom()) - this.f12242k);
            m20267a(canvas, this.f12239h);
        }
    }

    private void m20267a(Canvas canvas, Rect rect) {
        if (VERSION.SDK_INT >= 11 || !(this.f12240i instanceof ColorDrawable)) {
            this.f12240i.setBounds(rect);
            this.f12240i.draw(canvas);
            return;
        }
        canvas.save();
        canvas.clipRect(rect);
        this.f12240i.draw(canvas);
        canvas.restore();
    }

    public int getAuxViewPadding() {
        int auxViewPadding = super.getAuxViewPadding();
        return !m20268g() ? auxViewPadding : auxViewPadding + this.f12241j;
    }

    private boolean m20268g() {
        if (this.f12240i == null || this.a == null || this.a.getVisibility() == 8) {
            return false;
        }
        return true;
    }

    public void setActionButtonTheme(Theme theme) {
        if (theme == Theme.GRAY) {
            setActionButtonBackground(getResources().getDrawable(2130839739));
            setActionButtonTextAppearance(2131624239);
        } else if (theme == Theme.BLUE) {
            setActionButtonBackground(getResources().getDrawable(2130839736));
            setActionButtonTextAppearance(2131624243);
        } else if (theme == Theme.SPECIAL) {
            setActionButtonBackground(getResources().getDrawable(2130839742));
            setActionButtonTextAppearance(2131624247);
        } else {
            setActionButtonBackground(null);
            setActionButtonTextAppearance(2131624222);
        }
    }

    public CharSequence getActionButtonText() {
        if (this.a instanceof TextView) {
            return ((TextView) this.a).getText();
        }
        return null;
    }

    public void setActionButtonText(int i) {
        if (this.a instanceof TextView) {
            ((TextView) this.a).setText(i);
            return;
        }
        throw new IllegalStateException("Action button is not an instanceof TextView");
    }

    public void setActionButtonText(CharSequence charSequence) {
        if (this.a instanceof TextView) {
            ((TextView) this.a).setText(charSequence);
            return;
        }
        throw new IllegalStateException("Action button is not an instanceof TextView");
    }

    public void setActionButtonTextAppearance(int i) {
        if (i <= 0) {
            return;
        }
        if (this.a instanceof TextView) {
            ((TextView) this.a).setTextAppearance(getContext(), i);
            return;
        }
        throw new IllegalStateException("Action button is not an instanceof TextView");
    }

    public Drawable getActionButtonDrawable() {
        if (this.a instanceof TextView) {
            return ((TextView) this.a).getCompoundDrawables()[0];
        }
        throw new IllegalStateException("Action button is not an instanceof TextView");
    }

    public void setActionButtonDrawable(Drawable drawable) {
        if (this.a instanceof TextView) {
            ((TextView) this.a).setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            return;
        }
        throw new IllegalStateException("Action button is not an instanceof TextView");
    }

    public void setActionButtonResource(int i) {
        if (this.a instanceof TextView) {
            ((TextView) this.a).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            return;
        }
        throw new IllegalStateException("Action button is not an instanceof TextView");
    }

    public void setActionButtonBackground(Drawable drawable) {
        this.a.setBackgroundDrawable(drawable);
    }

    public int getActionButtonPadding() {
        return getAuxViewPadding();
    }

    public void setActionButtonPadding(int i) {
        setAuxViewPadding(i);
    }

    public final boolean m20269f() {
        return this.a.getVisibility() == 0;
    }

    public void setShowActionButton(boolean z) {
        this.a.setVisibility(z ? 0 : 8);
    }

    public void setEnableActionButton(boolean z) {
        this.a.setEnabled(z);
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public void setActionButtonContentDescription(CharSequence charSequence) {
        this.a.setContentDescription(charSequence);
    }

    public void setDividerThickness(int i) {
        if (this.f12241j != i) {
            this.f12241j = i;
            requestLayout();
        }
    }

    public int getDividerThickness() {
        return this.f12241j;
    }

    public void setDividerPadding(int i) {
        if (this.f12242k != i) {
            this.f12242k = i;
            requestLayout();
        }
    }

    public int getDividerPadding() {
        return this.f12242k;
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (this.f12240i != drawable) {
            this.f12240i = drawable;
            if (this.f12240i != null) {
                this.f12241j = this.f12240i.getIntrinsicWidth();
            } else {
                this.f12241j = 0;
            }
            if (this.f12240i == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public Drawable getDivider() {
        return this.f12240i;
    }
}
