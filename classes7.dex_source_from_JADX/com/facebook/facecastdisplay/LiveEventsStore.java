package com.facebook.facecastdisplay;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.CollectionUtil;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: stories_to_fetch */
public class LiveEventsStore implements FacecastEventsStore {
    private static final String f2984a = LiveEventsStore.class.getName();
    private static final Object f2985b = null;
    private final FacecastUtil f2986c;
    private final AbstractFbErrorReporter f2987d;
    public final ScheduledExecutorService f2988e;
    private final DefaultAndroidThreadUtil f2989f;
    private final Handler f2990g = new Handler(Looper.getMainLooper());
    private final Clock f2991h;
    private final LiveCommentsDownloaderProvider f2992i;
    private final LiveWatchEventsDownloaderProvider f2993j;
    private final LiveSubscribeEventsDownloaderProvider f2994k;
    private final LiveLikeEventsDownloaderProvider f2995l;
    private final LiveAnnouncementsDownloaderProvider f2996m;
    public final List<LiveEventsDownloader> f2997n = new ArrayList();
    private final Set<String> f2998o = Collections.synchronizedSet(new HashSet());
    private final Set<String> f2999p = Collections.synchronizedSet(new HashSet());
    public final RoundRobinBuffer<LiveEventType, LiveEventModel> f3000q = new RoundRobinBuffer();
    @Nullable
    public volatile FacecastEventStoreListener f3001r;
    @Nullable
    public Future f3002s;
    @Nullable
    private String f3003t;
    private boolean f3004u;
    public boolean f3005v;
    private Provider<StreamingCommentsModel> f3006w;
    private StreamingCommentsModel f3007x;

    /* compiled from: stories_to_fetch */
    class C02692 implements Runnable {
        final /* synthetic */ LiveEventsStore f2975a;

        C02692(LiveEventsStore liveEventsStore) {
            this.f2975a = liveEventsStore;
        }

        public void run() {
            for (LiveEventsDownloader liveEventsDownloader : this.f2975a.f2997n) {
                liveEventsDownloader.mo120b();
                liveEventsDownloader.m3135a(null);
            }
            synchronized (this.f2975a.f3000q) {
                this.f2975a.f3000q.m22584b();
            }
        }
    }

    /* compiled from: stories_to_fetch */
    class C02703 implements Runnable {
        final /* synthetic */ LiveEventsStore f2976a;

        C02703(LiveEventsStore liveEventsStore) {
            this.f2976a = liveEventsStore;
        }

        public void run() {
            for (LiveEventsDownloader b : this.f2976a.f2997n) {
                b.mo120b();
            }
        }
    }

    /* compiled from: stories_to_fetch */
    class C02714 implements Runnable {
        final /* synthetic */ LiveEventsStore f2977a;

        C02714(LiveEventsStore liveEventsStore) {
            this.f2977a = liveEventsStore;
        }

        public void run() {
            LiveEventsStore.m3261c(this.f2977a);
        }
    }

    /* compiled from: stories_to_fetch */
    class C02725 implements Runnable {
        final /* synthetic */ LiveEventsStore f2978a;

        C02725(LiveEventsStore liveEventsStore) {
            this.f2978a = liveEventsStore;
        }

        public void run() {
            if (this.f2978a.f3001r != null) {
                this.f2978a.f3001r.mo147b();
            }
        }
    }

    /* compiled from: stories_to_fetch */
    class C02747 implements Runnable {
        final /* synthetic */ LiveEventsStore f2981a;

        C02747(LiveEventsStore liveEventsStore) {
            this.f2981a = liveEventsStore;
        }

        public void run() {
            if (this.f2981a.f3001r != null) {
                this.f2981a.f3001r.mo147b();
            }
        }
    }

    public static LiveEventsStore m3258b(InjectorLike injectorLike) {
        return new LiveEventsStore(FacecastUtil.m3107b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (LiveCommentsDownloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LiveCommentsDownloaderProvider.class), (LiveWatchEventsDownloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LiveWatchEventsDownloaderProvider.class), (LiveSubscribeEventsDownloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LiveSubscribeEventsDownloaderProvider.class), (LiveLikeEventsDownloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LiveLikeEventsDownloaderProvider.class), (LiveAnnouncementsDownloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LiveAnnouncementsDownloaderProvider.class), IdBasedProvider.a(injectorLike, 5741));
    }

    @Inject
    public LiveEventsStore(FacecastUtil facecastUtil, FbErrorReporter fbErrorReporter, ScheduledExecutorService scheduledExecutorService, AndroidThreadUtil androidThreadUtil, Clock clock, LiveCommentsDownloaderProvider liveCommentsDownloaderProvider, LiveWatchEventsDownloaderProvider liveWatchEventsDownloaderProvider, LiveSubscribeEventsDownloaderProvider liveSubscribeEventsDownloaderProvider, LiveLikeEventsDownloaderProvider liveLikeEventsDownloaderProvider, LiveAnnouncementsDownloaderProvider liveAnnouncementsDownloaderProvider, Provider<StreamingCommentsModel> provider) {
        this.f2986c = facecastUtil;
        this.f2987d = fbErrorReporter;
        this.f2988e = scheduledExecutorService;
        this.f2989f = androidThreadUtil;
        this.f2991h = clock;
        this.f2992i = liveCommentsDownloaderProvider;
        this.f2993j = liveWatchEventsDownloaderProvider;
        this.f2994k = liveSubscribeEventsDownloaderProvider;
        this.f2995l = liveLikeEventsDownloaderProvider;
        this.f2996m = liveAnnouncementsDownloaderProvider;
        this.f3006w = provider;
    }

    public final void mo134a(FacecastEventStoreListener facecastEventStoreListener) {
        this.f2989f.a();
        this.f3001r = facecastEventStoreListener;
    }

    public final void mo135a(final String str) {
        this.f2989f.a();
        if (this.f3002s != null && !this.f3002s.isDone()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f2987d.a(f2984a + "_startLoading", "Tried to start loading without a valid story id.");
            return;
        }
        if (this.f2986c.m3110b()) {
            m3259b().m22590a(this);
        }
        this.f3002s = this.f2988e.scheduleAtFixedRate(new Runnable(this) {
            boolean f2972a;
            final /* synthetic */ LiveEventsStore f2974c;

            public void run() {
                if (!this.f2972a) {
                    for (LiveEventsDownloader liveEventsDownloader : this.f2974c.f2997n) {
                        liveEventsDownloader.m3135a(this.f2974c);
                        liveEventsDownloader.mo125a(str);
                    }
                    this.f2972a = true;
                }
                LiveEventsStore.m3261c(this.f2974c);
            }
        }, 0, 2, TimeUnit.SECONDS);
        this.f3005v = false;
    }

    public final void mo132a() {
        this.f2989f.a();
        if (this.f3007x != null) {
            this.f3007x.m22589a();
        }
        ExecutorDetour.a(this.f2988e, new C02692(this), -2013519030);
        if (this.f3002s != null) {
            this.f3002s.cancel(false);
            this.f3002s = null;
        }
        this.f2997n.clear();
        this.f2990g.removeCallbacksAndMessages(f2985b);
        this.f2998o.clear();
        this.f2999p.clear();
        this.f3005v = true;
    }

    public final void mo137b(String str) {
        this.f2998o.add(str);
    }

    public final void mo139c(String str) {
        this.f3003t = str;
    }

    public final void mo136a(boolean z) {
        List list;
        this.f3004u = z;
        if (!this.f2986c.m3110b()) {
            list = this.f2997n;
            LiveCommentsDownloaderProvider liveCommentsDownloaderProvider = this.f2992i;
            list.add(new LiveCommentsDownloader(this.f2988e, GraphQLQueryExecutor.a(liveCommentsDownloaderProvider), (AbstractFbErrorReporter) FbErrorReporterImpl.a(liveCommentsDownloaderProvider), (Clock) SystemClockMethodAutoProvider.a(liveCommentsDownloaderProvider)));
        }
        list = this.f2997n;
        LiveWatchEventsDownloaderProvider liveWatchEventsDownloaderProvider = this.f2993j;
        list.add(new LiveWatchEventsDownloader(this.f2988e, GraphQLQueryExecutor.a(liveWatchEventsDownloaderProvider), (AbstractFbErrorReporter) FbErrorReporterImpl.a(liveWatchEventsDownloaderProvider), (Clock) SystemClockMethodAutoProvider.a(liveWatchEventsDownloaderProvider)));
        if (!this.f3004u) {
            list = this.f2997n;
            LiveSubscribeEventsDownloaderProvider liveSubscribeEventsDownloaderProvider = this.f2994k;
            list.add(new LiveSubscribeEventsDownloader(this.f2988e, GraphQLQueryExecutor.a(liveSubscribeEventsDownloaderProvider), (AbstractFbErrorReporter) FbErrorReporterImpl.a(liveSubscribeEventsDownloaderProvider), String_ViewerContextUserIdMethodAutoProvider.b(liveSubscribeEventsDownloaderProvider), (QeAccessor) QeInternalImplMethodAutoProvider.a(liveSubscribeEventsDownloaderProvider), (Clock) SystemClockMethodAutoProvider.a(liveSubscribeEventsDownloaderProvider)));
            this.f2997n.add(this.f2995l.m22509a(this.f2988e));
        }
        if (this.f2986c.f2822a.a(579, false)) {
            list = this.f2997n;
            LiveAnnouncementsDownloaderProvider liveAnnouncementsDownloaderProvider = this.f2996m;
            list.add(new LiveAnnouncementsDownloader(this.f2988e, GraphQLQueryExecutor.a(liveAnnouncementsDownloaderProvider), (AbstractFbErrorReporter) FbErrorReporterImpl.a(liveAnnouncementsDownloaderProvider), (Clock) SystemClockMethodAutoProvider.a(liveAnnouncementsDownloaderProvider)));
        }
    }

    public final void mo138b(boolean z) {
        this.f2989f.a();
        if (this.f3005v != z) {
            this.f3005v = z;
            if (z) {
                ExecutorDetour.a(this.f2988e, new C02703(this), -300187327);
                if (this.f3002s != null) {
                    this.f3002s.cancel(false);
                    this.f3002s = null;
                    return;
                }
                return;
            }
            for (LiveEventsDownloader a : this.f2997n) {
                a.mo119a();
            }
            this.f3002s = this.f2988e.scheduleAtFixedRate(new C02714(this), 0, 2, TimeUnit.SECONDS);
        }
    }

    public final void mo140d(String str) {
        synchronized (this.f3000q) {
            Object b = this.f3000q.m22583b(LiveEventType.LIVE_COMMENT_EVENT);
            if (CollectionUtil.b(b)) {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    if (((LiveEventWithAuthorModel) it.next()).f2848k.f2903b.equals(str)) {
                        it.remove();
                    }
                }
            }
            this.f2999p.add(str);
        }
    }

    public final void mo133a(float f) {
    }

    public final void m3267a(List<LiveEventModel> list, boolean z) {
        if (!z || this.f3001r == null) {
            synchronized (this.f3000q) {
                for (LiveEventModel liveEventModel : list) {
                    if (!((liveEventModel.mo118a() == LiveEventType.LIVE_COMMENT_EVENT && ((LiveCommentEventModel) liveEventModel).f2848k.f2903b.equals(this.f3003t) && this.f2998o.contains(((LiveCommentEventModel) liveEventModel).f2849a)) || m3260b(this, liveEventModel))) {
                        if (this.f2986c.m3110b()) {
                            m3256a(liveEventModel);
                        } else {
                            this.f3000q.m22582a(liveEventModel.mo118a(), liveEventModel);
                        }
                    }
                }
            }
            return;
        }
        m3257a((List) list);
    }

    public final void m3272c(boolean z) {
        if (z && m3262d()) {
            HandlerDetour.a(this.f2990g, new C02725(this), 1467603311);
        }
    }

    public final void mo141e(String str) {
        this.f2989f.a();
        if (this.f2986c.m3110b()) {
            m3259b().m22591a(str);
        }
    }

    private synchronized StreamingCommentsModel m3259b() {
        if (this.f3007x == null) {
            this.f3007x = (StreamingCommentsModel) this.f3006w.get();
        }
        return this.f3007x;
    }

    public static void m3261c(LiveEventsStore liveEventsStore) {
        if (liveEventsStore.f3001r != null) {
            synchronized (liveEventsStore.f3000q) {
                LiveEventModel liveEventModel = (LiveEventModel) liveEventsStore.f3000q.m22581a();
                if (liveEventModel != null) {
                    liveEventsStore.m3256a(liveEventModel);
                }
            }
            for (LiveEventsDownloader liveEventsDownloader : liveEventsStore.f2997n) {
                int a = liveEventsStore.f3000q.m22580a(liveEventsDownloader.mo122d());
                if (liveEventsDownloader.hq_() == -1 || a <= liveEventsDownloader.hq_()) {
                    if (liveEventsDownloader.mo121c()) {
                        long a2 = (liveEventsStore.f2991h.a() - liveEventsDownloader.m3140g()) / 1000;
                        liveEventsDownloader.getClass().getName();
                        Long.valueOf(a2);
                    } else {
                        liveEventsDownloader.mo119a();
                    }
                }
            }
        }
    }

    private void m3257a(final List<LiveEventModel> list) {
        HandlerDetour.a(this.f2990g, new Runnable(this) {
            final /* synthetic */ LiveEventsStore f2980b;

            public void run() {
                if (this.f2980b.f3001r != null) {
                    this.f2980b.f3001r.mo146a(list);
                }
            }
        }, 555964311);
        if (m3262d()) {
            HandlerDetour.a(this.f2990g, new C02747(this), -387824139);
        }
    }

    private void m3256a(final LiveEventModel liveEventModel) {
        HandlerDetour.a(this.f2990g, new Runnable(this) {
            final /* synthetic */ LiveEventsStore f2983b;

            public void run() {
                if (this.f2983b.f3001r != null && !LiveEventsStore.m3260b(this.f2983b, liveEventModel)) {
                    this.f2983b.f3001r.mo144a(liveEventModel);
                }
            }
        }, 521181501);
    }

    private boolean m3262d() {
        for (LiveEventsDownloader h : this.f2997n) {
            if (!h.m3141h()) {
                return false;
            }
        }
        return true;
    }

    public static boolean m3260b(LiveEventsStore liveEventsStore, LiveEventModel liveEventModel) {
        return (liveEventModel instanceof LiveEventWithAuthorModel) && liveEventsStore.f2999p.contains(((LiveEventWithAuthorModel) liveEventModel).f2848k.f2903b);
    }
}
