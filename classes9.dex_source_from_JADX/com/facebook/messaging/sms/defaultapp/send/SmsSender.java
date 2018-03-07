package com.facebook.messaging.sms.defaultapp.send;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android_src.mmsv2.pdu.EncodedStringValue;
import android_src.mmsv2.pdu.GenericPdu;
import android_src.mmsv2.pdu.MmsException;
import android_src.mmsv2.pdu.PduBody;
import android_src.mmsv2.pdu.PduPersister;
import android_src.mmsv2.pdu.SendReq;
import android_src.mmsv2.util.MessageUtils;
import android_src.provider.Telephony.Mms.Outbox;
import android_src.provider.Telephony.MmsSms.PendingMessages;
import android_src.provider.Telephony.Sms;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.sms.SmsThreadManager;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.common.MmsSmsIdUtils;
import com.facebook.messaging.sms.common.SmsException;
import com.facebook.messaging.sms.defaultapp.MmsSmsPendingMessagesMarker;
import com.facebook.messaging.sms.defaultapp.OfflineThreadingIdCache;
import com.facebook.messaging.sms.defaultapp.PduPartFactory;
import com.facebook.messaging.sms.defaultapp.config.MmsSmsConfig;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.messaging.sms.util.TelephonyUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.extra.APPLICATION_ID */
public class SmsSender {
    private static final Uri f17719a = Uri.parse("content://sms/queued");
    private final Context f17720b;
    private final FbSharedPreferences f17721c;
    private final SmsThreadManager f17722d;
    private final PduPartFactory f17723e;
    private final OfflineThreadingIdCache f17724f;
    private final SmsTakeoverAnalyticsLogger f17725g;
    private final TelephonyManager f17726h;
    private final Lazy<MmsSmsConfig> f17727i;
    private final MmsSmsPendingSendQueue f17728j;

    /* compiled from: com.facebook.orca.extra.APPLICATION_ID */
    /* synthetic */ class C20931 {
        static final /* synthetic */ int[] f17718a = new int[Type.values().length];

        static {
            try {
                f17718a[Type.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17718a[Type.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17718a[Type.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17718a[Type.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static SmsSender m17679b(InjectorLike injectorLike) {
        return new SmsSender((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SmsThreadManager.m17473a(injectorLike), PduPartFactory.m17560b(injectorLike), OfflineThreadingIdCache.m17547a(injectorLike), SmsTakeoverAnalyticsLogger.b(injectorLike), MmsSmsPendingMessagesMarker.m17541a(injectorLike), TelephonyManagerMethodAutoProvider.b(injectorLike), IdBasedLazy.a(injectorLike, 8470), MmsSmsPendingSendQueue.m17644a(injectorLike));
    }

    @Inject
    public SmsSender(Context context, FbSharedPreferences fbSharedPreferences, SmsThreadManager smsThreadManager, PduPartFactory pduPartFactory, OfflineThreadingIdCache offlineThreadingIdCache, SmsTakeoverAnalyticsLogger smsTakeoverAnalyticsLogger, MmsSmsPendingMessagesMarker mmsSmsPendingMessagesMarker, TelephonyManager telephonyManager, Lazy<MmsSmsConfig> lazy, MmsSmsPendingSendQueue mmsSmsPendingSendQueue) {
        this.f17720b = context;
        this.f17721c = fbSharedPreferences;
        this.f17722d = smsThreadManager;
        this.f17723e = pduPartFactory;
        this.f17724f = offlineThreadingIdCache;
        this.f17725g = smsTakeoverAnalyticsLogger;
        this.f17726h = telephonyManager;
        this.f17727i = lazy;
        this.f17728j = mmsSmsPendingSendQueue;
    }

    public final String m17683a(Message message, boolean z) {
        boolean z2 = false;
        Preconditions.checkNotNull(message);
        Preconditions.checkArgument(ThreadKey.d(message.b));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(message.n));
        boolean d = this.f17722d.m17496d(message.b.i());
        try {
            Uri c;
            if (MmsSmsIdUtils.m17503d(message.a)) {
                c = m17680c(message);
            } else if (MmsSmsIdUtils.m17502c(message.a)) {
                c = m17677b(message);
            } else if (m17682e(message)) {
                c = m17681d(message);
            } else {
                c = m17678b(message, d);
            }
            if (c == null) {
                throw new SmsException("Message URI was null");
            }
            String a = MmsSmsIdUtils.m17499a(c);
            if (z) {
                this.f17724f.m17549a(a, message.n);
            }
            long i = message.b.i();
            if (d) {
                i = this.f17722d.m17483a(c, i);
            }
            this.f17728j.m17652a(a, i);
            if (d) {
                int b = this.f17722d.m17493b(message.b.i());
                String c2 = message.L.c();
                if (b > 1 || c2 != null) {
                    z2 = true;
                }
                this.f17725g.a(z2, c2, message.L.d.size(), b);
            }
            return a;
        } catch (MmsException e) {
            throw new SmsException(e.getMessage());
        }
    }

    private Uri m17677b(Message message) {
        this.f17725g.c();
        Uri a = MmsSmsIdUtils.m17497a(message.a);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("date", Long.valueOf(message.c));
        this.f17720b.getContentResolver().update(a, contentValues, null, null);
        Sms.a(this.f17720b, a, 6, 0);
        return a;
    }

    private Uri m17678b(Message message, boolean z) {
        long i = message.b.i();
        String str = message.f;
        if (Strings.isNullOrEmpty(str)) {
            throw new SmsException("Empty message body.");
        }
        List a = this.f17722d.m17487a(i);
        if (a.size() != 1) {
            throw new SmsException("Not single recipient thread.");
        } else if (FbPhoneNumberUtils.c((String) a.get(0))) {
            try {
                a.get(0);
                ContentResolver contentResolver = this.f17720b.getContentResolver();
                Uri uri = f17719a;
                String str2 = (String) a.get(0);
                Long valueOf = Long.valueOf(message.c);
                if (z) {
                    i = 0;
                }
                Uri a2 = Sms.a(contentResolver, uri, str2, str, null, valueOf, true, false, i);
                this.f17725g.b();
                return a2;
            } catch (Throwable e) {
                BLog.b("SmsSender", e, "Queue sms msg failed.", new Object[0]);
                throw new SmsException(e.getMessage());
            }
        } else {
            throw new SmsException("Not supported destination: " + ((String) a.get(0)));
        }
    }

    private Uri m17680c(Message message) {
        this.f17725g.b(message.L.c(), message.L.d.size(), this.f17722d.m17493b(message.b.i()));
        Uri b = MmsSmsIdUtils.m17500b(message.a);
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("date", Long.valueOf(message.c / 1000));
        contentValues.putNull("st");
        this.f17720b.getContentResolver().update(b, contentValues, null, null);
        return b;
    }

    private Uri m17681d(Message message) {
        String str;
        boolean z = true;
        int i = 0;
        if (message.L.d.isEmpty() && Strings.isNullOrEmpty(message.f) && message.k == null) {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (message.k != null) {
            str = "sticker";
        } else {
            str = message.L.c();
        }
        this.f17725g.a(str, message.L.d.size(), this.f17722d.m17493b(message.b.i()));
        HashSet hashSet = new HashSet();
        try {
            PduBody pduBody = new PduBody();
            if (!message.L.d.isEmpty()) {
                pduBody.m3623a(PduPartFactory.m17553a());
            }
            ImmutableList immutableList = message.L.d;
            int size = immutableList.size();
            while (i < size) {
                MediaResource mediaResource = (MediaResource) immutableList.get(i);
                switch (C20931.f17718a[mediaResource.d.ordinal()]) {
                    case 1:
                        pduBody.m3623a(this.f17723e.m17564a(mediaResource, hashSet, message.L.d.size()));
                        break;
                    case 2:
                        pduBody.m3623a(this.f17723e.m17563a(mediaResource));
                        break;
                    case 3:
                        pduBody.m3623a(this.f17723e.m17565b(mediaResource));
                        break;
                    case 4:
                        throw new MmsException("Other media resource type is not supported for mms");
                    default:
                        break;
                }
                i++;
            }
            if (message.k != null) {
                pduBody.m3623a(PduPartFactory.m17559b(message.k));
            }
            if (!Strings.isNullOrEmpty(message.f)) {
                pduBody.m3623a(PduPartFactory.m17554a(message.f));
            }
            String[] a = m17676a(message.b.i());
            if (a.length <= 0) {
                throw new MmsException("No valid sending destination(s).");
            }
            GenericPdu sendReq = new SendReq();
            EncodedStringValue[] a2 = EncodedStringValue.m3605a(a);
            if (a2 != null) {
                sendReq.m3734a(a2);
            }
            sendReq.m3611a(message.c / 1000);
            sendReq.m3612a(pduBody);
            PduPersister a3 = PduPersister.m3702a(this.f17720b);
            String line1Number = this.f17726h.getLine1Number();
            if (Strings.isNullOrEmpty(line1Number)) {
                line1Number = this.f17721c.a(SmsPrefKeys.L, null);
            }
            Uri a4 = a3.m3720a(sendReq, Outbox.a, TelephonyUtils.m17716a(-1), line1Number, true, null);
            ContentValues contentValues = new ContentValues(7);
            contentValues.put("proto_type", Integer.valueOf(1));
            contentValues.put("msg_id", Long.valueOf(ContentUris.parseId(a4)));
            contentValues.put("msg_type", Integer.valueOf(sendReq.m3593b()));
            contentValues.put("err_type", Integer.valueOf(0));
            contentValues.put("err_code", Integer.valueOf(0));
            contentValues.put("retry_index", Integer.valueOf(0));
            contentValues.put("due_time", Integer.valueOf(0));
            this.f17720b.getContentResolver().insert(PendingMessages.a, contentValues);
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                new File(((Uri) it.next()).getPath()).delete();
            }
            return a4;
        } catch (Throwable e) {
            BLog.b("SmsSender", e, "Queue mms failed.", new Object[0]);
            throw e;
        } catch (Throwable e2) {
            Throwable th = e2;
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                new File(((Uri) it2.next()).getPath()).delete();
            }
        }
    }

    private String[] m17676a(long j) {
        List<String> a = this.f17722d.m17487a(j);
        List arrayList = new ArrayList(a.size());
        for (String str : a) {
            String str2;
            String a2 = MessageUtils.m3744a(str2);
            if (!(Strings.isNullOrEmpty(a2) && ((MmsSmsConfig) this.f17727i.get()).m17639a(str2))) {
                str2 = a2;
            }
            if (!(Strings.isNullOrEmpty(str2) || arrayList.contains(str2))) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private boolean m17682e(Message message) {
        if (!message.L.d.isEmpty() || message.k != null) {
            return true;
        }
        List a = this.f17722d.m17487a(message.b.i());
        return a.size() > 1 || !FbPhoneNumberUtils.c((String) a.get(0));
    }
}
