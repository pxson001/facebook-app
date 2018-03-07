package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.messaging.business.airline.enums.AirlineBubbleType;
import com.facebook.messaging.business.common.view.BusinessPairTextView;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineFlightInfoModel;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: thread_group_upsell_name */
public class AirlineFlightRouteView extends CustomLinearLayout {
    private final ImmutableList<BusinessPairTextView> f1576a;
    private final AirlineAirportRouteView f1577b;
    private AirlineBubbleType f1578c;

    public AirlineFlightRouteView(Context context) {
        this(context, null, 0);
    }

    public AirlineFlightRouteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AirlineFlightRouteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1578c = AirlineBubbleType.CHECKIN;
        setContentView(2130903206);
        setOrientation(1);
        this.f1576a = ImmutableList.of((BusinessPairTextView) a(2131559488), (BusinessPairTextView) a(2131559489), (BusinessPairTextView) a(2131559490));
        this.f1577b = (AirlineAirportRouteView) a(2131559491);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AirlineView);
            this.f1578c = AirlineBubbleType.values()[obtainStyledAttributes.getInt(2, 0)];
            obtainStyledAttributes.recycle();
        }
        m1569a();
    }

    private void m1569a() {
        if (this.f1578c == AirlineBubbleType.DELAYED) {
            ((BusinessPairTextView) this.f1576a.get(1)).setTextStyle(2131626473);
            ((BusinessPairTextView) this.f1576a.get(2)).setTextStyle(2131626473);
        } else if (this.f1578c == AirlineBubbleType.BOARDING) {
            int size = this.f1576a.size();
            for (int i = 0; i < size; i++) {
                ((BusinessPairTextView) this.f1576a.get(i)).a();
            }
            this.f1577b.m1547a();
        }
    }

    private void m1570a(String str, int i) {
        ((BusinessPairTextView) this.f1576a.get(i)).setTitle(str);
    }

    public void setTitles(List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m1570a((String) list.get(i), i);
        }
    }

    private void m1571b(String str, int i) {
        ((BusinessPairTextView) this.f1576a.get(i)).setText(str);
    }

    public void setTexts(List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m1571b((String) list.get(i), i);
        }
    }

    public void setAirportRouteInfo(AirlineFlightInfoModel airlineFlightInfoModel) {
        this.f1577b.m1548a(airlineFlightInfoModel);
    }

    public void setTintColor(int i) {
        this.f1577b.setTintColor(i);
    }
}
