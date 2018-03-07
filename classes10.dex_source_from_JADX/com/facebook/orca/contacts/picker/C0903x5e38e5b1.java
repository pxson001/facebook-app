package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: og_object */
public class C0903x5e38e5b1 extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    private static BaseSearchableContactPickerListAdapter m5656b(InjectorLike injectorLike) {
        return MessagesContactPickerModule.j(DivebarContactPickerViewFactory.m5790b(injectorLike), IdBasedProvider.a(injectorLike, 7754));
    }

    public Object get() {
        return MessagesContactPickerModule.j(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 7754));
    }
}
