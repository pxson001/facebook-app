package com.facebook.messengerwear.support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.userscope.UserScopedCrossProcessBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.messaging.notify.MessagesNotificationIntents;
import com.facebook.messengerwear.shared.MessengerWearConstants.WearDataApiPath;
import com.facebook.messengerwear.shared.MessengerWearCrypto;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Inject;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;

@SuppressLint({"BadMethodUse-java.io.ObjectInputStream.readObject"})
/* compiled from: photo_checkup */
public class WearNotificationListenerService extends WearableListenerService {
    private static final Class f5098a = WearNotificationListenerService.class;
    @Inject
    private Provider<UserScopedCrossProcessBroadcastManager> f5099b;
    @Inject
    private Lazy<FbErrorReporter> f5100c;
    @BackgroundExecutorService
    @Inject
    private ExecutorService f5101d;
    @Inject
    public WearableGoogleApiClientFactory f5102e;
    @Inject
    private AnalyticsLogger f5103f;

    private static <T extends Context> void m4577a(Class<T> cls, T t) {
        m4578a((Object) t, (Context) t);
    }

    public static void m4578a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((WearNotificationListenerService) obj).m4580a(IdBasedProvider.a(fbInjector, 4971), IdBasedSingletonScopeProvider.b(fbInjector, 494), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(fbInjector), WearableGoogleApiClientFactory.m4583a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector));
    }

    private void m4580a(Provider<UserScopedCrossProcessBroadcastManager> provider, Lazy<FbErrorReporter> lazy, ExecutorService executorService, WearableGoogleApiClientFactory wearableGoogleApiClientFactory, AnalyticsLogger analyticsLogger) {
        this.f5099b = provider;
        this.f5100c = lazy;
        this.f5101d = executorService;
        this.f5102e = wearableGoogleApiClientFactory;
        this.f5103f = analyticsLogger;
    }

    public final void mo134a(DataEventBuffer dataEventBuffer) {
        super.mo134a(dataEventBuffer);
        Class cls = WearNotificationListenerService.class;
        m4578a((Object) this, (Context) this);
        final ArrayList arrayList = new ArrayList();
        Iterator it = dataEventBuffer.iterator();
        while (it.hasNext()) {
            DataEvent dataEvent = (DataEvent) it.next();
            DataItem b = ((DataEvent) dataEvent.a()).mo676b();
            String path = b.mo578b().getPath();
            switch (dataEvent.mo677c()) {
                case 1:
                    if (!path.startsWith("/reporting")) {
                        if (!path.startsWith("/analytics")) {
                            break;
                        }
                        m4581b(b);
                        arrayList.add(b.mo578b());
                        break;
                    }
                    m4576a(b);
                    arrayList.add(b.mo578b());
                    break;
                case 2:
                    if (!path.startsWith("/threads/")) {
                        break;
                    }
                    m4579a(path);
                    break;
                default:
                    break;
            }
        }
        ExecutorDetour.a(this.f5101d, new Runnable(this) {
            final /* synthetic */ WearNotificationListenerService f5097b;

            public void run() {
                GoogleApiClient a = this.f5097b.f5102e.m4585a();
                List<Uri> list = arrayList;
                if (a.a(3000, TimeUnit.MILLISECONDS).b()) {
                    int i = 1;
                    for (Uri b : list) {
                        i = ((DeleteDataItemsResult) Wearable.f13157a.mo675b(a, b).a(3000, TimeUnit.MILLISECONDS)).cp_().e() & i;
                    }
                    a.e();
                }
            }
        }, -251416611);
    }

    private void m4579a(String str) {
        try {
            String b = MessengerWearCrypto.m4506b(WearDataApiPath.m4498c(str));
            Intent intent = new Intent(MessagesNotificationIntents.k);
            intent.putExtra("thread_key_string", b);
            ((UserScopedCrossProcessBroadcastManager) this.f5099b.get()).a(intent, this);
        } catch (Throwable e) {
            BLog.b(f5098a, "Failed to decrypt threadKey", e);
        }
    }

    private void m4576a(DataItem dataItem) {
        Throwable th;
        DataMap a = DataMapItem.m13270a(dataItem).m13272a();
        try {
            th = (Throwable) m4575a(a.m13269g("cause"));
        } catch (Exception e) {
            th = null;
        }
        ((AbstractFbErrorReporter) this.f5100c.get()).a(a.m13266d("category"), a.m13266d("message"), th);
    }

    private void m4581b(DataItem dataItem) {
        DataMap dataMap = DataMapItem.m13270a(dataItem).f13147b;
        String d = dataMap.m13266d("event");
        if (d == null || d.isEmpty()) {
            throw new IllegalArgumentException("Analytic event expected.");
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(d);
        if (dataMap.f13145a.containsKey("params")) {
            Bundle a = dataMap.m13268f("params").m13254a();
            for (String str : a.keySet()) {
                honeyClientEvent.a(str, a.get(str));
            }
        }
        this.f5103f.a(honeyClientEvent);
    }

    private static Object m4575a(byte[] bArr) {
        return new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
    }
}
