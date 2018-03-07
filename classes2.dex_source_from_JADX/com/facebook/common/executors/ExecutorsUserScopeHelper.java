package com.facebook.common.executors;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

/* compiled from: voip_enable_video */
public class ExecutorsUserScopeHelper {

    /* compiled from: voip_enable_video */
    final class C00565 extends WrappingConstrainedListeningExecutorService {
        final /* synthetic */ Provider f960a;

        C00565(ConstrainedListeningExecutorService constrainedListeningExecutorService, Provider provider) {
            this.f960a = provider;
            super(constrainedListeningExecutorService);
        }

        protected final <T> Callable<T> a_(Callable<T> callable) {
            return ExecutorsUserScopeHelper.m1941b(callable, this.f960a);
        }
    }

    /* compiled from: voip_enable_video */
    final class C00573 extends WrappingListeningScheduledExecutorService {
        final /* synthetic */ Provider f967a;

        C00573(ListeningScheduledExecutorService listeningScheduledExecutorService, Provider provider) {
            this.f967a = provider;
            super(listeningScheduledExecutorService);
        }

        protected final <T> Callable<T> a_(Callable<T> callable) {
            return ExecutorsUserScopeHelper.m1941b(callable, this.f967a);
        }
    }

    /* compiled from: voip_enable_video */
    final class C00622 extends WrappingScheduledExecutorService {
        final /* synthetic */ Provider f1034a;

        C00622(ScheduledExecutorService scheduledExecutorService, Provider provider) {
            this.f1034a = provider;
            super(scheduledExecutorService);
        }

        protected final <T> Callable<T> a_(Callable<T> callable) {
            return ExecutorsUserScopeHelper.m1941b(callable, this.f1034a);
        }
    }

    /* compiled from: voip_enable_video */
    public final class C04514 extends WrappingPrioritizedExecutorService {
        final /* synthetic */ Provider f10617a;

        public C04514(PrioritizedExecutorService prioritizedExecutorService, Provider provider) {
            this.f10617a = provider;
            super(prioritizedExecutorService);
        }

        protected final <T> Callable<T> a_(Callable<T> callable) {
            return ExecutorsUserScopeHelper.m1941b(callable, this.f10617a);
        }
    }

    ExecutorsUserScopeHelper() {
    }

    static ScheduledExecutorService m1940a(Provider<ViewerContextManager> provider, ScheduledExecutorService scheduledExecutorService) {
        return new C00622(scheduledExecutorService, provider);
    }

    static ListeningScheduledExecutorService m1939a(Provider<ViewerContextManager> provider, ListeningScheduledExecutorService listeningScheduledExecutorService) {
        return new C00573(listeningScheduledExecutorService, provider);
    }

    public static ConstrainedListeningExecutorService m1938a(Provider<ViewerContextManager> provider, ConstrainedListeningExecutorService constrainedListeningExecutorService) {
        return new C00565(constrainedListeningExecutorService, provider);
    }

    public static <T> Callable<T> m1941b(Callable<T> callable, Provider<ViewerContextManager> provider) {
        ViewerContextManager viewerContextManager = (ViewerContextManager) provider.get();
        ViewerContext e = viewerContextManager.mo218e();
        return e == null ? callable : new 6(callable, viewerContextManager, e);
    }
}
