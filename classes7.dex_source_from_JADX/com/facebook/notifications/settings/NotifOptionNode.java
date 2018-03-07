package com.facebook.notifications.settings;

import com.facebook.graphql.model.BaseFeedUnit;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions.Nodes;

/* compiled from: moments_call_to_action_prefs/ */
public class NotifOptionNode extends BaseFeedUnit {
    public Nodes f8709a;

    public NotifOptionNode(Nodes nodes) {
        this.f8709a = nodes;
    }

    public final String m10673g() {
        return Integer.toString(hashCode());
    }
}
