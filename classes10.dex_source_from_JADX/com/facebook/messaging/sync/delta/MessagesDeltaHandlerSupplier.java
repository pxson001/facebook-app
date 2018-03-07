package com.facebook.messaging.sync.delta;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.sync.delta.handler.DeltaAdminAddedToGroupThreadHandler;
import com.facebook.messaging.sync.delta.handler.DeltaAdminRemovedFromGroupThreadHandler;
import com.facebook.messaging.sync.delta.handler.DeltaAdminTextMessageHandler;
import com.facebook.messaging.sync.delta.handler.DeltaApprovalModeHandler;
import com.facebook.messaging.sync.delta.handler.DeltaApprovalQueueHandler;
import com.facebook.messaging.sync.delta.handler.DeltaBroadcastMessageHandler;
import com.facebook.messaging.sync.delta.handler.DeltaDeliveredReceiptHandler;
import com.facebook.messaging.sync.delta.handler.DeltaFolderCountHandler;
import com.facebook.messaging.sync.delta.handler.DeltaForcedFetchHandler;
import com.facebook.messaging.sync.delta.handler.DeltaGenieMessageHandler;
import com.facebook.messaging.sync.delta.handler.DeltaJoinableModeHandler;
import com.facebook.messaging.sync.delta.handler.DeltaMarkReadHandler;
import com.facebook.messaging.sync.delta.handler.DeltaMarkUnreadHandler;
import com.facebook.messaging.sync.delta.handler.DeltaMessageDeleteHandler;
import com.facebook.messaging.sync.delta.handler.DeltaMontageMessageHandler;
import com.facebook.messaging.sync.delta.handler.DeltaNewMessageHandler;
import com.facebook.messaging.sync.delta.handler.DeltaNoOpHandler;
import com.facebook.messaging.sync.delta.handler.DeltaP2PPaymentMessageHandler;
import com.facebook.messaging.sync.delta.handler.DeltaParticipantLeftGroupThreadHandler;
import com.facebook.messaging.sync.delta.handler.DeltaParticipantsAddedToGroupThreadHandler;
import com.facebook.messaging.sync.delta.handler.DeltaRTCEventLogHandler;
import com.facebook.messaging.sync.delta.handler.DeltaReadReceiptHandler;
import com.facebook.messaging.sync.delta.handler.DeltaReplaceMessageHandler;
import com.facebook.messaging.sync.delta.handler.DeltaSentMessageHandler;
import com.facebook.messaging.sync.delta.handler.DeltaThreadActionHandler;
import com.facebook.messaging.sync.delta.handler.DeltaThreadDeleteHandler;
import com.facebook.messaging.sync.delta.handler.DeltaThreadFolderHandler;
import com.facebook.messaging.sync.delta.handler.DeltaThreadImageHandler;
import com.facebook.messaging.sync.delta.handler.DeltaThreadMuteSettingsHandler;
import com.facebook.messaging.sync.delta.handler.DeltaThreadNameHandler;
import com.facebook.messaging.sync.delta.handler.DeltaThreadRtcCallInfoHandler;
import com.facebook.messaging.sync.delta.handler.DeltaZeroRatingHandler;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.sync.delta.DeltaHandlerSupplier;
import javax.inject.Inject;

@UserScoped
/* compiled from: profile_share_opened */
public class MessagesDeltaHandlerSupplier implements DeltaHandlerSupplier<PrefetchedSyncData, DeltaWrapper> {
    private static final Object f4368G = new Object();
    private final Lazy<DeltaAdminAddedToGroupThreadHandler> f4369A;
    private final Lazy<DeltaAdminRemovedFromGroupThreadHandler> f4370B;
    private final Lazy<DeltaJoinableModeHandler> f4371C;
    private final Lazy<DeltaApprovalModeHandler> f4372D;
    private final Lazy<DeltaApprovalQueueHandler> f4373E;
    private final Lazy<DeltaThreadRtcCallInfoHandler> f4374F;
    private final Lazy<DeltaNoOpHandler> f4375a;
    private final Lazy<DeltaNewMessageHandler> f4376b;
    private final Lazy<DeltaMarkReadHandler> f4377c;
    private final Lazy<DeltaMarkUnreadHandler> f4378d;
    private final Lazy<DeltaMessageDeleteHandler> f4379e;
    private final Lazy<DeltaThreadDeleteHandler> f4380f;
    private final Lazy<DeltaParticipantsAddedToGroupThreadHandler> f4381g;
    private final Lazy<DeltaParticipantLeftGroupThreadHandler> f4382h;
    private final Lazy<DeltaThreadNameHandler> f4383i;
    private final Lazy<DeltaThreadImageHandler> f4384j;
    private final Lazy<DeltaThreadMuteSettingsHandler> f4385k;
    private final Lazy<DeltaThreadActionHandler> f4386l;
    private final Lazy<DeltaThreadFolderHandler> f4387m;
    private final Lazy<DeltaRTCEventLogHandler> f4388n;
    private final Lazy<DeltaReadReceiptHandler> f4389o;
    private final Lazy<DeltaAdminTextMessageHandler> f4390p;
    private final Lazy<DeltaSentMessageHandler> f4391q;
    private final Lazy<DeltaDeliveredReceiptHandler> f4392r;
    private final Lazy<DeltaBroadcastMessageHandler> f4393s;
    private final Lazy<DeltaP2PPaymentMessageHandler> f4394t;
    private final Lazy<DeltaFolderCountHandler> f4395u;
    private final Lazy<DeltaZeroRatingHandler> f4396v;
    private final Lazy<DeltaReplaceMessageHandler> f4397w;
    private final Lazy<DeltaMontageMessageHandler> f4398x;
    private final Lazy<DeltaGenieMessageHandler> f4399y;
    private final Lazy<DeltaForcedFetchHandler> f4400z;

    private static MessagesDeltaHandlerSupplier m3975b(InjectorLike injectorLike) {
        return new MessagesDeltaHandlerSupplier(IdBasedLazy.a(injectorLike, 8519), IdBasedLazy.a(injectorLike, 8518), IdBasedLazy.a(injectorLike, 8514), IdBasedLazy.a(injectorLike, 8515), IdBasedLazy.a(injectorLike, 8516), IdBasedLazy.a(injectorLike, 8528), IdBasedLazy.a(injectorLike, 8522), IdBasedLazy.a(injectorLike, 8521), IdBasedLazy.a(injectorLike, 8532), IdBasedLazy.a(injectorLike, 8530), IdBasedLazy.a(injectorLike, 8531), IdBasedLazy.a(injectorLike, 8527), IdBasedLazy.a(injectorLike, 8529), IdBasedLazy.a(injectorLike, 8523), IdBasedLazy.a(injectorLike, 8524), IdBasedLazy.a(injectorLike, 8505), IdBasedLazy.a(injectorLike, 8526), IdBasedLazy.a(injectorLike, 8509), IdBasedLazy.a(injectorLike, 8508), IdBasedLazy.a(injectorLike, 8520), IdBasedLazy.a(injectorLike, 8510), IdBasedLazy.a(injectorLike, 8534), IdBasedLazy.a(injectorLike, 8525), IdBasedLazy.a(injectorLike, 8517), IdBasedLazy.a(injectorLike, 8512), IdBasedLazy.a(injectorLike, 8511), IdBasedLazy.a(injectorLike, 8503), IdBasedLazy.a(injectorLike, 8504), IdBasedLazy.a(injectorLike, 8513), IdBasedLazy.a(injectorLike, 8506), IdBasedLazy.a(injectorLike, 8507), IdBasedLazy.a(injectorLike, 8533));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.MessagesDeltaHandlerSupplier m3974a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4368G;	 Catch:{ all -> 0x006c }
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
        r1 = m3975b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4368G;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.MessagesDeltaHandlerSupplier) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.MessagesDeltaHandlerSupplier) r0;	 Catch:{  }
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
        r0 = f4368G;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.MessagesDeltaHandlerSupplier) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.MessagesDeltaHandlerSupplier.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.MessagesDeltaHandlerSupplier");
    }

    public final AbstractMessagesDeltaHandler m3976a(DeltaWrapper deltaWrapper) {
        switch (deltaWrapper.setField_) {
            case 1:
                return (AbstractMessagesDeltaHandler) this.f4375a.get();
            case 2:
                return (AbstractMessagesDeltaHandler) this.f4376b.get();
            case 3:
                return (AbstractMessagesDeltaHandler) this.f4375a.get();
            case 4:
                return (AbstractMessagesDeltaHandler) this.f4377c.get();
            case 5:
                return (AbstractMessagesDeltaHandler) this.f4378d.get();
            case 6:
                return (AbstractMessagesDeltaHandler) this.f4379e.get();
            case 7:
                return (AbstractMessagesDeltaHandler) this.f4380f.get();
            case 8:
                return (AbstractMessagesDeltaHandler) this.f4381g.get();
            case 9:
                return (AbstractMessagesDeltaHandler) this.f4382h.get();
            case 10:
                return (AbstractMessagesDeltaHandler) this.f4383i.get();
            case 11:
                return (AbstractMessagesDeltaHandler) this.f4384j.get();
            case 12:
                return (AbstractMessagesDeltaHandler) this.f4385k.get();
            case 13:
                return (AbstractMessagesDeltaHandler) this.f4386l.get();
            case 14:
                return (AbstractMessagesDeltaHandler) this.f4387m.get();
            case 15:
                return (AbstractMessagesDeltaHandler) this.f4388n.get();
            case 17:
                return (AbstractMessagesDeltaHandler) this.f4390p.get();
            case 18:
                return (AbstractMessagesDeltaHandler) this.f4400z.get();
            case 19:
                return (AbstractMessagesDeltaHandler) this.f4389o.get();
            case 20:
                return (AbstractMessagesDeltaHandler) this.f4393s.get();
            case 22:
                return (AbstractMessagesDeltaHandler) this.f4391q.get();
            case 25:
                return (AbstractMessagesDeltaHandler) this.f4392r.get();
            case 26:
                return (AbstractMessagesDeltaHandler) this.f4394t.get();
            case 27:
                return (AbstractMessagesDeltaHandler) this.f4395u.get();
            case 28:
                return (AbstractMessagesDeltaHandler) this.f4375a.get();
            case 30:
                return (AbstractMessagesDeltaHandler) this.f4397w.get();
            case 31:
                return (AbstractMessagesDeltaHandler) this.f4396v.get();
            case 32:
                return (AbstractMessagesDeltaHandler) this.f4398x.get();
            case 33:
                return (AbstractMessagesDeltaHandler) this.f4399y.get();
            case 35:
                return (AbstractMessagesDeltaHandler) this.f4369A.get();
            case 36:
                return (AbstractMessagesDeltaHandler) this.f4370B.get();
            case 37:
                return (AbstractMessagesDeltaHandler) this.f4374F.get();
            case 38:
                return (AbstractMessagesDeltaHandler) this.f4371C.get();
            case 39:
                return (AbstractMessagesDeltaHandler) this.f4372D.get();
            case 40:
                return (AbstractMessagesDeltaHandler) this.f4373E.get();
            default:
                throw new RuntimeException(String.format("Unsupported delta type: %s", new Object[]{Integer.valueOf(deltaWrapper.setField_)}));
        }
    }

    @Inject
    public MessagesDeltaHandlerSupplier(Lazy<DeltaNoOpHandler> lazy, Lazy<DeltaNewMessageHandler> lazy2, Lazy<DeltaMarkReadHandler> lazy3, Lazy<DeltaMarkUnreadHandler> lazy4, Lazy<DeltaMessageDeleteHandler> lazy5, Lazy<DeltaThreadDeleteHandler> lazy6, Lazy<DeltaParticipantsAddedToGroupThreadHandler> lazy7, Lazy<DeltaParticipantLeftGroupThreadHandler> lazy8, Lazy<DeltaThreadNameHandler> lazy9, Lazy<DeltaThreadImageHandler> lazy10, Lazy<DeltaThreadMuteSettingsHandler> lazy11, Lazy<DeltaThreadActionHandler> lazy12, Lazy<DeltaThreadFolderHandler> lazy13, Lazy<DeltaRTCEventLogHandler> lazy14, Lazy<DeltaReadReceiptHandler> lazy15, Lazy<DeltaAdminTextMessageHandler> lazy16, Lazy<DeltaSentMessageHandler> lazy17, Lazy<DeltaDeliveredReceiptHandler> lazy18, Lazy<DeltaBroadcastMessageHandler> lazy19, Lazy<DeltaP2PPaymentMessageHandler> lazy20, Lazy<DeltaFolderCountHandler> lazy21, Lazy<DeltaZeroRatingHandler> lazy22, Lazy<DeltaReplaceMessageHandler> lazy23, Lazy<DeltaMontageMessageHandler> lazy24, Lazy<DeltaGenieMessageHandler> lazy25, Lazy<DeltaForcedFetchHandler> lazy26, Lazy<DeltaAdminAddedToGroupThreadHandler> lazy27, Lazy<DeltaAdminRemovedFromGroupThreadHandler> lazy28, Lazy<DeltaJoinableModeHandler> lazy29, Lazy<DeltaApprovalModeHandler> lazy30, Lazy<DeltaApprovalQueueHandler> lazy31, Lazy<DeltaThreadRtcCallInfoHandler> lazy32) {
        this.f4375a = lazy;
        this.f4376b = lazy2;
        this.f4377c = lazy3;
        this.f4378d = lazy4;
        this.f4379e = lazy5;
        this.f4380f = lazy6;
        this.f4383i = lazy9;
        this.f4384j = lazy10;
        this.f4385k = lazy11;
        this.f4381g = lazy7;
        this.f4382h = lazy8;
        this.f4386l = lazy12;
        this.f4387m = lazy13;
        this.f4388n = lazy14;
        this.f4389o = lazy15;
        this.f4390p = lazy16;
        this.f4391q = lazy17;
        this.f4392r = lazy18;
        this.f4393s = lazy19;
        this.f4394t = lazy20;
        this.f4395u = lazy21;
        this.f4396v = lazy22;
        this.f4397w = lazy23;
        this.f4398x = lazy24;
        this.f4399y = lazy25;
        this.f4400z = lazy26;
        this.f4369A = lazy27;
        this.f4370B = lazy28;
        this.f4371C = lazy29;
        this.f4372D = lazy30;
        this.f4373E = lazy31;
        this.f4374F = lazy32;
    }
}
