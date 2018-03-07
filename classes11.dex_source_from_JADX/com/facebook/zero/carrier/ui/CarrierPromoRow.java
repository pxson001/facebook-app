package com.facebook.zero.carrier.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.zero.carrier.model.CarrierPromoRowModel;
import com.facebook.zero.carrier.model.CarrierPromoSubRowModel;
import com.google.common.collect.ImmutableList;

/* compiled from: music.dmkt-sp.jp */
public class CarrierPromoRow extends CustomLinearLayout {
    public ImageView f5328a = ((ImageView) a(2131560244));
    public TextView f5329b = ((TextView) a(2131560245));
    public TextView f5330c = ((TextView) a(2131560246));
    public ViewGroup f5331d = ((ViewGroup) a(2131560243));

    public CarrierPromoRow(Context context) {
        super(context);
        setContentView(2130903512);
    }

    public final void m6574a(CarrierPromoRowModel carrierPromoRowModel) {
        this.f5328a.setImageResource(carrierPromoRowModel.f5315a);
        this.f5329b.setText(carrierPromoRowModel.f5316b);
        this.f5329b.setContentDescription(carrierPromoRowModel.f5316b);
        this.f5330c.setText(carrierPromoRowModel.f5317c);
        this.f5330c.setContentDescription(carrierPromoRowModel.f5317c);
        if (carrierPromoRowModel.f5318d) {
            this.f5329b.setTextColor(getResources().getColor(2131363901));
        }
        LayoutInflater from = LayoutInflater.from(getContext());
        for (CarrierPromoSubRowModel carrierPromoSubRowModel : ImmutableList.copyOf(carrierPromoRowModel.f5319e)) {
            View inflate = from.inflate(2130903513, this.f5331d, false);
            TextView textView = (TextView) inflate.findViewById(2131560247);
            textView.setText(carrierPromoSubRowModel.f5320a);
            textView.setContentDescription(carrierPromoSubRowModel.f5320a);
            textView = (TextView) inflate.findViewById(2131560248);
            textView.setText(carrierPromoSubRowModel.f5321b);
            textView.setContentDescription(carrierPromoSubRowModel.f5321b);
            this.f5331d.addView(CarrierManagerUiHelper.m6573a(getContext()));
            this.f5331d.addView(inflate);
        }
    }
}
