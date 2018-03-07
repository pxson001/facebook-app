package com.facebook.orca.threadview;

import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.google.common.base.Function;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: media_prefetch */
public class ThreadViewThreadKeyLoader {
    public static final Class<?> f7975a = ThreadViewThreadKeyLoader.class;
    private final DataCache f7976b;
    public final DefaultBlueServiceOperationFactory f7977c;
    private final DefaultThreadKeyFactory f7978d;
    public final MessagingPerformanceLogger f7979e;
    public final Random f7980f = new Random();

    /* compiled from: media_prefetch */
    public class C12071 extends OperationResultFutureCallback {
        final /* synthetic */ int f7971a;
        final /* synthetic */ ThreadViewThreadKeyLoader f7972b;

        public C12071(ThreadViewThreadKeyLoader threadViewThreadKeyLoader, int i) {
            this.f7972b = threadViewThreadKeyLoader;
            this.f7971a = i;
        }

        protected final void m7901a(ServiceException serviceException) {
            this.f7972b.f7979e.n(this.f7971a);
        }

        protected final void m7902a(Object obj) {
            this.f7972b.f7979e.o(this.f7971a);
        }
    }

    /* compiled from: media_prefetch */
    public class C12082 implements Function<OperationResult, ThreadKey> {
        final /* synthetic */ String f7973a;
        final /* synthetic */ ThreadViewThreadKeyLoader f7974b;

        public C12082(ThreadViewThreadKeyLoader threadViewThreadKeyLoader, String str) {
            this.f7974b = threadViewThreadKeyLoader;
            this.f7973a = str;
        }

        public Object apply(Object obj) {
            FetchThreadResult fetchThreadResult = (FetchThreadResult) ((OperationResult) obj).k();
            if (fetchThreadResult != null && fetchThreadResult.c != null) {
                return fetchThreadResult.c.a;
            }
            BLog.a(ThreadViewThreadKeyLoader.f7975a, "Could not find thread: legacyThreadId = %s", new Object[]{this.f7973a});
            return null;
        }
    }

    @Inject
    public ThreadViewThreadKeyLoader(DataCache dataCache, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, DefaultThreadKeyFactory defaultThreadKeyFactory, MessagingPerformanceLogger messagingPerformanceLogger) {
        this.f7976b = dataCache;
        this.f7977c = defaultBlueServiceOperationFactory;
        this.f7978d = defaultThreadKeyFactory;
        this.f7979e = messagingPerformanceLogger;
    }
}
