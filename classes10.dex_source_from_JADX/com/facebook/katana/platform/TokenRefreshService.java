package com.facebook.katana.platform;

import android.content.Context;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.platform.auth.service.ExtendAccessTokenService;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tttrmbmmmyrtrurfddduwhiv5152nknaneudedxc131514jhje61oookogobotacadtugafgfhflfoyj7179ufgfzi38378281cuvb4241ta */
public class TokenRefreshService extends ExtendAccessTokenService {
    private static <T extends Context> void m1177a(Class<T> cls, T t) {
        m1178a((Object) t, (Context) t);
    }

    public static void m1178a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TokenRefreshService) obj).m1179b(DefaultBlueServiceOperationFactory.b(fbInjector), IdBasedProvider.a(fbInjector, 372), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector));
    }

    @Inject
    private void m1179b(BlueServiceOperationFactory blueServiceOperationFactory, Provider<ViewerContext> provider, ExecutorService executorService) {
        super.m1176a((DefaultBlueServiceOperationFactory) blueServiceOperationFactory, (Provider) provider, executorService);
    }

    public final void mo44a() {
        Class cls = TokenRefreshService.class;
        m1178a((Object) this, (Context) this);
    }
}
