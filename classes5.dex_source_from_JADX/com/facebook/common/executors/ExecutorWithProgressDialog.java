package com.facebook.common.executors;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: startServiceHackAction cannot be null for logout */
public class ExecutorWithProgressDialog {
    private final Context f2551a;
    private final ListeningExecutorService f2552b;
    private final Executor f2553c;

    private static ExecutorWithProgressDialog m3673b(InjectorLike injectorLike) {
        return new ExecutorWithProgressDialog((Context) injectorLike.getInstance(Context.class), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ExecutorWithProgressDialog(Context context, ListeningExecutorService listeningExecutorService, Executor executor) {
        this.f2551a = context;
        this.f2552b = listeningExecutorService;
        this.f2553c = executor;
    }
}
