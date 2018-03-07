package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: ogshare */
public class C0902x4b655a75 extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    private static BaseSearchableContactPickerListAdapter m5655b(InjectorLike injectorLike) {
        return MessagesContactPickerModule.h(DivebarContactPickerViewFactory.m5790b(injectorLike), IdBasedProvider.a(injectorLike, 7753));
    }

    public Object get() {
        return MessagesContactPickerModule.h(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 7753));
    }
}
