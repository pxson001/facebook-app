package com.facebook.messaging.send.client;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.send.PendingSendQueueKey;
import com.facebook.messaging.model.send.PendingSendQueueType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;

@UserScoped
/* compiled from: default_funding_amount */
public class SendQueueSeparationExperimentController {
    private static final Object f16840d = new Object();
    private final QeAccessor f16841a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f16842b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessageClassifier> f16843c = UltralightRuntime.b;

    private static SendQueueSeparationExperimentController m16834b(InjectorLike injectorLike) {
        SendQueueSeparationExperimentController sendQueueSeparationExperimentController = new SendQueueSeparationExperimentController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 494);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.b(injectorLike, 2661);
        sendQueueSeparationExperimentController.f16842b = b;
        sendQueueSeparationExperimentController.f16843c = b2;
        return sendQueueSeparationExperimentController;
    }

    @Inject
    public SendQueueSeparationExperimentController(QeAccessor qeAccessor) {
        this.f16841a = qeAccessor;
    }

    public final PendingSendQueueKey m16835a(ThreadKey threadKey, MessageClassification messageClassification, PendingThreadSendMap pendingThreadSendMap) {
        if (messageClassification == MessageClassification.VIDEO_CLIP) {
            return new PendingSendQueueKey(threadKey, PendingSendQueueType.VIDEO);
        }
        if (messageClassification == MessageClassification.PHOTOS) {
            if (m16832a(threadKey, PendingSendQueueType.PHOTO, messageClassification, pendingThreadSendMap)) {
                return new PendingSendQueueKey(threadKey, PendingSendQueueType.PHOTO);
            }
            return m16833b(threadKey, messageClassification, pendingThreadSendMap);
        } else if (messageClassification == MessageClassification.AUDIO_CLIP) {
            return m16833b(threadKey, messageClassification, pendingThreadSendMap);
        } else {
            return new PendingSendQueueKey(threadKey, PendingSendQueueType.NORMAL);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.client.SendQueueSeparationExperimentController m16831a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f16840d;	 Catch:{ all -> 0x006c }
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
        r1 = m16834b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16840d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.SendQueueSeparationExperimentController) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.client.SendQueueSeparationExperimentController) r0;	 Catch:{  }
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
        r0 = f16840d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.SendQueueSeparationExperimentController) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.client.SendQueueSeparationExperimentController.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.client.SendQueueSeparationExperimentController");
    }

    private PendingSendQueueKey m16833b(ThreadKey threadKey, MessageClassification messageClassification, PendingThreadSendMap pendingThreadSendMap) {
        if (m16832a(threadKey, PendingSendQueueType.NORMAL, messageClassification, pendingThreadSendMap)) {
            return new PendingSendQueueKey(threadKey, PendingSendQueueType.NORMAL);
        }
        if (m16832a(threadKey, PendingSendQueueType.LIGHT_MEDIA, messageClassification, pendingThreadSendMap)) {
            return new PendingSendQueueKey(threadKey, PendingSendQueueType.LIGHT_MEDIA);
        }
        return m16830a(threadKey, messageClassification);
    }

    private boolean m16832a(ThreadKey threadKey, PendingSendQueueType pendingSendQueueType, MessageClassification messageClassification, PendingThreadSendMap pendingThreadSendMap) {
        PendingThreadSends a = pendingThreadSendMap.m16706a(new PendingSendQueueKey(threadKey, pendingSendQueueType));
        if (a != null) {
            for (Message a2 : a.m16717o()) {
                if (((MessageClassifier) this.f16843c.get()).a(a2) == messageClassification) {
                    return true;
                }
            }
        }
        return false;
    }

    private PendingSendQueueKey m16830a(ThreadKey threadKey, MessageClassification messageClassification) {
        PendingSendQueueType pendingSendQueueType = PendingSendQueueType.NORMAL;
        boolean a = this.f16841a.a(ExperimentsForMessagingSendClientModule.f16651a, true);
        boolean a2 = this.f16841a.a(ExperimentsForMessagingSendClientModule.f16652b, false);
        boolean a3 = this.f16841a.a(ExperimentsForMessagingSendClientModule.f16653c, false);
        Object obj = 1;
        if (a) {
            if (a2 || a3) {
                obj = null;
            }
        } else if (a2) {
            if (a || a3) {
                obj = null;
            }
        } else if (!a3 || a || a2) {
            obj = null;
        }
        if (obj == null) {
            ((AbstractFbErrorReporter) this.f16842b.get()).a("SendQueueSeparationExperimentController", StringFormatUtil.a("Invalid qe configuration. [isSeparateVideoQueueOnly=%s,isSeparatePhotoAndVideoQueuesEnabled=%s,isSeparateLightMediaAndVideoQueuesEnabled=%s]", new Object[]{Boolean.valueOf(a), Boolean.valueOf(a2), Boolean.valueOf(a3)}));
            return new PendingSendQueueKey(threadKey, PendingSendQueueType.NORMAL);
        }
        if (!a) {
            if (a3) {
                pendingSendQueueType = PendingSendQueueType.LIGHT_MEDIA;
            } else if (a2) {
                if (messageClassification == MessageClassification.PHOTOS) {
                    pendingSendQueueType = PendingSendQueueType.PHOTO;
                }
            }
            return new PendingSendQueueKey(threadKey, pendingSendQueueType);
        }
        pendingSendQueueType = PendingSendQueueType.NORMAL;
        return new PendingSendQueueKey(threadKey, pendingSendQueueType);
    }
}
