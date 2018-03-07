package com.facebook.orca.notify;

import com.facebook.messaging.model.messages.MessageType;

/* compiled from: new_user_id */
/* synthetic */ class ThreadSystemTrayNotificationManager$3 {
    static final /* synthetic */ int[] f6292a = new int[MessageType.values().length];

    static {
        try {
            f6292a[MessageType.ADD_MEMBERS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6292a[MessageType.REMOVE_MEMBERS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6292a[MessageType.SET_NAME.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6292a[MessageType.SET_IMAGE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f6292a[MessageType.REMOVED_IMAGE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f6292a[MessageType.ADMIN.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
