package com.facebook.messaging.inbox2.data.common;

import com.facebook.fbservice.service.DataFreshnessParam;
import com.google.common.base.Preconditions;

/* compiled from: setActionMenu */
public class InboxUnitParams {
    public final DataFreshnessParam f2752a;
    public final InboxUnitsToFetch f2753b;

    public InboxUnitParams(DataFreshnessParam dataFreshnessParam, InboxUnitsToFetch inboxUnitsToFetch) {
        this.f2752a = (DataFreshnessParam) Preconditions.checkNotNull(dataFreshnessParam);
        this.f2753b = (InboxUnitsToFetch) Preconditions.checkNotNull(inboxUnitsToFetch);
    }
}
