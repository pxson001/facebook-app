package com.facebook.goodwill.dailydialogue.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer$Priority;
import com.facebook.common.appchoreographer.AppChoreographer$ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.data.FeedDataLoadedCallbacks;
import com.facebook.feed.data.FeedDataLoadedCallbacks.Location;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feedplugins.customizedstory.CustomizedStoryRootPartDefinition;
import com.facebook.goodwill.abtest.ExperimentsForGoodwillAbTestModule;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger.Events;
import com.facebook.goodwill.dailydialogue.data.DailyDialoguePinnedUnitsProtocol;
import com.facebook.goodwill.dailydialogue.data.DailyDialoguePrefKeys;
import com.facebook.goodwill.dailydialogue.data.DailyDialogueViewedMutationProtocol;
import com.facebook.goodwill.dailydialogue.env.DailyDialogueEnvironment;
import com.facebook.goodwill.dailydialogue.env.DailyDialogueEnvironmentProvider;
import com.facebook.goodwill.dailydialogue.env.DailyDialogueMenuHelperProvider;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

/* compiled from: percent_time_2+_dropped_with_ */
public class DailyDialogueInjectedFeedAdapter extends BaseViewportEventListener implements ViewportEventListener, ResumePauseCallbacks, FeedDataLoadedCallbacks {
    private final Runnable f10225a = new C04291(this);
    private final Runnable f10226b = new C04302(this);
    private final MultiRowAdapterBuilder f10227c;
    private final Lazy<CustomizedStoryRootPartDefinition> f10228d;
    private final OneItemListItemCollection<GraphQLFeedUnitEdge> f10229e;
    private final TasksManager f10230f;
    public final DailyDialoguePinnedUnitsProtocol f10231g;
    public final Handler f10232h = new Handler();
    public final DailyDialogueViewedMutationProtocol f10233i;
    private final DailyDialogueEnvironmentProvider f10234j;
    private MultiRowAdapter f10235k;
    public final GoodwillAnalyticsLogger f10236l;
    private final Clock f10237m;
    private final FbSharedPreferences f10238n;
    public final QeAccessor f10239o;
    public boolean f10240p = false;
    public boolean f10241q = false;
    private boolean f10242r;
    private long f10243s;
    private boolean f10244t;
    public String f10245u;

    /* compiled from: percent_time_2+_dropped_with_ */
    class C04291 implements Runnable {
        final /* synthetic */ DailyDialogueInjectedFeedAdapter f10257a;

        C04291(DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter) {
            this.f10257a = dailyDialogueInjectedFeedAdapter;
        }

        public void run() {
            DailyDialogueInjectedFeedAdapter.m15325f(this.f10257a);
            this.f10257a.f10236l.m15343a(Events.GOODWILL_DAILY_DIALOGUE_GOOD_MORNING_DISMISS);
        }
    }

    /* compiled from: percent_time_2+_dropped_with_ */
    class C04302 implements Runnable {
        final /* synthetic */ DailyDialogueInjectedFeedAdapter f10258a;

        C04302(DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter) {
            this.f10258a = dailyDialogueInjectedFeedAdapter;
        }

        public void run() {
            DailyDialogueInjectedFeedAdapter.m15325f(this.f10258a);
            this.f10258a.f10233i.m15339b(new ViewedMutationCallback(), this.f10258a.f10245u);
        }
    }

    /* compiled from: percent_time_2+_dropped_with_ */
    class C04313 implements Runnable {
        final /* synthetic */ DailyDialogueInjectedFeedAdapter f10268a;

        C04313(DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter) {
            this.f10268a = dailyDialogueInjectedFeedAdapter;
        }

        public void run() {
            this.f10268a.m15330b();
        }
    }

    public static DailyDialogueInjectedFeedAdapter m15323a(InjectorLike injectorLike) {
        return new DailyDialogueInjectedFeedAdapter(MultiRowAdapterBuilder.m15276b(injectorLike), IdBasedLazy.m1808a(injectorLike, 1845), DailyDialoguePinnedUnitsProtocol.m15335b(injectorLike), (DailyDialogueEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DailyDialogueEnvironmentProvider.class), DailyDialogueViewedMutationProtocol.m15337b(injectorLike), GoodwillAnalyticsLogger.m15340a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), TasksManager.m14550b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), DefaultAppChoreographer.m1621a(injectorLike));
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public DailyDialogueInjectedFeedAdapter(MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<CustomizedStoryRootPartDefinition> lazy, DailyDialoguePinnedUnitsProtocol dailyDialoguePinnedUnitsProtocol, DailyDialogueEnvironmentProvider dailyDialogueEnvironmentProvider, DailyDialogueViewedMutationProtocol dailyDialogueViewedMutationProtocol, GoodwillAnalyticsLogger goodwillAnalyticsLogger, Clock clock, FbSharedPreferences fbSharedPreferences, TasksManager tasksManager, QeAccessor qeAccessor, AppChoreographer appChoreographer) {
        this.f10227c = multiRowAdapterBuilder;
        this.f10228d = lazy;
        this.f10230f = tasksManager;
        this.f10231g = dailyDialoguePinnedUnitsProtocol;
        this.f10233i = dailyDialogueViewedMutationProtocol;
        this.f10234j = dailyDialogueEnvironmentProvider;
        this.f10236l = goodwillAnalyticsLogger;
        this.f10237m = clock;
        this.f10238n = fbSharedPreferences;
        this.f10239o = qeAccessor;
        this.f10229e = new OneItemListItemCollection();
        this.f10243s = this.f10238n.mo277a(DailyDialoguePrefKeys.f10260b, -m15326h());
        appChoreographer.m1634a("Holding off Good Morning fetch for coldstart", new C04313(this), AppChoreographer$Priority.APPLICATION_LOADED_LOW_PRIORITY, AppChoreographer$ThreadType.UI);
    }

    public final void m15327a(Location location) {
        if (Location.HEAD.equals(location)) {
            m15324e();
        }
    }

    @VisibleForTesting
    final void m15330b() {
        if (!this.f10244t) {
            this.f10244t = true;
            m15324e();
        }
    }

    @VisibleForTesting
    final void m15328a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, String str) {
        this.f10243s = this.f10237m.mo211a();
        this.f10238n.edit().mo1275a(DailyDialoguePrefKeys.f10260b, this.f10243s).commit();
        if (graphQLFeedUnitEdge == null || graphQLFeedUnitEdge.m19091n() == null) {
            m15325f(this);
            return;
        }
        this.f10229e.f10223a = graphQLFeedUnitEdge;
        this.f10240p = false;
        this.f10245u = str;
        if (this.f10235k != null && !this.f10235k.ba_()) {
            this.f10235k.notifyDataSetChanged();
        }
    }

    private void m15324e() {
        long a = this.f10237m.mo211a();
        if (this.f10244t && a - this.f10243s >= m15326h()) {
            this.f10230f.m14556a((Object) "FetchPinnedUnits", new 4(this), new StoryCallback(this));
        }
    }

    public final FbListAdapter m15332c(ScrollingViewProxy scrollingViewProxy) {
        Object obj = this.f10234j;
        DailyDialogueEnvironment dailyDialogueEnvironment = new DailyDialogueEnvironment((Context) obj.getInstance(Context.class), (DailyDialogueMenuHelperProvider) obj.getOnDemandAssistedProviderForStaticDi(DailyDialogueMenuHelperProvider.class), HasScrollListenerSupportImpl.m18212a(scrollingViewProxy), this.f10225a, this.f10226b);
        Builder a = this.f10227c.m15277a(this.f10228d, this.f10229e);
        a.f12879f = dailyDialogueEnvironment;
        this.f10235k = a.m18959e();
        return this.f10235k;
    }

    public final void mo1970a(Object obj) {
        if (this.f10235k != null && this.f10235k.getCount() > 0 && this.f10235k.getItem(this.f10235k.getCount() - 1) == obj && !this.f10240p) {
            this.f10241q = true;
            HandlerDetour.b(this.f10232h, new 5(this), (long) ((this.f10239o.mo596a(ExperimentsForGoodwillAbTestModule.f10261a, false) ? this.f10239o.mo571a(ExperimentsForGoodwillAbTestModule.f10263c, 0.5f) : this.f10239o.mo571a(ExperimentsForGoodwillAbTestModule.f10266f, 0.5f)) * 1000.0f), -771684826);
        }
    }

    public final void mo1973b(Object obj) {
        this.f10241q = false;
        if (this.f10235k != null && this.f10235k.getCount() > 0 && this.f10235k.getItem(this.f10235k.getCount() - 1) == obj) {
            this.f10232h.removeCallbacksAndMessages(null);
        }
    }

    public final void mo1264c() {
        this.f10242r = true;
    }

    public final void mo1265d() {
        this.f10242r = false;
        this.f10232h.removeCallbacksAndMessages(null);
    }

    public static void m15325f(DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter) {
        dailyDialogueInjectedFeedAdapter.f10229e.f10223a = null;
        if (dailyDialogueInjectedFeedAdapter.f10235k != null) {
            dailyDialogueInjectedFeedAdapter.f10235k.notifyDataSetChanged();
        }
        dailyDialogueInjectedFeedAdapter.f10232h.removeCallbacksAndMessages(null);
        dailyDialogueInjectedFeedAdapter.f10240p = false;
    }

    private long m15326h() {
        return (long) ((this.f10239o.mo596a(ExperimentsForGoodwillAbTestModule.f10261a, false) ? this.f10239o.mo571a(ExperimentsForGoodwillAbTestModule.f10262b, 24.0f) : this.f10239o.mo571a(ExperimentsForGoodwillAbTestModule.f10265e, 24.0f)) * 3600000.0f);
    }
}
