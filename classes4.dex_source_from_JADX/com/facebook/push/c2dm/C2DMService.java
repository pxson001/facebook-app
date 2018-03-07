package com.facebook.push.c2dm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.analytics.util.LoggerMapUtils;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecurePendingIntent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.PushSource;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.analytics.PushServerRegistrationClientEvent;
import com.facebook.push.analytics.PushServerUnregistrationClientEvent;
import com.facebook.push.fbpushdata.FbPushDataHandlerService;
import com.facebook.push.registration.ServiceType;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: impression_logging_threshold */
public class C2DMService extends FbIntentService {
    private static final Class<?> f10435a = C2DMService.class;
    private C2DMRegistrar f10436b;
    private FbSharedPreferences f10437c;
    private PushNotifAnalyticsLogger f10438d;
    private ReliabilityAnalyticsLogger f10439e;
    private C2DMPushPrefKeys f10440f;
    private Clock f10441g;
    private MonotonicClock f10442h;
    private FbNetworkManager f10443i;
    private Provider<Boolean> f10444j;
    private BaseFbBroadcastManager f10445k;
    private AppStateManager f10446l;

    public final void m10979a(android.content.Intent r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x000d in list [B:12:0x002c]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        if (r5 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r5.getAction();	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        if (r5 == 0) goto L_0x000d;
    L_0x000a:
        android.support.v4.content.WakefulBroadcastReceiver.a(r5);
    L_0x000d:
        return;
    L_0x000e:
        r0 = r5.getAction();	 Catch:{  }
        r1 = "com.google.android.c2dm.intent.REGISTRATION";	 Catch:{  }
        r1 = r0.equals(r1);	 Catch:{  }
        if (r1 == 0) goto L_0x0030;	 Catch:{  }
    L_0x001a:
        r1 = r4.f10438d;	 Catch:{  }
        r2 = com.facebook.push.registration.ServiceType.GCM;	 Catch:{  }
        r2 = r2.name();	 Catch:{  }
        r3 = "gcm_response";	 Catch:{  }
        r1.m10886b(r2, r3, r0);	 Catch:{  }
        r4.m10977b(r5);	 Catch:{  }
    L_0x002a:
        if (r5 == 0) goto L_0x000d;
    L_0x002c:
        android.support.v4.content.WakefulBroadcastReceiver.a(r5);
        goto L_0x000d;
    L_0x0030:
        r1 = "com.google.android.c2dm.intent.RECEIVE";	 Catch:{  }
        r1 = r0.equals(r1);	 Catch:{  }
        if (r1 == 0) goto L_0x0043;	 Catch:{  }
    L_0x0038:
        r4.m10978c(r5);	 Catch:{  }
        goto L_0x002a;
    L_0x003c:
        r0 = move-exception;
        if (r5 == 0) goto L_0x0042;
    L_0x003f:
        android.support.v4.content.WakefulBroadcastReceiver.a(r5);
    L_0x0042:
        throw r0;
    L_0x0043:
        r1 = "com.google.android.c2dm.intent.RETRY";	 Catch:{  }
        r1 = r0.equals(r1);	 Catch:{  }
        if (r1 == 0) goto L_0x002a;	 Catch:{  }
    L_0x004b:
        r1 = r4.f10438d;	 Catch:{  }
        r2 = com.facebook.push.registration.ServiceType.GCM;	 Catch:{  }
        r2 = r2.name();	 Catch:{  }
        r3 = "gcm_response";	 Catch:{  }
        r1.m10886b(r2, r3, r0);	 Catch:{  }
        r0 = r4.f10436b;	 Catch:{  }
        r0.mo799a();	 Catch:{  }
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.c2dm.C2DMService.a(android.content.Intent):void");
    }

    public C2DMService() {
        super("C2DMReceiver");
    }

    static void m10974a(Context context, Intent intent) {
        intent.setClass(context, C2DMService.class);
        if (WakefulBroadcastReceiver.a(context, intent) == null) {
            BLog.a(f10435a, "Failed to start service");
        }
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 108381720);
        super.onCreate();
        AppInitLockHelper.a(this);
        InjectorLike injectorLike = FbInjector.get(this);
        this.f10436b = C2DMRegistrar.m10954a(injectorLike);
        this.f10437c = (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike);
        this.f10439e = ReliabilityAnalyticsLogger.m12278a(injectorLike);
        this.f10438d = PushNotifAnalyticsLogger.m10876a(injectorLike);
        this.f10440f = C2DMPushPrefKeys.m10969a(injectorLike);
        this.f10441g = (Clock) SystemClockMethodAutoProvider.a(injectorLike);
        this.f10442h = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike);
        this.f10443i = FbNetworkManager.a(injectorLike);
        this.f10444j = IdBasedProvider.a(injectorLike, 4271);
        this.f10445k = (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(injectorLike);
        this.f10446l = AppStateManager.a(injectorLike);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 728944090, a);
    }

    private void m10977b(Intent intent) {
        boolean z;
        String stringExtra = intent.getStringExtra("registration_id");
        String stringExtra2 = intent.getStringExtra("error");
        String stringExtra3 = intent.getStringExtra("unregistered");
        C2DMRegistrar c2DMRegistrar = this.f10436b;
        if (stringExtra3 != null) {
            z = true;
        } else {
            z = false;
        }
        Boolean.valueOf(z);
        c2DMRegistrar.f10414h.m10910a();
        if (z) {
            c2DMRegistrar.f10414h.m10918h();
            c2DMRegistrar.f10411e.m10879a(PushServerUnregistrationClientEvent.SUCCESS.name(), c2DMRegistrar.f10414h.m10910a());
            return;
        }
        c2DMRegistrar.f10417k.m10939c();
        if (stringExtra2 != null) {
            BLog.b(C2DMRegistrar.f10406b, "Registration error " + stringExtra2);
            c2DMRegistrar.f10417k.m10936a(stringExtra2.toLowerCase(Locale.US), null);
            if ("SERVICE_NOT_AVAILABLE".equals(stringExtra2)) {
                c2DMRegistrar.f10417k.m10934a(SecurePendingIntent.m10163b(c2DMRegistrar.f10409c, 0, new Intent("com.google.android.c2dm.intent.RETRY"), 0));
                return;
            }
            c2DMRegistrar.f10414h.m10918h();
            return;
        }
        c2DMRegistrar.f10414h.m10911a(stringExtra, c2DMRegistrar.f10414h.m10913b());
        c2DMRegistrar.f10417k.m10936a(PushServerRegistrationClientEvent.SUCCESS.name(), null);
        c2DMRegistrar.f10413g.m10797a(ServiceType.GCM, c2DMRegistrar.f10408a);
    }

    private void m10978c(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if ("deleted_messages".equals(extras.getString("message_type"))) {
                m10975a(extras.getString("total_deleted"));
            } else if (StringUtil.a(extras.getString("notification"))) {
                Map hashMap = new HashMap();
                SharedPreferences sharedPreferences = getSharedPreferences("rti.mqtt.mqtt_config", 4);
                if (sharedPreferences.contains("mqtt/connect_state")) {
                    hashMap.put("ml_state", Long.toString(m10973a(sharedPreferences.getLong("mqtt/connect_state", 0))));
                }
                hashMap.put("net_state", Long.toString(this.f10443i.p));
                hashMap.put("app_launch", Long.toString(this.f10446l.c()));
                hashMap.put("is_update", Boolean.toString(this.f10446l.V));
                hashMap.put("is_istl", Boolean.toString(this.f10446l.U));
                this.f10439e.m12291a(hashMap);
                if (((Boolean) this.f10444j.get()).booleanValue()) {
                    this.f10445k.a(new Intent().setAction("com.facebook.rti.mqtt.intent.ACTION_WAKEUP"));
                }
            } else {
                m10976b();
                FbPushDataHandlerService.a(this, extras.getString("notification"), PushSource.C2DM);
            }
        }
    }

    private long m10973a(long j) {
        if (j > 0) {
            return this.f10442h.now() - j;
        }
        if (j < 0) {
            return -(this.f10442h.now() + j);
        }
        return j;
    }

    private void m10976b() {
        Editor edit = this.f10437c.edit();
        edit.a(this.f10440f.f10377f, this.f10441g.a());
        edit.commit();
    }

    private void m10975a(String str) {
        this.f10439e.m12290a("messaging_push_notif_" + PushSource.C2DM.toString(), "gcm_deleted_messages", LoggerMapUtils.m8802a("total_deleted", str), null, null, null);
    }
}
