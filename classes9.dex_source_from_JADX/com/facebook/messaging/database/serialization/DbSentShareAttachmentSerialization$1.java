package com.facebook.messaging.database.serialization;

import com.facebook.messaging.model.share.SentShareAttachment.Type;

/* compiled from: me/threads */
/* synthetic */ class DbSentShareAttachmentSerialization$1 {
    static final /* synthetic */ int[] f10421a = new int[Type.values().length];

    static {
        try {
            f10421a[Type.SHARE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f10421a[Type.PAYMENT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
