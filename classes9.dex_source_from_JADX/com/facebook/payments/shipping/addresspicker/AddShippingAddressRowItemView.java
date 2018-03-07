package com.facebook.payments.shipping.addresspicker;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.picker.RowItemView;
import com.facebook.payments.shipping.form.ShippingAddressActivity;
import com.facebook.payments.ui.PaymentsComponentViewGroup;

/* compiled from: basicwebview_tts_npe */
public class AddShippingAddressRowItemView extends PaymentsComponentViewGroup implements OnClickListener, RowItemView<AddShippingAddressRowItem> {
    public AddShippingAddressRowItem f18888a;

    public AddShippingAddressRowItemView(Context context) {
        super(context);
        setContentView(2130907101);
        ((TextView) getView(2131567450)).setText(getContext().getString(2131240116));
    }

    public final void mo658a() {
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -562024156);
        a(ShippingAddressActivity.m18920a(getContext(), this.f18888a.f18887a), 101);
        Logger.a(2, EntryType.UI_INPUT_END, 404227686, a);
    }
}
