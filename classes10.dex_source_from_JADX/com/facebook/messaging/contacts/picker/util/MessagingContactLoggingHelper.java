package com.facebook.messaging.contacts.picker.util;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.contacts.picker.ContactPickerSectionHeaderRow;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.pages.analytics.BusinessPagesAnalyticsLogger;
import com.facebook.messaging.business.pages.analytics.BusinessPagesAnalyticsLogger.SuggestedPageProduct;
import com.facebook.messaging.business.pages.analytics.BusinessPagesAnalyticsLogger.SuggestedPageType;
import com.facebook.messaging.business.search.abtest.ExperimentsForBusinessSearchAbtestModule;
import com.facebook.messaging.business.search.analytics.BusinessSearchAnalyticsLogger;
import com.facebook.messaging.searchnullstate.ContactPickerHScrollItemData;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.user.model.User;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: take_photo */
public class MessagingContactLoggingHelper {
    private final BusinessPagesAnalyticsLogger f2064a;
    public final BusinessSearchAnalyticsLogger f2065b;
    private final Handler f2066c;

    /* compiled from: take_photo */
    class C03451 implements Runnable {
        final /* synthetic */ MessagingContactLoggingHelper f2062a;

        C03451(MessagingContactLoggingHelper messagingContactLoggingHelper) {
            this.f2062a = messagingContactLoggingHelper;
        }

        public void run() {
            BusinessSearchAnalyticsLogger businessSearchAnalyticsLogger = this.f2062a.f2065b;
            HoneyClientEventFast a = businessSearchAnalyticsLogger.a.a("messenger_search_business_impression", false);
            if (a.a()) {
                a.b();
                businessSearchAnalyticsLogger.b.a(Liveness.Live, ExperimentsForBusinessSearchAbtestModule.b);
            }
        }
    }

    public static MessagingContactLoggingHelper m1884b(InjectorLike injectorLike) {
        return new MessagingContactLoggingHelper(new BusinessPagesAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), new BusinessSearchAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike)), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike));
    }

    public final void m1885a(Context context, ContactPickerSectionHeaderRow contactPickerSectionHeaderRow) {
        if (!Strings.isNullOrEmpty(contactPickerSectionHeaderRow.a) && contactPickerSectionHeaderRow.a.equals(context.getResources().getString(2131231198))) {
            HandlerDetour.a(this.f2066c, new C03451(this), 671821582);
        }
    }

    @Inject
    public MessagingContactLoggingHelper(BusinessPagesAnalyticsLogger businessPagesAnalyticsLogger, BusinessSearchAnalyticsLogger businessSearchAnalyticsLogger, Handler handler) {
        this.f2064a = businessPagesAnalyticsLogger;
        this.f2065b = businessSearchAnalyticsLogger;
        this.f2066c = handler;
    }

    public final void m1886a(LinearLayoutManager linearLayoutManager, Set<String> set, ImmutableList<ContactPickerHScrollItemData> immutableList) {
        int l = linearLayoutManager.l();
        int n = linearLayoutManager.n();
        SuggestedPageType b = m1883b((ImmutableList) immutableList);
        if (b != null) {
            int i = l;
            while (i < n + 1) {
                User user = ((ContactPickerHScrollItemData) immutableList.get(i)).f3816a;
                if (user != null) {
                    String str = user.a;
                    if (!set.contains(str)) {
                        this.f2064a.a(str, i, i - l, immutableList.size(), SuggestedPageProduct.SEARCH_NULL_STATE, b);
                        set.add(str);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static SuggestedPageType m1883b(ImmutableList<ContactPickerHScrollItemData> immutableList) {
        if (immutableList == null || immutableList.isEmpty()) {
            return null;
        }
        SuggestedPageType suggestedPageType;
        switch (((ContactPickerHScrollItemData) immutableList.get(0)).f3818c) {
            case BYMM:
                suggestedPageType = SuggestedPageType.BUSINESSES;
                break;
            case BOTS:
                suggestedPageType = SuggestedPageType.BOTS;
                break;
            default:
                suggestedPageType = null;
                break;
        }
        return suggestedPageType;
    }
}
