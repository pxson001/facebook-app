package com.facebook.payments.paymentmethods.picker.model;

import com.facebook.common.locale.Country;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: body= */
public class CountrySelectorRowItem implements RowItem {
    public final Country f18838a;
    public final boolean f18839b;
    public final PickerScreenCommonParams f18840c;

    public CountrySelectorRowItem(PickerScreenCommonParams pickerScreenCommonParams, Country country, boolean z) {
        this.f18840c = pickerScreenCommonParams;
        this.f18838a = country;
        this.f18839b = z;
    }

    public final RowType mo657a() {
        return RowType.COUNTRY_SELECTOR;
    }
}
