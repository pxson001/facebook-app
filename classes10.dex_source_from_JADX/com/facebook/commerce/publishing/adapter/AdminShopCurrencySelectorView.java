package com.facebook.commerce.publishing.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.widget.text.BetterEditTextView;
import com.google.common.base.Preconditions;

/* compiled from: data bits cannot fit in the QR Code */
public class AdminShopCurrencySelectorView extends BetterEditTextView {
    private final Drawable f15481b;
    private final ColorStateList f15482c;
    private boolean f15483d;

    public AdminShopCurrencySelectorView(Context context) {
        this(context, null);
    }

    public AdminShopCurrencySelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdminShopCurrencySelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15483d = false;
        this.f15482c = getDropdownIconAndTextColorStateList();
        setTextColor(this.f15482c);
        this.f15481b = getDropdownIconWithIntrinsicBounds();
        TextViewUtils.a(this, null, null, this.f15481b, null);
        m16005b();
        this.f15483d = true;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f15483d) {
            m16005b();
        }
    }

    private void m16005b() {
        int colorForState = this.f15482c.getColorForState(getDrawableState(), -1);
        if (colorForState != -1) {
            this.f15481b.setColorFilter(colorForState, Mode.SRC_IN);
        }
    }

    private Drawable getDropdownIconWithIntrinsicBounds() {
        Drawable drawable = (Drawable) Preconditions.checkNotNull(getResources().getDrawable(2130843763));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }

    private ColorStateList getDropdownIconAndTextColorStateList() {
        return getContext().getResources().getColorStateList(2131364034);
    }
}
