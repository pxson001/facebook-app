package com.facebook.messaging.tincan.messenger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.upload.EncryptedPhotoUploadResult;
import com.facebook.messaging.media.upload.EncryptedPhotoUploadResult.Status;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@UserScoped
/* compiled from: client_city */
public class AttachmentUploadCompleteListener {
    private static final Object f17978d = new Object();
    private final DefaultBlueServiceOperationFactory f17979a;
    private final BaseFbBroadcastManager f17980b;
    private final AttachmentUploadRetryTrigger f17981c;

    /* compiled from: client_city */
    class C21061 implements ActionReceiver {
        final /* synthetic */ AttachmentUploadCompleteListener f17977a;

        C21061(AttachmentUploadCompleteListener attachmentUploadCompleteListener) {
            this.f17977a = attachmentUploadCompleteListener;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1345144601);
            AttachmentUploadCompleteListener.m17973a(this.f17977a, (EncryptedPhotoUploadResult) intent.getParcelableExtra("EncryptedPhotoUploadStatusKey"));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 950943203, a);
        }
    }

    private static AttachmentUploadCompleteListener m17974b(InjectorLike injectorLike) {
        return new AttachmentUploadCompleteListener(DefaultBlueServiceOperationFactory.b(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), new AttachmentUploadRetryTrigger(NetworkMonitor.a(injectorLike), EncryptedAttachmentUploadRetryHandler.a(injectorLike), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public AttachmentUploadCompleteListener(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, BaseFbBroadcastManager baseFbBroadcastManager, AttachmentUploadRetryTrigger attachmentUploadRetryTrigger) {
        this.f17979a = defaultBlueServiceOperationFactory;
        this.f17980b = baseFbBroadcastManager;
        this.f17981c = attachmentUploadRetryTrigger;
    }

    public final void m17976a() {
        this.f17980b.a().a("EncryptedPhotoUploadStatusAction", new C21061(this)).a().b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.messenger.AttachmentUploadCompleteListener m17972a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f17978d;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m17974b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17978d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.AttachmentUploadCompleteListener) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.messenger.AttachmentUploadCompleteListener) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f17978d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.AttachmentUploadCompleteListener) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.messenger.AttachmentUploadCompleteListener.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.messenger.AttachmentUploadCompleteListener");
    }

    public static void m17973a(AttachmentUploadCompleteListener attachmentUploadCompleteListener, EncryptedPhotoUploadResult encryptedPhotoUploadResult) {
        if (encryptedPhotoUploadResult.f11827c == Status.Success) {
            attachmentUploadCompleteListener.f17981c.m17991a(encryptedPhotoUploadResult.f11825a, encryptedPhotoUploadResult.f11826b);
            attachmentUploadCompleteListener.m17975b(encryptedPhotoUploadResult);
            return;
        }
        Preconditions.checkState(encryptedPhotoUploadResult.f11827c == Status.Failure);
        if (!attachmentUploadCompleteListener.f17981c.m17992b(encryptedPhotoUploadResult.f11825a, encryptedPhotoUploadResult.f11826b)) {
            attachmentUploadCompleteListener.m17975b(encryptedPhotoUploadResult);
        }
    }

    private void m17975b(EncryptedPhotoUploadResult encryptedPhotoUploadResult) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("upload_status", encryptedPhotoUploadResult);
        BlueServiceOperationFactoryDetour.a(this.f17979a, "UpdateUploadStatus", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(TincanSendMessageManager.class), 392601277).a();
    }
}
