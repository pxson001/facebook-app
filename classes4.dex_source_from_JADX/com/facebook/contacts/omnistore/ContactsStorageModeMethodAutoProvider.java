package com.facebook.contacts.omnistore;

import com.facebook.contacts.properties.ContactsStorageMode;
import com.facebook.inject.AbstractProvider;

/* compiled from: inline_notification_nux_first_seen_time */
public class ContactsStorageModeMethodAutoProvider extends AbstractProvider<ContactsStorageMode> {
    public Object get() {
        return ContactsOmnistoreModule.m10852a(Boolean_IsOmnistoreContactsEnabledGatekeeperAutoProvider.m10851b(this));
    }
}
