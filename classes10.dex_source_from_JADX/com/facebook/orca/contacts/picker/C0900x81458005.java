package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: old_id */
public class C0900x81458005 extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    public Object get() {
        return MessagesContactPickerModule.a(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 5374));
    }
}
