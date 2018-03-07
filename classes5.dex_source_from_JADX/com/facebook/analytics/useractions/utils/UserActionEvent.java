package com.facebook.analytics.useractions.utils;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: throwback_title */
public class UserActionEvent extends HoneyClientEvent {
    public UserActionEvent(UserActionType userActionType) {
        super(userActionType.toString());
    }

    public UserActionEvent(UserActionType userActionType, String str) {
        this(userActionType);
        b("view_path", str);
    }
}
