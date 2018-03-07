package com.facebook.localcontent.menus.structured;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.localcontent.analytics.LocalContentMenuLogger;
import com.facebook.localcontent.menus.FoodPhotosHScrollController;
import com.facebook.localcontent.menus.FoodPhotosHscrollView;
import com.facebook.localcontent.menus.structured.StructuredMenuLoader.C16511;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQL.AvailableMenusQueryString;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLModels.AvailableMenusQueryModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: duplicates */
public class StructuredMenuTabPagerFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    FoodPhotosHScrollController f15139a;
    private LinearLayout al;
    private TabbedViewPagerIndicator am;
    private ViewPager an;
    public String ao;
    @Inject
    public LocalContentMenuLogger f15140b;
    @Inject
    StructuredMenuLoader f15141c;
    @Inject
    StructuredMenuPagerAdapterProvider f15142d;
    @Inject
    ReactionThemedContextHelper f15143e;
    private StructuredMenuPagerAdapter f15144f;
    private EmptyListViewItem f15145g;
    public FoodPhotosHscrollView f15146h;
    public boolean f15147i;

    /* compiled from: duplicates */
    class C16521 implements OnPageChangeListener {
        final /* synthetic */ StructuredMenuTabPagerFragment f15138a;

        C16521(StructuredMenuTabPagerFragment structuredMenuTabPagerFragment) {
            this.f15138a = structuredMenuTabPagerFragment;
        }

        public final void m17579a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            StructuredMenuTabPagerFragment structuredMenuTabPagerFragment = this.f15138a;
            LocalContentMenuLogger localContentMenuLogger = structuredMenuTabPagerFragment.f15140b;
            HoneyClientEvent b = LocalContentMenuLogger.m17408b("structured_menu_viewer", "menu_viewer_menu_tab_tap", structuredMenuTabPagerFragment.ao);
            b.a("tab_position", i);
            localContentMenuLogger.f14941a.a(b);
        }

        public final void m17580b(int i) {
        }
    }

    public static void m17582a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StructuredMenuTabPagerFragment) obj).m17581a(FoodPhotosHScrollController.m17428b(fbInjector), LocalContentMenuLogger.m17409b(fbInjector), StructuredMenuLoader.m17575a(fbInjector), (StructuredMenuPagerAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(StructuredMenuPagerAdapterProvider.class), ReactionThemedContextHelper.m22628a(fbInjector));
    }

    public final void m17587c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = StructuredMenuTabPagerFragment.class;
        m17582a((Object) this, getContext());
        this.ao = (String) Preconditions.checkNotNull(this.s.getString("com.facebook.katana.profile.id"));
        this.f15147i = this.s.getBoolean("local_content_food_photos_header_enabled", true);
        if (bundle == null) {
            this.f15140b.f14941a.a(LocalContentMenuLogger.m17408b("structured_menu_viewer", "structured_menu_viewer_impression", this.ao));
        }
    }

    public final View m17583a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1287283048);
        View inflate = LayoutInflater.from(ReactionThemedContextHelper.m22627a(getContext(), null)).inflate(2130907286, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1831502531, a);
        return inflate;
    }

    public final void m17585a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f15145g = (EmptyListViewItem) e(2131567730);
        this.al = (LinearLayout) e(2131567731);
        this.f15146h = (FoodPhotosHscrollView) e(2131565637);
        this.am = (TabbedViewPagerIndicator) e(2131567732);
        this.an = (ViewPager) e(2131567729);
        StructuredMenuLoader structuredMenuLoader = this.f15141c;
        String str = this.ao;
        GraphQlQueryString availableMenusQueryString = new AvailableMenusQueryString();
        availableMenusQueryString.a("page_id", str);
        structuredMenuLoader.f15132b.a("task_key_load_categories" + str, structuredMenuLoader.f15131a.a(GraphQLRequest.a(availableMenusQueryString)), new C16511(structuredMenuLoader, this));
        if (this.f15147i) {
            this.f15139a.m17429a(this.f15146h, this.ao, am_());
        } else {
            this.f15146h.setVisibility(8);
        }
        this.f15145g.a(true);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 423126236);
        super.mi_();
        CharSequence string = this.s.getString("profile_name");
        if (StringUtil.a(string)) {
            String b = b(2131239096);
        } else {
            CharSequence charSequence = string;
        }
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(b);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1791804567, a);
    }

    public final String am_() {
        return "structured_menu_viewer";
    }

    public final void m17586a(@Nullable AvailableMenusQueryModel availableMenusQueryModel) {
        boolean z = true;
        if (availableMenusQueryModel == null || availableMenusQueryModel.a() == null || availableMenusQueryModel.a().a().isEmpty()) {
            ar();
            return;
        }
        this.f15145g.a(false);
        this.f15145g.setVisibility(8);
        if (availableMenusQueryModel.a().a().size() <= 1) {
            z = false;
        }
        if (z) {
            this.am.setVisibility(0);
        }
        this.an.setVisibility(0);
        StructuredMenuPagerAdapterProvider structuredMenuPagerAdapterProvider = this.f15142d;
        FragmentManager kO_ = kO_();
        ImmutableList a = availableMenusQueryModel.a().a();
        int dimensionPixelSize = this.f15147i ? z ? jW_().getDimensionPixelSize(2131432703) : jW_().getDimensionPixelSize(2131432702) : z ? jW_().getDimensionPixelSize(2131432704) : 0;
        this.f15144f = new StructuredMenuPagerAdapter((AbstractFbErrorReporter) FbErrorReporterImpl.a(structuredMenuPagerAdapterProvider), kO_, a, Integer.valueOf(dimensionPixelSize));
        this.an.setAdapter(this.f15144f);
        this.am.setViewPager(this.an);
        this.an.setOnPageChangeListener(new C16521(this));
    }

    private void m17581a(FoodPhotosHScrollController foodPhotosHScrollController, LocalContentMenuLogger localContentMenuLogger, StructuredMenuLoader structuredMenuLoader, StructuredMenuPagerAdapterProvider structuredMenuPagerAdapterProvider, ReactionThemedContextHelper reactionThemedContextHelper) {
        this.f15139a = foodPhotosHScrollController;
        this.f15140b = localContentMenuLogger;
        this.f15141c = structuredMenuLoader;
        this.f15142d = structuredMenuPagerAdapterProvider;
        this.f15143e = reactionThemedContextHelper;
    }

    public final void m17584a() {
        ar();
    }

    private void ar() {
        this.f15145g.setMessage(2131239095);
        this.f15145g.a(false);
    }
}
