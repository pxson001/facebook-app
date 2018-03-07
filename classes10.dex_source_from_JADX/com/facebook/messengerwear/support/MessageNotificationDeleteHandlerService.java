package com.facebook.messengerwear.support;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.facebook.base.service.FbService;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.messengerwear.shared.GoogleApiSharedHelper;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: photo_save_temp_thread_view */
public class MessageNotificationDeleteHandlerService extends FbService {
    public static final Class f4982a = MessageNotificationDeleteHandlerService.class;
    @Inject
    public WearableGoogleApiClientFactory f4983b;
    @BackgroundExecutorService
    @Inject
    private ExecutorService f4984c;

    private static <T extends Context> void m4518a(Class<T> cls, T t) {
        m4519a((Object) t, (Context) t);
    }

    public static void m4519a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MessageNotificationDeleteHandlerService) obj).m4517a(WearableGoogleApiClientFactory.m4583a(fbInjector), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(fbInjector));
    }

    private void m4517a(WearableGoogleApiClientFactory wearableGoogleApiClientFactory, ExecutorService executorService) {
        this.f4983b = wearableGoogleApiClientFactory;
        this.f4984c = executorService;
    }

    protected final void m4522a() {
        super.a();
        Class cls = MessageNotificationDeleteHandlerService.class;
        m4519a((Object) this, (Context) this);
    }

    protected final int m4521a(Intent intent, int i, final int i2) {
        final String stringExtra = intent.getStringExtra("thread_key");
        ExecutorDetour.a(this.f4984c, new Runnable(this) {
            final /* synthetic */ MessageNotificationDeleteHandlerService f4981c;

            public void run() {
                try {
                    GoogleApiSharedHelper.m4484a(this.f4981c.f4983b.m4585a(), stringExtra);
                } catch (Throwable e) {
                    BLog.b(MessageNotificationDeleteHandlerService.f4982a, "Exception while encrypting data.", e);
                }
                this.f4981c.stopSelf(i2);
            }
        }, -1801016673);
        return 1;
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }
}
