package com.facebook.orca.contacts.providers;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.SystemClock;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerMergedFilter;
import com.facebook.contacts.picker.ContactPickerMergedFilter.ContactPickerSubFilterConfig;
import com.facebook.messaging.contacts.picker.ContactPickerFriendFilter;
import com.facebook.orca.contacts.picker.ContactPickerNonFriendUsersFilter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: num_images */
public class ContactPickerListFilterProviderForFacebookList {
    public static ContactPickerListFilter m5818a(SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, AbstractFbErrorReporter abstractFbErrorReporter, ContactPickerFriendFilter contactPickerFriendFilter, ContactPickerNonFriendUsersFilter contactPickerNonFriendUsersFilter, boolean z) {
        boolean z2;
        Builder builder = ImmutableList.builder();
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        contactPickerFriendFilter.d = z2;
        builder.c(new ContactPickerSubFilterConfig(contactPickerFriendFilter, null, true));
        builder.c(new ContactPickerSubFilterConfig(contactPickerNonFriendUsersFilter, null, false));
        return new ContactPickerMergedFilter(builder.b(), systemClock, scheduledExecutorService, abstractFbErrorReporter);
    }
}
