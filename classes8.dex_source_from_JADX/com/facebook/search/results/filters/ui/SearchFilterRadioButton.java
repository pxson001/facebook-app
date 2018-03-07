package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import com.facebook.resources.ui.FbRadioButton;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: SLIDESHOW_NUX */
public class SearchFilterRadioButton extends CustomRelativeLayout implements Checkable {
    public BetterTextView f22894a;
    public FbRadioButton f22895b;
    private boolean f22896c;

    public SearchFilterRadioButton(Context context) {
        this(context, null);
    }

    private SearchFilterRadioButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SearchFilterRadioButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906994);
        this.f22894a = (BetterTextView) a(2131558927);
        this.f22895b = (FbRadioButton) a(2131566534);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131431622);
        setPadding(getPaddingLeft(), dimensionPixelSize, getPaddingRight(), dimensionPixelSize);
    }

    public void setTitle(CharSequence charSequence) {
        this.f22894a.setText(charSequence);
    }

    public void setChecked(boolean z) {
        if (this.f22896c != z) {
            this.f22896c = z;
            this.f22895b.setChecked(z);
            super.refreshDrawableState();
        }
    }

    public boolean isChecked() {
        return this.f22896c;
    }

    public void toggle() {
        if (!this.f22896c) {
            setChecked(true);
        }
    }
}
