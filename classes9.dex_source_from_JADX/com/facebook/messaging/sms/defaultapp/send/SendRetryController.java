package com.facebook.messaging.sms.defaultapp.send;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.GlobalFbBroadcastManager;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.sms.common.Constants.MmsSmsErrorType;
import com.facebook.messaging.sms.defaultapp.SmsReceiver;
import com.facebook.messaging.sms.util.TelephonyUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.EnumSet;
import javax.inject.Inject;

@UserScoped
/* compiled from: com.facebook.orca.extra.EXTERNAL_URI */
public class SendRetryController {
    private static final EnumSet<MmsSmsErrorType> f17710a = EnumSet.of(MmsSmsErrorType.CONNECTION_ERROR, MmsSmsErrorType.SERVER_ERROR, MmsSmsErrorType.IO_ERROR, MmsSmsErrorType.STICKER_FAIL, MmsSmsErrorType.GENERIC);
    private static final Object f17711h = new Object();
    public final Context f17712b;
    private final BaseFbBroadcastManager f17713c;
    private final Handler f17714d;
    private final MmsSmsPendingSendQueue f17715e;
    public SelfRegistrableReceiverImpl f17716f;
    private final Runnable f17717g = new C20911(this);

    /* compiled from: com.facebook.orca.extra.EXTERNAL_URI */
    class C20911 implements Runnable {
        final /* synthetic */ SendRetryController f17708a;

        C20911(SendRetryController sendRetryController) {
            this.f17708a = sendRetryController;
        }

        public void run() {
            SendRetryController sendRetryController = this.f17708a;
            if (!TelephonyUtils.m17719d(sendRetryController.f17712b)) {
                sendRetryController.f17716f.c();
                sendRetryController.f17712b.sendBroadcast(new Intent("com.facebook.messaging.sms.REQUEST_SEND_MESSAGE", null, sendRetryController.f17712b, SmsReceiver.class));
            }
        }
    }

    /* compiled from: com.facebook.orca.extra.EXTERNAL_URI */
    class C20922 implements ActionReceiver {
        final /* synthetic */ SendRetryController f17709a;

        C20922(SendRetryController sendRetryController) {
            this.f17709a = sendRetryController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 912756544);
            SendRetryController.m17673c(this.f17709a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1523871200, a);
        }
    }

    private static SendRetryController m17671b(InjectorLike injectorLike) {
        return new SendRetryController((Context) injectorLike.getInstance(Context.class), (BaseFbBroadcastManager) GlobalFbBroadcastManager.a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), MmsSmsPendingSendQueue.m17644a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sms.defaultapp.send.SendRetryController m17669a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f17711h;	 Catch:{ all -> 0x006c }
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
        r1 = m17671b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17711h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.defaultapp.send.SendRetryController) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sms.defaultapp.send.SendRetryController) r0;	 Catch:{  }
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
        r0 = f17711h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.defaultapp.send.SendRetryController) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.defaultapp.send.SendRetryController.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.defaultapp.send.SendRetryController");
    }

    @Inject
    public SendRetryController(Context context, BaseFbBroadcastManager baseFbBroadcastManager, Handler handler, MmsSmsPendingSendQueue mmsSmsPendingSendQueue) {
        this.f17712b = context;
        this.f17713c = baseFbBroadcastManager;
        this.f17714d = handler;
        this.f17715e = mmsSmsPendingSendQueue;
    }

    public static boolean m17670a(MmsSmsErrorType mmsSmsErrorType, PendingSendMessage pendingSendMessage) {
        return f17710a.contains(mmsSmsErrorType) && pendingSendMessage.f17706d <= 0;
    }

    public final void m17674a(PendingSendMessage pendingSendMessage) {
        this.f17715e.m17651a(pendingSendMessage);
    }

    public final synchronized boolean m17675a() {
        boolean z;
        m17672b();
        if (TelephonyUtils.m17719d(this.f17712b)) {
            if (!this.f17716f.a()) {
                this.f17716f.b();
                m17673c(this);
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private synchronized void m17672b() {
        if (this.f17716f == null) {
            this.f17716f = this.f17713c.a().a("android.intent.action.AIRPLANE_MODE", new C20922(this)).a();
        }
    }

    public static void m17673c(SendRetryController sendRetryController) {
        HandlerDetour.a(sendRetryController.f17714d, sendRetryController.f17717g);
        HandlerDetour.b(sendRetryController.f17714d, sendRetryController.f17717g, 5000, -2020568405);
    }
}
