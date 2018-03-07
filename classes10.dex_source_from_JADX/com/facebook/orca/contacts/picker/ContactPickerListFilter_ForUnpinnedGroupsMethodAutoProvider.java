package com.facebook.orca.contacts.picker;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contacts.picker.ContactPickerDbGroupFilter;
import com.facebook.orca.contacts.providers.UnpinnedGroupsContactPickerListFilterProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: nux_modal_text */
public class ContactPickerListFilter_ForUnpinnedGroupsMethodAutoProvider extends AbstractProvider<ContactPickerListFilter> {
    public Object get() {
        return UnpinnedGroupsContactPickerListFilterProvider.m5830a(SystemClockMethodAutoProvider.a(this), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ContactPickerDbGroupFilter.m1727b((InjectorLike) this), ContactPickerServerGroupFilter.m5784b((InjectorLike) this));
    }
}
