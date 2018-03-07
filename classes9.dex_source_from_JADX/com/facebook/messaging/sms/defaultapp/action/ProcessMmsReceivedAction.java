package com.facebook.messaging.sms.defaultapp.action;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android_src.mmsv2.pdu.GenericPdu;
import android_src.mmsv2.pdu.MmsException;
import android_src.mmsv2.pdu.NotificationInd;
import android_src.mmsv2.pdu.PduParser;
import android_src.mmsv2.pdu.PduPersister;
import android_src.provider.Telephony.Mms;
import android_src.provider.Telephony.Mms.Inbox;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.sms.SmsMessageLoader;
import com.facebook.messaging.sms.defaultapp.config.MmsSmsConfig;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.messaging.sms.util.TelephonyUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.media.upload.MEDIA_RESIZE_COMPLETE */
public class ProcessMmsReceivedAction {
    private final Context f17647a;
    private final FbSharedPreferences f17648b;
    private final SmsMessageLoader f17649c;
    private final MmsSmsConfig f17650d;
    private final MmsSmsCacheUpdateAction f17651e;
    private final ProcessDownloadMmsAction f17652f;

    public static ProcessMmsReceivedAction m17615a(InjectorLike injectorLike) {
        return new ProcessMmsReceivedAction((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SmsMessageLoader.m17430a(injectorLike), MmsSmsConfig.m17636b(injectorLike), MmsSmsCacheUpdateAction.m17596b(injectorLike), ProcessDownloadMmsAction.m17604b(injectorLike));
    }

    @Inject
    public ProcessMmsReceivedAction(Context context, FbSharedPreferences fbSharedPreferences, SmsMessageLoader smsMessageLoader, MmsSmsConfig mmsSmsConfig, MmsSmsCacheUpdateAction mmsSmsCacheUpdateAction, ProcessDownloadMmsAction processDownloadMmsAction) {
        this.f17647a = context;
        this.f17648b = fbSharedPreferences;
        this.f17649c = smsMessageLoader;
        this.f17650d = mmsSmsConfig;
        this.f17651e = mmsSmsCacheUpdateAction;
        this.f17652f = processDownloadMmsAction;
    }

    public final void m17617a(Bundle bundle) {
        boolean z = true;
        byte[] byteArray = bundle.getByteArray("data");
        if (byteArray == null) {
            throw new MmsException("No data in MMS: " + bundle);
        }
        GenericPdu a = new PduParser(byteArray, this.f17650d.m17640b()).m3679a();
        if (a == null) {
            throw new MmsException("Recieved invalid message: " + bundle);
        }
        PduPersister a2 = PduPersister.m3703a(this.f17647a, this.f17648b.a(SmsPrefKeys.L, null));
        try {
            if (a.m3593b() == 130) {
                NotificationInd notificationInd = (NotificationInd) a;
                if (!m17616a(notificationInd)) {
                    boolean a3 = this.f17650d.m17638a();
                    Uri uri = Inbox.a;
                    int a4 = TelephonyUtils.m17716a(-1);
                    String b = a2.m3723b();
                    if (a3) {
                        z = false;
                    }
                    uri = a2.m3720a(notificationInd, uri, a4, b, z, null);
                    if (a3) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("extra_uri", uri);
                        bundle2.putBoolean("extra_repersist_on_error", true);
                        bundle2.putString("location_url", new String(notificationInd.m3617d()));
                        this.f17652f.m17605a(bundle2);
                    } else {
                        Message a5 = this.f17649c.m17441a(uri);
                        if (a5 != null) {
                            this.f17651e.m17600a(CallerContext.a(getClass()), a5, null);
                        } else {
                            BLog.c("ProcessMmsReceivedAction", "Failed to load received message %s", new Object[]{uri.toString()});
                        }
                    }
                }
            } else {
                BLog.b("ProcessMmsReceivedAction", "Received unhandled PDU.");
            }
            a2.m3722a();
        } catch (Throwable th) {
            a2.m3722a();
        }
    }

    private boolean m17616a(NotificationInd notificationInd) {
        byte[] d = notificationInd.m3617d();
        if (d != null) {
            Expression a = SqlExpression.a("ct_l", new String(d));
            Cursor query = this.f17647a.getContentResolver().query(Mms.a, new String[]{"_id"}, a.a(), a.b(), null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        return true;
                    }
                    query.close();
                } finally {
                    query.close();
                }
            }
        }
        return false;
    }
}
