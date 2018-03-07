package com.facebook.messaging.sms.defaultapp.action;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android_src.provider.Telephony.Sms;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.sms.SmsMessageLoader;
import com.facebook.messaging.sms.common.Constants.MmsSmsErrorType;
import com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue;
import com.facebook.messaging.sms.defaultapp.send.PendingSendMessage;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.extra.PROTOCOL_VERSION */
public class ProcessSmsSentAction {
    private final Context f17671a;
    private final SmsMessageLoader f17672b;
    private final MmsSmsCacheUpdateAction f17673c;
    private final MmsSmsPendingSendQueue f17674d;

    public static ProcessSmsSentAction m17634a(InjectorLike injectorLike) {
        return new ProcessSmsSentAction((Context) injectorLike.getInstance(Context.class), SmsMessageLoader.m17430a(injectorLike), MmsSmsCacheUpdateAction.m17596b(injectorLike), MmsSmsPendingSendQueue.m17644a(injectorLike));
    }

    @Inject
    public ProcessSmsSentAction(Context context, SmsMessageLoader smsMessageLoader, MmsSmsCacheUpdateAction mmsSmsCacheUpdateAction, MmsSmsPendingSendQueue mmsSmsPendingSendQueue) {
        this.f17671a = context;
        this.f17672b = smsMessageLoader;
        this.f17673c = mmsSmsCacheUpdateAction;
        this.f17674d = mmsSmsPendingSendQueue;
    }

    @Nullable
    public final Message m17635a(Uri uri, Bundle bundle) {
        MmsSmsErrorType mmsSmsErrorType = (MmsSmsErrorType) bundle.getSerializable("mmssms_error_type");
        if (mmsSmsErrorType != MmsSmsErrorType.NO_ERROR) {
            Sms.a(this.f17671a, uri, 5, 1);
        } else if (!Sms.a(this.f17671a, uri, 2, 0)) {
            BLog.b("ProcessSmsSentAction", "Failed to move message to sent box: %s", new Object[]{uri});
        }
        PendingSendMessage a = PendingSendMessage.m17661a(bundle);
        this.f17674d.m17654b(a.f17703a, a.f17704b);
        Message a2 = this.f17672b.m17441a(uri);
        if (a2 != null) {
            this.f17673c.m17601a(CallerContext.a(getClass()), a2, mmsSmsErrorType);
        } else {
            BLog.b("ProcessSmsSentAction", "Failed to load sent sms for notification: %s", new Object[]{uri});
        }
        return a2;
    }
}
