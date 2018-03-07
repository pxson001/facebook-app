package com.facebook.fig.header;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.fig.common.FigTextHelper;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ultralight.Inject;

/* compiled from: SEND_MESSAGE_TO_GUESTS */
public class FigHeader extends ImageBlockLayout {
    @Inject
    AllCapsTransformationMethod f23851h;
    public FigTextHelper f23852i;
    @ActionType
    public int f23853j;
    private Drawable f23854k;
    public CharSequence f23855l;
    private int f23856m;

    /* compiled from: SEND_MESSAGE_TO_GUESTS */
    public @interface ActionType {
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setThumbnailPadding(int i) {
    }

    public void setThumbnailSize(int i) {
    }

    protected final void m25998a(int i, int i2) {
        this.f23852i.c(i);
        b(Math.max(0, this.f23852i.b()), this.f23852i.c() + 0);
    }

    protected final void m25999a(int i, int i2, int i3) {
        this.f23852i.a(c(), i, ((this.f23856m - this.f23852i.c()) / 2) + i2, i3);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f23852i.a(canvas);
    }

    public void setTitleText(int i) {
        this.f23852i.a(getContext().getText(i));
        requestLayout();
        invalidate();
    }

    public void setActionText(int i) {
        CharSequence string = getResources().getString(i);
        this.f23855l = string;
        if (this.f23853j == 1) {
            ((FbTextView) this.a).setText(string);
        }
        requestLayout();
        invalidate();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.f23852i.a(accessibilityEvent);
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public void setActionType(@ActionType int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131432671);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.b = true;
        layoutParams.d = 17;
        layoutParams.leftMargin = 0;
        if (i != this.f23853j) {
            this.f23853j = i;
            if (this.a != null) {
                super.removeView(this.a);
            }
            GlyphView glyphView;
            switch (i) {
                case 1:
                    FbTextView fbTextView = new FbTextView(getContext());
                    fbTextView.setText(this.f23855l);
                    fbTextView.setTransformationMethod(this.f23851h);
                    fbTextView.setTextAppearance(getContext(), 2131624532);
                    super.addView(fbTextView, 0, layoutParams);
                    break;
                case 2:
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.width = dimensionPixelSize;
                    glyphView = new GlyphView(getContext());
                    glyphView.setGlyphColor(ContextCompat.b(getContext(), 2131362108));
                    glyphView.setImageDrawable(ContextCompat.a(getContext(), 2130839667));
                    super.addView(glyphView, 0, layoutParams);
                    break;
                case 3:
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.width = dimensionPixelSize;
                    glyphView = new GlyphView(getContext());
                    glyphView.setGlyphColor(ContextCompat.b(getContext(), 2131362108));
                    glyphView.setImageDrawable(this.f23854k);
                    super.addView(glyphView, 0, layoutParams);
                    break;
            }
        }
        requestLayout();
        invalidate();
    }

    public void setActionDrawable(Drawable drawable) {
        this.f23854k = drawable;
        requestLayout();
        invalidate();
    }

    public void setActionDrawable(int i) {
        this.f23854k = ContextCompat.a(getContext(), i);
        requestLayout();
        invalidate();
    }

    public void setActionOnClickListener(OnClickListener onClickListener) {
        if (this.a != null) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void setActionContentDescription(CharSequence charSequence) {
        if (this.a != null) {
            this.a.setContentDescription(charSequence);
        }
    }
}
