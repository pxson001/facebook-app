package com.facebook.katana.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.base.service.FbService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.init.AppInitLock.Listener;
import com.facebook.inject.FbInjector;
import com.facebook.katana.service.AppSession.LoginStatus;
import com.facebook.katana.service.method.ServiceOperation;
import com.facebook.katana.service.method.ServiceOperationListener;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

@Deprecated
/* compiled from: top_level_call_button */
public class FacebookService extends FbService implements ServiceOperationListener {
    public static Map<String, ServiceOperation> f1182a = new HashMap();
    private final Map<String, ServiceOperation> f1183b = Collections.synchronizedMap(new HashMap());
    private Context f1184c;
    private ExecutorService f1185d;

    public final void m1208a() {
        super.a();
        this.f1184c = getApplicationContext();
        this.f1185d = (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(FbInjector.get(this));
    }

    public final int m1207a(Intent intent, int i, int i2) {
        int a = super.a(intent, i, i2);
        if (intent == null) {
            return a;
        }
        final Intent intent2 = (Intent) intent.clone();
        AppInitLock.a(FbInjector.get(this)).a(new Listener(this) {
            final /* synthetic */ FacebookService f1177b;

            public final void m1202a() {
                this.f1177b.m1204a(intent2);
            }
        });
        return a;
    }

    private void m1204a(Intent intent) {
        int intExtra = intent.getIntExtra("type", 0);
        AppSession a = AppSession.a(this.f1184c, true);
        if (a == null || a.d() != LoginStatus.STATUS_LOGGING_OUT || intExtra == 2) {
            ServiceOperation serviceOperation = null;
            switch (intExtra) {
                case 2:
                    final List a2 = Lists.a();
                    synchronized (this.f1183b) {
                        a2.addAll(this.f1183b.values());
                    }
                    this.f1183b.clear();
                    ExecutorDetour.a(this.f1185d, new Runnable(this) {
                        final /* synthetic */ FacebookService f1179b;

                        public void run() {
                            for (ServiceOperation a : a2) {
                                a.mo49a(false);
                            }
                        }
                    }, 518458175);
                    break;
                case 1001:
                    serviceOperation = (ServiceOperation) f1182a.remove(intent.getStringExtra("rid"));
                    if (serviceOperation != null) {
                        serviceOperation.m1211a(intent, this);
                        break;
                    }
                    break;
            }
            if (serviceOperation != null) {
                m1206a(intent.getStringExtra("rid"), serviceOperation);
            } else if (intExtra == 2000) {
                serviceOperation = (ServiceOperation) this.f1183b.remove(intent.getStringExtra("rid"));
                if (serviceOperation != null) {
                    ExecutorDetour.a(this.f1185d, new Runnable(this) {
                        final /* synthetic */ FacebookService f1181b;

                        public void run() {
                            serviceOperation.mo49a(true);
                        }
                    }, 286221078);
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public final void mo45a(ServiceOperation serviceOperation, int i, String str, @Nullable Exception exception) {
        Intent intent = serviceOperation.f1188i;
        this.f1183b.remove(intent.getStringExtra("rid"));
        switch (intent.getIntExtra("type", 0)) {
            case 1001:
                AppSession.a(this.f1184c, intent, i, str, exception, serviceOperation, null);
                return;
            default:
                AppSession.a(this.f1184c, intent, i, str, exception, null, null);
                return;
        }
    }

    private void m1206a(String str, ServiceOperation serviceOperation) {
        this.f1183b.put(str, serviceOperation);
        serviceOperation.mo46a();
    }
}
