package com.facebook.messaging.sms.defaultapp.action;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony.Mms.Sent;
import android_src.mmsv2.pdu.MmsException;
import android_src.mmsv2.pdu.PduPersister;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.sms.SmsMessageLoader;
import com.facebook.messaging.sms.common.Constants.MmsSmsErrorType;
import com.facebook.messaging.sms.defaultapp.MmsFileProvider;
import com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue;
import com.facebook.messaging.sms.defaultapp.send.PendingSendMessage;
import java.io.File;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.media.upload.MEDIA_GET_FBID_COMPLETE */
public class ProcessMmsSentAction {
    private final Context f17653a;
    private final SmsMessageLoader f17654b;
    private final MmsSmsCacheUpdateAction f17655c;
    private final MmsSmsPendingSendQueue f17656d;

    public static ProcessMmsSentAction m17618a(InjectorLike injectorLike) {
        return new ProcessMmsSentAction((Context) injectorLike.getInstance(Context.class), SmsMessageLoader.m17430a(injectorLike), MmsSmsCacheUpdateAction.m17596b(injectorLike), MmsSmsPendingSendQueue.m17644a(injectorLike));
    }

    @Inject
    public ProcessMmsSentAction(Context context, SmsMessageLoader smsMessageLoader, MmsSmsCacheUpdateAction mmsSmsCacheUpdateAction, MmsSmsPendingSendQueue mmsSmsPendingSendQueue) {
        this.f17653a = context;
        this.f17654b = smsMessageLoader;
        this.f17655c = mmsSmsCacheUpdateAction;
        this.f17656d = mmsSmsPendingSendQueue;
    }

    @Nullable
    public final Message m17619a(Uri uri, Bundle bundle) {
        MmsSmsErrorType mmsSmsErrorType = (MmsSmsErrorType) bundle.getSerializable("mmssms_error_type");
        Uri uri2 = (Uri) bundle.getParcelable("content_uri");
        if (uri2 != null) {
            File a = MmsFileProvider.m17522a(this.f17653a, uri2);
            if (a.exists()) {
                a.delete();
            }
        }
        if (mmsSmsErrorType == MmsSmsErrorType.NO_ERROR) {
            try {
                uri = PduPersister.m3702a(this.f17653a).m3719a(uri, Sent.CONTENT_URI);
            } catch (MmsException e) {
                mmsSmsErrorType = MmsSmsErrorType.PROCESSING_ERROR;
            }
        }
        if (mmsSmsErrorType != MmsSmsErrorType.NO_ERROR) {
            MmsPendingMessageAction.m17595a(this.f17653a, uri);
        }
        PendingSendMessage a2 = PendingSendMessage.m17661a(bundle);
        this.f17656d.m17654b(a2.m17663a(), a2.m17664b());
        Message a3 = this.f17654b.m17441a(uri);
        if (a3 != null) {
            this.f17655c.m17601a(CallerContext.a(getClass()), a3, mmsSmsErrorType);
        } else {
            BLog.b("ProcessMmsSentAction", "Failed to load sent mms for notification: %s", new Object[]{uri});
        }
        return a3;
    }
}
