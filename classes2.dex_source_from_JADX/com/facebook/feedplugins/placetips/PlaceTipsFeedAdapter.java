package com.facebook.feedplugins.placetips;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.ContentFragmentContainer;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.dispose.Disposable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow$OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.ConfidenceLevel;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.common.abtest.ExperimentsForPlaceTipsCommonAbTestModule;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.EventsModel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.LocationUpsellsModel;
import com.facebook.placetips.logging.PlaceTipsAnalyticsEvent;
import com.facebook.placetips.logging.PlaceTipsAnalyticsLogger;
import com.facebook.placetips.settings.PlaceTipsRuntimeSettingsManager;
import com.facebook.placetips.settings.PlaceTipsSettingsChangedListener;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.AccessorFuture;
import com.facebook.placetips.settings.graphql.C0638x892114ef;
import com.facebook.placetips.settings.graphql.GravitySettingsUtil;
import com.facebook.placetips.upsell.PlaceTipsUpsellAnalyticsEvent;
import com.facebook.placetips.upsell.PlaceTipsUpsellAnalyticsLogger;
import com.facebook.placetips.upsell.PlaceTipsUpsellBuilder;
import com.facebook.placetips.upsell.PlaceTipsUpsellExperimentController;
import com.facebook.placetips.upsell.PlaceTipsUpsellManagerCacheWrapper;
import com.facebook.placetips.upsell.UpsellPageConfig;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.abtest.ExperimentsForReactionAbtestModule;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.constants.ReactionIntentConstants.EntryPoint;
import com.facebook.reaction.placetips.PlaceTipsReactionManager;
import com.facebook.reaction.placetips.PlaceTipsReactionManager.Callback;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: maximumWeight */
public class PlaceTipsFeedAdapter extends FbBaseAdapter implements Disposable {
    private final ReactionExperimentController f14783a;
    public final PlaceTipsAnalyticsLogger f14784b;
    private final PlaceTipsUpsellAnalyticsLogger f14785c;
    private final PlaceTipsReactionManager f14786d;
    private final PlaceTipsFeedUnitBinder f14787e;
    public final PlaceTipsPostComposeNuxPrefs f14788f;
    private final Lazy<FbErrorReporter> f14789g;
    private final Supplier<PresentationConfig> f14790h;
    private final Lazy<PlaceTipsUpsellManagerCacheWrapper> f14791i;
    private final PlaceTipsRuntimeSettingsManager f14792j;
    private final EventTipsManager f14793k;
    public final Lazy<FbUriIntentHandler> f14794l;
    private final Callback f14795m = new C06401(this);
    private final PopoverWindow$OnDismissListener f14796n = new C06412(this);
    private final PlaceTipsSettingsChangedListener f14797o = new C06423(this);
    private boolean f14798p = false;
    public Tooltip f14799q = null;
    private boolean f14800r = false;

    /* compiled from: maximumWeight */
    class C06401 implements Callback {
        final /* synthetic */ PlaceTipsFeedAdapter f14971a;

        C06401(PlaceTipsFeedAdapter placeTipsFeedAdapter) {
            this.f14971a = placeTipsFeedAdapter;
        }

        public final void mo2829a() {
            AdapterDetour.a(this.f14971a, 1326879127);
        }
    }

    /* compiled from: maximumWeight */
    class C06412 implements PopoverWindow$OnDismissListener {
        final /* synthetic */ PlaceTipsFeedAdapter f14972a;

        C06412(PlaceTipsFeedAdapter placeTipsFeedAdapter) {
            this.f14972a = placeTipsFeedAdapter;
        }

        public final boolean mo2830a(PopoverWindow popoverWindow) {
            PlaceTipsPostComposeNuxPrefs placeTipsPostComposeNuxPrefs = this.f14972a.f14788f;
            if (!placeTipsPostComposeNuxPrefs.m21391b()) {
                placeTipsPostComposeNuxPrefs.f14953c.edit().putBoolean(PlaceTipsPostComposeNuxPrefs.f14952b, true).commit();
            }
            return false;
        }
    }

    /* compiled from: maximumWeight */
    class C06423 implements PlaceTipsSettingsChangedListener {
        final /* synthetic */ PlaceTipsFeedAdapter f14973a;

        C06423(PlaceTipsFeedAdapter placeTipsFeedAdapter) {
            this.f14973a = placeTipsFeedAdapter;
        }

        public final void mo2828a(@Nullable C0638x892114ef c0638x892114ef, C0638x892114ef c0638x892114ef2) {
            PlaceTipsFeedAdapter.m21193a(this.f14973a, GravitySettingsUtil.m21578a(c0638x892114ef2));
        }
    }

    /* compiled from: maximumWeight */
    class C06455 implements FutureCallback<Accessor> {
        final /* synthetic */ PlaceTipsFeedAdapter f14977a;

        C06455(PlaceTipsFeedAdapter placeTipsFeedAdapter) {
            this.f14977a = placeTipsFeedAdapter;
        }

        public void onSuccess(Object obj) {
            PlaceTipsFeedAdapter.m21193a(this.f14977a, ((Accessor) obj).m21313c());
        }

        public void onFailure(Throwable th) {
            throw new Error(th);
        }
    }

    /* compiled from: maximumWeight */
    class PresentationConfig {
        @Nullable
        final ConfidenceLevel f15113a;

        public PresentationConfig(@Nullable ConfidenceLevel confidenceLevel) {
            this.f15113a = confidenceLevel;
        }
    }

    public static PlaceTipsFeedAdapter m21195b(InjectorLike injectorLike) {
        return new PlaceTipsFeedAdapter(QeInternalImplMethodAutoProvider.m3744a(injectorLike), EventTipsManager.m21200b(injectorLike), ReactionExperimentController.m21318a(injectorLike), PlaceTipsAnalyticsLogger.m21246a(injectorLike), PlaceTipsUpsellAnalyticsLogger.m21331a(injectorLike), PlaceTipsReactionManager.m21341a(injectorLike), PlaceTipsFeedUnitBinder.m21368b(injectorLike), PlaceTipsPostComposeNuxPrefs.m21389b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), IdBasedSingletonScopeProvider.m1810b(injectorLike, 616), IdBasedLazy.m1808a(injectorLike, 3030), PlaceTipsRuntimeSettingsManager.m21404a(injectorLike), AccessorFuture.m21411b(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike));
    }

    @Inject
    public PlaceTipsFeedAdapter(final QeAccessor qeAccessor, EventTipsManager eventTipsManager, ReactionExperimentController reactionExperimentController, PlaceTipsAnalyticsLogger placeTipsAnalyticsLogger, PlaceTipsUpsellAnalyticsLogger placeTipsUpsellAnalyticsLogger, PlaceTipsReactionManager placeTipsReactionManager, PlaceTipsFeedUnitBinder placeTipsFeedUnitBinder, PlaceTipsPostComposeNuxPrefs placeTipsPostComposeNuxPrefs, Lazy<FbErrorReporter> lazy, Lazy<FbUriIntentHandler> lazy2, Lazy<PlaceTipsUpsellManagerCacheWrapper> lazy3, PlaceTipsRuntimeSettingsManager placeTipsRuntimeSettingsManager, AccessorFuture accessorFuture, Executor executor) {
        this.f14783a = reactionExperimentController;
        this.f14794l = lazy2;
        this.f14784b = placeTipsAnalyticsLogger;
        this.f14785c = placeTipsUpsellAnalyticsLogger;
        this.f14786d = placeTipsReactionManager;
        this.f14787e = placeTipsFeedUnitBinder;
        this.f14788f = placeTipsPostComposeNuxPrefs;
        this.f14789g = lazy;
        this.f14786d.m21353a(this.f14795m);
        this.f14790h = Suppliers.memoize(new Supplier<PresentationConfig>(this) {
            final /* synthetic */ PlaceTipsFeedAdapter f14976b;

            public Object get() {
                return new PresentationConfig(qeAccessor.mo594a(Liveness.Live, ExperimentsForPlaceTipsCommonAbTestModule.f15115b, false) ? ConfidenceLevel.MEDIUM : null);
            }
        });
        this.f14791i = lazy3;
        this.f14792j = placeTipsRuntimeSettingsManager;
        this.f14793k = eventTipsManager;
        this.f14792j.m21408a(this.f14797o);
        Futures.m2458a((ListenableFuture) accessorFuture, new C06455(this), executor);
    }

    public final View mo1985a(int i, ViewGroup viewGroup) {
        return new PlaceTipsFeedUnitView(viewGroup.getContext());
    }

    public final void mo1986a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        PlaceTipsFeedUnitView placeTipsFeedUnitView = (PlaceTipsFeedUnitView) view;
        placeTipsFeedUnitView.setVisibility(0);
        LocationUpsellsModel b = ((PlaceTipsUpsellManagerCacheWrapper) this.f14791i.get()).m21644b();
        if (b != null) {
            PlaceTipsFeedUnitBinder placeTipsFeedUnitBinder = this.f14787e;
            String str = null;
            placeTipsFeedUnitView.a();
            placeTipsFeedUnitView.setTitle(b.c());
            placeTipsFeedUnitView.setSubText(b.d());
            placeTipsFeedUnitView.setSourceText(null);
            if (b.b() != null) {
                str = b.b().mo2924b();
            }
            placeTipsFeedUnitView.setIconImage(str);
            placeTipsFeedUnitBinder.f14920f.m21334a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_FEED_UNIT_VPV);
            m21196b();
            placeTipsFeedUnitView.setPlaceTipOnClickListener(new 6(this));
            return;
        }
        PresenceDescription a = this.f14786d.m21351a();
        EventsModel a2 = this.f14793k.m21202a();
        if (a2 != null && (a == null || a.l() != PresenceSourceType.INJECT)) {
            this.f14787e.m21370a(a2, placeTipsFeedUnitView);
            m21196b();
            placeTipsFeedUnitView.setPlaceTipOnClickListener(new 7(this, a2));
        } else if (a == null) {
            ((AbstractFbErrorReporter) this.f14789g.get()).m2352b("place_tips", new NullPointerException("try to bind place tips feed unit w/ null presence description"));
            m21196b();
            placeTipsFeedUnitView.setVisibility(8);
        } else {
            this.f14787e.m21369a(a, placeTipsFeedUnitView);
            placeTipsFeedUnitView.setPlaceTipOnClickListener(new 8(this));
            String a3 = this.f14783a.f14885b.mo581a(ExperimentsForReactionAbtestModule.f13564a, null);
            if (a.l() != PresenceSourceType.POST_COMPOSE || this.f14788f.m21391b() || a3 == null) {
                m21196b();
            } else {
                m21194a(placeTipsFeedUnitView, a3, a);
            }
        }
    }

    public int getCount() {
        if (!this.f14800r) {
            return 0;
        }
        return (this.f14786d.m21354a(((PresentationConfig) this.f14790h.get()).f15113a) || (this.f14793k.m21202a() != null ? 1 : null) != null) ? 1 : 0;
    }

    public void notifyDataSetChanged() {
        ((PlaceTipsUpsellManagerCacheWrapper) this.f14791i.get()).m21645c();
        super.notifyDataSetChanged();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public final void jc_() {
        this.f14786d.m21355b(this.f14795m);
        this.f14792j.m21409b(this.f14797o);
        this.f14798p = true;
    }

    public final boolean ba_() {
        return this.f14798p;
    }

    public final void m21199a(View view) {
        Context context = view.getContext();
        PresenceDescription a = this.f14786d.m21351a();
        if (a == null) {
            ((AbstractFbErrorReporter) this.f14789g.get()).m2352b("place_tips", new NullPointerException("place tips feed unit click w/ null presence description"));
            return;
        }
        Object obj;
        if (((PlaceTipsUpsellManagerCacheWrapper) this.f14791i.get()).m21644b() != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            FbFragment a2 = m21191a(context);
            if (a2 != null) {
                boolean z;
                this.f14785c.m21334a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_FEED_UNIT_CLICK);
                PlaceTipsUpsellExperimentController placeTipsUpsellExperimentController = ((PlaceTipsUpsellManagerCacheWrapper) this.f14791i.get()).f15102a.f15106c;
                int i = 0;
                Preconditions.checkArgument(placeTipsUpsellExperimentController.m21649a());
                int c = placeTipsUpsellExperimentController.m21650c();
                if (c > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                PlaceTipsUpsellBuilder placeTipsUpsellBuilder = (PlaceTipsUpsellBuilder) placeTipsUpsellExperimentController.f15110c.get();
                while (i < c) {
                    placeTipsUpsellBuilder.d.add((UpsellPageConfig) ((Supplier) placeTipsUpsellExperimentController.f15108a.get(i)).get());
                    i++;
                }
                PlaceTipsUpsellBuilder placeTipsUpsellBuilder2 = placeTipsUpsellBuilder;
                placeTipsUpsellBuilder2.f = new 10(this, context, a);
                placeTipsUpsellBuilder2 = placeTipsUpsellBuilder2;
                placeTipsUpsellBuilder2.g = new 9(this);
                placeTipsUpsellBuilder2.a(a2.kO_(), "PlaceTipsUpsellDialogFrag");
                return;
            }
            return;
        }
        m21192a(this, context, a);
    }

    public static void m21192a(PlaceTipsFeedAdapter placeTipsFeedAdapter, Context context, PresenceDescription presenceDescription) {
        FbFragment a = m21191a(context);
        if (a != null) {
            placeTipsFeedAdapter.f14784b.m21257a(PlaceTipsAnalyticsEvent.FEED_UNIT_CLICK, presenceDescription.l(), presenceDescription.i(), presenceDescription.d());
            placeTipsFeedAdapter.f14786d.m21352a(a, EntryPoint.NEWSFEED);
        }
    }

    @Nullable
    private static FbFragment m21191a(Context context) {
        ContentFragmentContainer contentFragmentContainer = (ContentFragmentContainer) ContextUtils.m2500a(context, ContentFragmentContainer.class);
        if (contentFragmentContainer == null) {
            return null;
        }
        return contentFragmentContainer.mo783a();
    }

    private void m21194a(PlaceTipsFeedUnitView placeTipsFeedUnitView, String str, PresenceDescription presenceDescription) {
        Context context = placeTipsFeedUnitView.getContext();
        if (this.f14799q == null) {
            this.f14799q = new Tooltip(context, 2);
            this.f14799q.t = -1;
            this.f14799q.a(Position.BELOW);
            this.f14784b.m21257a(PlaceTipsAnalyticsEvent.POST_COMPOSE_TOOLTIP_SEEN, presenceDescription.l(), presenceDescription.i(), presenceDescription.d());
        }
        this.f14799q.H = this.f14796n;
        this.f14799q.b(str);
        this.f14799q.f(placeTipsFeedUnitView);
    }

    private void m21196b() {
        if (this.f14799q != null) {
            this.f14799q.H = null;
            this.f14799q.l();
        }
    }

    public static void m21193a(PlaceTipsFeedAdapter placeTipsFeedAdapter, boolean z) {
        if (placeTipsFeedAdapter.f14800r != z) {
            placeTipsFeedAdapter.f14800r = z;
            AdapterDetour.a(placeTipsFeedAdapter, -1958691530);
        }
    }
}
