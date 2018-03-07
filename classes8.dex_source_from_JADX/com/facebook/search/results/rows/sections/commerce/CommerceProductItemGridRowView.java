package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: RECOVERY_SUCCESS */
public class CommerceProductItemGridRowView extends CustomLinearLayout {
    public final CommerceProductGridItemView f23926a;
    public final CommerceProductGridItemView f23927b;

    public CommerceProductItemGridRowView(Context context) {
        this(context, null);
    }

    public CommerceProductItemGridRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommerceProductItemGridRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906982);
        setOrientation(0);
        this.f23926a = (CommerceProductGridItemView) a(2131567271);
        this.f23927b = (CommerceProductGridItemView) a(2131567272);
    }

    public CommerceProductGridItemView getFirstProductView() {
        return this.f23926a;
    }

    public CommerceProductGridItemView getSecondProductView() {
        return this.f23927b;
    }
}
