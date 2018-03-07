package com.facebook.messaging.tincan.messenger;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mNotificationsCounts */
public class AttachmentUploadRetryColStartTrigger implements INeedInit {
    public final NetworkMonitor f8596a;
    private final ExecutorService f8597b;
    public final EncryptedAttachmentUploadRetryHandler f8598c;
    private final LoggedInUserSessionManager f8599d;
    @Nullable
    public SelfRegistrableReceiverImpl f8600e = null;

    /* compiled from: mNotificationsCounts */
    class C05332 implements Runnable {
        final /* synthetic */ AttachmentUploadRetryColStartTrigger f11145a;

        C05332(AttachmentUploadRetryColStartTrigger attachmentUploadRetryColStartTrigger) {
            this.f11145a = attachmentUploadRetryColStartTrigger;
        }

        public void run() {
            this.f11145a.f8598c.m8854a();
        }
    }

    public static AttachmentUploadRetryColStartTrigger m8848b(InjectorLike injectorLike) {
        return new AttachmentUploadRetryColStartTrigger(NetworkMonitor.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), EncryptedAttachmentUploadRetryHandler.m8851a(injectorLike), LoggedInUserSessionManager.a(injectorLike));
    }

    @Inject
    public AttachmentUploadRetryColStartTrigger(NetworkMonitor networkMonitor, ExecutorService executorService, EncryptedAttachmentUploadRetryHandler encryptedAttachmentUploadRetryHandler, LoggedInUserSessionManager loggedInUserSessionManager) {
        this.f8596a = networkMonitor;
        this.f8597b = executorService;
        this.f8598c = encryptedAttachmentUploadRetryHandler;
        this.f8599d = loggedInUserSessionManager;
    }

    public void init() {
        if (this.f8596a.a()) {
            m8849b(this);
        } else {
            this.f8600e = this.f8596a.a(State.CONNECTED, new 1(this));
        }
    }

    public static void m8849b(AttachmentUploadRetryColStartTrigger attachmentUploadRetryColStartTrigger) {
        if (attachmentUploadRetryColStartTrigger.f8599d.b()) {
            m8850c(attachmentUploadRetryColStartTrigger);
        }
    }

    public static void m8850c(AttachmentUploadRetryColStartTrigger attachmentUploadRetryColStartTrigger) {
        if (attachmentUploadRetryColStartTrigger.f8600e != null && attachmentUploadRetryColStartTrigger.f8600e.a()) {
            attachmentUploadRetryColStartTrigger.f8600e.c();
            attachmentUploadRetryColStartTrigger.f8600e = null;
        }
        ExecutorDetour.a(attachmentUploadRetryColStartTrigger.f8597b, new C05332(attachmentUploadRetryColStartTrigger), -1557327118);
    }
}
