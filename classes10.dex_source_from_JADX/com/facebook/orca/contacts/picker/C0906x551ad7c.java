package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: of */
public class C0906x551ad7c extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    public Object get() {
        return MessagesContactPickerModule.d(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 5377));
    }
}
