package com.facebook.messaging.sms.defaultapp.action;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android_src.provider.Telephony.MmsSms.PendingMessages;

/* compiled from: com.facebook.orca.media.upload.MEDIA_UPLOAD_STATUS_CHANGED */
public class MmsPendingMessageAction {
    public static void m17595a(Context context, Uri uri) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("err_type", Integer.valueOf(10));
        context.getContentResolver().update(PendingMessages.a, contentValues, "msg_id=" + String.valueOf(ContentUris.parseId(uri)), null);
        contentValues = new ContentValues(1);
        contentValues.put("st", Integer.valueOf(135));
        context.getContentResolver().update(uri, contentValues, null, null);
    }
}
