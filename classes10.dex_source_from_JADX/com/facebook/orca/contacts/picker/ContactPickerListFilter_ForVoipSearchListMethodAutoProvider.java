package com.facebook.orca.contacts.picker;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.inject.AbstractProvider;
import com.facebook.messaging.contacts.picker.ContactPickerFriendFilter;
import com.facebook.rtc.Boolean_IsVoipVideoEnabledMethodAutoProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: number_of_searches */
public class ContactPickerListFilter_ForVoipSearchListMethodAutoProvider extends AbstractProvider<ContactPickerListFilter> {
    public Object get() {
        return MessagesContactPickerModule.a(SystemClockMethodAutoProvider.a(this), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ContactPickerFriendFilter.m1729a(this), Boolean_IsVoipVideoEnabledMethodAutoProvider.b(this));
    }
}
