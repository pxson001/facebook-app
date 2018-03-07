package com.facebook.messaging.inbox2.rtc;

import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;

/* compiled from: selfupdate_clean_update_info */
public class RtcRecommendationInboxItem extends InboxUnitItem {
    public final ContactPickerUserRow f2962f;

    public RtcRecommendationInboxItem(NodesModel nodesModel, ContactPickerUserRow contactPickerUserRow) {
        super(nodesModel);
        this.f2962f = contactPickerUserRow;
    }

    public final InboxItemType m2948a() {
        return InboxItemType.V2_RTC_RECOMMENDATION;
    }

    public final InboxItemViewType m2949b() {
        return InboxItemViewType.V2_RTC_RECOMMENDATION;
    }

    public final String m2950d() {
        return "tap_rtc_recommendation_unit";
    }

    protected final long m2952h() {
        Hasher a = InboxUnitItem.a.a();
        a.a(this.d.j(), Charsets.UTF_8);
        a.a(this.f2962f.a.a, Charsets.UTF_8);
        return a.a().c();
    }

    public final boolean m2951e() {
        return true;
    }
}
