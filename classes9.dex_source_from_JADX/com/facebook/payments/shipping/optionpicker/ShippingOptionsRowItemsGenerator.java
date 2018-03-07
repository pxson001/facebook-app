package com.facebook.payments.shipping.optionpicker;

import com.facebook.payments.paymentmethods.picker.RowItemsGenerator;
import com.facebook.payments.paymentmethods.picker.SimplePickerScreenManager;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.shipping.model.ShippingOption;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: backstage_emote_flow_sent */
public class ShippingOptionsRowItemsGenerator implements RowItemsGenerator<ShippingOptionPickerScreenData> {
    private final SimplePickerScreenManager f19042a;

    public final ImmutableList mo652a(PickerScreenData pickerScreenData) {
        ShippingOptionPickerScreenData shippingOptionPickerScreenData = (ShippingOptionPickerScreenData) pickerScreenData;
        Builder builder = new Builder();
        Iterator it = this.f19042a.m18837c(shippingOptionPickerScreenData.mo752a().mo743a().f18786c).mo655a(shippingOptionPickerScreenData).values().iterator();
        while (it.hasNext()) {
            ShippingOptionSectionType shippingOptionSectionType = (ShippingOptionSectionType) it.next();
            switch (shippingOptionSectionType) {
                case SHIPPING_OPTIONS:
                    ImmutableList immutableList = shippingOptionPickerScreenData.f19025a.f19028b;
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        ShippingOption shippingOption = (ShippingOption) immutableList.get(i);
                        builder.c(new ShippingOptionRowItem(shippingOption.mo647b(), shippingOption.mo646a().equals(shippingOptionPickerScreenData.f19026b), shippingOption.mo646a()));
                    }
                default:
                    throw new IllegalArgumentException("Unhandled section type " + shippingOptionSectionType);
            }
        }
        return builder.b();
    }

    @Inject
    public ShippingOptionsRowItemsGenerator(SimplePickerScreenManager simplePickerScreenManager) {
        this.f19042a = simplePickerScreenManager;
    }
}
