package com.facebook.fig.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView.BufferType;
import com.facebook.resources.ui.FbCheckBox;

/* compiled from: media_comment */
public class FigBaseToggleButton extends FbCheckBox {
    public boolean f10458a;

    public FigBaseToggleButton(Context context) {
        super(context);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText("", bufferType);
    }

    public void setBackground(Drawable drawable) {
        if (!this.f10458a) {
            super.setBackground(drawable);
        }
    }

    public void setBackgroundColor(int i) {
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!this.f10458a) {
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundResource(int i) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    public void setBackgroundTintMode(Mode mode) {
    }

    public void setButtonDrawable(int i) {
    }

    public void setButtonDrawable(Drawable drawable) {
    }

    public void setAllCaps(boolean z) {
    }

    public void setCompoundDrawablePadding(int i) {
    }

    public void setCompoundDrawableTintList(ColorStateList colorStateList) {
    }

    public void setCompoundDrawableTintMode(Mode mode) {
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (!this.f10458a) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable);
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
    }

    public void setCursorVisible(boolean z) {
    }

    public void setEllipsize(TruncateAt truncateAt) {
    }

    public void setEms(int i) {
    }

    public void setGravity(int i) {
    }

    public void setHeight(int i) {
    }

    public void setHighlightColor(int i) {
    }

    public void setIncludeFontPadding(boolean z) {
    }

    public void setLines(int i) {
    }

    public void setMaxHeight(int i) {
    }

    public void setMaxLines(int i) {
    }

    public void setMaxWidth(int i) {
    }

    public void setMinHeight(int i) {
    }

    public void setMinLines(int i) {
    }

    public void setMinWidth(int i) {
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setTextAppearance(int i) {
    }

    public void setTextAppearance(Context context, int i) {
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (!this.f10458a) {
            super.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (!this.f10458a) {
            super.setTextColor(i);
        }
    }

    public void setTextScaleX(float f) {
    }

    public void setTextSize(float f) {
    }

    public void setTextSize(int i, float f) {
    }

    public void setTypeface(Typeface typeface, int i) {
    }

    public void setTypeface(Typeface typeface) {
    }

    public void setWidth(int i) {
    }
}
