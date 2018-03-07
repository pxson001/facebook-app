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
import com.facebook.messaging.contacts.picker.ContactPickerServerAgentPageFilter;
import com.facebook.messaging.contacts.picker.ContactPickerServerCommercePageFilter;
import com.facebook.messaging.contacts.picker.ContactPickerTincanThreadsFilter;
import com.facebook.orca.contacts.picker.ContactPickerNonFriendUsersFilter;
import com.facebook.orca.contacts.picker.ContactPickerServerGroupFilter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: null outgoingMessage.threadKey in onMessageSent. mThreadKey =  */
public class MergedDivebarContactPickerListFilterProvider {
    private static final DelayPolicy f6111a = new C09321();

    /* compiled from: null outgoingMessage.threadKey in onMessageSent. mThreadKey =  */
    final class C09321 implements DelayPolicy {
        C09321() {
        }

        public final long m5824a(CharSequence charSequence) {
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

    public static ContactPickerListFilter m5826a(SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, AbstractFbErrorReporter abstractFbErrorReporter, Resources resources, ContactPickerFriendFilter contactPickerFriendFilter, ContactPickerNonFriendUsersFilter contactPickerNonFriendUsersFilter, ContactPickerDbGroupFilter contactPickerDbGroupFilter, ContactPickerServerGroupFilter contactPickerServerGroupFilter, @Nullable ContactPickerServerCommercePageFilter contactPickerServerCommercePageFilter, @Nullable ContactPickerServerAgentPageFilter contactPickerServerAgentPageFilter, ContactPickerTincanThreadsFilter contactPickerTincanThreadsFilter, boolean z, boolean z2) {
        return new ContactPickerMergedFilter(m5828b(systemClock, scheduledExecutorService, abstractFbErrorReporter, resources, contactPickerFriendFilter, contactPickerNonFriendUsersFilter, contactPickerDbGroupFilter, contactPickerServerGroupFilter, contactPickerServerCommercePageFilter, contactPickerServerAgentPageFilter, contactPickerTincanThreadsFilter, z, z2), systemClock, scheduledExecutorService, abstractFbErrorReporter);
    }

    private static ImmutableList<ContactPickerSubFilterConfig> m5828b(SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, FbErrorReporter fbErrorReporter, Resources resources, ContactPickerFriendFilter contactPickerFriendFilter, ContactPickerNonFriendUsersFilter contactPickerNonFriendUsersFilter, ContactPickerDbGroupFilter contactPickerDbGroupFilter, ContactPickerServerGroupFilter contactPickerServerGroupFilter, @Nullable ContactPickerServerCommercePageFilter contactPickerServerCommercePageFilter, @Nullable ContactPickerServerAgentPageFilter contactPickerServerAgentPageFilter, ContactPickerTincanThreadsFilter contactPickerTincanThreadsFilter, boolean z, boolean z2) {
        Object obj;
        Builder builder = ImmutableList.builder();
        if (contactPickerServerAgentPageFilter != null) {
            builder.c(new ContactPickerSubFilterConfig(m5825a(contactPickerServerAgentPageFilter, scheduledExecutorService), null, true));
        }
        contactPickerFriendFilter.m1734b(true);
        contactPickerFriendFilter.a(!z2);
        builder.c(new ContactPickerSubFilterConfig(contactPickerFriendFilter, null, true));
        builder.c(new ContactPickerSubFilterConfig(new ContactPickerMergedFilter(m5827a(contactPickerDbGroupFilter, contactPickerServerGroupFilter, scheduledExecutorService), systemClock, scheduledExecutorService, fbErrorReporter), resources.getString(2131231197), false));
        if (contactPickerServerCommercePageFilter == null) {
            obj = null;
        } else {
            obj = new ContactPickerSubFilterConfig(m5825a(contactPickerServerCommercePageFilter, scheduledExecutorService), resources.getString(2131231198), false);
        }
        if (contactPickerTincanThreadsFilter.m1835c()) {
            builder.c(new ContactPickerSubFilterConfig(contactPickerTincanThreadsFilter, resources.getString(2131232420), true));
        }
        ContactPickerSubFilterConfig contactPickerSubFilterConfig = new ContactPickerSubFilterConfig(m5825a(contactPickerNonFriendUsersFilter, scheduledExecutorService), null, false);
        if (z) {
            if (obj != null) {
                builder.c(obj);
            }
            builder.c(contactPickerSubFilterConfig);
        } else {
            builder.c(contactPickerSubFilterConfig);
            if (obj != null) {
                builder.c(obj);
            }
        }
        return builder.b();
    }

    private static ImmutableList<ContactPickerSubFilterConfig> m5827a(ContactPickerDbGroupFilter contactPickerDbGroupFilter, ContactPickerServerGroupFilter contactPickerServerGroupFilter, ScheduledExecutorService scheduledExecutorService) {
        Builder builder = ImmutableList.builder();
        builder.c(new ContactPickerSubFilterConfig(contactPickerDbGroupFilter, null, false));
        builder.c(new ContactPickerSubFilterConfig(m5825a(contactPickerServerGroupFilter, scheduledExecutorService), null, false));
        return builder.b();
    }

    private static ContactPickerDelayingListFilter m5825a(ContactPickerListFilter contactPickerListFilter, ScheduledExecutorService scheduledExecutorService) {
        return new ContactPickerDelayingListFilter(contactPickerListFilter, scheduledExecutorService, f6111a);
    }
}
