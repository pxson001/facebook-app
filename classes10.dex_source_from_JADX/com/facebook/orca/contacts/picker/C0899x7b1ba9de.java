package com.facebook.orca.contacts.picker;

import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contacts.picker.util.MessagingContactLoggingHelper;

/* compiled from: old_password */
public class C0899x7b1ba9de extends AbstractProvider<BaseSearchableContactPickerListAdapter> {
    public static BaseSearchableContactPickerListAdapter m5653b(InjectorLike injectorLike) {
        return MessagesContactPickerModule.a(DivebarContactPickerViewFactory.m5790b(injectorLike), IdBasedProvider.a(injectorLike, 5373), MessagingContactLoggingHelper.m1884b(injectorLike));
    }

    public Object get() {
        return MessagesContactPickerModule.a(DivebarContactPickerViewFactory.m5790b((InjectorLike) this), IdBasedProvider.a(this, 5373), MessagingContactLoggingHelper.m1884b((InjectorLike) this));
    }
}
