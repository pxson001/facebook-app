package com.facebook.reaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.common.ReactionUnitIndexMap;
import com.facebook.reaction.event.ReactionEvent;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidCacheResponseEvent;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidResponseEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionCacheResultEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionEmptyRequestEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionRequestEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionResultEvent;
import com.facebook.reaction.event.ReactionFetchEvents.RequestNonCancellationFailureEvent;
import com.facebook.reaction.externalshare.ReactionExternalShareService;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.MethodNotSupportedException;

@Singleton
/* compiled from: cached */
public class ReactionSessionManager {
    private static volatile ReactionSessionManager f18695r;
    private final Map<String, ReactionSession> f18696a = Maps.c();
    private final Clock f18697b;
    public final BaseFbBroadcastManager f18698c;
    private final Lazy<FragmentFactoryMap> f18699d;
    public final PaginationReactionRequestTracker f18700e;
    public final PendingStoryStore f18701f;
    public final PrefetchReactionRequestTracker f18702g;
    private final PublishUpdateHandler f18703h;
    private final QuickPerformanceLogger f18704i;
    private final ReactionAnalyticsLogger f18705j;
    private final ReactionRequestTracker f18706k;
    private final ReactionUnitIndexMap f18707l;
    private final SecureContextHelper f18708m;
    private final SelfRegistrableReceiverImpl f18709n;
    private final UriIntentMapper f18710o;
    public final Lazy<FbErrorReporter> f18711p;
    private WeakReference<FbFragment> f18712q = null;

    /* compiled from: cached */
    interface InternalTrackerCallback {
        void mo1105a(ReactionSession reactionSession);

        void mo1106a(ReactionSession reactionSession, InvalidCacheResponseEvent invalidCacheResponseEvent);

        void mo1107a(ReactionSession reactionSession, InvalidResponseEvent invalidResponseEvent);

        void mo1108a(ReactionSession reactionSession, ReactionCacheResultEvent reactionCacheResultEvent);

        void mo1109a(ReactionSession reactionSession, ReactionRequestEvent reactionRequestEvent);

        void mo1110a(ReactionSession reactionSession, ReactionResultEvent reactionResultEvent);

        void mo1111a(ReactionSession reactionSession, RequestNonCancellationFailureEvent requestNonCancellationFailureEvent);
    }

    /* compiled from: cached */
    public class PublishUpdateHandler implements ActionReceiver {
        public final /* synthetic */ ReactionSessionManager f18692a;
        public final Map<String, String> f18693b = new HashMap();

        public PublishUpdateHandler(ReactionSessionManager reactionSessionManager) {
            this.f18692a = reactionSessionManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -765080287);
            String stringExtra = intent.getStringExtra("extra_request_id");
            Optional d = this.f18692a.f18701f.d(stringExtra);
            ReactionSession b = this.f18692a.m22614b(stringExtra);
            if (b != null) {
                b.m22555a(intent);
                stringExtra = intent.getAction();
                if (b.m22573u() != null) {
                    b.m22573u().mo727a(stringExtra, d);
                } else {
                    b.f18671n = stringExtra;
                }
            } else {
                ReactionSession b2 = this.f18692a.m22614b((String) this.f18693b.get(stringExtra));
                if (b2 != null) {
                    b2.m22555a(intent);
                    if (b2.m22573u() != null) {
                        b2.m22573u().mo727a(intent.getAction(), d);
                    }
                }
            }
            LogUtils.e(1081082668, a);
        }
    }

    /* compiled from: cached */
    public class ReactionRequestTrackerCallback {
        final /* synthetic */ ReactionSessionManager f18694a;

        public ReactionRequestTrackerCallback(ReactionSessionManager reactionSessionManager) {
            this.f18694a = reactionSessionManager;
        }

        public final void m22588a(ReactionEvent reactionEvent) {
            ReactionSession a = ReactionSessionManager.m22589a(this.f18694a, reactionEvent);
            if (a != null) {
                InternalTrackerCallback internalTrackerCallback = a.m22548C() ? this.f18694a.f18700e : this.f18694a.f18702g;
                if (reactionEvent instanceof InvalidResponseEvent) {
                    internalTrackerCallback.mo1107a(a, (InvalidResponseEvent) reactionEvent);
                } else if (reactionEvent instanceof ReactionEmptyRequestEvent) {
                    internalTrackerCallback.mo1105a(a);
                } else if (reactionEvent instanceof ReactionResultEvent) {
                    internalTrackerCallback.mo1110a(a, (ReactionResultEvent) reactionEvent);
                } else if (reactionEvent instanceof InvalidCacheResponseEvent) {
                    try {
                        internalTrackerCallback.mo1106a(a, (InvalidCacheResponseEvent) reactionEvent);
                    } catch (MethodNotSupportedException e) {
                        ((AbstractFbErrorReporter) this.f18694a.f18711p.get()).b(ReactionSessionManager.class.getSimpleName(), "onInvalidCacheResponseEvent method is not supported by the callback:\n" + e.getMessage());
                    }
                } else if (reactionEvent instanceof ReactionCacheResultEvent) {
                    try {
                        internalTrackerCallback.mo1108a(a, (ReactionCacheResultEvent) reactionEvent);
                    } catch (MethodNotSupportedException e2) {
                        ((AbstractFbErrorReporter) this.f18694a.f18711p.get()).b(ReactionSessionManager.class.getSimpleName(), "onReactionCacheResultEvent method is not supported by the callback:\n" + e2.getMessage());
                    }
                } else if (reactionEvent instanceof ReactionRequestEvent) {
                    internalTrackerCallback.mo1109a(a, (ReactionRequestEvent) reactionEvent);
                } else if (reactionEvent instanceof RequestNonCancellationFailureEvent) {
                    internalTrackerCallback.mo1111a(a, (RequestNonCancellationFailureEvent) reactionEvent);
                }
            }
        }
    }

    public static com.facebook.reaction.ReactionSessionManager m22590a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f18695r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.ReactionSessionManager.class;
        monitor-enter(r1);
        r0 = f18695r;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22597b(r0);	 Catch:{ all -> 0x0035 }
        f18695r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18695r;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.ReactionSessionManager.a(com.facebook.inject.InjectorLike):com.facebook.reaction.ReactionSessionManager");
    }

    private static ReactionSessionManager m22597b(InjectorLike injectorLike) {
        return new ReactionSessionManager((Clock) SystemClockMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 541), PaginationReactionRequestTracker.m22474b(injectorLike), PendingStoryStore.a(injectorLike), (PrefetchReactionRequestTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PrefetchReactionRequestTrackerProvider.class), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), ReactionAnalyticsLogger.m22814a(injectorLike), (ReactionRequestTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionRequestTrackerProvider.class), ReactionUnitIndexMap.m22905a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public ReactionSessionManager(Clock clock, FbBroadcastManager fbBroadcastManager, Lazy<FragmentFactoryMap> lazy, PaginationReactionRequestTracker paginationReactionRequestTracker, PendingStoryStore pendingStoryStore, PrefetchReactionRequestTrackerProvider prefetchReactionRequestTrackerProvider, QuickPerformanceLogger quickPerformanceLogger, ReactionAnalyticsLogger reactionAnalyticsLogger, ReactionRequestTrackerProvider reactionRequestTrackerProvider, ReactionUnitIndexMap reactionUnitIndexMap, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, Lazy<FbErrorReporter> lazy2) {
        this.f18697b = clock;
        this.f18698c = fbBroadcastManager;
        this.f18699d = lazy;
        this.f18700e = paginationReactionRequestTracker;
        this.f18701f = pendingStoryStore;
        this.f18702g = prefetchReactionRequestTrackerProvider.m22492a(this);
        this.f18704i = quickPerformanceLogger;
        this.f18705j = reactionAnalyticsLogger;
        this.f18706k = reactionRequestTrackerProvider.m22545a(new ReactionRequestTrackerCallback(this));
        this.f18707l = reactionUnitIndexMap;
        this.f18708m = secureContextHelper;
        this.f18710o = uriIntentMapper;
        this.f18711p = lazy2;
        this.f18703h = new PublishUpdateHandler(this);
        this.f18709n = fbBroadcastManager.a().a("com.facebook.STREAM_PUBLISH_START", this.f18703h).a("com.facebook.STREAM_PUBLISH_COMPLETE", this.f18703h).a();
    }

    public final void m22611a(String str, String str2) {
        this.f18703h.f18693b.put(str, str2);
    }

    public final void m22608a(String str) {
        ReactionSession g = m22619g(str);
        if (g != null) {
            m22595a(g, "POST_ABORTED", null);
        }
    }

    @Nullable
    public final ReactionSession m22614b(@Nullable String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        return (ReactionSession) this.f18696a.get(str);
    }

    public final ReactionSession m22603a(String str, Surface surface) {
        return m22604a(str, surface, 4000);
    }

    public final ReactionSession m22604a(String str, Surface surface, long j) {
        if (!m22598b()) {
            ReactionRequestTracker reactionRequestTracker = this.f18706k;
            int size = reactionRequestTracker.f18653a.size();
            for (int i = 0; i < size; i++) {
                reactionRequestTracker.f18654b.a((FbEventSubscriber) reactionRequestTracker.f18653a.get(i));
            }
        }
        if (!this.f18709n.a()) {
            this.f18709n.b();
        }
        ReactionSession reactionSession = new ReactionSession(str, surface, j);
        this.f18696a.put(str, reactionSession);
        return reactionSession;
    }

    public final ReactionSession m22602a(ReactionQueryParams reactionQueryParams, ReactionStories reactionStories, Surface surface) {
        ReactionSession a = m22603a((String) Preconditions.checkNotNull(reactionStories.d()), surface);
        a.m22557a(reactionStories);
        a.m22549F();
        a.f18665h = -1;
        a.f18667j = -1;
        a.f18682y = reactionQueryParams;
        return a;
    }

    private void m22599c(@Nonnull ReactionSession reactionSession) {
        if (ReactionSurfaceUtil.m4778d(reactionSession.f18660c)) {
            this.f18698c.a("com.facebook.intent.action.REACTION_CLOSE_EXTERNAL_SHARE_SERVICE");
        }
    }

    final void m22605a(ReactionSession reactionSession) {
        if (ReactionSurfaceUtil.m4778d(reactionSession.f18660c)) {
            Intent b = m22596b(reactionSession);
            b.setAction("com.facebook.intent.action.REACTION_SHOW_DIALOG");
            this.f18698c.a(b);
            return;
        }
        m22601f(reactionSession);
    }

    public final void m22616c(String str) {
        ReactionSession b = m22614b(str);
        if (b != null) {
            b.f18668k = this.f18697b.a();
        }
    }

    public final void m22617d(String str) {
        ReactionSession b = m22614b(str);
        if (b != null) {
            m22600d(b);
        }
    }

    public final void m22610a(String str, ReactionSessionListener reactionSessionListener) {
        ReactionSession b = m22614b(str);
        if (b != null && reactionSessionListener != null) {
            b.m22556a(reactionSessionListener);
            if (b.f18671n != null) {
                reactionSessionListener.mo727a(b.f18671n, this.f18701f.d(str));
                b.f18671n = null;
            }
            if (b.m22547B() && !b.f18672o && !b.m22577z() && b.f18656A != null) {
                b.f18656A.run();
            }
        }
    }

    public final void m22618f(String str) {
        ReactionSession b = m22614b(str);
        if (b != null && b.m22547B() && b.f18656A != null) {
            b.f18656A.run();
        }
    }

    public final void m22609a(String str, Context context) {
        ReactionSession b = m22614b(str);
        if (b != null) {
            Intent b2;
            m22600d(b);
            if (b.m22577z()) {
                b2 = m22596b(b);
            } else if (b.f18672o) {
                b.f18670m = true;
                b2 = new Intent();
                b2.putExtra("response_pending", true);
            } else {
                if (b.f18663f != null) {
                    m22595a(b, b.f18663f, b.m22550H());
                }
                m22619g(str);
                return;
            }
            context.startService(ReactionExternalShareService.m22955a(context, b2));
        }
    }

    public final boolean m22613a(String str, FbFragment fbFragment, Runnable runnable, Bundle bundle) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        ReactionSession b = m22614b(str);
        if (b == null) {
            return false;
        }
        Preconditions.checkArgument(b.m22547B(), "Non-on-demand surface: " + b.f18660c);
        b.f18681x = bundle;
        b.f18656A = runnable;
        return m22615b(str, fbFragment);
    }

    public final boolean m22612a(String str, FbFragment fbFragment) {
        ReactionSession b = m22614b(str);
        if (b == null || b.m22547B()) {
            return false;
        }
        return m22615b(str, fbFragment);
    }

    public final boolean m22615b(String str, FbFragment fbFragment) {
        ReactionSession b = m22614b(str);
        if (b == null) {
            return false;
        }
        if (b.m22547B()) {
            Preconditions.checkNotNull(b.f18656A, "No runnable for " + b.f18660c);
        }
        m22600d(b);
        if (b.f18672o || b.m22577z() || b.m22547B()) {
            this.f18712q = new WeakReference(fbFragment);
            if (b.m22577z()) {
                m22601f(b);
            } else if (b.m22547B()) {
                m22601f(b);
            } else {
                b.f18670m = true;
            }
            return true;
        }
        if (b.f18663f != null) {
            m22595a(b, b.f18663f, b.m22550H());
        }
        m22619g(str);
        return false;
    }

    public final void m22607a(ReactionSession reactionSession, String str) {
        m22595a(reactionSession, str, reactionSession.m22550H());
        m22599c(reactionSession);
        m22591a();
        m22619g(reactionSession.f18658a);
    }

    final void m22606a(ReactionSession reactionSession, long j) {
        m22592a(reactionSession, j, Long.valueOf(reactionSession.m22572s()));
        m22599c(reactionSession);
        m22591a();
        m22619g(reactionSession.f18658a);
    }

    @VisibleForTesting
    public static Intent m22596b(@Nonnull ReactionSession reactionSession) {
        boolean z;
        boolean z2 = true;
        if (!reactionSession.m22547B()) {
            if (reactionSession.f18667j > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
        }
        if (reactionSession.f18668k > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (reactionSession.f18669l <= 0) {
            z2 = false;
        }
        Preconditions.checkState(z2);
        return new Intent().putExtra("reaction_session_id", reactionSession.f18658a);
    }

    private void m22593a(ReactionSession reactionSession, FragmentManager fragmentManager) {
        fragmentManager.a().a(((FragmentFactoryMap) this.f18699d.get()).a(ContentFragmentType.REACTION_DIALOG_FRAGMENT.ordinal()).a(m22596b(reactionSession)), "chromeless:content:fragment:tag").c();
        m22591a();
    }

    private void m22591a() {
        WeakReference weakReference = this.f18712q;
        this.f18712q = null;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    @Nullable
    public static ReactionSession m22589a(@Nullable ReactionSessionManager reactionSessionManager, ReactionEvent reactionEvent) {
        if (reactionEvent == null) {
            return null;
        }
        return reactionSessionManager.m22614b(reactionEvent.mo1120a());
    }

    private boolean m22598b() {
        return !this.f18696a.isEmpty();
    }

    private void m22595a(ReactionSession reactionSession, String str, @Nullable Long l) {
        this.f18705j.m22828a(reactionSession.f18658a, reactionSession.f18660c, reactionSession.m22561e(), reactionSession.m22560c(), str, l);
    }

    private void m22592a(ReactionSession reactionSession, long j, Long l) {
        this.f18705j.m22824a(reactionSession.m22562f(), reactionSession.m22575w(), reactionSession.m22561e(), reactionSession.m22560c(), j, reactionSession.m22565j(), l);
    }

    private void m22600d(ReactionSession reactionSession) {
        reactionSession.f18669l = this.f18697b.a();
    }

    @Nullable
    public final ReactionSession m22619g(String str) {
        this.f18704i.markerCancel(1966082, str.hashCode());
        this.f18704i.markerCancel(1966090, str.hashCode());
        this.f18704i.markerCancel(1966084, str.hashCode());
        ReactionSession reactionSession = (ReactionSession) this.f18696a.remove(str);
        Iterator it = this.f18703h.f18693b.entrySet().iterator();
        while (it.hasNext()) {
            if (str.equals(((Entry) it.next()).getValue())) {
                it.remove();
            }
        }
        if (reactionSession != null) {
            FutureDetour.a(reactionSession.f18661d, reactionSession.f18658a, -1903368312);
        }
        if (!m22598b() && this.f18709n.a()) {
            this.f18709n.c();
        }
        if (!m22598b()) {
            ReactionRequestTracker reactionRequestTracker = this.f18706k;
            int size = reactionRequestTracker.f18653a.size();
            for (int i = 0; i < size; i++) {
                reactionRequestTracker.f18654b.b((FbEventSubscriber) reactionRequestTracker.f18653a.get(i));
            }
            this.f18707l.f18869a.clear();
        }
        return reactionSession;
    }

    private void m22601f(ReactionSession reactionSession) {
        FbFragment fbFragment;
        Object obj;
        if (this.f18712q == null) {
            fbFragment = null;
        } else {
            fbFragment = (FbFragment) this.f18712q.get();
        }
        if (fbFragment == null || fbFragment.x || fbFragment.L || !fbFragment.mx_()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            m22595a(reactionSession, "NO_PARENT_FRAGMENT", Long.valueOf(reactionSession.m22572s()));
            m22591a();
            m22619g(reactionSession.f18658a);
            return;
        }
        m22594a(reactionSession, fbFragment);
    }

    private void m22594a(ReactionSession reactionSession, FbFragment fbFragment) {
        m22593a(reactionSession, fbFragment.kO_());
    }
}
