package com.facebook.messaging.inbox2.cameraroll;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: setToolbarSegments */
public class CameraRollInboxItem extends InboxUnitItem {
    public CameraRollInboxItem(NodesModel nodesModel) {
        super(nodesModel);
    }

    public final InboxItemType m2659a() {
        return InboxItemType.V2_CAMERA_ROLL;
    }

    public final InboxItemViewType m2660b() {
        return InboxItemViewType.V2_CAMERA_ROLL;
    }

    public final String m2661d() {
        return "tap_camera_roll_unit";
    }

    public final boolean m2662e() {
        return false;
    }
}
