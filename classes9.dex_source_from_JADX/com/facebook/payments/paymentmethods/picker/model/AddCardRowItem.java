package com.facebook.payments.paymentmethods.picker.model;

import android.content.Intent;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;

/* compiled from: bookmarkSetFavorites */
public class AddCardRowItem implements RowItem {
    public final Intent f18828a;
    public final int f18829b;

    public AddCardRowItem(Intent intent, int i) {
        this.f18828a = intent;
        this.f18829b = i;
    }

    public final RowType mo657a() {
        return RowType.ADD_CARD;
    }
}
