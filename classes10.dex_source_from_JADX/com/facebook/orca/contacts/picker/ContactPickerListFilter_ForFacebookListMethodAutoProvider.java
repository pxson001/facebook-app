package com.facebook.orca.contacts.picker;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contacts.picker.ContactPickerFriendFilter;
import com.facebook.messaging.smsbridge.abtest.Boolean_IsSmsBridgeEnabledMethodAutoProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: nux_modal_title */
public class ContactPickerListFilter_ForFacebookListMethodAutoProvider extends AbstractProvider<ContactPickerListFilter> {
    public Object get() {
        return MessagesContactPickerModule.a(SystemClockMethodAutoProvider.a(this), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ContactPickerFriendFilter.m1729a(this), ContactPickerNonFriendUsersFilter.m5782b((InjectorLike) this), Boolean_IsSmsBridgeEnabledMethodAutoProvider.b(this));
    }
}
