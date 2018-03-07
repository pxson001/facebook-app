package com.facebook.fig.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.resources.ui.FbButton;
import javax.annotation.Nullable;

/* compiled from: media_container_id */
public abstract class FigBaseButton extends FbButton {
    public boolean f10457a;

    abstract boolean mo1047a();

    public FigBaseButton(Context context) {
        super(context);
    }

    public FigBaseButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!this.f10457a) {
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    public void setBackgroundTintMode(Mode mode) {
    }

    public void setAllCaps(boolean z) {
    }

    public void setCompoundDrawablePadding(int i) {
    }

    public void setCompoundDrawableTintMode(Mode mode) {
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (!this.f10457a) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (!this.f10457a) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setCursorVisible(boolean z) {
    }

    public void setEms(int i) {
    }

    public void setGravity(int i) {
        if (!this.f10457a) {
            super.setGravity(i);
        }
    }

    public void setHeight(int i) {
    }

    public void setHighlightColor(int i) {
    }

    public void setIncludeFontPadding(boolean z) {
    }

    public void setLines(int i) {
        if (!this.f10457a) {
            super.setLines(i);
        }
    }

    public void setMaxHeight(int i) {
    }

    public void setMaxLines(int i) {
    }

    public void setMaxWidth(int i) {
        if (mo1047a()) {
            super.setMaxWidth(i);
        }
    }

    public void setMinHeight(int i) {
    }

    public void setMinLines(int i) {
    }

    public void setMinWidth(int i) {
        if (mo1047a()) {
            super.setMinWidth(i);
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!this.f10457a) {
            super.setPadding(i, i2, i3, i4);
        }
    }

    public void setTextAppearance(int i) {
    }

    public void setTextAppearance(Context context, int i) {
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (!this.f10457a) {
            super.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (!this.f10457a) {
            super.setTextColor(i);
        }
    }

    public void setTextScaleX(float f) {
    }

    public void setTextSize(int i, float f) {
        if (!this.f10457a) {
            super.setTextSize(i, f);
        }
    }

    public void setTypeface(Typeface typeface, int i) {
    }

    public void setTypeface(Typeface typeface) {
    }

    public void setWidth(int i) {
        if (mo1047a()) {
            super.setWidth(i);
        }
    }
}
