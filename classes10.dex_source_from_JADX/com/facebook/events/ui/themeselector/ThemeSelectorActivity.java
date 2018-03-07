package com.facebook.events.ui.themeselector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.events.ui.themeselector.ThemeCategoriesFetcher.C27851;
import com.facebook.events.ui.themeselector.ThemeCategoriesFetcher.C27862;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeCategoriesModel.EventCoverPhotoThemeCategoriesModel.NodesModel;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: app_invite_promotion_displayed */
public class ThemeSelectorActivity extends FbFragmentActivity {
    public int f19584A;
    @Inject
    ThemeCategoriesFetcherProvider f19585p;
    @Inject
    EventsThemeSelectionPagerAdapterProvider f19586q;
    public EventsThemeSelectionPagerAdapter f19587r;
    public LoadingIndicatorView f19588s;
    public TabbedViewPagerIndicator f19589t;
    private ThemeCategoriesFetcher f19590u;
    public ViewPager f19591v;
    public ViewStub f19592w;
    public View f19593x;
    public String f19594y;
    public String f19595z;

    /* compiled from: app_invite_promotion_displayed */
    class C27871 implements OnClickListener {
        final /* synthetic */ ThemeSelectorActivity f19582a;

        C27871(ThemeSelectorActivity themeSelectorActivity) {
            this.f19582a = themeSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 857937573);
            this.f19582a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -2017607784, a);
        }
    }

    /* compiled from: app_invite_promotion_displayed */
    public class C27882 {
        final /* synthetic */ ThemeSelectorActivity f19583a;

        C27882(ThemeSelectorActivity themeSelectorActivity) {
            this.f19583a = themeSelectorActivity;
        }

        public final void m19782a(ImmutableList<NodesModel> immutableList) {
            ThemeSelectorActivity themeSelectorActivity = this.f19583a;
            EventsThemeSelectionPagerAdapterProvider eventsThemeSelectionPagerAdapterProvider = this.f19583a.f19586q;
            String str = this.f19583a.f19594y;
            String str2 = this.f19583a.f19595z;
            themeSelectorActivity.f19587r = new EventsThemeSelectionPagerAdapter(str, str2, Integer.valueOf(this.f19583a.f19584A), immutableList, (EventsThemeSelectionRecyclerViewWrapperProvider) eventsThemeSelectionPagerAdapterProvider.getOnDemandAssistedProviderForStaticDi(EventsThemeSelectionRecyclerViewWrapperProvider.class));
            this.f19583a.f19588s.b();
            this.f19583a.f19593x = this.f19583a.f19592w.inflate();
            this.f19583a.f19591v = (ViewPager) this.f19583a.f19593x.findViewById(2131561580);
            this.f19583a.f19591v.setAdapter(this.f19583a.f19587r);
            this.f19583a.f19589t = (TabbedViewPagerIndicator) this.f19583a.f19593x.findViewById(2131561579);
            this.f19583a.f19589t.setViewPager(this.f19583a.f19591v);
        }
    }

    private static <T extends Context> void m19789a(Class<T> cls, T t) {
        m19790a((Object) t, (Context) t);
    }

    public static void m19790a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ThemeSelectorActivity) obj).m19788a((ThemeCategoriesFetcherProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ThemeCategoriesFetcherProvider.class), (EventsThemeSelectionPagerAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventsThemeSelectionPagerAdapterProvider.class));
    }

    private void m19788a(ThemeCategoriesFetcherProvider themeCategoriesFetcherProvider, EventsThemeSelectionPagerAdapterProvider eventsThemeSelectionPagerAdapterProvider) {
        this.f19585p = themeCategoriesFetcherProvider;
        this.f19586q = eventsThemeSelectionPagerAdapterProvider;
    }

    protected final void m19801b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = ThemeSelectorActivity.class;
        m19790a((Object) this, (Context) this);
        setContentView(2130904175);
        Intent intent = getIntent();
        if (intent.hasExtra("extra_theme_selector_event_name")) {
            this.f19594y = intent.getStringExtra("extra_theme_selector_event_name");
        }
        if (intent.hasExtra("extra_theme_selector_event_description")) {
            this.f19595z = intent.getStringExtra("extra_theme_selector_event_description");
        }
        this.f19584A = intent.getIntExtra("extra_show_full_width_themes", 1);
        m19799i();
        this.f19588s = (LoadingIndicatorView) a(2131560537);
        this.f19592w = (ViewStub) a(2131561581);
        m19800j();
        ThemeCategoriesFetcher themeCategoriesFetcher = this.f19590u;
        themeCategoriesFetcher.f19576b.a("FetchThemeCategoriesForEvent", new C27851(themeCategoriesFetcher), new C27862(themeCategoriesFetcher));
        this.f19588s.a();
    }

    private void m19799i() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setShowDividers(true);
        fbTitleBar.setHasBackButton(false);
        fbTitleBar.a(new C27871(this));
    }

    private void m19800j() {
        ThemeCategoriesFetcherProvider themeCategoriesFetcherProvider = this.f19585p;
        this.f19590u = new ThemeCategoriesFetcher(GraphQLQueryExecutor.a(themeCategoriesFetcherProvider), TasksManager.b(themeCategoriesFetcherProvider), new C27882(this));
    }
}
