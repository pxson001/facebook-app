package com.facebook.platform.auth.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.service.FbService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.platform.auth.server.ExtendAccessTokenMethod$Params;
import com.facebook.platform.auth.server.ExtendAccessTokenMethod$Result;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tttutrtewazobbbuizmemmmumpfuffenrtrurfjocopevappkahoamasnknd */
public class ExtendAccessTokenService extends FbService {
    private static final Class<?> f1145b = ExtendAccessTokenService.class;
    final Messenger f1146a = new Messenger(new ServiceHandler(this));
    public DefaultBlueServiceOperationFactory f1147c;
    public Provider<ViewerContext> f1148d;
    public ExecutorService f1149e;

    /* compiled from: tttutrtewazobbbuizmemmmumpfuffenrtrurfjocopevappkahoamasnknd */
    public class C12641 extends OperationResultFutureCallback {
        final /* synthetic */ Message f8467a;
        final /* synthetic */ ExtendAccessTokenService f8468b;

        public C12641(ExtendAccessTokenService extendAccessTokenService, Message message) {
            this.f8468b = extendAccessTokenService;
            this.f8467a = message;
        }

        protected final void m8378a(Object obj) {
            ExtendAccessTokenMethod$Result extendAccessTokenMethod$Result = (ExtendAccessTokenMethod$Result) ((OperationResult) obj).h();
            Bundle bundle = new Bundle();
            bundle.putString("access_token", extendAccessTokenMethod$Result.f8465a);
            bundle.putLong("expires_in", extendAccessTokenMethod$Result.f8466b);
            ExtendAccessTokenService extendAccessTokenService = this.f8468b;
            ExtendAccessTokenService.m1172a(this.f8467a, bundle);
        }

        protected final void m8377a(ServiceException serviceException) {
            if (serviceException == null || serviceException.result == null) {
                ExtendAccessTokenService.m1173a(this.f8468b, this.f8467a, "unexpected response");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("error", serviceException.result.f);
            ExtendAccessTokenService extendAccessTokenService = this.f8468b;
            ExtendAccessTokenService.m1172a(this.f8467a, bundle);
        }
    }

    /* compiled from: tttutrtewazobbbuizmemmmumpfuffenrtrurfjocopevappkahoamasnknd */
    class ServiceHandler extends Handler {
        WeakReference<ExtendAccessTokenService> f8469a;

        ServiceHandler(ExtendAccessTokenService extendAccessTokenService) {
            this.f8469a = new WeakReference(extendAccessTokenService);
        }

        public void handleMessage(Message message) {
            ExtendAccessTokenService extendAccessTokenService = (ExtendAccessTokenService) this.f8469a.get();
            if (extendAccessTokenService != null) {
                String string = message.getData().getString("access_token");
                if (string == null) {
                    ExtendAccessTokenService.m1173a(extendAccessTokenService, message, "access_token parameter not found.");
                    return;
                }
                ViewerContext viewerContext = (ViewerContext) extendAccessTokenService.f1148d.get();
                if (viewerContext == null || viewerContext.mAuthToken == null) {
                    ExtendAccessTokenService.m1173a(extendAccessTokenService, message, "no logged in user");
                    return;
                }
                Parcelable extendAccessTokenMethod$Params = new ExtendAccessTokenMethod$Params(string, viewerContext.mAuthToken);
                Bundle bundle = new Bundle();
                bundle.putParcelable("access_token", extendAccessTokenMethod$Params);
                Futures.a(BlueServiceOperationFactoryDetour.a(extendAccessTokenService.f1147c, "platform_extend_access_token", bundle, 1757304498).a(), new C12641(extendAccessTokenService, Message.obtain(message)), extendAccessTokenService.f1149e);
            }
        }
    }

    public static void m1174a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ExtendAccessTokenService) obj).m1176a(DefaultBlueServiceOperationFactory.b(fbInjector), IdBasedProvider.a(fbInjector, 372), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector));
    }

    @Inject
    public final void m1176a(BlueServiceOperationFactory blueServiceOperationFactory, Provider<ViewerContext> provider, ExecutorService executorService) {
        this.f1147c = blueServiceOperationFactory;
        this.f1148d = provider;
        this.f1149e = executorService;
    }

    public static void m1173a(ExtendAccessTokenService extendAccessTokenService, Message message, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("error", str);
        m1172a(message, bundle);
    }

    public static void m1172a(Message message, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.setData(bundle);
        try {
            message.replyTo.send(obtain);
        } catch (Throwable e) {
            BLog.b(f1145b, "sending reply failed", e);
        }
    }

    public void mo44a() {
        Class cls = ExtendAccessTokenService.class;
        m1174a((Object) this, (Context) this);
    }

    public IBinder onBind(Intent intent) {
        return this.f1146a.getBinder();
    }
}
