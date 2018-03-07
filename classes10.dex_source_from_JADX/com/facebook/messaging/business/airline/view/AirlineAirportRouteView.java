package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.facebook.R;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineFlightInfoModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirportInfoModel;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: thread_key_extra */
public class AirlineAirportRouteView extends CustomLinearLayout {
    private final BetterTextView f1539a;
    private final BetterTextView f1540b;
    private final BetterTextView f1541c;
    private final BetterTextView f1542d;
    private final FbDraweeView f1543e;

    public AirlineAirportRouteView(Context context) {
        this(context, null, 0);
    }

    public AirlineAirportRouteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AirlineAirportRouteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903199);
        this.f1539a = (BetterTextView) a(2131559465);
        this.f1540b = (BetterTextView) a(2131559462);
        this.f1541c = (BetterTextView) a(2131559467);
        this.f1542d = (BetterTextView) a(2131559463);
        this.f1543e = (FbDraweeView) a(2131559466);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433787);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131433790);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AirlineAirportRouteView);
            dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, dimensionPixelSize);
            dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize2);
            obtainStyledAttributes.recycle();
        }
        this.f1539a.setTextSize(0, (float) dimensionPixelSize);
        this.f1541c.setTextSize(0, (float) dimensionPixelSize);
        LayoutParams layoutParams = this.f1543e.getLayoutParams();
        layoutParams.width = dimensionPixelSize2;
        layoutParams.height = dimensionPixelSize2;
        this.f1543e.setLayoutParams(layoutParams);
        setTintColor(getResources().getColor(2131363824));
        setOrientation(1);
    }

    public final void m1548a(AirlineFlightInfoModel airlineFlightInfoModel) {
        Preconditions.checkNotNull(airlineFlightInfoModel);
        setDepartureAirport(airlineFlightInfoModel.aW_());
        setArrivalAirport(airlineFlightInfoModel.b());
    }

    public void setDepartureAirport(@Nullable AirportInfoModel airportInfoModel) {
        if (airportInfoModel == null) {
            setVisibility(8);
            return;
        }
        this.f1539a.setText(airportInfoModel.a());
        this.f1540b.setText(airportInfoModel.b());
    }

    public void setArrivalAirport(@Nullable AirportInfoModel airportInfoModel) {
        if (airportInfoModel == null) {
            setVisibility(8);
            return;
        }
        this.f1541c.setText(airportInfoModel.a());
        this.f1542d.setText(airportInfoModel.b());
    }

    public void setTintColor(int i) {
        this.f1539a.setTextColor(i);
        this.f1541c.setTextColor(i);
        this.f1543e.setColorFilter(i);
    }

    public final void m1547a() {
        setTintColor(-1);
        this.f1540b.setTextAppearance(getContext(), 2131626471);
        this.f1542d.setTextAppearance(getContext(), 2131626471);
    }
}
