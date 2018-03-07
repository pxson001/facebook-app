package com.facebook.orca.contacts.picker;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.inject.AbstractProvider;
import com.facebook.messaging.contacts.picker.ContactPickerFriendFilter;
import com.facebook.orca.contacts.providers.ContactPickerListFilterProviderForVoipSelectSearchList;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: number_of_results_user_saw_per_search */
public class C0925x1f1a36b1 extends AbstractProvider<ContactPickerListFilter> {
    public Object get() {
        return ContactPickerListFilterProviderForVoipSelectSearchList.m5823a(SystemClockMethodAutoProvider.a(this), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ContactPickerFriendFilter.m1729a(this));
    }
}
