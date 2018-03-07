package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: object_type */
public class C0907x823b4327 extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    public Object get() {
        return MessagesContactPickerModule.b(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 5378));
    }
}
