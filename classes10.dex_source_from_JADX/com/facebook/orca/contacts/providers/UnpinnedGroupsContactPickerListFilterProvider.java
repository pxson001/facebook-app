package com.facebook.orca.contacts.providers;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.picker.ContactPickerDelayingListFilter;
import com.facebook.contacts.picker.ContactPickerDelayingListFilter.DelayPolicy;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerMergedFilter;
import com.facebook.contacts.picker.ContactPickerMergedFilter.ContactPickerSubFilterConfig;
import com.facebook.messaging.contacts.picker.ContactPickerDbGroupFilter;
import com.facebook.orca.contacts.picker.ContactPickerServerGroupFilter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: null error */
public class UnpinnedGroupsContactPickerListFilterProvider {
    public static final DelayPolicy f6112a = new C09331();

    /* compiled from: null error */
    final class C09331 implements DelayPolicy {
        C09331() {
        }

        public final long m5829a(CharSequence charSequence) {
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

    public static ContactPickerListFilter m5830a(SystemClock systemClock, ScheduledExecutorService scheduledExecutorService, AbstractFbErrorReporter abstractFbErrorReporter, ContactPickerDbGroupFilter contactPickerDbGroupFilter, ContactPickerServerGroupFilter contactPickerServerGroupFilter) {
        Builder builder = ImmutableList.builder();
        contactPickerDbGroupFilter.f1783e = true;
        builder.c(new ContactPickerSubFilterConfig(contactPickerDbGroupFilter, null, false));
        contactPickerServerGroupFilter.f6071j = 10;
        contactPickerServerGroupFilter.f6070i = 20;
        contactPickerServerGroupFilter.f6072k = true;
        builder.c(new ContactPickerSubFilterConfig(new ContactPickerDelayingListFilter(contactPickerServerGroupFilter, scheduledExecutorService, f6112a), null, false));
        return new ContactPickerMergedFilter(builder.b(), systemClock, scheduledExecutorService, abstractFbErrorReporter);
    }
}
