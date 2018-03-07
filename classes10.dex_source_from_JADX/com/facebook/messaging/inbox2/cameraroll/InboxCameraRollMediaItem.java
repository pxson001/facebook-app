package com.facebook.messaging.inbox2.cameraroll;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.ui.media.attachments.MediaResource;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: setSessionCookies */
public class InboxCameraRollMediaItem extends InboxUnitItem {
    public final MediaResource f2712f;

    public InboxCameraRollMediaItem(NodesModel nodesModel, MediaResource mediaResource) {
        super(nodesModel);
        this.f2712f = mediaResource;
    }

    public final long m2681h() {
        return this.f2712f.g;
    }

    protected final String m2682j() {
        return this.d.j() + ":" + this.f2712f.g;
    }

    public final InboxItemType m2677a() {
        return InboxItemType.V2_CAMERA_ROLL_ITEM;
    }

    public final InboxItemViewType m2678b() {
        return InboxItemViewType.V2_CAMERA_ROLL_ITEM;
    }

    public final String m2679d() {
        return "tap_camera_roll_item";
    }

    public final boolean m2680e() {
        return false;
    }
}
