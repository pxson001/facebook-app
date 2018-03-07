package com.facebook.messaging.sms.defaultapp.action;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.SmsMessage;
import android.telephony.SmsMessage.MessageClass;
import android_src.provider.Telephony.Sms;
import android_src.provider.Telephony.Sms.Inbox;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.SmsThreadKeyUtil;
import com.facebook.messaging.sms.SmsMessageLoader;
import com.facebook.messaging.sms.util.HighestTimestampUtil;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.extra.RENDER_AS_STICKER */
public class ProcessSmsReceivedAction {
    private static final String[] f17665a = new String[]{"_id", "thread_id", "address", "protocol"};
    private final Context f17666b;
    private final Clock f17667c;
    private final HighestTimestampUtil f17668d;
    private final SmsMessageLoader f17669e;
    private final MmsSmsCacheUpdateAction f17670f;

    public static ProcessSmsReceivedAction m17629a(InjectorLike injectorLike) {
        return new ProcessSmsReceivedAction((Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), HighestTimestampUtil.m17707b(injectorLike), SmsMessageLoader.m17430a(injectorLike), MmsSmsCacheUpdateAction.m17596b(injectorLike));
    }

    @Inject
    public ProcessSmsReceivedAction(Context context, Clock clock, HighestTimestampUtil highestTimestampUtil, SmsMessageLoader smsMessageLoader, MmsSmsCacheUpdateAction mmsSmsCacheUpdateAction) {
        this.f17666b = context;
        this.f17667c = clock;
        this.f17668d = highestTimestampUtil;
        this.f17669e = smsMessageLoader;
        this.f17670f = mmsSmsCacheUpdateAction;
    }

    public final void m17633a(Intent intent) {
        int i = 0;
        Object[] objArr = (Object[]) intent.getSerializableExtra("pdus");
        byte[][] bArr = new byte[objArr.length][];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            bArr[i2] = (byte[]) objArr[i2];
        }
        byte[][] bArr2 = new byte[bArr.length][];
        int length = bArr2.length;
        SmsMessage[] smsMessageArr = new SmsMessage[length];
        while (i < length) {
            bArr2[i] = bArr[i];
            smsMessageArr[i] = SmsMessage.createFromPdu(bArr2[i]);
            i++;
        }
        SmsMessage[] smsMessageArr2 = smsMessageArr;
        if (smsMessageArr2 == null || smsMessageArr2.length == 0) {
            BLog.b("ProcessSmsReceivedAction", "Received invalid message from intent: %s", new Object[]{intent});
            return;
        }
        SmsMessage smsMessage = smsMessageArr2[0];
        Uri b = smsMessage.getMessageClass() != MessageClass.CLASS_0 ? smsMessage.isReplace() ? m17631b(smsMessageArr2) : m17628a(smsMessageArr2) : null;
        smsMessage.getDisplayOriginatingAddress();
        Integer.valueOf(smsMessageArr2.length);
        Boolean.valueOf(smsMessage.isReplace());
        if (b != null) {
            Message a = this.f17669e.m17441a(b);
            if (a != null) {
                this.f17670f.m17600a(CallerContext.a(getClass()), a, null);
            }
        }
    }

    private Uri m17628a(SmsMessage[] smsMessageArr) {
        ContentValues c = m17632c(smsMessageArr);
        String asString = c.getAsString("address");
        if (Strings.isNullOrEmpty(asString)) {
            asString = "Unknown";
            c.put("address", asString);
        }
        Long valueOf = Long.valueOf(SmsThreadKeyUtil.a(this.f17666b, asString));
        c.put("thread_id", valueOf);
        m17630a(c, valueOf.longValue());
        return this.f17666b.getContentResolver().insert(Inbox.a, c);
    }

    private Uri m17631b(SmsMessage[] smsMessageArr) {
        Throwable th;
        Cursor cursor;
        ContentValues c = m17632c(smsMessageArr);
        SmsMessage smsMessage = smsMessageArr[0];
        String originatingAddress = smsMessage.getOriginatingAddress();
        int protocolIdentifier = smsMessage.getProtocolIdentifier();
        ConjunctionExpression a = SqlExpression.a(new Expression[]{SqlExpression.a("address", originatingAddress), SqlExpression.a("protocol", String.valueOf(protocolIdentifier))});
        ContentResolver contentResolver = this.f17666b.getContentResolver();
        try {
            Cursor query = contentResolver.query(Inbox.a, f17665a, a.a(), a.b(), null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        Uri withAppendedId = ContentUris.withAppendedId(Sms.a, CursorHelper.b(query, "_id"));
                        m17630a(c, CursorHelper.b(query, "thread_id"));
                        contentResolver.update(withAppendedId, c, null, null);
                        if (query != null) {
                            query.close();
                        }
                        return withAppendedId;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return m17628a(smsMessageArr);
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static ContentValues m17632c(SmsMessage[] smsMessageArr) {
        String displayMessageBody;
        int i = 0;
        SmsMessage smsMessage = smsMessageArr[0];
        ContentValues contentValues = new ContentValues();
        contentValues.put("address", smsMessage.getDisplayOriginatingAddress());
        contentValues.put("date_sent", Long.valueOf(smsMessage.getTimestampMillis()));
        contentValues.put("protocol", Integer.valueOf(smsMessage.getProtocolIdentifier()));
        contentValues.put("read", Integer.valueOf(0));
        contentValues.put("seen", Integer.valueOf(0));
        contentValues.put("subject", smsMessage.getPseudoSubject());
        contentValues.put("reply_path_present", Integer.valueOf(smsMessage.isReplyPathPresent() ? 1 : 0));
        contentValues.put("service_center", smsMessage.getServiceCenterAddress());
        if (smsMessageArr.length == 1) {
            displayMessageBody = smsMessage.getDisplayMessageBody();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int length = smsMessageArr.length;
            while (i < length) {
                stringBuilder.append(smsMessageArr[i].getDisplayMessageBody());
                i++;
            }
            displayMessageBody = stringBuilder.toString();
        }
        contentValues.put("body", displayMessageBody.replace('\f', '\n'));
        return contentValues;
    }

    private void m17630a(ContentValues contentValues, long j) {
        contentValues.put("date", Long.valueOf(Math.max(this.f17668d.m17708a(j) + 1, this.f17667c.a())));
    }
}
