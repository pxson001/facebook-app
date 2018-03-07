package com.facebook.auth.login;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: transient_token */
public class KindleSsoUtil {
    private final Executor f745a;
    public final Executor f746b;
    public final FbAppType f747c;
    public final Context f748d;
    public SettableFuture<String> f749e = null;
    public IBinder f750f = null;
    private FutureCallback<String> f751g = new 1(this);
    public ServiceConnection f752h = new 2(this);
    public Runnable f753i = new 3(this);

    public static KindleSsoUtil m1105b(InjectorLike injectorLike) {
        return new KindleSsoUtil((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public KindleSsoUtil(Executor executor, ExecutorService executorService, FbAppType fbAppType, Context context) {
        this.f745a = executor;
        this.f746b = executorService;
        this.f747c = fbAppType;
        this.f748d = context;
    }

    public final synchronized ListenableFuture<String> m1106a() {
        ListenableFuture<String> f;
        if (this.f749e == null) {
            f = SettableFuture.f();
            this.f749e = f;
            Futures.a(this.f749e, this.f751g, this.f745a);
            Intent intent = new Intent();
            intent.setClassName("com.amazon.identity.snds", "com.amazon.identity.snds.fb.FacebookSSOService");
            if (!ServiceConnectionDetour.a(this.f748d, intent, this.f752h, 1, 1507860142)) {
                this.f749e.a(new Exception("Could not connect to FacebookSSOService"));
            }
        } else {
            f = this.f749e;
        }
        return f;
    }
}
