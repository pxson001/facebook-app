package com.facebook.payments.picker;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.picker.model.HeaderRowItem;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.ui.PaymentsComponentViewGroup;

/* compiled from: bcda3805450a9665a4a360760b062c90 */
public class HeaderItemView extends PaymentsComponentViewGroup implements RowItemView {
    public TextView f18881a = ((TextView) getView(2131562867));

    public HeaderItemView(Context context) {
        super(context);
        setContentView(2130904758);
    }

    public final void m18887a(RowItem rowItem) {
        HeaderRowItem headerRowItem = (HeaderRowItem) rowItem;
        if (!StringUtil.a(headerRowItem.f18885a)) {
            this.f18881a.setText(headerRowItem.f18885a);
        }
    }

    public final void mo658a() {
    }
}
