package com.facebook.messaging.inbox2.photoreminders;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.photoreminders.inboxheader.PhotoRemindersInboxData;

/* compiled from: send_fragment */
public class InboxUnitPhotoRemindersItem extends InboxUnitItem {
    public final PhotoRemindersInboxData f2856f;

    public InboxUnitPhotoRemindersItem(NodesModel nodesModel, PhotoRemindersInboxData photoRemindersInboxData) {
        super(nodesModel);
        this.f2856f = photoRemindersInboxData;
    }

    public final InboxItemType m2816a() {
        return InboxItemType.V2_PHOTO_REMINDERS;
    }

    public final InboxItemViewType m2817b() {
        return InboxItemViewType.V2_PHOTO_REMINDERS;
    }

    public final String m2818d() {
        return "tap_photo_reminder";
    }

    public final boolean m2819e() {
        return true;
    }
}
