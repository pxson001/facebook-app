package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: offersite */
public class C0905xcbfa9e26 extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    private static BaseSearchableContactPickerListAdapter m5658b(InjectorLike injectorLike) {
        return MessagesContactPickerModule.g(DivebarContactPickerViewFactory.m5790b(injectorLike), IdBasedProvider.a(injectorLike, 5376));
    }

    public Object get() {
        return MessagesContactPickerModule.g(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 5376));
    }
}
