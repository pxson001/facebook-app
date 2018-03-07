package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.facebook.messaging.business.common.view.BusinessPairTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: thread_group_button */
public class AirlineItineraryReceiptView extends CustomLinearLayout {
    private final BusinessPairTextView f1593a;
    private final BusinessPairTextView f1594b;
    private final BusinessPairTextView f1595c;
    private final BetterTextView f1596d;
    private final LinearLayout f1597e;
    private final LayoutInflater f1598f;

    public AirlineItineraryReceiptView(Context context) {
        this(context, null, 0);
    }

    public AirlineItineraryReceiptView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected AirlineItineraryReceiptView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903222);
        setOrientation(1);
        this.f1598f = LayoutInflater.from(context);
        this.f1597e = (LinearLayout) a(2131559524);
        this.f1593a = (BusinessPairTextView) a(2131559525);
        this.f1594b = (BusinessPairTextView) a(2131559526);
        this.f1595c = (BusinessPairTextView) a(2131559527);
        this.f1596d = (BetterTextView) a(2131559523);
        m1576a();
    }

    private void m1576a() {
        this.f1595c.setTextStyle(2131626468);
        this.f1595c.setTitleStyle(2131626468);
    }
}
