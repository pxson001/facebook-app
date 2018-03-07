package com.facebook.pages.common.surface.fragments.reaction;

import com.facebook.composer.publish.common.PendingStory;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.job_sequencer.PagesJobSequencer;
import com.facebook.pages.common.job_sequencer.SequencedJob;
import com.facebook.pages.common.job_sequencer.SequencedJob.Builder;
import com.facebook.pages.common.job_sequencer.SequencedJob.Priority;
import com.facebook.pages.common.job_sequencer.SequencerSignal;
import com.facebook.pages.common.sequencelogger.PagesFirstCardPerfLogger;
import com.facebook.pages.common.sequencelogger.PagesSurfaceFirstCardPerfLogger;
import com.facebook.pages.common.surface.fragments.reaction.PagesGenericReactionSurfaceTabFragment.C03091;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionListener;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: results_error */
public class PagesReactionSessionEarlyFetchController {
    private static final Priority f2461a = Priority.INTERACTIVE;
    private static final ImmutableSet[] f2462b = new ImmutableSet[]{ImmutableSet.of(SequencerSignal.HEADER_PERF_LOGGING_STOPPED), ImmutableSet.of(SequencerSignal.PAGES_REACTION_HOME_TAB_FIRST_CARD_TIMER)};
    private static final ImmutableSet<SequencerSignal> f2463c = ImmutableSet.of(SequencerSignal.FIRST_CARD_DATA_LOADED);
    private final ReactionSessionManager f2464d;
    public final PagesJobSequencer f2465e;
    private final Lazy<ScheduledExecutorService> f2466f;
    public final String f2467g;
    public final C03091 f2468h;
    @Nullable
    public final PagesSurfaceFirstCardPerfLogger f2469i;
    @Nullable
    public final ReactionSession f2470j;
    @Nullable
    public final ReactionSession f2471k;
    public boolean f2472l = true;
    private boolean f2473m = false;
    private final ReactionSessionListener f2474n = new C03274(this);

    /* compiled from: results_error */
    class C03252 implements Runnable {
        final /* synthetic */ PagesReactionSessionEarlyFetchController f2456a;

        C03252(PagesReactionSessionEarlyFetchController pagesReactionSessionEarlyFetchController) {
            this.f2456a = pagesReactionSessionEarlyFetchController;
        }

        public void run() {
            this.f2456a.f2465e.m2450a(this.f2456a.f2467g, ImmutableSet.of(SequencerSignal.PAGES_REACTION_HOME_TAB_FIRST_CARD_TIMER));
        }
    }

    /* compiled from: results_error */
    class C03274 implements ReactionSessionListener {
        final /* synthetic */ PagesReactionSessionEarlyFetchController f2460a;

        C03274(PagesReactionSessionEarlyFetchController pagesReactionSessionEarlyFetchController) {
            this.f2460a = pagesReactionSessionEarlyFetchController;
        }

        public final boolean kq_() {
            return this.f2460a.f2472l;
        }

        public final void m3426a(ReactionStories reactionStories) {
        }

        public final void kr_() {
        }

        public final void m3427a(String str, Optional<PendingStory> optional) {
        }

        public final void kQ_() {
            this.f2460a.f2472l = false;
            C03091 c03091 = this.f2460a.f2468h;
            ReactionSession reactionSession = this.f2460a.f2471k;
            if (c03091.f2426a.av != null) {
                reactionSession.a(c03091.f2426a);
                c03091.f2426a.b(reactionSession);
                c03091.f2426a.at.b(reactionSession);
                c03091.f2426a.kQ_();
            }
        }

        public final void kp_() {
        }
    }

    @Inject
    public PagesReactionSessionEarlyFetchController(@Assisted String str, @Assisted String str2, @Assisted String str3, @Assisted ReactionSessionResultListener reactionSessionResultListener, @Assisted PagesFirstCardPerfLogger pagesFirstCardPerfLogger, ReactionSessionManager reactionSessionManager, PagesJobSequencer pagesJobSequencer, Lazy<ScheduledExecutorService> lazy) {
        this.f2467g = (String) Preconditions.checkNotNull(str);
        this.f2468h = (C03091) Preconditions.checkNotNull(reactionSessionResultListener);
        this.f2469i = pagesFirstCardPerfLogger;
        this.f2471k = reactionSessionManager.b(str2);
        this.f2470j = reactionSessionManager.b(str3);
        this.f2464d = reactionSessionManager;
        this.f2465e = pagesJobSequencer;
        this.f2466f = lazy;
    }

    public final ReactionSession m3433a(ReactionSessionListener reactionSessionListener) {
        if (this.f2471k == null) {
            return null;
        }
        if (this.f2471k != null) {
            Preconditions.checkNotNull(this.f2471k.y);
            this.f2471k.y.b = 5;
            this.f2471k.y.x = "SubsequentLoad";
        }
        if (this.f2469i != null) {
            this.f2469i.a("SurfaceFirstCardFromEarlyFetcher", "true");
            this.f2469i.a("SurfaceFirstCardCachedWithEarlyFetcher", this.f2470j != null ? "true" : "false");
        }
        if (this.f2471k.A()) {
            if (this.f2470j != null) {
                this.f2464d.g(this.f2470j.a);
            }
            this.f2471k.a(reactionSessionListener);
            m3430b(reactionSessionListener);
            return this.f2471k;
        } else if (this.f2470j != null && this.f2470j.A()) {
            this.f2470j.a(reactionSessionListener);
            this.f2471k.a(this.f2474n);
            m3431c(reactionSessionListener);
            return this.f2470j;
        } else if (this.f2470j != null) {
            this.f2470j.a(reactionSessionListener);
            this.f2471k.a(this.f2474n);
            return this.f2470j;
        } else {
            this.f2471k.a(reactionSessionListener);
            return this.f2471k;
        }
    }

    private static ImmutableList<ReactionStories> m3429a(ReactionSession reactionSession) {
        if (!reactionSession.A()) {
            return null;
        }
        ImmutableList<ReactionStories> p = reactionSession.p();
        reactionSession.a();
        reactionSession.o = true;
        return p;
    }

    private void m3430b(final ReactionSessionListener reactionSessionListener) {
        if (this.f2471k != null) {
            final ImmutableList a = m3429a(this.f2471k);
            if (a != null) {
                this.f2465e.m2449a(m3428a(new Callable<Object>(this) {
                    final /* synthetic */ PagesReactionSessionEarlyFetchController f2455c;

                    public Object call() {
                        int size = a.size();
                        for (int i = 0; i < size; i++) {
                            this.f2455c.f2471k.a((ReactionStories) a.get(i));
                        }
                        this.f2455c.f2471k.o = false;
                        PagesReactionSessionEarlyFetchController.m3432d(this.f2455c);
                        reactionSessionListener.kQ_();
                        return null;
                    }
                }));
                ((ScheduledExecutorService) this.f2466f.get()).schedule(new C03252(this), 3, TimeUnit.SECONDS);
            }
        }
    }

    private void m3431c(final ReactionSessionListener reactionSessionListener) {
        if (this.f2470j != null) {
            final ImmutableList a = m3429a(this.f2470j);
            if (a != null) {
                this.f2465e.m2449a(m3428a(new Callable<Object>(this) {
                    final /* synthetic */ PagesReactionSessionEarlyFetchController f2459c;

                    public Object call() {
                        if (this.f2459c.f2472l) {
                            int size = a.size();
                            for (int i = 0; i < size; i++) {
                                this.f2459c.f2470j.a((ReactionStories) a.get(i));
                            }
                            this.f2459c.f2470j.o = false;
                            PagesReactionSessionEarlyFetchController.m3432d(this.f2459c);
                            reactionSessionListener.kQ_();
                        }
                        return null;
                    }
                }));
            }
        }
    }

    public static void m3432d(PagesReactionSessionEarlyFetchController pagesReactionSessionEarlyFetchController) {
        if (!pagesReactionSessionEarlyFetchController.f2473m && pagesReactionSessionEarlyFetchController.f2469i != null) {
            pagesReactionSessionEarlyFetchController.f2469i.d();
            pagesReactionSessionEarlyFetchController.f2473m = true;
        }
    }

    private SequencedJob m3428a(Callable<Object> callable) {
        Builder a = new Builder().m2455a(callable, true);
        a.f1630a = f2461a;
        a = a;
        a.f1631b = this.f2467g;
        a = a;
        a.f1633d = SequencedJob.m2457a(f2463c);
        Builder builder = a;
        for (ImmutableSet a2 : f2462b) {
            builder.m2453a(a2);
        }
        return builder.m2456a();
    }
}
