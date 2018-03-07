package com.facebook.notifications.settings;

import com.facebook.graphql.model.BaseFeedUnit;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment;

/* compiled from: moments_app_photo_overlay_call_to_action */
public class NotifOptionSetNode extends BaseFeedUnit {
    public NotifOptionSetFragment f8710a;
    public int f8711b;

    public NotifOptionSetNode(NotifOptionSetFragment notifOptionSetFragment, int i) {
        this.f8710a = notifOptionSetFragment;
        this.f8711b = i;
    }

    public final String m10675g() {
        return Integer.toString(hashCode());
    }

    public final NotifOptionSetFragment m10674f() {
        return this.f8710a;
    }
}
