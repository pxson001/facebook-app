package com.facebook.messaging.sms.defaultapp;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: com.facebook.rtc.fbwebrtc.RTC_VIDEO_CHAT_HEAD_SHRINK_BY_USER_INTERACTION */
public class SmsActionReceiver implements ActionReceiver {
    private static final Object f17573f = new Object();
    private static WakeLock f17574g;
    private static final long f17575h = TimeUnit.SECONDS.toMillis(90);
    @Inject
    SecureContextHelper f17576a;
    @Inject
    SmsIntegrationState f17577b;
    @Inject
    FbWakeLockManager f17578c;
    @Inject
    SmsPermissionsUtil f17579d;
    @Inject
    MmsSmsPendingSendQueue f17580e;

    public static void m17569a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SmsActionReceiver) obj).m17568a((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SmsIntegrationState.a(injectorLike), FbWakeLockManager.a(injectorLike), SmsPermissionsUtil.m17591a(injectorLike), MmsSmsPendingSendQueue.m17644a(injectorLike));
    }

    private void m17568a(SecureContextHelper secureContextHelper, SmsIntegrationState smsIntegrationState, FbWakeLockManager fbWakeLockManager, SmsPermissionsUtil smsPermissionsUtil, MmsSmsPendingSendQueue mmsSmsPendingSendQueue) {
        this.f17576a = secureContextHelper;
        this.f17577b = smsIntegrationState;
        this.f17578c = fbWakeLockManager;
        this.f17579d = smsPermissionsUtil;
        this.f17580e = mmsSmsPendingSendQueue;
    }

    @TargetApi(19)
    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 279246905);
        Class cls = SmsActionReceiver.class;
        m17569a((Object) this, context);
        Object obj = null;
        String action = intent.getAction();
        Object obj2 = -1;
        switch (action.hashCode()) {
            case -1838488750:
                if (action.equals("com.facebook.messaging.sms.COMPOSE_SMS")) {
                    obj2 = null;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                break;
            default:
                obj = 1;
                break;
        }
        if (obj != null && !this.f17577b.d()) {
            this.f17580e.m17650a();
        } else if (this.f17579d.m17594b()) {
            intent.setClass(context, SmsHandlerService.class);
            intent.putExtra("result_code", broadcastReceiverLike.getResultCode());
            m17567a(context, intent);
        } else {
            this.f17579d.m17593a();
        }
        LogUtils.e(536653541, a);
    }

    private void m17567a(Context context, Intent intent) {
        synchronized (f17573f) {
            if (f17574g == null) {
                WakeLock a = this.f17578c.a(1, "startSmsHandling");
                f17574g = a;
                a.a(false);
            }
            f17574g.a(f17575h);
            this.f17576a.c(intent, context);
        }
    }

    public static void m17566a(Service service, int i) {
        synchronized (f17573f) {
            if (f17574g != null && service.stopSelfResult(i)) {
                f17574g.d();
            }
        }
    }
}
