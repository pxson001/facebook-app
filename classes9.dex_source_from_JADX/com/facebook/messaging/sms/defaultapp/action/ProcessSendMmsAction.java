package com.facebook.messaging.sms.defaultapp.action;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android_src.mmsv2.MmsManager;
import android_src.mmsv2.pdu.GenericPdu;
import android_src.mmsv2.pdu.MmsException;
import android_src.mmsv2.pdu.PduBody;
import android_src.mmsv2.pdu.PduPersister;
import android_src.mmsv2.pdu.SendReq;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.content.SecurePendingIntent;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.common.Constants.MmsSmsErrorType;
import com.facebook.messaging.sms.common.MmsSmsIdUtils;
import com.facebook.messaging.sms.defaultapp.MmsFileProvider;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.sms.defaultapp.SmsReceiver;
import com.facebook.messaging.sms.defaultapp.config.MmsSmsConfig;
import com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue;
import com.facebook.messaging.sms.defaultapp.send.MmsStickerAttachmentHelper;
import com.facebook.messaging.sms.defaultapp.send.PendingSendMessage;
import com.facebook.messaging.sms.util.TelephonyUtils;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.stickers.client.FetchStickerCoordinator;
import com.facebook.stickers.client.StickerAssetDownloadUtil;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.ui.StickerUrls;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.extra.THREAD_TOKEN */
public class ProcessSendMmsAction {
    private final Context f17657a;
    private final SmsDefaultAppManager f17658b;
    private final MmsSmsConfig f17659c;
    private final MmsSmsPendingSendQueue f17660d;
    private final MmsStickerAttachmentHelper f17661e;

    private static ProcessSendMmsAction m17622b(InjectorLike injectorLike) {
        return new ProcessSendMmsAction((Context) injectorLike.getInstance(Context.class), SmsDefaultAppManager.a(injectorLike), MmsSmsConfig.m17636b(injectorLike), MmsSmsPendingSendQueue.m17644a(injectorLike), new MmsStickerAttachmentHelper((Context) injectorLike.getInstance(Context.class), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), FetchStickerCoordinator.a(injectorLike), RuntimePermissionsUtil.b(injectorLike), StickerAssetDownloadUtil.b(injectorLike), StickerCache.a(injectorLike), StickerUrls.b(injectorLike)));
    }

    public static ProcessSendMmsAction m17620a(InjectorLike injectorLike) {
        return m17622b(injectorLike);
    }

    @Inject
    public ProcessSendMmsAction(Context context, SmsDefaultAppManager smsDefaultAppManager, MmsSmsConfig mmsSmsConfig, MmsSmsPendingSendQueue mmsSmsPendingSendQueue, MmsStickerAttachmentHelper mmsStickerAttachmentHelper) {
        this.f17657a = context;
        this.f17658b = smsDefaultAppManager;
        this.f17659c = mmsSmsConfig;
        this.f17660d = mmsSmsPendingSendQueue;
        this.f17661e = mmsStickerAttachmentHelper;
    }

    private void m17621a(Uri uri, MmsSmsErrorType mmsSmsErrorType, @Nullable String str, PendingSendMessage pendingSendMessage) {
        Intent intent = new Intent("com.facebook.messaging.sms.MESSAGE_SENT", uri, this.f17657a, SmsReceiver.class);
        if (!Strings.isNullOrEmpty(str)) {
            intent.putExtra("mmssms_quickfail_msg", str);
        }
        intent.putExtra("mmssms_quickfail_type", mmsSmsErrorType);
        PendingSendMessage.m17662a(intent, pendingSendMessage);
        this.f17657a.sendBroadcast(intent);
    }

    public final void m17623a(PendingSendMessage pendingSendMessage) {
        Uri b = MmsSmsIdUtils.m17500b(pendingSendMessage.m17663a());
        if (pendingSendMessage.m17666e()) {
            m17621a(b, MmsSmsErrorType.EXPIRED_MESSAGE, null, pendingSendMessage);
        } else if (TelephonyUtils.m17718c(this.f17657a)) {
            PduPersister a = PduPersister.m3702a(this.f17657a);
            GenericPdu genericPdu = (SendReq) a.m3721a(b);
            if (genericPdu == null) {
                this.f17660d.m17654b(pendingSendMessage.m17663a(), pendingSendMessage.m17664b());
            }
            PduBody d = genericPdu.m3613d();
            String str = new String(d.m3620a(0).m3696i());
            if (d.m3624b() == 1 && str.startsWith("sticker:")) {
                try {
                    d.m3623a(this.f17661e.m17660a(str.substring(8)));
                    a.m3720a(genericPdu, b, TelephonyUtils.m17716a(-1), a.m3723b(), true, null);
                } catch (MmsException e) {
                    m17621a(b, MmsSmsErrorType.STICKER_FAIL, e.getMessage(), pendingSendMessage);
                    return;
                }
            }
            if (genericPdu.mo124e() > ((long) this.f17659c.m17641c())) {
                m17621a(b, MmsSmsErrorType.OVERSIZE, "size: " + genericPdu.mo124e(), pendingSendMessage);
                return;
            }
            try {
                Object a2 = MmsFileProvider.m17521a(this.f17657a, genericPdu);
                Intent intent = new Intent("com.facebook.messaging.sms.MESSAGE_SENT", b, this.f17657a, SmsReceiver.class);
                intent.putExtra("content_uri", a2);
                PendingSendMessage.m17662a(intent, pendingSendMessage);
                PendingIntent b2 = SecurePendingIntent.b(this.f17657a, 0, intent, 134217728);
                this.f17658b.b();
                MmsManager.m3539a(TelephonyUtils.m17716a(-1), this.f17657a, a2, null, b2);
            } catch (Exception e2) {
                m17621a(b, MmsSmsErrorType.FILE_PROVIDER, e2.getMessage(), pendingSendMessage);
            }
        } else {
            m17621a(b, MmsSmsErrorType.NO_CONNECTION, null, pendingSendMessage);
        }
    }
}
