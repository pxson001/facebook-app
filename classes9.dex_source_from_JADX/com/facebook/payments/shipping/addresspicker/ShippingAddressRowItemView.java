package com.facebook.payments.shipping.addresspicker;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.payments.picker.RowItemView;
import com.facebook.payments.shipping.model.ShippingAddressRowItem;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.PaymentsComponentLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Preconditions;

/* compiled from: base_entity_id */
public class ShippingAddressRowItemView extends PaymentsComponentLinearLayout implements RowItemView<ShippingAddressRowItem> {
    public FloatingLabelTextView f18890a = ((FloatingLabelTextView) a(2131567432));
    public GlyphView f18891b = ((GlyphView) a(2131560317));
    public ShippingAddressRowItem f18892c;

    public ShippingAddressRowItemView(Context context) {
        super(context);
        setContentView(2130907083);
        setOrientation(0);
        CustomViewUtils.b(this, new ColorDrawable(getResources().getColor(2131361920)));
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433344);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    public final void mo658a() {
        switch (this.f18892c.f18981a) {
            case CHECKOUT:
                Bundle bundle = new Bundle();
                bundle.putString("extra_user_action", this.f18892c.f18986f.mo760a());
                a(new PaymentsComponentAction(Action.USER_ACTION, bundle));
                return;
            case OTHERS:
                Preconditions.checkNotNull(this.f18892c.f18982b);
                this.a.a(this.f18892c.f18982b, this.f18892c.f18983c);
                return;
            default:
                throw new IllegalArgumentException("Unhandled " + this.f18892c.f18981a);
        }
    }
}
