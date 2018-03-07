package com.facebook.socialgood.ui;

import android.content.Context;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: ONAVO_COUNT */
public class FundraiserDonationPaymentMethodView extends CustomRelativeLayout {
    public static final CallerContext f12826a = CallerContext.a(FundraiserDonationPaymentMethodView.class);
    public FbDraweeView f12827b = ((FbDraweeView) a(2131562450));
    public TextView f12828c = ((TextView) a(2131562451));
    public ToggleButton f12829d = ((ToggleButton) a(2131562452));

    public FundraiserDonationPaymentMethodView(Context context) {
        super(context);
        setContentView(2130904559);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131434484);
        setPadding(dimensionPixelSize, getPaddingTop(), dimensionPixelSize, getPaddingBottom());
        setBackgroundResource(2130840519);
    }

    public final void m13490a() {
        this.f12827b.a(null, f12826a);
        this.f12827b.setVisibility(8);
    }

    public void setText(String str) {
        this.f12828c.setText(str);
    }

    public final void m13491c() {
        setSelected(false);
        this.f12829d.setChecked(false);
        this.f12829d.setVisibility(4);
    }
}
