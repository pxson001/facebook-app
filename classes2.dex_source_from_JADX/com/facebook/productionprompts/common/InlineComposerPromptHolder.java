package com.facebook.productionprompts.common;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.internal.ImmutableSet;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerMultiRowInjectedFeedAdapter.2;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.constants.PromptConstants;
import com.facebook.ipc.productionprompts.fetcher.PromptFetcher;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater.TapSource;
import com.facebook.productionprompts.abtest.ProductionPromptsGatekeepers;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.constraints.PromptFetchConstraintCollection;
import com.facebook.productionprompts.events.PromptCancelFlowEvent;
import com.facebook.productionprompts.events.PromptCompleteFlowEvent;
import com.facebook.productionprompts.events.PromptsDismissEvent;
import com.facebook.productionprompts.events.PromptsEventBus;
import com.facebook.productionprompts.events.PromptsEventSubscriber;
import com.facebook.productionprompts.events.PromptsInvalidateEvent;
import com.facebook.productionprompts.logging.ProductionPromptsLogger;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.InlineComposerPromptSession.Builder;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.productionprompts.model.PromptViewState;
import com.facebook.productionprompts.model.PromptViewState$Visibility;
import com.facebook.productionprompts.prefs.PromptsPrefKeys;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: network_info_interact_req */
public class InlineComposerPromptHolder implements PromptViewStateUpdater {
    public static final String f12559b = (InlineComposerPromptHolder.class.getSimpleName() + "_user_in_holdout");
    private static final Object f12560z = new Object();
    @Nullable
    @VisibleForTesting
    public InlineComposerPromptSession f12561a = null;
    public final PromptFetcher f12562c;
    private final Provider<InlineComposerPromptActionHandler> f12563d;
    public final PromptRankingHelper f12564e;
    public final PromptViewStateHelper f12565f;
    private final PromptFetchConstraintCollection f12566g;
    private final TasksManager f12567h;
    public final Clock f12568i;
    public final PromptsEventBus f12569j;
    public final PromptsExperimentHelper f12570k;
    private final ProductionPromptsLogger f12571l;
    public final PromptsCompleteFlowEventSubscriber f12572m = new PromptsCompleteFlowEventSubscriber(this);
    public final PromptsCancelFlowEventSubscriber f12573n = new PromptsCancelFlowEventSubscriber(this);
    public final PromptsDismissEventSubscriber f12574o = new PromptsDismissEventSubscriber(this);
    public final PromptsInvalidateEventSubscriber f12575p = new PromptsInvalidateEventSubscriber(this);
    private final Provider<PromptImpressionLoggingSessionIdMap> f12576q;
    private final PromptSleepHelper f12577r;
    private final PersistentHiddenStateHelper f12578s;
    public final QuickPerformanceLogger f12579t;
    public final PromptsInternalSettingsController f12580u;
    public final AbstractFbErrorReporter f12581v;
    public final GatekeeperStoreImpl f12582w;
    public 2 f12583x;
    public long f12584y;

    /* compiled from: network_info_interact_req */
    class PromptsCompleteFlowEventSubscriber extends PromptsEventSubscriber<PromptCompleteFlowEvent> {
        final /* synthetic */ InlineComposerPromptHolder f12841a;

        public PromptsCompleteFlowEventSubscriber(InlineComposerPromptHolder inlineComposerPromptHolder) {
            this.f12841a = inlineComposerPromptHolder;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f12841a.m18652a((PromptCompleteFlowEvent) fbEvent);
        }

        public final Class<PromptCompleteFlowEvent> mo648a() {
            return PromptCompleteFlowEvent.class;
        }
    }

    /* compiled from: network_info_interact_req */
    class PromptsCancelFlowEventSubscriber extends PromptsEventSubscriber<PromptCancelFlowEvent> {
        final /* synthetic */ InlineComposerPromptHolder f12842a;

        public PromptsCancelFlowEventSubscriber(InlineComposerPromptHolder inlineComposerPromptHolder) {
            this.f12842a = inlineComposerPromptHolder;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f12842a.m18651a((PromptCancelFlowEvent) fbEvent);
        }

        public final Class<PromptCancelFlowEvent> mo648a() {
            return PromptCancelFlowEvent.class;
        }
    }

    /* compiled from: network_info_interact_req */
    class PromptsDismissEventSubscriber extends PromptsEventSubscriber<PromptsDismissEvent> {
        final /* synthetic */ InlineComposerPromptHolder f12843a;

        public PromptsDismissEventSubscriber(InlineComposerPromptHolder inlineComposerPromptHolder) {
            this.f12843a = inlineComposerPromptHolder;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f12843a.m18653a((PromptsDismissEvent) fbEvent);
        }

        public final Class<PromptsDismissEvent> mo648a() {
            return PromptsDismissEvent.class;
        }
    }

    /* compiled from: network_info_interact_req */
    class PromptsInvalidateEventSubscriber extends PromptsEventSubscriber<PromptsInvalidateEvent> {
        final /* synthetic */ InlineComposerPromptHolder f12844a;

        public PromptsInvalidateEventSubscriber(InlineComposerPromptHolder inlineComposerPromptHolder) {
            this.f12844a = inlineComposerPromptHolder;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f12844a.m18654a((PromptsInvalidateEvent) fbEvent);
        }

        public final Class<PromptsInvalidateEvent> mo648a() {
            return PromptsInvalidateEvent.class;
        }
    }

    private static InlineComposerPromptHolder m18650b(InjectorLike injectorLike) {
        return new InlineComposerPromptHolder(InlineComposerPromptFetcher.m18661a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3134), PromptRankingHelper.m18808a(injectorLike), PromptViewStateHelper.m18813a(injectorLike), PromptFetchConstraintCollection.m18841a(injectorLike), TasksManager.m14546a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), PromptsEventBus.m14730a(injectorLike), PromptsExperimentHelper.m15311a(injectorLike), ProductionPromptsLogger.m18862a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 3153), PromptSleepHelper.m18815a(injectorLike), PersistentHiddenStateHelper.m18839a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), PromptsInternalSettingsController.m18718a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.productionprompts.common.InlineComposerPromptHolder m18643a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.m1499a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.mo191b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.m1454a(r1);
        r4 = r3.m8951b();	 Catch:{ all -> 0x006c }
        r1 = f12560z;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.m8952c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.m1504b(r1);	 Catch:{  }
        r6 = r0.m1455a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.m1474e();	 Catch:{ all -> 0x0062 }
        r1 = m18650b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12560z;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.productionprompts.common.InlineComposerPromptHolder) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.m1505c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.productionprompts.common.InlineComposerPromptHolder) r0;	 Catch:{  }
        r3.m8952c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.m1505c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.m8952c();
        throw r0;
    L_0x0071:
        r0 = f12560z;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.productionprompts.common.InlineComposerPromptHolder) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.productionprompts.common.InlineComposerPromptHolder.a(com.facebook.inject.InjectorLike):com.facebook.productionprompts.common.InlineComposerPromptHolder");
    }

    @Inject
    public InlineComposerPromptHolder(InlineComposerPromptFetcher inlineComposerPromptFetcher, Provider<InlineComposerPromptActionHandler> provider, PromptRankingHelper promptRankingHelper, PromptViewStateHelper promptViewStateHelper, PromptFetchConstraintCollection promptFetchConstraintCollection, TasksManager tasksManager, Clock clock, PromptsEventBus promptsEventBus, PromptsExperimentHelper promptsExperimentHelper, ProductionPromptsLogger productionPromptsLogger, Provider<PromptImpressionLoggingSessionIdMap> provider2, PromptSleepHelper promptSleepHelper, PersistentHiddenStateHelper persistentHiddenStateHelper, QuickPerformanceLogger quickPerformanceLogger, PromptsInternalSettingsController promptsInternalSettingsController, FbErrorReporter fbErrorReporter, GatekeeperStore gatekeeperStore) {
        this.f12562c = inlineComposerPromptFetcher;
        this.f12563d = provider;
        this.f12564e = promptRankingHelper;
        this.f12565f = promptViewStateHelper;
        this.f12566g = promptFetchConstraintCollection;
        this.f12567h = tasksManager;
        this.f12568i = clock;
        this.f12569j = promptsEventBus;
        this.f12570k = promptsExperimentHelper;
        this.f12571l = productionPromptsLogger;
        this.f12576q = provider2;
        this.f12577r = promptSleepHelper;
        this.f12578s = persistentHiddenStateHelper;
        this.f12579t = quickPerformanceLogger;
        this.f12580u = promptsInternalSettingsController;
        this.f12581v = fbErrorReporter;
        this.f12582w = gatekeeperStore;
    }

    public final void m18657a(final boolean z, final String str) {
        Preconditions.b(this.f12583x != null);
        boolean z2 = false;
        if (this.f12562c.mo2490a()) {
            if (this.f12582w.m2189a(ProductionPromptsGatekeepers.f13528b, false)) {
                this.f12581v.m2350b(f12559b, "InlineComposerPromptFetcher#isEnabled=true but user is in PRODUCTION_PROMPTS_HOLDOUT");
            } else if (str.equals("on_resume") || this.f12568i.mo211a() - this.f12584y > 15000) {
                z2 = true;
            }
        }
        if (z2) {
            this.f12584y = this.f12568i.mo211a();
            this.f12567h.m14556a((Object) "FETCH_PROMPT_FUTURE", new Callable<ListenableFuture<ImmutableList<InlineComposerPromptSession>>>(this) {
                final /* synthetic */ InlineComposerPromptHolder f13931c;

                /* compiled from: network_info_interact_req */
                class C05891 implements Function<ImmutableList<PromptObject>, ImmutableList<InlineComposerPromptSession>> {
                    final /* synthetic */ C05741 f14021a;

                    C05891(C05741 c05741) {
                        this.f14021a = c05741;
                    }

                    public Object apply(Object obj) {
                        return this.f14021a.f13931c.f12565f.m18814a(this.f14021a.f13931c.f12564e.m18812a((ImmutableList) obj, this.f14021a.f13931c.f12561a), this.f14021a.f13931c.f12561a);
                    }
                }

                public Object call() {
                    if (!z) {
                        this.f13931c.f12579t.mo449a(9633793, "prefetch_source", str);
                    }
                    this.f13931c.f12580u.f12631c.clear();
                    return Futures.m2450a(this.f13931c.f12562c.mo2492c(), new C05891(this), MoreExecutors.m1813a());
                }
            }, new AbstractDisposableFutureCallback<ImmutableList<InlineComposerPromptSession>>(this) {
                final /* synthetic */ InlineComposerPromptHolder f13933b;

                protected final void mo347a(Object obj) {
                    ImmutableList immutableList = (ImmutableList) obj;
                    this.f13933b.f12579t.mo468b(9633793, (short) 2);
                    this.f13933b.m18656a(immutableList, this.f13933b.f12583x, z);
                }

                protected final void mo348a(Throwable th) {
                    this.f13933b.f12579t.markerCancel(9633793, 3);
                }
            });
        }
    }

    public final void mo2486a(InlineComposerPromptSession inlineComposerPromptSession, TapSource tapSource) {
        if (this.f12561a != null && this.f12561a.f13409a.mo2493b().equals(inlineComposerPromptSession.f13409a.mo2493b()) && !PromptViewState$Visibility.MAXIMIZED.equals(this.f12561a.f13411c.a)) {
            this.f12571l.m18872b(PromptAnalytics.a(inlineComposerPromptSession, ((PromptImpressionLoggingSessionIdMap) this.f12576q.get()).m19702a(inlineComposerPromptSession.f13409a.mo2493b())), tapSource);
            PersistentHiddenStateHelper persistentHiddenStateHelper = this.f12578s;
            if (this.f12561a.f13409a.mo2493b().equals(persistentHiddenStateHelper.f12823a.mo278a(PromptsPrefKeys.f12797s, null))) {
                persistentHiddenStateHelper.f12823a.mo282a(ImmutableSet.m32768a(PromptsPrefKeys.f12797s));
            }
            m18645a(PromptViewState$Visibility.MAXIMIZED);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo2487b(com.facebook.productionprompts.model.InlineComposerPromptSession r5, com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater.TapSource r6) {
        /*
        r4 = this;
        r0 = r4.f12561a;
        if (r0 == 0) goto L_0x0018;
    L_0x0004:
        r0 = r4.f12561a;
        r0 = r0.f13409a;
        r0 = r0.mo2493b();
        r1 = r5.f13409a;
        r1 = r1.mo2493b();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        return;
    L_0x0019:
        r0 = com.facebook.productionprompts.model.PromptViewState$Visibility.MINIMIZED;
        r1 = r4.f12561a;
        r1 = r1.f13411c;
        r1 = r1.a;
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0018;
    L_0x0027:
        r0 = com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater.TapSource.ICON;
        if (r6 == r0) goto L_0x004d;
    L_0x002b:
        r0 = r4.f12561a;
        r0 = r0.f13409a;
        r2 = com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater.TapSource.XOUT;
        if (r6 != r2) goto L_0x0087;
    L_0x0033:
        r2 = m18649a(r0);
        if (r2 == 0) goto L_0x0087;
    L_0x0039:
        r2 = 1;
    L_0x003a:
        r0 = r2;
        if (r0 == 0) goto L_0x004d;
    L_0x003d:
        r2 = com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater.TapSource.XOUT;
        if (r6 != r2) goto L_0x0089;
    L_0x0041:
        r2 = r4.f12570k;
        r2 = r2.m15317r();
        if (r2 == 0) goto L_0x0089;
    L_0x0049:
        r2 = 1;
    L_0x004a:
        r0 = r2;
        if (r0 == 0) goto L_0x0068;
    L_0x004d:
        r0 = r4.f12576q;
        r0 = r0.get();
        r0 = (com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap) r0;
        r1 = r5.f13409a;
        r1 = r1.mo2493b();
        r0 = r0.m19702a(r1);
        r1 = r4.f12571l;
        r0 = com.facebook.productionprompts.logging.PromptAnalytics.a(r5, r0);
        r1.m18870a(r0, r6);
    L_0x0068:
        r0 = r4.f12578s;
        r1 = r4.f12561a;
        r1 = r1.f13409a;
        r1 = r1.mo2493b();
        r2 = r0.f12823a;
        r2 = r2.edit();
        r3 = com.facebook.productionprompts.prefs.PromptsPrefKeys.f12797s;
        r2 = r2.mo1276a(r3, r1);
        r2.commit();
        r0 = com.facebook.productionprompts.model.PromptViewState$Visibility.MINIMIZED;
        r4.m18645a(r0);
        goto L_0x0018;
    L_0x0087:
        r2 = 0;
        goto L_0x003a;
    L_0x0089:
        r2 = 0;
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.productionprompts.common.InlineComposerPromptHolder.b(com.facebook.productionprompts.model.InlineComposerPromptSession, com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater$TapSource):void");
    }

    @VisibleForTesting
    final void m18656a(ImmutableList<InlineComposerPromptSession> immutableList, NewPromptCallback newPromptCallback, boolean z) {
        if (!this.f12566g.mo2498a(this.f12568i.mo211a())) {
            return;
        }
        if (!immutableList.isEmpty()) {
            InlineComposerPromptSession inlineComposerPromptSession = (InlineComposerPromptSession) immutableList.get(0);
            if (m18648a(this.f12561a, inlineComposerPromptSession, z)) {
                m18644a(inlineComposerPromptSession);
                newPromptCallback.a(inlineComposerPromptSession);
            }
            this.f12580u.m18724a((ImmutableList) immutableList);
        } else if (this.f12561a != null && z) {
            m18647a(false);
            newPromptCallback.a(null);
        }
    }

    @VisibleForTesting
    final void m18652a(PromptCompleteFlowEvent promptCompleteFlowEvent) {
        if (promptCompleteFlowEvent.f13532c) {
            this.f12571l.m18873c(promptCompleteFlowEvent.f13531b);
            PromptSleepHelper promptSleepHelper = this.f12577r;
            String str = promptCompleteFlowEvent.f13531b.promptType;
            if (str != null) {
                promptSleepHelper.f12770a.m18828d(str);
                promptSleepHelper.f12771b.m18838c(str);
            }
            m18646a(promptCompleteFlowEvent.f13530a, promptCompleteFlowEvent.f13531b.promptId, promptCompleteFlowEvent.f13532c, false);
        } else {
            this.f12571l.m18874d(promptCompleteFlowEvent.f13531b);
        }
        this.f12583x.a(this.f12561a);
    }

    @VisibleForTesting
    final void m18651a(PromptCancelFlowEvent promptCancelFlowEvent) {
        this.f12571l.m18875e(promptCancelFlowEvent.f13534b);
        if (!this.f12570k.m15314c()) {
            mo2487b(this.f12561a, TapSource.IMPLICIT);
        }
    }

    @VisibleForTesting
    final void m18653a(PromptsDismissEvent promptsDismissEvent) {
        ((InlineComposerPromptActionHandler) this.f12563d.get()).mo2622a(null, promptsDismissEvent.f13535a);
        PromptSleepHelper promptSleepHelper = this.f12577r;
        String str = promptsDismissEvent.f13535a.f13410b.f15099c;
        if (str != null) {
            promptSleepHelper.f12770a.m18827c(str);
            promptSleepHelper.f12771b.m18837b(str);
        }
        PromptObject a = InlineComposerPromptSession.m19774a(promptsDismissEvent.f13535a);
        if (this.f12570k.m15317r() || m18649a(a) || this.f12570k.m15314c()) {
            m18646a(a.getClass(), promptsDismissEvent.f13535a.f13409a.mo2493b(), promptsDismissEvent.f13537c, promptsDismissEvent.f13538d);
            this.f12571l.m18871b(promptsDismissEvent.f13536b);
            this.f12583x.a(this.f12561a);
        }
    }

    @VisibleForTesting
    final void m18654a(PromptsInvalidateEvent promptsInvalidateEvent) {
        this.f12562c.mo2488a(promptsInvalidateEvent.f13539a);
    }

    public static boolean m18649a(PromptObject promptObject) {
        ImmutableList immutableList = PromptConstants.f13946a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (promptObject.mo2494c().equals((String) immutableList.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean m18648a(@Nullable InlineComposerPromptSession inlineComposerPromptSession, InlineComposerPromptSession inlineComposerPromptSession2, boolean z) {
        if (Objects.equal(inlineComposerPromptSession, inlineComposerPromptSession2)) {
            return false;
        }
        if (inlineComposerPromptSession != null || inlineComposerPromptSession2 == null) {
            return z;
        }
        return true;
    }

    private void m18644a(InlineComposerPromptSession inlineComposerPromptSession) {
        if (this.f12561a == null || !this.f12561a.f13409a.mo2493b().equals(inlineComposerPromptSession.f13409a.mo2493b())) {
            this.f12566g.mo2499b(this.f12568i.mo211a());
        }
        this.f12561a = inlineComposerPromptSession;
    }

    private void m18647a(boolean z) {
        this.f12566g.mo2496a(this.f12568i.mo211a(), z);
        if (this.f12570k.m15314c() && z) {
            m18645a(PromptViewState$Visibility.DISMISSED);
        } else {
            this.f12561a = null;
        }
    }

    private void m18645a(PromptViewState$Visibility promptViewState$Visibility) {
        Preconditions.a(this.f12561a);
        m18644a(new Builder(this.f12561a).a(new PromptViewState(promptViewState$Visibility, this.f12561a.f13411c.b)).a());
        this.f12583x.a(this.f12561a);
    }

    private void m18646a(Class<? extends PromptObject> cls, String str, boolean z, boolean z2) {
        if (this.f12561a != null && this.f12561a.f13409a.mo2493b().equals(str)) {
            m18647a(z2);
            this.f12562c.mo2489a(cls, str, z);
        }
        this.f12562c.mo2488a(cls);
    }
}
