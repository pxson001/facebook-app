package com.facebook.payments.shipping.optionpicker;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.payments.picker.RowItemView;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.PaymentsComponentLinearLayout;
import com.facebook.widget.CustomViewUtils;

/* compiled from: backstage_entry */
public class ShippingOptionRowItemView extends PaymentsComponentLinearLayout implements RowItemView<ShippingOptionRowItem> {
    public TextView f19036a = ((TextView) a(2131567433));
    public GlyphView f19037b = ((GlyphView) a(2131560317));
    public String f19038c;

    public ShippingOptionRowItemView(Context context) {
        super(context);
        setContentView(2130907084);
        setOrientation(0);
        CustomViewUtils.b(this, new ColorDrawable(getResources().getColor(2131361920)));
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433345);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131433346);
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    public final void mo658a() {
        Bundle bundle = new Bundle();
        bundle.putString("extra_user_action", this.f19038c);
        a(new PaymentsComponentAction(Action.USER_ACTION, bundle));
    }
}
