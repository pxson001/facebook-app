package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.orca.threadview.ThreadViewThreadKeyLoader.C12071;
import com.facebook.orca.threadview.ThreadViewThreadKeyLoader.C12082;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;

/* compiled from: methodArgs */
public class LegacyThreadViewActivityOpener extends FbFragmentActivity {
    public ThreadViewThreadKeyLoader f7014p;
    public SecureContextHelper f7015q;
    public AbstractFbErrorReporter f7016r;
    public Executor f7017s;

    private static <T extends Context> void m6588a(Class<T> cls, T t) {
        m6589a((Object) t, (Context) t);
    }

    public static void m6589a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        LegacyThreadViewActivityOpener legacyThreadViewActivityOpener = (LegacyThreadViewActivityOpener) obj;
        ThreadViewThreadKeyLoader threadViewThreadKeyLoader = new ThreadViewThreadKeyLoader(DataCache.a(fbInjector), DefaultBlueServiceOperationFactory.b(fbInjector), DefaultThreadKeyFactory.b(fbInjector), MessagingPerformanceLogger.a(fbInjector));
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        legacyThreadViewActivityOpener.f7014p = threadViewThreadKeyLoader;
        legacyThreadViewActivityOpener.f7015q = secureContextHelper;
        legacyThreadViewActivityOpener.f7016r = abstractFbErrorReporter;
        legacyThreadViewActivityOpener.f7017s = executor;
    }

    protected final void m6592a(Bundle bundle) {
        Class cls = LegacyThreadViewActivityOpener.class;
        m6589a((Object) this, (Context) this);
    }

    public final void m6593b(Bundle bundle) {
        super.b(bundle);
        m6590b(getIntent());
    }

    protected final void m6591a(Intent intent) {
        super.a(intent);
        m6590b(intent);
    }

    private void m6590b(final Intent intent) {
        Preconditions.checkArgument(intent.hasExtra("thread_id"));
        final String stringExtra = intent.getStringExtra("thread_id");
        ThreadViewThreadKeyLoader threadViewThreadKeyLoader = this.f7014p;
        int nextInt = threadViewThreadKeyLoader.f7980f.nextInt();
        threadViewThreadKeyLoader.f7979e.b(nextInt, "ThreadViewThreadKeyLoader");
        Bundle bundle = new Bundle();
        FetchThreadParamsBuilder fetchThreadParamsBuilder = new FetchThreadParamsBuilder();
        fetchThreadParamsBuilder.a = ThreadCriteria.a(stringExtra);
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.f = 0;
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.b = DataFreshnessParam.STALE_DATA_OKAY;
        bundle.putParcelable("fetchThreadParams", fetchThreadParamsBuilder.i());
        bundle.putInt("logger_instance_key", nextInt);
        OperationFuture a = BlueServiceOperationFactoryDetour.a(threadViewThreadKeyLoader.f7977c, "fetch_thread", bundle, CallerContext.a(ThreadViewThreadKeyLoader.class), -614139610).a();
        Futures.a(a, new C12071(threadViewThreadKeyLoader, nextInt));
        Futures.a(Futures.a(a, new C12082(threadViewThreadKeyLoader, stringExtra)), new FutureCallback<ThreadKey>(this) {
            final /* synthetic */ LegacyThreadViewActivityOpener f7013c;

            public void onSuccess(Object obj) {
                ThreadKey threadKey = (ThreadKey) obj;
                if (threadKey != null) {
                    this.f7013c.m6586a(intent, threadKey);
                } else {
                    this.f7013c.f7016r.a("LegacyThreadViewActivityOpener", "Null thread key for id " + stringExtra);
                }
                this.f7013c.finish();
            }

            public void onFailure(Throwable th) {
                this.f7013c.f7016r.a("LegacyThreadViewActivityOpener", "Failure getting thread key for id " + stringExtra);
                this.f7013c.finish();
            }
        }, this.f7017s);
    }

    private void m6586a(Intent intent, ThreadKey threadKey) {
        Intent a = ThreadViewActivity.m7086a((Context) this, threadKey);
        if (intent.getExtras() != null) {
            a.putExtras(intent.getExtras());
        }
        this.f7015q.a(a, this);
    }
}
