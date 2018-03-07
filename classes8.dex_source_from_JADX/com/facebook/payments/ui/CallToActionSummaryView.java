package com.facebook.payments.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.util.SizeUtil;
import javax.annotation.Nullable;

/* compiled from: subtitle_annotation */
public class CallToActionSummaryView extends PaymentsSecurityInfoView {
    public CallToActionSummaryView(Context context) {
        super(context);
        m2187a();
    }

    public CallToActionSummaryView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2187a();
    }

    public CallToActionSummaryView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2187a();
    }

    private void m2187a() {
        super.setTextSize((float) SizeUtil.c(getResources(), 2131427402));
    }
}
