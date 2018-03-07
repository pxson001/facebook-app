package com.facebook.orca.contacts.picker;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contacts.picker.ContactPickerRowsFactory;
import javax.inject.Inject;

/* compiled from: num_threads_tried_to_fetch */
public class DefaultCallLogPickerRowCreator {
    private final ContactPickerRowsFactory f6085a;

    private static DefaultCallLogPickerRowCreator m5788b(InjectorLike injectorLike) {
        return new DefaultCallLogPickerRowCreator(ContactPickerRowsFactory.m1786b(injectorLike));
    }

    @Inject
    DefaultCallLogPickerRowCreator(ContactPickerRowsFactory contactPickerRowsFactory) {
        this.f6085a = contactPickerRowsFactory;
    }
}
