package com.facebook.messaging.messageclassifier;

import com.facebook.messaging.model.messages.MessageType;

/* compiled from: large */
/* synthetic */ class MessageClassifier$1 {
    static final /* synthetic */ int[] f12239a = new int[MessageType.values().length];

    static {
        try {
            f12239a[MessageType.ADD_MEMBERS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f12239a[MessageType.REMOVE_MEMBERS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f12239a[MessageType.SET_NAME.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f12239a[MessageType.SET_IMAGE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f12239a[MessageType.REMOVED_IMAGE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f12239a[MessageType.VIDEO_CALL.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f12239a[MessageType.MISSED_VIDEO_CALL.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f12239a[MessageType.INCOMING_CALL.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f12239a[MessageType.MISSED_CALL.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f12239a[MessageType.OUTGOING_CALL.ordinal()] = 10;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f12239a[MessageType.CALL_LOG.ordinal()] = 11;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f12239a[MessageType.TELEPHONE_CALL_LOG.ordinal()] = 12;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f12239a[MessageType.SMS_LOG.ordinal()] = 13;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f12239a[MessageType.REGULAR.ordinal()] = 14;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f12239a[MessageType.PENDING_SEND.ordinal()] = 15;
        } catch (NoSuchFieldError e15) {
        }
        try {
            f12239a[MessageType.FAILED_SEND.ordinal()] = 16;
        } catch (NoSuchFieldError e16) {
        }
        try {
            f12239a[MessageType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER.ordinal()] = 17;
        } catch (NoSuchFieldError e17) {
        }
        try {
            f12239a[MessageType.ADMIN.ordinal()] = 18;
        } catch (NoSuchFieldError e18) {
        }
        try {
            f12239a[MessageType.P2P_PAYMENT.ordinal()] = 19;
        } catch (NoSuchFieldError e19) {
        }
        try {
            f12239a[MessageType.P2P_PAYMENT_CANCELED.ordinal()] = 20;
        } catch (NoSuchFieldError e20) {
        }
        try {
            f12239a[MessageType.P2P_PAYMENT_GROUP.ordinal()] = 21;
        } catch (NoSuchFieldError e21) {
        }
        try {
            f12239a[MessageType.COMMERCE_LINK.ordinal()] = 22;
        } catch (NoSuchFieldError e22) {
        }
        try {
            f12239a[MessageType.COMMERCE_UNLINK.ordinal()] = 23;
        } catch (NoSuchFieldError e23) {
        }
        try {
            f12239a[MessageType.ACTIVITY_REPLY.ordinal()] = 24;
        } catch (NoSuchFieldError e24) {
        }
    }
}
