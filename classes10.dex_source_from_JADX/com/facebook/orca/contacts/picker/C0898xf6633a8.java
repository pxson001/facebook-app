package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: old_ts */
public class C0898xf6633a8 extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    public static BaseSearchableContactPickerListAdapter m5652b(InjectorLike injectorLike) {
        return MessagesContactPickerModule.f(DivebarContactPickerViewFactory.m5790b(injectorLike), IdBasedProvider.a(injectorLike, 5372));
    }

    public Object get() {
        return MessagesContactPickerModule.f(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 5372));
    }
}
