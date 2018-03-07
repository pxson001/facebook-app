package com.facebook.orca.contacts.providers;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.picker.ContactPickerDelayingListFilter;
import com.facebook.contacts.picker.ContactPickerDelayingListFilter.DelayPolicy;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerMergedFilter;
import com.facebook.contacts.picker.ContactPickerMergedFilter.ContactPickerSubFilterConfig;
import com.facebook.messaging.contacts.picker.ContactPickerDbGroupFilter;
import com.facebook.messaging.contacts.picker.ContactPickerFriendFilter;
import com.facebook.orca.contacts.picker.ContactPickerServerGroupFilter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: num_deltas_in_batch */
public class ContactPickerListFilterProviderForVoipGroupCallList {
    public static final DelayPolicy f6110a = new C09311();

    /* compiled from: num_deltas_in_batch */
    final class C09311 implements DelayPolicy {
        C09311() {
        }

        public final long m5819a(CharSequence charSequence) {
            if (StringUtil.a(new CharSequence[]{charSequence})) {
                return 0;
            }
            int codePointCount = Character.codePointCount(charSequence, 0, charSequence.length());
            if (codePointCount >= 3) {
                return 0;
            }
            if (codePointCount == 2) {
                return 300;
            }
            return 500;
        }
    }

    public static ContactPickerListFilter m5820a(SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, AbstractFbErrorReporter abstractFbErrorReporter, ContactPickerFriendFilter contactPickerFriendFilter, Resources resources, ContactPickerDbGroupFilter contactPickerDbGroupFilter, ContactPickerServerGroupFilter contactPickerServerGroupFilter) {
        return new ContactPickerMergedFilter(m5822a(contactPickerFriendFilter, contactPickerDbGroupFilter, contactPickerServerGroupFilter, systemClock, scheduledExecutorService, abstractFbErrorReporter, resources), systemClock, scheduledExecutorService, abstractFbErrorReporter);
    }

    private static ImmutableList<ContactPickerSubFilterConfig> m5822a(ContactPickerFriendFilter contactPickerFriendFilter, ContactPickerDbGroupFilter contactPickerDbGroupFilter, ContactPickerServerGroupFilter contactPickerServerGroupFilter, SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, FbErrorReporter fbErrorReporter, Resources resources) {
        Builder builder = ImmutableList.builder();
        contactPickerFriendFilter.f1793i = true;
        builder.c(new ContactPickerSubFilterConfig(contactPickerFriendFilter, null, true));
        builder.c(new ContactPickerSubFilterConfig(new ContactPickerMergedFilter(m5821a(contactPickerDbGroupFilter, contactPickerServerGroupFilter, scheduledExecutorService), systemClock, scheduledExecutorService, fbErrorReporter), resources.getString(2131231197), false));
        return builder.b();
    }

    private static ImmutableList<ContactPickerSubFilterConfig> m5821a(ContactPickerDbGroupFilter contactPickerDbGroupFilter, ContactPickerServerGroupFilter contactPickerServerGroupFilter, ScheduledExecutorService scheduledExecutorService) {
        Builder builder = ImmutableList.builder();
        contactPickerDbGroupFilter.f1785g = true;
        builder.c(new ContactPickerSubFilterConfig(contactPickerDbGroupFilter, null, false));
        contactPickerServerGroupFilter.f6073l = true;
        builder.c(new ContactPickerSubFilterConfig(new ContactPickerDelayingListFilter(contactPickerServerGroupFilter, scheduledExecutorService, f6110a), null, false));
        return builder.b();
    }
}
