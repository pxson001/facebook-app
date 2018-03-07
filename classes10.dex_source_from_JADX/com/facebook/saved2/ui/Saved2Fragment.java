package com.facebook.saved2.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.crudolib.dao.DAOItem;
import com.facebook.crudolib.dbquery.loader.inprocess.DatabaseQueryManager;
import com.facebook.crudolib.dbquery.loader.inprocess.NoContentProviderQueryExecutor;
import com.facebook.crudolib.dbquery.loader.inprocess.OnDataCallback;
import com.facebook.crudolib.eventbus.Event;
import com.facebook.crudolib.eventbus.EventSubscriber;
import com.facebook.crudolib.mutableprimitive.MutableInt;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.analytics.SaveAnalyticsLogger.Referer;
import com.facebook.saved.common.data.RecentSaveInfo;
import com.facebook.saved.interstitial.SavedDashboardInterstitialManagerProvider;
import com.facebook.saved2.analytics.Saved2StartPerfLogger;
import com.facebook.saved2.bus.Saved2EventBus;
import com.facebook.saved2.bus.Saved2EventBus.FetchFailedData;
import com.facebook.saved2.bus.Saved2EventBus.FetchSucceededData;
import com.facebook.saved2.model.Saved2UnreadCountsTable_Queries.BaseQueryDAO;
import com.facebook.saved2.model.Saved2UnreadCountsTable_Queries.BaseQueryDAOImpl;
import com.facebook.saved2.model.Saved2UnreadCountsTable_Queries.BaseQueryProvider;
import com.facebook.saved2.network.Saved2DataFetcher;
import com.facebook.saved2.network.Saved2DataFetcher.C14041;
import com.facebook.saved2.ui.LoadItemsController.StateMachine;
import com.facebook.saved2.ui.itemadapters.Saved2GroupedItemsAdapterFactoryProvider;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: instant_shopping_audio_button_on_enter */
public class Saved2Fragment extends FbFragment {
    @Inject
    Saved2NetworkController f9493a;
    public DatabaseQueryManager al;
    public LoadItemsController am;
    public ViewPager an;
    public SavedSectionsPagerAdapter ao;
    private TabbedViewPagerIndicator ap;
    @Nullable
    public String aq;
    @Nullable
    public String ar;
    private final EventSubscriber<FetchSucceededData> as = new C14172(this);
    private final EventSubscriber<FetchFailedData> at = new C14183(this);
    private final OnPageChangeListener au = new C14194(this);
    @Inject
    public Saved2StartPerfLogger f9494b;
    @Inject
    @Saved2QueryExecutor
    NoContentProviderQueryExecutor f9495c;
    @Inject
    Toaster f9496d;
    @Inject
    SavedSectionsPagerAdapterProvider f9497e;
    @Inject
    SaveAnalyticsLogger f9498f;
    @Inject
    RecentSaveInfo f9499g;
    @Inject
    FbSharedPreferences f9500h;
    @Inject
    SavedDashboardInterstitialManagerProvider f9501i;

    /* compiled from: instant_shopping_audio_button_on_enter */
    public class C14161 implements OnDataCallback<BaseQueryDAO> {
        final /* synthetic */ Saved2Fragment f9489a;

        public C14161(Saved2Fragment saved2Fragment) {
            this.f9489a = saved2Fragment;
        }

        public final void m9767a(DAOItem dAOItem) {
            BaseQueryDAOImpl baseQueryDAOImpl = (BaseQueryDAOImpl) dAOItem;
            this.f9489a.f9494b.m9532g();
            this.f9489a.ao.m9715a(baseQueryDAOImpl.a(), baseQueryDAOImpl);
            Saved2Fragment.m9772e(this.f9489a);
        }

        public final void m9766a() {
            this.f9489a.ao.m9715a(null, null);
        }
    }

    /* compiled from: instant_shopping_audio_button_on_enter */
    class C14172 implements EventSubscriber<FetchSucceededData> {
        final /* synthetic */ Saved2Fragment f9490a;

        C14172(Saved2Fragment saved2Fragment) {
            this.f9490a = saved2Fragment;
        }

        public final void m9768a(Event event) {
            FetchSucceededData fetchSucceededData = (FetchSucceededData) event;
            StateMachine a = this.f9490a.am.m9763a(fetchSucceededData.f9366a);
            a.f9462a.mo443a(a, fetchSucceededData.f9367b);
        }
    }

    /* compiled from: instant_shopping_audio_button_on_enter */
    class C14183 implements EventSubscriber<FetchFailedData> {
        final /* synthetic */ Saved2Fragment f9491a;

        C14183(Saved2Fragment saved2Fragment) {
            this.f9491a = saved2Fragment;
        }

        public final void m9769a(Event event) {
            StateMachine a = this.f9491a.am.m9763a(((FetchFailedData) event).f9365a);
            a.f9462a.mo440a(a, this.f9491a.b(2131230811));
        }
    }

    /* compiled from: instant_shopping_audio_button_on_enter */
    class C14194 extends SimpleOnPageChangeListener {
        final /* synthetic */ Saved2Fragment f9492a;

        C14194(Saved2Fragment saved2Fragment) {
            this.f9492a = saved2Fragment;
        }

        public final void e_(int i) {
            String e = ((BaseQueryDAOImpl) this.f9492a.ao.m9713a(i)).e();
            this.f9492a.ar = e;
            this.f9492a.am.m9763a(e).m9762b();
            String str = e;
            this.f9492a.f9498f.b.b("saved_dashboard", null, null, ImmutableMap.of("action_name", "saved_dashboard_filter_section_clicked", "next_section_type", str, "event_id", SafeUUIDGenerator.a().toString()));
        }
    }

    public static void m9771a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((Saved2Fragment) obj).m9770a(Saved2NetworkController.m9778b(injectorLike), Saved2StartPerfLogger.m9519a(injectorLike), C1415x906da584.m9764a(injectorLike), Toaster.b(injectorLike), (SavedSectionsPagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SavedSectionsPagerAdapterProvider.class), SaveAnalyticsLogger.a(injectorLike), RecentSaveInfo.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (SavedDashboardInterstitialManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SavedDashboardInterstitialManagerProvider.class));
    }

    private void m9770a(Saved2NetworkController saved2NetworkController, Saved2StartPerfLogger saved2StartPerfLogger, NoContentProviderQueryExecutor noContentProviderQueryExecutor, Toaster toaster, SavedSectionsPagerAdapterProvider savedSectionsPagerAdapterProvider, SaveAnalyticsLogger saveAnalyticsLogger, RecentSaveInfo recentSaveInfo, FbSharedPreferences fbSharedPreferences, SavedDashboardInterstitialManagerProvider savedDashboardInterstitialManagerProvider) {
        this.f9493a = saved2NetworkController;
        this.f9494b = saved2StartPerfLogger;
        this.f9495c = noContentProviderQueryExecutor;
        this.f9496d = toaster;
        this.f9497e = savedSectionsPagerAdapterProvider;
        this.f9498f = saveAnalyticsLogger;
        this.f9499g = recentSaveInfo;
        this.f9500h = fbSharedPreferences;
        this.f9501i = savedDashboardInterstitialManagerProvider;
    }

    public final void m9776c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = Saved2Fragment.class;
        m9771a((Object) this, getContext());
        this.f9494b.m9526a();
        this.al = new DatabaseQueryManager(E(), this.f9495c, new MutableInt(1));
        this.am = new LoadItemsController(this.al, this.f9493a, this.f9494b, this.f9500h, this.f9496d);
        this.ao = new SavedSectionsPagerAdapter(o(), this.am, (Saved2GroupedItemsAdapterFactoryProvider) this.f9497e.getOnDemandAssistedProviderForStaticDi(Saved2GroupedItemsAdapterFactoryProvider.class));
        String string = this.s.getString("extra_section_name");
        if (bundle != null) {
            string = bundle.getString("extra_section_name");
        }
        if (string == null) {
            string = "ALL";
        }
        this.aq = string;
        if (bundle == null) {
            SaveAnalyticsLogger saveAnalyticsLogger = this.f9498f;
            Referer referer = (Referer) Referer.fromString(this.s.getString("extra_referer")).orNull();
            String str = this.aq;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_dashboard_imp");
            honeyClientEvent.c = "saved_dashboard";
            saveAnalyticsLogger.a.a(honeyClientEvent.a("referer", referer).b("section_type", str).b("event_id", SafeUUIDGenerator.a().toString()));
        }
        Saved2EventBus.f9368a.a(this.at);
        Saved2EventBus.f9369b.a(this.as);
        this.f9494b.m9532g();
        this.al.a(new BaseQueryProvider(), new C14161(this));
        this.am.m9763a((String) Assertions.b(this.aq)).m9762b();
        this.f9501i.m9212a(getContext()).m9211a();
    }

    public final void m9773I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1347747);
        super.I();
        Saved2EventBus.f9368a.b(this.at);
        Saved2EventBus.f9369b.b(this.as);
        this.f9499g.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1840918290, a);
    }

    public final void m9777e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("extra_section_name", this.ar);
    }

    public static void m9772e(Saved2Fragment saved2Fragment) {
        saved2Fragment.f9494b.m9533h();
        Saved2NetworkController saved2NetworkController = saved2Fragment.f9493a;
        if (!saved2NetworkController.f9504c) {
            saved2NetworkController.f9504c = true;
            Saved2DataFetcher saved2DataFetcher = saved2NetworkController.f9502a;
            saved2DataFetcher.f9438f.m9534i();
            new C14041(saved2DataFetcher).start();
        }
        if (saved2Fragment.ap != null) {
            saved2Fragment.ap.b();
        }
        saved2Fragment.ar();
    }

    public final View m9774a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1151418241);
        View inflate = layoutInflater.inflate(2130906934, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 288086550, a);
        return inflate;
    }

    public final void m9775a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.an = (ViewPager) e(2131567201);
        this.an.setAdapter(this.ao);
        this.ap = (TabbedViewPagerIndicator) e(2131567200);
        this.ap.setViewPager(this.an);
        this.ap.l = this.au;
        ar();
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -451422519);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131238120);
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1854585135, a);
    }

    private void ar() {
        if (this.an != null && this.aq != null && this.ao.b() > 0) {
            int a = FindSectionUtil.m9717a((BaseQueryDAOImpl) this.ao.m9716e(), this.aq);
            if (a < 0) {
                BLog.a("Saved2Fragment", "Cannot display requested section '%s': not found", new Object[]{r0});
            } else {
                this.an.setCurrentItem(a);
            }
            this.aq = null;
        }
    }
}
