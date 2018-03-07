package com.facebook.orca.contacts.picker;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contacts.picker.ContactPickerDbGroupFilter;
import com.facebook.messaging.contacts.picker.ContactPickerFriendFilter;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: number_of_suggestions_user_saw */
public class ContactPickerListFilter_ForVoipGroupCallListMethodAutoProvider extends AbstractProvider<ContactPickerListFilter> {
    public static ContactPickerListFilter m5779b(InjectorLike injectorLike) {
        return MessagesContactPickerModule.a(SystemClockMethodAutoProvider.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ContactPickerFriendFilter.m1729a(injectorLike), ContactPickerDbGroupFilter.m1727b(injectorLike), ContactPickerServerGroupFilter.m5784b(injectorLike));
    }

    public Object get() {
        return MessagesContactPickerModule.a(SystemClockMethodAutoProvider.a(this), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ResourcesMethodAutoProvider.a(this), ContactPickerFriendFilter.m1729a(this), ContactPickerDbGroupFilter.m1727b((InjectorLike) this), ContactPickerServerGroupFilter.m5784b((InjectorLike) this));
    }
}
