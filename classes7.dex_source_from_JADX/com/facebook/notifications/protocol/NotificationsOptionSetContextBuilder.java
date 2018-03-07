package com.facebook.notifications.protocol;

import com.facebook.graphql.calls.NotifOptionSetContextInputNotifOptionSetContext.ClientActionTypes;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;

/* compiled from: mtouch */
public class NotificationsOptionSetContextBuilder {
    public static NotificationsOptionSetContextBuilder m10656a(InjectorLike injectorLike) {
        return new NotificationsOptionSetContextBuilder();
    }

    public static final ImmutableList<ClientActionTypes> m10657b() {
        return ImmutableList.of(ClientActionTypes.OPEN_ACTION_SHEET, ClientActionTypes.OPEN_DEVICE_PUSH_SETTINGS, ClientActionTypes.OPEN_EVENT_DASHBOARD, ClientActionTypes.OPEN_EVENT_SETTING, ClientActionTypes.OPEN_GROUP_DASHBOARD, ClientActionTypes.OPEN_GROUP_SETTING, ClientActionTypes.OPEN_SOUNDS_SETTING, ClientActionTypes.OPEN_SUB_PAGE, ClientActionTypes.SERVER_ACTION);
    }
}
