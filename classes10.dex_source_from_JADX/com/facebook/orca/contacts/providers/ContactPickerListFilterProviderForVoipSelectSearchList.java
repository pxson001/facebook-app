package com.facebook.orca.contacts.providers;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.SystemClock;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerMergedFilter;
import com.facebook.contacts.picker.ContactPickerMergedFilter.ContactPickerSubFilterConfig;
import com.facebook.messaging.contacts.picker.ContactPickerFriendFilter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: num_admin_in_thread */
public class ContactPickerListFilterProviderForVoipSelectSearchList {
    public static ContactPickerListFilter m5823a(SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, AbstractFbErrorReporter abstractFbErrorReporter, ContactPickerFriendFilter contactPickerFriendFilter) {
        Builder builder = ImmutableList.builder();
        contactPickerFriendFilter.f1793i = true;
        builder.c(new ContactPickerSubFilterConfig(contactPickerFriendFilter, null, true));
        return new ContactPickerMergedFilter(builder.b(), systemClock, scheduledExecutorService, abstractFbErrorReporter);
    }
}
