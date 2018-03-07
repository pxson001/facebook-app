package com.facebook.messaging.sms.defaultapp.action;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android_src.provider.Telephony.Sms;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.common.Constants.MmsSmsErrorType;
import com.facebook.messaging.sms.common.MmsSmsIdUtils;
import com.facebook.messaging.sms.defaultapp.SmsReceiver;
import com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue;
import com.facebook.messaging.sms.defaultapp.send.PendingSendMessage;
import java.util.ArrayList;
import java.util.Collections;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.extra.REPLY_TOKEN */
public class ProcessSendSmsAction {
    private static final String[] f17662c = new String[]{"_id", "thread_id", "address", "body"};
    private final Context f17663a;
    private final MmsSmsPendingSendQueue f17664b;

    public static ProcessSendSmsAction m17624a(InjectorLike injectorLike) {
        return new ProcessSendSmsAction((Context) injectorLike.getInstance(Context.class), MmsSmsPendingSendQueue.m17644a(injectorLike));
    }

    @Inject
    public ProcessSendSmsAction(Context context, MmsSmsPendingSendQueue mmsSmsPendingSendQueue) {
        this.f17663a = context;
        this.f17664b = mmsSmsPendingSendQueue;
    }

    private void m17625a(Uri uri, MmsSmsErrorType mmsSmsErrorType, PendingSendMessage pendingSendMessage) {
        Intent intent = new Intent("com.facebook.messaging.sms.MESSAGE_SENT", uri, this.f17663a, SmsReceiver.class);
        intent.putExtra("mmssms_quickfail_type", mmsSmsErrorType);
        PendingSendMessage.m17662a(intent, pendingSendMessage);
        this.f17663a.sendBroadcast(intent);
    }

    public final void m17627a(PendingSendMessage pendingSendMessage) {
        Cursor query;
        Throwable th;
        Uri a = MmsSmsIdUtils.m17497a(pendingSendMessage.m17663a());
        if (pendingSendMessage.m17666e()) {
            m17625a(a, MmsSmsErrorType.EXPIRED_MESSAGE, pendingSendMessage);
            return;
        }
        try {
            query = this.f17663a.getContentResolver().query(a, f17662c, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        String c = CursorHelper.c(query, "body");
                        m17626a(CursorHelper.c(query, "address"), c, ContentUris.withAppendedId(Sms.a, (long) CursorHelper.a(query, "_id")), pendingSendMessage);
                        if (query != null) {
                            query.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            this.f17664b.m17654b(pendingSendMessage.m17663a(), pendingSendMessage.m17664b());
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private void m17626a(String str, String str2, Uri uri, PendingSendMessage pendingSendMessage) {
        SmsManager smsManager = SmsManager.getDefault();
        ArrayList divideMessage = smsManager.divideMessage(str2);
        String stripSeparators = PhoneNumberUtils.stripSeparators(str);
        ArrayList arrayList = new ArrayList(Collections.nCopies(divideMessage.size(), null));
        Intent intent = new Intent("com.facebook.messaging.sms.MESSAGE_SENT", uri, this.f17663a, SmsReceiver.class);
        PendingSendMessage.m17662a(intent, pendingSendMessage);
        arrayList.set(divideMessage.size() - 1, SecurePendingIntent.b(this.f17663a, 0, intent, 134217728));
        smsManager.sendMultipartTextMessage(stripSeparators, null, divideMessage, arrayList, null);
    }
}
