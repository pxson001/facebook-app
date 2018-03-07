package com.facebook.events.dashboard.multirow;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.events.dashboard.DashboardFilterType;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: com.facebook.sdk.ClientToken */
public class EventsDashboardItemCollectionProvider extends AbstractAssistedProvider<EventsDashboardItemCollection> {
    public final EventsDashboardItemCollection m17379a(Boolean bool, DashboardFilterType dashboardFilterType) {
        return new EventsDashboardItemCollection(bool, dashboardFilterType, (Clock) SystemClockMethodAutoProvider.a(this), (Context) getInstance(Context.class), EventsDashboardTimeFormatUtil.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
