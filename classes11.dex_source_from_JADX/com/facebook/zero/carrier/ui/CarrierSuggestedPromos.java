package com.facebook.zero.carrier.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.iorg.common.upsell.server.UpsellPromo;
import com.facebook.widget.CustomLinearLayout;
import java.util.List;

/* compiled from: multiline */
public class CarrierSuggestedPromos extends CustomLinearLayout {
    public ViewGroup f5336a = ((ViewGroup) a(2131560253));

    /* compiled from: multiline */
    public class CarrierSuggestedPromosRow extends CustomLinearLayout {
        public TextView f5332a = ((TextView) a(2131560250));
        public TextView f5333b = ((TextView) a(2131560251));
        public View f5334c = a(2131560252);
        public ImageView f5335d = ((ImageView) a(2131560249));

        public CarrierSuggestedPromosRow(Context context) {
            super(context);
            setContentView(2130903514);
        }

        public final void m6575a(UpsellPromo upsellPromo, OnClickListener onClickListener) {
            String str;
            this.f5335d.setImageResource(CarrierManagerUiHelper.m6572a(upsellPromo, false));
            if (upsellPromo.g) {
                str = upsellPromo.b;
            } else {
                str = getResources().getString(2131241751, new Object[]{upsellPromo.b, upsellPromo.f});
            }
            String str2 = str;
            this.f5332a.setText(str2);
            this.f5332a.setContentDescription(str2);
            this.f5334c.setTag(upsellPromo);
            this.f5334c.setOnClickListener(onClickListener);
            if (upsellPromo.j) {
                this.f5334c.setVisibility(0);
                this.f5335d.setAlpha(255);
                this.f5332a.setTextColor(-16777216);
                this.f5333b.setVisibility(8);
                return;
            }
            this.f5334c.setVisibility(4);
            this.f5335d.setAlpha(100);
            this.f5332a.setTextColor(Color.argb(100, 0, 0, 0));
            this.f5333b.setVisibility(0);
            this.f5333b.setTextColor(Color.argb(100, 0, 0, 0));
            this.f5333b.setText(2131241762);
            this.f5333b.setContentDescription(getResources().getString(2131241762));
        }
    }

    public CarrierSuggestedPromos(Context context) {
        super(context);
        setContentView(2130903515);
    }

    public final void m6576a(List<UpsellPromo> list, OnClickListener onClickListener) {
        for (UpsellPromo upsellPromo : list) {
            if (!upsellPromo.i) {
                CarrierSuggestedPromosRow carrierSuggestedPromosRow = new CarrierSuggestedPromosRow(getContext());
                carrierSuggestedPromosRow.m6575a(upsellPromo, onClickListener);
                this.f5336a.addView(CarrierManagerUiHelper.m6573a(getContext()));
                this.f5336a.addView(carrierSuggestedPromosRow);
            }
        }
    }
}
