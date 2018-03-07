package com.facebook.messaging.payment.ui;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.payment.ui.model.PlatformCommerceAmountViewParams;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: facebook_id */
public class PlatformCommerceAmountView extends CustomLinearLayout {
    private final LinearLayout f15139a;
    private final BetterTextView f15140b;
    private final BetterTextView f15141c;
    private final BetterTextView f15142d;
    private final BetterTextView f15143e;
    private final ProgressBar f15144f;
    private final LinearLayout f15145g;
    private final LinearLayout f15146h;
    private PlatformCommerceAmountViewParams f15147i;

    public PlatformCommerceAmountView(Context context) {
        this(context, null);
    }

    public PlatformCommerceAmountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlatformCommerceAmountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906294);
        this.f15139a = (LinearLayout) a(2131566079);
        this.f15140b = (BetterTextView) a(2131566081);
        this.f15141c = (BetterTextView) a(2131566084);
        this.f15142d = (BetterTextView) a(2131566087);
        this.f15143e = (BetterTextView) a(2131566089);
        this.f15144f = (ProgressBar) a(2131566090);
        this.f15145g = (LinearLayout) a(2131566082);
        this.f15146h = (LinearLayout) a(2131566085);
    }

    public final void m15509a() {
        this.f15144f.setVisibility(0);
        this.f15139a.setAlpha(0.2f);
    }

    public final void m15510b() {
        this.f15144f.setVisibility(8);
        this.f15139a.setAlpha(1.0f);
    }

    public void setViewParams(PlatformCommerceAmountViewParams platformCommerceAmountViewParams) {
        this.f15147i = platformCommerceAmountViewParams;
        this.f15140b.setText(this.f15147i.f15154a);
        m15508a(this.f15145g, this.f15141c, this.f15147i.f15155b, 2131240551);
        m15508a(this.f15146h, this.f15142d, this.f15147i.f15156c, 2131240552);
        this.f15143e.setText(this.f15147i.f15157d);
    }

    private void m15508a(LinearLayout linearLayout, BetterTextView betterTextView, @Nullable String str, @StringRes int i) {
        if (str == null) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        if (StringUtil.a(str)) {
            betterTextView.setText(i);
            betterTextView.setTextColor(getResources().getColor(2131363623));
            return;
        }
        betterTextView.setText(str);
    }
}
