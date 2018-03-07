package com.facebook.orca.contacts.picker;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.search.BusinessSearchGatekeeperUtil;
import com.facebook.messaging.contacts.picker.ContactPickerDbGroupFilter;
import com.facebook.messaging.contacts.picker.ContactPickerFriendFilter;
import com.facebook.messaging.contacts.picker.ContactPickerServerAgentPageFilter;
import com.facebook.messaging.contacts.picker.ContactPickerServerCommercePageFilter;
import com.facebook.messaging.contacts.picker.ContactPickerTincanThreadsFilter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: nux_status_count */
public class ContactPickerListFilter_ForDivebarListMethodAutoProvider extends AbstractProvider<ContactPickerListFilter> {
    public static ContactPickerListFilter m5778b(InjectorLike injectorLike) {
        return MessagesContactPickerModule.a(SystemClockMethodAutoProvider.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ContactPickerFriendFilter.m1729a(injectorLike), ContactPickerNonFriendUsersFilter.m5782b(injectorLike), ContactPickerDbGroupFilter.m1727b(injectorLike), ContactPickerServerGroupFilter.m5784b(injectorLike), ContactPickerServerCommercePageFilter.m1830b(injectorLike), ContactPickerServerAgentPageFilter.m1828b(injectorLike), ContactPickerTincanThreadsFilter.m1833b(injectorLike), BusinessSearchGatekeeperUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 4200), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        return MessagesContactPickerModule.a(SystemClockMethodAutoProvider.a(this), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ResourcesMethodAutoProvider.a(this), ContactPickerFriendFilter.m1729a(this), ContactPickerNonFriendUsersFilter.m5782b((InjectorLike) this), ContactPickerDbGroupFilter.m1727b((InjectorLike) this), ContactPickerServerGroupFilter.m5784b((InjectorLike) this), ContactPickerServerCommercePageFilter.m1830b((InjectorLike) this), ContactPickerServerAgentPageFilter.m1828b((InjectorLike) this), ContactPickerTincanThreadsFilter.m1833b((InjectorLike) this), BusinessSearchGatekeeperUtil.b(this), IdBasedProvider.a(this, 4200), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
