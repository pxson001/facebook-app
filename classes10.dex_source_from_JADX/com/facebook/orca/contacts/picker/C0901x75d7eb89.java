package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: oldUnit */
public class C0901x75d7eb89 extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    private static BaseSearchableContactPickerListAdapter m5654b(InjectorLike injectorLike) {
        return MessagesContactPickerModule.e(DivebarContactPickerViewFactory.m5790b(injectorLike), IdBasedProvider.a(injectorLike, 7751));
    }

    public Object get() {
        return MessagesContactPickerModule.e(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 7751));
    }
}
