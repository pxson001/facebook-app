package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.messaging.business.common.view.BusinessPairTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: thread_group_button_video */
public class AirlineItineraryFlightInfoView extends CustomLinearLayout {
    private final BusinessPairTextView f1587a;
    private final BusinessPairTextView f1588b;
    private final BusinessPairTextView f1589c;
    private final BusinessPairTextView f1590d;
    private final BusinessPairTextView f1591e;
    private final BusinessPairTextView f1592f;

    public AirlineItineraryFlightInfoView(Context context) {
        this(context, null, 0);
    }

    public AirlineItineraryFlightInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AirlineItineraryFlightInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903217);
        this.f1590d = (BusinessPairTextView) a(2131559514);
        this.f1591e = (BusinessPairTextView) a(2131559519);
        this.f1587a = (BusinessPairTextView) a(2131559517);
        this.f1588b = (BusinessPairTextView) a(2131559515);
        this.f1589c = (BusinessPairTextView) a(2131559516);
        this.f1592f = (BusinessPairTextView) a(2131559518);
        setOrientation(1);
    }
}
