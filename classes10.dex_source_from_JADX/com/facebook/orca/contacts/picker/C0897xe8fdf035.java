package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: omit_unseen_stories */
public class C0897xe8fdf035 extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    private static BaseSearchableContactPickerListAdapter m5651b(InjectorLike injectorLike) {
        return MessagesContactPickerModule.i(DivebarContactPickerViewFactory.m5790b(injectorLike), IdBasedProvider.a(injectorLike, 7752));
    }

    public Object get() {
        return MessagesContactPickerModule.i(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 7752));
    }
}
